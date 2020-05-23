package my.awesome.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.profile.R;

public class AchievementDetailActivity extends AppCompatActivity {

    private ImageView issuerLogo;
    private TextView awardName, issuerName, issuedDate, credID, awardDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.achievement.ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImg(index);
            issuerLogo = (ImageView) findViewById(R.id.issuerLogoDet);
            scaleImg(issuerLogo, pic);

            String awa = getAwardName(index);
            awardName = (TextView) findViewById(R.id.awardNameDet);
            awardName.setText(awa);

            String nam = getIssuerName(index);
            issuerName = (TextView) findViewById(R.id.issuerNameDet);
            issuerName.setText(nam);

            String dat = getIssuedDate(index);
            issuedDate = (TextView) findViewById(R.id.issuedDateDet);
            issuedDate.setText(dat);

            String cre = getCredID(index);
            credID = (TextView) findViewById(R.id.credIDDet);
            credID.setText(cre);

            String des = getAwardDesc(index);
            awardDesc = (TextView) findViewById(R.id.awardDescDet);
            awardDesc.setText(des);
        }
    }

    private int getImg(int index) {
        switch(index) {
            case 0: return R.drawable.img_tcl;
            case 1: return R.drawable.img_uowl;
            case 2: return R.drawable.img_jlpt;
            case 3: return R.drawable.img_hsk;
            case 4: return R.drawable.img_junctionx2019;
            default: return -1;
        }
    }

    private String getAwardName(int index) {
        switch(index) {
            case 0: return "Grade 7 Theory of Music";
            case 1: return "Diploma of the London College of Music (Classical Guitar) Performance";
            case 2: return "Japanese Language Proficiency Test JLPT N5";
            case 3: return "HSK Level 6";
            case 4: return "1st Prize Shopee Track - The Future of Smart Ecommerce";
            default: return "";
        }
    }

    private String getIssuerName(int index) {
        switch(index) {
            case 0: return "Trinity College London";
            case 1: return "University of West London";
            case 2: return "The Japan Foundation, Japan Educational Exchanges and Services";
            case 3: return "Confucius Institute Headquarters";
            case 4: return "Junction X Singapore";
            default: return "";
        }
    }

    private String getIssuedDate(int index) {
        switch(index) {
            case 0: return "Mar 2019";
            case 1: return "Dec 2018";
            case 2: return "Jan 2013";
            case 3: return "Sep 2012";
            case 4: return "27 Sep 2019 - 29 Sep 2019";
            default: return "";
        }
    }

    private String getCredID(int index) {
        switch(index) {
            case 0: return "501/2113/3";
            case 1: return "600/0639/0";
            case 2: return "12B2030101-50226";
            case 3: return "H61209029384";
            case 4: return "";
            default: return "";
        }
    }

    private String getAwardDesc(int index) {
        switch(index) {
            case 0: return "Awarded after completion of Theory of Music Grade 7 syllabus";
            case 1: return "Awarded after demonstrating a standard of performance consistent with a Level 1 (first-year) undergraduate performance recital.";
            case 2: return "Awarded after completion of Japanese N5 syllabus and able to understand simple Japanese conversational topics.";
            case 3: return "Awarded after completion of HSK Level 6, the highest proficiency for non-native Chinese speakers.";
            case 4: return "Developed a prototype: Aunty Amy Chatbot that serves to give a humane touch to ecommerce platform. The duration of the hackathon lasted for 40+h.";
            default: return "";
        }
    }

    private void scaleImg(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
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
