package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class FeedbackSentDialogBinding implements ViewBinding {
    public final Button closeButton;
    public final LinearLayout feedbackSentBody;
    public final TextView feedbackSentTitle;
    private final View rootView;
    public final TextView txtFeedbackSentLink;
    public final TextView txtFeedbackSentMessage;

    private FeedbackSentDialogBinding(View view, Button button, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = view;
        this.closeButton = button;
        this.feedbackSentBody = linearLayout;
        this.feedbackSentTitle = textView;
        this.txtFeedbackSentLink = textView2;
        this.txtFeedbackSentMessage = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static FeedbackSentDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeedbackSentDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.feedback_sent_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FeedbackSentDialogBinding bind(View view) {
        int i = C6079R.id.close_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, C6079R.id.feedback_sent_body);
            i = C6079R.id.feedback_sent_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C6079R.id.txt_feedback_sent_link;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = C6079R.id.txt_feedback_sent_message;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new FeedbackSentDialogBinding(view, button, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
