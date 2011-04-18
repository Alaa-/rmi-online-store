

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class OnlineStoresRegister {

	public void register() {

		try {
			String catalogAddress = ServerApp.HOST + "/Catalog";

			OnlineStore onlineComputerStore = OnlineStoreFactory.getInstance().createOnlineComputerStore();
			OnlineStore onlineBookStore = OnlineStoreFactory.getInstance().createOnlineBookStore();

			StoreCatalog catalog = (StoreCatalog) Naming.lookup(catalogAddress);
			catalog.register(onlineComputerStore);
			catalog.register(onlineBookStore);
			
			System.out.println("Registrado loja de livros e de computadores...");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
