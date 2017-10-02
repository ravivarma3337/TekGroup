import java.sql.*;

public class Employee {

	public static void main(String[] args) {

		try {

			// 1. connection to the database

			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "root");

			// 2.create the statement
			Statement mystmt = mycon.createStatement();

			// 3.execute the sql query
// ------display the table
			// ResultSet myRs = mystmt.executeQuery("select *from details");
// -----insersion
			//String sql = "insert into Details" + "(user_id, fname, lname, email)" +
			//"values(11,'jaafwafan','okmga','rsj@gm')";
			//String sql1 = "insert into Details" + "(user_id, fname, lname, email)" +
				//	"values(22,'qqqq','nnn','aarsj@gm')";	
			//String sql12 = "insert into Details" + "(user_id, fname, lname,email)" +
			//"values(33,'pji','kumar','gan@rm')";
			// *String sql12 = "insert into Details" + "(user_id, fname, lname)" +
			// "values(3,'zzzzzPP','mamamam')";
// -----update
			//String sql3 = "update Details set fname = 'RAMARAJU' where user_id=33";
			
//------delete
			  String sql4= "delete from Details where lname= 'nnn'";

			// 4.process the result set
			 //while (myRs.next()) {
			 //System.out.println(myRs.getString("lname") + ", " +
			//myRs.getString("fname")+ ","+ myRs.getString("user_id"));

			//}
			//mystmt.executeUpdate(sql); //Execute the sql code against database
			//mystmt.executeUpdate(sql1);
			//mystmt.executeUpdate(sql12);
		   	//mystmt.executeUpdate(sql);
			  
//delete logics
			  int rowsAffected=mystmt.executeUpdate(sql4);
			  
			  System.out.println("Rows Affected:" + rowsAffected);
			  System.out.println("Delete completed.");

			// *System.out.println("insert complete");
			// System.out.println("update complete");

		} catch (Exception ex) {
			//System.out.println("no data found");
			ex.printStackTrace(); // exeception handler
		}

	}

}