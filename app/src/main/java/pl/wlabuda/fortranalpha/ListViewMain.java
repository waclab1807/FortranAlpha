package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
public class ListViewMain extends Activity {
    ListView listView ;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { getString(R.string.geomerty2d),
                getString(R.string.geometry3d),
                getString(R.string.trigonometry),
                getString(R.string.tales),
                getString(R.string.angle)
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
                        intent = new Intent(ListViewMain.this, ListViewGeometria2D.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(ListViewMain.this, ListViewGeometria3D.class);
                        startActivity(intent1);
                        break;
                    case 3:
                        Intent intent3 = new Intent(ListViewMain.this, Tales.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(ListViewMain.this, Katy.class);
                        startActivity(intent4);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_SHORT)
                                .show();
                        break;
                }

            }

        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.backButton), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1000);
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