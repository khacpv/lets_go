// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.menu;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MenuHeaderView$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.menu.MenuHeaderView> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492933, "field 'avatar'");
    target.avatar = finder.castView(view, 2131492933, "field 'avatar'");
    view = finder.findRequiredView(source, 2131492934, "field 'tvUsername'");
    target.tvUsername = finder.castView(view, 2131492934, "field 'tvUsername'");
    view = finder.findRequiredView(source, 2131492935, "field 'tvLevel'");
    target.tvLevel = finder.castView(view, 2131492935, "field 'tvLevel'");
  }

  @Override public void reset(T target) {
    target.avatar = null;
    target.tvUsername = null;
    target.tvLevel = null;
  }
}
