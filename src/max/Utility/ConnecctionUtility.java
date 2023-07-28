package max.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnecctionUtility {
	private ConnecctionUtility(){}
	private static Connection con;
	static
	{
		try {
	//String url="jdbc:postgresql://10.9.9.0/jdbc";
	    
			Class.forName("org.postgresql.Driver");
 con = DriverManager.getConnection("jdbc:postgresql://localhost:5434/jdbc", "postgres", "postgres");
  		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDulal()
	{
		return con;
	}
	
	public static int getUnique(Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select max(cid) as cd from cmst");
		     ResultSet rs = ps.executeQuery();
		     while(rs.next())
		     {
		    	 int cd=rs.getInt("cd");
		    	 return cd+1;
		     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	

}


