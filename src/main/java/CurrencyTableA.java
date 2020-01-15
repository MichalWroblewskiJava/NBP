class CurrencyValueTableA {
    private String table;
    private String currency;
    private String code;
    private RateTableA[] rates;

    RateTableA[] getRates() {
        return rates;
    }
}
class RateTableA {
    private String no;
    private String effectiveDate;
    private float mid;

    float getMid() {
        return mid;
    }
}