package my.awesome.profile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.my.profile.R;

public class MainActivity extends AppCompatActivity {
    //TODO: Craft Out Designs for the next few layouts

    private static final String TAG = "MainActivity";
    private TextView introText, abtMeTxt, workExpTxt, eduTxt, portfolioTxt, listAchieveTxt, volSvcTxt, intNHobbiesTxt, networkAppTxt;
    private CardView abtMeCardView, workExpCardView, eduCardView, portfolioCardView, achieveCardView, volSvcCardView, intNHobbiesCardView, networkCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setOnClickListener();
    }

    public void initWidgets() {
        introText = (TextView) findViewById(R.id.introText);
        abtMeTxt = (TextView) findViewById(R.id.abtMeTxt);
        workExpTxt = (TextView) findViewById(R.id.workExpTxt);
        eduTxt = (TextView) findViewById(R.id.eduTxt);
        portfolioTxt = (TextView) findViewById(R.id.portfolioTxt);
        listAchieveTxt = (TextView) findViewById(R.id.listAchieveTxt);
        volSvcTxt = (TextView) findViewById(R.id.volSvcTxt);
        intNHobbiesTxt = (TextView) findViewById(R.id.intNHobbiesTxt);
        networkAppTxt = (TextView) findViewById(R.id.networkAppTxt);


        abtMeCardView = (CardView) findViewById(R.id.abtMeCardView);
        workExpCardView = (CardView) findViewById(R.id.workExpCardView);
        eduCardView = (CardView) findViewById(R.id.eduCardView);
        portfolioCardView = (CardView) findViewById(R.id.portfolioCardView);
        achieveCardView = (CardView) findViewById(R.id.achieveCardView);
        volSvcCardView = (CardView) findViewById(R.id.volSvcCardView);
        intNHobbiesCardView = (CardView) findViewById(R.id.intNHobbiesCardView);
        networkCardView = (CardView) findViewById(R.id.networkCardView);
    }

    public void setOnClickListener() {

        abtMeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });

        workExpCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                Intent intent = new Intent(MainActivity.this, WorkExpActivity.class);
                startActivity(intent);

            }
        });

        eduCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                Intent intent = new Intent(MainActivity.this, EduActivity.class);
                startActivity(intent);
            }
        });

        portfolioCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                Intent intent = new Intent(MainActivity.this, PortfolioActivity.class);
                startActivity(intent);
            }
        });

        achieveCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                Intent intent = new Intent(MainActivity.this, AchievementActivity.class);
                startActivity(intent);
            }
        });

        volSvcCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                Intent intent = new Intent(MainActivity.this, VolSvcActivity.class);
                startActivity(intent);
            }
        });

        intNHobbiesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                Intent intent = new Intent(MainActivity.this, IntNHobbiesActivity.class);
                startActivity(intent);
            }
        });

        networkCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("App Version 1.0 Unnamed")
                        .setMessage("\nNetworking in Progress... App Building in Progress :-)")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();
            }
        });
    }
}
