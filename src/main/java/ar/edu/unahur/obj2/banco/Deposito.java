package ar.edu.unahur.obj2.banco;

public class Deposito implements IOperacion{

    @Override
    public String descripcion() {
        return "Depósito";
    }

    @Override
    public String mensajeCliente(Double unMonto) {
        return "Se acreditaron $" +unMonto;
    }

}
