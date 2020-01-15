public class CurrencyValue {
    private float currencyMid;
    private float currencyAsk;
    private float currencyBid;
    private float previousAsk;
    private float previousBid;

    public CurrencyValue() {
    }

    public CurrencyValue(float currencyMid, float currencyAsk, float currencyBid, float previousAsk, float previousBid) {

        this.currencyMid = currencyMid;
        this.currencyAsk = currencyAsk;
        this.currencyBid = currencyBid;
        this.previousAsk = previousAsk;
        this.previousBid = previousBid;
    }

    float getCurrencyMid() {
        return currencyMid;
    }

    void setCurrencyMid(float currencyMid) {
        this.currencyMid = currencyMid;
    }

    float getCurrencyAsk() {
        return currencyAsk;
    }

    void setCurrencyAsk(float currencyAsk) {
        this.currencyAsk = currencyAsk;
    }

    float getCurrencyBid() {
        return currencyBid;
    }

    void setCurrencyBid(float currencyBid) {
        this.currencyBid = currencyBid;
    }

    float getPreviousAsk() {
        return previousAsk;
    }

    void setPreviousAsk(float previousAsk) {
        this.previousAsk = previousAsk;
    }

    float getPreviousBid() {
        return previousBid;
    }

    void setPreviousBid(float previousBid) {
        this.previousBid = previousBid;
    }


}

