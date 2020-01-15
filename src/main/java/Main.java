import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDate day = LocalDate.now();
        LocalDate monthBefore = GetDateOfRate.getDayOfCurrency(day.minusMonths(1));
        day = GetDateOfRate.getDayOfCurrency(day);
        PrintToConsole.printToConsole(day, monthBefore);
    }
}
