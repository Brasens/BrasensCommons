package com.brasens.dtos.enums;

public enum IdentifierType {
    ACC_X("Acc X"),
    ACC_Y("Acc Y"),
    ACC_Z("Acc Z"),
    SPEED_X("Speed X"),
    SPEED_Y("Speed Y"),
    SPEED_Z("Speed Z");
    private final String legend;

    IdentifierType(String legend) {
        this.legend = legend;
    }

    public String getLegend() {
        return legend;
    }

    public static IdentifierType getIdentifierType(String period) {
        switch (period) {
            case "Acc X":
                return IdentifierType.ACC_X;
            case "Acc Y":
                return IdentifierType.ACC_Y;
            case "Acc Z":
                return IdentifierType.ACC_Z;
            case "Speed X":
                return IdentifierType.SPEED_X;
            case "Speed Y":
                return IdentifierType.SPEED_Y;
            case "Speed Z":
                return IdentifierType.SPEED_Z;
            default:
                throw new IllegalArgumentException("IdentifierType desconhecido: " + period);
        }
    }
}
