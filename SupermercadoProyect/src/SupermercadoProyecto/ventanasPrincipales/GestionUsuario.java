/*package SupermercadoProyecto.ventanasPrincipales;
import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

//import ConexionBD.MySQLConexion;

public class GestionUsuario {
	public Usuario obtenerUsuario(Usuario usu) {
		Usuario usuario = null;
		
		Connection conect = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			conect = MySQLConexion.getConexion();
			
			String sql="SELECT * FROM USUARIO WHERE NOMBREUSUARIO=? AND CONTRASEÑA =?";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1,usu.getNombreUsuario());
			pst.setString(2, usu.getcontrasena());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		}catch(Exception e) {
			System.out.println("Error al obtener el usuario");
		}
		
		return usuario;
	}
}
*/