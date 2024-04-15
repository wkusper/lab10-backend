package edu.iu.habahram.ducksservice.model;

public enum DuckType {
    MALLARD, REDHEAD, RUBBER_DUCK, DECOY_DUCK;

    @Override
    public String toString() {
        switch (this) {
            case MALLARD: return "Mallard";
            case REDHEAD: return "Redhead";
            case DECOY_DUCK: return "Decoy";
            case RUBBER_DUCK: return "Rubber";
            default: return "unspecified";
        }
    }


    public static DuckType toEnum(String value) {
        switch (value.toLowerCase()) {
            case "mallard": return DuckType.MALLARD;
            case "redhead": return DuckType.REDHEAD;
            case "decoy": return DuckType.DECOY_DUCK;
            case "rubber": return DuckType.RUBBER_DUCK;
            default: return null;
        }
    }
}
