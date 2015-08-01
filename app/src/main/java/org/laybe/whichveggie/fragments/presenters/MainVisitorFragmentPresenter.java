package org.laybe.whichveggie.fragments.presenters;

import org.laybe.whichveggie.R;
import android.view.MenuItem;

import javax.inject.Inject;

public class MainVisitorFragmentPresenter extends MainBaseFragmentPresenter {

    @Inject
    public MainVisitorFragmentPresenter() {
        super();
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (drawerTogglePresenter.onOptionsItemSelected(item))
			return true;
		
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.action_login:
			login();
			return true;
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	private void login() {
		switchProfile();
	}
}
