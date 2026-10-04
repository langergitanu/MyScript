package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteColorHelper;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteDataHelper;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteDefine;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C8357R;
import com.survicate.surveys.TextRecallingManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenQTColorDialControl.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\b\u0000\u0018\u0000 Y2\u00020\u0001:\u0004YZ[\\B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\fJ\u0016\u0010\"\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0016\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0005J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0005H\u0002J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001bJ\u0010\u0010,\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u001dJ\u0014\u0010-\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0/J\u001e\u00100\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0/H\u0002J\u0016\u00101\u001a\u00020\u001f2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010/J \u00104\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010/H\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\u0012\u00106\u001a\u0004\u0018\u00010\u00142\u0006\u00107\u001a\u00020\fH\u0002J\b\u00108\u001a\u00020\fH\u0002J\b\u00109\u001a\u00020\u001fH\u0002J\u0016\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000fJ(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002J \u0010:\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000fH\u0002J\u0018\u0010@\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000fH\u0002J\u0018\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000fH\u0002J\u0010\u0010C\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000fH\u0002J\u0018\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000fH\u0002J\u0018\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000fH\u0002J\u000e\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020\u000fJ\u000e\u0010L\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\fJ\u0010\u0010M\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\fH\u0002J\u0018\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fH\u0002J \u0010Q\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\f2\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H\u0002J\u0018\u0010N\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0005H\u0002J\b\u0010U\u001a\u00020\fH\u0002J\b\u0010V\u001a\u00020\u001fH\u0002J\u0010\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorDialControl;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "hasRecentColor", "", "<init>", "(Landroid/content/Context;Z)V", "mContext", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mDialIndex", "", "mFrom", "mOtherColor", "", "mColorDataHelper", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteDataHelper;", "mPaletteItems", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorDialControl$ColorItem;", "mRecentItems", "mDividerIndexes", "mHasRecentColor", "mDialLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorDialControl$OnActionButtonListener;", "mColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorDialControl$OnColorChangedListener;", "close", "", "setColorTheme", "theme", "updateVisibleColor", "list", "initColorLayout", "dialLayout", "supportEyedropper", "setFixedItem", "setEyedropperEnabled", "enabled", "setActionButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setColorChangedListener", "setPaletteList", "paletteList", "", "reconfigureColor", "setRecentColor", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "reconfigureRecentColor", "updateColorDial", "getColorInfo", "dialIndex", "getDefaultPaletteId", "notifyColorChanged", "setColor", "uiInfo", "color", "needAnimation", "moveToCurrent", TypedValues.TransitionType.S_FROM, "getDialIndex", "getPaletteDialIndex", "viewIndex", "getRecentDialIndex", "copyColor", "srcColor", "destColor", "isSameColor", "color1", "color2", "setPickerColor", "hsvColor", "setEyedropperColor", "onDialColorSelect", "updateLayout", "oldDialIndex", "newDialIndex", "setDialSelected", "selected", "selectItemAnimation", "animation", "getTotalDialItemCount", "applyPickerColor", "getVisibleColor", "contentColor", "Companion", "ColorItem", "OnActionButtonListener", "OnColorChangedListener", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenQTColorDialControl {
    private static final int EYEDROPPER_BUTTON_POSITION = 1;
    private static final int PICKER_BUTTON_POSITION = 0;
    private static final int RECENT_COLOR_MAX = 8;
    private static final String TAG = "SpenQTColorDialControl";
    private OnActionButtonListener mActionListener;
    private OnColorChangedListener mColorChangedListener;
    private SpenPaletteDataHelper mColorDataHelper;
    private SpenColorThemeUtil mColorThemeUtil;
    private Context mContext;
    private int mDialIndex;
    private SpenSettingQTColorDialLayout mDialLayout;
    private List<Integer> mDividerIndexes;
    private int mFrom;
    private boolean mHasRecentColor;
    private float[] mOtherColor;
    private List<ColorItem> mPaletteItems;
    private List<ColorItem> mRecentItems;

    /* JADX INFO: compiled from: SpenQTColorDialControl.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorDialControl$OnActionButtonListener;", "", "onPickerButtonClick", "", "onEyedropperButtonClick", "onColorButtonClicked", FirebaseAnalytics.Param.INDEX, "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface OnActionButtonListener {
        void onColorButtonClicked(int index);

        void onEyedropperButtonClick();

        void onPickerButtonClick();
    }

    /* JADX INFO: compiled from: SpenQTColorDialControl.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorDialControl$OnColorChangedListener;", "", "onColorChanged", "", "info", "", "hsvColor", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public interface OnColorChangedListener {
        void onColorChanged(int info, float[] hsvColor);
    }

    public SpenQTColorDialControl(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mDialIndex = -1;
        this.mOtherColor = new float[3];
        this.mColorDataHelper = new SpenPaletteDataHelper();
        this.mPaletteItems = new ArrayList();
        this.mRecentItems = new ArrayList();
        this.mDividerIndexes = new ArrayList();
        this.mHasRecentColor = z;
    }

    /* JADX INFO: compiled from: SpenQTColorDialControl.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTColorDialControl$ColorItem;", "", "colorUIInfo", "", "contentColor", "", "visibleColor", "description", "", "<init>", "(I[FILjava/lang/CharSequence;)V", "getColorUIInfo", "()I", "setColorUIInfo", "(I)V", "getContentColor", "()[F", "setContentColor", "([F)V", "getVisibleColor", "setVisibleColor", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final /* data */ class ColorItem {
        private int colorUIInfo;
        private float[] contentColor;
        private CharSequence description;
        private int visibleColor;

        public ColorItem() {
            this(0, null, 0, null, 15, null);
        }

        public static /* synthetic */ ColorItem copy$default(ColorItem colorItem, int i, float[] fArr, int i2, CharSequence charSequence, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = colorItem.colorUIInfo;
            }
            if ((i3 & 2) != 0) {
                fArr = colorItem.contentColor;
            }
            if ((i3 & 4) != 0) {
                i2 = colorItem.visibleColor;
            }
            if ((i3 & 8) != 0) {
                charSequence = colorItem.description;
            }
            return colorItem.copy(i, fArr, i2, charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getColorUIInfo() {
            return this.colorUIInfo;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float[] getContentColor() {
            return this.contentColor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getVisibleColor() {
            return this.visibleColor;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        public final ColorItem copy(int colorUIInfo, float[] contentColor, int visibleColor, CharSequence description) {
            Intrinsics.checkNotNullParameter(contentColor, "contentColor");
            return new ColorItem(colorUIInfo, contentColor, visibleColor, description);
        }

        public String toString() {
            return "ColorItem(colorUIInfo=" + this.colorUIInfo + ", contentColor=" + Arrays.toString(this.contentColor) + ", visibleColor=" + this.visibleColor + ", description=" + ((Object) this.description) + ")";
        }

        public ColorItem(int i, float[] contentColor, int i2, CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(contentColor, "contentColor");
            this.colorUIInfo = i;
            this.contentColor = contentColor;
            this.visibleColor = i2;
            this.description = charSequence;
        }

        public final int getColorUIInfo() {
            return this.colorUIInfo;
        }

        public final void setColorUIInfo(int i) {
            this.colorUIInfo = i;
        }

        public /* synthetic */ ColorItem(int i, float[] fArr, int i2, CharSequence charSequence, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? new float[]{0.0f, 0.0f, 0.0f} : fArr, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : charSequence);
        }

        public final float[] getContentColor() {
            return this.contentColor;
        }

        public final void setContentColor(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.contentColor = fArr;
        }

        public final int getVisibleColor() {
            return this.visibleColor;
        }

        public final void setVisibleColor(int i) {
            this.visibleColor = i;
        }

        public final CharSequence getDescription() {
            return this.description;
        }

        public final void setDescription(CharSequence charSequence) {
            this.description = charSequence;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorDialControl.ColorItem");
            ColorItem colorItem = (ColorItem) other;
            if (this.colorUIInfo != colorItem.colorUIInfo) {
                return false;
            }
            float[] fArr = this.contentColor;
            float f = fArr[0];
            float[] fArr2 = colorItem.contentColor;
            return f == fArr2[0] && fArr[1] == fArr2[1] && fArr[2] == fArr2[2] && this.visibleColor == colorItem.visibleColor && Intrinsics.areEqual(this.description, colorItem.description);
        }

        public int hashCode() {
            int iHashCode = ((((this.colorUIInfo * 31) + Arrays.hashCode(this.contentColor)) * 31) + this.visibleColor) * 31;
            CharSequence charSequence = this.description;
            return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
        }
    }

    public final void close() {
        this.mContext = null;
        this.mColorThemeUtil.close();
    }

    public final void setColorTheme(int theme) {
        this.mColorThemeUtil.setColorTheme(theme);
        updateVisibleColor(this.mPaletteItems);
        updateVisibleColor(this.mRecentItems);
        updateColorDial();
    }

    private final void updateVisibleColor(List<ColorItem> list) {
        for (ColorItem colorItem : list) {
            colorItem.setVisibleColor(getVisibleColor(colorItem.getContentColor()));
        }
    }

    public final boolean initColorLayout(SpenSettingQTColorDialLayout dialLayout, boolean supportEyedropper) {
        Intrinsics.checkNotNullParameter(dialLayout, "dialLayout");
        if (this.mContext == null) {
            return false;
        }
        setFixedItem(dialLayout, supportEyedropper);
        dialLayout.setActionListener(new SpenSettingQTColorDialLayout.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorDialControl.initColorLayout.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.ActionListener
            public void onFixedButtonClick(int index, boolean isSelected) {
                OnActionButtonListener onActionButtonListener;
                if (index != 0) {
                    if (index == 1 && (onActionButtonListener = SpenQTColorDialControl.this.mActionListener) != null) {
                        onActionButtonListener.onEyedropperButtonClick();
                        return;
                    }
                    return;
                }
                OnActionButtonListener onActionButtonListener2 = SpenQTColorDialControl.this.mActionListener;
                if (onActionButtonListener2 != null) {
                    onActionButtonListener2.onPickerButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.ActionListener
            public void onDialButtonClick(int index, boolean isSelected) {
                OnActionButtonListener onActionButtonListener = SpenQTColorDialControl.this.mActionListener;
                if (onActionButtonListener != null) {
                    onActionButtonListener.onColorButtonClicked(index);
                }
                if (isSelected) {
                    SpenQTColorDialControl.this.onDialColorSelect(index);
                }
            }
        });
        this.mDialLayout = dialLayout;
        return true;
    }

    private final void setFixedItem(SpenSettingQTColorDialLayout dialLayout, boolean supportEyedropper) {
        int i = C8357R.drawable.note_handwriting_setting_color_01;
        int i2 = C8357R.drawable.color_picker_icon_selector;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        List<SpenSettingQTColorDialLayout.FixedItem> listMutableListOf = CollectionsKt.mutableListOf(new SpenSettingQTColorDialLayout.FixedItem(i, i2, context.getString(C8357R.string.pen_string_color_picker)));
        if (supportEyedropper) {
            int i3 = C8357R.drawable.qt_ic_spoid;
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            listMutableListOf.add(new SpenSettingQTColorDialLayout.FixedItem(i3, 0, context2.getString(C8357R.string.pen_string_color_spuit)));
        }
        dialLayout.setFixedItems(listMutableListOf);
    }

    public final void setEyedropperEnabled(boolean enabled) {
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.mDialLayout;
        if (spenSettingQTColorDialLayout != null) {
            setFixedItem(spenSettingQTColorDialLayout, enabled);
        }
    }

    public final void setActionButtonListener(OnActionButtonListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mActionListener = listener;
    }

    public final void setColorChangedListener(OnColorChangedListener listener) {
        this.mColorChangedListener = listener;
    }

    public final void setPaletteList(List<Integer> paletteList) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        Intrinsics.checkNotNull(context);
        reconfigureColor(context, paletteList);
        updateColorDial();
    }

    private final void reconfigureColor(Context context, List<Integer> paletteList) {
        this.mColorDataHelper.setPaletteInfo(context, paletteList, -1);
        this.mPaletteItems.clear();
        Iterator<T> it = paletteList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            int iIntValue = ((Number) it.next()).intValue();
            SpenColorPaletteData paletteData = this.mColorDataHelper.getPaletteData(i);
            if (paletteData != null) {
                int colorUIInfo = SpenPaletteDefine.getColorUIInfo(iIntValue, 2);
                int length = paletteData.values.length;
                for (int i3 = 0; i3 < length; i3++) {
                    ColorItem colorItem = new ColorItem(0, null, 0, null, 15, null);
                    colorItem.setColorUIInfo(colorUIInfo);
                    Color.colorToHSV(paletteData.values[i3], colorItem.getContentColor());
                    colorItem.setDescription(paletteData.names[i3]);
                    colorItem.setVisibleColor(this.mColorThemeUtil.getColorTheme() == 0 ? paletteData.values[i3] : paletteData.themeValues[i3]);
                    this.mPaletteItems.add(colorItem);
                }
            }
            i = i2;
        }
        this.mDividerIndexes.clear();
        if (this.mHasRecentColor) {
            int size = this.mPaletteItems.size();
            this.mDividerIndexes.add(Integer.valueOf(size));
            this.mDividerIndexes.add(Integer.valueOf(size + 7));
        }
    }

    public final void setRecentColor(List<SpenHSVColor> recentList) {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        Intrinsics.checkNotNull(context);
        reconfigureRecentColor(context, recentList);
        updateColorDial();
    }

    private final void reconfigureRecentColor(Context context, List<SpenHSVColor> recentList) {
        if (!this.mHasRecentColor) {
            Log.i(TAG, "Not support recent color hasRecentColor=false");
            return;
        }
        this.mRecentItems.clear();
        if (recentList == null) {
            return;
        }
        SpenPaletteColorHelper spenPaletteColorHelper = new SpenPaletteColorHelper(context);
        int colorUIInfo = SpenPaletteDefine.getColorUIInfo(0, 1);
        for (SpenHSVColor spenHSVColor : CollectionsKt.reversed(recentList)) {
            ColorItem colorItem = new ColorItem(0, null, 0, null, 15, null);
            colorItem.setColorUIInfo(colorUIInfo);
            spenHSVColor.getColor(colorItem.getContentColor());
            colorItem.setDescription(spenPaletteColorHelper.getColorString(colorItem.getContentColor()));
            colorItem.setVisibleColor(SpenSettingUtil.HSVToColor(colorItem.getContentColor()));
            if (this.mColorThemeUtil.getColorTheme() == 1) {
                colorItem.setVisibleColor(this.mColorThemeUtil.getColor(colorItem.getVisibleColor()));
            }
            this.mRecentItems.add(colorItem);
        }
        spenPaletteColorHelper.close();
    }

    private final void updateColorDial() {
        ArrayList arrayList = new ArrayList();
        for (ColorItem colorItem : this.mPaletteItems) {
            arrayList.add(new SpenSettingQTColorDialLayout.ColorDialItem(SpenSettingQTColorDialLayout.DialItemType.COLOR, colorItem.getVisibleColor(), colorItem.getDescription()));
        }
        if (this.mHasRecentColor) {
            arrayList.add(new SpenSettingQTColorDialLayout.ColorDialItem(SpenSettingQTColorDialLayout.DialItemType.DIVIDER, 0, null, 4, null));
            int iMax = Math.max(0, 8 - this.mRecentItems.size());
            for (int i = 0; i < iMax; i++) {
                arrayList.add(new SpenSettingQTColorDialLayout.ColorDialItem(SpenSettingQTColorDialLayout.DialItemType.EMPTY, 0, null, 4, null));
            }
            int i2 = 8 - iMax;
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(new SpenSettingQTColorDialLayout.ColorDialItem(SpenSettingQTColorDialLayout.DialItemType.COLOR, this.mRecentItems.get(i3).getVisibleColor(), this.mRecentItems.get(i3).getDescription()));
            }
            arrayList.add(new SpenSettingQTColorDialLayout.ColorDialItem(SpenSettingQTColorDialLayout.DialItemType.DIVIDER, 0, null, 4, null));
        }
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.mDialLayout;
        if (spenSettingQTColorDialLayout != null) {
            spenSettingQTColorDialLayout.setDialItems(arrayList);
        }
    }

    private final ColorItem getColorInfo(int dialIndex) {
        if (dialIndex < this.mPaletteItems.size()) {
            return this.mPaletteItems.get(dialIndex);
        }
        int size = ((dialIndex - this.mPaletteItems.size()) - 1) - Math.max(0, 8 - this.mRecentItems.size());
        if (size < this.mRecentItems.size()) {
            return this.mRecentItems.get(size);
        }
        return null;
    }

    private final int getDefaultPaletteId() {
        if (this.mHasRecentColor) {
            return 0;
        }
        return this.mColorDataHelper.getPaletteID(0);
    }

    private final void notifyColorChanged() {
        int i = this.mDialIndex;
        ColorItem colorInfo = i > -1 ? getColorInfo(i) : null;
        if (colorInfo != null) {
            Log.i(TAG, "notify() uiInfo=" + colorInfo + ".colorUIInfo, color=[" + colorInfo.getContentColor()[0] + TextRecallingManager.ANSWER_SEPARATOR + colorInfo.getContentColor()[0] + TextRecallingManager.ANSWER_SEPARATOR + colorInfo.getContentColor()[2]);
            OnColorChangedListener onColorChangedListener = this.mColorChangedListener;
            if (onColorChangedListener != null) {
                onColorChangedListener.onColorChanged(colorInfo.getColorUIInfo(), colorInfo.getContentColor());
                return;
            }
            return;
        }
        int colorUIInfo = SpenPaletteDefine.getColorUIInfo(getDefaultPaletteId(), this.mFrom);
        float[] fArr = this.mOtherColor;
        float f = fArr[0];
        Log.i(TAG, "notify() uiInfo=" + colorUIInfo + ", color=[" + f + TextRecallingManager.ANSWER_SEPARATOR + f + TextRecallingManager.ANSWER_SEPARATOR + fArr[2]);
        OnColorChangedListener onColorChangedListener2 = this.mColorChangedListener;
        if (onColorChangedListener2 != null) {
            onColorChangedListener2.onColorChanged(colorUIInfo, this.mOtherColor);
        }
    }

    public final void setColor(int uiInfo, float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        setColor(uiInfo, color, false, true);
    }

    private final void setColor(int uiInfo, float[] color, boolean needAnimation, boolean moveToCurrent) {
        SpenPaletteDefine.showUIInfo(TAG, "setColor()", uiInfo);
        setColor(getDialIndex(uiInfo, color), SpenPaletteDefine.getFromType(uiInfo), color);
        updateLayout(false, needAnimation);
    }

    private final void setColor(int dialIndex, int from, float[] color) {
        if (dialIndex > -1) {
            this.mDialIndex = dialIndex;
            this.mFrom = from;
        } else {
            this.mDialIndex = -1;
            this.mFrom = from;
            copyColor(color, this.mOtherColor);
        }
    }

    private final int getDialIndex(int uiInfo, float[] color) {
        int paletteID = SpenPaletteDefine.getPaletteID(uiInfo);
        int fromType = SpenPaletteDefine.getFromType(uiInfo);
        if (fromType == 1) {
            int recentDialIndex = getRecentDialIndex(color);
            return recentDialIndex > -1 ? recentDialIndex + (this.mColorDataHelper.getPaletteSize() * 8) + 1 : recentDialIndex;
        }
        if (fromType != 2) {
            return -1;
        }
        return getPaletteDialIndex(this.mColorDataHelper.getViewIndex(paletteID), color);
    }

    private final int getPaletteDialIndex(int viewIndex, float[] color) {
        if (viewIndex == -1) {
            return -1;
        }
        int i = viewIndex * 8;
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = i + i2;
            if (isSameColor(this.mPaletteItems.get(i3).getContentColor(), color)) {
                return i3;
            }
        }
        return -1;
    }

    private final int getRecentDialIndex(float[] color) {
        Iterator<T> it = this.mRecentItems.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (isSameColor(((ColorItem) it.next()).getContentColor(), color)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    private final void copyColor(float[] srcColor, float[] destColor) {
        System.arraycopy(srcColor, 0, destColor, 0, 3);
    }

    private final boolean isSameColor(float[] color1, float[] color2) {
        return color1[0] == color2[0] && color1[1] == color2[1] && color1[2] == color2[2];
    }

    public final void setPickerColor(float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        setColor(-1, 4, hsvColor);
        updateLayout(false, true);
        notifyColorChanged();
    }

    public final void setEyedropperColor(int color) {
        if (this.mHasRecentColor) {
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            setColor(SpenPaletteDefine.getColorUIInfo(0, 8), fArr, false, false);
            notifyColorChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDialColorSelect(int dialIndex) {
        ColorItem colorInfo = getColorInfo(dialIndex);
        if (colorInfo == null) {
            Log.i(TAG, "Invalid Color Position. index=" + dialIndex);
            return;
        }
        int i = this.mDialIndex;
        setColor(dialIndex, SpenPaletteDefine.getFromType(colorInfo.getColorUIInfo()), colorInfo.getContentColor());
        Log.i(TAG, "dialIndex=" + i + " -> " + this.mDialIndex + ", from=" + this.mFrom);
        if (this.mDialIndex != i) {
            Log.i(TAG, "Nothing to work");
        }
        updateLayout(i, this.mDialIndex);
        notifyColorChanged();
    }

    private final void updateLayout(int oldDialIndex, int newDialIndex) {
        if (this.mDialLayout == null || oldDialIndex == newDialIndex) {
            return;
        }
        setDialSelected(oldDialIndex, false, false);
        setDialSelected(newDialIndex, true, true);
    }

    private final void setDialSelected(int dialIndex, boolean selected, boolean selectItemAnimation) {
        if (dialIndex > -1 && this.mDividerIndexes.indexOf(Integer.valueOf(dialIndex)) > -1) {
            Log.i(TAG, "dialIndex=" + dialIndex + " is divider. so return");
        }
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.mDialLayout;
        if (spenSettingQTColorDialLayout != null) {
            SpenSettingQTColorDialLayout.ButtonType buttonType = dialIndex > -1 ? SpenSettingQTColorDialLayout.ButtonType.DIALED : SpenSettingQTColorDialLayout.ButtonType.FIXED;
            boolean z = false;
            if (dialIndex <= -1) {
                dialIndex = 0;
            }
            if (selected && selectItemAnimation) {
                z = true;
            }
            spenSettingQTColorDialLayout.setSelected(buttonType, dialIndex, selected, z);
        }
    }

    private final void updateLayout(boolean moveToCurrent, boolean animation) {
        applyPickerColor();
        int totalDialItemCount = getTotalDialItemCount();
        int i = -1;
        while (i < totalDialItemCount) {
            setDialSelected(i, i == this.mDialIndex, false);
            i++;
        }
    }

    private final int getTotalDialItemCount() {
        return this.mPaletteItems.size() + (this.mHasRecentColor ? 10 : 0);
    }

    private final void applyPickerColor() {
        if (this.mDialIndex > -1) {
            return;
        }
        SpenSettingQTColorDialLayout spenSettingQTColorDialLayout = this.mDialLayout;
        Drawable fixedSelectorDrawable = spenSettingQTColorDialLayout != null ? spenSettingQTColorDialLayout.getFixedSelectorDrawable(0) : null;
        LayerDrawable layerDrawable = fixedSelectorDrawable instanceof LayerDrawable ? (LayerDrawable) fixedSelectorDrawable : null;
        Drawable drawableFindDrawableByLayerId = layerDrawable != null ? layerDrawable.findDrawableByLayerId(C8357R.id.selector_color) : null;
        GradientDrawable gradientDrawable = drawableFindDrawableByLayerId instanceof GradientDrawable ? (GradientDrawable) drawableFindDrawableByLayerId : null;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(getVisibleColor(this.mOtherColor));
        }
    }

    private final int getVisibleColor(float[] contentColor) {
        int iHSVToColor = SpenSettingUtil.HSVToColor(contentColor);
        return this.mColorThemeUtil.getColorTheme() == 1 ? this.mColorThemeUtil.getColor(iHSVToColor) : iHSVToColor;
    }
}
