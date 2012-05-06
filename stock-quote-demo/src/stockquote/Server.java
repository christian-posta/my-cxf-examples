package stockquote;

import javax.xml.ws.Endpoint;

public class Server {
    private static final String address = "http://localhost:9020/StockQuote/doc-literal";

	public static void main(String[] args) 
	{
		StockQuoteImpl impl = new StockQuoteImpl(new StockQuoteBackEnd()); 
		Endpoint.publish(address, impl);
		System.out.println("Listening for requests...");
	} 
}
