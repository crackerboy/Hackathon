package com.hack.gymtonic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

import com.tjerkw.slideexpandable.library.ActionSlideExpandableListView;

public class CreateChallengeActivity extends AppCompatActivity {

	/*public void addKeyListener(EditText edittext) {

		// get edittext component
		edittext = (EditText) findViewById(R.id.myText);

		// add a keylistener to monitor the keaybord avitvity...
		edittext.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				// if the users pressed a button and that button was "0"
				if ((event.getAction() == KeyEvent.ACTION_DOWN) &amp;&amp; (keyCode == KeyEvent.KEYCODE_0)) {

					// display the input text....
					Toast.makeText(MainActivity.this,edittext.getText(), Toast.LENGTH_LONG).show();
					return true;

					// if the users pressed a button and that button was "9"
				} else if ((event.getAction() == KeyEvent.ACTION_DOWN) 	&amp;&amp; (keyCode == KeyEvent.KEYCODE_9)) {

					// display message
					Toast.makeText(MainActivity.this, "Number 9 is pressed!", Toast.LENGTH_LONG).show();
					return true;
				}

				return false;
			}
		});
	}*/

	@Override
	public void onCreate(Bundle savedData) {

		super.onCreate(savedData);
		// set the content view for this activity, check the content view xml file
		// to see how it refers to the ActionSlideExpandableListView view.
		this.setContentView(R.layout.single_expandable_list);




		// get a reference to the listview, needed in order
		// to call setItemActionListener on it
		ActionSlideExpandableListView list = (ActionSlideExpandableListView)this.findViewById(R.id.list);

		// fill the list with data
		list.setAdapter(buildDummyData());

		final Context context = this;
		list.setItemActionListener(new ActionSlideExpandableListView.OnActionClickListener() {
			@Override
			public void onClick(View itemView, View clickedView, int position) {
				LayoutInflater li = LayoutInflater.from(context);
				View promptsView = li.inflate(R.layout.popup_text, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(promptsView);

                final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);

                builder.setCancelable(true)
                        .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent nextActivity = new Intent(getApplicationContext(), MakeABetActivity.class);
                                startActivity(nextActivity);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                dialogInterface.cancel();
                            }
                        });

                builder.create().show();
            }
		}, R.id.button_km, R.id.button_avgspeed, R.id.button_time);
	}

	/**
	 * Builds dummy data for the test.
	 * In a real app this would be an adapter
	 * for your data. For example a CursorAdapter
	 */
	public ListAdapter buildDummyData() {
		//size of buttons
		final int SIZE = 3;
		String[] values = new String[SIZE];
		for(int i=0;i<SIZE;i++) {
			if(i == 0){
				values[i] = "Gym";
			}else if(i == 1){
				values[i] = "Ride";
			}else if(i == 2){
				values[i] = "Walk";
			}else if(i == 3){
				values[i] = "Run";
			}else{
				values[i] = "Item "+i;
			}
		}
		return new ArrayAdapter<String>(
				this,
				R.layout.expandable_list_item,
				R.id.text,
				values
		);
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