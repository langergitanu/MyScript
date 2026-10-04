package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C8357R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenPenWidthMiniLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\"\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthMiniLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayoutInterface;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mIcon", "Landroid/widget/ImageView;", "mIsFixedWidth", "", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayoutInterface$OnDataChangedListener;", "close", "", "onFinishInflate", "setPenInfo", "penName", "", "sizeLevel", "", "color", "setPenWidth", "isFixed", "needAnimation", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initView", "layoutResource", "setFixedWidth", "isFixedWidth", "setIconInfo", "resId", "stringId", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenPenWidthMiniLayout extends FrameLayout implements SpenPenWidthLayoutInterface {
    private static final String TAG = "SpenPenWidthMiniView";
    private SpenPenWidthLayoutInterface.OnDataChangedListener mDataChangedListener;
    private ImageView mIcon;
    private boolean mIsFixedWidth;

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setPenInfo(String penName, int sizeLevel, int color) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenWidthMiniLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void close() {
        this.mIcon = null;
        this.mDataChangedListener = null;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, getChildCount() == 0 ? C8357R.layout.setting_pen_width_mini_layout : 0);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setPenWidth(boolean isFixed, boolean needAnimation) {
        Log.i(TAG, "setPenWidth() isFixedWidth=" + isFixed + " needAnimation=" + needAnimation);
        if (this.mIcon == null || this.mIsFixedWidth == isFixed) {
            return;
        }
        setFixedWidth(isFixed, needAnimation);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setDataChangedListener(SpenPenWidthLayoutInterface.OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    private final void initView(Context context, int layoutResource) {
        if (layoutResource != 0) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            ((LayoutInflater) systemService).inflate(layoutResource, (ViewGroup) this, true);
        }
        this.mIcon = (ImageView) findViewById(C8357R.id.width_view);
        setFixedWidth(this.mIsFixedWidth, false);
        ImageView imageView = this.mIcon;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthMiniLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpenPenWidthMiniLayout.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenPenWidthMiniLayout spenPenWidthMiniLayout, View view) {
        spenPenWidthMiniLayout.setFixedWidth(!spenPenWidthMiniLayout.mIsFixedWidth, true);
        SpenPenWidthLayoutInterface.OnDataChangedListener onDataChangedListener = spenPenWidthMiniLayout.mDataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onPenWidthChanged(spenPenWidthMiniLayout.mIsFixedWidth);
        }
    }

    private final void setFixedWidth(boolean isFixedWidth, boolean needAnimation) {
        Log.i(TAG, "setPenWidth() isFixedWidth=" + isFixedWidth + " needAnimation=" + needAnimation);
        this.mIsFixedWidth = isFixedWidth;
        if (isFixedWidth) {
            setIconInfo(C8357R.drawable.pressure_off, C8357R.string.pen_string_fixed_thickness);
        } else {
            setIconInfo(C8357R.drawable.pressure_on, C8357R.string.pen_string_variable_thickness);
        }
    }

    private final void setIconInfo(int resId, int stringId) {
        ImageView imageView = this.mIcon;
        if (imageView == null) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(resId);
        ImageView imageView2 = this.mIcon;
        Intrinsics.checkNotNull(imageView2);
        String string = imageView2.getContext().getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageView imageView3 = this.mIcon;
        Intrinsics.checkNotNull(imageView3);
        String str = string;
        imageView3.setContentDescription(str);
        SpenSettingUtilHover.setHoverText(this.mIcon, str);
    }
}
