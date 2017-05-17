package io.oasp.logistic.ridesharing.requestmanagement.common.api.datatype;

public enum LuggageSize {

    SMALL,

    MEDIUM,
    
    LARGE;

    public boolean isSmall() {

        return equals(SMALL);
    }

    public boolean isMedium() {

        return equals(MEDIUM);
    }

    /**
     * @return {@code true}, if this value equals {@link LuggageSize#LARGE}. {@code false} otherwise.
     */
    public boolean isLarge() {

        return equals(LARGE);
    }
}
