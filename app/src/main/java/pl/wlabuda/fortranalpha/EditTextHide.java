package pl.wlabuda.fortranalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by waclab1807 on 23.04.15.
 */
public class EditTextHide {

    public EditTextHide(Boolean hide, EditText... editTexts){
        for(EditText t:editTexts){
            t.setVisibility((hide)? View.VISIBLE:View.GONE);
        }
    }
}
