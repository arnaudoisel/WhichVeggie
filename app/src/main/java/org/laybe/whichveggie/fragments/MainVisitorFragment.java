package org.laybe.whichveggie.fragments;

import java.util.Arrays;
import java.util.List;

import org.laybe.whichveggie.R;
import org.laybe.whichveggie.fragments.modules.MainVisitorFragmentModule;

import android.app.Fragment;

public class MainVisitorFragment extends MainBaseFragment {

	@Override
	protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainVisitorFragmentModule(this));
	}
	
	@Override
	protected Fragment getFragmentForDrawerPosition(int position) {
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new NewsFragment();
			break;
		case 1:
			fragment = new WhatNowFragment();
			break;
		case 2:
			fragment = new CalendarFragment();
			break;
		default:
			break;
		}
		
		return fragment;
	}

	@Override
	protected int getDrawerItemsArrayId() {
		return R.array.drawer_items;
	}

	@Override
	protected int getOptionsMenuId() {
		return R.menu.main_visitor;
	}

}
