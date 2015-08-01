package org.laybe.whichveggie.fragments.modules;

import javax.inject.Singleton;

import org.laybe.whichveggie.activities.modules.MainActivityModule;
import org.laybe.whichveggie.fragments.FragmentView;
import org.laybe.whichveggie.fragments.MainFragment;
import org.laybe.whichveggie.fragments.MainVisitorFragment;
import org.laybe.whichveggie.fragments.presenters.FragmentPresenter;
import org.laybe.whichveggie.fragments.presenters.MainFragmentPresenter;
import org.laybe.whichveggie.fragments.presenters.MainVisitorFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module (
		injects = {
				MainVisitorFragment.class,
		},
		addsTo = MainActivityModule.class
		)
public class MainVisitorFragmentModule {

	private MainFragment view;

	private MainFragmentPresenter presenter;
	
	public MainVisitorFragmentModule(MainFragment view) {
		this.view = view;
	}

	@Provides @Singleton
	FragmentView provideFragmentView() {
		return view;
	}
	
	@Provides @Singleton
	MainFragment provideView() {
		return view;
	}

	@Provides @Singleton
	FragmentPresenter provideFragmentPresenter(MainVisitorFragmentPresenter presenter) {
		return initPresenter(presenter);
	}

	@Provides @Singleton
	MainFragmentPresenter provideMainFragmentPresenter(MainVisitorFragmentPresenter presenter) {
		return initPresenter(presenter);
	}

	MainVisitorFragmentPresenter initPresenter(MainVisitorFragmentPresenter presenter) {
		if (this.presenter == null)
			this.presenter = presenter;
		return presenter;
	}
}
