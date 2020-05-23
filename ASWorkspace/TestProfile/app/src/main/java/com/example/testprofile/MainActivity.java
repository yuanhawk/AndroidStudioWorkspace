package com.example.testprofile;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] profile;
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();

        myListView = (ListView)findViewById(R.id.myListView);
        profile = resources.getStringArray(R.array.profile);
        description = resources.getStringArray(R.array.description);

        ProfileAdapter profileAdapter = new ProfileAdapter(this, profile, description);
        myListView.setAdapter(profileAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.testprofile.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });

    }
}
