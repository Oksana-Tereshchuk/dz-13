package dataproviders;

import models.Account;
import org.testng.annotations.DataProvider;

import static utils.CsvReader.getListObjectsFromCsv;
import static utils.JDBCReader.getAccountsFromDB;

public class TestDataProvider {
    private static final String PATH = "src\\test\\resources\\data.csv";
    //private static final String PATH_ANOTHER = "src\\test\\resources\\dataAnother.csv";

    @DataProvider(name = "accounts")
    public static Object[][] accounts() {
        return getListObjectsFromCsv(PATH, Account.class).stream().map(account -> new Object[]{account.getNum1(), account.getNum2()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "accountsDB")
    public static Object[][] accountsFromDB() {
        return getAccountsFromDB().stream().map(account -> new Object[]{account.getNum1(), account.getNum2()})
                .toArray(Object[][]::new);
    }
    
    @DataProvider(name = "symbols")
    public static Object[][] symbols() {
        return new Object[][]{{1, 1}, {2, 2}, {3, 7}};
    }

}