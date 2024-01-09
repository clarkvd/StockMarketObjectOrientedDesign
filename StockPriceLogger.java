public class StockPriceLogger implements PriceObserver{
	@Override
	public void update(Stock stock){
		System.out.println("Stock Price Update: " + stock.getSymbol() + " is now $" + stock.getPrice());
	}
}
