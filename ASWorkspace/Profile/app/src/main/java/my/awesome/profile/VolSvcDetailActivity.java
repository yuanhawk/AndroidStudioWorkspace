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

public class VolSvcDetailActivity extends AppCompatActivity {

    private ImageView comLogo;
    private TextView posName, comName, svcDate, catName, volSvcDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol_svc_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.vol_svc.ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImg(index);
            comLogo = (ImageView) findViewById(R.id.comLogoDet);
            scaleImg(comLogo, pic);

            String pos = getPositionName(index);
            posName = (TextView) findViewById(R.id.posNameDet);
            posName.setText(pos);

            String nam = getOrganisationName(index);
            comName = (TextView) findViewById(R.id.comNameDet);
            comName.setText(nam);

            String dat = getServiceDate(index);
            svcDate = (TextView) findViewById(R.id.svcDateDet);
            svcDate.setText(dat);

            String cat = getCategoryName(index);
            catName = (TextView) findViewById(R.id.catNameDet);
            catName.setText(cat);

            String des = getServiceDesc(index);
            volSvcDesc = (TextView) findViewById(R.id.volSvcDescDet);
            volSvcDesc.setText(des);
        }
    }

    private int getImg(int index) {
        switch(index) {
            case 0: return R.drawable.img_yec;
            case 1: return R.drawable.img_yec;
            default: return -1;
        }
    }

    private String getPositionName(int index) {
        switch(index) {
            case 0: return "Community Engagement Programme (C2E) Secretary";
            case 1: return "Executive Member";
            default: return "";
        }
    }

    private String getOrganisationName(int index) {
        switch(index) {
            case 0: return "Hwi Yoh Community Centre Youth Executive Committee";
            case 1: return "Hwi Yoh Community Centre Youth Executive Committee";
            default: return "";
        }
    }

    private String getServiceDate(int index) {
        switch(index) {
            case 0: return "Sep 2015 - Sep 2017";
            case 1: return "Sep 2017 - Present";
            default: return "";
        }
    }

    private String getCategoryName(int index) {
        switch(index) {
            case 0: return "Social Services";
            case 1: return "Social Services";
            default: return "";
        }
    }

    private String getServiceDesc(int index) {
        switch(index) {
            case 0: return "Assumed the role of Community Engagement Programme (C2E) Secretary in Hwi Yoh CC YEC. Involved in planning and executing community programmes, 2016 Lunar New Year Lunch for the Elderly, and volunteered at emergency preparedness events. Some other events that I have volunteered at: KidsRead Programme, YOUTHSpeak on Budget, annual bursary/scholarship awarding events, etc.";
            case 1: return "Avid volunteer at various events during military service: 2018 Lunar New Year Lunch, 2018 Jalan Kayu Day, 2018 Halloween Event, etc. Planned the first Japanese Summer Festival (Nippon Matsuri) and Anime Film Festival (2019) for the Hwi Yoh community.";
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
