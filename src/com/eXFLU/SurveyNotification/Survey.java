package com.eXFLU.SurveyNotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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
        	        	
	    	String url = "http://google.com";
        	Intent myIntent = new Intent(Intent.ACTION_VIEW);
        	myIntent.setData(Uri.parse(url));
        	startActivity(myIntent);
        	
        	try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			goBacktoMain(); //works now
        	//need to go back to the main thread
	    }
	   
	   private void goBacktoMain()
	   {
		   Intent mainIntent = new Intent(this, SurveyNotification.class);
		   mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		   startActivity(mainIntent);
		  
	   }
}
