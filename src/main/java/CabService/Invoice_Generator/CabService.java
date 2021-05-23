package CabService.Invoice_Generator;

import java.util.ArrayList;
import java.util.List;

public class CabService {
	//initializing variables
	double totalfare=0;
	double averagefarePerRide;
	//method to calculate total fare by passing distance and time as parameters
	//using if statements to calculate total fare and minimum fare
	public double calculateFare(final double distance, final int minute) {
		
		totalfare=(distance*10) + minute;
		
		if(totalfare==0.0) {
			return totalfare=0;			
		}
			
		if(totalfare<5.0 ) {
			return totalfare=5;
		}
		
		return totalfare;
	}
	//method to calculate total fare for number of rides
	public double calculateTotalFare(Ride[] rides) {
		for(Ride ride:rides) {
			totalfare+=this.calculateFare(ride.distance, ride.minute);
		}
		return totalfare;
	}
	//method to calculate average fare for ride bt passing total fare and length of ride as parameters
	public double averagefarePerRide(double totalfare, int length) {
		averagefarePerRide=totalfare/length;
		return averagefarePerRide;
	}
	
	public int returnNumOfRides(double totalfare, double averageFarePerRide) {

		int numOfRides= (int) ( totalfare / averageFarePerRide );
		return numOfRides;
	}
	//overloading a calculateFare method to select choice for premier and normal ride by passing extra parameter for choice
	//using if statements to calculate fare for normal and premium fare
	public double calculateFare(String choice, double distance, int minute) {
		if(choice.equalsIgnoreCase("Normal")) {
			int costPerMinute =1;
			double minCostPerKm =10;
			double minfare = 5;
			double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
			return totalfare;
		}else if(choice.equalsIgnoreCase("Premium")) {
			int costPerMinute =2;
			double minCostPerKm =15;
			double minfare = 20;
			double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
			return totalfare;
		}
		return 0;
	}
	//method to generate invoice for particular user by passing user Id as parameter
	//using arraylist to store the information of every users
	//using for loop to loop through details for particular user
	public InvoiceRecords findInvoice(String userId) throws InvalidInputException {
			try {
	    	List<InvoiceRecords> list = new ArrayList<>();
			list.add(new InvoiceRecords("User1",3,600,200));
			list.add(new InvoiceRecords("User2",2,248,124));
			list.add(new InvoiceRecords("User3",4,440,110));
			list.add(new InvoiceRecords("User4",8,560,70));
			
			InvoiceRecords user = null;
			  for (int i = 0; i < list.size(); i++) {
				if (userId.equals(list.get(i).getUserId())) {
					user = list.get(i);
					user.getNumofRides();
					user.getTotalFare();
					user.getAverageFare();
				    break;
				 } 
			   }
			return user;
			}catch (NullPointerException ae ) {
				throw new InvalidInputException("Invalid Input!No Records Found");
			}
	}
}



