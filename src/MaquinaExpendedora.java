import java.util.Scanner;

public class MaquinaExpendedora {

    private Producto producto1, producto2, producto3;
    private double saldo;

    public MaquinaExpendedora(Producto producto1, Producto producto2, Producto producto3) {
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
        this.saldo = 0;
    }

    public void insertarDinero(double saldo){
        System.out.println("Has insertado "+saldo+"$.");
        System.out.println();
        this.saldo = this.saldo + saldo;
    }

    public int solicitarCodigoProducto(){
        System.out.print("Introduce el codigo del producto deseado: ");
        Scanner teclado = new Scanner(System.in);
        int codigo = teclado.nextInt();
        return codigo;
    }

    public void comprarProducto(int codigoProducto){
        Producto productoElegido;
        switch (codigoProducto) {
            case 1:
                productoElegido = this.producto1;
                break;
            case 2:
                productoElegido = this.producto2;
                break;
            case 3:
                productoElegido = this.producto3;
                break;
            case 9:
                productoElegido = obtenerProductoAleatorio();
                break;
            case 0:
                mostrarSaldo();
                // No queremos que haga nada mas, detenemos la ejecucion del metodo
                return;
            default:
                System.out.println("No has elegido un codigo de producto valido.");
                System.out.println();
                // No queremos que haga nada mas, detenemos la ejecucion del metodo
                return;
        }
        if(this.saldo >= productoElegido.getPrecio()){
            System.out.println("Has comprado "+productoElegido.getNombre()+".");
            System.out.println();
            this.saldo = this.saldo - productoElegido.getPrecio();
        } else {
            System.out.println("No tienes suficiente saldo para comprar el producto: "+productoElegido.getNombre()+" (cuesta "+productoElegido.getPrecio()+"$ y dispones de "+this.saldo+"$)");
            System.out.println();
        }

    }

    private Producto obtenerProductoAleatorio() {
        Producto productoAleatorio;
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                productoAleatorio = this.producto1;
                break;
            case 1:
                productoAleatorio = this.producto2;
                break;
            case 2:
                productoAleatorio = this.producto3;
                break;
            default:
                productoAleatorio = this.producto3;
        }
        return productoAleatorio;
    }

    public void mostrarMenu(){
        System.out.println(toString());
        System.out.println();
        System.out.println("=== MENÚ DE PRODUCTOS ===");
        System.out.println("Elige entre los distintos productos disponibles:");
        System.out.println(this.producto1);
        System.out.println(this.producto2);
        System.out.println(this.producto3);
        System.out.println("9: Producto: Aleatorio | Precio: el correspondiente al producto | Stock: ?");
        System.out.println("0: Devuelve el saldo restante");
        System.out.println();
    }

    public void mostrarSaldo(){
        System.out.println("Devolviendo "+this.saldo+"$ de saldo restante, que tengas un buen dia.");
        this.saldo = 0;
    }

    public String toString(){
        return "Saldo actual: "+this.saldo+"$.";
    }
}
