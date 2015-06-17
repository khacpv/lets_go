// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FragmentMain$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.FragmentMain> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492881, "field 'mDrawerLayout'");
    target.mDrawerLayout = finder.castView(view, 2131492881, "field 'mDrawerLayout'");
    view = finder.findRequiredView(source, 2131492885, "field 'leftDrawer'");
    target.leftDrawer = finder.castView(view, 2131492885, "field 'leftDrawer'");
    view = finder.findRequiredView(source, 2131492886, "field 'mDrawerList'");
    target.mDrawerList = finder.castView(view, 2131492886, "field 'mDrawerList'");
    view = finder.findRequiredView(source, 2131492882, "field 'actionbar'");
    target.actionbar = finder.castView(view, 2131492882, "field 'actionbar'");
    view = finder.findRequiredView(source, 2131492883, "field 'customHeader'");
    target.customHeader = finder.castView(view, 2131492883, "field 'customHeader'");
  }

  @Override public void reset(T target) {
    target.mDrawerLayout = null;
    target.leftDrawer = null;
    target.mDrawerList = null;
    target.actionbar = null;
    target.customHeader = null;
  }
}
