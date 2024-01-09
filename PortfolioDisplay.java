import java.util.Map;

public class PortfolioDisplay {
	public void displayPortfolio(Player player) {

        	System.out.println("Your Portfolio:");

        	Portfolio portfolio = player.getPortfolio();
        	Map<Stock, Integer> holdings = portfolio.getHoldings();
        	Map<ComplexInstrument, Integer> complexInstrumentHoldings = portfolio.getComplexInstrumentHoldings();

        	if (holdings.isEmpty() && complexInstrumentHoldings.isEmpty()) {
            		System.out.println("Your portfolio is empty.");
        	} 
		else {
            		for (Map.Entry<Stock, Integer> entry : holdings.entrySet()) {
                		Stock stock = entry.getKey();
                		Integer quantity = entry.getValue();
                		System.out.printf("Stock: " + stock.getSymbol() + ", Quantity: " + quantity + ", Total Value: $ %.2f %n", stock.getPrice() * quantity);
            		}
            		for (Map.Entry<ComplexInstrument, Integer> entry : complexInstrumentHoldings.entrySet()) {
                		ComplexInstrument instrument = entry.getKey();
                		Integer quantity = entry.getValue();
                		System.out.printf("ETF: " + instrument.getName() + ", Quantity: " + quantity + ", Total Value: $ %.2f %n", instrument.getValue() * quantity);
            		}
        	}
    	}
}
