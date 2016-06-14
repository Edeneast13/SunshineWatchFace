package com.example.android.sunshine.app.sync;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by brianroper on 6/14/16.
 */
public class WatchListener extends WearableListenerService {

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {

        for(DataEvent dataEvent : dataEventBuffer){

            if(dataEvent.getType() == DataEvent.TYPE_CHANGED){

                DataMap dataMap = DataMapItem
                        .fromDataItem(dataEvent.getDataItem())
                        .getDataMap();

                String path = dataEvent.getDataItem()
                        .getUri()
                        .getPath();

                if(path.equals("/weather-data")){

                    String highTemp = dataMap.getString("highTemp");
                    String lowTemp = dataMap.getString("lowTemp");
                    int weatherId = dataMap.getInt("weatherId");
                }
            }
        }
    }
}
