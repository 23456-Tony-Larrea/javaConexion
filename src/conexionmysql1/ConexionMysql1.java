/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
        int codigo;
        
         String op="";//se crea una variable que recibira la opcion 
 
        do{
            op=JOptionPane.showInputDialog("a. Insertar\n b. Actualizar\n c. Eliminar\n d. Observar\n e. Salir\n"); 
            if(op.equals("a")){//si se elige la opcion a se muestra el siguiente mensaje
                JOptionPane.showMessageDialog(null, "esto es insertar.");
                usuario=JOptionPane.showInputDialog("null","ingresa el usuario");
                clave=JOptionPane.showInputDialog("null","ingresa la clave");     
                estado = Integer.parseInt(JOptionPane.showInputDialog("null", "ingresa el estado"));
                correo=JOptionPane.showInputDialog("null","ingresa el correo");
          try {
           //conexion a la base de datos Mysql
            con.conectarMySQL();
            UsuarioDao usDao= new UsuarioDao();
            resultadodeConsulta=usDao.Insertar(usuario, clave, estado, correo);
            if (resultadodeConsulta == 1){
                System.out.println("Usuario Insertado correctamente....\n");
               
            }else
            {
                System.err.println("No se pudo insertar el usuario...\n");
                return;
            }
            }catch (Exception e){
            System.err.println("Error de consulta " +e.getMessage());
            
        }
            }
            else if(op.equals("b")){//si se elige la opcion b se muestra el siguiente mensaje
                JOptionPane.showMessageDialog(null, "esto es actualizar.");
                codigo = Integer.parseInt(JOptionPane.showInputDialog("null", "ingresa el ID para actualizar"));
                 usuario=JOptionPane.showInputDialog("null","ingresa el usuario a actualizar");
                clave=JOptionPane.showInputDialog("null","ingresa la clave a acualizar");     
                estado = Integer.parseInt(JOptionPane.showInputDialog("null", "ingresa el estado a acualizar"));
                correo=JOptionPane.showInputDialog("null","ingresa el correo a acualizar");
                      try {
           //conexion a la base de datos Mysql
            con.conectarMySQL();
            UsuarioDao usDao= new UsuarioDao();
            resultadodeConsulta=usDao.Actualizar(codigo, usuario, clave, estado, correo);
            if (resultadodeConsulta == 1){
                System.out.println("Usuario actualizado correctamente....\n");
               
            }else
            {
                System.err.println("No se pudo actualizar el usuario...\n");
                return;
            }
            }catch (Exception e){
            System.err.println("Error de consulta " +e.getMessage());
            
        }  
                
            }
            else if(op.equals("c")){//si se elige la opcion c se muestra el siguiente mensaje
                JOptionPane.showMessageDialog(null, "Esto es Eliminar");
                        
                codigo = Integer.parseInt(JOptionPane.showInputDialog("null", "ingresa el ID para actualizar"));
                      try {
           //conexion a la base de datos Mysql
            con.conectarMySQL();
            UsuarioDao usDao= new UsuarioDao();
            resultadodeConsulta=usDao.Eliminar(codigo);
            if (resultadodeConsulta == 1){
                System.out.println("Usuario eliminado correctamente....\n");
               
            }else
            {
                System.err.println("No se pudo eliminado el usuario...\n");
                return;
            }
            }catch (Exception e){
            System.err.println("Error de consulta " +e.getMessage());
            
        }
            }
             else if(op.equals("d")){//si se elige la opcion d se cierra o finaliza la aplicacion
                try{
           //conexion a la base de datos Mysql
            con.conectarMySQL();
            UsuarioDao usDao= new UsuarioDao();
            usDao.ConsultarUsuario();
                
                }catch(Exception e){
                            System.err.println("Error de consulta " +e.getMessage());

                }
            }
           
            else if(op.equals("e")){//si se elige la opcion d se cierra o finaliza la aplicacion
                System.exit(0);//comando para cerrar las aplicaciones
            }
            else{//si la opcion ingresada es diferente a las mostradas se muestra el siguiente mensaje
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
            }
        }while(!op.equals("e"));//finaliza el ciclo con la condicional que hay dentro del whil
          
//       try {
//           //conexion a la base de datos Mysql
//            con.conectarMySQL();
//            UsuarioDao usDao= new UsuarioDao();
//            resultadodeConsulta=usDao.Insertar(usuario, clave, estado, correo);
//            if (resultadodeConsulta == 1){
//                System.out.println("Usuario Insertado correctamente....\n");
//               
//            }else
//            {
//                System.err.println("No se pudo insertar el usuario...\n");
//                return;
//            }
//            }catch (Exception e){
//            System.err.println("Error de consulta " +e.getMessage());
//            
//        }
       
        
    }

}
