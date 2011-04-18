

import java.io.IOException;

public class ServerApp {

	public static final String HOST = "rmi://127.0.0.1:1234";

	public static void main(String[] args) throws IOException {
		//Runtime.getRuntime().exec("rmiregistry 1099");
		//Runtime.getRuntime().exec("rmic StoreCatalogImpl");
		//Runtime.getRuntime().exec("rmic OnlineStoreImpl");
		
		StoreCatalog catalog = new StoreCatalogImpl();
		catalog.open();
		
		OnlineStoresRegister onlineStoresRegister = new OnlineStoresRegister();
		onlineStoresRegister.register();
	}
}
