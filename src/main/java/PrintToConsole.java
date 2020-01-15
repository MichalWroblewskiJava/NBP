import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

class PrintToConsole {
    static void printToConsole(LocalDate today, LocalDate monthBefore) throws IOException {
        Map<String, CurrencyValue> currencies = CurrencyRateMap.setCurrencyValues(today, monthBefore);
        System.out.printf("%70s", "----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.printf("%10s %12s %12s %12s %12s %12s %12s", "Date", today, today, today, monthBefore, monthBefore, "Strata/");
        System.out.println();
        System.out.printf("%10s %12s %12s %12s %12s %12s %12s", "Currency", "ASK", "BID", "MID", "ASK", "BID", "Zysk w PLN");
        System.out.println();
        System.out.printf("%70s", "----------------------------------------------------------------------------------------");
        System.out.println();
        for (Map.Entry<String, CurrencyValue> currency : currencies.entrySet()) {
            String currencyCode = currency.getKey();

            float currencyAsk = currency.getValue().getCurrencyAsk();
            float currencyBid = currency.getValue().getCurrencyBid();
            float currencyMid = currency.getValue().getCurrencyMid();
            float previousAsk = currency.getValue().getPreviousAsk();
            float previousBid = currency.getValue().getPreviousBid();

            float howMuchCurrency = 100 / previousAsk;
            float sellCurrencyNow = howMuchCurrency * currencyBid;
            float incomeLose = sellCurrencyNow - 100;
            System.out.format("%10S %12s %12s %12s %12s %12s %12s", currencyCode, currencyAsk, currencyBid, currencyMid, previousAsk, previousBid, incomeLose);
            System.out.println();
            System.out.printf("%70s", "----------------------------------------------------------------------------------------");
            System.out.println();
        }
    }
}
