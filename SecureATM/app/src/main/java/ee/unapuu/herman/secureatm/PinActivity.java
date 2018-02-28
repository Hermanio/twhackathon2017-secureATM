package ee.unapuu.herman.secureatm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by toks on 22.04.17.
 */

public class PinActivity extends Activity implements View.OnClickListener {
    private EditText pinArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        View view = getWindow().getDecorView().getRootView();
        view.findViewById(R.id.num0).setOnClickListener(this);
        view.findViewById(R.id.num1).setOnClickListener(this);
        view.findViewById(R.id.num2).setOnClickListener(this);
        view.findViewById(R.id.num3).setOnClickListener(this);
        view.findViewById(R.id.num4).setOnClickListener(this);
        view.findViewById(R.id.num5).setOnClickListener(this);
        view.findViewById(R.id.num6).setOnClickListener(this);
        view.findViewById(R.id.num7).setOnClickListener(this);
        view.findViewById(R.id.num8).setOnClickListener(this);
        view.findViewById(R.id.num9).setOnClickListener(this);
        view.findViewById(R.id.cancelButton).setOnClickListener(this);
        view.findViewById(R.id.okButton).setOnClickListener(this);

        pinArea = view.findViewById(R.id.pinArea);

    }

    @Override
    public void onClick(View view) {
        if (view.getTag() != null) {
            if (view.getTag().toString().equals("OK")) {
                Intent intent = new Intent(this, MoneyPickerActivity.class);
                startActivity(intent);
            } else if (view.getTag().toString().equals("X")) {
                pinArea.setText("");
            } else {
                if (pinArea.getText().length() < 12) {
                    pinArea.setText(pinArea.getText() + "x");
                }
            }
        }
    }
}
