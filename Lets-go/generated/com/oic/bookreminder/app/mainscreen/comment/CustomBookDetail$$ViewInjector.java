// Generated code from Butter Knife. Do not modify!
package com.oic.bookreminder.app.mainscreen.comment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.oic.bookreminder.app.mainscreen.commentdetail.CustomBookDetail;

public class CustomBookDetail$$ViewInjector<T extends CustomBookDetail> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492883, "field 'imvCommentAvatar'");
    target.imvCommentAvatar = finder.castView(view, 2131492883, "field 'imvCommentAvatar'");
    view = finder.findRequiredView(source, 2131492884, "field 'tvName'");
    target.tvName = finder.castView(view, 2131492884, "field 'tvName'");
    view = finder.findRequiredView(source, 2131492885, "field 'edtCommentText'");
    target.edtCommentText = finder.castView(view, 2131492885, "field 'edtCommentText'");
    view = finder.findRequiredView(source, 2131492886, "field 'listCommentSearch'");
    target.listCommentSearch = finder.castView(view, 2131492886, "field 'listCommentSearch'");
  }

  @Override public void reset(T target) {
    target.imvCommentAvatar = null;
    target.tvName = null;
    target.edtCommentText = null;
    target.listCommentSearch = null;
  }
}
