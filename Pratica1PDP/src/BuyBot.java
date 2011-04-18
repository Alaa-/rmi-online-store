

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BuyBot {

	private final StoreCatalog catalog;

	public BuyBot(StoreCatalog catalog) {
		this.catalog = catalog;
	}

	public BuyBot(String catalogURI) throws MalformedURLException, RemoteException, NotBoundException {
		this.catalog = (StoreCatalog) Naming.lookup(catalogURI);
	}

	public BestOffer buyBestOfferOfType(String productType) throws RemoteException {

		OnlineStore[] stores = getCatalog().getOnlineStores();
		// TO DO: c) pesquisa em cada loja por items do tipo de interesse,
		// imprimindo id, loja e preço para cada item encontrado e lembrando a
		// melhor oferta

		OnlineStore bestStore = stores[0];
		Product bestOfferEver = null;

		for (OnlineStore store : stores) {
			Product storeBestOffer;

			try {
				storeBestOffer = store.getBestOfferOfType(productType);
				if (storeBestOffer.isBetterOfferThan(bestOfferEver)) {

					bestOfferEver = storeBestOffer;
					bestStore = store;
				}
			} catch (DataNotFoundException e) {
				System.out.println("Store " + store.getName() + " does not have a product of type " + productType);
			}
		}

		bestStore.buy(bestOfferEver);
		return new BestOffer(bestStore, bestOfferEver);
	}

	public StoreCatalog getCatalog() {
		return catalog;
	}

}
