public class Commission extends Hourly{
    private double totalSales;
    private final double commissionRate;

	public Commission(String name, String address, String phoneNumber,
    String socialSecurityNumber, double hourlyRate, double commissionRate) {
		super(name, address, phoneNumber, socialSecurityNumber, hourlyRate);
        this.commissionRate = commissionRate;
        this.totalSales = 0.0;
	}

    public void addSales(double totalSales){
        this.totalSales += totalSales;
    }

    @Override
    public double pay() {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0;

        return payment;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}
