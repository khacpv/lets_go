// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.commentdetail;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FragmentCommentDetail$$ViewInjector<T extends com.oic.bookreminder.app.mainscreen.commentdetail.FragmentCommentDetail> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492876, "field 'imvCommentAvatar'");
    target.imvCommentAvatar = finder.castView(view, 2131492876, "field 'imvCommentAvatar'");
    view = finder.findRequiredView(source, 2131492877, "field 'tvName'");
    target.tvName = finder.castView(view, 2131492877, "field 'tvName'");
    view = finder.findRequiredView(source, 2131492878, "field 'btnPostComment' and method 'postComment'");
    target.btnPostComment = finder.castView(view, 2131492878, "field 'btnPostComment'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.postComment(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492879, "field 'edtCommentText'");
    target.edtCommentText = finder.castView(view, 2131492879, "field 'edtCommentText'");
    view = finder.findRequiredView(source, 2131492880, "field 'listCommentSearch'");
    target.listCommentSearch = finder.castView(view, 2131492880, "field 'listCommentSearch'");
  }

  @Override public void reset(T target) {
    target.imvCommentAvatar = null;
    target.tvName = null;
    target.btnPostComment = null;
    target.edtCommentText = null;
    target.listCommentSearch = null;
  }
}
