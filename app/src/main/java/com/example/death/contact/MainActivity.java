package com.example.death.contact;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    void call()
    {
      //  startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        final ArrayList<user> arrayList = new ArrayList<user>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(new user("Name"+i, " Number" + i));
        }
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String call = arrayList.get(i).number;
                String uri = "tel:" +call.trim();
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                Toast.makeText(getApplicationContext(),"Calling "+call,Toast.LENGTH_SHORT).show();
                call();
            }
        });

    }
}
