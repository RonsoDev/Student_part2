package com.solomonron.mystudent_pilot;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RegisterCities extends AppCompatActivity {

    private RecyclerView rv_cities;
    private ArrayList<Kita> mKitaArrayList = new ArrayList<>();
    private Kita_adapter mKita_adapter;
    private ImageView next_btn;
    private SearchView city_search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_cities);

        city_search = findViewById(R.id.searchView_cities);
        city_search.setQueryHint("חפש עיר");
        city_search.setImeOptions(EditorInfo.IME_ACTION_DONE);

        city_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                String userinput = newText.toLowerCase();
                List<Kita> newlist = new ArrayList<>();

                for (Kita kita : mKitaArrayList) {
                    if (kita.getCity().toLowerCase().contains(userinput)) {
                        int id= kita.getId();
                        String city= kita.getCity();
                        newlist.add(kita );
                    }
                }


                mKita_adapter.updateList(newlist);
                return false;
            }
        });


        rv_cities = findViewById(R.id.RV_register_cities);
       // rv_cities.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_cities.setLayoutManager(mLayoutManager);

        mKita_adapter = new Kita_adapter(mKitaArrayList);
        rv_cities.setAdapter(mKita_adapter);
        mKita_adapter.notifyDataSetChanged();
        next_btn = findViewById(R.id.button_next_cities);

        mKitaArrayList.add(new Kita(0, "TEL AVIV"));
        mKitaArrayList.add(new Kita(1, "YAVNE"));
        mKitaArrayList.add(new Kita(2, "RISHON"));
        mKitaArrayList.add(new Kita(3, "REHOVOT"));
        mKitaArrayList.add(new Kita(4, "HOLON"));
        mKitaArrayList.add(new Kita(5, "BAT YAM"));
        mKitaArrayList.add(new Kita(6, "HAIFA"));
        mKitaArrayList.add(new Kita(7, "HERZLIA"));

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}
