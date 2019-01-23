import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class _URL {

	final static String clientId = "clientId";
	final static String clientSecret = "clientSecret";

	private String parsing(StringBuffer response) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = (JsonObject) jsonParser.parse(response.toString());
		JsonObject object = (JsonObject) jsonObj.get("result");

		return object.get("url").toString();
	}

	String shortCut(String text) {
		StringBuffer response = new StringBuffer();
		try {
			String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + text;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200)
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			else
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return parsing(response);
	}

}
