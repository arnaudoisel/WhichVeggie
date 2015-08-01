package org.laybe.whichveggie.modules;

import javax.inject.Singleton;

import org.laybe.whichveggie.WhichVeggieApp;
import org.laybe.whichveggie.controllers.AppController;
import org.laybe.whichveggie.controllers.AppControllerImpl;
import org.laybe.whichveggie.events.EventBus;
import org.laybe.whichveggie.events.EventBusImpl;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module (
		injects = WhichVeggieApp.class,
		includes = LoginModule.class
		)
public class AppModule {

	private final WhichVeggieApp app;

	public AppModule(WhichVeggieApp app) {
		this.app = app;
	}

	@Provides @Singleton
	AppController provideAppController(AppControllerImpl appController) {
		return appController;
	}
	
	@Provides @Singleton @ForApplication 
	Context provideApplicationContext() {
		return app;
	}

	@Provides @Singleton @ForApplication
	EventBus provideEventBus() {
		return new EventBusImpl(de.greenrobot.event.EventBus.getDefault());
	}

}
