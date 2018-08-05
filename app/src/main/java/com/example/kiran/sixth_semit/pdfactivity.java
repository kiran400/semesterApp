package com.example.kiran.sixth_semit;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class pdfactivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<datalist> arrayList= new ArrayList<datalist>();
    String [] subName,subUrl;

    int[] imageid={R.drawable.studynotes,R.drawable.ssolution,R.drawable.qquestion,R.drawable.ssylabus,R.drawable.slideshare,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        recyclerView = findViewById(R.id.recyclerview);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);//improve perfomance

        subName = getResources().getStringArray(R.array.sixthSemSubject);//from string.xml we take country name array

        //Log.d("value", String.valueOf(subName.length));


        subUrl = getResources().getStringArray(R.array.seventhSemSubjectUrl);//url to show  in onclick of item



        int count = 0;





        for(count=0;count<subName.length;count++)
        {

                datalist listprovider = new datalist(subName[count],subUrl[count],imageid[count]);//stores data of 0 index in listprovideri.e which is instance of datalist
                //go to datalist constructor and initialized value there
                arrayList.add(listprovider);



        }




        adapter = new recyclerAdapter(arrayList, this);//sending data to recycleradapter..and context tooo
        recyclerView.setAdapter(adapter);//showing data in recycler view




    }

}
