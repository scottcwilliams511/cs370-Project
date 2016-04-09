package com.app.agile_overlords.moveandgroove.Activities;

/**
 * Created by brittneyryn on 4/5/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.List;



public abstract class BaseActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();

}
    public void inject(Object object) {
        //activityScopeGraph.inject(object);
    }

    protected abstract List<Object> getModules();

    private void injectDependencies() {

    }
    private void injectViews() {
       // ButterKnife.inject(this);
    }
}