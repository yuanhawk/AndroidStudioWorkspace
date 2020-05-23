package my.awesome.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.my.profile.R;

public class VolSvcAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ListView volSvcList;
    private String[] positionName;
    private String[] comName;
    private String[] svcDate;
    private String[] catName;
    private String[] descSvc;

    public VolSvcAdapter(Context c, String[] p, String[] o, String[] s, String[] a, String[] d) {
        positionName = p;
        comName = o;
        svcDate = s;
        catName = a;
        descSvc = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return positionName.length;
    }

    @Override
    public Object getItem(int i) {
        return positionName[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.listview_vol_svc, null);
        TextView positionNameTV = (TextView) v.findViewById(R.id.positionName);
        TextView comNameTV = (TextView) v.findViewById(R.id.comName);
        TextView svcDateTV = (TextView) v.findViewById(R.id.svcDate);
        TextView catNameTV = (TextView) v.findViewById(R.id.catName);
        TextView descSvcTV = (TextView) v.findViewById(R.id.descriptionSvc);

        String awa = positionName[i];
        String nam = comName[i];
        String dat = svcDate[i];
        String cat = catName[i];
        String des = descSvc[i];

        positionNameTV.setText(awa);
        comNameTV.setText(nam);
        svcDateTV.setText(dat);
        catNameTV.setText(cat);
        descSvcTV.setText(des);

        return v;
    }
}
