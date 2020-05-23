package my.awesome.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.profile.R;

public class AboutMeActivity extends AppCompatActivity {

    private ImageView profileImg;
    private TextView myName, myTitle, myContact, aboutMe, toPortfolioTxt;
    private CardView toPortfolioCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();
        myName.setText("Tan Li Yuan");
        myTitle.setText("First Year Undergraduate Student (Freshmore) SUTD");
        myContact.setText("LinkedIn: linkedin.com/in/tanliyuanmarcus\nEmail: liyuan_tan@mymail.sutd.edu.sg\nBlog: tyuanhawkguitar.wordpress.com\nGitHub: github.com/yuanhawk");
        aboutMe.setText("A conscientious person who has displayed perseverance and patience in his quest for knowledge. Ability to be a team player and has the patience and willingness to help his peers and juniors of his CCA. Successfully planned and executed community projects with a heart to serve the community. Perseveres through difficulties and resolute in achieving excellence in all that he undertakes.");

        toPortfolioCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutMeActivity.this, PortfolioActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initWidgets() {
        profileImg = (ImageView) findViewById(R.id.profileImg);

        myName = (TextView) findViewById(R.id.myName);
        myTitle = (TextView) findViewById(R.id.myTitle);
        myContact = (TextView) findViewById(R.id.myContact);
        aboutMe = (TextView) findViewById(R.id.aboutMe);
        toPortfolioTxt = (TextView) findViewById(R.id.toPortfolioTxt);

        toPortfolioCardView = (CardView) findViewById(R.id.toPortfolioCardView);
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
