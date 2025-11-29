import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try {
            makePostRequest();
        } catch (Exception e) {
            System.out.println("Error thrown into Main");
        }
    }
        static void makePostRequest(){
            try {
                // Set up the body data
                String message = "Hello servlet"; // The message to send the servlet
// Convert message string to bytes in UTF8 character format
                byte[] body = message.getBytes(StandardCharsets.UTF_8);

// Create a URL object that can send http requests to a link
                URL myURL = new URL("http://localhost:8080/MyServlet/patients");
                HttpURLConnection conn = null;

                conn = (HttpURLConnection) myURL.openConnection();// Set up the header
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept", "text/html");
                conn.setRequestProperty("charset", "utf-8");
                conn.setRequestProperty("Content-Length", Integer.toString(body.length));
                conn.setDoOutput(true);

// Write the bytes of the body
                try (OutputStream outputStream = conn.getOutputStream()) {
                    outputStream.write(body, 0, body.length);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

                String inputLine;
// Read the body of the response
                while ((inputLine = bufferedReader.readLine()) != null) {
                    System.out.println(inputLine);
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


            }





