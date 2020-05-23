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

public class EduDetailsActivity extends AppCompatActivity {

    private ImageView schoolLogo;
    private TextView schoolName, degName, studyDuration, activities, studyDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.education.ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImg(index);
            schoolLogo = (ImageView) findViewById(R.id.schoolLogoDet);
            scaleImg(schoolLogo, pic);

            String sch = getSchoolName(index);
            schoolName = (TextView) findViewById(R.id.schoolNameDet);
            schoolName.setText(sch);

            String deg = getDegName(index);
            degName = (TextView) findViewById(R.id.degNameDet);
            degName.setText(deg);

            String stu = getStudyDuration(index);
            studyDuration = (TextView) findViewById(R.id.studyDurationDet);
            studyDuration.setText(stu);

            String act = getActivities(index);
            activities = (TextView) findViewById(R.id.activitiesDet);
            activities.setText(act);

            String des = getStudyDescription(index);
            studyDesc = (TextView) findViewById(R.id.eduDescDet);
            studyDesc.setText(des);
        }
    }

    private int getImg(int index) {
        switch(index) {
            case 0: return R.drawable.img_sutd;
            case 1: return R.drawable.img_ri;
            case 2: return R.drawable.img_ri;
            default: return -1;
        }
    }

    private String getSchoolName(int index) {
        switch(index) {
            case 0: return "Singapore University of Technology and Design (SUTD)";
            case 1: return "Raffles Institution (Y5-6)";
            case 2: return "Raffles Institution (Y1-4)";
            default: return "";
        }
    }

    private String getDegName(int index) {
        switch(index) {
            case 0: return "Bachelor of Engineering - BE, Computer Science";
            case 1: return "Completion of A Level Examinations";
            case 2: return "Completion of Integrated Programme (IP) Track";
            default: return "";
        }
    }

    private String getStudyDuration(int index) {
        switch(index) {
            case 0: return "2019 - 2022";
            case 1: return "2015 - 2016";
            case 2: return "2011 - 2014";
            default: return "";
        }
    }

    private String getActivities(int index) {
        switch(index) {
            case 0: return "Student Government (ROOT) - Finance | Ballroom Dancing Club";
            case 1: return "Raffles Institution (Y5-6) Guitar Ensemble (RJGE)";
            case 2: return "Raffles Institution Red Cross (RIRC) | Y4 Peer Support Leader (PSL) | 2014 GAPSem";
            default: return "";
        }
    }

    private String getStudyDescription(int index) {
        switch(index) {
            case 0: return "An aspiring student aiming to join Information Systems Technology and Design (ISTD - Computer Science) Pillar.\n" +
                    "\n" +
                    "Part of SUTD’s student government (ROOT) – Finance, and my role involved managing transactional records and revenue generation. Some of the new projects undertaken includes: converting manual finance form checks to online form submissions, auto email generation, online form checkers and calculators and existing project undertaken: locker management.\n" +
                    "\n" +
                    "Participates in Ballroom Dancing as a second 5th Row and learned Waltz (Vals) and Tango.";
            case 1: return "Raffles Institution Guitar Ensemble, Year 5 – 6\n" +
                    "A classical musician who has performed at various events. External events include SYF Arts Presentation Guitar Ensemble (2015) and 10th Guitar Ensemble Festival (2016), and internal event include in public performance for school concert – Afinado as a soloist and ensemble player.";
            case 2: return "Integrated Programme (IP) track\n" +
                    "\n" +
                    "Raffles Institution Red Cross (RIRC), Year 1 – 4\n" +
                    "Training Specialist who plans and executes daily trainings. Oversees the planning and execution of 2013 Nov End-Of-Year Camp.\n" +
                    "\n" +
                    "Y4 Peer Support Leader (PSL)\n" +
                    "2014 Year 1 Orientation Camp - Adelphoi\n" +
                    "Part of the planning team of the Junior Rafflesian Investiture Ceremony (JRIC) for incoming Year 1 Investiture. Assumed the role of a peer support leader that saw the development of a class of Year 1 students over a period of 3 months.";
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
