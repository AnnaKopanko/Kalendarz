package com.example.martyna.kalendarz;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.Toast;

public class WidgetActivity extends AppWidgetProvider{
    ArrayAdapter<String> adapter = null;
    ListView lv = null;
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {

        lv.setAdapter(adapter);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            PendingIntent pending = PendingIntent.getActivity(context, 0,intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.activity_zakupy);

            views.setOnClickPendingIntent(R.id.button, pending);
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();

    }
}