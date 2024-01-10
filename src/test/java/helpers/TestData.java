package helpers;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestData {
    private static final String[] numberDaysToChoose = {"сутки", "двое суток", "трое суток", "четверо суток", "пятеро суток",
            "шестеро суток", "семеро суток"};
    private static final Faker faker = new Faker(new Locale("ru"));

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateAddress() {
        return faker.address().streetAddress();
    }

    public static String generatePhoneNumber() {
        return faker.numerify("+79#########");
    }

    public static String generateDate() {
        Date fakerDate = faker.date().future(1, TimeUnit.DAYS);
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        return dateFormat.format(fakerDate);
    }

    public static String chooseDaysNumber() {
        Random random = new Random();
        int index = random.nextInt(numberDaysToChoose.length);
        return numberDaysToChoose[index];
    }
}
