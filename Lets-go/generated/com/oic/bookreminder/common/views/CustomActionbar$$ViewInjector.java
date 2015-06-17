// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.common.views;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CustomActionbar$$ViewInjector<T extends com.oic.bookreminder.common.views.CustomActionbar> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492902, "field 'imvMenu' and method 'onMenuClick'");
    target.imvMenu = finder.castView(view, 2131492902, "field 'imvMenu'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onMenuClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492903, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131492903, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131492905, "field 'edtSearch'");
    target.edtSearch = finder.castView(view, 2131492905, "field 'edtSearch'");
    view = finder.findRequiredView(source, 2131492904, "field 'imvSearch' and method 'onSearchClick'");
    target.imvSearch = finder.castView(view, 2131492904, "field 'imvSearch'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onSearchClick(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.imvMenu = null;
    target.tvTitle = null;
    target.edtSearch = null;
    target.imvSearch = null;
  }
}
