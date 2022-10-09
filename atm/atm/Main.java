package atm;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner i=new Scanner(System.in);
		int opt;
    while(true) {
    	System.out.println("1.Load cash to ATM 2.Show customer details 3.ATM operations");
         opt=i.nextInt();
         switch(opt) {
         case 1:System.out.println("No of 2000 denomination:");
                int t=i.nextInt();
                System.out.println("No of 500 denomination:");
                int f=i.nextInt();
                System.out.println("No of 100 denomination:");
                int h=i.nextInt();
                Machine.loadCash(t, f, h);
                break;
          case 2:customer.showCustomers();
                break;
          case 3:while(true) {
        	     System.out.println("1. Check Balance\t2. Withdraw Money\n3. Check ATM Balance");
                 int choice=i.nextInt();
                 switch(choice) {
                 case 3:Machine.getATMbal(); break;
                 }
                 System.out.println("1 to main menu");
                 choice=i.nextInt();
                 if(choice==1) break;
                 }
                 
         }
    	
    }
 
			
			        
			}
			
		}

