class CurrencyValueTableC {
    private String table;
    private String currency;
    private String code;
    private RatesTableC[] rates;

    RatesTableC[] getRates() {
        return rates;
    }
}
class RatesTableC {
    private String no;
    private String effectiveDate;
    private float bid;
    private float ask;

    float getBid() {
        return bid;
    }

    float getAsk() {
        return ask;
    }
}