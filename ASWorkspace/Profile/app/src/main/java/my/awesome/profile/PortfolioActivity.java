package my.awesome.profile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.my.profile.R;

public class PortfolioActivity extends AppCompatActivity {

    private static final String TAG = "PortfolioActivity";

    private Button linkedInBtn, gitHubBtn, myBlogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();

        linkedInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                AlertDialog.Builder builder = new AlertDialog.Builder(PortfolioActivity.this)
                        .setTitle("Going to LinkedIn Website")
                        .setMessage("\n\nWould you like to proceed to my LinkedIn Account")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(PortfolioActivity.this, MyWebActivity.class);
                                intent.putExtra("url", "https://www.linkedin.com/in/tanliyuanmarcus/");
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

        gitHubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                AlertDialog.Builder builder = new AlertDialog.Builder(PortfolioActivity.this)
                        .setTitle("Going to LinkedIn Website")
                        .setMessage("\n\nWould you like to proceed to my GitHub Account")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(PortfolioActivity.this, MyWebActivity.class);
                                intent.putExtra("url", "https://github.com/yuanhawk");
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

        myBlogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                AlertDialog.Builder builder = new AlertDialog.Builder(PortfolioActivity.this)
                        .setTitle("Going to My Blog")
                        .setMessage("\n\nWould you like to proceed to my blog")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(PortfolioActivity.this, MyWebActivity.class);
                                intent.putExtra("url", "https://tyuanhawkguitar.wordpress.com/");
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

    private void initWidgets() {
        linkedInBtn = (Button) findViewById(R.id.linkedInBtn);
        gitHubBtn = (Button) findViewById(R.id.gitHubBtn);
        myBlogBtn = (Button) findViewById(R.id.myBlogBtn);
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
