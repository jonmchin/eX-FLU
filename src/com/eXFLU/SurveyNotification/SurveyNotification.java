package com.eXFLU.SurveyNotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

//won't have launcher, Bluetooth class will call this which will then call Survey Class
public class SurveyNotification extends Activity
{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        WifiManager myWifi;  
	    myWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	    WifiInfo myWifiInfo = myWifi.getConnectionInfo();
	    
	    while (myWifiInfo.getNetworkId() == -1)
	    {
	    	//store information until user gets into wifi area
	    }
	  
	    if (myWifiInfo.getNetworkId() != -1) //if the device is connected to a wifi network
	    {
	    	String ns = Context.NOTIFICATION_SERVICE;
	    	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
        
	    	int icon = R.drawable.icon;
	    	CharSequence tickerText = "Take a Survey!";
	    	long time = System.currentTimeMillis();

	    	Notification notification = new Notification(icon, tickerText, time);
	    	notification.flags |= Notification.FLAG_AUTO_CANCEL;
        
	    	Context context = getApplicationContext();
	    	CharSequence contentTitle = "Survey";
	    	CharSequence contentText = "Please take this survey";
	    	
	    	Intent notificationIntent = new Intent(this, Survey.class);
	    	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	    	notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
	    	
	    	final int Notification_ID = 1;
	    	
	    	mNotificationManager.notify(Notification_ID, notification);
	    	
	    }
	    
		// if the device isn't connected to a wifi network
	    else    //eventually have a storage type system here, to store the bluetooth information
	    {
	    	TextView tv = new TextView(this);
	    	tv.setText("[NO WIFI]");
       		setContentView(tv);
	    }
    }
}