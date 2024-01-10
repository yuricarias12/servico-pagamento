package services;

public interface OnlinePaymentsService {
    double paymentFee(Double amount);
    double interest(double amount, int months);
}
