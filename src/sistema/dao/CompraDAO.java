package sistema.dao;

import sistema.excepciones.ExcepcionGeneral;
import sistema.modelos.Compra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

public class CompraDAO {

    private static final Logger LOG = Logger.getLogger(CompraDAO.class.getName());
    private static final String INSERTAR = "SELECT comprar(?,?,?,?,?)";
    private static final String CONSULTA = "SELECT id_compra, fecha, cliente, producto, cantidad, valor FROM consulta_compras(?,?)";
    
    public short comprar(short proveedor,
                        short producto,
                        short cantidad,
                        short valor,
                        short usuario) throws ExcepcionGeneral, IOException{
        short id_compra = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DAO.conectar();
            ps = con.prepareStatement(INSERTAR);
            ps.setShort(1, proveedor);
            ps.setShort(2, producto);
            ps.setShort(3, cantidad);
            ps.setShort(4, valor);
            ps.setShort(5, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                id_compra = rs.getShort(1);
            }
        } catch (SQLException sqle) {
            LOG.log(Level.SEVERE, "Error en CompraDAO.comprar: {0}", sqle.getMessage());
            throw new ExcepcionGeneral(sqle.getMessage());
        } finally {
            DAO.cerrar(con, ps, rs);
        }
        return id_compra;
    }
    
    public List<Compra> listar(short limite, short pagina) throws ExcepcionGeneral, IOException {
        List<Compra> listado = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DAO.conectar();
            ps = con.prepareStatement(CONSULTA);
            ps.setShort(1, limite);
            ps.setShort(2, pagina);
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(convertir(rs));
            }
        } catch (SQLException sqle) {
            LOG.log(Level.SEVERE, "Error CompraDAO.listar: {0}", sqle.getMessage());
            throw new ExcepcionGeneral(sqle.getMessage());
        } finally {
            DAO.cerrar(con, ps, rs);
        }
        return listado;
    }
    
    private Compra convertir (ResultSet rs) throws SQLException {
        Compra compra = new Compra();
        compra.id_compra = rs.getShort("id_compra");
        compra.fecha = Calendar.getInstance();
        compra.fecha.setTime(rs.getDate("fecha"));
        compra.cliente = rs.getString("cliente");
        compra.producto = rs.getString("producto");
        compra.cantidad = rs.getShort("cantidad");
        compra.valor = rs.getShort("valor");
        return compra;
    }
}