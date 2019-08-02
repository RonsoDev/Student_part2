package com.solomonron.mystudent_pilot;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.solomonron.mystudent_pilot.room.MyAppDatabase;
import com.solomonron.mystudent_pilot.room.StudentRoom;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class RegisterCities extends AppCompatActivity {

    private RecyclerView rv_cities;
    private ArrayList<Kita> mKitaArrayList = new ArrayList<>();
    private City_adapter mCity_adapter;
    private ImageView next_btn;
    private SearchView city_search;
    public MyAppDatabase myAppDatabase;
    private List<StudentRoom> citiesList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.register_cities);

        city_search = findViewById(R.id.searchView_cities);
        city_search.setQueryHint("חפש עיר");
        city_search.setImeOptions(EditorInfo.IME_ACTION_DONE);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "studentdb").allowMainThreadQueries().build();

        myAppDatabase.mMyDao().nukeTable();//פלסטר שנוכל להמשיך לעבוד בלי שזה יקרוס כל התקנה. יש למחוק את השורה הזאת בשלב מסוים על מנת להתמודד עם הבעיה שהדאטבייס מיוצר כל פעם מחדש ולכן מקריס את האפליקציה


        final StudentRoom studentRoom = new StudentRoom(0, "מיכל", "שוקר", "א1", "ביאליק", "-", "חולון");
        final StudentRoom studentRoom1 = new StudentRoom(1, "רון", "סולומון", "א1", "ביאליק", "-", "חולון");
        final StudentRoom studentRoom2 = new StudentRoom(2, "זיו", "אברמוביץ", "א3", "הס", "-", "תל אביב");
        final StudentRoom studentRoom3 = new StudentRoom(3, "דוד", "זוהר", "גן שושן", "-", "אשכול גנים נחמה", "תל אביב");
        final StudentRoom studentRoom4 = new StudentRoom(4, "סשה", "ברון כהן", "גן חנה", "-", "אשכול גנים ורד", "אשקלון");
        final StudentRoom studentRoom5 = new StudentRoom(5, "דני", "שובבני", "ב4", "ניב", "-", "ראשון לציון");
        final StudentRoom studentRoom6 = new StudentRoom(6, "רזיאל", "משהו", "גן כוכבה", "-", "אשכול גנים לילך", "ראשון לציון");
        final StudentRoom studentRoom7 = new StudentRoom(7, "צור", "בן עמי", "א2", "ראשונים", "-", "רחובות");


        myAppDatabase.mMyDao().addStudent(studentRoom);
        myAppDatabase.mMyDao().addStudent(studentRoom1);
        myAppDatabase.mMyDao().addStudent(studentRoom2);
        myAppDatabase.mMyDao().addStudent(studentRoom3);
        myAppDatabase.mMyDao().addStudent(studentRoom4);
        myAppDatabase.mMyDao().addStudent(studentRoom5);
        myAppDatabase.mMyDao().addStudent(studentRoom6);
        myAppDatabase.mMyDao().addStudent(studentRoom7);


        citiesList = myAppDatabase.mMyDao().getStudents();


        rv_cities = findViewById(R.id.RV_register_cities);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_cities.setLayoutManager(mLayoutManager);

        final List<Kita> cityName = new ArrayList<>();

        String city = " ";


        // יוצר רשימת ערים מהסטיודנטרום ומכניס לתוך רשימה מסוג קיטה
        for (StudentRoom sr : citiesList) {
            while (!sr.getCity().equals(city)) {
                city = sr.getCity();
                cityName.add(new Kita(city));


            }
        }


        mCity_adapter = new City_adapter(cityName);
        rv_cities.setAdapter(mCity_adapter);
        mCity_adapter.notifyDataSetChanged();
        next_btn = findViewById(R.id.button_next_cities);


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<Kita> idList = new ArrayList<>();


                for (Kita kita : cityName) {
                    if (kita.isSelected())
                        idList.add(new Kita(kita.getCity()));


                }

                if (!idList.isEmpty()) {
                  //  Intent intent = new Intent(RegisterCities.this, RegisterSchools.class);
                    Intent intent = new Intent(RegisterCities.this, RegisterSchools.class);

                    intent.putParcelableArrayListExtra("Register_City", idList);
                    startActivity(intent);
                    Toast.makeText(RegisterCities.this, "כעת יש לבחור בתי ספר/גנים", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(RegisterCities.this, "יש לבצע בחירה של לפחות עיר אחת", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }


}
