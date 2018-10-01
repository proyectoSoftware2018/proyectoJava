
package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;




public class Nota {
   public String codigo,nombre,apellido;
   int noral,nprac,ntrab,ncuad,exabi;
   double proce,promedio;
   private Conexion conn;
   private PreparedStatement ps;

    public Nota(String codigo, String nombre, String apellido, int noral, int nprac, int ntrab, int ncuad, int exabi, double proce, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.noral = noral;
        this.nprac = nprac;
        this.ntrab = ntrab;
        this.ncuad = ncuad;
        this.exabi = exabi;
        this.proce = proce;
        this.promedio = promedio;
        conn = new Conexion();
        ps = null;
    }
    
    
    public boolean insert() {
        
        try {
            ps = conn.getConnection().prepareCall("call InsertarNota(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setInt(4, noral);
            ps.setInt(5, nprac);
            ps.setInt(6, ntrab);
            ps.setInt(7, ncuad);
            ps.setInt(8, exabi);
            ps.setDouble(9, proce);
            ps.setDouble(10, promedio);
            
            ps.executeUpdate();
            return true;
           
        } catch (Exception e) {
             return false;
        }

       
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNoral() {
        return noral;
    }

    public void setNoral(int noral) {
        this.noral = noral;
    }

    public int getNprac() {
        return nprac;
    }

    public void setNprac(int nprac) {
        this.nprac = nprac;
    }

    public int getNtrab() {
        return ntrab;
    }

    public void setNtrab(int ntrab) {
        this.ntrab = ntrab;
    }

    public int getNcuad() {
        return ncuad;
    }

    public void setNcuad(int ncuad) {
        this.ncuad = ncuad;
    }

    public int getExabi() {
        return exabi;
    }

    public void setExabi(int exabi) {
        this.exabi = exabi;
    }

    public double getProce() {
        double p;
        proce=(noral+nprac+ntrab+ncuad)/4;
        p=Math.round(proce);
        return p;
    }

    public void setProce(double proce) {
        this.proce = proce;
    }

    public double getPromedio() {
        double p;
        promedio=(proce+exabi)/2;
        p=Math.round(promedio);
        return p;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
   
    
   
}
