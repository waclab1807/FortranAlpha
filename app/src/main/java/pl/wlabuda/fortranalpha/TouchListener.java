package pl.wlabuda.fortranalpha;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by waclab1807 on 24.04.15.
 */
public class TouchListener{
    public TouchListener(final ImageView imageView,final int obraz, EditText editText) {
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                imageView.setImageResource(obraz);
                return false;
            }
        });
    }
}
