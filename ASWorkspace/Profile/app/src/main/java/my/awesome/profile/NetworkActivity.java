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
import android.widget.ImageView;

import com.my.profile.R;

public class NetworkActivity extends AppCompatActivity {

    private static final String TAG = "NetworkActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView qrCode = (ImageView) findViewById(R.id.qrCode); 
        Button linkedIn = (Button) findViewById(R.id.linkedInLink);

        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: started");
                AlertDialog.Builder builder = new AlertDialog.Builder(NetworkActivity.this)
                        .setTitle("Going to LinkedIn Website")
                        .setMessage("\n\nWould you like to proceed to my LinkedIn Account")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(NetworkActivity.this, MyWebActivity.class);
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
