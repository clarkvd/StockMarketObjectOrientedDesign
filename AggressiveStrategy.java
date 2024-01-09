public class AggressiveStrategy implements InvestmentStrategy {
	private String s;
	
	public AggressiveStrategy(String s){
		this.s = "Aggressive";
	}

	public InvestmentStrategy getStrategy(){
        	return this;
	}

	public String getStrategyName(){
		return this.s;
	}

}

