package com.example.emilia.pfi3_2015_emilia_l_assignment3;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.AsyncTask;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.example.emilia.pfi3_2015_emilia_l_assignment3.skaneAPI.model.Journey;
import com.example.emilia.pfi3_2015_emilia_l_assignment3.skaneAPI.model.Journeys;
import com.example.emilia.pfi3_2015_emilia_l_assignment3.skaneAPI.xmlparser.Parser;

import java.util.ArrayList;

import static com.example.emilia.pfi3_2015_emilia_l_assignment3.R.id.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class Travels extends Fragment {


    ArrayList<Journey> journeyList = new ArrayList<Journey>();

    public Travels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travels, container,false);

        ExpandableListView expl = (ExpandableListView)view.findViewById(expandableListView);
        expl.setAdapter(new Adapter(getActivity(), journeyList));

        return view;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void finishedSearch (){


    }

    private class DoInBackground extends AsyncTask<String,Void,Long>{
        @Override
        protected Long DoInBackground(String... params){
            Journeys journeys = Parser.getJourneys(params[0]);

            journeyList.clear();
            journeyList.addAll(journeys.getJourneys());
            return null;

        }

        @Override
        protected void onPostExecute(Long result){
            finishedSearch();

        }

    }

}
