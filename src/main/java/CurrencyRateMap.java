import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

class CurrencyRateMap {
    static Map<String, CurrencyValue> setCurrencyValues(LocalDate today, LocalDate monthBefore) throws IOException {
        String[] currenciesCode = {"usd", "aud", "cad", "eur", "huf", "chf", "gbp", "jpy", "czk", "dkk", "nok", "sek", "xdr"};
        Map<String, CurrencyValue> currencies = new LinkedHashMap<String, CurrencyValue>();

        for (String currencyCode : currenciesCode) {
            URL urlNBP = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode + "/" + today + "?format=json");
            RatesTableC[] askBid = ReadURL.readAskBidURL(urlNBP);

            URL urlNBPmid = new URL("http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode + "/" + today + "?format=json");
            RateTableA[] mid = ReadURL.readMidURL(urlNBPmid);

            URL urlNBPprevious = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode + "/" + monthBefore + "?format=json");
            RatesTableC[] askBidPrevious = ReadURL.readAskBidURL(urlNBPprevious);

            CurrencyValue currencyValue = new CurrencyValue();
            currencyValue.setCurrencyAsk(askBid[0].getAsk());
            currencyValue.setCurrencyBid(askBid[0].getBid());
            currencyValue.setCurrencyMid(mid[0].getMid());
            currencyValue.setPreviousAsk(askBidPrevious[0].getAsk());
            currencyValue.setPreviousBid(askBidPrevious[0].getBid());

            currencies.put(currencyCode, currencyValue);
        }
        return currencies;
    }
}
