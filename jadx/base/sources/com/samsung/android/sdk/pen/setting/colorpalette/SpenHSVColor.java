package com.samsung.android.sdk.pen.setting.colorpalette;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenHSVColor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u001e\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "", "hsvColor", "", "<init>", "([F)V", "color", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;)V", "mHsvColor", "setColor", "", "hsv", "", "hue", "", "saturation", "value", "getColor", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenHSVColor {
    private final float[] mHsvColor;

    public SpenHSVColor(float[] fArr) {
        this.mHsvColor = new float[]{0.0f, 0.0f, 0.0f};
        if (fArr != null) {
            setColor(fArr);
        }
    }

    public SpenHSVColor(SpenHSVColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.mHsvColor = fArr;
        color.getColor(fArr);
    }

    public final boolean setColor(float[] hsv) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        if (hsv.length < 3) {
            return false;
        }
        System.arraycopy(hsv, 0, this.mHsvColor, 0, 3);
        return true;
    }

    public final void setColor(float hue, float saturation, float value) {
        float[] fArr = this.mHsvColor;
        fArr[0] = hue;
        fArr[1] = saturation;
        fArr[2] = value;
    }

    public final boolean getColor(float[] hsv) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        if (hsv.length < 3) {
            return false;
        }
        System.arraycopy(this.mHsvColor, 0, hsv, 0, 3);
        return true;
    }
}
