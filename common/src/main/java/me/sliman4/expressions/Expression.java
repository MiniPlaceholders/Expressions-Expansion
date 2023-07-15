package me.sliman4.expressions;

import io.github.miniplaceholders.api.Expansion;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

import java.util.function.BiFunction;

public interface Expression extends BiFunction<ArgumentQueue, Context, Tag> {
    void register(final Expansion.Builder builder);
}
