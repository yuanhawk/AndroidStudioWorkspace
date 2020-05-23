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

public class WorkExpDetailActivity extends AppCompatActivity {

    private ImageView companyLogo;
    private TextView position, companyName, workDuration, workDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_exp_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.profile.ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImg(index);
            companyLogo = (ImageView) findViewById(R.id.companyLogoDet);
            scaleImg(companyLogo, pic);

            String pos = getPosition(index);
            position = (TextView) findViewById(R.id.positionDet);
            position.setText(pos);

            String com = getCompanyName(index);
            companyName = (TextView) findViewById(R.id.companyNameDet);
            companyName.setText(com);

            String wor = getWorkDuration(index);
            workDuration = (TextView) findViewById(R.id.workDurationDet);
            workDuration.setText(wor);

            String des = getDescription(index);
            workDesc = (TextView) findViewById(R.id.workDescDet);
            workDesc.setText(des);
        }

    }

    private int getImg(int index) {
        switch(index) {
            case 1: return R.drawable.img_indigo;
            case 2: return R.drawable.img_saf;
            case 3: return R.drawable.img_indigo;
            default: return -1;
        }
    }

    private String getPosition(int index) {
        switch(index) {
            case 0: return "Music Teacher";
            case 1: return "Data Entry Assistant";
            case 2: return "CBRE (E) Pioneer";
            case 3: return "Intern";
            default: return "";
        }
    }

    private String getCompanyName(int index) {
        switch(index) {
            case 0: return "Avant Garde Promotions";
            case 1: return "Indigo Education Group";
            case 2: return "Singapore Armed Forces (SAF)";
            case 3: return "Indigo Education Group";
            default: return "";
        }
    }

    private String getWorkDuration(int index) {
        switch(index) {
            case 0: return "Jan 2019 - May 2019 | 5 months";
            case 1: return "Nov 2018 - Feb 2019 | 4 months";
            case 2: return "Jan 2017 - Nov 2018 | 1 year 11 months";
            case 3: return "Dec 2016 | 1 month";
            default: return "";
        }
    }

    private String getDescription(int index) {
        switch(index) {
            case 0: return "Instructs guitar ensembles on classical guitar techniques and ensemble skills, such as sight-reading, positional melodic playing, tremolos, pizzicatos, and staccatos. Instructed at St. Joseph Institution and taught as a relief music teacher in several other schools. Conducted private music classes.";
            case 1: return "Led a team of essay markers and organised essay results into data used for analysis to improve the performance of students in their respective school examinations. Maintained the timetable and schedules of the company website. Involved in worksheet formatting, market research, and gathering data and feedback as ad hoc roles.";
            case 2: return "Actively involved as an operational trooper in security missions (Trump – Kim summit and Shangri-la Dialogue, etc). Consolidated large amount of EOD technical knowledge and experience as a dual vocational engineer.";
            case 3: return "Created secondary Integrated Programme (IP) Mathematics resources for various levels and digitised General Paper and IP essays. Collated and digitised survey and testimonials from ‘A’ Level students. Modified the formats of worksheets from various subjects (Mathematics, GP and IP English).";
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
