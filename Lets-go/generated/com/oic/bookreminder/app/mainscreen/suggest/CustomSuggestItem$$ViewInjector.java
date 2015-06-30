// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.suggest;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CustomSuggestItem$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.suggest.CustomSuggestItem> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492944, "field 'tvAskTitle'");
    target.tvAskTitle = finder.castView(view, 2131492944, "field 'tvAskTitle'");
  }

  @Override public void reset(T target) {
    target.tvAskTitle = null;
  }
}
