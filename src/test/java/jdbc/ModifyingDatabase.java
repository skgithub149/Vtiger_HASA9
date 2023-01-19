package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyingDatabase {

	public static void main(String[] args) throws SQLException {
		
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		Statement statement = connect.createStatement();
		int result = statement.executeUpdate("insert into students(id,name,address)values(103,'Xyz','Hyd');");
		
		if (result==1) {
			System.out.println("DB updated successfully");
			
		}
		else {
			System.out.println("DB not updated");
		}
		
		ResultSet res = statement.executeQuery("select * from  students;");
		
		while (res.next()) {
			System.out.println(res.getInt("id")+"\t"+res.getString("name")+"\t"+res.getString("address"));
			
		}
		connect.close();

	}

}
