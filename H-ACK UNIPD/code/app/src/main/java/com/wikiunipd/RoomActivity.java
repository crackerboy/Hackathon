/*
 * Copyright (c) 2015. Created by PopUp Team. All right Reserved
 */

package com.wikiunipd;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class RoomActivity extends ActionBarActivity {

    String menuTitle;
    String title;
    String address;
    String link;
    String hours;
    int seats;
    int image;
    String facilities;
    ImageView imageView;
    double latitude;
    double longitude;
    private FloatingActionButton mFabButton = null;

    String comment1;
    String comment2;
    String comment3;

    double rate1;
    double rate2;
    double rate3;
    double avgRate;

    TextView avgScore;
    TextView titleView;
    TextView hoursView;
    TextView seatsView;
    TextView facilitiesView;
    TextView text1;
    TextView text2;
    TextView text3;


    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Toolbar toolbar = (Toolbar) findViewById(R.id.atoolbar);

        setSupportActionBar(toolbar);

        getTitle();

        Bundle extras = getIntent().getExtras();
        menuTitle = extras.getString("title");
        setTitle(menuTitle);

        title = extras.getString("title");
        address = extras.getString("address");
        latitude = extras.getDouble("latitude");
        longitude = extras.getDouble("longitude");
        link = extras.getString("link");
        image = extras.getInt("image");


        hours = extras.getString("hours");
        seats = extras.getInt("seats");


        titleView = (TextView) findViewById(R.id.title);
        titleView.setText(title);

        text1 = (TextView) findViewById(R.id.text1);
        text1.setText(getResources().getString(R.string.quality) + ": " + Double.toString(rate1) +"/5");

        text2 = (TextView) findViewById(R.id.text2);
        text2.setText(getResources().getString(R.string.overcrowding) + ": " + Double.toString(rate2)+ "/5");

        text3 = (TextView) findViewById(R.id.text3);
        text3.setText(getResources().getString(R.string.temperature) + ": " + Double.toString(rate3) + "/5")
        ;

        hoursView = (TextView) findViewById(R.id.hours);
        hoursView.setText(hours);

        seatsView = (TextView) findViewById(R.id.seats);
        seatsView.setText(getResources().getString(R.string.seats) + " " + Integer.toString(seats));


        imageView = (ImageView)findViewById(R.id.featuredImg);

        imageView.setImageResource(image);

        imageView.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo: " + latitude + ", " + longitude + "?q=" + latitude + "," + longitude + "(name)"));
// the following line should be used if you want use only Google maps
                intent.setComponent(new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity"));
                startActivity(intent);
            }


        });

      /*  avgScore = (TextView) findViewById(R.id.avgRate);
        avgScore.setText("Valutazione Media " + Double.toString(avgRate));
        avgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_layout);
                dialog.setTitle(R.string.dialog_title);


                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });*/

       //fab creation
       mFabButton = new FloatingActionButton.Builder(this)
                .withDrawable(
                        getResources().getDrawable(
                                R.drawable.ic_plus_white_24dp))
                .withButtonColor(R.color.color_accent)
                .withGravity(Gravity.BOTTOM | Gravity.END)
                .withMargins(0, 0, 16, 16).create();

        //fab listener
        mFabButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // create a new DialogFragment and sets it visible
                Intent intent = new Intent(RoomActivity.this, FeedbackActivity.class);



                startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                comment1 = data.getStringExtra("comment1");
                comment2 = data.getStringExtra("comment2");
                comment3 = data.getStringExtra("comment3");

                rate1 = data.getDoubleExtra("rate1", 0);
                rate2 = data.getDoubleExtra("rate2", 0);
                rate3 = data.getDoubleExtra("rate3", 0);

                avgRate = data.getDoubleExtra("rate", 0);

                DecimalFormat df = new DecimalFormat("#.#");
                df.format(avgRate);

            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_room, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                super.onBackPressed();
                break;

            case R.id.broswer:
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(browserIntent);
                return true;


            default:
                return super.onOptionsItemSelected(item);


        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onResume() {

        super.onResume();


        text1.setText(getResources().getString(R.string.quality) + ": " + Double.toString(rate1) +"/5");

        text2.setText(getResources().getString(R.string.overcrowding) + ": " + Double.toString(rate2)+ "/5");

        text3.setText(getResources().getString(R.string.temperature) + ": " + Double.toString(rate3) + "/5")
        ;


    }
}
