package com.khandani.silverglobesolutions.cazzysimple_networking;

/**
 * Created by silverglobesolutions on 25/10/17.
 */

public class ServerResponseWrapper {

   public String response;
    public  boolean isSuccess;

    public static ServerResponseWrapper sendResponse(String msg, boolean isSuccess){
        ServerResponseWrapper responseWrapper = new ServerResponseWrapper();
        responseWrapper.response = msg;
        responseWrapper.isSuccess = isSuccess;
        return  responseWrapper;

    }

}


