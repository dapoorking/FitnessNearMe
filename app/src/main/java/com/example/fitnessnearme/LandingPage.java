package com.example.fitnessnearme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.anastr.speedviewlib.ProgressiveGauge;
import com.github.anastr.speedviewlib.SpeedView;

public class LandingPage extends AppCompatActivity {
    private static final String TAG = "LandingPage"; // Log tag for debugging
    private TextView loggedInUserTextView;
    Button eventsButton;
    Button myGymButton;
    Button trysomethingnew;
    ImageView facebookIcon;
    ImageView twitterIcon;
    ImageView instagramIcon;
    private TextView walk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_landing_page);
        loggedInUserTextView = findViewById(R.id.usernameTextView);
        walk=findViewById(R.id.step);
        walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this, StepCounterActivity.class);
                startActivity(intent);
            }
        });


        SharedPreferences preferences = getSharedPreferences(Constants.PREFERENCE_NAME, MODE_PRIVATE);
        String loggedInUsername = preferences.getString(Constants.KEY_USERNAME, "");

        // Update the TextView with the logged-in username
        loggedInUserTextView.setText("USER: " + loggedInUsername);

        eventsButton = findViewById(R.id.eventsButton);
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(LandingPage.this, events.class);
                startActivity(intent);
            }
        });

        myGymButton = findViewById(R.id.myGymButton);
        myGymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(LandingPage.this, mygym.class);
                startActivity(intent);
            }
        });

        trysomethingnew = findViewById(R.id.trySomethingNewButton);
        trysomethingnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(LandingPage.this, trysomethingnew.class);
                startActivity(intent);
            }
        });

        facebookIcon = findViewById(R.id.facebookIcon);
        twitterIcon = findViewById(R.id.twitterIcon);
        instagramIcon = findViewById(R.id.instagramIcon);
    }

    public void onFacebookIconClicked(View view) {
        String facebookUrl = "https://www.facebook.com/people/Fitness_Near_Me/61551339500367/?mibextid=ZbWKwL";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
        startActivity(intent);
    }

    public void onTwitterIconClicked(View view) {
        String twitterUrl = "https://www.youtube.com/@dapoorking";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl));
        startActivity(intent);
    }

    public void onInstagramIconClicked(View view) {
        String instagramUrl = "https://instagram.com/weare.responsible?utm_source=qr&igshid=OGU0MmVlOWVjOQ==";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
        startActivity(intent);
    }
}
