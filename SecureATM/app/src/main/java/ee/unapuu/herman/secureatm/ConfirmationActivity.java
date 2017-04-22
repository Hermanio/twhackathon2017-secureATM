package ee.unapuu.herman.secureatm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by toks on 22.04.17.
 */

public class ConfirmationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
    }

    public void forward (View view) {
        Intent intent = new Intent(this, MoneyGetActivity.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        finish();
    }
}
