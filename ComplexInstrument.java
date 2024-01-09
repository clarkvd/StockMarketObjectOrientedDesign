import java.util.List;
import java.util.ArrayList;

public class ComplexInstrument extends FinancialInstrument {
	private List<FinancialInstrument> components;
	private String name;
	public ComplexInstrument() {
		this.components = new ArrayList<>();
		this.name = "ETF";
	}

	public void addComponent(FinancialInstrument component) {
		components.add(component);
	}
	public String getName() {
		return name;
	}
	public double getValue() {
		double sum = 0;
		for (FinancialInstrument fi : components) {
    			sum += fi.getValue();
		}
		return sum;
	}
}
