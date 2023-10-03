package nm.vamk.assignment_4_blog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText usernameEditText;
    EditText commentEditText;
    TextView textFieldTextView;
    EditText textToSearchEditText;
    EditText dateToSearchEditText;
    TextView searchResult;
    ArrayList<String> commentData;
    StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editText_username);
        commentEditText = findViewById(R.id.editText_comment);
        textFieldTextView = findViewById(R.id.tw_textField);
        commentData = new ArrayList<>();
        stringBuilder = new StringBuilder();


        Button submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(submitButtonClickListener);

        Button searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(searchButtonButtonClickListener);
    }

    private View.OnClickListener submitButtonClickListener = new View.OnClickListener() {
        String username = "";
        String comment = "";
        int entryNumber = 1;

        String commentDataToSave;

        @Override
        public void onClick(View v) {
            if(usernameEditText.getText().length() == 0 ) {
                usernameEditText.setBackgroundColor(Color.rgb(255,0,0));
            } else {
                username = String.valueOf(usernameEditText.getText());
                usernameEditText.setText("");
            }

            if(commentEditText.getText().length() == 0) {
                commentEditText.setBackgroundColor(Color.rgb(255,0,0));
            } else {
                comment = String.valueOf(commentEditText.getText());
                commentEditText.setText("");
            }

            if(username.isEmpty() || comment.isEmpty()) {
                textFieldTextView.setText("");
            } else {
                String entryNumberString = String.valueOf(entryNumber ++);
                commentDataToSave = getCurrentDateTime() + " " + username + " - " + comment;
                commentData.add(entryNumberString + " " + commentDataToSave);
                usernameEditText.setBackgroundColor(0);
                commentEditText.setBackgroundColor(0);


                for(int i = commentData.size() - 1; i >=0; i--) {
                    stringBuilder.append(commentData.get(i)).append("\n");
                    Log.d("Comments", commentData.get(i));
                }

                textFieldTextView.setText(stringBuilder.toString());
                stringBuilder.setLength(0);

                 /*
                textFieldTextViewTemp = textFieldTextView;
                textFieldTextView.setText(entryNumber++ +". "+ getCurrentDateTime() + " " + username + " - " + comment + "\n"
                        + textFieldTextViewTemp.getText().toString());

                if(commentData.size() <= 1) {
                    Log.d("Comments", commentData.get(0));
                } else {

                }

                  */


            }
            //newComment = textFieldTextView;
            //currentComment = textFieldTextView;
            //textFieldTextView.setText(currentComment.getText() + " | " +newComment.getText());

            /*
            textFieldData = textFieldTextView.getText().toString();
            userEntries.add(textFieldData);
            */

            //Log.d("check", userEntries.get(0) + userEntries.get(1));

            /*
            textFieldTextViewTemp = textFieldTextView;
            textFieldTextView.setText(textFieldTextViewTemp.getText());

            String tempValue = (String) textFieldTextView.getText();
            Log.d("check", tempValue);
            */



        }
    };

    private View.OnClickListener searchButtonButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            textToSearchEditText = findViewById(R.id.editText_textToSearch);
            dateToSearchEditText = findViewById(R.id.editText_dateToSearch);

            String searchText = textToSearchEditText.getText().toString();
            String searchDate = dateToSearchEditText.getText().toString();
            StringBuilder searchResults = new StringBuilder();
            searchResult = findViewById(R.id.tw_searchResult);
            searchResult.setText("");

            //Need to fix the searching by date!
            for(String comment : commentData) {
                if(comment.toLowerCase().contains(searchText.toLowerCase()) || comment.toLowerCase().contains(searchDate)) {
                    searchResults.append(comment).append("\n");
                }
            }

            if (searchResults.length() > 0) {
                searchResult.setText(searchResults.toString());
            } else {
                searchResult.setText("No matching results found.");
            }


            /*
            if(commentData.contains(textToSearchEditText.getText().toString())) {
                searchResult.setText(commentData.get());
            } else {
                Log.d("button", "Nothing...");
            }
             */
            //searchResult.setText(textToSearchEditText.getText());
        }
    };

    public String getCurrentDateTime() {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateformat.format(date);
    }


}