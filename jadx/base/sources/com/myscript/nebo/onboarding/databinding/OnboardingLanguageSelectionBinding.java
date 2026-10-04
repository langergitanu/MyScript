package com.myscript.nebo.onboarding.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.myscript.nebo.onboarding.C6669R;

/* JADX INFO: loaded from: classes7.dex */
public final class OnboardingLanguageSelectionBinding implements ViewBinding {
    public final RecyclerView languageList;
    public final MaterialButton onboardingContinue;
    public final LinearLayout onboardingLanguageMainContent;
    public final TextView onboardingLanguageSubtitle;
    public final TextView onboardingLanguageTitle;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final SearchView searchLanguage;
    public final ImageView searchLanguageNoResultIcon;
    public final TextView searchLanguageNoResultLabel;
    public final TextView txtNetworkInfo;

    private OnboardingLanguageSelectionBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, MaterialButton materialButton, LinearLayout linearLayout, TextView textView, TextView textView2, ProgressBar progressBar, SearchView searchView, ImageView imageView, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.languageList = recyclerView;
        this.onboardingContinue = materialButton;
        this.onboardingLanguageMainContent = linearLayout;
        this.onboardingLanguageSubtitle = textView;
        this.onboardingLanguageTitle = textView2;
        this.progressBar = progressBar;
        this.searchLanguage = searchView;
        this.searchLanguageNoResultIcon = imageView;
        this.searchLanguageNoResultLabel = textView3;
        this.txtNetworkInfo = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static OnboardingLanguageSelectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnboardingLanguageSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6669R.layout.onboarding_language_selection, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OnboardingLanguageSelectionBinding bind(View view) {
        int i = C6669R.id.language_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = C6669R.id.onboarding_continue;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = C6669R.id.onboarding_language_main_content;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C6669R.id.onboarding_language_subtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = C6669R.id.onboarding_language_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = C6669R.id.progress_bar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = C6669R.id.search_language;
                                SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, i);
                                if (searchView != null) {
                                    i = C6669R.id.search_language_no_result_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = C6669R.id.search_language_no_result_label;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = C6669R.id.txt_network_info;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                return new OnboardingLanguageSelectionBinding((ConstraintLayout) view, recyclerView, materialButton, linearLayout, textView, textView2, progressBar, searchView, imageView, textView3, textView4);
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
