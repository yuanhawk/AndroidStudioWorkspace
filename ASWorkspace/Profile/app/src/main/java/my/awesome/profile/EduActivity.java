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

public class EduActivity extends AppCompatActivity {

    private String[] schoolName, degName, studyDuration, activities, description;
    private TextView schoolNameTV, degNameTV, studyDurationTV, activitiesTV, descriptionTV;

    private ListView eduList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Resources resources = getResources();
        schoolName = resources.getStringArray(R.array.school_name);
        degName = resources.getStringArray(R.array.deg_name);
        studyDuration = resources.getStringArray(R.array.study_duration);
        activities = resources.getStringArray(R.array.activities);
        description = resources.getStringArray(R.array.desc_sch);

        EduAdapter adapter = new EduAdapter(this, schoolName, degName, studyDuration, activities, description);
        eduList.setAdapter(adapter);

        eduList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), EduDetailsActivity.class);
                showDetailActivity.putExtra("com.example.education.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });
    }

    private void initWidgets() {
        schoolNameTV = (TextView) findViewById(R.id.schoolName);
        degNameTV = (TextView) findViewById(R.id.degName);
        studyDurationTV = (TextView) findViewById(R.id.studyDuration);
        activitiesTV = (TextView) findViewById(R.id.activities);
        descriptionTV = (TextView) findViewById(R.id.descriptionSch);

        eduList = (ListView) findViewById(R.id.eduList);
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
