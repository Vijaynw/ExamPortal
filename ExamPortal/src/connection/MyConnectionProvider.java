package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider implements MyProvider {

	static Connection con = null;
	public static Connection getcon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connurl, uname, pwd);
		}
		catch(Exception e) {
			System.out.println("Error :" +e);
		}
		return con;
	}
}
