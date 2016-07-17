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

		System.out.println("Conectado a la base demo.");
	}

	public ResultSet query(String sql) {

		try {
			this.rs = this.st.executeQuery(sql);

			System.out.println("Se ejecuto el query");

			while (rs.next()) {
				System.out
						.println("Nombre: " + rs.getString("first_name") + ", Apellido: " + rs.getString("last_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public int insert(String sql) {
		int rowsAffected = 0;

		try {
			rowsAffected = this.st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if ((rowsAffected == 0))
			System.out.println("No se realizo el insert.");
		else
			System.out.println("Se realizo el insert");

		return rowsAffected;
	}

	public void close(){
		try {
			this.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Se cerro la conexion.");
	}
}
