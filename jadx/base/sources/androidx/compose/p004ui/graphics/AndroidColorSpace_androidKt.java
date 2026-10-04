package androidx.compose.p004ui.graphics;

import android.graphics.ColorSpace;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidColorSpace.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007¨\u0006\u0004"}, m1599d2 = {"toAndroidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "toComposeColorSpace", "ui-graphics"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidColorSpace_androidKt {
    public static final ColorSpace toAndroidColorSpace(androidx.compose.p004ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpaceVerificationHelper colorSpaceVerificationHelper = ColorSpaceVerificationHelper.INSTANCE;
        return ColorSpaceVerificationHelper.androidColorSpace(colorSpace);
    }

    public static final androidx.compose.p004ui.graphics.colorspace.ColorSpace toComposeColorSpace(ColorSpace colorSpace) {
        ColorSpaceVerificationHelper colorSpaceVerificationHelper = ColorSpaceVerificationHelper.INSTANCE;
        return ColorSpaceVerificationHelper.composeColorSpace(colorSpace);
    }
}
