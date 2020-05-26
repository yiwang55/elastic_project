package com.imooc.enumeration;

public enum Level{
    CITY("city"),
    REGION("region");

    private String value;

    Level(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Level of(String value){
        for (Level level : Level.values()) {
            if (level.getValue().equals(value)){
                return level;
            }
        }
        throw new IllegalArgumentException();
    }

}