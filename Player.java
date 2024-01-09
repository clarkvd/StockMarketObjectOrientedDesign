import java.util.Random;
import java.lang.Math;

public class Player{
	private String name;
	private double balance;
	private Portfolio portfolio;
	private InvestmentStrategy strategy;

    	public Player(String name, double startingBalance){
        	this.name = name;
        	this.balance = startingBalance;
        	this.portfolio = new Portfolio();
    	}

    	public void buyStock(Stock stock, int quantity){
        	double cost = stock.getPrice() * quantity;
        	if (balance >= cost){
            		portfolio.addStock(stock, quantity);
            		balance -= cost;
	    		updateStockPrice(stock);
			//System.out.println("Bought " + quantity + " units of complex instrument " + stock.getSymbol());
		} 
		else{
            		System.out.println("Insufficient balance to complete purchase.");
        	}
    	}

    	public void buyComplexInstrument(ComplexInstrument instrument, int quantity){
        	double cost = instrument.getValue() * quantity;
        	if (this.balance >= cost){
            		portfolio.addComplexInstrument(instrument, quantity);
            		this.balance -= cost;
	    		System.out.println(instrument.getValue());
            		System.out.println("Purchased " + quantity + " units of " + instrument.getName());
        	} 
		else{
           		System.out.println("Insufficient balance to complete purchase.");
        	}
    	}

    	public void sellStock(Stock stock, int quantity){
        	if (portfolio.containsStock(stock, quantity)) {
           		portfolio.removeStock(stock, quantity);
            		balance += stock.getPrice() * quantity;
	    		updateStockPrice(stock);
			System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
		} 
		else{
            		System.out.println("Not enough stock in portfolio to sell.");
        	}
    	}

    	public void sellComplexInstrument(ComplexInstrument instrument, int quantity){
        	if (portfolio.containsComplexInstrument(instrument, quantity)){
            		portfolio.removeComplexInstrument(instrument, quantity);
            		balance += instrument.getValue() * quantity;
        	}	 
		else{
           		 System.out.println("Not enough stock in portfolio to sell.");
        	}
    	}

    	private void updateStockPrice(Stock stock){
        	Random random = new Random();
		boolean shouldAdd = random.nextBoolean();
		double newPrice = stock.getPrice();
		double delta = .02 * stock.getVolatility();
		if (shouldAdd){
			newPrice *= (1+delta);
		}
		else{
			newPrice *= (1-delta);
		}
		newPrice = Math.round(newPrice * 100.0) / 100.0;
		stock.setPrice(newPrice);
    	}

    	public double getBalance(){
        	return this.balance;
    	}

    	public Portfolio getPortfolio(){
        	return this.portfolio;
    	}

    	public InvestmentStrategy getInvestmentStrategy(){
		return this.strategy;
    	}

    	public void setInvestmentStrategy(InvestmentStrategy strategy){
		this.strategy = strategy;
    	}

}
