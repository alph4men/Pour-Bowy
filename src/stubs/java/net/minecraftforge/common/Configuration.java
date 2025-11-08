package net.minecraftforge.common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private final Map<String, Property> properties = new HashMap<String, Property>();
    private boolean changed;

    public Configuration(File file) {
    }

    public void load() {
    }

    public boolean hasChanged() {
        return changed;
    }

    public void save() {
        changed = false;
    }

    public Property get(String category, String key, int defaultValue) {
        String compositeKey = category + "." + key;
        Property property = properties.get(compositeKey);
        if (property == null) {
            property = new Property(defaultValue);
            properties.put(compositeKey, property);
        }
        return property;
    }

    public static class Property {
        private int value;

        public Property(int value) {
            this.value = value;
        }

        public int getInt(int defaultValue) {
            return value;
        }

        public void set(int newValue) {
            this.value = newValue;
        }
    }
}
