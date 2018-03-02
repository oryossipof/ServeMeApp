package com.example.oryossipof.alphahotal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by or yossipof on 06/10/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    private static String typeToCheck = "";
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

       // String login_url = "http://10.0.2.2/security/fcm_insert.php";
       // String login_url = "http://192.168.14.157/ServerMeApp/login.php";
        String login_url = "http://servemeapp.000webhostapp.com//androidDataBaseQueries.php";
       // String notification_url = "http://securitymanagementapp.000webhostapp.com//send_notiofication.php";
        if (type.equals("login")) {
            typeToCheck = "login";
            try {
                String roomNum = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");

                /*********/
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                /************/

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_date = URLEncoder.encode("room_num", "UTF-8") + "=" + URLEncoder.encode(roomNum, "UTF-8")
                        + "&"+ URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
                        + "&"+ URLEncoder.encode("todo", "UTF-8") + "=" + URLEncoder.encode("login", "UTF-8");

                bufferedWriter.write(post_date);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (type.equals("questionnaires"))
        {
            typeToCheck = "questionnaires";
            String questionnaires_url = "http://servemeapp.000webhostapp.com//androidDataBaseQueries.php";
            try {
                String origin = params[1];
                String adult = params[2];
                String gender = params[3];
                String vegeterian = params[4];
                String vegan = params[5];
                String married = params[6];
                String children = params[7];
                String forPleasure = params[8];
                String isGroup = params[9];
                URL url = new URL(questionnaires_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");

                /*********/
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                /************/

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_date = URLEncoder.encode("origin", "UTF-8") + "=" + URLEncoder.encode(origin, "UTF-8")
                        + "&"+ URLEncoder.encode("adult", "UTF-8") + "=" + URLEncoder.encode(adult, "UTF-8")
                        + "&"+ URLEncoder.encode("gender", "UTF-8") + "=" + URLEncoder.encode(gender, "UTF-8")
                        + "&"+ URLEncoder.encode("vegeterian", "UTF-8") + "=" + URLEncoder.encode(vegeterian, "UTF-8")
                        + "&"+ URLEncoder.encode("vegan", "UTF-8") + "=" + URLEncoder.encode(vegan, "UTF-8")
                        + "&"+ URLEncoder.encode("married", "UTF-8") + "=" + URLEncoder.encode(married, "UTF-8")
                        + "&"+ URLEncoder.encode("children", "UTF-8") + "=" + URLEncoder.encode(children, "UTF-8")
                        + "&"+ URLEncoder.encode("forPleasure", "UTF-8") + "=" + URLEncoder.encode(forPleasure, "UTF-8")
                        + "&"+ URLEncoder.encode("isGroup", "UTF-8") + "=" + URLEncoder.encode(isGroup, "UTF-8")
                        + "&"+ URLEncoder.encode("todo", "UTF-8") + "=" + URLEncoder.encode("insertQuestionnaires", "UTF-8");

                bufferedWriter.write(post_date);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




            return null;

        }


        @Override
        protected void onPreExecute () {
          //  if (typeToCheck != "login")
           // {
                alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Login Status");
      //      }




        }

        @Override
        protected void onPostExecute (String result){
            if (typeToCheck != "login") {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else
            {
                Intent intent = new Intent("resultIntent");
                intent.putExtra("result", result);
                context.sendBroadcast(intent);
            }



        }

        @Override
        protected void onProgressUpdate (Void...values){
            super.onProgressUpdate(values);
        }
    }

