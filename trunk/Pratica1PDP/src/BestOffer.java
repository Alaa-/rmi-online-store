


public class BestOffer {

	private final OnlineStore onlineStore;
	private final Product product;
		
	public BestOffer(OnlineStore onlineStore, Product product) {
		this.onlineStore = onlineStore;
		this.product = product;
	}

	public OnlineStore getOnlineStore() {
		return onlineStore;
	}

	public Product getProduct() {
		return product;
	}

}
