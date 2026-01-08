package com.interview.streams;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionServiceImpl {

    // Amount, Date, Type, accountNumber --> type string with credit/debit
    // Get transactions by account
    // Transaction summary date wise

    public List<TransactionSummary> getAccountSummaryByAccountNumber(String accountNumber) {

        String transactionType = "Credit";

        List<Transaction> transactions = new ArrayList<>(); // Repo call to get the transactions by accountNumber

        Map<Date, Map<String, Double>> dateWiseSummary =  transactions.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Transaction::getTransactionDate, Collectors.groupingBy(
                Transaction::getType,
                Collectors.summingDouble(Transaction::getAmount)
        )));

        //If account number also has to be considered
        Map<String, Map<Date, Map<String, Double>>> accountDateTypeSummary =
                transactions.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.groupingBy(
                                Transaction::getAccountNumber,  // Level 1: Account
                                Collectors.groupingBy(          // Level 2: Date
                                        Transaction::getTransactionDate,
                                        Collectors.groupingBy(      // Level 3: Type
                                                Transaction::getType,
                                                Collectors.summingDouble(Transaction::getAmount)
                                        )
                                )
                        ));


        return dateWiseSummary.entrySet().stream()
                .map(entry -> {
                    Date date = entry.getKey();
                    Map<String, Double> typeSummary = entry.getValue();
                    Double credit = typeSummary.getOrDefault("Credit", 0.0);
                    Double debit = typeSummary.getOrDefault("Debit", 0.0);
                    return new TransactionSummary(date, credit, debit);
                })
                .sorted(Comparator.comparing(TransactionSummary::getDate))
                .collect(Collectors.toList());
    }



    class Transaction {

        Double amount;
        Date transactionDate;
        String type;
        String accountNumber;

        public Date getTransactionDate() {
            return transactionDate;
        }

        public String getType() {
            return type;
        }

        public Double getAmount() {
            return amount;
        }

        public String getAccountNumber() {
            return accountNumber;
        }
    }

    class TransactionSummary {

        Date date;
        Double credit;
        Double debit;

        public TransactionSummary(Date date, Double credit, Double debit) {
            this.date = date;
            this.credit = credit;
            this.debit = debit;
        }

        public Date getDate() {
            return date;
        }

    }
}
