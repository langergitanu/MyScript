package com.myscript.nebo.languagemanager.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.languagemanager.C6611R;

/* JADX INFO: loaded from: classes7.dex */
public final class ItemLanguageBinding implements ViewBinding {
    public final ImageView imgCancel;
    public final ImageView imgCheck;
    public final ImageView imgDownload;
    public final ImageView imgRemove;
    public final ImageView imgUpdate;
    public final ProgressBar progressBar;
    public final LinearLayout progressGroup;
    private final LinearLayout rootView;
    public final TextView txtDownloadingSummary;
    public final TextView txtTitle;
    public final LinearLayout viewLanguageItem;

    private ItemLanguageBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ProgressBar progressBar, LinearLayout linearLayout2, TextView textView, TextView textView2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.imgCancel = imageView;
        this.imgCheck = imageView2;
        this.imgDownload = imageView3;
        this.imgRemove = imageView4;
        this.imgUpdate = imageView5;
        this.progressBar = progressBar;
        this.progressGroup = linearLayout2;
        this.txtDownloadingSummary = textView;
        this.txtTitle = textView2;
        this.viewLanguageItem = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemLanguageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLanguageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6611R.layout.item_language, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLanguageBinding bind(View view) {
        int i = C6611R.id.img_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C6611R.id.img_check;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = C6611R.id.img_download;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = C6611R.id.img_remove;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = C6611R.id.img_update;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = C6611R.id.progress_bar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = C6611R.id.progress_group;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = C6611R.id.txt_downloading_summary;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = C6611R.id.txt_title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) view;
                                            return new ItemLanguageBinding(linearLayout2, imageView, imageView2, imageView3, imageView4, imageView5, progressBar, linearLayout, textView, textView2, linearLayout2);
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
