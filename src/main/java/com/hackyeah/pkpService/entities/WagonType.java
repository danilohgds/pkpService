package com.hackyeah.pkpService.entities;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum WagonType {

    FIRST_CLASS(1),
    SECOND_CLASS(2),
    SILENT(0);

    private final int typeId;

    WagonType(int typeId) {
        this.typeId = typeId;
    }

    public static WagonType byTypeId(int typeId) {
        return Arrays.asList(values()).stream().filter(wagonType -> wagonType.typeId == typeId).findFirst().orElseThrow(() -> new IllegalArgumentException());
    }
}
