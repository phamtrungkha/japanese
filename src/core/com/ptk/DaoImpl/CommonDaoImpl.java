package core.com.ptk.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import core.com.ptk.Dao.CommonDao;

public class CommonDaoImpl implements CommonDao{

	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/japanese?useUnicode=true&characterEncoding=UTF-8";
    static final String USER = "root";
    static final String PASS = "";
    
	public Connection getConnection() {
		
        Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
