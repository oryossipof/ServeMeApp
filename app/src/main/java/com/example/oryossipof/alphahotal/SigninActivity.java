package com.example.oryossipof.alphahotal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SigninActivity extends Activity {
private Button loginBT;
private  BackgroundWorker backgroundWorker;
    private EditText roomNum, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signin);

        loginBT = (Button) findViewById(R.id.signinBT);
        password = (EditText) findViewById(R.id.passInput);
        roomNum = (EditText) findViewById(R.id.roomNumInput);
        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (!validate())
                    return;
                String type = "login";
                backgroundWorker = new BackgroundWorker(SigninActivity.this);
                backgroundWorker.execute(type,roomNum.getText().toString(),password.getText().toString());
                registerReceiver(new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        String result = (String)intent.getExtras().getString("result");


                        //alertDialog.show();


                        if(result.equals("login success"))
                        {
                            Intent intent1 = new Intent(SigninActivity.this, questionnairesActivity.class);
                            startActivity(intent1);
                            try {
                                this.finalize();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }
                            finish();
                        }

                        else
                        {
                            AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                            alertDialog.setTitle("Login Result");
                            alertDialog.setMessage(result);
                            alertDialog.show();
                        }
                    }
                }, new IntentFilter("resultIntent"));
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String roomId = roomNum.getText().toString();

        if(roomId.isEmpty()) {
            roomNum.setError("can't be empty");
            valid = false;
        }
        else {
            roomNum.setError(null);
        }

        String pass= password.getText().toString();
        if(pass.isEmpty()) {
            password.setError("can't be empty");
            valid = false;
        }
        else {
            password.setError(null);
        }

        return valid;
    }

}
