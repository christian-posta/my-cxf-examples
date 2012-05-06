package stockquote;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.namespace.QName;

import com.iona.ps.training.stockquotedemo.StockQuoteServiceFault_Exception;
import com.iona.ps.training.stockquotedemo.StockQuoterI;
import com.iona.ps.training.stockquotedemo.StockQuoterService;

public class Client {


	private static StockQuoterI stockQuoter;
	
	public static void doStuff() throws Exception 
	{
		// This method is left empty for the demonstrator to fill in; use the  stockQuoteService 
		// client stub to invoke on the web service's methods! For an example, see the method below,  
		// getAllSymbols().
		// 
		// By default, we just call the method below that prints out a suggested call. 
		//
		printInstructions();
		getAllSymbols();
	}
	
	public static void printInstructions() {
		String message = 
			"This client initialises the service endpoint, but doesn't do anything with it!  To change this behaviour, edit the " + "\n" + 
			"file src/stockquote/Client.java and modify the doStuff() method." 
			+"\n\n" + 
			"You can find sample code in the method getAllSymbols()... " +"\n"; 
		
		System.out.println(message); 
	}
	
	public static void getAllSymbols() throws RemoteException {
		try {
			List<String> symbols = stockQuoter.getStockSymbols();
			for (String symbol: symbols) { 
				String description = stockQuoter.getStockDescription(symbol);
				BigDecimal value = stockQuoter.getStockQuote(symbol);
				System.out.println("-------");
				System.out.println(symbol + " = " + value);
				System.out.println(description);
				System.out.println("-------");
			}
		} catch (StockQuoteServiceFault_Exception e) {
			System.out.println(e);
		}
	}
	public static void init(String[] args) throws Exception 
	{
        QName serviceName = new QName("http://ps.iona.com/training/StockQuoteDemo","StockQuoterService");
        
        String wsdlLocation = "./wsdl/StockQuoteDemo.wsdl";
        URL wsdlUrl= null; 
        try {
        	wsdlUrl = new URL(wsdlLocation);
        } catch (java.net.MalformedURLException ex) {
        	wsdlUrl = new File(wsdlLocation).toURL();
        }
        
        StockQuoterService stockQuoterService = new StockQuoterService(wsdlUrl, serviceName);
        stockQuoter = stockQuoterService.getSOAPOverHTTPEndpoint();
	}
	
	public static void main(String[] args) 
	{
		try {
			init(args);
		} catch (Exception e) {
			System.out.println("Exception during initialisation; details: " + e);
			System.exit(1);
		}
		
		try {
			doStuff();
		} catch (Exception e) {
			System.out.println("Exception during remote call; details: " + e);
			System.exit(1);
		}
		
		System.exit(0);
	}

}
