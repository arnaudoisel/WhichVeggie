package org.laybe.whichveggie.activities.presenters;


import javax.inject.Inject;

public class MainActivityPresenterImpl extends BaseActivityPresenter implements MainActivityPresenter {

    private static int i=0;

    @Inject
    public MainActivityPresenterImpl() {
        super();
        i++;
        System.out.println("MainActivityPresenterImpl instances = " + i);
    }
}
