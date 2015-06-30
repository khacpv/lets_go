// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.suggest;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FragmentSuggest$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.suggest.FragmentSuggest> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492942, "field 'listSuggest'");
    target.listSuggest = finder.castView(view, 2131492942, "field 'listSuggest'");
  }

  @Override public void reset(T target) {
    target.listSuggest = null;
  }
}
