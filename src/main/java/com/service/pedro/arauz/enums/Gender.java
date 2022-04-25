package com.service.pedro.arauz.enums;

public enum Gender {

    MASCULINO("Masculino"), FEMENINO("Femenino");

    private String gender;

    Gender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
