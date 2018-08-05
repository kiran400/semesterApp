package com.example.kiran.sixth_semit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class displayUrl extends AppCompatActivity {

//now we write other code ourselves as this is just a java class not an activity


    TextView mtextview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_disurl);//setContentVIew(view View)

        Log.d("urlcheck","displayurl works fine");


        getIncomingIntent();//calling getincomingintent method

    }

    //now getiing data from intent

    private  void getIncomingIntent(){
        Log.d("incomingintent","inside incoming intent");

        //so first we check whether intent has anything to receive or not using if cause if there was nothing to receive
        //and we uesd getExtra() method from intent it will result in app crash

        if(getIntent().hasExtra("urldata")){//if 2 incoming data from intent we simply use && and then getintent().hasextra()


            //...in a same way repeat it again from beginning
           //NOTE: //(getIntent().hasExtra("urldata") &&(getIntent().hasExtra("xyz"){...}


        //
          String urldata = getIntent().getStringExtra("urldata");


            //now urldata has the url..it get of every recyclerview according to position
            //we get url of data we click from recylcer item


            setUrl(urldata);//calling setUrl method

        }
    }


    private void setUrl(String urldata){


     //now showing the data using URI
        Uri uri = Uri.parse(urldata); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);


      //  mtextview=(TextView)findViewById(R.id.txtview);
        //mtextview.setText(urldata);



    }

}





