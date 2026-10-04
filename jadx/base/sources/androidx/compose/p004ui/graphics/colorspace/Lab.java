package androidx.compose.p004ui.graphics.colorspace;

import androidx.compose.p004ui.graphics.ColorKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;

/* JADX INFO: compiled from: Lab.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, m1599d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics", "toZ", "toZ$ui_graphics", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class Lab extends ColorSpace {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: A */
    private static final float f94A = 0.008856452f;

    /* JADX INFO: renamed from: B */
    private static final float f95B = 7.787037f;

    /* JADX INFO: renamed from: C */
    private static final float f96C = 0.13793103f;

    /* JADX INFO: renamed from: D */
    private static final float f97D = 0.20689656f;

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    public Lab(String str, int i) {
        super(str, ColorModel.INSTANCE.m8586getLabxdoWZVw(), i, null);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        float f = v[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        v[0] = f;
        float f2 = v[1];
        if (f2 < -128.0f) {
            f2 = -128.0f;
        }
        if (f2 > 128.0f) {
            f2 = 128.0f;
        }
        v[1] = f2;
        float f3 = v[2];
        float f4 = f3 >= -128.0f ? f3 : -128.0f;
        float f5 = f4 <= 128.0f ? f4 : 128.0f;
        v[2] = f5;
        float f6 = (f + 16.0f) / 116.0f;
        float f7 = (f2 * 0.002f) + f6;
        float f8 = f6 - (f5 * 0.005f);
        float f9 = f7 > f97D ? f7 * f7 * f7 : (f7 - f96C) * 0.12841855f;
        float f10 = f6 > f97D ? f6 * f6 * f6 : (f6 - f96C) * 0.12841855f;
        float f11 = f8 > f97D ? f8 * f8 * f8 : (f8 - f96C) * 0.12841855f;
        v[0] = f9 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        v[1] = f10 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        v[2] = f11 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
        return v;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics(float v0, float v1, float v2) {
        if (v0 < 0.0f) {
            v0 = 0.0f;
        }
        if (v0 > 100.0f) {
            v0 = 100.0f;
        }
        if (v1 < -128.0f) {
            v1 = -128.0f;
        }
        if (v1 > 128.0f) {
            v1 = 128.0f;
        }
        float f = (v0 + 16.0f) / 116.0f;
        float f2 = (v1 * 0.002f) + f;
        float f3 = f2 > f97D ? f2 * f2 * f2 : (f2 - f96C) * 0.12841855f;
        return (((long) Float.floatToRawIntBits((f > f97D ? f * f * f : (f - f96C) * 0.12841855f) * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1])) & 4294967295L) | (((long) Float.floatToRawIntBits(f3 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0])) << 32);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics(float v0, float v1, float v2) {
        if (v0 < 0.0f) {
            v0 = 0.0f;
        }
        if (v0 > 100.0f) {
            v0 = 100.0f;
        }
        if (v2 < -128.0f) {
            v2 = -128.0f;
        }
        if (v2 > 128.0f) {
            v2 = 128.0f;
        }
        float f = ((v0 + 16.0f) / 116.0f) - (v2 * 0.005f);
        return (f > f97D ? f * f * f : 0.12841855f * (f - f96C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics */
    public long mo8590xyzaToColorJlNiLsg$ui_graphics(float x, float y, float z, float a2, ColorSpace colorSpace) {
        float f = x / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        float f2 = y / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        float f3 = z / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
        float fCbrt = f > f94A ? (float) Math.cbrt(f) : (f * f95B) + f96C;
        float fCbrt2 = f2 > f94A ? (float) Math.cbrt(f2) : (f2 * f95B) + f96C;
        float f4 = (116.0f * fCbrt2) - 16.0f;
        float f5 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f3 > f94A ? (float) Math.cbrt(f3) : (f3 * f95B) + f96C)) * 200.0f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 > 100.0f) {
            f4 = 100.0f;
        }
        if (f5 < -128.0f) {
            f5 = -128.0f;
        }
        if (f5 > 128.0f) {
            f5 = 128.0f;
        }
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        return ColorKt.Color(f4, f5, fCbrt3 <= 128.0f ? fCbrt3 : 128.0f, a2, colorSpace);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        float f = v[0] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        float f2 = v[1] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        float f3 = v[2] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
        float fCbrt = f > f94A ? (float) Math.cbrt(f) : (f * f95B) + f96C;
        float fCbrt2 = f2 > f94A ? (float) Math.cbrt(f2) : (f2 * f95B) + f96C;
        float f4 = (116.0f * fCbrt2) - 16.0f;
        float f5 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f3 > f94A ? (float) Math.cbrt(f3) : (f3 * f95B) + f96C)) * 200.0f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 > 100.0f) {
            f4 = 100.0f;
        }
        v[0] = f4;
        if (f5 < -128.0f) {
            f5 = -128.0f;
        }
        if (f5 > 128.0f) {
            f5 = 128.0f;
        }
        v[1] = f5;
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        v[2] = fCbrt3 <= 128.0f ? fCbrt3 : 128.0f;
        return v;
    }
}
