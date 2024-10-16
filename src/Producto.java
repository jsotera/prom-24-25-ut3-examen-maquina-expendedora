public class Producto {

    private String nombre;
    private int codigo;
    private double precio;
    private int cantidad;

    public Producto(String nombre, int codigo, double precio, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public boolean reducirCantidad(){
        if(this.cantidad > 0){
            this.cantidad--;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String msg = this.codigo+": Producto: " + this.nombre +
                " | Precio: " + this.precio + "$" +
                " | Stock: " + this.cantidad;
        return msg;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }
}
