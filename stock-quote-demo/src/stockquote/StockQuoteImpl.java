package stockquote;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import com.iona.ps.training.stockquotedemo.StockQuoteServiceFault;
import com.iona.ps.training.stockquotedemo.StockQuoteServiceFault_Exception;
import com.iona.ps.training.stockquotedemo.StockQuoterI;

@WebService(
		name = "StockQuoter",
		serviceName = "StockQuoterService",
		targetNamespace = "http://ps.iona.com/training/StockQuoteDemo",
		portName = "SOAPOverHTTPEndpoint"
)
public class StockQuoteImpl implements StockQuoterI {

	private StockQuoteBackEnd backEnd;
	
	public StockQuoteImpl(StockQuoteBackEnd backEnd) {
		this.backEnd = backEnd;
	}
	
	public BigDecimal getStockQuote(String symbol)
			throws StockQuoteServiceFault_Exception 
	{
		System.out.println("StockQuoteServiceDocImpl.getStockQuote(" + symbol + ")");
		try {
			return backEnd.getQuote(symbol);
		} catch (StockQuoteBackEndException e) {
			StockQuoteServiceFault fault = new StockQuoteServiceFault();
			fault.setErrorCode(0);
			fault.setErrorMessage(e.getMessage());
			throw new StockQuoteServiceFault_Exception("", fault);
		}
	}

	public String getStockDescription(String symbol)
			throws StockQuoteServiceFault_Exception 
	{
		System.out.println("StockQuoteServiceDocImpl.getStockDescription(" + symbol + ")");

		try {
			return backEnd.getStockDescription(symbol);
		} catch (StockQuoteBackEndException e) {
			StockQuoteServiceFault fault = new StockQuoteServiceFault();
			fault.setErrorCode(0);
			fault.setErrorMessage(e.getMessage());
			throw new StockQuoteServiceFault_Exception("", fault);

		}
	}

	public List<String> getStockSymbols()
			throws StockQuoteServiceFault_Exception 
	{
		System.out.println("StockQuoteServiceDocImpl.getStockSymbols()");

		try {
			return backEnd.getSymbols();
		} catch (StockQuoteBackEndException e) {
			StockQuoteServiceFault fault = new StockQuoteServiceFault();
			fault.setErrorCode(0);
			fault.setErrorMessage(e.getMessage());
			throw new StockQuoteServiceFault_Exception("", fault);

		}
	}

}
