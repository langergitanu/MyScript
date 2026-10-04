package com.myscript.android.utils;

import android.animation.Animator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes3.dex */
public class SelectionMode {
    private Activity mActivity;
    private Callback mCallback;
    private View mSelectionRootView;
    private Toolbar mToolbar;

    public interface Callback {
        boolean onCreateSelectionMode(SelectionMode selectionMode, Menu menu);

        void onDestroySelectionMode(SelectionMode selectionMode);

        boolean onPrepareSelectionMode(SelectionMode selectionMode, Menu menu);

        boolean onSelectionItemClicked(SelectionMode selectionMode, MenuItem menuItem);
    }

    private SelectionMode(Activity activity, ViewGroup viewGroup, Callback callback) {
        this.mActivity = activity;
        int i = C6014R.layout.selection_mode_layout;
        int i2 = C6014R.id.selection_mode_toolbar;
        View viewInflate = LayoutInflater.from(activity).inflate(i, (ViewGroup) null);
        viewGroup.addView(viewInflate);
        this.mSelectionRootView = viewInflate;
        this.mCallback = callback;
        Toolbar toolbar = (Toolbar) viewInflate.findViewById(i2);
        this.mToolbar = toolbar;
        Menu menu = toolbar.getMenu();
        Callback callback2 = this.mCallback;
        if (callback2 != null ? callback2.onCreateSelectionMode(this, menu) : false) {
            this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.myscript.android.utils.SelectionMode$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            this.mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.myscript.android.utils.SelectionMode$$ExternalSyntheticLambda1
                @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return this.f$0.lambda$new$1(menuItem);
                }
            });
            this.mToolbar.setNavigationIcon(C6014R.drawable.ic_close);
            this.mToolbar.setNavigationContentDescription(android.R.string.cancel);
            int iMax = Math.max(viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
            if (this.mSelectionRootView.isAttachedToWindow()) {
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(this.mSelectionRootView, 0, viewGroup.getBottom(), 0, iMax);
                animatorCreateCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorCreateCircularReveal.setDuration(activity.getResources().getInteger(C6014R.integer.selection_mode_ripple_duration));
                this.mSelectionRootView.setVisibility(0);
                animatorCreateCircularReveal.start();
                return;
            }
            this.mSelectionRootView.setVisibility(0);
            return;
        }
        destroy(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(MenuItem menuItem) {
        Callback callback = this.mCallback;
        return callback != null && callback.onSelectionItemClicked(this, menuItem);
    }

    public static SelectionMode startSelectionMode(Activity activity, ViewGroup viewGroup, Callback callback) {
        return new SelectionMode(activity, viewGroup, callback);
    }

    public void invalidate() {
        Toolbar toolbar;
        Callback callback = this.mCallback;
        if (callback == null || (toolbar = this.mToolbar) == null) {
            return;
        }
        callback.onPrepareSelectionMode(this, toolbar.getMenu());
    }

    public void setTitle(String str) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setTitle(str);
        }
    }

    public void setTitle(int i) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setTitle(i);
        }
    }

    public void setSubtitle(String str) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    public void setSubtitle(int i) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setSubtitle(i);
        }
    }

    public MenuInflater getMenuInflater() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity.getMenuInflater();
        }
        return null;
    }

    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    public void finish() {
        destroy(true);
    }

    private void destroy(boolean z) {
        Callback callback;
        if (this.mToolbar != null) {
            final View view = this.mSelectionRootView;
            final ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(this.mActivity.getResources().getInteger(C6014R.integer.selection_mode_fade_out_duration));
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.myscript.android.utils.SelectionMode.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        animation.setAnimationListener(null);
                        viewGroup.removeView(view);
                    }
                });
                view.setAlpha(1.0f);
                view.startAnimation(alphaAnimation);
                view.setVisibility(8);
            } else {
                viewGroup.removeView(view);
            }
            this.mSelectionRootView = null;
            this.mToolbar.getMenu().clear();
            this.mToolbar.setNavigationOnClickListener(null);
            this.mToolbar.setOnMenuItemClickListener(null);
            this.mToolbar = null;
            if (z && (callback = this.mCallback) != null) {
                callback.onDestroySelectionMode(this);
            }
            this.mCallback = null;
            this.mActivity = null;
        }
    }
}
