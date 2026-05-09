package helper;

public class RequestParser {
    public String parseRequest(String requestLine){

        if (requestLine==null){
            return "/";
        }
        String[] parts=requestLine.split(" ");
        return parts[1];

    }
}
