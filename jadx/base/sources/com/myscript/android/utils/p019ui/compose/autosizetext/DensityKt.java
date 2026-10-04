package com.myscript.android.utils.p019ui.compose.autosizetext;

import androidx.compose.p004ui.geometry.InlineClassHelperKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpKt;
import androidx.compose.p004ui.unit.DpOffset;
import androidx.compose.p004ui.unit.DpSize;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: density.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b)\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0013\u0010\u0011\u001a\u00020\u0001*\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0014\u001a\u00020\b*\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\f*\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\f*\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u0019\u001a\u0011\u0010\u001c\u001a\u00020\u001d*\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010 \u001a\u00020!*\u00020\u0004¢\u0006\u0004\b\"\u0010\u001f\u001a\u0019\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010$\u001a\u00020\u0001¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010'\u001a\u00020\b*\u00020\u00022\u0006\u0010$\u001a\u00020\u0001¢\u0006\u0004\b(\u0010&\u001a\u0019\u0010)\u001a\u00020\f*\u00020\u00022\u0006\u0010$\u001a\u00020\u0001¢\u0006\u0004\b*\u0010+\u001a\u0019\u0010,\u001a\u00020\f*\u00020\u00022\u0006\u0010$\u001a\u00020\u0001¢\u0006\u0004\b-\u0010+\u001a\u0013\u0010.\u001a\u00020\u0004*\u00020\u0001H\u0007¢\u0006\u0004\b/\u00100\u001a\u0013\u0010\u0014\u001a\u00020\b*\u00020\u0001H\u0007¢\u0006\u0004\b1\u00100\u001a\u0013\u0010\u0017\u001a\u00020\f*\u00020\u0001H\u0007¢\u0006\u0004\b2\u00103\u001a\u0013\u0010\u001a\u001a\u00020\f*\u00020\u0001H\u0007¢\u0006\u0004\b4\u00103\u001a\u0017\u00105\u001a\u00020\u0004*\u00020\u00022\u0006\u00106\u001a\u00020\b¢\u0006\u0002\u0010\n\u001a\u0017\u00107\u001a\u00020\u0001*\u00020\u00022\u0006\u00106\u001a\u00020\b¢\u0006\u0002\u0010\u0006\u001a\u0011\u0010.\u001a\u00020\u0004*\u00020\bH\u0007¢\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0011\u001a\u00020\u0001*\u00020\bH\u0007¢\u0006\u0002\u0010\u0013\u001a\n\u0010\u0017\u001a\u00020\f*\u00020\b\u001a\n\u0010\u001a\u001a\u00020\f*\u00020\b\u001a\u000f\u00108\u001a\u000209*\u00020\b¢\u0006\u0002\u0010\u001f\u001a\u000f\u0010:\u001a\u00020;*\u00020\b¢\u0006\u0002\u0010\u001f\u001a\u0017\u0010<\u001a\u00020\u0004*\u00020\u00022\u0006\u00106\u001a\u00020\f¢\u0006\u0002\u0010=\u001a\u0017\u0010>\u001a\u00020\u0001*\u00020\u00022\u0006\u00106\u001a\u00020\f¢\u0006\u0002\u0010?\u001a\u0011\u0010.\u001a\u00020\u0004*\u00020\fH\u0007¢\u0006\u0002\u0010@\u001a\u0011\u0010\u0011\u001a\u00020\u0001*\u00020\fH\u0007¢\u0006\u0002\u0010A\u001a\n\u0010\u0014\u001a\u00020\b*\u00020\f\u001a\u000f\u0010B\u001a\u00020C*\u00020\f¢\u0006\u0002\u0010D\u001a\u000f\u0010E\u001a\u00020F*\u00020\f¢\u0006\u0002\u0010D\u001a\u0019\u0010G\u001a\u00020C*\u00020\u00022\u0006\u0010H\u001a\u00020\u001d¢\u0006\u0004\bI\u0010J\u001a\u0019\u0010K\u001a\u00020C*\u00020\u00022\u0006\u0010H\u001a\u00020\u001d¢\u0006\u0004\bL\u0010J\u001a\u0019\u0010M\u001a\u000209*\u00020\u00022\u0006\u0010H\u001a\u00020\u001d¢\u0006\u0004\bN\u0010J\u001a\u0013\u0010O\u001a\u00020C*\u00020\u001dH\u0007¢\u0006\u0004\bP\u0010Q\u001a\u0013\u0010R\u001a\u00020C*\u00020\u001dH\u0007¢\u0006\u0004\bS\u0010Q\u001a\u0013\u0010T\u001a\u000209*\u00020\u001dH\u0007¢\u0006\u0004\bU\u0010Q\u001a\u0011\u0010V\u001a\u00020W*\u00020\u001d¢\u0006\u0004\bX\u0010Y\u001a\u0019\u0010Z\u001a\u00020\u001d*\u00020\u00022\u0006\u0010[\u001a\u000209¢\u0006\u0004\b\\\u0010J\u001a\u0013\u0010]\u001a\u00020\u001d*\u000209H\u0007¢\u0006\u0004\b^\u0010Q\u001a\u0011\u0010O\u001a\u00020C*\u000209¢\u0006\u0004\b_\u0010`\u001a\u0011\u0010V\u001a\u00020W*\u000209¢\u0006\u0004\ba\u0010Y\u001a\u0019\u0010b\u001a\u00020\u001d*\u00020\u00022\u0006\u0010c\u001a\u00020C¢\u0006\u0004\bd\u0010J\u001a\u0013\u0010]\u001a\u00020\u001d*\u00020CH\u0007¢\u0006\u0004\be\u0010Q\u001a\u0013\u0010T\u001a\u000209*\u00020CH\u0007¢\u0006\u0004\bf\u0010Q\u001a\u0011\u0010V\u001a\u00020W*\u00020C¢\u0006\u0004\bg\u0010Y\u001a\u0019\u0010h\u001a\u00020F*\u00020\u00022\u0006\u0010i\u001a\u00020!¢\u0006\u0004\bj\u0010J\u001a\u0019\u0010k\u001a\u00020F*\u00020\u00022\u0006\u0010i\u001a\u00020!¢\u0006\u0004\bl\u0010J\u001a\u0019\u0010m\u001a\u00020;*\u00020\u00022\u0006\u0010i\u001a\u00020!¢\u0006\u0004\bn\u0010J\u001a\u0013\u0010o\u001a\u00020F*\u00020!H\u0007¢\u0006\u0004\bp\u0010Q\u001a\u0013\u0010q\u001a\u00020F*\u00020!H\u0007¢\u0006\u0004\br\u0010Q\u001a\u0013\u0010s\u001a\u00020;*\u00020!H\u0007¢\u0006\u0004\bt\u0010Q\u001a\u0019\u0010u\u001a\u00020!*\u00020\u00022\u0006\u0010v\u001a\u00020;¢\u0006\u0004\bw\u0010J\u001a\u0013\u0010x\u001a\u00020!*\u00020;H\u0007¢\u0006\u0004\by\u0010Q\u001a\u0011\u0010o\u001a\u00020F*\u00020;¢\u0006\u0004\bz\u0010`\u001a\u0019\u0010{\u001a\u00020!*\u00020\u00022\u0006\u0010|\u001a\u00020F¢\u0006\u0004\b}\u0010J\u001a\u0013\u0010x\u001a\u00020!*\u00020FH\u0007¢\u0006\u0004\b~\u0010Q\u001a\u0011\u0010s\u001a\u00020;*\u00020F¢\u0006\u0004\b\u007f\u0010`¨\u0006\u0080\u0001"}, m1599d2 = {"dpToSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Density;", "dp", "Landroidx/compose/ui/unit/Dp;", "dpToSp-3ABfNKs", "(Landroidx/compose/ui/unit/Density;F)J", "dpToFloatPx", "", "dpToFloatPx-3ABfNKs", "(Landroidx/compose/ui/unit/Density;F)F", "dpToIntPx", "", "dpToIntPx-3ABfNKs", "(Landroidx/compose/ui/unit/Density;F)I", "dpRoundToPx", "dpRoundToPx-3ABfNKs", "toSp", "toSp-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)J", "toFloatPx", "toFloatPx-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)F", "toIntPx", "toIntPx-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)I", "roundToPx", "roundToPx-8Feqmps", "toRecDpSize", "Landroidx/compose/ui/unit/DpSize;", "toRecDpSize-0680j_4", "(F)J", "toRecDpOffset", "Landroidx/compose/ui/unit/DpOffset;", "toRecDpOffset-0680j_4", "spToDp", "sp", "spToDp-mpE4wyQ", "(Landroidx/compose/ui/unit/Density;J)F", "spToFloatPx", "spToFloatPx-mpE4wyQ", "spToIntPx", "spToIntPx-mpE4wyQ", "(Landroidx/compose/ui/unit/Density;J)I", "spRoundToPx", "spRoundToPx-mpE4wyQ", "toDp", "toDp-o2QH7mI", "(JLandroidx/compose/runtime/Composer;I)F", "toFloatPx-o2QH7mI", "toIntPx-o2QH7mI", "(JLandroidx/compose/runtime/Composer;I)I", "roundToPx-o2QH7mI", "floatPxToDp", "px", "floatPxToSp", "toRecSize", "Landroidx/compose/ui/geometry/Size;", "toRecOffset", "Landroidx/compose/ui/geometry/Offset;", "intPxToDp", "(Landroidx/compose/ui/unit/Density;I)F", "intPxToSp", "(Landroidx/compose/ui/unit/Density;I)J", "(ILandroidx/compose/runtime/Composer;I)F", "(ILandroidx/compose/runtime/Composer;I)J", "toRecIntSize", "Landroidx/compose/ui/unit/IntSize;", "(I)J", "toRecIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "dpSizeToIntSize", "dpSize", "dpSizeToIntSize-6HolHcs", "(Landroidx/compose/ui/unit/Density;J)J", "dpSizeRoundToIntSize", "dpSizeRoundToIntSize-6HolHcs", "dpSizeToSize", "dpSizeToSize-6HolHcs", "toIntSize", "toIntSize-qzXmJYc", "(JLandroidx/compose/runtime/Composer;I)J", "roundToIntSize", "roundToIntSize-qzXmJYc", "toSize", "toSize-qzXmJYc", "isSpaced", "", "isSpaced-EaSLcWc", "(J)Z", "sizeToDpSize", "size", "sizeToDpSize-d16Qtg0", "toDpSize", "toDpSize-Pq9zytI", "toIntSize-uvyYCjk", "(J)J", "isSpaced-uvyYCjk", "intSizeToDpSize", "intSize", "intSizeToDpSize-O0kMr_c", "toDpSize-aZF9jCo", "toSize-aZF9jCo", "isSpaced-ozmzZPI", "dpOffsetToIntOffset", "dpOffset", "dpOffsetToIntOffset-BkVx2pU", "dpOffsetRoundToIntOffset", "dpOffsetRoundToIntOffset-BkVx2pU", "dpOffsetToOffset", "dpOffsetToOffset-BkVx2pU", "toIntOffset", "toIntOffset-rOJDEFc", "roundToIntOffset", "roundToIntOffset-rOJDEFc", "toOffset", "toOffset-rOJDEFc", "offsetToDpOffset", TypedValues.CycleType.S_WAVE_OFFSET, "offsetToDpOffset-Uv8p0NA", "toDpOffset", "toDpOffset-9KIMszo", "toIntOffset-k-4lQ0M", "intOffsetToDpOffset", "intOffset", "intOffsetToDpOffset-I_oMVgE", "toDpOffset-f8xVGno", "toOffset--gyyYBs", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DensityKt {
    /* JADX INFO: renamed from: isSpaced-ozmzZPI, reason: not valid java name */
    public static final boolean m12544isSpacedozmzZPI(long j) {
        return ((int) (j >> 32)) > 0 && ((int) (j & 4294967295L)) > 0;
    }

    public static final float toFloatPx(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toSp-8Feqmps, reason: not valid java name */
    public static final long m12575toSp8Feqmps(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1765292752, "C(toSp)32@1140L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1765292752, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toSp (density.kt:32)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12540dpToSp3ABfNKs = m12540dpToSp3ABfNKs((Density) objConsume, f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12540dpToSp3ABfNKs;
    }

    /* JADX INFO: renamed from: toFloatPx-8Feqmps, reason: not valid java name */
    public static final float m12561toFloatPx8Feqmps(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -306898264, "C(toFloatPx)35@1208L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-306898264, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toFloatPx (density.kt:35)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM12538dpToFloatPx3ABfNKs = m12538dpToFloatPx3ABfNKs((Density) objConsume, f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM12538dpToFloatPx3ABfNKs;
    }

    /* JADX INFO: renamed from: toIntPx-8Feqmps, reason: not valid java name */
    public static final int m12565toIntPx8Feqmps(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1020692536, "C(toIntPx)38@1279L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1020692536, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toIntPx (density.kt:38)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iM12539dpToIntPx3ABfNKs = m12539dpToIntPx3ABfNKs((Density) objConsume, f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM12539dpToIntPx3ABfNKs;
    }

    /* JADX INFO: renamed from: roundToPx-8Feqmps, reason: not valid java name */
    public static final int m12549roundToPx8Feqmps(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 815538493, "C(roundToPx)41@1350L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(815538493, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.roundToPx (density.kt:41)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iM12534dpRoundToPx3ABfNKs = m12534dpRoundToPx3ABfNKs((Density) objConsume, f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM12534dpRoundToPx3ABfNKs;
    }

    /* JADX INFO: renamed from: toDp-o2QH7mI, reason: not valid java name */
    public static final float m12556toDpo2QH7mI(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -750983029, "C(toDp)58@1951L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-750983029, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toDp (density.kt:58)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM12553spToDpmpE4wyQ = m12553spToDpmpE4wyQ((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM12553spToDpmpE4wyQ;
    }

    /* JADX INFO: renamed from: toFloatPx-o2QH7mI, reason: not valid java name */
    public static final float m12562toFloatPxo2QH7mI(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -561463059, "C(toFloatPx)61@2025L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561463059, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toFloatPx (density.kt:61)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM12554spToFloatPxmpE4wyQ = m12554spToFloatPxmpE4wyQ((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM12554spToFloatPxmpE4wyQ;
    }

    /* JADX INFO: renamed from: toIntPx-o2QH7mI, reason: not valid java name */
    public static final int m12566toIntPxo2QH7mI(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1788016499, "C(toIntPx)64@2102L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1788016499, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toIntPx (density.kt:64)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iM12555spToIntPxmpE4wyQ = m12555spToIntPxmpE4wyQ((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM12555spToIntPxmpE4wyQ;
    }

    /* JADX INFO: renamed from: roundToPx-o2QH7mI, reason: not valid java name */
    public static final int m12550roundToPxo2QH7mI(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2143382334, "C(roundToPx)67@2179L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2143382334, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.roundToPx (density.kt:67)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iM12552spRoundToPxmpE4wyQ = m12552spRoundToPxmpE4wyQ((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM12552spRoundToPxmpE4wyQ;
    }

    public static final float floatPxToDp(Density density, float f) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return Math.abs(f) <= Float.MAX_VALUE ? density.mo2187toDpu2uoSUM(f) : C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM();
    }

    public static final long floatPxToSp(Density density, float f) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return Math.abs(f) <= Float.MAX_VALUE ? density.mo2194toSpkPz2Gy4(f) : TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
    }

    public static final float toDp(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 961633786, "C(toDp)76@2440L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(961633786, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toDp (density.kt:76)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fFloatPxToDp = floatPxToDp((Density) objConsume, f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fFloatPxToDp;
    }

    public static final long toSp(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1771659548, "C(toSp)79@2511L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1771659548, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toSp (density.kt:79)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jFloatPxToSp = floatPxToSp((Density) objConsume, f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jFloatPxToSp;
    }

    public static final int toIntPx(float f) {
        if (Math.abs(f) <= Float.MAX_VALUE) {
            return (int) f;
        }
        return 0;
    }

    public static final int roundToPx(float f) {
        if (Math.abs(f) <= Float.MAX_VALUE) {
            return MathKt.roundToInt(f);
        }
        return 0;
    }

    public static final long toRecSize(float f) {
        if (Math.abs(f) > Float.MAX_VALUE) {
            return Size.INSTANCE.m7980getUnspecifiedNHjbRc();
        }
        return Size.m7963constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    public static final long toRecOffset(float f) {
        if (Math.abs(f) > Float.MAX_VALUE) {
            return Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        }
        return Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    public static final float intPxToDp(Density density, int i) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return density.mo2188toDpu2uoSUM(i);
    }

    public static final long intPxToSp(Density density, int i) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return density.mo2195toSpkPz2Gy4(i);
    }

    public static final float toDp(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 359830029, "C(toDp)96@2957L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(359830029, i2, -1, "com.myscript.android.utils.ui.compose.autosizetext.toDp (density.kt:96)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fIntPxToDp = intPxToDp((Density) objConsume, i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fIntPxToDp;
    }

    public static final long toSp(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -957925193, "C(toSp)99@3024L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-957925193, i2, -1, "com.myscript.android.utils.ui.compose.autosizetext.toSp (density.kt:99)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jIntPxToSp = intPxToSp((Density) objConsume, i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jIntPxToSp;
    }

    /* JADX INFO: renamed from: dpSizeToIntSize-6HolHcs, reason: not valid java name */
    public static final long m12536dpSizeToIntSize6HolHcs(Density dpSizeToIntSize, long j) {
        Intrinsics.checkNotNullParameter(dpSizeToIntSize, "$this$dpSizeToIntSize");
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return IntSize.m11183constructorimpl((((long) ((int) dpSizeToIntSize.mo2191toPx0680j_4(DpSize.m11115getWidthD9Ej5fM(j)))) << 32) | (((long) ((int) dpSizeToIntSize.mo2191toPx0680j_4(DpSize.m11113getHeightD9Ej5fM(j)))) & 4294967295L));
        }
        return IntSize.INSTANCE.m11193getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: dpSizeRoundToIntSize-6HolHcs, reason: not valid java name */
    public static final long m12535dpSizeRoundToIntSize6HolHcs(Density dpSizeRoundToIntSize, long j) {
        Intrinsics.checkNotNullParameter(dpSizeRoundToIntSize, "$this$dpSizeRoundToIntSize");
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return IntSize.m11183constructorimpl((((long) dpSizeRoundToIntSize.mo2185roundToPx0680j_4(DpSize.m11115getWidthD9Ej5fM(j))) << 32) | (((long) dpSizeRoundToIntSize.mo2185roundToPx0680j_4(DpSize.m11113getHeightD9Ej5fM(j))) & 4294967295L));
        }
        return IntSize.INSTANCE.m11193getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: dpSizeToSize-6HolHcs, reason: not valid java name */
    public static final long m12537dpSizeToSize6HolHcs(Density dpSizeToSize, long j) {
        Intrinsics.checkNotNullParameter(dpSizeToSize, "$this$dpSizeToSize");
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            float fMo2191toPx0680j_4 = dpSizeToSize.mo2191toPx0680j_4(DpSize.m11115getWidthD9Ej5fM(j));
            float fMo2191toPx0680j_42 = dpSizeToSize.mo2191toPx0680j_4(DpSize.m11113getHeightD9Ej5fM(j));
            return Size.m7963constructorimpl((((long) Float.floatToRawIntBits(fMo2191toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo2191toPx0680j_42)) & 4294967295L));
        }
        return Size.INSTANCE.m7980getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: toIntSize-qzXmJYc, reason: not valid java name */
    public static final long m12567toIntSizeqzXmJYc(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -469610655, "C(toIntSize)122@3713L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-469610655, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toIntSize (density.kt:122)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12536dpSizeToIntSize6HolHcs = m12536dpSizeToIntSize6HolHcs((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12536dpSizeToIntSize6HolHcs;
    }

    /* JADX INFO: renamed from: roundToIntSize-qzXmJYc, reason: not valid java name */
    public static final long m12548roundToIntSizeqzXmJYc(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1700153401, "C(roundToIntSize)125@3799L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1700153401, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.roundToIntSize (density.kt:125)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12535dpSizeRoundToIntSize6HolHcs = m12535dpSizeRoundToIntSize6HolHcs((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12535dpSizeRoundToIntSize6HolHcs;
    }

    /* JADX INFO: renamed from: toSize-qzXmJYc, reason: not valid java name */
    public static final long m12574toSizeqzXmJYc(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1918657085, "C(toSize)128@3882L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1918657085, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toSize (density.kt:128)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12537dpSizeToSize6HolHcs = m12537dpSizeToSize6HolHcs((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12537dpSizeToSize6HolHcs;
    }

    /* JADX INFO: renamed from: isSpaced-EaSLcWc, reason: not valid java name */
    public static final boolean m12543isSpacedEaSLcWc(long j) {
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            float f = 0;
            if (C1486Dp.m11016compareTo0680j_4(DpSize.m11115getWidthD9Ej5fM(j), C1486Dp.m11017constructorimpl(f)) > 0 && C1486Dp.m11016compareTo0680j_4(DpSize.m11113getHeightD9Ej5fM(j), C1486Dp.m11017constructorimpl(f)) > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: toDpSize-Pq9zytI, reason: not valid java name */
    public static final long m12559toDpSizePq9zytI(long j, Composer composer, int i) {
        long jM11124getUnspecifiedMYxV2XQ;
        ComposerKt.sourceInformationMarkerStart(composer, 983120441, "C(toDpSize):density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(983120441, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toDpSize (density.kt:140)");
        }
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            composer.startReplaceGroup(-114058140);
            composer.endReplaceGroup();
            jM11124getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m11124getUnspecifiedMYxV2XQ();
        } else {
            composer.startReplaceGroup(-114059253);
            ComposerKt.sourceInformation(composer, "140@4197L7");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM11124getUnspecifiedMYxV2XQ = m12551sizeToDpSized16Qtg0((Density) objConsume, j);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM11124getUnspecifiedMYxV2XQ;
    }

    /* JADX INFO: renamed from: intSizeToDpSize-O0kMr_c, reason: not valid java name */
    public static final long m12542intSizeToDpSizeO0kMr_c(Density intSizeToDpSize, long j) {
        Intrinsics.checkNotNullParameter(intSizeToDpSize, "$this$intSizeToDpSize");
        return DpKt.m11039DpSizeYgX7TsA(intSizeToDpSize.mo2188toDpu2uoSUM((int) (j >> 32)), intSizeToDpSize.mo2188toDpu2uoSUM((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: toDpSize-aZF9jCo, reason: not valid java name */
    public static final long m12560toDpSizeaZF9jCo(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -877678676, "C(toDpSize)154@4587L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-877678676, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toDpSize (density.kt:154)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12542intSizeToDpSizeO0kMr_c = m12542intSizeToDpSizeO0kMr_c((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12542intSizeToDpSizeO0kMr_c;
    }

    /* JADX INFO: renamed from: toSize-aZF9jCo, reason: not valid java name */
    public static final long m12573toSizeaZF9jCo(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 409800708, "C(toSize):density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(409800708, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toSize (density.kt:157)");
        }
        long jM7963constructorimpl = Size.m7963constructorimpl((((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (j >> 32)) << 32));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM7963constructorimpl;
    }

    /* JADX INFO: renamed from: dpOffsetToIntOffset-BkVx2pU, reason: not valid java name */
    public static final long m12532dpOffsetToIntOffsetBkVx2pU(Density dpOffsetToIntOffset, long j) {
        Intrinsics.checkNotNullParameter(dpOffsetToIntOffset, "$this$dpOffsetToIntOffset");
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return IntOffset.m11139constructorimpl((((long) ((int) dpOffsetToIntOffset.mo2191toPx0680j_4(DpOffset.m11078getXD9Ej5fM(j)))) << 32) | (((long) ((int) dpOffsetToIntOffset.mo2191toPx0680j_4(DpOffset.m11080getYD9Ej5fM(j)))) & 4294967295L));
        }
        return IntOffset.INSTANCE.m11156getZeronOccac();
    }

    /* JADX INFO: renamed from: dpOffsetRoundToIntOffset-BkVx2pU, reason: not valid java name */
    public static final long m12531dpOffsetRoundToIntOffsetBkVx2pU(Density dpOffsetRoundToIntOffset, long j) {
        Intrinsics.checkNotNullParameter(dpOffsetRoundToIntOffset, "$this$dpOffsetRoundToIntOffset");
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return IntOffset.m11139constructorimpl((((long) dpOffsetRoundToIntOffset.mo2185roundToPx0680j_4(DpOffset.m11078getXD9Ej5fM(j))) << 32) | (((long) dpOffsetRoundToIntOffset.mo2185roundToPx0680j_4(DpOffset.m11080getYD9Ej5fM(j))) & 4294967295L));
        }
        return IntOffset.INSTANCE.m11156getZeronOccac();
    }

    /* JADX INFO: renamed from: dpOffsetToOffset-BkVx2pU, reason: not valid java name */
    public static final long m12533dpOffsetToOffsetBkVx2pU(Density dpOffsetToOffset, long j) {
        Intrinsics.checkNotNullParameter(dpOffsetToOffset, "$this$dpOffsetToOffset");
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            float fMo2191toPx0680j_4 = dpOffsetToOffset.mo2191toPx0680j_4(DpOffset.m11078getXD9Ej5fM(j));
            float fMo2191toPx0680j_42 = dpOffsetToOffset.mo2191toPx0680j_4(DpOffset.m11080getYD9Ej5fM(j));
            return Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(fMo2191toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo2191toPx0680j_42)) & 4294967295L));
        }
        return Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: renamed from: toIntOffset-rOJDEFc, reason: not valid java name */
    public static final long m12564toIntOffsetrOJDEFc(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1495902195, "C(toIntOffset)176@5312L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1495902195, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toIntOffset (density.kt:176)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12532dpOffsetToIntOffsetBkVx2pU = m12532dpOffsetToIntOffsetBkVx2pU((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12532dpOffsetToIntOffsetBkVx2pU;
    }

    /* JADX INFO: renamed from: roundToIntOffset-rOJDEFc, reason: not valid java name */
    public static final long m12547roundToIntOffsetrOJDEFc(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -718615833, "C(roundToIntOffset)179@5406L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-718615833, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.roundToIntOffset (density.kt:179)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12531dpOffsetRoundToIntOffsetBkVx2pU = m12531dpOffsetRoundToIntOffsetBkVx2pU((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12531dpOffsetRoundToIntOffsetBkVx2pU;
    }

    /* JADX INFO: renamed from: toOffset-rOJDEFc, reason: not valid java name */
    public static final long m12570toOffsetrOJDEFc(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1981858347, "C(toOffset)182@5497L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1981858347, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toOffset (density.kt:182)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12533dpOffsetToOffsetBkVx2pU = m12533dpOffsetToOffsetBkVx2pU((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12533dpOffsetToOffsetBkVx2pU;
    }

    /* JADX INFO: renamed from: toDpOffset-9KIMszo, reason: not valid java name */
    public static final long m12557toDpOffset9KIMszo(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1613140057, "C(toDpOffset)191@5740L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1613140057, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toDpOffset (density.kt:191)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12546offsetToDpOffsetUv8p0NA = m12546offsetToDpOffsetUv8p0NA((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12546offsetToDpOffsetUv8p0NA;
    }

    /* JADX INFO: renamed from: intOffsetToDpOffset-I_oMVgE, reason: not valid java name */
    public static final long m12541intOffsetToDpOffsetI_oMVgE(Density intOffsetToDpOffset, long j) {
        Intrinsics.checkNotNullParameter(intOffsetToDpOffset, "$this$intOffsetToDpOffset");
        float fMo2188toDpu2uoSUM = intOffsetToDpOffset.mo2188toDpu2uoSUM(IntOffset.m11145getXimpl(j));
        float fMo2188toDpu2uoSUM2 = intOffsetToDpOffset.mo2188toDpu2uoSUM(IntOffset.m11146getYimpl(j));
        return DpOffset.m11073constructorimpl((((long) Float.floatToRawIntBits(fMo2188toDpu2uoSUM)) << 32) | (((long) Float.floatToRawIntBits(fMo2188toDpu2uoSUM2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: toDpOffset-f8xVGno, reason: not valid java name */
    public static final long m12558toDpOffsetf8xVGno(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2064596262, "C(toDpOffset)201@6051L7:density.kt#jo4mkz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2064596262, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.toDpOffset (density.kt:201)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM12541intOffsetToDpOffsetI_oMVgE = m12541intOffsetToDpOffsetI_oMVgE((Density) objConsume, j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM12541intOffsetToDpOffsetI_oMVgE;
    }

    /* JADX INFO: renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m12569toOffsetgyyYBs(long j) {
        float fM11145getXimpl = IntOffset.m11145getXimpl(j);
        return Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m11146getYimpl(j))) & 4294967295L) | (Float.floatToRawIntBits(fM11145getXimpl) << 32));
    }

    /* JADX INFO: renamed from: dpToSp-3ABfNKs, reason: not valid java name */
    public static final long m12540dpToSp3ABfNKs(Density dpToSp, float f) {
        Intrinsics.checkNotNullParameter(dpToSp, "$this$dpToSp");
        return !Float.isNaN(f) ? dpToSp.mo2193toSp0xMU5do(f) : TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
    }

    /* JADX INFO: renamed from: dpToFloatPx-3ABfNKs, reason: not valid java name */
    public static final float m12538dpToFloatPx3ABfNKs(Density dpToFloatPx, float f) {
        Intrinsics.checkNotNullParameter(dpToFloatPx, "$this$dpToFloatPx");
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        return dpToFloatPx.mo2191toPx0680j_4(f);
    }

    /* JADX INFO: renamed from: dpToIntPx-3ABfNKs, reason: not valid java name */
    public static final int m12539dpToIntPx3ABfNKs(Density dpToIntPx, float f) {
        Intrinsics.checkNotNullParameter(dpToIntPx, "$this$dpToIntPx");
        if (Float.isNaN(f)) {
            return 0;
        }
        return (int) dpToIntPx.mo2191toPx0680j_4(f);
    }

    /* JADX INFO: renamed from: dpRoundToPx-3ABfNKs, reason: not valid java name */
    public static final int m12534dpRoundToPx3ABfNKs(Density dpRoundToPx, float f) {
        Intrinsics.checkNotNullParameter(dpRoundToPx, "$this$dpRoundToPx");
        if (Float.isNaN(f)) {
            return 0;
        }
        return dpRoundToPx.mo2185roundToPx0680j_4(f);
    }

    /* JADX INFO: renamed from: toRecDpSize-0680j_4, reason: not valid java name */
    public static final long m12572toRecDpSize0680j_4(float f) {
        return !Float.isNaN(f) ? DpKt.m11039DpSizeYgX7TsA(f, f) : DpSize.INSTANCE.m11124getUnspecifiedMYxV2XQ();
    }

    /* JADX INFO: renamed from: toRecDpOffset-0680j_4, reason: not valid java name */
    public static final long m12571toRecDpOffset0680j_4(float f) {
        if (Float.isNaN(f)) {
            return DpOffset.INSTANCE.m11087getUnspecifiedRKDOV3M();
        }
        return DpOffset.m11073constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    /* JADX INFO: renamed from: spToDp-mpE4wyQ, reason: not valid java name */
    public static final float m12553spToDpmpE4wyQ(Density spToDp, long j) {
        Intrinsics.checkNotNullParameter(spToDp, "$this$spToDp");
        return !((TextUnit.m11209getRawTypeimpl(j) > 0L ? 1 : (TextUnit.m11209getRawTypeimpl(j) == 0L ? 0 : -1)) == 0) ? spToDp.mo2186toDpGaN1DYA(j) : C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM();
    }

    /* JADX INFO: renamed from: spToFloatPx-mpE4wyQ, reason: not valid java name */
    public static final float m12554spToFloatPxmpE4wyQ(Density spToFloatPx, long j) {
        Intrinsics.checkNotNullParameter(spToFloatPx, "$this$spToFloatPx");
        if (TextUnit.m11209getRawTypeimpl(j) == 0) {
            return Float.NaN;
        }
        return spToFloatPx.mo2190toPxR2X_6o(j);
    }

    /* JADX INFO: renamed from: spToIntPx-mpE4wyQ, reason: not valid java name */
    public static final int m12555spToIntPxmpE4wyQ(Density spToIntPx, long j) {
        Intrinsics.checkNotNullParameter(spToIntPx, "$this$spToIntPx");
        if (TextUnit.m11209getRawTypeimpl(j) == 0) {
            return 0;
        }
        return (int) spToIntPx.mo2190toPxR2X_6o(j);
    }

    /* JADX INFO: renamed from: spRoundToPx-mpE4wyQ, reason: not valid java name */
    public static final int m12552spRoundToPxmpE4wyQ(Density spRoundToPx, long j) {
        Intrinsics.checkNotNullParameter(spRoundToPx, "$this$spRoundToPx");
        if (TextUnit.m11209getRawTypeimpl(j) == 0) {
            return 0;
        }
        return spRoundToPx.mo2184roundToPxR2X_6o(j);
    }

    public static final long toRecIntSize(int i) {
        long j = i;
        return IntSize.m11183constructorimpl((j & 4294967295L) | (j << 32));
    }

    public static final long toRecIntOffset(int i) {
        long j = i;
        return IntOffset.m11139constructorimpl((j & 4294967295L) | (j << 32));
    }

    /* JADX INFO: renamed from: sizeToDpSize-d16Qtg0, reason: not valid java name */
    public static final long m12551sizeToDpSized16Qtg0(Density sizeToDpSize, long j) {
        Intrinsics.checkNotNullParameter(sizeToDpSize, "$this$sizeToDpSize");
        if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return DpKt.m11039DpSizeYgX7TsA(sizeToDpSize.mo2187toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32))), sizeToDpSize.mo2187toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L))));
        }
        return DpSize.INSTANCE.m11124getUnspecifiedMYxV2XQ();
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m12568toIntSizeuvyYCjk(long j) {
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return IntSize.INSTANCE.m11193getZeroYbymL2g();
        }
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (j >> 32));
        return IntSize.m11183constructorimpl((((long) ((int) Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iIntBitsToFloat) << 32));
    }

    /* JADX INFO: renamed from: isSpaced-uvyYCjk, reason: not valid java name */
    public static final boolean m12545isSpaceduvyYCjk(long j) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats && Float.intBitsToFloat((int) (j >> 32)) > 0.0f && Float.intBitsToFloat((int) (j & 4294967295L)) > 0.0f;
    }

    /* JADX INFO: renamed from: offsetToDpOffset-Uv8p0NA, reason: not valid java name */
    public static final long m12546offsetToDpOffsetUv8p0NA(Density offsetToDpOffset, long j) {
        Intrinsics.checkNotNullParameter(offsetToDpOffset, "$this$offsetToDpOffset");
        if ((9223372034707292159L & j) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            float fMo2187toDpu2uoSUM = offsetToDpOffset.mo2187toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32)));
            float fMo2187toDpu2uoSUM2 = offsetToDpOffset.mo2187toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L)));
            return DpOffset.m11073constructorimpl((((long) Float.floatToRawIntBits(fMo2187toDpu2uoSUM)) << 32) | (((long) Float.floatToRawIntBits(fMo2187toDpu2uoSUM2)) & 4294967295L));
        }
        return DpOffset.INSTANCE.m11087getUnspecifiedRKDOV3M();
    }

    /* JADX INFO: renamed from: toIntOffset-k-4lQ0M, reason: not valid java name */
    public static final long m12563toIntOffsetk4lQ0M(long j) {
        if ((9223372034707292159L & j) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return IntOffset.INSTANCE.m11156getZeronOccac();
        }
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (j >> 32));
        return IntOffset.m11139constructorimpl((((long) ((int) Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iIntBitsToFloat) << 32));
    }
}
