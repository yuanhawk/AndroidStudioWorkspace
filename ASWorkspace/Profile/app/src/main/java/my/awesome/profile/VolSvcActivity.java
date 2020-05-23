package my.awesome.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.my.profile.R;

public class VolSvcActivity extends AppCompatActivity {
    private String[] positionName, comName, svcDate, catName, descSvc;
    private TextView positionNameTV, comNameTV, svcDateTV, catNameTV, descSvcTV;

    private ListView volSvcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol_svc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Resources resources = getResources();
        positionName = resources.getStringArray(R.array.position_name);
        comName = resources.getStringArray(R.array.org_name);
        svcDate = resources.getStringArray(R.array.svc_date);
        catName = resources.getStringArray(R.array.cat_name);
        descSvc = resources.getStringArray(R.array.desc_svc);

        VolSvcAdapter adapter = new VolSvcAdapter(this, positionName, comName, svcDate, catName, descSvc);
        volSvcList.setAdapter(adapter);

        volSvcList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), VolSvcDetailActivity.class);
                showDetailActivity.putExtra("com.example.vol_svc.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });
    }

    private void initWidgets() {
        positionNameTV = (TextView) findViewById(R.id.positionName);
        comNameTV = (TextView) findViewById(R.id.comName);
        svcDateTV = (TextView) findViewById(R.id.svcDate);
        catNameTV = (TextView) findViewById(R.id.catName);
        descSvcTV = (TextView) findViewById(R.id.descriptionSvc);

        volSvcList = (ListView) findViewById(R.id.volSvcList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
