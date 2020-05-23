package my.awesome.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.my.profile.R;

public class WorkExpAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ListView workList;
    private String[] position;
    private String[] companyName;
    private String[] workDuration;
    private String[] description;

    public WorkExpAdapter(Context c, String[] p, String[] n, String[] d, String[] w) {
        position = p;
        companyName = n;
        description = d;
        workDuration = w;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return position.length;
    }

    @Override
    public Object getItem(int i) {
        return position[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.listview_work, null);
        TextView positionTV = (TextView) v.findViewById(R.id.position);
        TextView companyNameTV = (TextView) v.findViewById(R.id.companyName);
        TextView workDurationTV = (TextView) v.findViewById(R.id.workDuration);
        TextView descriptionTV = (TextView) v.findViewById(R.id.description);

        String pos = position[i];
        String com = companyName[i];
        String wor = workDuration[i];
        String des = description[i];

        positionTV.setText(pos);
        companyNameTV.setText(com);
        workDurationTV.setText(wor);
        descriptionTV.setText(des);

        return v;
    }
}
