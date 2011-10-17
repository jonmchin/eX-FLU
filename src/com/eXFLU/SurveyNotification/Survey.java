package com.eXFLU.SurveyNotification;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class Survey extends Activity
{
	   @Override
	    public void onCreate(Bundle savedInstanceState)
	    {  //this class is where we'll put the survey
	        super.onCreate(savedInstanceState);
	        
	        String url = "http://SurveyMonkey.com";
	        Intent myIntent = new Intent(Intent.ACTION_VIEW);
	        myIntent.setData(Uri.parse(url));
	        startActivity(myIntent);
	       /* TextView tv = new TextView(this);
	        tv.setText("[Insert Survey]");
	        setContentView(tv);*/
	    }

}
