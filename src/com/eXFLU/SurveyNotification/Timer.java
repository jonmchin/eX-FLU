package com.eXFLU.SurveyNotification;

import android.os.CountDownTimer;

public class Timer extends CountDownTimer
{
	public boolean timerdone = false;
	public Timer(long time, long interval)
	{
		super(time, interval);
	}

	@Override
	public void onFinish() 
	{
		timerdone = true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTick(long arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	

}
