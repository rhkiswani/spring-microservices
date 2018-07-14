package com.rhkiswani.backbasetask.core.util;

import java.util.Map;

public final class MapsUtil {

    private MapsUtil() {

    }

    public static Double getAsDoubleOrDefault(Map map, String key, Double defaultVal) {
        if (map.get(key) == null) {
            return null;
        }
        try {
            return Double.parseDouble(String.valueOf(map.get(key)));
        } catch (Exception e) {
            return defaultVal != null ? defaultVal : 0;
        }
    }

    public static Integer getAsIntegerOrDefault(Map map, String key, Integer defaultVal) {
        return getAsDoubleOrDefault(map, key, Double.valueOf(defaultVal)).intValue();
    }
}
