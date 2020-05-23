package my.awesome.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.my.profile.R;

public class EduAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ListView eduList;
    private String[] schoolName;
    private String[] degName;
    private String[] studyDuration;
    private String[] activities;
    private String[] description;

    public EduAdapter(Context c, String[] s, String[] d, String[] t, String[] a, String[] e) {
        schoolName = s;
        degName = d;
        studyDuration = t;
        activities = a;
        description = e;

        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return schoolName.length;
    }

    @Override
    public Object getItem(int i) {
        return schoolName[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.listview_edu, null);
        TextView schoolNameTV = (TextView) v.findViewById(R.id.schoolName);
        TextView degNameTV = (TextView) v.findViewById(R.id.degName);
        TextView studyDurationTV = (TextView) v.findViewById(R.id.studyDuration);
        TextView activitiesTV = (TextView) v.findViewById(R.id.activities);
        TextView descriptionTV = (TextView) v.findViewById(R.id.descriptionSch);

        String sch = schoolName[i];
        String deg = degName[i];
        String stu = studyDuration[i];
        String act = activities[i];
        String des = description[i];

        schoolNameTV.setText(sch);
        degNameTV.setText(deg);
        studyDurationTV.setText(stu);
        activitiesTV.setText(act);
        descriptionTV.setText(des);

        return v;
    }
}
