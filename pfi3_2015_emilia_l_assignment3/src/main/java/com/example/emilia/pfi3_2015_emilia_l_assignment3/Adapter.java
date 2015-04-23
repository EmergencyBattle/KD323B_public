package com.example.emilia.pfi3_2015_emilia_l_assignment3;

/**
 * Created by Emilia on 16.4.2015.
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
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
        convertView = li.inflate(R.layout.list_item_collapsed,null);

        //Journey journey = j.get(groupPosition);


        TextView depTime = (TextView) convertView.findViewById(R.id.textViewDepTime);
        String departure = "Linje " + j.get(groupPosition).getLineOnFirstJourney();
        depTime.setText(departure);

        TextView arrTime = (TextView) convertView.findViewById(R.id.textViewArrTime);
        String arrival = "Ankommer om " + j.get(groupPosition).getTimeToDeparture() + " min";
        arrTime.setText(arrival);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.list_item_expanded,null);

        //Journey journey = j.get(groupPosition);

        TextView depTimeDev = (TextView) convertView.findViewById(R.id.textViewDepTimeDev);
        if (j.get(groupPosition).getDepTimeDeviation() != "") {
        String deviation = "Försening " + j.get(groupPosition).getDepTimeDeviation().toString();
        depTimeDev.setText(deviation);
        } else {
        String deviation = "I tid";
            depTimeDev.setText(deviation);
        }

        TextView travelMinutes = (TextView) convertView.findViewById(R.id.textViewTravelMinutes);
        String time = "Restid " + j.get(groupPosition).getTravelMinutes().toString() + " min";
        travelMinutes.setText(time);

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