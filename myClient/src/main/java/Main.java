import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try {
            makeRequest();
        } catch (Exception e) {
            System.out.println("Error thrown into Main");
        }
    }
    static void makeRequest(){
                    try {
                        URL myURL = new URL("http://localhost:8080/Ex5_Servlet_Groovy/doctors");
                        HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Accept", "text/html");
                        conn.setRequestProperty("charset", "utf-8");

                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(myURL.openStream()));

                        String inputLine;
// Read the body of the response
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println(inputLine);
                        }
                        in.close();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }





