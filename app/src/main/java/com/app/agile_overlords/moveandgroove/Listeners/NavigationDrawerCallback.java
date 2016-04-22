package com.app.agile_overlords.moveandgroove.Listeners;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/19/16.
 */
/*public interface NavigationDrawerCallback {
    void onNavigationDrawerItemSelected(NavigationItem item);
}

public static class NavigationItem {
    final int id;
    final String title;

    NavigationItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return title;
    }
}

private class MyNavigationDrawerToggle extends ActionBarDrawerToggle {

    private CharSequence previousTitle;

    private MyNavigationDrawerToggle(Activity activity, DrawerLayout drawerLayout,
                                     int drawerImageRes, int openDrawerContentDescRes,
                                     int closeDrawerContentDescRes) {
        super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes, closeDrawerContentDescRes);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);

        ActionBar actionBar = getActionBar();
        previousTitle = actionBar.getTitle();
        actionBar.setTitle(getString(R.string.app_name));
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);

        if (previousTitle != null) {
            ActionBar actionBar = getActionBar();
            actionBar.setTitle(previousTitle);
        }
    }

    private void invalidateTitle() {
        previousTitle = null;
    }
}
}
*/