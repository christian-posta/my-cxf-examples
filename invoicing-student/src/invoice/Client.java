package invoice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import com.iona.ps.courseware.invoice.Address;
import com.iona.ps.courseware.invoice.Customer;
import com.iona.ps.courseware.invoice.Invoice;
import com.iona.ps.courseware.invoice.InvoiceHeader;
import com.iona.ps.courseware.invoice.InvoiceLine;
import com.iona.ps.courseware.invoice.SupportLevel;
import com.iona.ps.courseware.invoicingservice.Invoicing;
import com.iona.ps.courseware.invoicingservice.InvoicingService;

public class Client {

	private static final QName serviceName = new QName(
			"http://www.iona.com/ps/courseware/InvoicingService",
			"InvoicingService");

	private static final String wsdlFileLocation = "./wsdl/InvoicingService.wsdl"; 
	
	private static  DatatypeFactory datatypeFactory = null;
	
	static {
		try {
			datatypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			// Ignore.
		}
	}
	
	public static void main(String[] args) 
	{		
		
		// Get the URL for the WSDL file.
		URL wsdlURL = null;
		try {
			wsdlURL = new File(wsdlFileLocation).toURL();
		} catch (MalformedURLException e1) {
			System.out
					.println("Exception; cannot create a URL for the wsdl file '"
							+ wsdlFileLocation + "'.");
		}

        
        // TODO: Create the InvoiceService. 
        // Create an InvoiceService object, passing it the wsdlURL and 
        // the serviceName 
        // 
        InvoicingService invoiceService = new InvoicingService(wsdlURL, serviceName); 
        
        
        // TODO: Create a proxy to the Invoice server. 
        // Get an InvoiceServer proxy object from the InvoiceService 
        // 
        Invoicing invoicing = invoiceService.getSOAPOverHTTPEndpoint(); 
    
        
        // TODO: Create an invoice. 
        // Create an invoice by calling the createInvoice() method.
        // Assign the result to the invoice object below.
        Invoice invoice = createInvoice();  
        
        
        // TODO: Send the invoice to the server/ 
        // Send the invoice your created to the Invoicing Service, 
        // by calling the sendInvoice() method on the invoicing object.
        //       
        invoicing.sendInvoice(invoice);
        
        
		// Shutdown gracefully; we have to explicitly use System.exit()  
		// so that any daemon threads created by the underlying bus will get 
		// terminated; if we don't do this then the threads will continue  
		// running and the program will hang after the main thread (this one!) 
		// has been finished. 
		//
		System.exit(0);		
	}	

	
	public static Invoice createInvoice()
	{
		// Declare an invoice to be returned by this method.
		//
        Invoice invoice = new Invoice();

		
		// TODO: 
        // Declare an Address object from the generated class package, and set
        // the addressLine1, addressLine2, city, country and postal code.
        // 
        Address addr = new Address();
        addr.setAddressLine1("433 N 38Th");
        addr.setCity("Phoenix");
        addr.setStateProvinceRegion("AZ");
        

		
		// TODO: 
        // Declare a Customer object, and set the contact first name, last name,
        // customer number, phone number, email, address and supportLevel to
        // your own data.
        // 
        Customer cust = new Customer();
        cust.setAddress(addr);
        cust.setFirstName("Christian");
        cust.setLastName("Posta");
        cust.setContactPhoneNumber("480-555-5555");
        

		
		// TODO: 
        // Use the datatypeFactory.newXMLGregorianCalendar() method to create an 
        // XMLGregorianCalendar called shippingDate, and set it to 2005-11-30
        // 
        XMLGregorianCalendar shippingDate = datatypeFactory.newXMLGregorianCalendar();
        shippingDate.setDay(15);
        shippingDate.setMonth(5);
        shippingDate.setYear(2012);
        
		// TODO: 
        // Use the datatypeFactory.newXMLGregorianCalendar() method to create an 
        // XMLGregorianCalendar called paymentDueDate, and set it tos 2005-12-25
        //    
        XMLGregorianCalendar paymentDueDate = datatypeFactory.newXMLGregorianCalendar();
        paymentDueDate.setDay(25);
        paymentDueDate.setMonth(12);
        paymentDueDate.setYear(2005);
                


		
		// TODO: 
        // Create an InvoiceHeader, and set the customer, payment due date
        // and shipping date.
        // 
        InvoiceHeader header = new InvoiceHeader();
        header.setCustomer(cust);
        header.setShippingDate(shippingDate);
        header.setPaymentDueDate(paymentDueDate);
		
		// TODO: 
        // Create an InvoiceLine object, and set it's descriptionn to "Widget",
        // product code to 123, quantity to 1000, total cost to 20000 and unit
        // cost to 20.
        // 
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setDescription("Widget");
        invoiceLine.setProductCode(123);
        invoiceLine.setQuantity(1000);
        invoiceLine.setTotalCost(20000);
        invoiceLine.setUnitCost(20);

		
		// TODO: 
        // Create another InvoiceLine object, and set it's descriptionn to
        // "Doo-Lally", product code to 321, quantity to 1000, total cost to
        // 30000 and unit cost to 30.
        // 

		
		// TODO: 
        // Add the two invoiceLines created above to the invoice. You can
        // do this by calling getInvoiceLine() on the invoice, which returns
        // a List object; use the add() method on that object to add your 
        // invoice lines.
        // 
        invoice.getInvoiceLine().add(invoiceLine);

		
		// TODO: 
        // Use the setHeader() method on the invoice object to set the header
        // to the header you created above.
        // 
        invoice.setHeader(header);
        
        // Return the invoice
        //
        return invoice;
	}
}

