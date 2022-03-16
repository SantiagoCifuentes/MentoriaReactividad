import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Factura {
    // clase factura

    String descripcion;
    int importe;
    int codigo;
    int cantidad;
    LocalDate fecha;

    Factura(String descripcion, int importe) {
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public Factura(String descripcion, int importe, int codigo, int cantidad, LocalDate fecha) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Factura() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImporte() {
        return importe;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "descripcion='" + descripcion + '\'' +
                ", importe=" + importe +
                ", codigo=" + codigo +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                '}';
    }

    public static void main(String[] args) {
        // registros de la data
        Factura f = new Factura("ordenador", 1000, 20, 90, LocalDate.of(2020, 11, 30));
        Factura f2 = new Factura("movil", 300, 10, 70, LocalDate.of(2017, 5, 19));
        Factura f3 = new Factura("imporesora", 200, 30, 80, LocalDate.of(2016, 1, 12));
        Factura f4 = new Factura("imac", 1500, 20, 60, LocalDate.of(2010, 3, 25));

        // generar una lista
        List<Factura> lista = new ArrayList<Factura>();

        // agregar los productos de la factura
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);


        //filtro por codigo
        List<Factura> facturaPorCodigo = lista.stream()
                .filter(ele -> ele.getCodigo() == 20)
                .collect(Collectors.toList());

        // facturaPorCodigo.forEach(System.out::println);


        //*******************************************************************************************************************************

        //filtro por cantidad
        List<Factura> facturaPorCantidad = lista.stream()
                .filter(ele -> ele.getCantidad() < 80) //aquí se cambiaría la condición que se quiera validar, ya sea < o ==
                .collect(Collectors.toList());

        // System.out.println(facturaPorCantidad.isEmpty()?"No se encuentra el item":facturaPorCantidad);


        //*******************************************************************************************************************************

        //filtro por fecha

        List<Factura> facturaPorFechaIgual = lista.stream()
                //.filter(ele->ele.getFecha().equals(LocalDate.of(2020,11,30)))
                .filter(ele -> ele.getFecha().getYear() == 2020)//Otra forma
                .collect(Collectors.toList());

        System.out.println(facturaPorFechaIgual.isEmpty() ? "No se encuentra el item" : facturaPorFechaIgual);


        List<Factura> facturaPorFechaMenor = lista.stream()
                .filter(ele -> ele.getFecha().isBefore(LocalDate.of(2020, 11, 30)))
                //.filter(ele->ele.getFecha().getYear()<2020)//Otra forma de filtrar por año
                .collect(Collectors.toList());



        //System.out.println(facturaPorFechaMenor.isEmpty()?"No se encuentra el item":facturaPorFechaMenor);

        List<Factura> facturaPorFechaMayor = lista.stream()
                .filter(ele -> ele.getFecha().isAfter(LocalDate.of(2020, 11, 30)))
                //.filter(ele->ele.getFecha().getYear()>2020) //Otra forma de filtrar por año
                .collect(Collectors.toList());

        System.out.println(facturaPorFechaMayor.isEmpty() ? "No se encuentra el item" : facturaPorFechaMayor);


    }
}
