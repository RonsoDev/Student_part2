package com.solomonron.mystudent_pilot.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MyDao {


    @Insert
    public void addStudent(StudentRoom studentRoom);

    @Query("select * from StudentRoom")
    public List<StudentRoom> getStudents();

    @Query("DELETE FROM StudentRoom")
    public void nukeTable();


}
