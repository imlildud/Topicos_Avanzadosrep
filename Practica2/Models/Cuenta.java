package Practica2.Models;

public class Cuenta {
    private final String numeroCuenta;
    private final String pin;
    private double saldo;
    private final String titular;
    private String destino;

    public Cuenta(String numeroCuenta, String pin, double saldoInicial, String titular){
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldoInicial;
        this.titular = titular;
    }

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean validarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo){
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    public void depositar(double cantidad){
        if (cantidad > 0){
            saldo += cantidad;
        }
    }
    public void transferir(double cantidad, Cuenta destino){
        ;
    }
}