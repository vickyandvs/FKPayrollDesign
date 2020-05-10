import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.*;  

public class AddEmployee{

	String firstName;
	String lastName;
	String postalAdd;
	String accountNo;

	String address;
	int modeOfPayment=1;
	int unionMember=0;
	double rate=0;
	
	double salary=0;
	int type;
	



	public AddEmployee(){

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter first name of Employee.");
		firstName=sc.nextLine();
		System.out.println("Enter last name of Employee.");
		lastName=sc.nextLine();
		System.out.println("Mode of payment.");
		System.out.println("Enter 1 for pickup");
		System.out.println("Enter 2 for postal service.");
		System.out.println("Enter 3 for directtly to account.");
		modeOfPayment=sc.nextInt();
		sc.nextLine();
		if(modeOfPayment==2)
		{
			System.out.println("Enter postal address");
			postalAdd=sc.nextLine();

		}
		else if(modeOfPayment==3)
		{

			System.out.println("Enter bank account no.");
			accountNo=sc.nextLine();

		}
		System.out.println("Type of Employee");
		System.out.println("Enter 1 for Hourly Employee");
		System.out.println("Enter 2 for salaried");
		type=sc.nextInt();
		sc.nextLine();
		if(type==1)
		{

			System.out.println("Enter hour rate");
			rate=sc.nextDouble();

		}
		else {

			System.out.println("Enter Salary");
			salary=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter commission rate of employee");
			rate=sc.nextInt();

		}
		sc.nextLine();
		System.out.println("Enter 1 if employee is union memeber 0 otherwise");
			int a=sc.nextInt();
		//String union;
			sc.nextLine();
		if(a==1)
		{
			//union="true";
			unionMember=1;
		}
		else
		{
			//union="false";
			unionMember=0;
		}

	}

	public String queryGenerator(){
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
   LocalDateTime now = LocalDateTime.now();  
   String date=dtf.format(now);  
		String union;
		if(unionMember==1)union="TRUE";
		else union="FALSE";
		String query="insert into Employee(firstName,lastName,modeOfSalary,rate,salary,type,postalAdd,accountNo,isUnionMember,lastComm,lastPaidDate)values('"+firstName+"','"+lastName+"',"+modeOfPayment+","+rate+","+salary+","+type+",'"+postalAdd+"','"+accountNo+"',"+union+",'"+date+"','"+date+"')";
		return query;
	}





}