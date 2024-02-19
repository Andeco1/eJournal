package com.example.ejournal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class adapter_ejournal extends ArrayAdapter<Learner> {

    public adapter_ejournal(@NonNull Context context, @NonNull ArrayList<Learner> arr) {
        super(context, R.layout.adapter_marks, arr);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Learner learner = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_marks, null);
            ((TextView) convertView.findViewById(R.id.full_name)).setText(learner.fullname);
            for (int i = 0; i < 10; i++) {
                if (Objects.equals(learner.marks.get(i).subject_name, learner.subject)) {
                    Marks m = learner.marks.get(i);

                    ((TextView) convertView.findViewById(R.id.pn)).setText(" "+Integer.toString(m.marks1.get(learner.week * 6))+" ");
                    ((TextView) convertView.findViewById(R.id.vt)).setText(" "+Integer.toString(m.marks1.get(learner.week * 6+1))+" ");
                    ((TextView) convertView.findViewById(R.id.sr)).setText(" "+Integer.toString(m.marks1.get(learner.week * 6+2))+" ");
                    ((TextView) convertView.findViewById(R.id.cht)).setText(" "+Integer.toString(m.marks1.get(learner.week * 6+3))+" ");
                    ((TextView) convertView.findViewById(R.id.pt)).setText(" "+Integer.toString(m.marks1.get(learner.week * 6+4))+" ");
                    ((TextView) convertView.findViewById(R.id.sb)).setText(" "+Integer.toString(m.marks1.get(learner.week * 6+5))+" ");
                }
            }


        }
        return convertView;
    }
}
