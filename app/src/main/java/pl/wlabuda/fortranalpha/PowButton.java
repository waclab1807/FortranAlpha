package pl.wlabuda.fortranalpha;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by waclab1807 on 23.04.15.
 */
public class PowButton {
    public PowButton(Button powbtn, final EditText lastFocused){
        powbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastFocused.setText("()^()");
                lastFocused.setSelection(1);
            }
        });
    }
}
