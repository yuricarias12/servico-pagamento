package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentsService onlinePaymentsService; //Usado para declarar dependência;

    public ContractService(OnlinePaymentsService onlinePaymentsService) {
        this.onlinePaymentsService = onlinePaymentsService;
    }

    public void processContract(Contract contract, int months) {

        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentsService.interest(basicQuota, i);
            double fee = onlinePaymentsService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota));
        }
        //Inserindo valores de forma manual;
        //contract.getInstallments().add(new Installment(LocalDate.of(2018, 7, 25), 206.04));
    }
}
