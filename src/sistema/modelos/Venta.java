package sistema.modelos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Venta {

    public short id_venta;
    public Calendar fecha;
    public String cliente;
    public String producto;
    public short cantidad;
    public short valor;
    public String usuario;

    public String getFecha() {
        String fechaFormat;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fechaFormat = sdf.format(fecha.getTime());
        return fechaFormat;
    }

}