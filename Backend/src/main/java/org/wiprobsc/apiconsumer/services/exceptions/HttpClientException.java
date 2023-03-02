package org.wiprobsc.apiconsumer.services.exceptions;

public class HttpClientException extends RuntimeException{
    public HttpClientException(String msg){
        super(msg);
    }
}
