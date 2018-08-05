package com.example.kiran.sixth_semit;

public class datalist {


    private String subName,subUrl;


    private  int imageid;



    public datalist(String subName, String subUrl, int imageid)
    {
        this.subName = subName;
        this.subUrl = subUrl;
        this.imageid = imageid;

    }

    public String getSubName()
    {
        return subName;
    }

    public void setSubName(String subName)
    {
        this.subName = subName;
    }

    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl;
    }


    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }


}



