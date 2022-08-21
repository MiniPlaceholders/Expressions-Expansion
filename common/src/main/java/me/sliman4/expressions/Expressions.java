package me.sliman4.expressions;

import me.dreamerzero.miniplaceholders.api.Expansion;
import me.sliman4.expressions.expr.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Expressions {
    public static void initialize(File dataFolder, InputStream configYml) {
        Configuration config;
        try {
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            File configFile = new File(dataFolder, "config.yml");
            if (!configFile.exists()) {
                Files.copy(configYml, configFile.toPath());
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
            config = yaml.loadAs(Files.newInputStream(configFile.toPath()), Configuration.class);
        } catch (IOException exception) {
            exception.printStackTrace();
            return;
        }

        registerPlaceholders(config);
    }

    public static void registerPlaceholders(Configuration config) {
        Expansion.Builder builder = Expansion.builder("expr");
        List<Expression> expressions = Arrays.asList(
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
                new ExprRandom(),
                new ExprRound(),
                new ExprSub(),
                new ExprSubstring(),
                new ExprUser(config)
        );
        for(Expression expression : expressions) {
            expression.register(builder);
        }
        builder
                .build()
                .register();
    }
}
