public class Main {

	public static void main(String[] args) {
		GameUI gameUI = new GameUI();
		MarketDisplay marketDisplay = new MarketDisplay();
		PortfolioDisplay portfolioDisplay = new PortfolioDisplay();

		Stock apple = StockFactory.createStock("AAPL", 150.00, 5.0);
		Stock google = StockFactory.createStock("GOOGL", 2800.00, 10.0);
		Stock amazon = StockFactory.createStock("AMZN", 3300.00, 3.0);

		StockPriceLogger logger = new StockPriceLogger();
		apple.registerObserver(logger);
		google.registerObserver(logger);
		amazon.registerObserver(logger);

        	ComplexInstrument complexETF = new ComplexInstrument();
		complexETF.addComponent(apple);
        	complexETF.addComponent(google);
        	complexETF.addComponent(amazon);

        	StockMarket stockMarket = StockMarket.getInstance();
        	stockMarket.addStock(apple);
        	stockMarket.addStock(google);
        	stockMarket.addStock(amazon);
		stockMarket.addComplexInstrument(complexETF);

        	MarketSimulator marketSimulator = new MarketSimulator(stockMarket);

        	InvestmentStrategy strategy = gameUI.chooseInvestmentStrategy();
        	Player player1 = new Player("Ryan", 100000.0);
		player1.setInvestmentStrategy(strategy);
        
		gameUI.displayWelcomeMessage();
        
		boolean exit = false;
		while (!exit) {
            		gameUI.displayMainMenu();
            		int choice = gameUI.getUserChoice();

            	switch (choice) {
                	case 1: // View Market
                    		marketDisplay.displayStockPricesBasedOnStrategy(stockMarket.getStocks(), stockMarket.getComplexInstruments(), player1.getInvestmentStrategy());
                    		break;
                	case 2: // View Portfolio
                    		portfolioDisplay.displayPortfolio(player1);
                    		break;
                	case 3: // Trade Stocks or Complex Instruments
                    		gameUI.displayTradeMenu();
                    		int tradeChoice = gameUI.getUserChoice();
                    		switch (tradeChoice) {
                        		case 1: // Buy Stock
                            			handleBuyStock(player1, stockMarket, gameUI, false);
                            			gameUI.displayPlayerStatus(player1);
						break;
                        		case 2: // Sell Stock
                            			handleSellStock(player1, stockMarket, gameUI, false);
						gameUI.displayPlayerStatus(player1);
                            			break;
                        		case 3: // Buy Complex Instrument
                            			handleBuyStock(player1, stockMarket, gameUI, true);
                            			gameUI.displayPlayerStatus(player1);
						break;
                        		case 4: // Sell Complex Instrument
                            			handleSellStock(player1, stockMarket, gameUI, true);
                            			gameUI.displayPlayerStatus(player1);
						break;
                        		case 5: // Return to Main Menu
                            			break;
                        		default:
                            			System.out.println("Invalid option. Please try again.");
                    		}
                    		break;
                	case 4: // Exit
                    		exit = true;
                    		break;
                	default:
                    		System.out.println("Invalid option. Please try again.");
            		}
        	}

        	System.out.println("Thank you for playing the Stock Market Simulation Game!");
    	}

   	 private static void handleBuyStock(Player player, StockMarket stockMarket, GameUI gameUI, boolean isComplex) {
        	String symbol = gameUI.getStockSymbol();
        	int quantity = gameUI.getStockQuantity();

                if (quantity <= 0){
                        System.out.println("Invalid quantity. Quantity must be greater than 0.");
                        return;
                }

        	if (isComplex) {
            		ComplexInstrument instrument = stockMarket.getComplexInstrumentBySymbol(symbol);
            		if (instrument != null){
                		player.buyComplexInstrument(instrument, quantity);
            		} 
			else{
                		System.out.println("Complex instrument not found.");
            		}
        	} 
		else{
            		Stock stock = stockMarket.getStockBySymbol(symbol);
            		if (stock != null){
                		player.buyStock(stock, quantity);
                		System.out.println("Bought " + quantity + " shares of " + symbol);
            		} 
			else{
                		System.out.println("Stock not found.");
            		}
        	}
    	}

    	private static void handleSellStock(Player player, StockMarket stockMarket, GameUI gameUI, boolean isComplex) {
        	String symbol = gameUI.getStockSymbol();
        	int quantity = gameUI.getStockQuantity();
		if (quantity <= 0){
			System.out.println("Invalid quantity. Quantity must be greater than 0.");
			return;
		}
        	if (isComplex){
            		ComplexInstrument instrument = stockMarket.getComplexInstrumentBySymbol(symbol);
            		if (instrument != null) {
                		player.sellComplexInstrument(instrument, quantity);
                		System.out.println("Sold " + quantity + " units of complex instrument " + symbol);
            		} 
			else{
                		System.out.println("Complex instrument not found.");
            		}
        	} 
		else{
            		Stock stock = stockMarket.getStockBySymbol(symbol);
            		if (stock != null){
                		player.sellStock(stock, quantity);
            		} 
			else{
                		System.out.println("Stock not found.");
            		}
        	}
    	}
}
