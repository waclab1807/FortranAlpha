package pl.wlabuda.fortranalpha;

import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

/**
 * Created by waclab1807 on 23.04.15.
 */
public class EditTextHide {

    public EditTextHide(Boolean hide, EditText... editTexts){
        if (hide){
            for(EditText t:editTexts){
                t.setVisibility(View.GONE);
            }
        }else{
            for(EditText t:editTexts){
                t.setVisibility(View.VISIBLE);
            }
        }
    }
}
