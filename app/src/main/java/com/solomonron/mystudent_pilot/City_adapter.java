package com.solomonron.mystudent_pilot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.solomonron.mystudent_pilot.room.StudentRoom;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class City_adapter extends RecyclerView.Adapter<City_adapter.KitaViewHolder> {

    private final List<Kita> citiesList;
/*    private Context mContext;
    private List<Kita> mKitaList;
    private List<Kita> mKitaListfull;*/





    public City_adapter(List<Kita> citiesList) {
        this.citiesList = citiesList;
    }

    @NonNull
    @Override
    public KitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_register_row, parent, false);

        //KitaViewHolder holder = new KitaViewHolder(view);

        return new KitaViewHolder(view);
    }

    class KitaViewHolder extends RecyclerView.ViewHolder {

        ImageView not_selected_row;
        ImageView selected_row;
        TextView not_selected_tv;
        TextView selected_tv;


        KitaViewHolder(@NonNull View itemView) {
            super(itemView);
            not_selected_row = itemView.findViewById(R.id.info_row_not_selected);
            selected_row = itemView.findViewById(R.id.info_row_selected);
            not_selected_tv = itemView.findViewById(R.id.city_not_selected_TV);
            selected_tv = itemView.findViewById(R.id.city_selected_TV);
        }
    }






    @Override
    public void onBindViewHolder(@NonNull final KitaViewHolder holder, final int position) {




        final Kita kita = citiesList.get(position);



        holder.not_selected_tv.setText(kita.getCity());
        holder.selected_tv.setText(kita.getCity());

        holder.not_selected_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kita.setSelected(!kita.isSelected());
                holder.not_selected_row.setVisibility(View.INVISIBLE);
                holder.not_selected_tv.setVisibility(View.INVISIBLE);
                holder.selected_row.setVisibility(View.VISIBLE);
                holder.selected_tv.setVisibility(View.VISIBLE);







            }
        });

        holder.selected_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kita.setSelected(!kita.isSelected());
                holder.not_selected_row.setVisibility(View.VISIBLE);
                holder.not_selected_tv.setVisibility(View.VISIBLE);
                holder.selected_row.setVisibility(View.INVISIBLE);
                holder.selected_tv.setVisibility(View.INVISIBLE);





            }
        });

    }


    @Override
    public int getItemCount() {
        //return mKitaList.size();
        return citiesList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);

    }


    //קונסטרקטור לחיפוש ערים
   /* public void updateList(List<Kita> newList) {

        mKitaList = newList;
       // mKitaListfull = newList;


        notifyDataSetChanged();

    }*/


}


