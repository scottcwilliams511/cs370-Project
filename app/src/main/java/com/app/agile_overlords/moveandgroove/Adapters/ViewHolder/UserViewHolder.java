package com.app.agile_overlords.moveandgroove.Adapters.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.Models.UserModel;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class UserViewHolder extends RelativeLayout implements View.OnClickListener{
    private TextView userName;
    private TextView age;

    public UserViewHolder(View context) {
        super(context);
    }

    //public UserViewHolder(final View userView) { super(userView); }

    public final void bind (final UserModel user){
        this.userName = userName;

    }

    @Override
    public void onClick(View v) {

    }
}
