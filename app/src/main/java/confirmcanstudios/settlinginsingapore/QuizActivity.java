package confirmcanstudios.settlinginsingapore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        dynamicQuizSet();
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

    public int categoryNumber;

    private void dynamicQuizSet(){
        switch(getIntent().getIntExtra("CategoryID", 0)){
            case R.string.category1:
                categoryNumber = 1;
                break;
            case R.string.category2:
                categoryNumber = 2;
                break;
            case R.string.category3:
                categoryNumber = 3;
                break;
            case R.string.category4:
                categoryNumber = 4;
                break;
            case R.string.category5:
                categoryNumber = 5;
                break;
            case R.string.category6:
                categoryNumber = 6;
                break;
            case R.string.category7:
                categoryNumber = 7;
                break;
            case R.string.category8:
                categoryNumber = 8;
                break;
            default:
                categoryNumber = 0;
                break;

        }
        TextView question = (TextView) findViewById(
                R.id.question);
        TextView option1 = (TextView) findViewById(
                R.id.option1);
        TextView option2 = (TextView) findViewById(
                R.id.option2);
        TextView option3 = (TextView) findViewById(
                R.id.option3);

        String dynamicString = "cat" + categoryNumber + "qn1";
        String dynamicString1 = "cat" + categoryNumber + "qn1opt1";
        String dynamicString2 = "cat" + categoryNumber + "qn1opt2";
        String dynamicString3 = "cat" + categoryNumber + "qn1opt3";

        question.setText(getResources().getIdentifier(dynamicString, "string",
                this.getPackageName()));
        option1.setText(getResources().getIdentifier(dynamicString1, "string",
                this.getPackageName()));
        option2.setText(getResources().getIdentifier(dynamicString2, "string",
                this.getPackageName()));
        option3.setText(getResources().getIdentifier(dynamicString3, "string",
                this.getPackageName()));
    }
}
