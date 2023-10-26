package nm.vamk.assignment_4_blog_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView textFieldTextView;

    TextView searchResultTextView;
    EditText usernameEditText;
    EditText commentEditText;

    EditText commentToSearchEditText;

    EditText dateToSearchEditText;

    Button submitButton;
    Button searchButton;

    String username;
    String comment;

    String commentToSearch;
    String dateToSearch;
    StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editText_username);
        commentEditText = findViewById(R.id.editText_comment);
        textFieldTextView = findViewById(R.id.tw_textField);
        searchResultTextView = findViewById(R.id.tw_searchResult);

        commentToSearchEditText = findViewById(R.id.editText_textToSearch);
        dateToSearchEditText = findViewById(R.id.editText_dateToSearch);


        submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(ButtonClickListener);

        searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(ButtonClickListener);

        stringBuilder = new StringBuilder();
    }

    private View.OnClickListener ButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedButton = (Button) v;

            //Submit button event
            if (clickedButton.equals(submitButton)) {
                username = "";
                comment = "";

                if (usernameEditText.getText().length() != 0) {
                    username = usernameEditText.getText().toString();
                    usernameEditText.setText("");
                } else {
                    usernameEditText.setBackgroundColor(Color.rgb(255, 0, 0));
                }

                if (commentEditText.getText().length() != 0) {
                    comment = commentEditText.getText().toString();
                    commentEditText.setText("");
                } else {
                    commentEditText.setBackgroundColor(Color.rgb(255, 0, 0));
                }

                if (!username.isEmpty() && !comment.isEmpty()) {
                    EntryDB.addNewEntryToDatabase(getCurrentDateTime(), username, comment);
                    usernameEditText.setBackgroundColor(0);
                    commentEditText.setBackgroundColor(0);
                    for (Entry entry : EntryDB.getEntriesList()) {
                        stringBuilder.append(entry.toString()).append("\n");

                    }
                    textFieldTextView.setText(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            }

            //Search button event
            if (clickedButton.equals(searchButton)) {
                commentToSearch = commentToSearchEditText.getText().toString();
                dateToSearch = dateToSearchEditText.getText().toString();

                //Search by comment
                if (!commentToSearch.isEmpty()) {
                    for (Entry entry : EntryDB.getEntriesByComment(commentToSearch)) {
                        stringBuilder.append(entry.toString()).append("\n");
                    }
                    if (stringBuilder.length() > 0) {
                        searchResultTextView.setText(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    } else {
                        searchResultTextView.setText(R.string.negative_result);
                    }
                }

                //Search by date
                if (!dateToSearch.isEmpty()) {
                    for (Entry entry : EntryDB.getEntriesByDate(dateToSearch)) {
                        stringBuilder.append(entry.toString()).append("\n");
                    }
                    if (stringBuilder.length() > 0) {
                        searchResultTextView.setText(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    } else {
                        searchResultTextView.setText(R.string.negative_result);
                    }


                    }
            }
        }
    };

    public String getCurrentDateTime() {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateformat.format(date);
    }
}