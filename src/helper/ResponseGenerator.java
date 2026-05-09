package helper;

public class ResponseGenerator {
    public String generateResponse(String resource) {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<h1>Requested Resource: "
                + resource
                + "</h1>";
    }
}
