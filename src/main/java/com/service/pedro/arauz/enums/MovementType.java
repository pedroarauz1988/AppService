package com.service.pedro.arauz.enums;

public enum MovementType {

    RETIRO("Retiro"), DEPOSITO("Deposito");

    private String movementType;

    MovementType(String movementType){
        this.movementType = movementType;
    }

    @Override
    public String toString() {
        return movementType;
    }
}
