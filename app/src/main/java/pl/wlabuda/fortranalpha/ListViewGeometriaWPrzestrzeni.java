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
public class ListViewGeometriaWPrzestrzeni extends Activity {
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
        String[] values = new String[] { getString(R.string.prismAndscaleneTriangle),
                getString(R.string.cube),
                getString(R.string.pyramid),
                getString(R.string.cylinder),
                getString(R.string.globe)
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
                        intent = new Intent(ListViewGeometriaWPrzestrzeni.this, GraniastoslupPrawidlowyTrojkatny.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1;
                        intent1 = new Intent(ListViewGeometriaWPrzestrzeni.this, Szescian.class);
                        startActivity(intent1);
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewGeometriaWPrzestrzeni.this);
                        builder
                                .setTitle(getString(R.string.prismAndscaleneTriangle))
                                .setMessage(R.string.prismAndscaleneTriangleDesc)
                                .setIcon(R.drawable.gran_pros_trojkatny)
                                .setPositiveButton("OK", null)
                                .show();
                        break;
                    case 1:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(ListViewGeometriaWPrzestrzeni.this);
                        builder1
                                .setTitle(getString(R.string.cube))
                                .setMessage(getString(R.string.cubeDesc))
                                .setIcon(R.drawable.szescian)
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