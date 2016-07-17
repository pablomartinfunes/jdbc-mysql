public class Test {

	public static void main(String[] args) {

		JdbcConnection conn = new JdbcConnection();

		System.out.println("Obtenemos los empleados actuales.");

		conn.query("Select * from employees;");

		System.out.println("Se sumara al empleado Pablo Funes.");

		conn.insert("insert into employees" + "(last_name, first_name, email, department, salary) "
				+ "values ('Funes', 'Pablo', 'pabfun7@gmail.com', 'IT', 25000)");

		System.out.println("Obtenemos los empleados actualizado.");

		conn.query("Select * from employees;");

		conn.close();

	}

}
