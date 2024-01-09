import java.util.List;
import java.util.Comparator;
import java.util.Arrays;

public class MarketDisplay {

    	public void displayStockPricesBasedOnStrategy(List<Stock> stocks, List<ComplexInstrument> instruments, InvestmentStrategy strategy) {
		if (strategy instanceof ConservativeStrategy){
            		System.out.println("\nCurrent Stock Prices:");
			stocks.sort(Comparator.comparingDouble(Stock::getVolatility));
		} 
		else if (strategy instanceof AggressiveStrategy){
            		stocks.sort(Comparator.comparingDouble(Stock::getVolatility).reversed());
        	}

		List<String> strings = Arrays.asList("Best for your strategy", "Decent for your strategy", "Bad for your strategy");

		for (int i = 0; i < stocks.size(); i++){
    			Stock stock = stocks.get(i);
    			String string = strings.get(i); 
    			System.out.println(stock.getSymbol() + ": $" + stock.getPrice() + ", " + string);
		}

        	System.out.println("\nCurrent Complex Instrument Prices:");
		for (ComplexInstrument instrument : instruments){
			System.out.println(instrument.getName() + ": $" + instrument.getValue());
        	}
		System.out.println();
    	}
}
