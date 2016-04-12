package com.app.agile_overlords.moveandgroove.Fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.agile_overlords.moveandgroove.Activities.BaseActivity;
import butterknife.ButterKnife;
import java.lang.Object;



/**
 * Created by brittney on 4/5/16.
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //injectDependencies();

    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    protected abstract int getFragmentLayout();

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // injectViews(view);
    }



    private void injectDependencies() {
        ((BaseActivity) getActivity()).inject(this);
    }

   //private void injectViews(final View view) {
        //ButterKnife.inject(this, view);
    //}


}

