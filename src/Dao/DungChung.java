package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Da xac dinh he quan tri csdl");
			String dburl = "jdbc:sqlserver://DESKTOP-RLM4EQ8\\SQLEXPRESS:1433;databaseName=QlSach;user=sa; password=123";
			cn = DriverManager.getConnection(dburl);
			System.out.println("Da ket noi");
		} catch (Exception tt) {
			System.out.println(tt.getMessage());
			tt.printStackTrace();
		}
	}
}
