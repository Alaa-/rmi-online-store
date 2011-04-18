

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class OnlineStoreImpl extends UnicastRemoteObject implements OnlineStore {

	private static final long serialVersionUID = -4707650513311829200L;

	private String name;
	private Vector<Product> stock = new Vector<Product>();

	public OnlineStoreImpl(String name, Product[] products) throws RemoteException {
		this.name = name;
		this.stock.addAll(Arrays.asList(products));
	}

	public synchronized void buy(Product p) {

		this.stock.remove(p);
	}

	public Product[] getProductsOfType(String type) throws DataNotFoundException, RemoteException {

		List<Product> matchedProducts = new LinkedList<Product>();

		for (Product product : stock) {
			if (product.isTypeOf(type)) {
				matchedProducts.add(product);
			}
		}

		if (matchedProducts.isEmpty()) {
			throw new DataNotFoundException("There is no product of type " + type);
		}

		return matchedProducts.toArray(new Product[matchedProducts.size()]);
	}

	public Product getFirstProductOfType(String type) throws DataNotFoundException, RemoteException {

		for (Product product : stock) {
			if (product.getType().equals(type)) {
				return product;
			}
		}

		throw new DataNotFoundException("Thre is no product of type " + type);
	}

	public Product getBestOfferOfType(String type) throws DataNotFoundException, RemoteException {

		String storeNameLabel = "[Store " + this.getName() + "] ";
		System.out.println(storeNameLabel + "Listing products of type: " + type);

		int i = 1;
		Product bestOffer = null;
		for (Product product : stock) {
			if (product.isTypeOf(type) && product.isBetterOfferThan(bestOffer)) {

				System.out.println("#" + i + " " + product);
				bestOffer = product;
				i++;
			}
		}

		if (bestOffer == null) {
			throw new DataNotFoundException("There is no product of type " + type);
		}
		
		System.out.println("### Best Offer: " + bestOffer);
		return bestOffer;
	}

	public String getName() {

		return name;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof OnlineStore)) {
			return false;
		}

		try {
			OnlineStore otherOnlineStore = (OnlineStore) obj;
			return this.getName().equals(otherOnlineStore.getName());
			
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
