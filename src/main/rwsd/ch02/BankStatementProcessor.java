package main.rwsd.ch02;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public List<BankTransaction> totalFromMonth(final Month month) {

        final List<BankTransaction> transactionsInMonth = new ArrayList<>();

        for (final BankTransaction transaction: bankTransactions){
            if (transaction.getDate().getMonth() == month){
                transactionsInMonth.add(transaction);
            }
        }

        return transactionsInMonth;
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for (final BankTransaction transaction: bankTransactions){
            total += transaction.getAmount();
        }
        return total;
    }

    public double calculateTotalForCategory (final String category) {
        double total = 0d;
        for (BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
