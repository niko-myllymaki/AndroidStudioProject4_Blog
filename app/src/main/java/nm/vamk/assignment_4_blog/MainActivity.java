package nm.vamk.assignment_4_blog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText commentEditText;
    TextView textFieldTextView;

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
        @Override
        public void onClick(View v) {
            Button submitButton = (Button) v;
            if(usernameEditText.getText().length() == 0 ) {
                usernameEditText.setBackgroundColor(Color.rgb(255,0,0));
            } else {
                textFieldTextView.setText(usernameEditText.getText());

            }

            if(commentEditText.getText().length() == 0) {
                commentEditText.setBackgroundColor(Color.rgb(255,0,0));
            } else {
                textFieldTextView.setText(commentEditText.getText());
                //Currently overwrites the text from usernameEditText
            }

        }
    };


}