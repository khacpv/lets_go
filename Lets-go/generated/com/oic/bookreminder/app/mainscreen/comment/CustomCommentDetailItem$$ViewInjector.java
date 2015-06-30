// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.comment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CustomCommentDetailItem$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.comment.CustomCommentItem> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492887, "field 'tvCommentTitle' and method 'tvCommentTitleClick'");
    target.tvCommentTitle = finder.castView(view, 2131492887, "field 'tvCommentTitle'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentTitleClick();
        }
      });
    view = finder.findRequiredView(source, 2131492889, "field 'commentBook'");
    target.commentBook = finder.castView(view, 2131492889, "field 'commentBook'");
    view = finder.findRequiredView(source, 2131492888, "field 'tvCommentTime' and method 'tvCommentTimeClick'");
    target.tvCommentTime = finder.castView(view, 2131492888, "field 'tvCommentTime'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentTimeClick();
        }
      });
    view = finder.findRequiredView(source, 2131492892, "field 'tvCommentNumber' and method 'tvCommentNumberClick'");
    target.tvCommentNumber = finder.castView(view, 2131492892, "field 'tvCommentNumber'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentNumberClick();
        }
      });
    view = finder.findRequiredView(source, 2131492890, "field 'tvCommentLike' and method 'tvCommentLikeClick'");
    target.tvCommentLike = finder.castView(view, 2131492890, "field 'tvCommentLike'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tvCommentLikeClick();
        }
      });
    view = finder.findRequiredView(source, 2131492883, "field 'imvCommentAvatar' and method 'imvCommentAvatarClick'");
    target.imvCommentAvatar = finder.castView(view, 2131492883, "field 'imvCommentAvatar'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.imvCommentAvatarClick();
        }
      });
  }

  @Override public void reset(T target) {
    target.tvCommentTitle = null;
    target.commentBook = null;
    target.tvCommentTime = null;
    target.tvCommentNumber = null;
    target.tvCommentLike = null;
    target.imvCommentAvatar = null;
  }
}
