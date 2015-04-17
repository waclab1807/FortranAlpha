package pl.wlabuda.fortranalpha;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {
	
	private int index;
    public View rootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		Bundle data = getArguments();
		index = data.getInt("idx");
	}

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        switch (index){
            case 0:
                rootView = inflater.inflate(R.layout.activity1, container, false);
                break;
            case 1:
                rootView = inflater.inflate(R.layout.activity2, container, false);
            break;
            case 2:
                rootView = inflater.inflate(R.layout.activity3, container, false);
            break;
            default:
                rootView = null;
        }
		return rootView;
	}
}
