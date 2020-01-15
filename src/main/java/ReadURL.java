import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

class ReadURL {
    private static final Gson GSON = new Gson();

    static RatesTableC[] readAskBidURL(URL url) throws IOException {
        String total = readFromURL(url);
        return GSON.fromJson(total, CurrencyValueTableC.class).getRates();
    }

    static RateTableA[] readMidURL(URL url) throws IOException {
        String total = readFromURL(url);
        return GSON.fromJson(total, CurrencyValueTableA.class).getRates();
    }

    private static String readFromURL(URL url) throws IOException {
        Scanner scan = new Scanner(url.openStream());
        StringBuilder total = new StringBuilder();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            total.append(line).append(" ");
        }
        scan.close();
        return total.toString();
    }
}