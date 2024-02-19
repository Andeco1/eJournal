package com.example.ejournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adapter_learnres_and_parents extends ArrayAdapter<Learner> {

    public adapter_learnres_and_parents(@NonNull Context context, @NonNull ArrayList<Learner> arr) {
        super(context, R.layout.lpadapter_item, arr);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Learner learner = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lpadapter_item,null);
        }
        ((TextView) convertView.findViewById(R.id.learner_name)).setText(learner.fullname);
        ((TextView) convertView.findViewById(R.id.parent1)).setText(learner.parents.get(0).fullname);
        ((TextView) convertView.findViewById(R.id.parent2)).setText(learner.parents.get(1).fullname);
        return convertView;
    }
}
