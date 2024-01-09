import java.util.Scanner;

public class GameUI {
	private Scanner scanner;

	public GameUI() {
		this.scanner = new Scanner(System.in);
	}

	public void displayWelcomeMessage() {
		System.out.println("Welcome to the Stock Market Simulation Game!");
	}

	public InvestmentStrategy chooseInvestmentStrategy() {
		System.out.println("\nChoose your investment strategy:");
		System.out.println("1. Conservative");
		System.out.println("2. Aggressive");

		int choice = scanner.nextInt();
		System.out.println("\nStocks in the market will now be ranked from most fitting to least fitting to your chosen strategy\n");
		switch (choice) {
			case 1:
				InvestmentStrategy s = new ConservativeStrategy("Conservative");
				return s.getStrategy();
				//return new ConservativeStrategy();
			case 2:
				InvestmentStrategy a =  new AggressiveStrategy("Aggressive");
				return a.getStrategy();
			default:
				System.out.println("Invalid choice. Defaulting to Conservative.\n");
                                InvestmentStrategy d = new ConservativeStrategy("Conservative");
                                return d.getStrategy();		
		}
	}

	public void displayMainMenu() {
		System.out.println("\nMain Menu:");
		System.out.println("1. View Market");
		System.out.println("2. View Portfolio");
		System.out.println("3. Trade Stocks");
		System.out.println("4. Exit\n");
	}

	public int getUserChoice() {
		System.out.print("Enter your choice: ");
		return scanner.nextInt();
	}

	public void displayPlayerStatus(Player player) {
		System.out.println("Player Balance: $" + player.getBalance());
	}

	public void displayTradeMenu() {
		System.out.println("Trading Menu:");
		System.out.println("1. Buy Stock");
		System.out.println("2. Sell Stock");
		System.out.println("3. Buy Complex Instrument");
		System.out.println("4. Sell Complex Instrument");
		System.out.println("5. Return to Main Menu\n");
	}

	public String getStockSymbol() {
		System.out.print("Enter stock symbol: ");
		return scanner.next();
	}

	public int getStockQuantity() {
		System.out.print("Enter quantity: ");
		return scanner.nextInt();
	}

}
