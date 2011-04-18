

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class OnlineStoreImplTest {

	private OnlineStoreImpl onlineStore;

	Product p1;
	Product p2;
	Product p3;
	
	@Before
	public void setUp() throws Exception {

		Product[] stock = new Product[3];

		p1 = new Product("Book", "id1", 100.00);
		p2 = new Product("Pen", "id2", 2.00);
		p3 = new Product("Book", "id3", 50.00);

		stock[0] = p1;
		stock[1] = p2;
		stock[2] = p3;

		this.onlineStore = new OnlineStoreImpl("Book Store", stock);
	}

	@Test
	public void shouldGetBestOfferOfTypeBook() throws DataNotFoundException, RemoteException {
		
		Product booksBestOffer = onlineStore.getBestOfferOfType("Book");
		Assert.assertEquals(p3, booksBestOffer);
	}
	
	@Test
	public void shouldGetFirstProductInStockOfProvidedType() throws DataNotFoundException, RemoteException {
		
		Product firstProductOfTypeBook = onlineStore.getFirstProductOfType("Book");
		Assert.assertEquals(p1, firstProductOfTypeBook);
	}

	@Test
	public void shouldGetAllBooksInStock() throws DataNotFoundException, RemoteException {
		
		Product[] books = onlineStore.getProductsOfType("Book");
		List<Product> booksList = Arrays.asList(books);

		Assert.assertTrue(booksList.contains(p1));
		Assert.assertTrue(booksList.contains(p3));
	}
	
	@Test(expected=DataNotFoundException.class)
	public void shouldThrowDataNotFoundExceptionIfNoProductOfProvidedTypeIsFound() throws DataNotFoundException, RemoteException {
		onlineStore.getProductsOfType("computer");
	}
}
