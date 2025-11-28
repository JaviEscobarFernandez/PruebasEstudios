/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videotutoria9_ejercicios;

/**
 *
 * @author javie
 */
public class Calculadora {
    
    public int sumar(int x, int y) { return x + y; }
    public int restar(int x, int y) { return x - y; }
    public int multiplicar(int x, int y) { return x * y; }
    public int dividir(int x, int y) {
        if (y == 0)
            return 0;
        return x / y;
    }
}
