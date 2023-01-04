package com.uom.cps3230.AlertLimit;


import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AlertLimitRunner {

    int n_alerts;
    boolean is_over_limit = false;

    boolean is_zero = true;
    protected Request_maker rm = new Request_maker();

    public int getN_alerts() {
        return n_alerts;
    }

    public boolean is_over_limit() {
        return is_over_limit;
    }

    public boolean is_zero() {
        return is_zero;
    }

    public void create_alert() throws IOException {
        Alert my_alert= new Alert(123,"title","descr",5,"link","img");
        rm.makePostRequest(my_alert);
        n_alerts = get_number_of_alerts();
        if (n_alerts > 5){
            is_over_limit = true;
        }

        if (n_alerts >0){
            is_zero = false;
        }
    }

    public void delete_alerts() throws IOException {
        rm.makeDeleteRequest();
        n_alerts = get_number_of_alerts();

        if(n_alerts ==0){
            is_zero = true;
            is_over_limit = false;
        }
        else if (n_alerts >5){
            is_over_limit = true;
        }
        else{
            is_over_limit = false;
        }
    }

    public int get_number_of_alerts() throws IOException {
        Request_maker rm= new Request_maker();
        String res = rm.makeEventGetRequest();

        JSONArray arr = new JSONArray(res);
        JSONObject my_obj = arr.getJSONObject(0);

        int len = my_obj.getJSONObject("systemState").getJSONArray("alerts").length();
        System.out.println("Number of alerts is: "+len);
        return len;
    }
}
