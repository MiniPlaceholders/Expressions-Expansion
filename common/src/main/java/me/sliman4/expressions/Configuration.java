package me.sliman4.expressions;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Map<String, String> userExpressions = new HashMap<>();

    public Map<String, String> getUserExpressions() {
        return userExpressions;
    }

    public void setUserExpressions(Map<String, String> userExpressions) {
        this.userExpressions = userExpressions;
    }
}
