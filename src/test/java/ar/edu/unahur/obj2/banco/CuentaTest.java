package ar.edu.unahur.obj2.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.banco.commands.DepositarComando;
import ar.edu.unahur.obj2.banco.commands.IComando;
import ar.edu.unahur.obj2.banco.commands.Invoker;
import ar.edu.unahur.obj2.banco.commands.RetirarComando;

public class CuentaTest {
    @Test 
    void dadaUnaCuentaCon10000Depositar5000SuSaldoDebeSer15000(){
        Cuenta cuenta =new Cuenta(1234,10000.00);
        IComando deposito = new DepositarComando(cuenta, 5000.00);
        deposito.ejecutar();
        assertEquals(15000.00, cuenta.getSaldo());
    }
    @Test
    void cuentaCon1000RealizaDeposito2000Extraccion1000YDeposito3000Extraccion2000(){
        Cuenta cuenta2 = new Cuenta(1235, 1000.0);
        IComando deposito1=new DepositarComando(cuenta2, 2000.0);
        IComando extraccion1= new RetirarComando(cuenta2, 1000.0);
        IComando deposito2=new DepositarComando(cuenta2, 3000.0);
        IComando extraccion2= new RetirarComando(cuenta2, 2000.0);
        Invoker lote = new Invoker();
        lote.agregarComando(deposito1);
        lote.agregarComando(extraccion1);
        lote.agregarComando(deposito2);
        lote.agregarComando(extraccion2);
        lote.ejecutarLote();
        assertEquals(3000, cuenta2.getSaldo());
    }
}
