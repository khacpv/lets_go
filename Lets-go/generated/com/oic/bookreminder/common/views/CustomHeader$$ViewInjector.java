// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.common.views;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CustomHeader$$ViewInjector<T extends com.oic.bookreminder.common.views.CustomHeader> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492936, "field 'tvComment' and method 'onTabClick'");
    target.tvComment = finder.castView(view, 2131492936, "field 'tvComment'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onTabClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492937, "field 'tvAsk' and method 'onTabClick'");
    target.tvAsk = finder.castView(view, 2131492937, "field 'tvAsk'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onTabClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492938, "field 'tvExchange' and method 'onTabClick'");
    target.tvExchange = finder.castView(view, 2131492938, "field 'tvExchange'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onTabClick(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.tvComment = null;
    target.tvAsk = null;
    target.tvExchange = null;
  }
}
