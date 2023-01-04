package com.uom.cps3230.GeneralModel;

public class Alert {
    protected int price;
    protected String heading;
    protected String description;
    protected int typeAlert;
    protected String link;
    protected String img;

    protected String user_id = "73ed1cab-f8c2-4ff8-84b6-d7f81d835829";

    public Alert(Integer _price,String _title,String _description,Integer _typeAlert,String _link,String _img){
        price = _price;
        heading = _title;
        description = _description;
        typeAlert = _typeAlert;
        link= _link;
        img =_img;
    }

}
