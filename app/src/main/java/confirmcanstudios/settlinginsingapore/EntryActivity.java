package confirmcanstudios.settlinginsingapore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        
        dynamicEntrySet();
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

    private void dynamicEntrySet(){
        String imageName = getIntent().getStringExtra("Entry").toLowerCase().replace(" ", "");

        //Gets the imageID based on the selected word/phrase
        int dynamicImageID;
        if(getResources().getIdentifier(imageName , "drawable", this.getPackageName()) == 0){
            dynamicImageID = getResources().getIdentifier("error" , "drawable", this.getPackageName());
        }
        else {
            dynamicImageID = getResources().getIdentifier(imageName , "drawable", this.getPackageName());
        }

        int dynamicStringID;
        if(getResources().getIdentifier(getIntent().getStringExtra("Entry").replace(" ", ""), "string",
                this.getPackageName()) == 0){
            dynamicStringID = getResources().getIdentifier("Error", "string",
                    this.getPackageName());
        }
        else {
            dynamicStringID = getResources().getIdentifier(getIntent().getStringExtra("Entry").replace(" ", ""), "string",
                    this.getPackageName());
         }

        ImageView EntryImage = (ImageView) findViewById(
                R.id.EntryActivityImage);
        TextView EntryTitle = (TextView) findViewById(
            R.id.EntryActivityTitle);
        TextView EntryDesc = (TextView) findViewById(
                R.id.EntryActivityDesc);

        //Programmatically set resources in EntryActivity
        setTitle(getIntent().getStringExtra("Entry"));
        EntryImage.setImageResource(dynamicImageID);
        EntryTitle.setText(getIntent().getStringExtra("Entry"));
        EntryDesc.setText(dynamicStringID);
    }

}
