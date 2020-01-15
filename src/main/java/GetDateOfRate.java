import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

class GetDateOfRate {
    static LocalDate getDayOfCurrency(LocalDate day) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/usd/" + day + "?format=json");
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        int dayCount=1;
        while(huc.getResponseCode() != 200){//strona NBP jezeli wywołanie jest pozytywne ma kod 200, negatywne 404
            day = day.minusDays(1);
            url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/usd/" + day + "?format=json");
            huc = (HttpURLConnection) url.openConnection();
            if (dayCount==5){
                System.out.println("Please, check Your internet connection");
                break;
            }
            dayCount++;
        }
        return day;
    }
}
