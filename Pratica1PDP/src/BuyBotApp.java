

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BuyBotApp {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		if (args.length < 2) {
			System.out.println("[USAGE] BuyBotApp <remote_object_address> <product_type>");
			return;
		}
		
		String catalogURI = "rmi://" + args[0];
		String productType = args[1];
		
		BuyBot buyBot = new BuyBot(catalogURI);
		BestOffer bestOffer = buyBot.buyBestOfferOfType(productType);
		
		String buyMessage = String.format("Best Offer %s purchased from %s", bestOffer.getProduct(), bestOffer.getOnlineStore().getName());
		System.out.println(buyMessage);
	}

}
