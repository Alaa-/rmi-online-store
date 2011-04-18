

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OnlineStore extends Remote, Serializable {

	/**
	 * Gets the Store name
	 * 
	 * @return the name of the store
	 */
	public String getName() throws RemoteException;

	/**
	 * Retrieve a list of available products of the provided type
	 * @param type search filter
	 * @return
	 */
	public Product[] getProductsOfType(String type) throws DataNotFoundException, RemoteException;

	/**
	 * Compra um produto, se existir em estoque, o qual deve ser removido do
	 * estoque da loja, e retorna true. Retorna falso caso o produto requisitado
	 * não esteja disponível.
	 */
	public void buy(Product p) throws RemoteException;

	/**
	 * Gets the best offer in the {@link OnlineStore}
	 * @param productType 
	 * @return the best offer
	 * @throws DataNotFoundException 
	 */
	public Product getBestOfferOfType(String productType) throws DataNotFoundException, RemoteException;
}
