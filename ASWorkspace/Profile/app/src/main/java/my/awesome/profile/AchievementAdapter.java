package my.awesome.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.my.profile.R;

public class AchievementAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private ListView awardList;
    private String[] awardName;
    private String[] issuerName;
    private String[] issuedDate;
    private String[] credID;
    private String[] descAward;

    public AchievementAdapter(Context c, String[] a, String[] i, String[] s, String[] r, String[] d) {
        awardName = a;
        issuerName = i;
        issuedDate = s;
        credID = r;
        descAward = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return awardName.length;
    }

    @Override
    public Object getItem(int i) {
        return awardName[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.listview_achievement, null);
        TextView awardNameTV = (TextView) v.findViewById(R.id.awardName);
        TextView issuerNameTV = (TextView) v.findViewById(R.id.issuerName);
        TextView issuedDateTV = (TextView) v.findViewById(R.id.issuedDate);
        TextView credIDTV = (TextView) v.findViewById(R.id.credID);
        TextView descAwardTV = (TextView) v.findViewById(R.id.descriptionAward);

        String awa = awardName[i];
        String nam = issuerName[i];
        String dat = issuedDate[i];
        String cre = credID[i];
        String des = descAward[i];

        awardNameTV.setText(awa);
        issuerNameTV.setText(nam);
        issuedDateTV.setText(dat);
        credIDTV.setText(cre);
        descAwardTV.setText(des);

        return v;
    }
}
