package confirmcanstudios.settlinginsingapore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        dynamicCategorySet();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void dynamicCategorySet(){
        setTitle(getIntent().getIntExtra("CategoryID", 0));
        // Get ListView object from xml
        final ListView listViewMain = (ListView) findViewById(R.id.listViewMain);

        // Defined Array values to show in ListView
        String[] values = getResources().getStringArray(getIntent().getIntExtra("CategoryArrayID", 0));

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listViewMain.setAdapter(adapter);

        // ListView Item Click Listener
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item value
                String itemValue = (String) listViewMain.getItemAtPosition(position);

                Intent intent = new Intent(CategoryActivity.this, EntryActivity.class);
                intent.putExtra("Entry", itemValue);
                startActivity(intent);
            }
        });
    }

    public void quiz(View view){
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("CategoryID", getIntent().getIntExtra("CategoryID", 0));
        startActivity(intent);
    }

}