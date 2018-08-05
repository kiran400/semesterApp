package com.example.kiran.sixth_semit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class eight_sem extends AppCompatActivity {



    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<datalist> arrayList= new ArrayList<datalist>();
    String [] subName,subUrl;

    int[] imageid={R.drawable.studynotes,R.drawable.ssolution,R.drawable.qquestion,R.drawable.ssylabus,R.drawable.slideshare,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_sem);



        recyclerView = findViewById(R.id.recyclereightview);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);//improve perfomance


        subName = getResources().getStringArray(R.array.sixthSemSubject);//from string.xml we take country name array

        //Log.d("value", String.valueOf(subName.length));


        subUrl = getResources().getStringArray(R.array.eigthSemSubjectUrl);//url to show  in onclick of item



        int count = 0;



        for(count=0;count<subName.length;count++)
        {

            datalist listprovider = new datalist(subName[count],subUrl[count],imageid[count]);//stores data of 0 index in listprovideri.e which is instance of datalist
            //go to datalist constructor and initialized value there
            arrayList.add(listprovider);



        }


        adapter = new recyclerAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);//showing data in recycler view

    }
}
