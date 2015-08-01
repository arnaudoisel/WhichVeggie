package org.laybe.whichveggie.activities.modules;

import javax.inject.Singleton;

import org.laybe.whichveggie.activities.ActivityView;
import org.laybe.whichveggie.activities.MainActivity;
import org.laybe.whichveggie.activities.MainActivityImpl;
import org.laybe.whichveggie.activities.presenters.ActivityPresenter;
import org.laybe.whichveggie.activities.presenters.MainActivityPresenter;
import org.laybe.whichveggie.activities.presenters.MainActivityPresenterImpl;
import org.laybe.whichveggie.fragments.MainLoggedInFragment;
import org.laybe.whichveggie.fragments.MainVisitorFragment;
import org.laybe.whichveggie.models.User;
import org.laybe.whichveggie.modules.AppModule;
import org.laybe.whichveggie.modules.ForActivity;

import android.app.Fragment;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module (
		injects = MainActivityImpl.class,
        library = true,
		addsTo = AppModule.class
		)
public class MainActivityModule {

	private MainActivityImpl view;

	public MainActivityModule(MainActivityImpl view) {
		this.view = view;
	}

	@Provides @Singleton @ForActivity Context provideActivityContext() {
		return view;
	}

	@Provides
	ActivityView provideActivityView() {
		return view;
	}

	@Provides @Singleton
	MainActivity provideView() {
		return view;
	}

	@Provides @Singleton
	ActivityPresenter providePresenter(MainActivityPresenter presenter) {
		return presenter;
	}

	@Provides @Singleton
	MainActivityPresenter providePresenter(MainActivityPresenterImpl presenter) {
		return presenter;
	}

	@Provides
	Fragment provideContentFragment(User user) {
		if (user == null)
			return new MainVisitorFragment();
		else
			return new MainLoggedInFragment();
	}

}
