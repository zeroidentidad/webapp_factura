package sistema.modelos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Compra {
    public short id_compra;
    public Calendar fecha;
    public String cliente;
    public String producto;
    public short cantidad;
    public short valor;
    public Usuario usuario;
    
    public String getFecha() {
        String fechaFormat;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fechaFormat = sdf.format(fecha.getTime());
        return fechaFormat;
    }
}