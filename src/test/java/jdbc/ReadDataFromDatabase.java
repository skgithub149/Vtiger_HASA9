package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		//Step 1: create an instance for Driver
		//Driver should be imported from com.mysql.cj.jdbc.Driver
		//new Driver() throws SQLException
		Driver dbDriver=new Driver();
		
		//Step 2: Register to the dbDriver
		//DriverManager is in java.sql
		DriverManager.registerDriver(dbDriver);
		
		//Step 3: Establish database connection
		//Connection should be imported from java.sql
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		
		//Step 4: Create Statement
		//Statement should be imported from java.sql
		Statement statement = connect.createStatement();
		
		//Step 5:Execute query to fetch data
		ResultSet result = statement.executeQuery("select * from  students;");
		
		//to fetch the data from databse
		while (result.next()) {
			System.out.println(result.getInt("id")+"\t"+result.getString("name")+"\t"+result.getString("address"));
			
		}			
		
		//Step 6:Close database
		connect.close();
		}
		

	}


