// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.splash;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FragmentSplash$$ViewInjector<T extends com.oic.bookreminder.app.splash.FragmentSplash> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492939, "field 'logo'");
    target.logo = finder.castView(view, 2131492939, "field 'logo'");
    view = finder.findRequiredView(source, 2131492940, "field 'text1'");
    target.text1 = finder.castView(view, 2131492940, "field 'text1'");
    view = finder.findRequiredView(source, 2131492941, "field 'text2'");
    target.text2 = finder.castView(view, 2131492941, "field 'text2'");
  }

  @Override public void reset(T target) {
    target.logo = null;
    target.text1 = null;
    target.text2 = null;
  }
}
