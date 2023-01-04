package main;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Runner {
static boolean is_loggedin= false;
	
	public static void login(boolean value){
		if(value)
		{
			System.out.println("user logged in");
		} else{
			System.out.println("Invalid login");
		}
	}
	
	public static void log_out(boolean v){
		if(v)
		{
			System.out.println("Invalid logout");
		} else{
			System.out.println("Successful logout");
		}
	}
	
	public static void inv_login(boolean b){
		
	}
    public static void main(String[] args) throws JSONException, IOException {
    	
    	Login login_maker = new Login();
    	login_maker.go_to_website();
    	
    	login_maker.valid_login();
    	set_is_loggedin();
    	login(is_loggedin);
    	
    	login_maker.log_out();
    	set_is_loggedin();
    	log_out(is_loggedin);
    	
    	login_maker.invalid_login();
    	set_is_loggedin();
    	login(is_loggedin);
    	
    	login_maker.valid_login();
    	set_is_loggedin();
    	login(is_loggedin);
    	
    	login_maker.close_driver();
	   
    }
    
    public static int Event_number() throws IOException, JSONException{
    	RequestMaker rm= new RequestMaker();
        String res = rm.makeEventGetRequest();
        
        JSONArray arr = new JSONArray(res);
	    JSONObject obj = arr.getJSONObject(0);
        
        int event = obj.getInt("eventLogType");
        System.out.println(event);
        return event;
    }
    
    public static void set_is_loggedin() throws IOException, JSONException{
    	RequestMaker rm= new RequestMaker();
        String login = rm.makeLoginGetRequest();
        
        JSONObject my_obj = new JSONObject(login);
        
        boolean status = my_obj.getBoolean("isLoggedInOnWebsite");
        if(status){
        	is_loggedin = true;
        }
        else{
        	is_loggedin = false;
        }
    }
}