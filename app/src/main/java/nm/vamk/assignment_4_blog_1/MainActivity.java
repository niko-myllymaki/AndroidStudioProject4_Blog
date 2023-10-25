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

    EditText usernameEditText;
    EditText commentEditText;
    TextView textFieldTextView;

    Button submitButton;

    String username;
    String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editText_username);
        commentEditText = findViewById(R.id.editText_comment);
        textFieldTextView = findViewById(R.id.tw_textField);

        submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(ButtonClickListener);
    }

    private View.OnClickListener ButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedButton = (Button)v;

            if(clickedButton.equals(submitButton)) {
                username = "";
                comment = "";

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

                if(!username.isEmpty() && !comment.isEmpty()) {
                    EntryDB.addNewEntryToDatabase(getCurrentDateTime(), username, comment );
                    usernameEditText.setBackgroundColor(0);
                    commentEditText.setBackgroundColor(0);
                    textFieldTextView.setText(EntryDB.getEntriesList().toString());

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