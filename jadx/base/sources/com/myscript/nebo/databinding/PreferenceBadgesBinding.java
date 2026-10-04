package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PreferenceBadgesBinding implements ViewBinding {
    public final TextView preferenceBadgeCount;
    public final ImageView preferenceWidgetBadge;
    public final ImageView preferenceWidgetIconCaret;
    public final ImageView preferenceWidgetNewFeature;
    private final LinearLayout rootView;

    private PreferenceBadgesBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.rootView = linearLayout;
        this.preferenceBadgeCount = textView;
        this.preferenceWidgetBadge = imageView;
        this.preferenceWidgetIconCaret = imageView2;
        this.preferenceWidgetNewFeature = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceBadgesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PreferenceBadgesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.preference_badges, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PreferenceBadgesBinding bind(View view) {
        int i = C6079R.id.preference_badge_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C6079R.id.preference_widget_badge;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C6079R.id.preference_widget_icon_caret;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = C6079R.id.preference_widget_new_feature;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        return new PreferenceBadgesBinding((LinearLayout) view, textView, imageView, imageView2, imageView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
