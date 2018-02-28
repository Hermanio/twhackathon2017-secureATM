package ee.unapuu.herman.secureatm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by toks on 22.04.17.
 */

public class MoneyPickerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_moneypicker);
        EditText customBox = findViewById(R.id.customBox);
        customBox.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    forward(v);
                    return true;
                }
                return false;
            }
        });
    }

    public void forward(View view) {
        Intent intent = new Intent(this, ConfirmationActivity.class);
        startActivity(intent);
    }
}
