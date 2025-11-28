
import com.mycompany.videotutoria9_ejercicios.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author javie
 */
public class TestCalculadora {
    private Calculadora c;
    
    @BeforeEach
    void Inicio() {
        c = new Calculadora();
    }

    @Test
    public void TestSuma() {
        assertEquals(5, c.sumar(3, 2), "Suma Test Failed");
    }
    
    @Test
    public void TestResta() {
        assertEquals(2, c.restar(10, 8), "Resta Test Failed");
    }
    
    @Test
    public void TestMultiplica() {
        assertEquals(10, c.multiplicar(2, 5), "Multiplicación Test Failed");
    }
    
    @Test
    public void TestDivide() {
        assertEquals(50, c.dividir(100, 2), "División Test Failed");
    }
}
