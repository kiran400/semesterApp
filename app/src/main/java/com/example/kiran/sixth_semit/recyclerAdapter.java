package com.example.kiran.sixth_semit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {//recyclerviewholder class should be declare below


    private Context mcontext;//context is used to map view and resource
    //context should be passed while using intent for onclick listener

    private ArrayList<datalist> array_list = new ArrayList<datalist>();


    //NOTE::::::::::
    //EVERY VARIABLE THAT WE CREATED SHOULD BE IN CONSTRUCTOR ..I.E CONTEXT TOO
    //CONTEXT IS USED TO KNOW MAYBE FROM WHERE WE ARE GOING TO WHERE

    recyclerAdapter(ArrayList<datalist> array_list, Context mcontext){

       this.array_list = array_list;
       this.mcontext = mcontext;//we should initialize context also otherwise it won't work
    }






    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerViewHolder recyclerViewHolder;
        //from list_layout.xml
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);

        recyclerViewHolder =  new RecyclerViewHolder(view);

        return recyclerViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ////use to put data on view can be card view, list view....so we need position + data from class list_provider

        //from using list_provider java class
       final datalist listprovider;

        listprovider = array_list.get(position);//get positon here and used in next line code to replace data on view

        holder.mtextview.setText(listprovider.getSubName());

        //to add image in recycler view

        holder.imgView.setImageResource(listprovider.getImageid());

     //NOTE::::::::

        //on bind view holder actuall work for onclick listener happens
//this method works because of position argument we have and as this is called for every element on recycler view


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {//use ctrl+space to directly get on click listener after writing new
            @Override
            public void onClick(View v) {

            Log.d("TAG","you clicker"+listprovider.getSubName());//to check whether click is correct or not

              //here we need to specify context otherwise intent wont't work ...it works directly in main acivty but not in many other place



                Intent intent = new Intent(mcontext,displayUrl.class);

                intent.putExtra("urldata",listprovider.getSubUrl());//urldata is the keyword that now has stored subUrl
                mcontext.startActivity(intent);//without using mcontext we cannot start activity
                //as we are in recylceradapter and it doesn't know the context from where activity is to get started
                //in main activvity we don't need it as maybe the activity always get started first from it




            }
        });



    }

    @Override
    public int getItemCount() {
        Log.d("value1", String.valueOf(array_list.size()));
        return array_list.size();
    }
}


    class RecyclerViewHolder extends RecyclerView.ViewHolder{


    TextView mtextview;
    ImageView imgView;

    //for onclicl listener initialinzing Linear layout and pointing on it's id
        LinearLayout linearLayout;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            mtextview = itemView.findViewById(R.id.capital_id);

            imgView= itemView.findViewById(R.id.img_id);

            //here for onclick listener

            linearLayout= itemView.findViewById(R.id.layout_linear);//pointing to linear layout using it;s id layout_linear

        }
    }



