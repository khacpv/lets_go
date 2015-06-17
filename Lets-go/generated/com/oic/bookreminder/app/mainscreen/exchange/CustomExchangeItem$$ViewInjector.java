// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.exchange;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CustomExchangeItem$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.exchange.CustomExchangeItem> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492929, "field 'tvExchangeTitle'");
    target.tvExchangeTitle = finder.castView(view, 2131492929, "field 'tvExchangeTitle'");
  }

  @Override public void reset(T target) {
    target.tvExchangeTitle = null;
  }
}
