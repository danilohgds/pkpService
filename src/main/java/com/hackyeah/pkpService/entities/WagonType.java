package com.hackyeah.pkpService.entities;

import lombok.Getter;

@Getter
public enum WagonType {

    FIRST_CLASS("1ST CLASS"),
    SECOND_CLASS("2ND Class"),
    SILENT("SILENT");

    private final String label;

    WagonType(String label) {
        this.label = label;
    }
}
