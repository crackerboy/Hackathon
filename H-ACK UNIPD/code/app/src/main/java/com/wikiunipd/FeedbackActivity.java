/*
 * Copyright (c) 2015. Created by PopUp Team. All right Reserved
 */

package com.wikiunipd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;


public class FeedbackActivity extends ActionBarActivity {

    String menuTitle;
    String title;

    RatingBar ratingBar1;
    RatingBar ratingBar2;
    RatingBar ratingBar3;

    EditText comment1;
    EditText comment2;
    EditText comment3;


    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Toolbar toolbar = (Toolbar) findViewById(R.id.atoolbar);

        setSupportActionBar(toolbar);

        getTitle();

        menuTitle = "Feedback";
        setTitle(menuTitle);

        addListenerOnButtonClick();

    }

    public void addListenerOnButtonClick() {

        ratingBar1 = (RatingBar) findViewById(R.id.ratingBar1);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
        ratingBar3 = (RatingBar) findViewById(R.id.ratingBar3);

        comment1 = (EditText) findViewById(R.id.editText1);
        comment2 = (EditText) findViewById(R.id.editText2);
        comment3 = (EditText) findViewById(R.id.editText3);

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    double rating1 = ratingBar1.getRating();
                    double rating2 = ratingBar2.getRating();
                    double rating3 = ratingBar3.getRating();




                double avgRate = (rating1 + rating2 + rating3)/3.0;

                String quality = comment1.getText().toString();
                String overcrowding = comment2.getText().toString();
                String temperature = comment3.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("rate1", rating1);
                returnIntent.putExtra("rate2", rating2);
                returnIntent.putExtra("rate3", rating3);

                returnIntent.putExtra("rate", avgRate);

                returnIntent.putExtra("comment1", quality);
                returnIntent.putExtra("comment2", overcrowding);
                returnIntent.putExtra("comment3", temperature);


                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_feedback, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                super.onBackPressed();
                break;


            default:
                return super.onOptionsItemSelected(item);


        }
        return super.onOptionsItemSelected(item);

    }
}
