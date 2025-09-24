package Practica5Builder.Models;

public class CuentaBuilder {
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private String titular;

    public CuentaBuilder setNumeroCuenta(String numeroCuenta){
        this.numeroCuenta = numeroCuenta;
        return this;
    }

    public CuentaBuilder setPin(String pin){
        this.pin = pin;
        return this;
    }

    public CuentaBuilder setSaldo(double saldo){
        this.saldo = saldo;
        return this;
    }

    public CuentaBuilder setTitular(String titular){
        this.titular = titular;
        return this;
    }

    public Cuenta build(){
        if (numeroCuenta == null || pin == null || titular == null){
            throw new IllegalStateException("Numero de cuenta, pin o titular son obligatorios");
        }
        return new Cuenta(numeroCuenta, pin, saldo, titular);
    }
}