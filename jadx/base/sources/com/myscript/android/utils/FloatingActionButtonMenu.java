package com.myscript.android.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.C0028R;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.C4627R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 92\u00020\u0001:\u000289B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020!H\u0014J\u0006\u0010$\u001a\u00020!J$\u0010%\u001a\u00020!*\u00020\r2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010*\u001a\u00020!*\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)H\u0002J,\u0010-\u001a\u00020!*\u00020\r2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,H\u0002J\u0006\u00102\u001a\u00020!J\u0006\u00103\u001a\u00020!J\u0012\u00104\u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u000207R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006:"}, m1599d2 = {"Lcom/myscript/android/utils/FloatingActionButtonMenu;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentOverlayView", "Landroid/view/View;", "fab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "menuRoot", "Landroid/widget/LinearLayout;", "menu", "Landroid/view/Menu;", "menuResId", "menuIconWidth", "isAnimating", "", "lastRequestedVisibility", "menuOpened", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/android/utils/FloatingActionButtonMenu$OnMenuItemClickListener;", "getListener", "()Lcom/myscript/android/utils/FloatingActionButtonMenu$OnMenuItemClickListener;", "setListener", "(Lcom/myscript/android/utils/FloatingActionButtonMenu$OnMenuItemClickListener;)V", "initialize", "", "onAttachedToWindow", "onDetachedFromWindow", "toggleMenuVisibility", "scaleToSquare", "srcDimension", "targetDimension", "delay", "", "fade", "targetAlpha", "", "circularReveal", "cx", "cy", "srcRadius", "targetRadius", "show", "hide", "setOnClickListener", "Landroid/view/View$OnClickListener;", "fabRectLocationInWindow", "Landroid/graphics/Rect;", "OnMenuItemClickListener", "Companion", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FloatingActionButtonMenu extends FrameLayout {
    private static final long ANIMATION_BETWEEN_ITEMS_DELAY = 100;
    private static final float ANIMATION_FAB_ROTATION = 45.0f;
    private static final long ANIMATION_LONG_DURATION = 300;
    private static final long ANIMATION_SHORT_DURATION = 150;
    private View contentOverlayView;
    private FloatingActionButton fab;
    private boolean isAnimating;
    private int lastRequestedVisibility;
    private OnMenuItemClickListener listener;
    private Menu menu;
    private int menuIconWidth;
    private boolean menuOpened;
    private int menuResId;
    private LinearLayout menuRoot;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/android/utils/FloatingActionButtonMenu$OnMenuItemClickListener;", "", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface OnMenuItemClickListener {
        void onMenuItemClick(MenuItem item);
    }

    public final OnMenuItemClickListener getListener() {
        return this.listener;
    }

    public final void setListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.listener = onMenuItemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonMenu(Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize(context, null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initialize(context, attributeSet, i);
    }

    private final void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        this.menuIconWidth = context.getResources().getDimensionPixelSize(C6014R.dimen.fab_menu_icon_width);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C6014R.styleable.FloatingActionButtonMenu, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.menuResId = typedArrayObtainStyledAttributes.getResourceId(C6014R.styleable.FloatingActionButtonMenu_contextualMenu, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attrs, C0028R.styleable.AppCompatImageView, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "obtainStyledAttributes(...)");
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attrs, C4627R.styleable.FloatingActionButton, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes3, "obtainStyledAttributes(...)");
        View viewInflate = View.inflate(context, C6014R.layout.fab_menu, this);
        View viewFindViewById = viewInflate.findViewById(C6014R.id.fab_menu_main_button);
        FloatingActionButton floatingActionButton = (FloatingActionButton) viewFindViewById;
        floatingActionButton.setSize(typedArrayObtainStyledAttributes3.getInt(C4627R.styleable.FloatingActionButton_fabSize, -1));
        floatingActionButton.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), typedArrayObtainStyledAttributes2.getResourceId(C0028R.styleable.AppCompatImageView_android_src, 0), context.getTheme()));
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "apply(...)");
        this.fab = floatingActionButton;
        View viewFindViewById2 = viewInflate.findViewById(C6014R.id.content_overlay_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.contentOverlayView = viewFindViewById2;
        if (this.menuResId != 0) {
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C6014R.id.fab_menu_container);
            this.menuRoot = linearLayout;
            if (linearLayout != null) {
                this.menu = new PopupMenu(context, this).getMenu();
                new MenuInflater(context).inflate(this.menuResId, this.menu);
                Menu menu = this.menu;
                if (menu != null) {
                    int size = menu.size();
                    for (int i = 0; i < size; i++) {
                        MenuItem item = menu.getItem(i);
                        View viewInflate2 = FrameLayout.inflate(context, C6014R.layout.fab_menu_item, null);
                        viewInflate2.setTag(Integer.valueOf(item.getItemId()));
                        TextView textView = (TextView) viewInflate2.findViewById(C6014R.id.fab_menu_item_title);
                        textView.setEnabled(item.isEnabled());
                        textView.setText(item.getTitle());
                        ImageView imageView = (ImageView) viewInflate2.findViewById(C6014R.id.fab_menu_item_icon);
                        imageView.setEnabled(item.isEnabled());
                        imageView.setImageDrawable(item.getIcon());
                        linearLayout.addView(viewInflate2);
                    }
                }
            }
        }
        typedArrayObtainStyledAttributes3.recycle();
        typedArrayObtainStyledAttributes2.recycle();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout linearLayout = this.menuRoot;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = linearLayout;
            int childCount = linearLayout2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View childAt = linearLayout2.getChildAt(i);
                childAt.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.android.utils.FloatingActionButtonMenu$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FloatingActionButtonMenu.onAttachedToWindow$lambda$0$0(this.f$0, childAt, view);
                    }
                });
            }
        }
        View view = this.contentOverlayView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentOverlayView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.android.utils.FloatingActionButtonMenu$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FloatingActionButtonMenu.onAttachedToWindow$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToWindow$lambda$0$0(FloatingActionButtonMenu floatingActionButtonMenu, View view, View view2) {
        MenuItem menuItemFindItem;
        Menu menu = floatingActionButtonMenu.menu;
        if (menu != null) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            menuItemFindItem = menu.findItem(((Integer) tag).intValue());
        } else {
            menuItemFindItem = null;
        }
        if (menuItemFindItem == null || !menuItemFindItem.isEnabled()) {
            return;
        }
        floatingActionButtonMenu.toggleMenuVisibility();
        OnMenuItemClickListener onMenuItemClickListener = floatingActionButtonMenu.listener;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListener.onMenuItemClick(menuItemFindItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToWindow$lambda$1(FloatingActionButtonMenu floatingActionButtonMenu, View view) {
        if (floatingActionButtonMenu.menuOpened) {
            floatingActionButtonMenu.toggleMenuVisibility();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        LinearLayout linearLayout = this.menuRoot;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = linearLayout;
            int childCount = linearLayout2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                linearLayout2.getChildAt(i);
                setOnClickListener(null);
            }
        }
        View view = this.contentOverlayView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentOverlayView");
            view = null;
        }
        view.setOnClickListener(null);
        super.onDetachedFromWindow();
    }

    public final void toggleMenuVisibility() {
        LinearLayout linearLayout;
        MenuItem item;
        if (this.isAnimating || (linearLayout = this.menuRoot) == null) {
            return;
        }
        FloatingActionButton floatingActionButton = this.fab;
        FloatingActionButton floatingActionButton2 = null;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton = null;
        }
        float x = floatingActionButton.getX();
        FloatingActionButton floatingActionButton3 = this.fab;
        if (floatingActionButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton3 = null;
        }
        int width = (int) (x + (floatingActionButton3.getWidth() / 2));
        FloatingActionButton floatingActionButton4 = this.fab;
        if (floatingActionButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton4 = null;
        }
        float y = floatingActionButton4.getY();
        FloatingActionButton floatingActionButton5 = this.fab;
        if (floatingActionButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton5 = null;
        }
        int height = (int) (y + (floatingActionButton5.getHeight() / 2));
        View view = this.contentOverlayView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentOverlayView");
            view = null;
        }
        int width2 = view.getWidth();
        View view2 = this.contentOverlayView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentOverlayView");
            view2 = null;
        }
        float fMax = Math.max(width2, view2.getHeight());
        boolean z = this.menuOpened;
        float f = z ? fMax : 0.0f;
        float f2 = z ? 0.0f : fMax;
        View view3 = this.contentOverlayView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentOverlayView");
            view3 = null;
        }
        circularReveal(view3, width, height, f, f2);
        float f3 = !this.menuOpened ? 45.0f : 0.0f;
        FloatingActionButton floatingActionButton6 = this.fab;
        if (floatingActionButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
        } else {
            floatingActionButton2 = floatingActionButton6;
        }
        ViewExt.rotate(floatingActionButton2, f3, 300L, 0L, new OvershootInterpolator());
        boolean z2 = this.menuOpened;
        int i = z2 ? 0 : this.menuIconWidth;
        float f4 = z2 ? 0.0f : 1.0f;
        LinearLayout linearLayout2 = linearLayout;
        int childCount = linearLayout2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            linearLayout2.getChildAt(i2);
            int childCount2 = this.menuOpened ? i2 : (linearLayout.getChildCount() - 1) - i2;
            View childAt = linearLayout.getChildAt(childCount2);
            childAt.setEnabled(!this.menuOpened);
            long j = ((long) i2) * ANIMATION_BETWEEN_ITEMS_DELAY;
            Menu menu = this.menu;
            if ((menu == null || (item = menu.getItem(childCount2)) == null) ? false : item.isVisible()) {
                ImageView imageView = (ImageView) childAt.findViewById(C6014R.id.fab_menu_item_icon);
                int width3 = this.menuOpened ? imageView.getWidth() : 0;
                Intrinsics.checkNotNull(imageView);
                scaleToSquare(imageView, width3, i, j);
                TextView textView = (TextView) childAt.findViewById(C6014R.id.fab_menu_item_title);
                Intrinsics.checkNotNull(textView);
                fade(textView, f4, j);
            } else {
                childAt.setVisibility(8);
            }
        }
        this.menuOpened = !this.menuOpened;
    }

    private final void scaleToSquare(final View view, int i, int i2, long j) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.android.utils.FloatingActionButtonMenu$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionButtonMenu.scaleToSquare$lambda$0$0(view, valueAnimator);
            }
        });
        valueAnimatorOfInt.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setStartDelay(j);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scaleToSquare$lambda$0$0(View view, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iMax = Math.max(0, ((Integer) animatedValue).intValue());
        view.getLayoutParams().width = iMax;
        view.getLayoutParams().height = iMax;
        view.requestLayout();
    }

    private final void fade(final View view, final float f, long j) {
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", f);
        objectAnimatorOfFloat.setDuration(150L);
        objectAnimatorOfFloat.setStartDelay(j);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.myscript.android.utils.FloatingActionButtonMenu$fade$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                view.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                view.setVisibility(f > 0.0f ? 0 : 8);
                objectAnimatorOfFloat.removeListener(this);
            }
        });
        objectAnimatorOfFloat.start();
    }

    private final void circularReveal(View view, int i, int i2, float f, final float f2) {
        final Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f2);
        animatorCreateCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorCreateCircularReveal.setDuration(300L);
        animatorCreateCircularReveal.addListener(new Animator.AnimatorListener() { // from class: com.myscript.android.utils.FloatingActionButtonMenu$circularReveal$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.isAnimating = true;
                View view2 = this.this$0.contentOverlayView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentOverlayView");
                    view2 = null;
                }
                view2.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.isAnimating = false;
                View view2 = this.this$0.contentOverlayView;
                FloatingActionButton floatingActionButton = null;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentOverlayView");
                    view2 = null;
                }
                view2.setVisibility(f2 == 0.0f ? 8 : 0);
                animatorCreateCircularReveal.removeListener(this);
                if (this.this$0.menuOpened) {
                    return;
                }
                FloatingActionButton floatingActionButton2 = this.this$0.fab;
                if (floatingActionButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fab");
                } else {
                    floatingActionButton = floatingActionButton2;
                }
                floatingActionButton.setVisibility(this.this$0.lastRequestedVisibility);
            }
        });
        animatorCreateCircularReveal.start();
    }

    public final void show() {
        setVisibility(0);
        this.lastRequestedVisibility = 0;
        FloatingActionButton floatingActionButton = this.fab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton = null;
        }
        floatingActionButton.post(new Runnable() { // from class: com.myscript.android.utils.FloatingActionButtonMenu$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FloatingActionButtonMenu.show$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(FloatingActionButtonMenu floatingActionButtonMenu) {
        FloatingActionButton floatingActionButton = floatingActionButtonMenu.fab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton = null;
        }
        floatingActionButton.show();
    }

    public final void hide() {
        if (this.menuOpened) {
            this.lastRequestedVisibility = 4;
            toggleMenuVisibility();
        } else {
            if (this.isAnimating) {
                this.lastRequestedVisibility = 4;
                return;
            }
            FloatingActionButton floatingActionButton = this.fab;
            if (floatingActionButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fab");
                floatingActionButton = null;
            }
            floatingActionButton.post(new Runnable() { // from class: com.myscript.android.utils.FloatingActionButtonMenu$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    FloatingActionButtonMenu.hide$lambda$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$0(FloatingActionButtonMenu floatingActionButtonMenu) {
        FloatingActionButton floatingActionButton = floatingActionButtonMenu.fab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton = null;
        }
        floatingActionButton.hide();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener listener) {
        FloatingActionButton floatingActionButton = this.fab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton = null;
        }
        floatingActionButton.setOnClickListener(listener);
    }

    public final Rect fabRectLocationInWindow() {
        FloatingActionButton floatingActionButton = this.fab;
        FloatingActionButton floatingActionButton2 = null;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton = null;
        }
        int[] locationInWindow = ViewExt.getLocationInWindow(floatingActionButton);
        int i = locationInWindow[0];
        int i2 = locationInWindow[1];
        FloatingActionButton floatingActionButton3 = this.fab;
        if (floatingActionButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
            floatingActionButton3 = null;
        }
        int width = floatingActionButton3.getWidth() + i;
        int i3 = locationInWindow[1];
        FloatingActionButton floatingActionButton4 = this.fab;
        if (floatingActionButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
        } else {
            floatingActionButton2 = floatingActionButton4;
        }
        return new Rect(i, i2, width, i3 + floatingActionButton2.getHeight());
    }
}
