package com.example.sendemailhtml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.buttonSend);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    public void sendMail()
    {
        new MailCreator().execute("");
    }

    public class MailCreator extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            try {

                MailSender sender = new MailSender(getBaseContext(), "info.gespark@gespark.pt","3xSMg8nSgUNB");
                sender.sendUserDetailWithImage("Android Mail Test", "Hi", "GesPark",
                        "nunomcfrancisco@gmail.com", "Himanshu Verma", "xyz@gmail.com", "+91 6075959010", "02/02/1994", "25","New Delhi, India","");

            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Toast.makeText(getActivity(),"Mail Sent",Toast.LENGTH_LONG).show();
        }
    }
}
