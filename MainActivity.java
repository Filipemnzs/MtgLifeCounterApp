package com.example.mtglifecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class MainActivity extends AppCompatActivity {

    Button counter1Up, counter1Down, counter2Up, counter2Down;
    TextView lifeCount1, lifeCount2;

    int lifeTotal1, lifeTotal2;
    

    AdView adView = new AdView(this);

    private PublisherAdView mPublisherAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
        
        PublisherAdView adView = new PublisherAdView(this);
        adView.setAdSizes(AdSize.BANNER);

        adView.setAdUnitId("/6499/example/banner");

        mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest =  new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);



        counter1Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeTotal1 = Integer.parseInt(lifeCount1.getText().toString());
                lifeCount1.setText(String.valueOf(lifeTotal1 + 1));
            }
        });

        counter1Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeTotal1 = Integer.parseInt(lifeCount1.getText().toString());
                lifeCount1.setText(String.valueOf(lifeTotal1 - 1));
            }
        });

        counter2Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeTotal2 = Integer.parseInt(lifeCount2.getText().toString());
                lifeCount2.setText(String.valueOf(lifeTotal2 + 1));
            }
        });

        counter2Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeTotal2 = Integer.parseInt(lifeCount2.getText().toString());
                lifeCount2.setText(String.valueOf(lifeTotal2 - 1));
    }
        });


    }

    public void setUI(){
        counter1Up = findViewById(R.id.counter1UpBTN);
        counter1Down = findViewById(R.id.counter1DownBTN);
        counter2Up = findViewById(R.id.counter2UpBTN);
        counter2Down = findViewById(R.id.counter2DownBTN);

        lifeCount1 = findViewById(R.id.counter1TV);
        lifeCount2 = findViewById(R.id.counter2TV);

        lifeCount1.setText("20");
        lifeCount2.setText("20");

        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-8065887610573597/7308094284");
    }

    public void rollActivity(View v){
        Intent i = new Intent(this, DiceRoll.class);
        startActivity(i);
    }


}


