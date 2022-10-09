package atm;
import java.sql.*;
public class customer{
	public static void showCustomers() throws SQLException {
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Our5qLd8Zer0");
	Statement st=c.createStatement();
	ResultSet r=st.executeQuery("select * from customer");
	System.out.println("AC.NO\tNAME\t\tPIN\t AC BALANCE");
	while(r.next())
	{
		System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t\t****"+"\t"+r.getInt(4));
	}
	c.close();
	}
	
	public static void checkBal(String acno,int pin) throws SQLException {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Our5qLd8Zer0");
		Statement st=c.createStatement();
		ResultSet r=st.executeQuery("select bal from customer where ac_no="+acno+" and "+"pin="+pin);
		if(r.next()) System.out.println(r.getInt(1));
		else System.out.println("Incorrect credentials");
		c.close();
		}
	/*public static void withdraw(String ac,int pin,int wamt) throws SQLException {
		int bal;
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Our5qLd8Zer0");
		Statement st=c.createStatement();
		ResultSet r=st.executeQuery("select bal from customer where ac_no="+ac+" and "+"pin="+pin);
		if(r.next())  bal=r.getInt(1);
		else {System.out.println("Incorrect credentials"); return;}
		 r=st.executeQuery("select sum(val) from amount");
		r.next();
		if(bal<wamt) {System.out.println("insufficient balance"); return;}
		else if(r.getInt(1)<wamt) {System.out.println("Transaction failed"); return;	
		}
		else {
			bal-=wamt;
			PreparedStatement ps=c.prepareStatement("update amount set num=? ,val=? where denomination=2000");
			ps.setInt(1,a);	ps.setInt(2,a*2000);
			ps.executeUpdate();
			System.out.println("Witdrawn successfully");
		}
		c.close();
	}*/
	}
   
   
