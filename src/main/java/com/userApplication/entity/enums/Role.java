package com.userApplication.entity.enums;

public enum Role {
    ADMIN(1), VENDOR(2), CUSTOMER(3);

    public int getValue() {
        return value;
    }

    private final int value;

    Role(int value) {
        this.value = value;
    }


    public static Role getByValue(int value) {
        for (Role role : Role.values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role ID: " + value);
    }
}
