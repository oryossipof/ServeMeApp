package com.example.oryossipof.alphahotal;

        import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MaintenanceActivity extends Activity {

    private ListView mListView ;
    private Context context;
    private int[] darwablename = { R.drawable.safe2,R.drawable.volte,R.drawable.plum,R.drawable.door2,R.drawable.phone,R.drawable.call3};
    String maintenance[] = {"Fix Safe","Power failure","Plumbing fault","Fix door","Fix phone","Call"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_maintenance);



        mListView = (ListView) findViewById(R.id.lv_housekeeping);
        final CutomAdapter2 adapter = new CutomAdapter2();
        mListView.setAdapter(adapter);
        context=this;


    }

    class CutomAdapter2 extends BaseAdapter
    {


        @Override
        public int getCount() {
            return darwablename.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.listview_layout,null);
            ImageView iv= (ImageView) view.findViewById(R.id.imageviewlayout);
            TextView textview = (TextView) view.findViewById(R.id.textviewLayout);
            iv.setImageResource(darwablename[i]);
            textview.setText(maintenance[i]);

            return view;
        }
    }
}
