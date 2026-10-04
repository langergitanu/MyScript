package com.myscript.nebo.freemium;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.grid.GridBannerState;
import com.myscript.nebo.grid.UserStatus;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FreemiumBannerView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/freemium/FreemiumBannerView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bannerLarge", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "description", "actionButton", "Lcom/google/android/material/button/MaterialButton;", "constraintLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mainContainer", "Lcom/google/android/material/card/MaterialCardView;", "onDetachedFromWindow", "", "setActionButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setVisibility", "show", "", "updateState", "state", "Lcom/myscript/nebo/grid/GridBannerState;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreemiumBannerView extends FrameLayout {
    public static final int $stable = 8;
    private MaterialButton actionButton;
    private ImageView bannerLarge;
    private ConstraintLayout constraintLayout;
    private TextView description;
    private MaterialCardView mainContainer;
    private TextView title;

    /* JADX INFO: compiled from: FreemiumBannerView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UserStatus.values().length];
            try {
                iArr[UserStatus.Trial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UserStatus.Freemium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FreemiumBannerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(getContext(), C6079R.layout.pages_counter_view, this);
        this.bannerLarge = (ImageView) findViewById(C6079R.id.img_banner_large);
        View viewFindViewById = findViewById(C6079R.id.page_counter_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.title = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(C6079R.id.page_counter_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.description = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(C6079R.id.page_counter_action_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.actionButton = (MaterialButton) viewFindViewById3;
        View viewFindViewById4 = findViewById(C6079R.id.constraint_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.constraintLayout = (ConstraintLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(C6079R.id.main_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mainContainer = (MaterialCardView) viewFindViewById5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FreemiumBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(getContext(), C6079R.layout.pages_counter_view, this);
        this.bannerLarge = (ImageView) findViewById(C6079R.id.img_banner_large);
        View viewFindViewById = findViewById(C6079R.id.page_counter_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.title = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(C6079R.id.page_counter_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.description = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(C6079R.id.page_counter_action_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.actionButton = (MaterialButton) viewFindViewById3;
        View viewFindViewById4 = findViewById(C6079R.id.constraint_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.constraintLayout = (ConstraintLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(C6079R.id.main_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mainContainer = (MaterialCardView) viewFindViewById5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FreemiumBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(getContext(), C6079R.layout.pages_counter_view, this);
        this.bannerLarge = (ImageView) findViewById(C6079R.id.img_banner_large);
        View viewFindViewById = findViewById(C6079R.id.page_counter_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.title = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(C6079R.id.page_counter_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.description = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(C6079R.id.page_counter_action_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.actionButton = (MaterialButton) viewFindViewById3;
        View viewFindViewById4 = findViewById(C6079R.id.constraint_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.constraintLayout = (ConstraintLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(C6079R.id.main_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mainContainer = (MaterialCardView) viewFindViewById5;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.constraintLayout.setOnClickListener(null);
        super.onDetachedFromWindow();
    }

    public final void setActionButtonListener(View.OnClickListener listener) {
        this.actionButton.setOnClickListener(listener);
    }

    public final void setVisibility(boolean show) {
        final long integer = getResources().getInteger(android.R.integer.config_longAnimTime);
        if (show) {
            FreemiumBannerView freemiumBannerView = this;
            if (freemiumBannerView.getVisibility() == 0) {
                return;
            }
            setVisibility(0);
            if (freemiumBannerView.isLaidOut() && !freemiumBannerView.isLayoutRequested()) {
                if (getWidth() > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    TranslateAnimation translateAnimation = new TranslateAnimation(getWidth(), 0.0f, 0.0f, 0.0f);
                    AnimationSet animationSet = new AnimationSet(true);
                    animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
                    animationSet.setDuration(integer);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.addAnimation(translateAnimation);
                    startAnimation(animationSet);
                    return;
                }
                return;
            }
            freemiumBannerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.freemium.FreemiumBannerView$setVisibility$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    if (this.this$0.getWidth() > 0) {
                        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(this.this$0.getWidth(), 0.0f, 0.0f, 0.0f);
                        AnimationSet animationSet2 = new AnimationSet(true);
                        animationSet2.setInterpolator(new AccelerateDecelerateInterpolator());
                        animationSet2.setDuration(integer);
                        animationSet2.addAnimation(alphaAnimation2);
                        animationSet2.addAnimation(translateAnimation2);
                        this.this$0.startAnimation(animationSet2);
                    }
                }
            });
            return;
        }
        if (getVisibility() == 0) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(integer);
            startAnimation(alphaAnimation2);
            setVisibility(8);
        }
    }

    public final void updateState(GridBannerState state) {
        String quantityString;
        String string;
        Intrinsics.checkNotNullParameter(state, "state");
        setVisibility(state.isVisible());
        TextView textView = this.title;
        int i = WhenMappings.$EnumSwitchMapping$0[state.getStatus().ordinal()];
        if (i == 1) {
            quantityString = getResources().getQuantityString(C6079R.plurals.freemium_banner_trial_title, state.getRemainingTrialDays(), Integer.valueOf(state.getRemainingTrialDays()));
        } else if (i == 2) {
            quantityString = getResources().getString(C6079R.string.freemium_banner_title);
        }
        textView.setText(quantityString);
        TextView textView2 = this.description;
        int i2 = WhenMappings.$EnumSwitchMapping$0[state.getStatus().ordinal()];
        if (i2 == 1) {
            string = getResources().getString(C6079R.string.freemium_banner_trial_message);
        } else if (i2 == 2) {
            string = getResources().getString(C6079R.string.freemium_banner_message);
        }
        textView2.setText(string);
        this.actionButton.setEnabled(state.getHasInternet());
        this.actionButton.setAlpha(state.getHasInternet() ? 1.0f : 0.5f);
    }
}
