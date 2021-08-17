package com.send.email.proxy;

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendEmailImplProxy {

	// public void sendEmail(String myEmail, String toEmail, String subject, String
	// body) {
	@Before("execution(public void sendEmail(String, String, String, String))")
	public void sendEmail() {
		System.out.println("proxy object is called");
//		RestTemplate restTemplate=new RestTemplate();
/*
		//		restTemplate.getForObject("http://localhost:8082/actuator/refresh","Refresh has been called");

//	    HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity entity = new HttpEntity(headers);
	      
	      restTemplate.exchange(
	         "http://localhost:8082/actuator/refresh", HttpMethod.POST,null , String.class).getBody();

	      //	      restTemplate.ca(
//	 	         "http://localhost:8082/actuator/refresh", HttpMethod.POST, entity, String.class).getBody();
	 
	   */   
	      
//	      Map<String, String> map = new HashMap<>();
	      
//	       restTemplate.exchange(
//	         "http://localhost:8082/actuator/refresh", HttpMethod.POST, entity, String.class).getBody();
//	        restTemplate.postForObject("http://localhost:8082/actuator/refresh", map, Void.class);
 
try {
//	        HttpClient httpclient = HttpClients.createDefault();
//	        HttpPost httppost = new HttpPost("http://localhost:8082/actuator/refresh");

	        // Request parameters and other properties.
//	        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//	        params.add(new BasicNameValuePair("param-1", "12345"));
//	        params.add(new BasicNameValuePair("param-2", "Hello!"));
//	        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

	        //Execute and get the response.
//	        HttpResponse response = httpclient.execute(httppost);
//	        HttpEntity entity = response.getEntity();

//	URL url=new URL("http://localhost:8082/actuator/refresh");
//	HttpURLConnection con=(HttpURLConnection)url.openConnection();
//	con.setRequestMethod("POST");
//	con.setDoOutput(true);
	
 

//	RestTemplate restTemplate = new RestTemplate();
//	String fooResourceUrl
//	  = "http://localhost:8082/actuator/refresh";
//	ResponseEntity<String> response = restTemplate.execute(fooResourceUrl,HttpMethod.POST,null,null , String.class);
////	assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//	
	/*
	URL url = new URL("http://localhost:8082/actuator/refresh");
	URLConnection con = url.openConnection();
	HttpURLConnection http = (HttpURLConnection)con;
	http.setRequestMethod("POST"); // PUT is another valid option
	http.setDoOutput(true);
*/
//    sendPost();

	String rawData = "id=10";
	String type = "application/x-www-form-urlencoded";
	String encodedData = URLEncoder.encode( rawData, "UTF-8" ); 
	URL u = new URL("http://localhost:8082/actuator/refresh");
	HttpURLConnection conn = (HttpURLConnection) u.openConnection();
	conn.setDoOutput(true);
	conn.setRequestMethod("POST");
//	conn.setRequestProperty( "Content-Type", type );
//	conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
	OutputStream os = conn.getOutputStream();
	os.write(encodedData.getBytes());



}catch(Exception e) {
	e.printStackTrace();
}
	
	
	


	}

	
	 private final CloseableHttpClient httpClient = HttpClients.createDefault();

 	    private void close() throws IOException {
	        httpClient.close();
	    }
	
	 private void sendPost() throws Exception {

	        HttpPost post = new HttpPost("http://localhost:8082/actuator/refresh");

	        // add request parameter, form parameters
//	        List<NameValuePair> urlParameters = new ArrayList<>();
//	        urlParameters.add(new BasicNameValuePair("username", "abc"));
//	        urlParameters.add(new BasicNameValuePair("password", "123"));
//	        urlParameters.add(new BasicNameValuePair("custom", "secret"));

//	        post.setEntity(new UrlEncodedFormEntity(urlParameters));

	        try (CloseableHttpClient httpClient = HttpClients.createDefault();
	             CloseableHttpResponse response = httpClient.execute(post)) {

	            System.out.println(EntityUtils.toString(response.getEntity()));
	        }

	    
	 
	 
	 }


		private static final String POST_URL = "http://localhost:8082/actuator/refresh";
		
	 private static void sendPOST() throws IOException {
			URL obj = new URL(POST_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");

			// For POST only - START
			con.setDoOutput(true);
			
			OutputStream os = con.getOutputStream();
//			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			// For POST only - END

			int responseCode = con.getResponseCode();
			System.out.println("POST Response Code :: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
			} else {
				System.out.println("POST request not worked");
			}
		}
}
