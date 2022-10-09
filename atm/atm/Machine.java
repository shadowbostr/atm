package atm;
import java.sql.*;
public class Machine{
	 static void loadCash(int d2000,int d500,int d100) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Our5qLd8Zer0");
		Statement st=c.createStatement();
		ResultSet r=st.executeQuery("select num from amount");
		r.next();
		int a=r.getInt(1);
		r.next();
		int b=r.getInt(1);
		r.next();
		int d=r.getInt(1);
		a+=d2000;
		b+=d500;
		d+=d100;
		PreparedStatement ps=c.prepareStatement("update amount set num=? ,val=? where denomination=2000");
		ps.setInt(1,a);	ps.setInt(2,a*2000);
		ps.executeUpdate();
		ps=c.prepareStatement("update amount set num=? ,val=? where denomination=500");
		ps.setInt(1,b);	ps.setInt(2,b*500);
		ps.executeUpdate();
		ps=c.prepareStatement("update amount set num=? ,val=? where denomination=100");
		ps.setInt(1,d);	ps.setInt(2,d*100);
		ps.executeUpdate();
		System.out.println("Amount successfully loaded");
		c.close();
			
	}
	 public static void getATMbal() throws SQLException {
		Connection x=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Our5qLd8Zer0");
		Statement s=x.createStatement();
		ResultSet rs=s.executeQuery("select *from amount");
		System.out.println("DENOMINATION\tNUMBER\tVALUE");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t"+rs.getInt(3));
		}
		 rs=s.executeQuery("select sum(val) from amount");
		rs.next();
		System.out.println("Total Amount available in the ATM ="+ rs.getInt(1));;
		x.close();
	}
	

}