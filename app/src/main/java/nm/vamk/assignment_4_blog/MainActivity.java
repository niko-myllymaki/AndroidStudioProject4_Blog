package nm.vamk.assignment_4_blog;

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

    TextView textFieldTextViewTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editText_username);
        commentEditText = findViewById(R.id.editText_comment);
        textFieldTextView = findViewById(R.id.tw_textField);

        Button submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(submitButtonClickListener);
    }

    private View.OnClickListener submitButtonClickListener = new View.OnClickListener() {
        String username = "";
        String comment = "";
        @Override
        public void onClick(View v) {
            Button submitButton = (Button) v;
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
                textFieldTextView.setText(getCurrentDateTime() + " " + username + " - " + comment);
                textFieldTextViewTemp = textFieldTextView;
                usernameEditText.setBackgroundColor(0);
                commentEditText.setBackgroundColor(0);
            }
            textFieldTextViewTemp = textFieldTextView;
            textFieldTextView.setText(textFieldTextViewTemp.getText());

            String tempValue = (String) textFieldTextView.getText();
            Log.d("check", tempValue);




        }
    };

    public String getCurrentDateTime() {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateformat.format(date);
    }


}