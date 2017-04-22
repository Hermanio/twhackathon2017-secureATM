package ee.unapuu.herman.secureatm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by toks on 22.04.17.
 */

public class MoneyPickerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneypicker);
    }

    public void forward (View view) {
        Intent intent = new Intent(this, ConfirmationActivity.class);
        startActivity(intent);
    }


}
