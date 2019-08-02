package com.solomonron.mystudent_pilot;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.solomonron.mystudent_pilot.Common.Common;
import com.solomonron.mystudent_pilot.interface_itemView.ItemClickListener;
import com.solomonron.mystudent_pilot.room.StudentRoom;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

public class Header_Adapter extends RecyclerView.Adapter<Header_Adapter.HeaderViewHolder> {

    private ArrayList<Kita> hdrList;
    int row_index = -1;
    //String cityHeaderName = "";
    Context mContext;
    Kita kita = new Kita();





    @NonNull
    @Override
    public HeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_row_item_city, parent, false);

        return new HeaderViewHolder(view);
    }


    public Header_Adapter(ArrayList<Kita> hdrList, Context mContext) {

        this.mContext = mContext;
        this.hdrList = hdrList;
    }


    @Override
    public void onBindViewHolder(@NonNull final HeaderViewHolder holder, final int position) {

        //boolean flag = true ;


        final Kita city = hdrList.get(position);

         String cityShem = city.getCity();


        if (row_index == -1  )  {
// הוגדר אובייקט של קיטה במיקום אפס על מנת לאלץ את הברודקסט לשלוח את העיר הראשונה שמפויעה בהדר-רסייקלרויו

            final Kita cityPosZero = hdrList.get(0);
            final String cityShemPosZero = cityPosZero.getCity();


            sendCityName(cityShemPosZero);


            holder.selected_city_header.setBackgroundColor(0xFFFAFAFA);

            holder.header_selected_city_TV.setTextColor(0xFF000000);
            holder.header_selected_city_TV.setText(city.getCity());
            row_index = 0;
           // flag = false;

        }




        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void Onclick(View view, int position) {
                row_index = position;

                //Common.currentItem = hdrList.get(position);
                notifyDataSetChanged();
            }
        });
   /*     cityHeaderName = hdrList.get(position).getCity();


        holder.setCityNameToRegisterSchool(new CityNameToRegisterSchool() {
            @Override
            public void OnClickCityHeaderPosition(View view, String cityName) {
                //mCityNameToRegisterSchool.OnClickCityHeaderPosition(city.getCity());
                //cityHeaderName = cityName;

                notifyDataSetChanged();

            }
        });*/


        if (row_index == position  ) {
            sendCityName(cityShem);
            holder.selected_city_header.setBackgroundColor(0xFFFAFAFA);
            holder.header_selected_city_TV.setTextColor(0xFF000000);
            holder.header_selected_city_TV.setText(city.getCity());


        } else {

            holder.selected_city_header.setBackgroundColor(0xFFFFEB3B);
            holder.header_selected_city_TV.setTextColor(0xFF90A4AE);
            holder.header_selected_city_TV.setText(city.getCity());
        }

       /* holder.selected_city_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/


    }

    public void sendCityName(String cityName) {


        Intent intent = new Intent("city-name");

        intent.putExtra("city", cityName);
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
    }


    @Override
    public int getItemCount() {
        return hdrList.size();
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ItemClickListener mItemClickListener;



        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.mItemClickListener = itemClickListener;
        }


        ConstraintLayout selected_city_header;
        TextView header_selected_city_TV;


        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);


            selected_city_header = itemView.findViewById(R.id.selected_city_header);
            header_selected_city_TV = itemView.findViewById(R.id.header_selected_city_TV);

            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            mItemClickListener.Onclick(v, getAdapterPosition()); // על מנת שבכל לחיצה הכותרת הרלוונטית תהיה בצבע שונה
        }
    }
}

