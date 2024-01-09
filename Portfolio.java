import java.util.Map;
import java.util.HashMap;

public class Portfolio{
    	private Map<Stock, Integer> holdings;
    	private Map<ComplexInstrument, Integer> complexInstrumentHoldings;

    	public Portfolio(){
        	this.holdings = new HashMap<>();
		this.complexInstrumentHoldings = new HashMap<>();
    	}

    	public void addStock(Stock stock, int quantity){
        	holdings.put(stock, holdings.getOrDefault(stock, 0) + quantity);
    	}

    	public void addComplexInstrument(ComplexInstrument instrument, int quantity){
        	complexInstrumentHoldings.put(instrument, complexInstrumentHoldings.getOrDefault(instrument, 0) + quantity);
    	}

   	public void removeStock(Stock stock, int quantity){
        	int currentQuantity = holdings.getOrDefault(stock, 0);
        	if (currentQuantity >= quantity){
           		holdings.put(stock, currentQuantity - quantity);
        	}
    	}

    	public void removeComplexInstrument(ComplexInstrument instrument, int quantity){
        	int currentQuantity = complexInstrumentHoldings.getOrDefault(instrument, 0);
        	if (currentQuantity >= quantity){
            		complexInstrumentHoldings.put(instrument, currentQuantity - quantity);
        	}
    	}

    	public boolean containsStock(Stock stock, int quantity){
        	return holdings.getOrDefault(stock, 0) >= quantity;
    	}

    	public boolean containsComplexInstrument(ComplexInstrument instrument, int quantity){
        	return complexInstrumentHoldings.getOrDefault(instrument, 0) >= quantity;
    	}

    	public Map getHoldings(){
        	return this.holdings;	
    	}

    	public Map getComplexInstrumentHoldings(){
        	return this.complexInstrumentHoldings;
    	}
}
