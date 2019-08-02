package com.solomonron.mystudent_pilot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.solomonron.mystudent_pilot.Common.Common;
import com.solomonron.mystudent_pilot.room.MyAppDatabase;
import com.solomonron.mystudent_pilot.room.StudentRoom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class RegisterSchools extends AppCompatActivity {


    public static MyAppDatabase myAppDatabase;
    private List<StudentRoom> RoomDB = new ArrayList<>();

    //משתני הדר-RV
    private RecyclerView rv_Header;
    private ArrayList<Kita> headerList = new ArrayList<>();
    private Header_Adapter mHeader_adapter;
    //משתני הדר-RV

    //משתני רשימת בתי ספר-RV
    private RecyclerView schoolListRV;
    private ArrayList<Kita> schoolList = new ArrayList<>();
    private SchoolListAdapter mSchoolListAdapter;


    private List<Kita> kindergardenList = new ArrayList<>();


    private TextView sampleTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "studentdb").allowMainThreadQueries().build();
        RoomDB = myAppDatabase.mMyDao().getStudents();


        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("city-name"));


        setContentView(R.layout.register_schools);
        sampleTV = findViewById(R.id.texttOsimple);
        //  sampleTV.setText(Common.currentItem.getCity());

        Intent intent = getIntent();

        headerList = intent.getParcelableArrayListExtra("Register_City");


        rv_Header = findViewById(R.id.cities_tab_RV);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rv_Header.setLayoutManager(mLayoutManager);
        mHeader_adapter = new Header_Adapter(headerList, this);
        rv_Header.setAdapter(mHeader_adapter);
        mHeader_adapter.notifyDataSetChanged();


        //String city = sampleTV.getText().toString()+"";


        schoolListRV = findViewById(R.id.school_choose_RV);
        RecyclerView.LayoutManager schoolLayoutManager = new LinearLayoutManager(getApplicationContext());
        schoolListRV.setLayoutManager(schoolLayoutManager);
     /*   mSchoolListAdapter = new SchoolListAdapter(schoolList);
        mSchoolListAdapter.notifyDataSetChanged();*/


    }

    BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String city = intent.getStringExtra("city");


            //sampleTV.setText(city);

            sendSchoolList(city);


        }
    };


    public void sendSchoolList(String city) {


        for (StudentRoom sr : RoomDB) {
            if (sr.getCity().equals(city)) {
                schoolList.add(new Kita(sr.getSchool()));
            }
        }

   /*     Set<Kita> filteredList = new HashSet<>(schoolList);
        schoolList.clear();
        schoolList.addAll(filteredList);*/

     /*   Set s= new HashSet(schoolList);
        schoolList = new ArrayList<>(s); */



     /*   boolean flag = true;
        for (StudentRoom sr : RoomDB) {
            if (sr.getCity().equals(city)) {
                String school = sr.getSchool();
                if (flag) {
                    schoolList.add(new Kita(school));
                    flag = false;
                } else {
                    boolean flag2 = true;
                    for (Kita kit : schoolList) {
                        while (flag2) {
                            if (school.equals(kit.getCity())) {
                                flag2 = false;
                            }

                        }
                        if (flag2 = false) {
                            break;
                        } else {
                            schoolList.add(new Kita(school));
                        }


                    }

                }
              *//*  for (Kita kit : schoolList) {
                    if (school.equals(kit.getSchool())) {
                        break;
                    }


                }*//*
            }
        }*/

        /*for (StudentRoom sr : RoomDB) {

            if (sr.getCity().equals(city)) {
                String school;

                school = sr.getSchool();
                schoolList.add(new Kita(school));


            }

        }*/
        mSchoolListAdapter = new SchoolListAdapter(schoolList);
        schoolListRV.setAdapter(mSchoolListAdapter);
        mSchoolListAdapter.notifyDataSetChanged();


    }


    public void sendKindergarenList(String city) {
        for (StudentRoom sr : RoomDB) {

            while (sr.getCity().equals(city)) {
                String kindergarden;

                kindergarden = sr.getKindergarden();
                kindergardenList.add(new Kita(kindergarden));


            }
        }
    }





 /*   @Override
    public void OnClickCityHeaderPosition(View view, String cityName) {


            sampleTV.setText(Common.currentItem.getCity());


    }*/


}
