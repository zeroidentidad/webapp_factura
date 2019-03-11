package sistema.excepciones;

public class ExcepcionGeneral extends RuntimeException{
    
    public ExcepcionGeneral(String msg) {
        super(msg);
    }
    
    public ExcepcionGeneral() {
        this("Error: sin tipo de mensaje");
    }
}
