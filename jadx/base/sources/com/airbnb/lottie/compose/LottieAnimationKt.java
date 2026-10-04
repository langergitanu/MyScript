package com.airbnb.lottie.compose;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.ScaleFactor;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.airbnb.lottie.AsyncUpdates;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieFeatureFlag;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.model.Marker;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: LottieAnimation.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÁ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u001f\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\nH\u0007¢\u0006\u0002\u0010!\u001aû\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010*\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010+\u001a\u001f\u0010,\u001a\u00020-*\u00020.2\u0006\u0010/\u001a\u000200H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063²\u0006\f\u00104\u001a\u0004\u0018\u00010\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0004\u001a\u00020\u0006X\u008a\u0084\u0002"}, m1599d2 = {"LottieAnimation", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "outlineMasksAndMattes", "", "applyOpacityToLayers", "enableMergePaths", "renderMode", "Lcom/airbnb/lottie/RenderMode;", "maintainOriginalImageBounds", "dynamicProperties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "clipToCompositionBounds", "clipTextToBoundingBox", "fontMap", "", "", "Landroid/graphics/Typeface;", "asyncUpdates", "Lcom/airbnb/lottie/AsyncUpdates;", "safeMode", "(Lcom/airbnb/lottie/LottieComposition;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;ZLandroidx/compose/runtime/Composer;III)V", "applyShadowToLayers", "(Lcom/airbnb/lottie/LottieComposition;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;ZLandroidx/compose/runtime/Composer;III)V", "isPlaying", "restartOnPlay", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "speed", "iterations", "", "reverseOnRepeat", "(Lcom/airbnb/lottie/LottieComposition;Landroidx/compose/ui/Modifier;ZZLcom/airbnb/lottie/compose/LottieClipSpec;FIZZZZLcom/airbnb/lottie/RenderMode;ZZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZZLjava/util/Map;ZLcom/airbnb/lottie/AsyncUpdates;Landroidx/compose/runtime/Composer;IIII)V", "(Lcom/airbnb/lottie/LottieComposition;FLandroidx/compose/ui/Modifier;ZZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZZLcom/airbnb/lottie/AsyncUpdates;Landroidx/compose/runtime/Composer;III)V", "times", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/geometry/Size;", "scale", "Landroidx/compose/ui/layout/ScaleFactor;", "times-UQTWf7w", "(JJ)J", "lottie-compose_release", "setDynamicProperties"}, m1600k = 2, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottieAnimationKt {
    public static final void LottieAnimation(final LottieComposition lottieComposition, final Function0<Float> progress, Modifier modifier, boolean z, boolean z2, boolean z3, boolean z4, RenderMode renderMode, boolean z5, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z6, boolean z7, Map<String, ? extends Typeface> map, AsyncUpdates asyncUpdates, boolean z8, Composer composer, final int i, final int i2, final int i3) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Composer composerStartRestartGroup = composer.startRestartGroup(382909894);
        Modifier.Companion companion = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z9 = (i3 & 8) != 0 ? false : z;
        final boolean z10 = (i3 & 16) != 0 ? false : z2;
        final boolean z11 = (i3 & 32) != 0 ? true : z3;
        final boolean z12 = (i3 & 64) != 0 ? false : z4;
        RenderMode renderMode2 = (i3 & 128) != 0 ? RenderMode.AUTOMATIC : renderMode;
        final boolean z13 = (i3 & 256) != 0 ? false : z5;
        LottieDynamicProperties lottieDynamicProperties2 = (i3 & 512) != 0 ? null : lottieDynamicProperties;
        Alignment center = (i3 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i3 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        final boolean z14 = (i3 & 4096) != 0 ? true : z6;
        final boolean z15 = (i3 & 8192) != 0 ? false : z7;
        Map<String, ? extends Typeface> map2 = (i3 & 16384) != 0 ? null : map;
        AsyncUpdates asyncUpdates2 = (i3 & 32768) != 0 ? AsyncUpdates.AUTOMATIC : asyncUpdates;
        boolean z16 = (i3 & 65536) != 0 ? false : z8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382909894, i, i2, "com.airbnb.lottie.compose.LottieAnimation (LottieAnimation.kt:97)");
        }
        composerStartRestartGroup.startReplaceableGroup(185152185);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new LottieDrawable();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final LottieDrawable lottieDrawable = (LottieDrawable) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(185152232);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Matrix();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        final Matrix matrix = (Matrix) objRememberedValue2;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(185152312);
        boolean zChanged = composerStartRestartGroup.changed(lottieComposition);
        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        }
        final MutableState mutableState = (MutableState) objRememberedValue3;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(185152364);
        if (lottieComposition == null || lottieComposition.getDuration() == 0.0f) {
            final LottieDynamicProperties lottieDynamicProperties3 = lottieDynamicProperties2;
            final Alignment alignment2 = center;
            final RenderMode renderMode3 = renderMode2;
            final Modifier modifier2 = companion;
            final boolean z17 = z9;
            final boolean z18 = z10;
            final boolean z19 = z11;
            final boolean z20 = z14;
            final boolean z21 = z15;
            final boolean z22 = z16;
            final Map<String, ? extends Typeface> map3 = map2;
            final ContentScale contentScale2 = fit;
            final boolean z23 = z13;
            final AsyncUpdates asyncUpdates3 = asyncUpdates2;
            BoxKt.Box(modifier2, composerStartRestartGroup, (i >> 6) & 14);
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        LottieAnimationKt.LottieAnimation(lottieComposition, progress, modifier2, z17, z18, z19, z12, renderMode3, z23, lottieDynamicProperties3, alignment2, contentScale2, z20, z21, map3, asyncUpdates3, z22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
                return;
            }
            return;
        }
        composerStartRestartGroup.endReplaceableGroup();
        final Rect bounds = lottieComposition.getBounds();
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        final Context context = (Context) objConsume;
        Modifier modifierLottieSize = LottieAnimationSizeNodeKt.lottieSize(companion, bounds.width(), bounds.height());
        final ContentScale contentScale3 = fit;
        final AsyncUpdates asyncUpdates4 = asyncUpdates2;
        final Map<String, ? extends Typeface> map4 = map2;
        final LottieDynamicProperties lottieDynamicProperties4 = lottieDynamicProperties2;
        final Modifier modifier3 = companion;
        final boolean z24 = z12;
        final Alignment alignment3 = center;
        final RenderMode renderMode4 = renderMode2;
        final boolean z25 = z16;
        Function1<DrawScope, Unit> function1 = new Function1<DrawScope, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope Canvas) {
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                Rect rect = bounds;
                ContentScale contentScale4 = contentScale3;
                Alignment alignment4 = alignment3;
                Matrix matrix2 = matrix;
                LottieDrawable lottieDrawable2 = lottieDrawable;
                boolean z26 = z24;
                boolean z27 = z25;
                RenderMode renderMode5 = renderMode4;
                AsyncUpdates asyncUpdates5 = asyncUpdates4;
                LottieComposition lottieComposition2 = lottieComposition;
                Map<String, Typeface> map5 = map4;
                LottieDynamicProperties lottieDynamicProperties5 = lottieDynamicProperties4;
                boolean z28 = z9;
                boolean z29 = z10;
                boolean z30 = z11;
                boolean z31 = z13;
                boolean z32 = z14;
                boolean z33 = z15;
                Context context2 = context;
                Function0<Float> function0 = progress;
                MutableState<LottieDynamicProperties> mutableState2 = mutableState;
                Canvas canvas = Canvas.getDrawContext().getCanvas();
                long jSize = SizeKt.Size(rect.width(), rect.height());
                long jIntSize = IntSizeKt.IntSize(MathKt.roundToInt(Size.m7972getWidthimpl(Canvas.mo8729getSizeNHjbRc())), MathKt.roundToInt(Size.m7969getHeightimpl(Canvas.mo8729getSizeNHjbRc())));
                long jMo9618computeScaleFactorH7hwNQA = contentScale4.mo9618computeScaleFactorH7hwNQA(jSize, Canvas.mo8729getSizeNHjbRc());
                long jMo7571alignKFBX0sM = alignment4.mo7571alignKFBX0sM(LottieAnimationKt.m12391timesUQTWf7w(jSize, jMo9618computeScaleFactorH7hwNQA), jIntSize, Canvas.getLayoutDirection());
                matrix2.reset();
                matrix2.preTranslate(IntOffset.m11145getXimpl(jMo7571alignKFBX0sM), IntOffset.m11146getYimpl(jMo7571alignKFBX0sM));
                matrix2.preScale(ScaleFactor.m9741getScaleXimpl(jMo9618computeScaleFactorH7hwNQA), ScaleFactor.m9742getScaleYimpl(jMo9618computeScaleFactorH7hwNQA));
                lottieDrawable2.enableFeatureFlag(LottieFeatureFlag.MergePathsApi19, z26);
                lottieDrawable2.setSafeMode(z27);
                lottieDrawable2.setRenderMode(renderMode5);
                lottieDrawable2.setAsyncUpdates(asyncUpdates5);
                lottieDrawable2.setComposition(lottieComposition2);
                lottieDrawable2.setFontMap(map5);
                if (lottieDynamicProperties5 != LottieAnimationKt.LottieAnimation$lambda$3(mutableState2)) {
                    LottieDynamicProperties lottieDynamicPropertiesLottieAnimation$lambda$3 = LottieAnimationKt.LottieAnimation$lambda$3(mutableState2);
                    if (lottieDynamicPropertiesLottieAnimation$lambda$3 != null) {
                        lottieDynamicPropertiesLottieAnimation$lambda$3.removeFrom$lottie_compose_release(lottieDrawable2);
                    }
                    if (lottieDynamicProperties5 != null) {
                        lottieDynamicProperties5.addTo$lottie_compose_release(lottieDrawable2);
                    }
                    LottieAnimationKt.LottieAnimation$lambda$4(mutableState2, lottieDynamicProperties5);
                }
                lottieDrawable2.setOutlineMasksAndMattes(z28);
                lottieDrawable2.setApplyingOpacityToLayersEnabled(z29);
                lottieDrawable2.setApplyingShadowToLayersEnabled(z30);
                lottieDrawable2.setMaintainOriginalImageBounds(z31);
                lottieDrawable2.setClipToCompositionBounds(z32);
                lottieDrawable2.setClipTextToBoundingBox(z33);
                Marker markerForAnimationsDisabled = lottieDrawable2.getMarkerForAnimationsDisabled();
                if (!lottieDrawable2.animationsEnabled(context2) && markerForAnimationsDisabled != null) {
                    lottieDrawable2.setProgress(markerForAnimationsDisabled.startFrame);
                } else {
                    lottieDrawable2.setProgress(function0.invoke().floatValue());
                }
                lottieDrawable2.setBounds(0, 0, rect.width(), rect.height());
                lottieDrawable2.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas), matrix2);
            }
        };
        final boolean z26 = z13;
        final boolean z27 = z9;
        final boolean z28 = z10;
        final boolean z29 = z14;
        final boolean z30 = z15;
        final boolean z31 = z11;
        CanvasKt.Canvas(modifierLottieSize, function1, composerStartRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LottieAnimationKt.LottieAnimation(lottieComposition, progress, modifier3, z27, z28, z31, z24, renderMode4, z26, lottieDynamicProperties4, alignment3, contentScale3, z29, z30, map4, asyncUpdates4, z25, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LottieDynamicProperties LottieAnimation$lambda$3(MutableState<LottieDynamicProperties> mutableState) {
        return mutableState.getValue();
    }

    @Deprecated(message = "Pass progress as a lambda instead of a float. This overload will be removed in the next release.")
    public static final void LottieAnimation(final LottieComposition lottieComposition, final float f, Modifier modifier, boolean z, boolean z2, boolean z3, boolean z4, RenderMode renderMode, boolean z5, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z6, boolean z7, AsyncUpdates asyncUpdates, Composer composer, final int i, final int i2, final int i3) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1170781710);
        Modifier modifier2 = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean z8 = (i3 & 8) != 0 ? false : z;
        boolean z9 = (i3 & 16) != 0 ? false : z2;
        boolean z10 = (i3 & 32) != 0 ? true : z3;
        boolean z11 = (i3 & 64) != 0 ? false : z4;
        RenderMode renderMode2 = (i3 & 128) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z12 = (i3 & 256) != 0 ? false : z5;
        LottieDynamicProperties lottieDynamicProperties2 = (i3 & 512) != 0 ? null : lottieDynamicProperties;
        Alignment center = (i3 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i3 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        boolean z13 = (i3 & 4096) != 0 ? true : z6;
        boolean z14 = (i3 & 8192) != 0 ? false : z7;
        AsyncUpdates asyncUpdates2 = (i3 & 16384) != 0 ? AsyncUpdates.AUTOMATIC : asyncUpdates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1170781710, i, i2, "com.airbnb.lottie.compose.LottieAnimation (LottieAnimation.kt:172)");
        }
        composerStartRestartGroup.startReplaceableGroup(185155711);
        boolean z15 = (((i & 112) ^ 48) > 32 && composerStartRestartGroup.changed(f)) || (i & 48) == 32;
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (z15 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(f);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        final Alignment alignment2 = center;
        final boolean z16 = z8;
        final boolean z17 = z11;
        final RenderMode renderMode3 = renderMode2;
        final boolean z18 = z12;
        final LottieDynamicProperties lottieDynamicProperties3 = lottieDynamicProperties2;
        LottieAnimation(lottieComposition, (Function0) objRememberedValue, modifier2, z16, z9, z10, z17, renderMode3, z18, lottieDynamicProperties3, alignment2, fit, z13, false, null, asyncUpdates2, z14, composerStartRestartGroup, (i & 7168) | (i & 896) | 1073741832 | (57344 & i) | (i & 458752) | (i & 3670016) | (i & 29360128) | (i & 234881024), (i2 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i2 << 3) & 458752) | ((i2 << 9) & 3670016), 24576);
        final boolean z19 = z9;
        final boolean z20 = z10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final ContentScale contentScale2 = fit;
            final boolean z21 = z13;
            final AsyncUpdates asyncUpdates3 = asyncUpdates2;
            final boolean z22 = z14;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LottieAnimationKt.LottieAnimation(lottieComposition, f, modifier3, z16, z19, z20, z17, renderMode3, z18, lottieDynamicProperties3, alignment2, contentScale2, z21, z22, asyncUpdates3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                }
            });
        }
    }

    public static final void LottieAnimation(final LottieComposition lottieComposition, Modifier modifier, boolean z, boolean z2, LottieClipSpec lottieClipSpec, float f, int i, boolean z3, boolean z4, boolean z5, boolean z6, RenderMode renderMode, boolean z7, boolean z8, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z9, boolean z10, Map<String, ? extends Typeface> map, boolean z11, AsyncUpdates asyncUpdates, Composer composer, final int i2, final int i3, final int i4, final int i5) {
        LottieDynamicProperties lottieDynamicProperties2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1331239405);
        Modifier.Companion companion = (i5 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z12 = (i5 & 4) != 0 ? true : z;
        boolean z13 = (i5 & 8) != 0 ? true : z2;
        LottieClipSpec lottieClipSpec2 = (i5 & 16) != 0 ? null : lottieClipSpec;
        float f2 = (i5 & 32) != 0 ? 1.0f : f;
        int i6 = (i5 & 64) != 0 ? 1 : i;
        boolean z14 = (i5 & 128) != 0 ? false : z3;
        boolean z15 = (i5 & 256) != 0 ? false : z4;
        boolean z16 = (i5 & 512) != 0 ? true : z5;
        boolean z17 = (i5 & 1024) != 0 ? false : z6;
        RenderMode renderMode2 = (i5 & 2048) != 0 ? RenderMode.AUTOMATIC : renderMode;
        final boolean z18 = (i5 & 4096) != 0 ? false : z7;
        final boolean z19 = (i5 & 8192) != 0 ? false : z8;
        LottieDynamicProperties lottieDynamicProperties3 = (i5 & 16384) != 0 ? null : lottieDynamicProperties;
        Alignment center = (i5 & 32768) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i5 & 65536) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        boolean z20 = (i5 & 131072) != 0 ? true : z9;
        boolean z21 = (i5 & 262144) != 0 ? false : z10;
        Map<String, ? extends Typeface> map2 = (i5 & 524288) != 0 ? null : map;
        boolean z22 = (i5 & 1048576) != 0 ? false : z11;
        AsyncUpdates asyncUpdates2 = (i5 & 2097152) != 0 ? AsyncUpdates.AUTOMATIC : asyncUpdates;
        if (ComposerKt.isTraceInProgress()) {
            lottieDynamicProperties2 = lottieDynamicProperties3;
            ComposerKt.traceEventStart(1331239405, i2, i3, "com.airbnb.lottie.compose.LottieAnimation (LottieAnimation.kt:224)");
        } else {
            lottieDynamicProperties2 = lottieDynamicProperties3;
        }
        int i7 = i2 >> 3;
        final boolean z23 = z12;
        final boolean z24 = z13;
        final LottieClipSpec lottieClipSpec3 = lottieClipSpec2;
        final int i8 = i6;
        final LottieAnimationState lottieAnimationStateAnimateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(lottieComposition, z23, z24, z18, lottieClipSpec3, f2, i8, null, false, false, composerStartRestartGroup, (i7 & 896) | (i7 & 112) | 8 | ((i3 << 3) & 7168) | (i2 & 57344) | (i2 & 458752) | (i2 & 3670016), 896);
        final Modifier modifier2 = companion;
        final boolean z25 = z16;
        final boolean z26 = z14;
        composerStartRestartGroup.startReplaceableGroup(185157769);
        boolean zChanged = composerStartRestartGroup.changed(lottieAnimationStateAnimateLottieCompositionAsState);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$6$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(LottieAnimationKt.LottieAnimation$lambda$6(lottieAnimationStateAnimateLottieCompositionAsState));
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        int i9 = i2 >> 12;
        int i10 = i3 << 18;
        int i11 = (i9 & 7168) | ((i2 << 3) & 896) | 1073741832 | (i9 & 57344) | (i9 & 458752) | (i10 & 3670016) | (i10 & 29360128) | ((i3 << 15) & 234881024);
        int i12 = i3 >> 15;
        final LottieDynamicProperties lottieDynamicProperties4 = lottieDynamicProperties2;
        final boolean z27 = z17;
        final RenderMode renderMode3 = renderMode2;
        final boolean z28 = z15;
        final Alignment alignment2 = center;
        final ContentScale contentScale2 = fit;
        final boolean z29 = z20;
        final boolean z30 = z21;
        final Map<String, ? extends Typeface> map3 = map2;
        final boolean z31 = z22;
        final AsyncUpdates asyncUpdates3 = asyncUpdates2;
        LottieAnimation(lottieComposition, function0, modifier2, z26, z28, z25, z27, renderMode3, z19, lottieDynamicProperties4, alignment2, contentScale2, z29, z30, map3, asyncUpdates3, z31, composerStartRestartGroup, i11, (i12 & 896) | (i12 & 14) | 32768 | (i12 & 112) | (i12 & 7168) | ((i4 << 12) & 458752) | ((i4 << 18) & 3670016), 0);
        final float f3 = f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    LottieAnimationKt.LottieAnimation(lottieComposition, modifier2, z23, z24, lottieClipSpec3, f3, i8, z26, z28, z25, z27, renderMode3, z18, z19, lottieDynamicProperties4, alignment2, contentScale2, z29, z30, map3, z31, asyncUpdates3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LottieAnimation$lambda$6(LottieAnimationState lottieAnimationState) {
        return lottieAnimationState.getValue().floatValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This is here for binary compatibility. It'll be removed after the next major release")
    public static final /* synthetic */ void LottieAnimation(final LottieComposition lottieComposition, final Function0 progress, Modifier modifier, boolean z, boolean z2, boolean z3, RenderMode renderMode, boolean z4, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z5, boolean z6, Map map, AsyncUpdates asyncUpdates, boolean z7, Composer composer, final int i, final int i2, final int i3) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Composer composerStartRestartGroup = composer.startRestartGroup(-674272918);
        Modifier modifier2 = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean z8 = (i3 & 8) != 0 ? false : z;
        boolean z9 = (i3 & 16) != 0 ? false : z2;
        boolean z10 = (i3 & 32) != 0 ? false : z3;
        RenderMode renderMode2 = (i3 & 64) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z11 = (i3 & 128) != 0 ? false : z4;
        LottieDynamicProperties lottieDynamicProperties2 = (i3 & 256) != 0 ? null : lottieDynamicProperties;
        Alignment center = (i3 & 512) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i3 & 1024) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        boolean z12 = (i3 & 2048) != 0 ? true : z5;
        boolean z13 = (i3 & 4096) != 0 ? false : z6;
        Map map2 = (i3 & 8192) != 0 ? null : map;
        AsyncUpdates asyncUpdates2 = (i3 & 16384) != 0 ? AsyncUpdates.AUTOMATIC : asyncUpdates;
        boolean z14 = (i3 & 32768) != 0 ? false : z7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-674272918, i, i2, "com.airbnb.lottie.compose.LottieAnimation (LottieAnimation.kt:282)");
        }
        int i4 = i << 3;
        int i5 = (i & 112) | 1073938440 | (i & 896) | (i & 7168) | (57344 & i) | (i4 & 3670016) | (i4 & 29360128) | (i4 & 234881024);
        int i6 = i2 << 3;
        int i7 = (i6 & 896) | 32768 | ((i >> 27) & 14) | (i6 & 112) | (i6 & 7168) | (458752 & i6) | (i6 & 3670016);
        final LottieDynamicProperties lottieDynamicProperties3 = lottieDynamicProperties2;
        final boolean z15 = z8;
        LottieAnimation(lottieComposition, progress, modifier2, z15, z9, false, z10, renderMode2, z11, lottieDynamicProperties3, center, fit, z12, z13, map2, asyncUpdates2, z14, composerStartRestartGroup, i5, i7, 0);
        final Modifier modifier3 = modifier2;
        final boolean z16 = z9;
        final boolean z17 = z10;
        final RenderMode renderMode3 = renderMode2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z18 = z11;
            final Alignment alignment2 = center;
            final ContentScale contentScale2 = fit;
            final boolean z19 = z12;
            final boolean z20 = z13;
            final Map map3 = map2;
            final AsyncUpdates asyncUpdates3 = asyncUpdates2;
            final boolean z21 = z14;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    LottieAnimationKt.LottieAnimation(lottieComposition, progress, modifier3, z15, z16, z17, renderMode3, z18, lottieDynamicProperties3, alignment2, contentScale2, z19, z20, map3, asyncUpdates3, z21, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m12391timesUQTWf7w(long j, long j2) {
        return IntSizeKt.IntSize((int) (Size.m7972getWidthimpl(j) * ScaleFactor.m9741getScaleXimpl(j2)), (int) (Size.m7969getHeightimpl(j) * ScaleFactor.m9742getScaleYimpl(j2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LottieAnimation$lambda$4(MutableState<LottieDynamicProperties> mutableState, LottieDynamicProperties lottieDynamicProperties) {
        mutableState.setValue(lottieDynamicProperties);
    }
}
