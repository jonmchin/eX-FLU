package com.eXFLU.SurveyNotification;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Survey extends Activity
{	
			//SurveyNotification mySurveyNotification = new SurveyNotification();
	   @Override
	    public void onCreate(Bundle savedInstanceState)
	    {  //this class is where we'll put the survey
	        super.onCreate(savedInstanceState);
	               

        	Intent startSurveyNotification = new Intent(this, SurveyNotification.class);
        	startActivity(startSurveyNotification);
        	
	    	String url = "http://google.com";
        	Intent myIntent = new Intent(Intent.ACTION_VIEW);
        	myIntent.setData(Uri.parse(url));
        	startActivity(myIntent);
        	//mySurveyNotification.timer();
        	//need to go back to the main thread
	    }

}
