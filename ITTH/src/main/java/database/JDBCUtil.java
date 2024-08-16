package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
   public static Connection getConnection() {
	   Connection c = null;
	try {
		//1 đăng ký 
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2 tạo các thành phần
		
		String url = "jdbc:mySQL://localhost:3306/knvb";
		String nameuse = "root";
		String passwork = "";
		//3 tạo kết nối 
		c=DriverManager.getConnection(url, nameuse, passwork);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	   
	   return c;
	   
   }
 
 public static void closeconnection(Connection c) {
	 if(c!=null) {
		 try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
}
