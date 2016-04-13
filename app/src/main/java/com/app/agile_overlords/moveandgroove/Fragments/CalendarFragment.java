package com.app.agile_overlords.moveandgroove.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by brittneyryn on 4/12/16.
 */
public class CalendarFragment extends Fragment {

    public static CalendarFragment newInstance(){
        CalendarFragment fragment = new CalendarFragment();
        Bundle agrs = new Bundle();
        fragment.setArguments(agrs);
        return fragment;
    }
}
