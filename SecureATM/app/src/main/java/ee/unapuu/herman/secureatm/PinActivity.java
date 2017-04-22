package ee.unapuu.herman.secureatm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        pinArea = (EditText) view.findViewById(R.id.pinArea);

    }



    @Override
    public void onClick(View view) {
       // switch (view.getId()) {

       // }
        if (view.getTag() != null) {
            if (view.getTag().toString().equals("OK") ) {
                Toast.makeText(this, "MOVE TO NEXT SCREEN", Toast.LENGTH_SHORT).show();
            } else if (view.getTag().toString().equals("X")) {
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                pinArea.setText("");
            } else {
                Toast.makeText(this, "number "+view.getTag(), Toast.LENGTH_SHORT).show();
                if (pinArea.getText().length() < 12) {
                    pinArea.setText(pinArea.getText()+"x");
                }
            }
        }

    }
}
