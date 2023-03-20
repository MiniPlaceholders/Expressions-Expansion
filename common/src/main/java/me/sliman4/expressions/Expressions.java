package me.sliman4.expressions;

import io.github.miniplaceholders.api.Expansion;
import me.sliman4.expressions.expr.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Expressions {
    public static void initialize(Path dataFolder, InputStream configYml, Platform platform) {
        try (configYml) {
            if (Files.notExists(dataFolder)) {
                Files.createDirectory(dataFolder);
            }
            Path configFile = dataFolder.resolve("config.yml");
            if (Files.notExists(configFile)) {
                Files.copy(configYml, configFile);
            }
            Yaml yaml = new Yaml(new Constructor() {
                @Override
                protected Class<?> getClassForName(String name) throws ClassNotFoundException {
                    if (name.equals(Configuration.class.getName())) {
                        return Configuration.class;
                    }
                    return super.getClassForName(name);
                }
            });
            Configuration config = yaml.loadAs(Files.newInputStream(configFile), Configuration.class);
            registerPlaceholders(config, platform);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void registerPlaceholders(Configuration config, Platform platform) {
        Expansion.Builder builder = Expansion.builder("expr");
        List.of(
                new ExprAdd(),
                new ExprCeil(),
                new ExprConcat(),
                new ExprDiv(),
                new ExprFloor(),
                new ExprFormat(),
                new ExprIf(),
                new ExprLength(),
                new ExprMax(),
                new ExprMin(),
                new ExprMod(),
                new ExprMul(),
                new ExprNeg(),
                new ExprPlayer(platform),
                new ExprRandom(),
                new ExprRound(),
                new ExprSub(),
                new ExprSubstring(),
                new ExprUser(config)
        ).forEach(expression -> expression.register(builder));
        builder
                .build()
                .register();
    }
}
