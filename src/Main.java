import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String pass = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, pass);

            //consultas

            //insert
            /*
            String sql = "INSERT INTO proveedores (nombre,direccion,localidad,provincia) VALUES (?,?,?,?);";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1,"Taller Juan");
            pst.setString(2,"Calle Romil 34");
            pst.setString(3,"Vigo");
            pst.setString(4,"Pontevedra");
            */

            //Delete https://www.cuantarazon.com/1302419/la-historia-esta-condenada-a-repetirse
            /*
            String sqlDelete="DELETE FROM proveedores WHERE id=?";
            PreparedStatement pst = conexion.prepareStatement(sqlDelete);
            pst.setInt(1,3);
            */

            //Update
            /*
            String sqlUpdate = "UPDATE proveedores SET nombre=?,direccion=? WHERE id=?";
            PreparedStatement pst = conexion.prepareStatement(sqlUpdate);
            pst.setString(1,"Paco");
            pst.setString(2,"Camelias");
            pst.setInt(3,1);
            */

            //necesario para ejecutar las consultas anteriores
            //pst.executeUpdate();

            //Select
            String sqlSelect = "SELECT * FROM proveedores";
            Statement stm = conexion.createStatement();

            ResultSet respuesta = stm.executeQuery(sqlSelect);

            while (respuesta.next()){
                System.out.println(respuesta.getInt(1) + " " + respuesta.getString("nombre"));
            }

            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}