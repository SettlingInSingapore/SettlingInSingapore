package confirmcanstudios.settlinginsingapore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //  Screen Navigation
    /*public void startCategoryOne (View view){
        Intent intent = new Intent(this, CategoryOneActivity.class);
        startActivity(intent);
    }*/
    public void CategoryOnClick(View v) {
        switch (v.getId()) {
            case R.id.categoryOne:
                startActivity(R.string.category1, R.array.categoryOneItems);
                break;
            case R.id.categoryTwo:
                startActivity(R.string.category2, R.array.categoryTwoItems);
                break;
            case R.id.categoryThree:
                startActivity(R.string.category3, R.array.categoryThreeItems);
                break;
            case R.id.categoryFour:
                startActivity(R.string.category4, R.array.categoryFourItems);
                break;
            case R.id.categoryFive:
                startActivity(R.string.category5, R.array.categoryFiveItems);
                break;
            case R.id.categorySix:
                startActivity(R.string.category6, R.array.categorySixItems);
                break;
            case R.id.categorySeven:
                startActivity(R.string.category7, R.array.categorySevenItems);
                break;
            case R.id.categoryEight:
                startActivity(R.string.category8, R.array.categoryEightItems);
                break;
            default:
                break;
        }
    }
    private void startActivity(int m, int n){
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("CategoryID", m);
        intent.putExtra("CategoryArrayID", n);
        startActivity(intent);
    }

}
