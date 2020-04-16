package cdc.bintan.com.bintancdc;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationResult;

public class MyLocationService extends BroadcastReceiver {
    final String LOGFGBG = "CekFGBG";
    //final String LOGBG = "CekBG";

    public static final String ACTION_PROCESS_UPDATE = "cdc.bintan.com.bintancdc.UPDATE_LOCATION";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            final String action = intent.getAction();
            if (ACTION_PROCESS_UPDATE.equals(action)){
                LocationResult result = LocationResult.extractResult(intent);
                if (result != null){
                    Location location = result.getLastLocation();
                    String location_string = new StringBuilder(""+location.getLatitude())
                            .append("/")
                            .append(location.getLongitude())
                            .toString();
                    try {
                        //Toast.makeText(context, location_string, Toast.LENGTH_SHORT).show();
                        Log.d(LOGFGBG, location_string);
                    } catch (Exception e) {
                        //Toast.makeText(context, location_string, Toast.LENGTH_SHORT).show();
                        Log.d(LOGFGBG, location_string);
                    }
                }
            }
        }
    }
}
