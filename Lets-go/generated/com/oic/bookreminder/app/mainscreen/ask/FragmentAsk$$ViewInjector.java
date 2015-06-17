// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.ask;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FragmentAsk$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.ask.FragmentAsk> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492878, "field 'listAsk'");
    target.listAsk = finder.castView(view, 2131492878, "field 'listAsk'");
  }

  @Override public void reset(T target) {
    target.listAsk = null;
  }
}
