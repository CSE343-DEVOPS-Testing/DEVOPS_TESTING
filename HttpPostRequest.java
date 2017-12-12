import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class HttpPostRequest {

    public static void main(String[] args) {
        try {
            String urlToPost = "http://httpbin.org/post";
            JSONObject jObj = new JSONObject();
            HttpPostRequest.postRequest(urlToPost,jObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void postRequest(String url , JSONObject jsonObject ) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection myConnection = (HttpURLConnection) obj.openConnection();

        String jsonContent = jsonObject.toString();

        myConnection.setRequestMethod("POST");
        myConnection.setRequestProperty("Post-Type", "");
        myConnection.setRequestProperty("Post-Lenght",String.valueOf(jsonContent.getBytes().length));


        myConnection.setDoOutput(true);

        DataOutputStream writerToOut = new DataOutputStream(myConnection.getOutputStream());

        writerToOut.writeBytes(jsonContent);
        writerToOut.flush();
        writerToOut.close();

    }

}

