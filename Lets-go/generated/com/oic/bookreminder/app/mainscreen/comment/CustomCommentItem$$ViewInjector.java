// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.comment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CustomCommentItem$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.comment.CustomCommentItem> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492918, "field 'tvCommentTitle'");
    target.tvCommentTitle = finder.castView(view, 2131492918, "field 'tvCommentTitle'");
    view = finder.findRequiredView(source, 2131492920, "field 'commentBook'");
    target.commentBook = finder.castView(view, 2131492920, "field 'commentBook'");
  }

  @Override public void reset(T target) {
    target.tvCommentTitle = null;
    target.commentBook = null;
  }
}
