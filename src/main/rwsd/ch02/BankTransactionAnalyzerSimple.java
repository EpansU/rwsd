package main.rwsd.ch02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/rwsd/resources/";

    public static void main(final String... args) throws IOException {

        final BankstatementCSVParser bankstatementParser = new BankstatementCSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankstatementParser.parseLinesFromCSV(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        System.out.println("The total from all transactions is " + bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total from January transactions is " + bankStatementProcessor.totalFromMonth(Month.JANUARY) );
    }
}
