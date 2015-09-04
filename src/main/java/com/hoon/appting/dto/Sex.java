package com.hoon.appting.dto;

/**
 * Created by hoon on 2015-08-12.
 */
public enum Sex {
    M("남자"),
    F("여자");

    private String sexType;

    Sex(String sexType) {
        this.sexType = sexType;
    }

    public String getSexType() {
        return sexType;
    }
}
