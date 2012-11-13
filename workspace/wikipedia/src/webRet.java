import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.*;




public class webRet {
	public static void submittingForm() throws Exception {
		URL url = new URL("http://en.wikipedia.org/wiki/Special:Random");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		Pattern p = Pattern.compile("href=\"/wiki/[a-zA-Z_]*\"");
		String inputLine;
		while((inputLine = in.readLine()) != null){

				Matcher a = p.matcher(inputLine);
				if(a.find()){
					System.out.println(a.group());
			}
		}
	}
	public static void main(String[] args){
		try {
			submittingForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
