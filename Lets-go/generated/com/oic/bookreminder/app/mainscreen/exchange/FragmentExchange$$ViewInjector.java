// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.exchange;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FragmentExchange$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.exchange.FragmentExchange> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492910, "field 'listExchange'");
    target.listExchange = finder.castView(view, 2131492910, "field 'listExchange'");
  }

  @Override public void reset(T target) {
    target.listExchange = null;
  }
}
