package org.laybe.whichveggie.fragments.modules;

import javax.inject.Singleton;

import org.laybe.whichveggie.activities.modules.MainActivityModule;
import org.laybe.whichveggie.fragments.FragmentView;
import org.laybe.whichveggie.fragments.MainFragment;
import org.laybe.whichveggie.fragments.MainLoggedInFragment;
import org.laybe.whichveggie.fragments.MainVisitorFragment;
import org.laybe.whichveggie.fragments.presenters.FragmentPresenter;
import org.laybe.whichveggie.fragments.presenters.MainFragmentPresenter;
import org.laybe.whichveggie.fragments.presenters.MainLoggedInFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module (
		injects = {
				MainLoggedInFragment.class,
				MainVisitorFragment.class,
		},
		addsTo = MainActivityModule.class
		)
public class MainLoggedInFragmentModule {

	private MainFragment view;
	
	private MainFragmentPresenter presenter;

	public MainLoggedInFragmentModule(MainFragment view) {
		this.view = view;
	}

	@Provides @Singleton
	FragmentView provideFragmentView() {
		return view;
	}
	
	@Provides @Singleton
	MainFragment provideMainFragmentView() {
		return view;
	}

	@Provides @Singleton
	FragmentPresenter provideFragmentPresenter(MainLoggedInFragmentPresenter presenter) {
		return initPresenter(presenter);
	}

	@Provides @Singleton
	MainFragmentPresenter provideMainFragmentPresenter(MainLoggedInFragmentPresenter presenter) {
		return initPresenter(presenter);
	}
	
	MainLoggedInFragmentPresenter initPresenter(MainLoggedInFragmentPresenter presenter) {
		if (this.presenter == null)
			this.presenter = presenter;
		return presenter;		
	}

}
