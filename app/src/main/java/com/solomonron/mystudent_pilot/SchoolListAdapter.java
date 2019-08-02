package com.solomonron.mystudent_pilot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.SchoolViewHolder> {

    private final List<Kita> schoolList;

    public SchoolListAdapter(List<Kita> schoolList) {
        this.schoolList = schoolList;
    }


    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_choose_row_item, parent, false);
        return new SchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder holder, int position) {

        final Kita kita = schoolList.get(position);

        holder.schoolName.setText(kita.getCity());
        holder.school_choose_chkbox_empty.setVisibility(View.VISIBLE);
        holder.school_choose_chkbox_full.setVisibility(View.INVISIBLE);

        //holder.schoolName.setText("כל הכבוד");


    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }


    public class SchoolViewHolder extends RecyclerView.ViewHolder {

        ImageView school_choose_bg;
        ImageView school_choose_chkbox_empty;
        ImageView school_choose_chkbox_full;
        TextView schoolName;


        public SchoolViewHolder(@NonNull View itemView) {
            super(itemView);

            school_choose_bg = itemView.findViewById(R.id.school_choose_bg);
            school_choose_chkbox_empty = itemView.findViewById(R.id.school_choose_chkbox_empty);
            school_choose_chkbox_full = itemView.findViewById(R.id.school_choose_chkbox_full);
            schoolName = itemView.findViewById(R.id.schoolName);
        }
    }


}
