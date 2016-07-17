import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		ResultSet rs;
		
		JdbcConnection conn = new JdbcConnection();
		
		rs = conn.query("Select * from employees;");
		
		try {
			while(rs.next()){
				System.out.println("Nombre: " + rs.getString("first_name") + ", Apellido: " + rs.getString("last_name"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}
