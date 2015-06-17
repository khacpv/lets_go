package com.oic.bookreminder.common.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 6/18/15.
 */
public class TextFormat {

    public static void setCommentTitleText(Context ctx,TextView textView,String userName,String middleText, String bookName){


        SpannableString wordUserName = new SpannableString(userName);
        wordUserName.setSpan(new StyleSpan(Typeface.BOLD), 0, wordUserName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordUserName.setSpan(new ForegroundColorSpan(ctx.getResources().getColor(R.color.black_text)), 0, wordUserName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(wordUserName);

        SpannableString wordCommented = new SpannableString(" "+middleText+" ");
        wordCommented.setSpan(new ForegroundColorSpan(ctx.getResources().getColor(R.color.white_text)), 0, wordCommented.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordCommented.setSpan(new RelativeSizeSpan(0.85F),0,wordCommented.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.append(wordCommented);

        SpannableString wordBookName = new SpannableString(bookName);
        wordBookName.setSpan(new ForegroundColorSpan(ctx.getResources().getColor(R.color.black_text)), 0, wordBookName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordBookName.setSpan(new RelativeSizeSpan(0.95F),0,wordBookName.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.append(wordBookName);
    }
}
