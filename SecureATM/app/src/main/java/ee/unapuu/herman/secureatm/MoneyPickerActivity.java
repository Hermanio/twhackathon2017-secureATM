package ee.unapuu.herman.secureatm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by toks on 22.04.17.
 */

public class MoneyPickerActivity extends Activity {
    private EditText customBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneypicker);

        customBox = (EditText) findViewById(R.id.customBox);
        customBox.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Toast.makeText(MoneyPickerActivity.this, "test", Toast.LENGTH_SHORT).show();
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    //Toast.makeText(MoneyPickerActivity.this, customBox.getText(), Toast.LENGTH_SHORT).show();
                    forward(v);
                    return true;
                }
                return false;
            }
        });
    }

    public void forward (View view) {
        Intent intent = new Intent(this, ConfirmationActivity.class);
        startActivity(intent);
    }


}
