package sistema.dao;

import sistema.excepciones.ExcepcionGeneral;
import sistema.modelos.Producto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;

public class ProductoDAO {

    private static final Logger LOG = Logger.getLogger(ProductoDAO.class.getName());
    private static final String CONSULTA = "SELECT id_producto, nombre, cantidad, precio FROM consulta_productos()";

    public List<Producto> listar() throws IOException, ExcepcionGeneral {
        List<Producto> listado = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DAO.conectar();
            ps = con.prepareStatement(CONSULTA);
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(convertir(rs));
            }
        } catch (SQLException sqle) {
            LOG.log(Level.SEVERE, "Error ProductoDAO: {0}", sqle.getMessage());
            throw new ExcepcionGeneral(sqle.getMessage());
        } finally {
            DAO.cerrar(con, ps, rs);
        }
        return listado;
    }
    
    private Producto convertir(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.id_producto = rs.getShort("id_producto");
        producto.nombre = rs.getString("nombre");
        producto.cantidad = rs.getShort("cantidad");
        producto.precio = rs.getShort("precio");
        return producto;
    }
}
