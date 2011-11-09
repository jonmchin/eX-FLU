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
			//goBacktoMain(); //for some reason it doesn't go back to the main thread
			sendNotification(); //works, although user has to click on notification
        	//need to go back to the main thread
	    }
	   
	   private void goBacktoMain()
	   {
		   Intent mainIntent = new Intent(this, SurveyNotification.class);
		   startActivity(mainIntent);
	   }
	   private void sendNotification()
	    {
	    	String ns = Context.NOTIFICATION_SERVICE;
	    	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
	    
	    	int icon = R.drawable.icon;
	    	CharSequence tickerText = "Go Back";
	    	long time = System.currentTimeMillis();

	    	Notification notification = new Notification(icon, tickerText, time);
	    	notification.flags |= Notification.FLAG_AUTO_CANCEL;
	    
	    	Context context = getApplicationContext();
	    	CharSequence contentTitle = "Go Back";
	    	CharSequence contentText = "Go Back to main thread";
	    	
	    	Intent notificationIntent = new Intent(this, SurveyNotification.class);
	    	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	    	notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

	    	final int Notification_ID = 1; //unique id for this specific notification
	    	mNotificationManager.notify(Notification_ID, notification);	
	    }

}
