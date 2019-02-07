package com.solomonron.mystudent_pilot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Kita_adapter extends RecyclerView.Adapter<Kita_adapter.KitaViewHolder> {

    private Context mContext;
    private List<Kita> mKitaList;
    private List<Kita> mKitaListfull;


    public Kita_adapter(Context context, List<Kita> kitaList) {
        this.mContext = context;
        this.mKitaList = kitaList;


    }

    public Kita_adapter(List<Kita> kitaList) {
        this.mKitaList = kitaList;

        //mKitaListfull = new ArrayList<>(mKitaList);

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




    @NonNull
    @Override
    public KitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_register_row, parent, false);

        //KitaViewHolder holder = new KitaViewHolder(view);

        return new KitaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final KitaViewHolder holder, int position) {


        Kita kita = mKitaList.get(position);

        holder.not_selected_tv.setText(kita.getCity());
        holder.selected_tv.setText(kita.getCity());

        holder.not_selected_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                holder.not_selected_row.setVisibility(View.INVISIBLE);
                holder.not_selected_tv.setVisibility(View.INVISIBLE);
                holder.selected_row.setVisibility(View.VISIBLE);
                holder.selected_tv.setVisibility(View.VISIBLE);

            }
        });

        holder.selected_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.not_selected_row.setVisibility(View.VISIBLE);
                holder.not_selected_tv.setVisibility(View.VISIBLE);
                holder.selected_row.setVisibility(View.INVISIBLE);
                holder.selected_tv.setVisibility(View.INVISIBLE);

            }
        });

    }


  /*  @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }*/
    @Override
    public int getItemCount() {
        return mKitaList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);

    }

    public void updateList(List<Kita> newList) {

        mKitaList = newList;
       // mKitaListfull = newList;


        notifyDataSetChanged();

    }


}


