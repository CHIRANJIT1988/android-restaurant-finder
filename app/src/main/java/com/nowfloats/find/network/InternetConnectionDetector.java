package com.nowfloats.find.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetConnectionDetector 
{
	private Context _context;

	public InternetConnectionDetector(Context context)
	{
		this._context = context;
	}

	private boolean isConnectingToInternet()
	{
		/*ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (connectivity != null)
		{
			NetworkInfo[] menu_info = connectivity.getAllNetworkInfo();

			if (menu_info != null)
			{
				 for (int i = 0; i < menu_info.length; i++)
				 {
					 if (menu_info[i].getState() == NetworkInfo.State.CONNECTED)
					 {
						 return true;
					 }
				 }
			}
		}*/

		try
		{
			ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

			NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
			return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean isConnected()
	{
		return isConnectingToInternet();
	}
}