import java.util.Random;

public class MarketSimulator{
	private StockMarket stockMarket;

	public MarketSimulator(StockMarket stockMarket) {
        	this.stockMarket = stockMarket;
    	}

    	public void simulate(){
        	for (Stock stock : stockMarket.getStocks()) {
            		Random random = new Random();
			boolean shouldAdd = random.nextBoolean();
			double newPrice = stock.getPrice();
			if (shouldAdd){
				newPrice *= 1.02;
			}
			else{
				newPrice *= 0.98;
			}
			newPrice *= stock.getVolatility();
            		stock.setPrice(newPrice);
        	}
    	}
}
