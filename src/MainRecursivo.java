public class MainRecursivo {

    public static void main(String[] args) {

        Producto agua = new Producto("Agua", 1, 1.5, 10);
        Producto refresco = new Producto("Refresco", 2, 2.0, 5);
        Producto chocolate = new Producto("Chocolate", 3, 1.2, 7);

        MaquinaExpendedora maquina = new MaquinaExpendedora(agua, refresco, chocolate);

        maquina.insertarDinero(3.0);

        compraRecursiva(maquina);

    }

    public static void compraRecursiva(MaquinaExpendedora maquina){

        maquina.mostrarMenu();

        int codigoProducto = maquina.solicitarCodigoProducto();
        maquina.comprarProducto(codigoProducto);

        if(codigoProducto!=0){
            compraRecursiva(maquina);
        }

    }
}