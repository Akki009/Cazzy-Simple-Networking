package com.cazzy.cazzysimplenetworking.Networking;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by silverglobesolutions on 25/10/17.
 */


public class Http_request {






    public static void sendPostRequest(final String EndpointURL, final String param, final ResponseHandler response) {


        class PostRequestAsync extends AsyncTask<Void,Void,ServerResponseWrapper>{

            @Override
            protected ServerResponseWrapper doInBackground(Void... voids) {
                URL url = null;
                HttpURLConnection urlConnection = null;


                try {
                    url = new URL(EndpointURL);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setDoOutput(true);
                    urlConnection.setDoInput(true);
                    urlConnection.setUseCaches(false);
                    urlConnection.setReadTimeout(10000);
                    urlConnection.setConnectTimeout(15000);
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    //hulle

                   


                    OutputStream os = urlConnection.getOutputStream();


                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(param);

                    writer.flush();
                    writer.close();
                    os.close();


                    int responseCode = urlConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder();
                    if (responseCode == HttpsURLConnection.HTTP_OK) {

                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        sb = new StringBuilder();
                        String response;
                        //Reading server response
                        while ((response = br.readLine()) != null) {

                            sb.append(response);
                        }
                        br.close();
                    }

                    return ServerResponseWrapper.sendResponse(sb.toString(),true);

                } catch (Exception e) {
                    return ServerResponseWrapper.sendResponse(e.getLocalizedMessage(),true);

                } finally {
                    urlConnection.disconnect();
                }

            }

            @Override
            protected void onPostExecute(ServerResponseWrapper s) {
                super.onPostExecute(s);
                response.getResponse(s);

            }
        }

        new PostRequestAsync().execute();


    }

    public static void sendGetRequest(final String EndpointURL, final ResponseHandler response) {


         class GetRequestAsync extends AsyncTask<Void, Integer, ServerResponseWrapper> {


             @Override
             protected ServerResponseWrapper doInBackground(Void... voids) {

                 HttpURLConnection httpURLConnection = null;
                 try {

                     URL url = new URL(EndpointURL);


                     httpURLConnection = (HttpURLConnection) url.openConnection();
                     httpURLConnection.setReadTimeout(10000);
                     httpURLConnection.setConnectTimeout(15000);
                     httpURLConnection.setRequestMethod("GET");
                     httpURLConnection.setDoInput(true);
                     httpURLConnection.setUseCaches(false);
                     httpURLConnection.connect();

                     int responseCode = httpURLConnection.getResponseCode();
                     StringBuilder sb = new StringBuilder();
                     if (responseCode == HttpsURLConnection.HTTP_OK) {

                         BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                         sb = new StringBuilder();
                         String response;

                         while ((response = br.readLine()) != null) {

                             sb.append(response);
                         }
                         br.close();
                     }

                     return ServerResponseWrapper.sendResponse(sb.toString(),true);




                 } catch (Exception e) {

                     return ServerResponseWrapper.sendResponse(e.getLocalizedMessage(),false);

                 } finally {

                     httpURLConnection.disconnect();

                 }
             }

             @Override
             protected void onPostExecute(ServerResponseWrapper serverResponseWrapper) {
                 super.onPostExecute(serverResponseWrapper);
                response.getResponse(serverResponseWrapper);
             }
         }
        new GetRequestAsync().execute();

    }


}
