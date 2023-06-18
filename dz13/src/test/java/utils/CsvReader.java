package utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReader {
    private static final String PATH = "src\\test\\resources\\data.csv";
    public static List<Account> getListObjectsFromCsv(String path, Class<Account> accountClass) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH));
            CsvToBean<Account> csvObjectBuilder = new CsvToBeanBuilder<Account>(reader)
                    .withType(Account.class)
                    .build();
            return csvObjectBuilder.parse();
        } catch (IOException ex) {
            throw new RuntimeException("The file could not be found" + PATH + ex);
        }
    }
}