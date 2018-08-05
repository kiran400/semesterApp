package com.example.kiran.sixth_semit;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //public static FragmentManager fragmentManager;//android.support.v4.app






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            //fragmentManager.beginTransaction()
            //        .add(R.id.pdf,blankFragment) //headcontainer is in main xml ..frame layout id//lhead is instance of Lasthead class
            //          .commit();


            //    soln_fragment soln_fragment = new soln_fragment();//instance of class lastbody


            // fragmentManager.beginTransaction()
            //.add(R.id.solution,soln_fragment)
            //.commit();


            notes notes = new notes();
            fragmentManager.beginTransaction()
                    .add(R.id.notescontainer, notes)
                    .commit();






            pdf pdffrag = new pdf();
            fragmentManager.beginTransaction()
                    .add(R.id.pdfcontainer, pdffrag)
                    .commit();




            //for eightsem fragment
            BlankFragment blankFragment = new BlankFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.eightsem, blankFragment)//replacing framelayout with id eight sem with blankfragment
                    .commit();



        }





    }
}
