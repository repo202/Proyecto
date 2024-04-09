package proyecto;

/**
 *
 * @author Andres Felipe
 */
public interface Transacciones {
    public abstract void Retirar() throws Exception;
    public abstract void Consignar();
    public abstract void Consultar();
    
}
