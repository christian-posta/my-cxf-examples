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

        
        // Create an InvoiceService object, passing it the wsdlURL and 
        // the serviceName 
        // 
        InvoicingService invoiceService = null; 
        invoiceService= new InvoicingService(wsdlURL, serviceName); 
        
        
        // Get an InvoiceServer proxy object from the InvoiceService 
        // 
        Invoicing invoicing = null; 
        invoicing = invoiceService.getPort(
        		new QName("http://www.iona.com/ps/courseware/InvoicingService", "SOAPOverHTTPEndpoint"), 
        		Invoicing.class); 
    
        
        // Create an invoice by calling the createInvoice() method.
        // Assign the result to the invoice object below.
        Invoice invoice = null;  
        invoice = createInvoice(); 
        
        
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

		
        // Declare an Address object from the generated class package, and set
        // the addressLine1, addressLine2, city, country and postal code.
        // 
        Address address = new Address();
        address.setAddressLine1("4 Shelbourne Road");
        address.setAddressLine2("Ballsbridge");
        address.setCity("Dublin");
        address.setStateProvinceRegion("Leinster");
        address.setCountry("Ireland");
        address.setZIPPostalCode("D4"); 

		
        // Declare a Customer object, and set the contact first name, last name,
        // customer number, phone number, email, address and supportLevel to
        // your own data.
        // 
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Bloggs");
        customer.setCustomerNumber("123");
        customer.setContactPhoneNumber("+353-1-6372000");
        customer.setEmail("customer@iona.com");
        customer.setAddress(address);
        customer.setSupportLevel(SupportLevel.GOLD); 

		
        // Use the datatypeFactory.newXMLGregorianCalendar() method to create an 
        // XMLGregorianCalendar called shippingDate, and set it to 2005-11-30
        // 
		XMLGregorianCalendar shippingDate = datatypeFactory.newXMLGregorianCalendar();
		shippingDate.setDay(30);
		shippingDate.setMonth(11);
		shippingDate.setYear(2005); 

        
        // Use the datatypeFactory.newXMLGregorianCalendar() method to create an 
        // XMLGregorianCalendar called paymentDueDate, and set it tos 2005-12-25
        // 
		XMLGregorianCalendar paymentDueDate = datatypeFactory.newXMLGregorianCalendar();
		paymentDueDate.setDay(25);
		paymentDueDate.setMonth(12);
		paymentDueDate.setYear(2005);         


		
        // Create an InvoiceHeader, and set the customer, payment due date
        // and shipping date.
        // 
        InvoiceHeader header = new InvoiceHeader();
        header.setCustomer(customer);        
        header.setShippingDate(shippingDate);
        header.setPaymentDueDate(paymentDueDate); 

		
        // Create an InvoiceLine object, and set it's descriptionn to "Widget",
        // product code to 123, quantity to 1000, total cost to 20000 and unit
        // cost to 20.
        // 
        InvoiceLine invoiceLine1 = new InvoiceLine();
        invoiceLine1.setDescription("Widget");
        invoiceLine1.setProductCode(123);
        invoiceLine1.setQuantity(1000);
        invoiceLine1.setTotalCost(20000);
        invoiceLine1.setUnitCost(20.00d); 

		
        // Create another InvoiceLine object, and set it's descriptionn to
        // "Doo-Lally", product code to 321, quantity to 1000, total cost to
        // 30000 and unit cost to 30.
        // 
        InvoiceLine invoiceLine2 = new InvoiceLine();
        invoiceLine2.setDescription("Doo-Lally");
        invoiceLine2.setProductCode(321);
        invoiceLine2.setQuantity(1000);
        invoiceLine2.setTotalCost(30000);
        invoiceLine2.setUnitCost(30); 

		
        // Add the two invoiceLines created above to the invoice. You can
        // do this by calling getInvoiceLine() on the invoice, which returns
        // a List object; use the add() method on that object to add your 
        // invoice lines.
        // 
        invoice.getInvoiceLine().add(invoiceLine1);
        invoice.getInvoiceLine().add(invoiceLine2); 

		
        // Use the setHeader() method on the invoice object to set the header
        // to the header you created above.
        // 
        invoice.setHeader(header); 
        
        // Return the invoice
        //
        return invoice;
	}
}

