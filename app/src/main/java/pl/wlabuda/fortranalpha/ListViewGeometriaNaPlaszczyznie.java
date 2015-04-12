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
public class ListViewGeometriaNaPlaszczyznie extends Activity {
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
        String[] values = new String[] { "Trójkąt prawidłowy",
                "Trójkąt równoramienny",
                "Trójkąt prostokątny",
                "Kwadrat",
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
                        intent = new Intent(ListViewGeometriaNaPlaszczyznie.this, TrojkatPrawidlowy.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent1;
                        intent1 = new Intent(ListViewGeometriaNaPlaszczyznie.this, TrojkatProstokatny.class);
                        startActivity(intent1);
                        break;
                    case 3:
                        Intent intent2;
                        intent2 = new Intent(ListViewGeometriaNaPlaszczyznie.this, Kwadrat.class);
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewGeometriaNaPlaszczyznie.this);
                        builder
                                .setTitle("Trójkąt prawidłowy")
                                .setMessage("Wszystkie jego boki są równe")
                                .setIcon(R.mipmap.ic_launcher)
                                .setPositiveButton("OK", null)
                                .show();
                        break;
                    case 2:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(ListViewGeometriaNaPlaszczyznie.this);
                        builder1
                                .setTitle("Trójkąt prostokątny")
                                .setMessage("Posiada kąt prosty")
                                .setIcon(R.mipmap.ic_launcher)
                                .setPositiveButton("OK", null)
                                .show();
                        break;
                    case 3:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(ListViewGeometriaNaPlaszczyznie.this);
                        builder2
                                .setTitle("Kwadrat")
                                .setMessage("Wszystkie jego boki są równe, a kąty proste")
                                .setIcon(R.mipmap.ic_launcher)
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
                        .setMessage("Kąty alfa, beta itd. \n" +
                                "Dynamiczne oznaczenia pól, które można policzyć, \n" +
                                "Wbudowany kalkulator, \n" +
                                "Wiele, wiele innych...")
                        .setIcon(R.drawable.logo)
                        .setPositiveButton("OK", null)
                        .show();
                break;
            case R.id.item3:
                Toast.makeText(ListViewGeometriaNaPlaszczyznie.this, "W budowie...",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.item4:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
