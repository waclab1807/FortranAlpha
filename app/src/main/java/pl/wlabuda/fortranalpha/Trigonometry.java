package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by waclab1807 on 30.03.15.
 */
public class Trigonometry extends Activity {
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
/*
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
*/
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { getString(R.string.trigonometry1),
                getString(R.string.trigonometry2),
                getString(R.string.trigonometry3)
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                switch (itemPosition){
                    case 0:
                        Intent intent;
                        intent = new Intent(Trigonometry.this, Trygonometria1.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1;
                        intent1 = new Intent(Trigonometry.this, Trygonometria2.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2;
                        intent2 = new Intent(Trigonometry.this, Trygonometria3.class);
                        startActivity(intent2);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_SHORT)
                                .show();
                        break;
                }
            }

        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        AlertDialog.Builder builder = new AlertDialog.Builder(Trigonometry.this);
                        builder
                                .setTitle(getString(R.string.scaleneTriangle))
                                .setMessage(R.string.scaleneTriangleDesc)
                                .setIcon(R.drawable.troj_praw)
                                .setPositiveButton("OK", null)
                                .show();
                        break;
                    case 1:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Trigonometry.this);
                        builder1
                                .setTitle(getString(R.string.rightangledTriangle))
                                .setMessage(R.string.rightangledTriangleDesc)
                                .setIcon(R.drawable.trojkat_prostokatny)
                                .setPositiveButton("OK", null)
                                .show();
                        break;
                    case 2:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Trigonometry.this);
                        builder2
                                .setTitle(getString(R.string.square))
                                .setMessage(R.string.squareDesc)
                                .setIcon(R.drawable.kwadrat)
                                .setPositiveButton("OK", null)
                                .show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        new DotsMenu(item, this);
        return super.onOptionsItemSelected(item);
    }
}
