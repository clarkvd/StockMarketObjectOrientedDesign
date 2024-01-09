import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class StockMarket{
    	private static StockMarket instance;
    	private List<Stock> stocks;
    	private List<ComplexInstrument> complexInstruments;

    	public StockMarket(){
        	this.stocks = new ArrayList<>();
		this.complexInstruments = new ArrayList<>();
    	}

    	public static StockMarket getInstance(){
        	if (instance == null){
            		instance = new StockMarket();
        	}
        	return instance;
    	}

    	public void addStock(Stock stock) {
        	stocks.add(stock);
    	}

    	public List<Stock> getStocks() {
        	return stocks;
    	}

    	public List<ComplexInstrument> getComplexInstruments() {
        	return complexInstruments;
    	}
    	public void addComplexInstrument(ComplexInstrument instrument){
        	complexInstruments.add(instrument);
    	}
    	public ComplexInstrument getComplexInstrumentBySymbol(String symbol){
        	for (ComplexInstrument instrument : complexInstruments){
            		if (instrument.getName().equals(symbol)){
                		return instrument;
            		}
        	}
        	return null;
    	}

    	public Stock getStockBySymbol(String symbol){
        	for (Stock stock : stocks){
            		if (stock.getSymbol().equalsIgnoreCase(symbol)){
                		return stock;
            		}
        	}
        	return null;
    	}
}
