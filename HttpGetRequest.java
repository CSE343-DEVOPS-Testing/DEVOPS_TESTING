import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class HttpGetRequest {

    public static void main(String[] args) {
        try {
            String urlToGet = "Enter here a URL to get a JSON object";
            HttpGetRequest.getRequest(urlToGet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getRequest(String url) throws Exception {

        URL urlObj = new URL(url);
        HttpURLConnection myConnection = (HttpURLConnection) obj.openConnection();

        myConnection.setRequestMethod("GET");
        myConnection.setRequestProperty("User", "");

        BufferedReader contentReader = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
        String inputLine;
        StringBuffer tempStr = new StringBuffer();

        while ((inputLine = contentReader.readLine()) != null) {
            tempStr.append(inputLine);
        }

        contentReader.close();

        //System.out.println(tempStr.toString());

        JSONObject resultJson = new JSONObject(tempStr.toString());

        return resultJson;
    }

}
