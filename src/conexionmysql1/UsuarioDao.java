/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioDao implements SqlInterface {
Conexion1 con=new Conexion1();
    @Override
    public int Insertar(String usuario,String clave,int estado,String correo) {
        int resultado = 0;
        try {
            //Declaracion de conexion Mysql
            Statement s = con.conectarMySQL().createStatement();
            //REsultado de consulta a la BD
            String sql;
            sql = "";
            sql="INSERT INTO project (usuario,clave,estado,correo) VALUES ('"+usuario+"','"+clave+"','"+estado+"','"+correo+"')";
            //ResultSet rs = s.executeQuery(sql);
            resultado = s.executeUpdate(sql);
            
            con.CerrarConexion();
           
        } catch (SQLException e) {
        
    }
        return resultado;
    }


    public int Actualizar(int Codigo,String usuario,String clave,int estado,String correo) {
        int resultado = 0;
        try {
            //Declaracion de conexion Mysql
            Statement s = con.conectarMySQL().createStatement();
            //REsultado de consulta a la BD
            String sql= "";
            sql="UPDATE project set usuario='"+usuario+"',clave='"+clave+"',estado='"+estado+"',Correo='"+correo+"'where codUsuario="+Codigo;
            //ResultSet rs = s.executeQuery(sql);
            resultado = s.executeUpdate(sql);
            
            con.CerrarConexion();
           
        } catch (SQLException e) {
            System.err.println("Problemas al actualizar Usuario");
    }
        return resultado;
    }

     public int Eliminar(int Codigo) {
        int resultado = 0;
        try {
            //Declaracion de conexion Mysql
            Statement s = con.conectarMySQL().createStatement();
            //REsultado de consulta a la BD
            String sql= "";
            sql="delete from project where codUsuario="+Codigo;
            //ResultSet rs = s.executeQuery(sql);
            resultado = s.executeUpdate(sql);
            
            con.CerrarConexion();
           
        } catch (SQLException e) {
            System.err.println("Problemas al actualizar Usuario");
    }
        return resultado;
    }
   

    @Override
    public void ConsultarUsuario() {
        try {
            Statement s = con.conectarMySQL().createStatement();
            //REsultado de consulta a la BD
            ResultSet rs = s.executeQuery("select * from project");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "   " + rs.getString(2) +  "    " + rs.getString(3) +  "   " + rs.getString(4) +  "    " + rs.getString(5));
            }
           // System.out.println("Conexion Correcta a la base de datos Mysql");
            con.conectarMySQL().close();
        }catch (Exception e){
            System.err.println("Error de consulta " +e.getMessage());
        }
        
    }


 
}
    

