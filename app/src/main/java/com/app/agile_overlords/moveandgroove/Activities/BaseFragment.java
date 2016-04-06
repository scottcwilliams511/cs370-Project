package com.app.agile_overlords.moveandgroove.Activities;

import android.app.Activity;
import android.support.v4.app.Fragment;
import butterknife.ButterKnife;



/**
 * Created by brittney on 4/5/16.
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        injectDependencies();

    }

}
