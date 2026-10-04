package androidx.compose.p004ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: AndroidBlendMode.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\n*\u00020\u0002H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u0002*\u00020\nH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "ui-graphics"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidBlendMode_androidKt {

    /* JADX INFO: compiled from: AndroidBlendMode.android.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlendMode.values().length];
            try {
                iArr[BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m7994isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8088getSrcOver0nO6VwU()) || m7996toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m7996toPorterDuffModes9anfk8(int i) {
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8061getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8084getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8067getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8088getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8071getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8086getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8069getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8087getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8070getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8085getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8068getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8089getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8080getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8082getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8079getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8065getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8075getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8077getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m7995toAndroidBlendModes9anfk8(int i) {
        return BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8061getClear0nO6VwU()) ? BlendMode.CLEAR : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8084getSrc0nO6VwU()) ? BlendMode.SRC : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8067getDst0nO6VwU()) ? BlendMode.DST : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8088getSrcOver0nO6VwU()) ? BlendMode.SRC_OVER : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8071getDstOver0nO6VwU()) ? BlendMode.DST_OVER : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8086getSrcIn0nO6VwU()) ? BlendMode.SRC_IN : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8069getDstIn0nO6VwU()) ? BlendMode.DST_IN : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8087getSrcOut0nO6VwU()) ? BlendMode.SRC_OUT : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8070getDstOut0nO6VwU()) ? BlendMode.DST_OUT : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8085getSrcAtop0nO6VwU()) ? BlendMode.SRC_ATOP : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8068getDstAtop0nO6VwU()) ? BlendMode.DST_ATOP : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8089getXor0nO6VwU()) ? BlendMode.XOR : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8080getPlus0nO6VwU()) ? BlendMode.PLUS : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8077getModulate0nO6VwU()) ? BlendMode.MODULATE : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8082getScreen0nO6VwU()) ? BlendMode.SCREEN : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8079getOverlay0nO6VwU()) ? BlendMode.OVERLAY : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8065getDarken0nO6VwU()) ? BlendMode.DARKEN : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8075getLighten0nO6VwU()) ? BlendMode.LIGHTEN : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8064getColorDodge0nO6VwU()) ? BlendMode.COLOR_DODGE : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8063getColorBurn0nO6VwU()) ? BlendMode.COLOR_BURN : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8073getHardlight0nO6VwU()) ? BlendMode.HARD_LIGHT : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8083getSoftlight0nO6VwU()) ? BlendMode.SOFT_LIGHT : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8066getDifference0nO6VwU()) ? BlendMode.DIFFERENCE : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8072getExclusion0nO6VwU()) ? BlendMode.EXCLUSION : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8078getMultiply0nO6VwU()) ? BlendMode.MULTIPLY : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8074getHue0nO6VwU()) ? BlendMode.HUE : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8081getSaturation0nO6VwU()) ? BlendMode.SATURATION : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8062getColor0nO6VwU()) ? BlendMode.COLOR : BlendMode.m8057equalsimpl0(i, BlendMode.INSTANCE.m8076getLuminosity0nO6VwU()) ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.INSTANCE.m8061getClear0nO6VwU();
            case 2:
                return BlendMode.INSTANCE.m8084getSrc0nO6VwU();
            case 3:
                return BlendMode.INSTANCE.m8067getDst0nO6VwU();
            case 4:
                return BlendMode.INSTANCE.m8088getSrcOver0nO6VwU();
            case 5:
                return BlendMode.INSTANCE.m8071getDstOver0nO6VwU();
            case 6:
                return BlendMode.INSTANCE.m8086getSrcIn0nO6VwU();
            case 7:
                return BlendMode.INSTANCE.m8069getDstIn0nO6VwU();
            case 8:
                return BlendMode.INSTANCE.m8087getSrcOut0nO6VwU();
            case 9:
                return BlendMode.INSTANCE.m8070getDstOut0nO6VwU();
            case 10:
                return BlendMode.INSTANCE.m8085getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.INSTANCE.m8068getDstAtop0nO6VwU();
            case 12:
                return BlendMode.INSTANCE.m8089getXor0nO6VwU();
            case 13:
                return BlendMode.INSTANCE.m8080getPlus0nO6VwU();
            case 14:
                return BlendMode.INSTANCE.m8077getModulate0nO6VwU();
            case 15:
                return BlendMode.INSTANCE.m8082getScreen0nO6VwU();
            case 16:
                return BlendMode.INSTANCE.m8079getOverlay0nO6VwU();
            case 17:
                return BlendMode.INSTANCE.m8065getDarken0nO6VwU();
            case 18:
                return BlendMode.INSTANCE.m8075getLighten0nO6VwU();
            case 19:
                return BlendMode.INSTANCE.m8064getColorDodge0nO6VwU();
            case 20:
                return BlendMode.INSTANCE.m8063getColorBurn0nO6VwU();
            case 21:
                return BlendMode.INSTANCE.m8073getHardlight0nO6VwU();
            case 22:
                return BlendMode.INSTANCE.m8083getSoftlight0nO6VwU();
            case 23:
                return BlendMode.INSTANCE.m8066getDifference0nO6VwU();
            case 24:
                return BlendMode.INSTANCE.m8072getExclusion0nO6VwU();
            case 25:
                return BlendMode.INSTANCE.m8078getMultiply0nO6VwU();
            case 26:
                return BlendMode.INSTANCE.m8074getHue0nO6VwU();
            case 27:
                return BlendMode.INSTANCE.m8081getSaturation0nO6VwU();
            case 28:
                return BlendMode.INSTANCE.m8062getColor0nO6VwU();
            case 29:
                return BlendMode.INSTANCE.m8076getLuminosity0nO6VwU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
