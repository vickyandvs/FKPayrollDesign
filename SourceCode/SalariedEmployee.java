
import java.util.*;

class SalariedEmployee implements Employee{
	String name;
	int id;
	String address;
	int modeOfPayment;
	boolean unionMember;
	double rate;
	Date lastPaid;
	double salary;
	int type;
	Date lastComm;



	private boolean isLastDay(Date now) {
	    

        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(now);  

        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime();
        //System.out.println("\n last date of month: "+lastDayOfMonth+"\n");
        if(now.equals(lastDayOfMonth))return true;
        return false; 

	}



	private double calculateCommission(ArrayList<Double>bonus)
	{

		double comm=0;
		for(Double bon:bonus)
		{
			comm+=(bon*rate)/100;
		}
		return comm;
	}

	public double calculateSalary(Date now,ArrayList<Double> bonus)
	{
		
		double payment=0;


		long diff = now.getTime() - lastComm.getTime();
 
		int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		if(diffDays>=14&&dayOfWeek==6)
		{
			payment+=calculateCommission(bonus);
			

			lastComm=now;
		}

		if(isLastDay(now))
		{

			payment+=salary;
			lastPaid=now;


		}

		return payment;






	}








}