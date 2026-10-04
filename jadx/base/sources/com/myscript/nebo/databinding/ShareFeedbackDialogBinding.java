package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class ShareFeedbackDialogBinding implements ViewBinding {
    public final LinearLayout buttonsContainer;
    public final Button closeButton;
    public final TextInputEditText feedbackEditText;
    public final TextInputLayout feedbackEdittextContainer;
    public final TextView noInternetConnection;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final Button submitButton;
    public final TextView subtitleTextView;
    public final TextView titleTextView;
    public final RelativeLayout topContainer;

    private ShareFeedbackDialogBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, Button button, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView, ProgressBar progressBar, Button button2, TextView textView2, TextView textView3, RelativeLayout relativeLayout) {
        this.rootView = constraintLayout;
        this.buttonsContainer = linearLayout;
        this.closeButton = button;
        this.feedbackEditText = textInputEditText;
        this.feedbackEdittextContainer = textInputLayout;
        this.noInternetConnection = textView;
        this.progressBar = progressBar;
        this.submitButton = button2;
        this.subtitleTextView = textView2;
        this.titleTextView = textView3;
        this.topContainer = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShareFeedbackDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ShareFeedbackDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.share_feedback_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ShareFeedbackDialogBinding bind(View view) {
        int i = C6079R.id.buttons_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C6079R.id.close_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = C6079R.id.feedback_edit_text;
                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                if (textInputEditText != null) {
                    i = C6079R.id.feedback_edittext_container;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                    if (textInputLayout != null) {
                        i = C6079R.id.no_internet_connection;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = C6079R.id.progressBar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = C6079R.id.submit_button;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button2 != null) {
                                    i = C6079R.id.subtitle_text_view;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = C6079R.id.title_text_view;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = C6079R.id.top_container;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                return new ShareFeedbackDialogBinding((ConstraintLayout) view, linearLayout, button, textInputEditText, textInputLayout, textView, progressBar, button2, textView2, textView3, relativeLayout);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
