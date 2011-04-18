

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StoreCatalog extends Remote, Serializable {

	/**
	 * Registry a new {@link OnlineStore}
	 * @param store the new {@link OnlineStore} to be registered
	 * @throws RemoteException 
	 */
	public void register(OnlineStore store) throws RemoteException;

	/**
	 * Retrieve all registered {@link OnlineStore}
	 * @return list of registered {@link OnlineStore}
	 * @throws RemoteException 
	 */
	public OnlineStore[] getOnlineStores() throws RemoteException;

	public void open() throws RemoteException, MalformedURLException;

}
