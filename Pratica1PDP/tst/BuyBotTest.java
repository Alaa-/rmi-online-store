

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BuyBotTest {

	private BuyBot buyBot;
	
	private OnlineStore[] registeredOnlineStores;
	
	private String productType = "Book";
	
	@Mock
	private StoreCatalog storeCatalog;
	
	@Mock
	private OnlineStore onlineStoreOne;
	
	@Mock
	private OnlineStore onlineStoreTwo;
	
	@Mock
	private Product bestOfferFromStoreOne;
	
	@Mock
	private Product bestOfferFromStoreTwo;
	
	@Before
	public void setup() throws MalformedURLException, RemoteException, NotBoundException, DataNotFoundException {
		MockitoAnnotations.initMocks(this);
		
		this.buyBot = new BuyBot(storeCatalog);
		
		registeredOnlineStores = new OnlineStore[2];
		registeredOnlineStores[0] = onlineStoreOne;
		registeredOnlineStores[1] = onlineStoreTwo;
		
		Mockito.when(storeCatalog.getOnlineStores()).thenReturn(registeredOnlineStores);
		Mockito.when(onlineStoreOne.getBestOfferOfType(productType)).thenReturn(bestOfferFromStoreOne);
		Mockito.when(onlineStoreTwo.getBestOfferOfType(productType)).thenReturn(bestOfferFromStoreTwo);
		Mockito.when(bestOfferFromStoreOne.isBetterOfferThan(bestOfferFromStoreTwo)).thenReturn(true);
		Mockito.when(bestOfferFromStoreOne.isBetterOfferThan(null)).thenReturn(true);
	}
	
	@Test
	public void shouldBuyTheBestOfferOfProvidedType() throws RemoteException {
		
		BestOffer bestOffer = buyBot.buyBestOfferOfType(productType);
		
		OnlineStore bestOfferStore = bestOffer.getOnlineStore();
		Product bestOfferProduct = bestOffer.getProduct();
		
		Assert.assertEquals(onlineStoreOne, bestOfferStore);
		Assert.assertEquals(bestOfferFromStoreOne, bestOfferProduct);
	}
}
