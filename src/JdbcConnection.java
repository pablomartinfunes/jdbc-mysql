import java.sql.*;

public class JdbcConnection {

	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;

	public JdbcConnection() {

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String passwd = "student";

		try {
			this.cn = DriverManager.getConnection(dbUrl, user, passwd);
			this.st = this.cn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String sql){
		
		try {
			this.rs =  this.st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
	
}
