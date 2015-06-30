// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.comment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FragmentComment$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.comment.FragmentComment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492880, "field 'listComment'");
    target.listComment = finder.castView(view, 2131492880, "field 'listComment'");
    view = finder.findRequiredView(source, 2131492885, "field 'commentSearchLayout'");
    target.commentSearchLayout = finder.castView(view, 2131492885, "field 'commentSearchLayout'");
  }

  @Override public void reset(T target) {
    target.listComment = null;
    target.commentSearchLayout = null;
  }
}
