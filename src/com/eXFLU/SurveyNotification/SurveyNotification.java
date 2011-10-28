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
	private boolean wifiChecking = false;
	private boolean isAppRunning = true;
	private boolean wifiConnection = false;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        if (isAppRunning)
        {
        	if (wifiChecking == false)
        	{
        		timer();
        	}
        	if (wifiChecking == true)
        	{
        		if (wifiConnection) //if the device is connected to a wifi network
        		{
        			sendNotification();
        		}
        	}
        	// if the device isn't connected to a wifi network
        	else   //eventually have a storage type system here, to store the bluetooth information
        	{
        		 TextView tv = new TextView(this);
        	     tv.setText("[NO WIFI]");
        	     setContentView(tv);
       		}
        wifiChecking = false;
	    }

    }   
    
    /**checkWifi changes the boolean 'wifiConnection'. If the device is connected to Wifi, it sets 'wifiConnection' to true.
    Otherwise it sets it to false.*/ 
    private void checkWifi()
	{
		WifiManager myWifi;  
	    myWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	    WifiInfo myWifiInfo = myWifi.getConnectionInfo();
	    
	    if (myWifiInfo.getNetworkId() != -1)
	    	wifiConnection = true;
	    else
	    	wifiConnection = false;
	}
    
    /**timer makes the thread sleep (30 seconds right now) and then sets wifiChecking to true*/
    public void timer()
    {
    	 try
         {
 			Thread.sleep(15000);
 		} catch (InterruptedException e)
 		{
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		checkWifi();
 		wifiChecking = true;
    }
    
    /**sendNotification sends a Notification to the user that launches the Survey class*/
    private void sendNotification()
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
}