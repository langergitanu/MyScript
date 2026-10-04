package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.myscript.android.utils.EllipsizeTextView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class GridViewPageItemBinding implements ViewBinding {
    public final ConstraintLayout gridViewPageItemBottomBar;
    public final ConstraintLayout gridViewPageItemContainer;
    public final ImageView gridViewPageItemErrorIcon;
    public final ProgressBar gridViewPageItemLoadingProgress;
    public final MaterialCardView gridViewPageItemRoot;
    public final FrameLayout gridViewPageItemSelected;
    public final ImageView gridViewPageItemThumbnail;
    public final ConstraintLayout gridViewPageItemThumbnailContainer;
    public final TextView gridViewPageItemToolbarMetadata;
    public final EllipsizeTextView gridViewPageItemToolbarPageTitle;
    public final ImageView gridViewPageItemTopInfoBackground;
    public final TextView gridViewPageItemTopInfoCount;
    public final Guideline gridViewPageItemTopInfoHlimit;
    public final ImageView gridViewPageItemTopInfoImage;
    public final Guideline gridViewPageItemTopInfoVlimit;
    private final MaterialCardView rootView;

    private GridViewPageItemBinding(MaterialCardView materialCardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ProgressBar progressBar, MaterialCardView materialCardView2, FrameLayout frameLayout, ImageView imageView2, ConstraintLayout constraintLayout3, TextView textView, EllipsizeTextView ellipsizeTextView, ImageView imageView3, TextView textView2, Guideline guideline, ImageView imageView4, Guideline guideline2) {
        this.rootView = materialCardView;
        this.gridViewPageItemBottomBar = constraintLayout;
        this.gridViewPageItemContainer = constraintLayout2;
        this.gridViewPageItemErrorIcon = imageView;
        this.gridViewPageItemLoadingProgress = progressBar;
        this.gridViewPageItemRoot = materialCardView2;
        this.gridViewPageItemSelected = frameLayout;
        this.gridViewPageItemThumbnail = imageView2;
        this.gridViewPageItemThumbnailContainer = constraintLayout3;
        this.gridViewPageItemToolbarMetadata = textView;
        this.gridViewPageItemToolbarPageTitle = ellipsizeTextView;
        this.gridViewPageItemTopInfoBackground = imageView3;
        this.gridViewPageItemTopInfoCount = textView2;
        this.gridViewPageItemTopInfoHlimit = guideline;
        this.gridViewPageItemTopInfoImage = imageView4;
        this.gridViewPageItemTopInfoVlimit = guideline2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static GridViewPageItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GridViewPageItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.grid_view_page_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GridViewPageItemBinding bind(View view) {
        int i = C6079R.id.grid_view_page_item_bottom_bar;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = C6079R.id.grid_view_page_item_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = C6079R.id.grid_view_page_item_error_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C6079R.id.grid_view_page_item_loading_progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        MaterialCardView materialCardView = (MaterialCardView) view;
                        i = C6079R.id.grid_view_page_item_selected;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = C6079R.id.grid_view_page_item_thumbnail;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = C6079R.id.grid_view_page_item_thumbnail_container;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = C6079R.id.grid_view_page_item_toolbar_metadata;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = C6079R.id.grid_view_page_item_toolbar_page_title;
                                        EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) ViewBindings.findChildViewById(view, i);
                                        if (ellipsizeTextView != null) {
                                            i = C6079R.id.grid_view_page_item_top_info_background;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = C6079R.id.grid_view_page_item_top_info_count;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = C6079R.id.grid_view_page_item_top_info_hlimit;
                                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline != null) {
                                                        i = C6079R.id.grid_view_page_item_top_info_image;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView4 != null) {
                                                            i = C6079R.id.grid_view_page_item_top_info_vlimit;
                                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline2 != null) {
                                                                return new GridViewPageItemBinding(materialCardView, constraintLayout, constraintLayout2, imageView, progressBar, materialCardView, frameLayout, imageView2, constraintLayout3, textView, ellipsizeTextView, imageView3, textView2, guideline, imageView4, guideline2);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
