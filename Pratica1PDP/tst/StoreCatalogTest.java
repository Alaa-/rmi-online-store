

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class StoreCatalogTest {

	private StoreCatalogImpl storeCatalog;
	
	@Before
	public void setup() throws RemoteException, MalformedURLException {
		this.storeCatalog = new StoreCatalogImpl();
	}
	
	@Test
	public void should() {
		
	}
	
}
