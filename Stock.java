import java.util.List;
import java.util.ArrayList;

public class Stock extends FinancialInstrument{
	private String symbol;
	private double price;
    	private double volatility;
    	private List<PriceObserver> observers = new ArrayList<>();

    	public Stock(String symbol, double price, double  volatility){
        	this.symbol = symbol;
        	this.price = price;
        	this.volatility = volatility;
    	}

    	public double getValue(){
        	return price;
    	}
    	public double getPrice(){
        	return this.price;
    	}
    	public String getSymbol(){
        	return this.symbol;
    	}
    	public void setSymbol(String symbol){
        	this.symbol = symbol;
    	}

    	public void registerObserver(PriceObserver observer){
        	observers.add(observer);
    	}
    	public void removeObserver(PriceObserver observer){
        	observers.remove(observer);
    	}

    	public void notifyObservers(){
        	for (PriceObserver observer : observers){
	    		observer.update(this);
		}
    	}

    	public void setPrice(double price){
        	if (this.price != price){
	    		this.price = price;
	    		notifyObservers();
		}
    	}

    	public double getVolatility(){
        	return this.volatility;
    	}
    	public void setVolatility(double volatility){
        	this.volatility = volatility;
    	}
}
