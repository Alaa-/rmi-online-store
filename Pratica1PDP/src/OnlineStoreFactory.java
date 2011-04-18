

import java.rmi.RemoteException;

public class OnlineStoreFactory {

	private static OnlineStoreFactory instance;
	
	private OnlineStoreFactory() {}
	
	public static OnlineStoreFactory getInstance() {
		if(instance == null) {
			instance = new OnlineStoreFactory();
		}
		
		return instance;
	}
	
	public OnlineStore createOnlineBookStore() throws RemoteException {
		Product[] products = new Product[] {
				new Product("Book", "Java Threads", 20.00),
				new Product("Book", "Modern OS", 15.00),
				new Product("Book", "book1", 200.00),
				new Product("Book", "book2", 200.00)		
		};

		OnlineStore store = new OnlineStoreImpl("Online Books Store", products);
		return store;
	}
	
	public OnlineStore createOnlineComputerStore() throws RemoteException {
		Product[] products = new Product[] {
				new Product("Book", "Java RMI", 200.00),
				new Product("Book", "Introduction to RMI", 150.00),
				new Product("laptop", "laptop1", 2500.00),
				new Product("laptop", "laptop2", 2300.00)		
		};

		OnlineStore store = new OnlineStoreImpl("Online Computers Store", products);
		return store;
	}
}