package me.sliman4.expressions;

import io.github.miniplaceholders.api.Expansion;

public interface Expression {
    void register(Expansion.Builder builder);
}
