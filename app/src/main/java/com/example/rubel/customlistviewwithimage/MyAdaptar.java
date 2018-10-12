package com.example.rubel.customlistviewwithimage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rubel on 11-Oct-18.
 */

public class MyAdaptar extends ArrayAdapter<String>{

    String[] name;
    int[] flags;
    Context mContext;

    public MyAdaptar(@NonNull Context context, String[] countryName,int[]countryFlag) {
        super(context, R.layout.listview_item);
        this.name = countryName;
        this.flags = countryFlag;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mflag = (ImageView) convertView.findViewById(R.id.img);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(mViewHolder);
        }
        else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
            mViewHolder.mflag.setImageResource(flags[position]);
            mViewHolder.mName.setText(name[position]);

        return convertView;
    }
    static class ViewHolder{
        ImageView mflag;
        TextView mName;
    }
}
