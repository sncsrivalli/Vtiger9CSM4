package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		// Step 1: Create an instance of JDBC Driver
		Driver dbDriver = new Driver();
		
		// Step 2: Register Driver
		DriverManager.registerDriver(dbDriver);
		
		// Step 3: Establish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root",
				"root");
		
		// Step 4: Create Statement
		Statement statement = connection.createStatement();
		
		// Step 5: Execute query to fetch data
		ResultSet result = statement.executeQuery("select * from employees;");
		
		while(result.next()) {
			System.out.println(result.getInt("id")+"\t"+result.getString("name")+"\t"+result.getInt("salary")
								+"\t"+result.getString("phone"));
		}
		
		// Step 6: Close database connection
		connection.close();
	}

}
