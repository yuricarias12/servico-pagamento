package services;

public class PaypalService implements  OnlinePaymentsService{
    @Override
    public double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * 0.01 * months;
    }
}
