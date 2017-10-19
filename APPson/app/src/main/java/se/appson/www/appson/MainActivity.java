package se.appson.www.appson;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView textName;
    private TextView descriptionText;


    JobSeekerTestDb seeker = new JobSeekerTestDb();
    public ArrayList<Profile> profile = seeker.profiles;


    Handler btn = new Handler();


    static int i = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = (TextView) findViewById(R.id.nameTextView);
        descriptionText = (TextView) findViewById(R.id.description_textView);
        profileImage = (ImageView) findViewById(R.id.profileImage);
        this.profileImage.setImageResource(R.drawable.app);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);

        return true;
    }


    public void onOptionItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_setting) {
            // OLD Intent intent = new Intent(this, SettingsActivity.class);
            Intent intent = new Intent(this, settings.class);
            startActivity(intent);
        }
    }


    public void nextProfile(View view) {

        Runnable next = new Runnable() {
            @Override
            public void run() {
                next();
            }
        };

        new Thread(next).start();
    }

    public void previousProfile(View view) {

        Runnable previous = new Runnable() {
            @Override
            public void run() {
                previous();
            }
        };

        new Thread(previous).start();
    }

    public void next() {
        this.btn.post(new Runnable() {
            @Override
            public void run() {

                i++;

                if(i > -1 && i < profile.size()) {
                    Log.d("Profile size ", Integer.valueOf(profile.size()).toString());
                    profileImage.setImageBitmap(profile.get(i).getProfileImage());
                    textName.setText(profile.get(i).getName());
                    descriptionText.setText(profile.get(i).getDescription());
                }
                else {
                    i = profile.size()-1;
                }
            }
        });
    }

    public void previous() {
        this.btn.post(new Runnable() {
            @Override
            public void run() {

                i--;

                if(i > -1 && i < profile.size()) {
                    profileImage.setImageBitmap(profile.get(i).getProfileImage());
                    textName.setText(profile.get(i).getName());
                    descriptionText.setText(profile.get(i).getDescription());
                }
                else {
                    i = 0;
                }
            }
        });
    }
}
