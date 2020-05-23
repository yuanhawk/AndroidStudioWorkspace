package my.awesome.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.profile.R;

public class IntNHobbiesActivity extends AppCompatActivity {

    private CardView comSvcCardView, guitarCardView;
    private ImageView comSvcImg, guitarImg;
    private TextView comPlanTxt,guitarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_int_nhobbies);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();
    }

    private void initWidgets(){
        comSvcCardView = (CardView) findViewById(R.id.comSvcCardView);
        guitarCardView = (CardView) findViewById(R.id.guitarCardView);

        comSvcImg = (ImageView) findViewById(R.id.comSvcImg);
        guitarImg = (ImageView) findViewById(R.id.guitarImg);

        comPlanTxt = (TextView) findViewById(R.id.comPlanTxt);
        guitarTxt = (TextView) findViewById(R.id.guitarTxt);
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
