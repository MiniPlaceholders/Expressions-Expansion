package me.sliman4.expressions;

import me.dreamerzero.miniplaceholders.api.Expansion;

public interface Expression {
    void register(Expansion.Builder builder);
}
