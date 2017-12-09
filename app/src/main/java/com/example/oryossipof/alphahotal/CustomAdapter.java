package com.example.oryossipof.alphahotal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    private ArrayList<SelectOption> arrayList;
    private Context mContext;

    public CustomAdapter(ArrayList<SelectOption> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public SelectOption getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
final int index = i;
        if(view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_item , viewGroup, false);
            Button mBtn = (Button) view.findViewById(R.id.item_button);

        mBtn.setBackgroundResource(getItem(i).getDrawable());


            mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, getItem(index).getIntent());
                    mContext.startActivity(intent);
                }
            });
        }

        return  view;
    }
}
