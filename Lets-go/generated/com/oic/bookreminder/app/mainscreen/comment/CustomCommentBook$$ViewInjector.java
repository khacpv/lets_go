// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.comment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CustomCommentBook$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.comment.CustomCommentBook> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492869, "field 'imvCommentBookAvatar'");
    target.imvCommentBookAvatar = finder.castView(view, 2131492869, "field 'imvCommentBookAvatar'");
    view = finder.findRequiredView(source, 2131492870, "field 'tvCommentBookTitle' and method 'tvCommentBookTitle'");
    target.tvCommentBookTitle = finder.castView(view, 2131492870, "field 'tvCommentBookTitle'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentBookTitle();
        }
      });
    view = finder.findRequiredView(source, 2131492871, "field 'tvCommentBookAuthor' and method 'tvCommentBookAuthor'");
    target.tvCommentBookAuthor = finder.castView(view, 2131492871, "field 'tvCommentBookAuthor'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentBookAuthor();
        }
      });
    view = finder.findRequiredView(source, 2131492872, "field 'tvCommentBookDescription' and method 'tvCommentBookDescription'");
    target.tvCommentBookDescription = finder.castView(view, 2131492872, "field 'tvCommentBookDescription'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentBookDescription();
        }
      });
    view = finder.findRequiredView(source, 2131492873, "field 'tvCommentBookSaveToShelf' and method 'tvCommentBookSaveToShelfClick'");
    target.tvCommentBookSaveToShelf = finder.castView(view, 2131492873, "field 'tvCommentBookSaveToShelf'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentBookSaveToShelfClick();
        }
      });
  }

  @Override public void reset(T target) {
    target.imvCommentBookAvatar = null;
    target.tvCommentBookTitle = null;
    target.tvCommentBookAuthor = null;
    target.tvCommentBookDescription = null;
    target.tvCommentBookSaveToShelf = null;
  }
}
