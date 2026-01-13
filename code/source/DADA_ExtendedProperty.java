

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
import java.util.Collections;
// --- <<IS-END-IMPORTS>> ---

public final class DADA_ExtendedProperty

{
	// ---( internal utility methods )---

	final static DADA_ExtendedProperty _instance = new DADA_ExtendedProperty();

	static DADA_ExtendedProperty _newInstance() { return new DADA_ExtendedProperty(); }

	static DADA_ExtendedProperty _cast(Object o) { return (DADA_ExtendedProperty)o; }

	// ---( server methods )---




	public static final void maxToStringLength (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(maxToStringLength)>> ---
		// @sigtype java 3.5
		// Main method executed by webMethods Flow
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		 
		try {
		    // Create a new IData object
		    IData largeData = IDataFactory.create();
		    IDataCursor cursor = largeData.getCursor();
		 
		    // Add some simple fields
		    cursor.insertAfter("customerId", "CUST12345");
		    cursor.insertAfter("name", "John Doe");
		 
		    // Add a large list of orders to simulate big IData
		    ArrayList<String> orders = new ArrayList<>(Collections.nCopies(1000, "OrderData"));
		    cursor.insertAfter("orders", orders);
		 
		    // Add a nested IData
		    IData preferences = IDataFactory.create();
		    IDataCursor prefCursor = preferences.getCursor();
		    prefCursor.insertAfter("newsletter", true);
		    prefCursor.insertAfter("smsAlerts", false);
		    prefCursor.destroy();
		 
		    cursor.insertAfter("preferences", preferences);
		    cursor.destroy();
		 
		    String dataString = largeData.toString();
		
		    // Print to server log
		    System.out.println("IData Output:");
		    System.out.println(dataString);
		
		    // Add IData string and its length to pipeline
		    pipelineCursor.insertAfter("largeIDataString", dataString);
		    pipelineCursor.insertAfter("largeIDataStringLength", dataString.length());
		
		    // Optionally, return the original IData as well
		    pipelineCursor.insertAfter("largeIData", largeData);
		 
		} catch (Exception e) {
		    throw new ServiceException(e);
		} finally {
		    pipelineCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}
}

