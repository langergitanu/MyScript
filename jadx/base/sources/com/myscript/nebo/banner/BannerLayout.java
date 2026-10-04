package com.myscript.nebo.banner;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.myscript.android.utils.ColorExt;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public class BannerLayout extends FrameLayout {
    private static final long BANNER_TRANSLATION_DURATION = 250;
    private static final int TRANSIENT_MAX_PROGRESS = 100;
    private static final int TRANSIENT_MIN_PROGRESS = 0;
    private Callback mCallback;
    private TextView mPermanentActionButton;
    private View mPermanentBanner;
    private String mPermanentBannerId;
    private TextView mPermanentBannerMessage;
    private ImageButton mPermanentCloseButton;
    private TextView mPermanentSecondaryActionButton;
    private TextView mTransientActionButton;
    private View mTransientBanner;
    private long mTransientBannerDuration;
    private String mTransientBannerId;
    private TextView mTransientBannerMessage;
    private ProgressBar mTransientBannerProgress;
    private TextView mTransientSecondaryActionButton;

    public interface Callback {
        void onActionButtonClicked(String str, Action action);

        void onClosed(String str);
    }

    public BannerLayout(Context context) {
        super(context);
        init();
    }

    public BannerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BannerLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C6079R.layout.banner, (ViewGroup) this, true);
        this.mPermanentBanner = findViewById(C6079R.id.permanent_banner);
        this.mPermanentBannerMessage = (TextView) findViewById(C6079R.id.permanent_banner_message);
        TextView textView = (TextView) findViewById(C6079R.id.permanent_banner_action);
        this.mPermanentActionButton = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        TextView textView2 = (TextView) findViewById(C6079R.id.permanent_banner_secondary_action);
        this.mPermanentSecondaryActionButton = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$1(view);
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C6079R.id.permanent_banner_close);
        this.mPermanentCloseButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onPermanentBannerClose(view);
            }
        });
        View viewFindViewById = findViewById(C6079R.id.transient_banner);
        this.mTransientBanner = viewFindViewById;
        viewFindViewById.post(new Runnable() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$2();
            }
        });
        this.mTransientBannerMessage = (TextView) findViewById(C6079R.id.transient_banner_message);
        TextView textView3 = (TextView) findViewById(C6079R.id.transient_banner_action);
        this.mTransientActionButton = textView3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$3(view);
            }
        });
        TextView textView4 = (TextView) findViewById(C6079R.id.transient_banner_secondary_action);
        this.mTransientSecondaryActionButton = textView4;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$4(view);
            }
        });
        ProgressBar progressBar = (ProgressBar) findViewById(C6079R.id.transient_banner_progress);
        this.mTransientBannerProgress = progressBar;
        progressBar.setProgress(0);
        this.mTransientBannerProgress.setMax(100);
        this.mTransientBannerProgress.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$5(view);
            }
        });
        this.mTransientBannerDuration = getContext().getResources().getInteger(C6079R.integer.transient_banner_duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        onBannerAction(view, this.mPermanentBannerId, Action.PRIMARY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        onBannerAction(view, this.mPermanentBannerId, Action.SECONDARY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2() {
        this.mTransientBanner.setTranslationY(-r0.getMeasuredHeight());
        this.mTransientBanner.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(View view) {
        onBannerAction(view, this.mTransientBannerId, Action.PRIMARY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$4(View view) {
        onBannerAction(view, this.mTransientBannerId, Action.SECONDARY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$5(View view) {
        if (this.mCallback == null || this.mTransientBannerId == null) {
            return;
        }
        this.mTransientBannerProgress.setEnabled(false);
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        this.mCallback.onClosed(this.mTransientBannerId);
    }

    public void permanentBannerChanged(Banner banner) {
        setPermanentBanner(banner);
        showPermanentBanner(banner != null);
    }

    public void transientBannerChanged(Banner banner) {
        setTransientBanner(banner);
        boolean z = banner != null;
        showTransientBanner(z, z ? banner.getId() : null);
    }

    private void setPermanentBanner(Banner banner) {
        if (banner == null) {
            this.mPermanentBannerId = null;
            return;
        }
        int backgroundColor = getBackgroundColor(banner);
        int foregroundColor = getForegroundColor(backgroundColor);
        this.mPermanentBannerId = banner.getId();
        this.mPermanentBanner.setBackgroundColor(backgroundColor);
        this.mPermanentBannerMessage.setText(banner.getMessage());
        this.mPermanentBannerMessage.setTextColor(foregroundColor);
        this.mPermanentBannerMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(getTintedMessageDrawable(banner.getMessageDrawable(), foregroundColor), (Drawable) null, (Drawable) null, (Drawable) null);
        String actionText = banner.getActionText();
        if (!TextUtils.isEmpty(actionText) && banner.getAction() != null) {
            this.mPermanentActionButton.setText(actionText);
            this.mPermanentActionButton.setTextColor(foregroundColor);
            this.mPermanentActionButton.setVisibility(0);
        } else {
            this.mPermanentActionButton.setVisibility(8);
        }
        this.mPermanentActionButton.setEnabled(banner.getAction() != null);
        String secondaryActionText = banner.getSecondaryActionText();
        if (!TextUtils.isEmpty(secondaryActionText)) {
            this.mPermanentSecondaryActionButton.setText(secondaryActionText);
            this.mPermanentSecondaryActionButton.setTextColor(foregroundColor);
            this.mPermanentSecondaryActionButton.setVisibility(0);
        } else {
            this.mPermanentSecondaryActionButton.setVisibility(8);
        }
        this.mPermanentSecondaryActionButton.setEnabled(banner.getSecondaryAction() != null);
        this.mPermanentCloseButton.setVisibility(banner.getIsCloseable() ? 0 : 8);
        this.mPermanentCloseButton.setColorFilter(foregroundColor, PorterDuff.Mode.SRC_IN);
    }

    private void showPermanentBanner(boolean z) {
        animateBanner(this.mPermanentBanner, z);
    }

    private void onBannerAction(View view, String str, Action action) {
        if (this.mCallback == null || str == null) {
            return;
        }
        view.setEnabled(false);
        this.mCallback.onActionButtonClicked(str, action);
        view.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermanentBannerClose(View view) {
        String str;
        Callback callback = this.mCallback;
        if (callback == null || (str = this.mPermanentBannerId) == null) {
            return;
        }
        callback.onClosed(str);
    }

    private void setTransientBanner(Banner banner) {
        if (banner == null) {
            this.mTransientBannerId = null;
            return;
        }
        int backgroundColor = getBackgroundColor(banner);
        int foregroundColor = getForegroundColor(backgroundColor);
        this.mTransientBannerId = banner.getId();
        this.mTransientBanner.setBackgroundColor(backgroundColor);
        this.mTransientBannerMessage.setText(banner.getMessage());
        this.mTransientBannerMessage.setTextColor(foregroundColor);
        this.mTransientBannerMessage.setCompoundDrawablesWithIntrinsicBounds(getTintedMessageDrawable(banner.getMessageDrawable(), foregroundColor), (Drawable) null, (Drawable) null, (Drawable) null);
        String actionText = banner.getActionText();
        if (TextUtils.isEmpty(actionText)) {
            this.mTransientActionButton.setVisibility(8);
        } else {
            this.mTransientActionButton.setText(actionText);
            this.mTransientActionButton.setTextColor(foregroundColor);
            this.mTransientActionButton.setVisibility(0);
        }
        this.mTransientActionButton.setEnabled(banner.getAction() != null);
        String secondaryActionText = banner.getSecondaryActionText();
        if (TextUtils.isEmpty(secondaryActionText)) {
            this.mTransientSecondaryActionButton.setVisibility(8);
        } else {
            this.mTransientSecondaryActionButton.setText(secondaryActionText);
            this.mTransientSecondaryActionButton.setTextColor(foregroundColor);
            this.mTransientSecondaryActionButton.setVisibility(0);
        }
        this.mTransientSecondaryActionButton.setEnabled(banner.getSecondaryAction() == null);
        this.mTransientBannerProgress.setProgress(0);
        Drawable progressDrawable = this.mTransientBannerProgress.getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.mutate().setTint(foregroundColor);
        }
    }

    private void showTransientBanner(boolean z, final String str) {
        if (z && str != null && str.equals(this.mTransientBannerId)) {
            animateBanner(this.mTransientBanner, true);
            this.mTransientBannerProgress.setEnabled(true);
            animateTransientProgress();
            postDelayed(new Runnable() { // from class: com.myscript.nebo.banner.BannerLayout$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showTransientBanner$6(str);
                }
            }, this.mTransientBannerDuration);
            return;
        }
        animateBanner(this.mTransientBanner, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTransientBanner$6(String str) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onClosed(str);
        }
    }

    private void animateBanner(final View view, final boolean z) {
        final float translationY = view.getTranslationY();
        final float f = z ? 0.0f : -view.getMeasuredHeight();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", translationY, f);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.myscript.nebo.banner.BannerLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setTranslationY(translationY);
                view.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f);
                view.setVisibility(z ? 0 : 8);
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void animateTransientProgress() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.mTransientBannerProgress, "progress", 0, 100);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(this.mTransientBannerDuration);
        objectAnimatorOfInt.start();
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private Drawable getTintedMessageDrawable(int i, int i2) {
        if (i == 0) {
            return null;
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable == null) {
            return drawable;
        }
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(drawableMutate, i2);
        return drawableMutate;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.banner.BannerLayout$2 */
    static /* synthetic */ class C61632 {
        static final /* synthetic */ int[] $SwitchMap$com$myscript$nebo$banner$Priority;

        static {
            int[] iArr = new int[Priority.values().length];
            $SwitchMap$com$myscript$nebo$banner$Priority = iArr;
            try {
                iArr[Priority.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$myscript$nebo$banner$Priority[Priority.FORBIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$myscript$nebo$banner$Priority[Priority.CORRUPTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$myscript$nebo$banner$Priority[Priority.MARKETING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$myscript$nebo$banner$Priority[Priority.FEEDBACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private int getBackgroundColor(Banner banner) {
        int i;
        Resources resources = getContext().getResources();
        int i2 = C61632.$SwitchMap$com$myscript$nebo$banner$Priority[banner.getPriority().ordinal()];
        if (i2 == 1 || i2 == 2) {
            i = C6079R.color.banner_warning_background_color;
        } else if (i2 == 3) {
            i = C6079R.color.banner_corrupted_background_color;
        } else if (i2 == 4) {
            i = C6079R.color.banner_marketing_background_color;
        } else {
            i = C6079R.color.banner_feedback_background_color;
        }
        return ResourcesCompat.getColor(resources, i, getContext().getTheme());
    }

    private int getForegroundColor(int i) {
        Resources resources = getContext().getResources();
        Resources.Theme theme = getContext().getTheme();
        return ((Integer) ColorExt.getBrightnessAwareValue(i, Integer.valueOf(ResourcesCompat.getColor(resources, C6079R.color.banner_foreground_light_color, theme)), Integer.valueOf(ResourcesCompat.getColor(resources, C6079R.color.banner_foreground_dark_color, theme)))).intValue();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        setOutlineProvider(new CustomOutline(i, i2));
    }

    private class CustomOutline extends ViewOutlineProvider {
        int height;
        int width;

        CustomOutline(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, this.width, this.height);
        }
    }
}
