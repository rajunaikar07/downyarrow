package com.example.downyarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final  int REQUEST_IMAGE_CAPTURE=1;
    EditText MobileNumber;
    Button call,browser,map;
    double latitude = 16.5428;
    double longitude = 81.5256;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileNumber = (EditText) findViewById(R.id.number);
        call = (Button) findViewById(R.id.callid);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str1 = MobileNumber.getText().toString();
                    if (str1.trim().equals(10)) {
                        Toast.makeText(MainActivity.this, "Plz Enter Number", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + str1));
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Calling", Toast.LENGTH_SHORT).show();
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        browser=(Button) findViewById(R.id.browserid);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.prabhas.com"));
                startActivity(Intent.createChooser(intent, "Title"));

            }
        });
        map=(Button) findViewById(R.id.mapid);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String label = "Srinu Area";

                String uriBegin = "geo:" + latitude + "," + longitude;

                String query = latitude + "," + longitude + "(" + label + ")";

                String encodedQuery = Uri.encode(query);

                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";


                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}