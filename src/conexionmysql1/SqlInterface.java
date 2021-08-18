/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql1;

/**
 *
 * @author Usuario
 */
public interface SqlInterface {
    public int Insertar(String usuario,String clave,int estado,String correo);
    public int Actualizar(int Codigo,String usuario,String clave,int estado,String correo );
    public int Eliminar (int Codigo);
    public void ConsultarUsuario();
}
