package com.example.oryossipof.alphahotal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Housekeeping extends AppCompatActivity {

    /*private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<Integer> draw = new ArrayList<Integer>(Arrays.asList(R.drawable.toilertries,R.drawable.towel2,R.drawable.clean,R.drawable.babybed,R.drawable.bed,R.drawable.papertoilet));
    private FeatureCoverFlow coverFlow;
    private CustomAdapter customAdapter;
    private TextSwitcher textSwitcher;
    private TextView tv ;
    String housekeeping[] = {"Toiletries","Towels","Room cleaning","Baby bed","Bedding","Paper toilet"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housekeeping);


      /*  tv  = (TextView)findViewById(R.id.securityTextView) ;

        textSwitcher = (TextSwitcher) findViewById(R.id.title);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(Housekeeping.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title , null);
                return  text;
            }
        });


        //Setting Animations..
        Animation in = AnimationUtils.loadAnimation(this , R.anim.slide_to_top);
        Animation out = AnimationUtils.loadAnimation(this , R.anim.slide_out_bottom);

        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);


        //Setting adapter for coverflow..
       // customAdapter = new CustomAdapter(draw , this);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverFlow);
        coverFlow.setAdapter(customAdapter);


        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                textSwitcher.setText(housekeeping[position]);
            }

            @Override
            public void onScrolling() {

            }
        });
    }*/



   /* private void initData() {

        for(int i = 1 ; i <= housekeeping.length ; i++){
            numbers.add(String.valueOf(i));
        }
    }*/
    }
}


