package org.laybe.whichveggie.services;

import java.util.List;

import org.laybe.whichveggie.WhichVeggieApp;

import dagger.ObjectGraph;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public abstract class BaseService extends Service {

	private ObjectGraph serviceGraph;

    protected abstract List<Object> getModules();

	@Override
	public void onCreate() {
		super.onCreate();
        serviceGraph = ((WhichVeggieApp) getApplication()).createScopedGraph(getModules().toArray());
        serviceGraph.inject(this);
	}
	
	@Override
	public void onDestroy() {
		serviceGraph = null;
		super.onDestroy();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// We don't provide binding, so return null
		return null;
	}

}
