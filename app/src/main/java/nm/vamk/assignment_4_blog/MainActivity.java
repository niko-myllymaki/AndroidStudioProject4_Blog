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
    Button submitButton;
    Button searchButton;

    String commentDataToSave;

    String username;
    String comment;
    int entryNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editText_username);
        commentEditText = findViewById(R.id.editText_comment);
        textFieldTextView = findViewById(R.id.tw_textField);
        commentData = new ArrayList<>();
        stringBuilder = new StringBuilder();


        submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(ButtonClickListener);

        searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(ButtonClickListener);
    }

    private View.OnClickListener ButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*
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
             */

            Button clickedButton = (Button)v;

            //Submit button event
            if(clickedButton.equals(submitButton)) {
                username = "";
                comment = "";

                checkUserInputs();
                if(!username.isEmpty() && !comment.isEmpty()) {
                    saveCommentData();
                    usernameEditText.setBackgroundColor(0);
                    commentEditText.setBackgroundColor(0);
                    for(int i = commentData.size() - 1; i >=0; i--) {
                        stringBuilder.append(commentData.get(i)).append("\n");
                    }

                    textFieldTextView.setText(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }

            }

            //Search button event
            if(clickedButton.equals(searchButton)) {
                textToSearchEditText = findViewById(R.id.editText_textToSearch);
                dateToSearchEditText = findViewById(R.id.editText_dateToSearch);

                String searchText = textToSearchEditText.getText().toString();
                String searchDate = dateToSearchEditText.getText().toString();
                StringBuilder searchResults = new StringBuilder();
                searchResult = findViewById(R.id.tw_searchResult);
                searchResult.setText("");

                if(!searchText.isEmpty()) {
                    for(String comment : commentData) {
                        if(comment.toLowerCase().contains(searchText.toLowerCase())) {
                            searchResults.append(comment).append("\n");
                        }
                    }
                } else {
                    Log.d("result", "No can do...");
                }

                if(!searchDate.isEmpty()) {
                    for(String comment : commentData) {
                        if(comment.toLowerCase().contains(searchDate)) {
                            searchResults.append(comment).append("\n");
                        }
                    }
                } else {
                    Log.d("result", "No can do...");
                }
                usernameEditText.setBackgroundColor(0);
                commentEditText.setBackgroundColor(0);
                if (searchResults.length() > 0) {
                    searchResult.setText(searchResults.toString());
                } else {
                    searchResult.setText("No matching results found.");
                }
            }






            /*
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
                }

                textFieldTextView.setText(stringBuilder.toString());
                stringBuilder.setLength(0);
                //username = "";
                //comment = "";

            }

             */

        }
    };

    public void checkUserInputs() {
        if(usernameEditText.getText().length() != 0) {
            username = usernameEditText.getText().toString();
            usernameEditText.setText("");
        } else {
            usernameEditText.setBackgroundColor(Color.rgb(255,0,0));
        }

        if(commentEditText.getText().length() != 0) {
            comment = commentEditText.getText().toString();
            commentEditText.setText("");
        } else {
            commentEditText.setBackgroundColor(Color.rgb(255,0,0));
        }
    }

    public void saveCommentData() {
        String entryNumberString = String.valueOf(entryNumber ++);
        commentDataToSave = getCurrentDateTime() + " " + username + " - " + comment;
        commentData.add(entryNumberString + " " + commentDataToSave);
    }



    public String getCurrentDateTime() {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateformat.format(date);
    }

    /*
    private View.OnClickListener searchButtonButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            textToSearchEditText = findViewById(R.id.editText_textToSearch);
            dateToSearchEditText = findViewById(R.id.editText_dateToSearch);

            String searchText = textToSearchEditText.getText().toString();
            String searchDate = dateToSearchEditText.getText().toString();
            StringBuilder searchResults = new StringBuilder();
            searchResult = findViewById(R.id.tw_searchResult);
            searchResult.setText("");

            if(!searchText.isEmpty()) {
                //Need to fix the searching by date!
                for(String comment : commentData) {
                    if(comment.toLowerCase().contains(searchText.toLowerCase())) {
                        searchResults.append(comment).append("\n");
                    }
                }
            } else {
                Log.d("result", "No can do...");
            }

            if(!searchDate.isEmpty()) {
                //Need to fix the searching by date!
                for(String comment : commentData) {
                    if(comment.toLowerCase().contains(searchDate)) {
                        searchResults.append(comment).append("\n");
                    }
                }
            } else {
                Log.d("result", "No can do...");
            }

            if (searchResults.length() > 0) {
                searchResult.setText(searchResults.toString());
            } else {
                searchResult.setText("No matching results found.");
            }
        }
    };

     */



}