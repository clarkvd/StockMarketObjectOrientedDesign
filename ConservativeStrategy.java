public class ConservativeStrategy implements InvestmentStrategy{
        private String s;

        public ConservativeStrategy(String s){
                this.s = "Conservative";
        }

        public InvestmentStrategy getStrategy(){
                return this;
        }
	
	public String getStrategyName(){
		return this.s;
	}
}

