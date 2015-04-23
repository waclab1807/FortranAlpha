package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
        String[] values = new String[] { "Figury płaskie",
                "Bryły",
                "Trygonometria",
                "Twierdzenie Talesa",
                "Kąty"
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
                        intent = new Intent(ListViewMain.this, ListViewGeometriaNaPlaszczyznie.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(ListViewMain.this, ListViewGeometriaWPrzestrzeni.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(ListViewMain.this, NowaKlasa.class);
                        startActivity(intent2);
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
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        String ktoryElement = "";
        switch (item.getItemId()) {
            case R.id.item1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder
                        .setTitle("O autorze:")
                        .setMessage("Wacław Łabuda \ne-mail: waclab1807@gmail.com \nPolska/Nowy Sącz")
                        .setIcon(R.drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case R.id.item2:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2
                        .setTitle("Plany na przyszłość:")
                        .setMessage("Trygonometria-jedynka trygonometryczna itd. \n" +
                                "Obliczanie delty i miejsc zerowych \n" +
                                "Twierdzenie Bezouta" +
                                "Ciągi" +
                                "Odcinki w układzie współrzędnych" +
                                "Macierze" +
                                "Dynamiczne oznaczenia pól, które można policzyć, \n" +
                                "Wiele, wiele innych...")
                        .setIcon(R.drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case R.id.item3:
                Toast.makeText(ListViewMain.this, "W budowie...",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                finish();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}