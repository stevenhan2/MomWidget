package han.steven.mom;



import java.util.ArrayList;
import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;


public class MomWidgetProvider extends AppWidgetProvider {
	private ArrayList<CuteProvider> cute;
	private Random rand;

	public MomWidgetProvider(){
		super();
		Log.d("ASDF","asdfasdf");
		cute = new ArrayList<CuteProvider>();
		
		//Add in your own here
		cute.add(new TestCuteProvider());
		rand = new Random();
	}

	public Cute getRandomCute(){
		//Decide how often which ones get shown
		return cute.get(0).getNextCute();
	}
	
	protected int fontSize(int x){
		if (x < 40)
			return 18;
		else if (x < 70)
			return 16;
		else if (x < 90)
			return 13;
		else if (x < 120)
			return 12;
		return 11;
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// Get all ids
		ComponentName thisWidget = new ComponentName(context,
				MomWidgetProvider.class);
		int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
		for (int widgetId : allWidgetIds) {
			// Create some random data
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
					R.layout.momwidget_layout);

			Cute cute = getRandomCute();
			
			
			//Use if API level high enough
//			remoteViews.setTextViewTextSize(R.id.saying, TypedValue.COMPLEX_UNIT_SP, fontSize(cute.saying.length()));
			
			// Set the text
			remoteViews.setTextViewText(R.id.name, cute.name + " says");
			remoteViews.setTextViewText(R.id.saying, "\"" + cute.saying + "\"");
			remoteViews.setImageViewResource(R.id.imageView1, cute.image);

			// Register an onClickListener
			Intent intent = new Intent(context, MomWidgetProvider.class);

			intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

			PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
					0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
			remoteViews.setOnClickPendingIntent(R.id.refresh, pendingIntent);
			appWidgetManager.updateAppWidget(widgetId, remoteViews);
		}
	}
} 