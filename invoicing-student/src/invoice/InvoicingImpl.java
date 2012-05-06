package invoice;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import com.iona.ps.courseware.invoice.Invoice;
import com.iona.ps.courseware.invoicingservice.Invoicing;


//
// Note the explicit naming of the wsdlLocation in the annotation below - if you wish to make use of alternative bindings (e.g. pure XML) 
// or transports (e.g. JMS) then you'll need this so that the service can pick up settings in the WSDL file.
//
@WebService(
		targetNamespace = "http://www.iona.com/ps/courseware/InvoicingService", 
		name = "Invoicing",
		serviceName = "InvoicingService",	
		portName = "SOAPOverHTTPEndpoint",
		wsdlLocation ="./wsdl/InvoicingService.wsdl" 
)
public class InvoicingImpl implements Invoicing {

	public void sendInvoice(Invoice invoice) 
	{
		System.out.println("sendInvoice() invoked; printing the invoice as XML.");
		
		try {
			
			// TODO: Wrap the invoice in a JAXBElement. 
			// The Invoice element has not been marked with the @XMLRootElement tag by
			// the code generator; as a result, if you want to use the marshal() method 
			// you must first wrap the invoice. in a JAXBElement.
			//
			// In the JAXBElement constructor, set the first parameter to the QName of the 
			// element, for example using: 
			// 
			//   new QName("http://www.iona.com/ps/courseware/Invoice", "invoice")
			//
			// The second parameter should be the Invoice class, and the final parameter
			// should be the invoice itself.
			//
			
			QName qname = new QName("http://www.iona.com/ps/courseware/Invoice", "invoice");
			JAXBElement element = new JAXBElement<Invoice>(qname, Invoice.class, invoice);
			marshaller.marshal(element, System.out);
			
			
			// TODO: Print out the element 
			// Use the marshal() method on the marshaller object to print out the 
			// element. The first parameter should be element, and the second should
			// be System.out. 
			// 
		} 
		catch (JAXBException e) {
			System.out.println("Error marshalling invoice; details: " + e);
		}
	}
	
	
	private static JAXBContext jc = null;
	private static Marshaller marshaller = null;
	
	static {
		try {
			jc = JAXBContext.newInstance( "com.iona.ps.courseware.invoice" );
			marshaller = jc.createMarshaller();
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT,
					  Boolean.TRUE );
			
		} catch (JAXBException e) {
			System.out.println("Exception trying to initialise JAXB; details: " + e);
			System.exit(1);			
		}
		
	}

}

