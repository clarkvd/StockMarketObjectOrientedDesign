public class StockFactory{
    
	public static Stock createStock(String symbol, double initialPrice, double volatility) {
        	return new Stock(symbol, initialPrice, volatility);
    	}
}
