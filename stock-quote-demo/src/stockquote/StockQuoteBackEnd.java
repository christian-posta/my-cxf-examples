/*
 * Created on Sep 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package stockquote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * @author trenaman
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StockQuoteBackEnd {
	
	private Hashtable<String, String> symbolInformation;
	private Random random;
	
	public StockQuoteBackEnd()  {
		random = new Random();	
		symbolInformation = new Hashtable<String, String>();
		symbolInformation.put("IONA", "IONA Technologes Ltd. Based in Ireland, these guys are the leading firm in Web Services technologies.");
		symbolInformation.put("IBM", "International Business Machines. Sometimes known as Goliath; nobody every gets fired for buying IBM.");
		symbolInformation.put("SUN", "Sun Microsystems Ltd. Makes of unix-oriented hardware and creators of the Java language.");
		symbolInformation.put("MS", "Microsoft. Anybody fancy a defenestration?");
	}
	
	public BigDecimal getQuote(String symbol) throws StockQuoteBackEndException 
	{
		
		if (! symbolInformation.containsKey(symbol)) { 
			throw new StockQuoteBackEndException("Unknown symbol '" + symbol + "'");
		}
		
		int dollars = 80 + (Math.abs(random.nextInt()) % 10);
		int cents = Math.abs(random.nextInt()) % 100;
		return new BigDecimal(dollars + "." + ((cents < 10) ? "0" : "") + cents);
	}
	
	public List<String> getSymbols() throws StockQuoteBackEndException {
		Enumeration keys = symbolInformation.keys();
		List<String> retn = new ArrayList<String>();
		
		while (keys.hasMoreElements()) {
			retn.add((String) keys.nextElement());
		}

		return retn; 
	}
	
	public String getStockDescription(String symbol) throws StockQuoteBackEndException 
	{
		String ret = null; 
		
		if (symbolInformation.containsKey(symbol)) { 
			ret = (String) symbolInformation.get(symbol);
		}
		else {
			throw new StockQuoteBackEndException("Unknown symbol '" + symbol + "'");
		}
		
		return ret;
	}
}
