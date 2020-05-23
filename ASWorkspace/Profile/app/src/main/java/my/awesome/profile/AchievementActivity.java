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

public class AchievementActivity extends AppCompatActivity {

    private String[] awardName, issuerName, issuedDate, credID, descAward;
    private TextView awardNameTV, issuerNameTV, issuedDateTv, credIDTV, descAwardTV;

    private ListView awardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Resources resources = getResources();
        awardName = resources.getStringArray(R.array.award_name);
        issuerName = resources.getStringArray(R.array.issuer_name);
        issuedDate = resources.getStringArray(R.array.issued_date);
        credID = resources.getStringArray(R.array.cred_id);
        descAward = resources.getStringArray(R.array.desc_award);

        AchievementAdapter adapter = new AchievementAdapter(this, awardName, issuerName, issuedDate, credID, descAward);
        awardList.setAdapter(adapter);

        awardList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), AchievementDetailActivity.class);
                showDetailActivity.putExtra("com.example.achievement.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });
    }

    private void initWidgets() {
        awardNameTV = (TextView) findViewById(R.id.awardName);
        issuerNameTV = (TextView) findViewById(R.id.issuerName);
        issuedDateTv = (TextView) findViewById(R.id.issuedDate);
        credIDTV = (TextView) findViewById(R.id.credID);
        descAwardTV = (TextView) findViewById(R.id.descriptionAward);

        awardList = (ListView) findViewById(R.id.awardList);
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
