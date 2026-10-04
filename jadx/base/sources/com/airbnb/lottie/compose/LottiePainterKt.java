package com.airbnb.lottie.compose;

import android.graphics.Typeface;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.layout.ScaleFactor;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.airbnb.lottie.AsyncUpdates;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.RenderMode;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: LottiePainter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0097\u0001\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u001f\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m1599d2 = {"rememberLottiePainter", "Lcom/airbnb/lottie/compose/LottiePainter;", "composition", "Lcom/airbnb/lottie/LottieComposition;", "progress", "", "outlineMasksAndMattes", "", "applyOpacityToLayers", "enableMergePaths", "renderMode", "Lcom/airbnb/lottie/RenderMode;", "maintainOriginalImageBounds", "dynamicProperties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "clipToCompositionBounds", "clipTextToBoundingBox", "fontMap", "", "", "Landroid/graphics/Typeface;", "asyncUpdates", "Lcom/airbnb/lottie/AsyncUpdates;", "(Lcom/airbnb/lottie/LottieComposition;FZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;Landroidx/compose/runtime/Composer;III)Lcom/airbnb/lottie/compose/LottiePainter;", "times", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/geometry/Size;", "scale", "Landroidx/compose/ui/layout/ScaleFactor;", "times-UQTWf7w", "(JJ)J", "lottie-compose_release"}, m1600k = 2, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottiePainterKt {
    public static final LottiePainter rememberLottiePainter(LottieComposition lottieComposition, float f, boolean z, boolean z2, boolean z3, RenderMode renderMode, boolean z4, LottieDynamicProperties lottieDynamicProperties, boolean z5, boolean z6, Map<String, ? extends Typeface> map, AsyncUpdates asyncUpdates, Composer composer, int i, int i2, int i3) {
        AsyncUpdates asyncUpdates2;
        composer.startReplaceableGroup(-1760390310);
        LottieComposition lottieComposition2 = (i3 & 1) != 0 ? null : lottieComposition;
        float f2 = (i3 & 2) != 0 ? 0.0f : f;
        boolean z7 = (i3 & 4) != 0 ? false : z;
        boolean z8 = (i3 & 8) != 0 ? false : z2;
        boolean z9 = (i3 & 16) != 0 ? false : z3;
        RenderMode renderMode2 = (i3 & 32) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z10 = (i3 & 64) != 0 ? false : z4;
        LottieDynamicProperties lottieDynamicProperties2 = (i3 & 128) != 0 ? null : lottieDynamicProperties;
        boolean z11 = (i3 & 256) != 0 ? true : z5;
        boolean z12 = (i3 & 512) == 0 ? z6 : false;
        Map<String, ? extends Typeface> map2 = (i3 & 1024) == 0 ? map : null;
        AsyncUpdates asyncUpdates3 = (i3 & 2048) != 0 ? AsyncUpdates.AUTOMATIC : asyncUpdates;
        if (ComposerKt.isTraceInProgress()) {
            asyncUpdates2 = asyncUpdates3;
            ComposerKt.traceEventStart(-1760390310, i, i2, "com.airbnb.lottie.compose.rememberLottiePainter (LottiePainter.kt:41)");
        } else {
            asyncUpdates2 = asyncUpdates3;
        }
        composer.startReplaceableGroup(1356844528);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            LottiePainter lottiePainter = new LottiePainter(null, 0.0f, false, false, false, null, false, null, false, false, null, null, 4095, null);
            composer.updateRememberedValue(lottiePainter);
            objRememberedValue = lottiePainter;
        }
        LottiePainter lottiePainter2 = (LottiePainter) objRememberedValue;
        composer.endReplaceableGroup();
        lottiePainter2.setComposition$lottie_compose_release(lottieComposition2);
        lottiePainter2.setProgress$lottie_compose_release(f2);
        lottiePainter2.setOutlineMasksAndMattes$lottie_compose_release(z7);
        lottiePainter2.setApplyOpacityToLayers$lottie_compose_release(z8);
        lottiePainter2.setEnableMergePaths$lottie_compose_release(z9);
        lottiePainter2.setRenderMode$lottie_compose_release(renderMode2);
        lottiePainter2.setMaintainOriginalImageBounds$lottie_compose_release(z10);
        lottiePainter2.setDynamicProperties$lottie_compose_release(lottieDynamicProperties2);
        lottiePainter2.setClipToCompositionBounds$lottie_compose_release(z11);
        lottiePainter2.setClipTextToBoundingBox$lottie_compose_release(z12);
        lottiePainter2.setFontMap$lottie_compose_release(map2);
        lottiePainter2.setAsyncUpdates$lottie_compose_release(asyncUpdates2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lottiePainter2;
    }

    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    private static final long m12435timesUQTWf7w(long j, long j2) {
        return IntSizeKt.IntSize((int) (Size.m7972getWidthimpl(j) * ScaleFactor.m9741getScaleXimpl(j2)), (int) (Size.m7969getHeightimpl(j) * ScaleFactor.m9742getScaleYimpl(j2)));
    }
}
