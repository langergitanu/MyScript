package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C8357R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SpenPenAttrMiniView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b,\b\u0016\u0018\u0000 K2\u00020\u0001:\u0001KB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0014H\u0016J(\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0014J\b\u0010(\u001a\u00020 H\u0016J\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0010\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\tJ\u000e\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u000fJ\u000e\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u000fJ*\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u00142\b\b\u0002\u00109\u001a\u00020\u000fJ\u0018\u0010?\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u000fH\u0002J\b\u0010C\u001a\u00020 H\u0002J\u0010\u0010D\u001a\u00020 2\u0006\u00104\u001a\u00020\u000fH\u0002J\u0018\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010G\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\u000fH\u0002J\u001a\u0010J\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010:\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f8D@DX\u0084\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010<¨\u0006L"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mLabelFormat", "", "mLabelText", "Landroid/widget/TextView;", "mColorView", "Landroid/widget/ImageView;", "mValue", "", "mSelectedView", "Landroid/view/View;", "mColorBackground", "mApplyDynamicColorSize", "", "mDiffColorRadius", "mSizeLevel", "mDefaultMargin", "mColor", "mNormalResId", "mFullResId", "mCurrentResId", "mUseNormalBackgroundTint", "mNormalBackgroundTintColor", "mUserDefineChildLayoutId", "onFinishInflate", "", "setSelected", "selected", "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", "close", "setValue", "value", "setColor", "color", "setLabelFormat", "format", "setLabelVisibility", "visibility", "setSizeLevel", "sizeLevel", "setColorBackground", "resId", "setDynamicColorBackground", "normalId", "fullResId", "useNormalTintColor", "normalTintColor", "userDefineChildLayout", "getUserDefineChildLayout", "()I", "setUserDefineChildLayout", "(I)V", "initView", "layoutResource", "inflateChildId", "getInflateChildId", "adjustBackground", "setInnerColorBackground", "setInnerColorBackgroundTint", "enable", "updateLabelText", "updateColorSize", FirebaseAnalytics.Param.LEVEL, "setAttributes", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public class SpenPenAttrMiniView extends FrameLayout {
    private static final int SHOW_TEXT_DURATION = 200;
    private static final String TAG = "SpenPenAttrMiniView";
    private boolean mApplyDynamicColorSize;
    private int mColor;
    private View mColorBackground;
    private ImageView mColorView;
    private int mCurrentResId;
    private int mDefaultMargin;
    private int mDiffColorRadius;
    private int mFullResId;
    private String mLabelFormat;
    private TextView mLabelText;
    private int mNormalBackgroundTintColor;
    private int mNormalResId;
    private View mSelectedView;
    private int mSizeLevel;
    private boolean mUseNormalBackgroundTint;
    private int mUserDefineChildLayoutId;
    private int mValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenAttrMiniView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setAttributes(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, getInflateChildId());
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        View view = this.mSelectedView;
        if (view != null) {
            view.setBackgroundResource(selected ? C8357R.drawable.setting_mini_attr_selected_bg : 0);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (!this.mApplyDynamicColorSize || h <= 0 || this.mSizeLevel <= 0) {
            return;
        }
        new Handler().post(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SpenPenAttrMiniView.onSizeChanged$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSizeChanged$lambda$0(SpenPenAttrMiniView spenPenAttrMiniView) {
        spenPenAttrMiniView.updateColorSize(spenPenAttrMiniView.mSizeLevel);
    }

    public void close() {
        this.mSelectedView = null;
        this.mColorView = null;
    }

    public final void setValue(int value) {
        this.mValue = value;
        updateLabelText(value);
    }

    public void setColor(int color) {
        ImageView imageView = this.mColorView;
        if (imageView == null || this.mColor == color) {
            return;
        }
        this.mColor = color;
        Intrinsics.checkNotNull(imageView);
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        adjustBackground();
    }

    public final void setLabelFormat(String format) {
        this.mLabelFormat = format;
        updateLabelText(this.mValue);
    }

    public final void setLabelVisibility(int visibility) {
        TextView textView = this.mLabelText;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNull(textView);
        if (textView.getVisibility() != visibility) {
            TextView textView2 = this.mLabelText;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(visibility);
            if (visibility == 0) {
                SpenSettingUtilAnimation.alphaVisibleAnimation$default(this.mLabelText, 15, 200L, null, 8, null);
            }
        }
    }

    public final void setSizeLevel(int sizeLevel) {
        if (!this.mApplyDynamicColorSize || this.mSizeLevel == sizeLevel) {
            return;
        }
        this.mSizeLevel = sizeLevel;
        updateColorSize(sizeLevel);
        adjustBackground();
    }

    public final void setColorBackground(int resId) {
        setInnerColorBackground(resId);
        setInnerColorBackgroundTint(false, 0);
        this.mNormalResId = -1;
        this.mFullResId = -1;
        this.mUseNormalBackgroundTint = false;
        this.mNormalBackgroundTintColor = 0;
    }

    public static /* synthetic */ void setDynamicColorBackground$default(SpenPenAttrMiniView spenPenAttrMiniView, int i, int i2, boolean z, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDynamicColorBackground");
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        spenPenAttrMiniView.setDynamicColorBackground(i, i2, z, i3);
    }

    public final void setDynamicColorBackground(int normalId, int fullResId, boolean useNormalTintColor, int normalTintColor) {
        if (this.mApplyDynamicColorSize) {
            this.mUseNormalBackgroundTint = useNormalTintColor;
            this.mNormalBackgroundTintColor = normalTintColor;
            this.mNormalResId = normalId;
            this.mFullResId = fullResId;
            adjustBackground();
        }
    }

    /* JADX INFO: renamed from: getUserDefineChildLayout, reason: from getter */
    protected final int getMUserDefineChildLayoutId() {
        return this.mUserDefineChildLayoutId;
    }

    protected final void setUserDefineChildLayout(int i) {
        this.mUserDefineChildLayoutId = i;
    }

    private final void initView(Context context, int layoutResource) {
        if (layoutResource != 0) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            ((LayoutInflater) systemService).inflate(layoutResource, (ViewGroup) this, true);
        }
        this.mLabelText = (TextView) findViewById(C8357R.id.text_label);
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        ImageView imageView = (ImageView) findViewById(C8357R.id.color);
        this.mColorView = imageView;
        if (imageView != null) {
            spenGradientDrawableHelper.setDrawableInfo(1, -16777216, 0, 0);
            ImageView imageView2 = this.mColorView;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageDrawable(spenGradientDrawableHelper.makeDrawable());
            ImageView imageView3 = this.mColorView;
            Intrinsics.checkNotNull(imageView3);
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            this.mDefaultMargin = ((FrameLayout.LayoutParams) layoutParams).topMargin;
        }
        this.mLabelFormat = TimeModel.NUMBER_FORMAT;
        this.mSelectedView = findViewById(C8357R.id.color_selected);
        this.mColorBackground = findViewById(C8357R.id.color_background);
    }

    private final int getInflateChildId() {
        if (getChildCount() > 0) {
            return 0;
        }
        int i = this.mUserDefineChildLayoutId;
        return i != 0 ? i : C8357R.layout.setting_pen_attr_mini_view;
    }

    private final void adjustBackground() {
        if (!this.mApplyDynamicColorSize || this.mNormalResId == -1) {
            return;
        }
        int i = (this.mSizeLevel == 100 && Color.alpha(this.mColor) == 255) ? this.mFullResId : this.mNormalResId;
        setInnerColorBackground(i);
        setInnerColorBackgroundTint(i == this.mNormalResId && this.mUseNormalBackgroundTint, this.mNormalBackgroundTintColor);
    }

    private final void setInnerColorBackground(int resId) {
        View view = this.mColorBackground;
        if (view == null || this.mCurrentResId == resId) {
            return;
        }
        this.mCurrentResId = resId;
        Intrinsics.checkNotNull(view);
        view.setBackgroundResource(resId);
    }

    private final void setInnerColorBackgroundTint(boolean enable, int color) {
        View view = this.mColorBackground;
        if (view != null) {
            view.setBackgroundTintList(enable ? ColorStateList.valueOf(color) : null);
        }
    }

    private final void updateLabelText(int value) {
        Log.i(TAG, "updateLabelText() value=" + value);
        if (this.mLabelText == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = this.mLabelFormat;
        Intrinsics.checkNotNull(str);
        String str2 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(value)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        TextView textView = this.mLabelText;
        Intrinsics.checkNotNull(textView);
        textView.setText(str2);
    }

    private final void updateColorSize(int level) {
        ImageView imageView = this.mColorView;
        if (imageView == null || !this.mApplyDynamicColorSize) {
            return;
        }
        int i = ((int) (((double) (this.mDiffColorRadius * (100 - level))) * 0.01d)) + this.mDefaultMargin;
        Intrinsics.checkNotNull(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(i, i, i, i);
        ImageView imageView2 = this.mColorView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setLayoutParams(layoutParams2);
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8357R.dimen.mini_pen_attr_default_color_diff_radius);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C8357R.styleable.SpenPenAttrMiniView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                this.mApplyDynamicColorSize = typedArrayObtainStyledAttributes.getBoolean(C8357R.styleable.SpenPenAttrMiniView_applyDynamicColorSize, false);
                this.mDiffColorRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8357R.styleable.SpenPenAttrMiniView_diffColorRadius, dimensionPixelSize);
                this.mUserDefineChildLayoutId = typedArrayObtainStyledAttributes.getResourceId(C8357R.styleable.SpenPenAttrMiniView_childLayout, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } else {
            this.mApplyDynamicColorSize = false;
            this.mDiffColorRadius = dimensionPixelSize;
            this.mUserDefineChildLayoutId = 0;
        }
        this.mSizeLevel = 0;
        this.mColor = 0;
        this.mNormalResId = -1;
        this.mFullResId = -1;
        this.mCurrentResId = 0;
    }
}
