package CabService.Invoice_Generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CabServiceTest {
CabService cabService = new CabService();
	
	@Test
	public void testCalculateFare_Should_Return_Total_Fare() {
		
		final double distance =260;
		final int minute=90;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(2690, totalFare,0);
	}
	
	@Test
	public void testCalculateFare_Should_Return_Min_Fare() {
		
		final double distance =0.1;
		final int minute=1;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(5, totalFare,0);
	}
	
	@Test
	public void testCalculateFare_Should_Return_Zero_Fare() {	
		final double distance =0.0;
		final int minute=0;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(0, totalFare,0);
	}
	
	@Test
	public void testCalculateTotalFare_Should_ReturnTotalFare_forMultipleRides() {	
		
		Ride [] rides= {new Ride(2.0,5),
						new Ride(0.1,1)
								};
		double Fare=cabService.calculateTotalFare(rides);
		assertEquals(30.0, Fare , 0);
	}
	
	@Test
	public void test_shouldReturn_TotalFare_averageFarePerRide_and_numOfRides() {	
		Ride [] rides= {new Ride(2.0,5),
						new Ride(0.1,1)
						};
	
		double totalFare=cabService.calculateTotalFare(rides);
		assertEquals(30.0, totalFare , 0);
		
		double averageFarePerRide=cabService.averagefarePerRide(totalFare,rides.length);
		assertEquals(15.0, averageFarePerRide,0.0);
		
		int numOfRides=cabService.returnNumOfRides(totalFare, averageFarePerRide);
		assertEquals(2, numOfRides);
	}
	
	@Test
	public void givenChoice_shouldReturn_TotalFare() {
		String choice = "Normal";
		double distance = 20.0;
		int minute = 20;
		double Fare = cabService.calculateFare(choice,distance, minute);
		assertEquals(220, Fare,  0.0);
			
	}
	
	@Test
	public void givenChoice_shouldReturn_TotalFareforGivenChoice() {
		String choice = "Premium";
		double distance = 20.0;
		int minute = 15;
		double Fare = cabService.calculateFare(choice,distance, minute);
		assertEquals(330, Fare,  0.0);
			
	}
	
	@Test
	public void givenUserId_shouldReturn_InvoiceSummary() throws InvalidInputException {
		String user ="User1";
		InvoiceRecords invoicerecords = cabService.findInvoice(user);
		InvoiceRecords expected = new InvoiceRecords("User1",3,600,200);
		assertEquals(expected, invoicerecords);	
	}
	
	@Test
	public void givenUserId_shouldreturn_InvoiceSummary() throws InvalidInputException {
		String user ="User4";
		InvoiceRecords invoicerecords = cabService.findInvoice(user);
		InvoiceRecords expected = new InvoiceRecords("User4",8,560,70);
		assertEquals(expected, invoicerecords);	
	}
	
	@Test
	public void givenUserId_shouldReturn_InvalidInputException() throws InvalidInputException {
		String user =" ";
		InvoiceRecords invoicerecords = cabService.findInvoice(user);
		assertEquals(null, invoicerecords);	
	}
}