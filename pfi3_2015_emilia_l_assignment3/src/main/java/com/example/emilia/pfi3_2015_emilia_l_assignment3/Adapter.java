package com.example.emilia.pfi3_2015_emilia_l_assignment3;

/**
 * Created by Emilia on 16.4.2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.Calendar;

import com.example.emilia.pfi3_2015_emilia_l_assignment3.skaneAPI.model.Journey;

import java.util.ArrayList;

public class Adapter extends BaseExpandableListAdapter {

    private ArrayList<Journey> j;
    private Context c;

    public Adapter (Context c, ArrayList<Journey> j){
        this.j = j;
        this.c = c;
    }

    @Override
    public int getGroupCount(){
        return j.size();
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return 1;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.fragment_travels,null);
        TextView tvCourse = (TextView) convertView.findViewById(R.id.tv_course);
        String course = j.get(groupPosition).getCourse();
        tvCourse.setText(course);
        TextView tvDate =(TextView) convertView.findViewById(R.id.tv_date);
        String date = j.get(groupPosition).getDate();
        tvDate.setText(date);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.fragment_travels,null);

        TextView arrTime = (TextView) convertView.findViewById(R.id.arrTime);
        String room = j.get(groupPosition).getArrDateTime().toString();
        arrTime.setText(room);

        TextView depTime = (TextView) convertView.findViewById(R.id.depTime);
        String start = j.get(groupPosition).getDepDateTime().toString();
        depTime.setText(start);

        return convertView;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}