package com.example.testprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ListView myListView;
    String[] profile;
    String[] description;

    public ProfileAdapter(Context c, String[] p, String[] d) {
        profile = p;
        description = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return profile.length;
    }

    @Override
    public Object getItem(int i) {
        return profile[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_details, null);
        TextView profileTextView = (TextView)v.findViewById(R.id.profileTextView);
        TextView descriptionTextView = (TextView)v.findViewById(R.id.descriptionTextView);

        String prof = profile[i];
        String desc = description[i];

        profileTextView.setText(prof);
        descriptionTextView.setText(desc);

        return v;
    }
}
