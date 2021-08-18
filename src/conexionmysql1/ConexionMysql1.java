/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql1;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class ConexionMysql1 {

    private static int resultadodeConsulta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion1 con = new Conexion1();
      
        String usuario;
        String clave;
        int estado;
        String correo;
        
       usuario="Tony";
       clave="12399912";
       estado=5;
       correo="avs@yavirac";        
        resultadodeConsulta=0;
        try {
            //conexion a la base de datos Mysql
            con.conectarMySQL();
            UsuarioDao usDao= new UsuarioDao();
            resultadodeConsulta=usDao.Insertar(usuario, clave, estado, correo);
            if (resultadodeConsulta == 1){
                System.out.println("Usuario Insertado correctamente....");
                usDao.Actualizar(4, usuario, clave, estado, correo);
                usDao.Eliminar(1);
                usDao.ConsultarUsuario();
               

            }else
            {
                System.err.println("No se pudo insertar el usuario...");
                return;
            }
            }catch (Exception e){
            System.err.println("Error de consulta " +e.getMessage());
            
        }
    }
}
