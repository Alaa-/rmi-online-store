

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * Catalog of all registered {@link OnlineStore}
 * 
 * Should be a Singleton (by RMI lookup it can be ensured)
 */
public class StoreCatalogImpl extends UnicastRemoteObject implements StoreCatalog {

	private static final long serialVersionUID = 7060239518076166648L;
	private final Vector<OnlineStore> onlineStoreList = new Vector<OnlineStore>();

	public StoreCatalogImpl() throws RemoteException {}
	
	public void open() throws RemoteException, MalformedURLException {
		Naming.rebind(ServerApp.HOST + "/Catalog", this);
		System.out.println("### Catalog is opened.");
	}
	
	public void close() throws RemoteException, MalformedURLException, NotBoundException {
		Naming.unbind("/Catalog");
	}
	
	public OnlineStore[] getOnlineStores() throws RemoteException {
		
		return onlineStoreList.toArray(new OnlineStore[onlineStoreList.size()]);
	}

	public void register(OnlineStore store) throws RemoteException {
		this.onlineStoreList.add(store);		
	}
}
