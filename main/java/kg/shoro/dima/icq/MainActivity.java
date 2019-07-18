package kg.shoro.dima.icq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Model model;
    EditText messageIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Model(this);
        messageIn = (EditText) findViewById(R.id.editTextIn);

        model.thread.start();
    }

    public void messageIn(String value) {

        final String text = value;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageIn.setText(text);
            }
        });
    }
}
