package com.airbnb.lottie.compose;

import android.graphics.Matrix;
import android.graphics.Typeface;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.airbnb.lottie.AsyncUpdates;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieFeatureFlag;
import com.airbnb.lottie.RenderMode;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: LottiePainter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0091\u0001\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\f\u0010V\u001a\u00020W*\u00020XH\u0014R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00168@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR/\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001e\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u001e\u001a\u0004\b1\u00102\"\u0004\b3\u00104R+\u0010\t\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001e\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cRG\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u001e\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020?8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b@\u0010AR+\u0010\f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010\u001e\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001cR\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\u001e\u001a\u0004\bG\u0010\u001a\"\u0004\bH\u0010\u001cR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00058@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR+\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010\u001e\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0010\u0010U\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottiePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "composition", "Lcom/airbnb/lottie/LottieComposition;", "progress", "", "outlineMasksAndMattes", "", "applyOpacityToLayers", "enableMergePaths", "renderMode", "Lcom/airbnb/lottie/RenderMode;", "maintainOriginalImageBounds", "dynamicProperties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "clipToCompositionBounds", "clipTextToBoundingBox", "fontMap", "", "", "Landroid/graphics/Typeface;", "asyncUpdates", "Lcom/airbnb/lottie/AsyncUpdates;", "(Lcom/airbnb/lottie/LottieComposition;FZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;)V", "<set-?>", "getApplyOpacityToLayers$lottie_compose_release", "()Z", "setApplyOpacityToLayers$lottie_compose_release", "(Z)V", "applyOpacityToLayers$delegate", "Landroidx/compose/runtime/MutableState;", "getAsyncUpdates$lottie_compose_release", "()Lcom/airbnb/lottie/AsyncUpdates;", "setAsyncUpdates$lottie_compose_release", "(Lcom/airbnb/lottie/AsyncUpdates;)V", "asyncUpdates$delegate", "getClipTextToBoundingBox$lottie_compose_release", "setClipTextToBoundingBox$lottie_compose_release", "clipTextToBoundingBox$delegate", "getClipToCompositionBounds$lottie_compose_release", "setClipToCompositionBounds$lottie_compose_release", "clipToCompositionBounds$delegate", "getComposition$lottie_compose_release", "()Lcom/airbnb/lottie/LottieComposition;", "setComposition$lottie_compose_release", "(Lcom/airbnb/lottie/LottieComposition;)V", "composition$delegate", "drawable", "Lcom/airbnb/lottie/LottieDrawable;", "getDynamicProperties$lottie_compose_release", "()Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "setDynamicProperties$lottie_compose_release", "(Lcom/airbnb/lottie/compose/LottieDynamicProperties;)V", "dynamicProperties$delegate", "getEnableMergePaths$lottie_compose_release", "setEnableMergePaths$lottie_compose_release", "enableMergePaths$delegate", "getFontMap$lottie_compose_release", "()Ljava/util/Map;", "setFontMap$lottie_compose_release", "(Ljava/util/Map;)V", "fontMap$delegate", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "getMaintainOriginalImageBounds$lottie_compose_release", "setMaintainOriginalImageBounds$lottie_compose_release", "maintainOriginalImageBounds$delegate", QuestionSurveyAnswerType.MATRIX, "Landroid/graphics/Matrix;", "getOutlineMasksAndMattes$lottie_compose_release", "setOutlineMasksAndMattes$lottie_compose_release", "outlineMasksAndMattes$delegate", "getProgress$lottie_compose_release", "()F", "setProgress$lottie_compose_release", "(F)V", "progress$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getRenderMode$lottie_compose_release", "()Lcom/airbnb/lottie/RenderMode;", "setRenderMode$lottie_compose_release", "(Lcom/airbnb/lottie/RenderMode;)V", "renderMode$delegate", "setDynamicProperties", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottiePainter extends Painter {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: applyOpacityToLayers$delegate, reason: from kotlin metadata */
    private final MutableState applyOpacityToLayers;

    /* JADX INFO: renamed from: asyncUpdates$delegate, reason: from kotlin metadata */
    private final MutableState asyncUpdates;

    /* JADX INFO: renamed from: clipTextToBoundingBox$delegate, reason: from kotlin metadata */
    private final MutableState clipTextToBoundingBox;

    /* JADX INFO: renamed from: clipToCompositionBounds$delegate, reason: from kotlin metadata */
    private final MutableState clipToCompositionBounds;

    /* JADX INFO: renamed from: composition$delegate, reason: from kotlin metadata */
    private final MutableState composition;
    private final LottieDrawable drawable;

    /* JADX INFO: renamed from: dynamicProperties$delegate, reason: from kotlin metadata */
    private final MutableState dynamicProperties;

    /* JADX INFO: renamed from: enableMergePaths$delegate, reason: from kotlin metadata */
    private final MutableState enableMergePaths;

    /* JADX INFO: renamed from: fontMap$delegate, reason: from kotlin metadata */
    private final MutableState fontMap;

    /* JADX INFO: renamed from: maintainOriginalImageBounds$delegate, reason: from kotlin metadata */
    private final MutableState maintainOriginalImageBounds;
    private final Matrix matrix;

    /* JADX INFO: renamed from: outlineMasksAndMattes$delegate, reason: from kotlin metadata */
    private final MutableState outlineMasksAndMattes;

    /* JADX INFO: renamed from: progress$delegate, reason: from kotlin metadata */
    private final MutableFloatState progress;

    /* JADX INFO: renamed from: renderMode$delegate, reason: from kotlin metadata */
    private final MutableState renderMode;
    private LottieDynamicProperties setDynamicProperties;

    public LottiePainter() {
        this(null, 0.0f, false, false, false, null, false, null, false, false, null, null, 4095, null);
    }

    public /* synthetic */ LottiePainter(LottieComposition lottieComposition, float f, boolean z, boolean z2, boolean z3, RenderMode renderMode, boolean z4, LottieDynamicProperties lottieDynamicProperties, boolean z5, boolean z6, Map map, AsyncUpdates asyncUpdates, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lottieComposition, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? RenderMode.AUTOMATIC : renderMode, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? null : lottieDynamicProperties, (i & 256) != 0 ? true : z5, (i & 512) == 0 ? z6 : false, (i & 1024) == 0 ? map : null, (i & 2048) != 0 ? AsyncUpdates.AUTOMATIC : asyncUpdates);
    }

    public LottiePainter(LottieComposition lottieComposition, float f, boolean z, boolean z2, boolean z3, RenderMode renderMode, boolean z4, LottieDynamicProperties lottieDynamicProperties, boolean z5, boolean z6, Map<String, ? extends Typeface> map, AsyncUpdates asyncUpdates) {
        Intrinsics.checkNotNullParameter(renderMode, "renderMode");
        Intrinsics.checkNotNullParameter(asyncUpdates, "asyncUpdates");
        this.composition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(lottieComposition, null, 2, null);
        this.progress = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.outlineMasksAndMattes = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.applyOpacityToLayers = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
        this.enableMergePaths = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), null, 2, null);
        this.renderMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(renderMode, null, 2, null);
        this.maintainOriginalImageBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z4), null, 2, null);
        this.dynamicProperties = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(lottieDynamicProperties, null, 2, null);
        this.clipToCompositionBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
        this.fontMap = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(map, null, 2, null);
        this.asyncUpdates = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(asyncUpdates, null, 2, null);
        this.clipTextToBoundingBox = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z6), null, 2, null);
        this.drawable = new LottieDrawable();
        this.matrix = new Matrix();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LottieComposition getComposition$lottie_compose_release() {
        return (LottieComposition) this.composition.getValue();
    }

    public final void setComposition$lottie_compose_release(LottieComposition lottieComposition) {
        this.composition.setValue(lottieComposition);
    }

    public final float getProgress$lottie_compose_release() {
        return this.progress.getFloatValue();
    }

    public final void setProgress$lottie_compose_release(float f) {
        this.progress.setFloatValue(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getOutlineMasksAndMattes$lottie_compose_release() {
        return ((Boolean) this.outlineMasksAndMattes.getValue()).booleanValue();
    }

    public final void setOutlineMasksAndMattes$lottie_compose_release(boolean z) {
        this.outlineMasksAndMattes.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getApplyOpacityToLayers$lottie_compose_release() {
        return ((Boolean) this.applyOpacityToLayers.getValue()).booleanValue();
    }

    public final void setApplyOpacityToLayers$lottie_compose_release(boolean z) {
        this.applyOpacityToLayers.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnableMergePaths$lottie_compose_release() {
        return ((Boolean) this.enableMergePaths.getValue()).booleanValue();
    }

    public final void setEnableMergePaths$lottie_compose_release(boolean z) {
        this.enableMergePaths.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RenderMode getRenderMode$lottie_compose_release() {
        return (RenderMode) this.renderMode.getValue();
    }

    public final void setRenderMode$lottie_compose_release(RenderMode renderMode) {
        Intrinsics.checkNotNullParameter(renderMode, "<set-?>");
        this.renderMode.setValue(renderMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getMaintainOriginalImageBounds$lottie_compose_release() {
        return ((Boolean) this.maintainOriginalImageBounds.getValue()).booleanValue();
    }

    public final void setMaintainOriginalImageBounds$lottie_compose_release(boolean z) {
        this.maintainOriginalImageBounds.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LottieDynamicProperties getDynamicProperties$lottie_compose_release() {
        return (LottieDynamicProperties) this.dynamicProperties.getValue();
    }

    public final void setDynamicProperties$lottie_compose_release(LottieDynamicProperties lottieDynamicProperties) {
        this.dynamicProperties.setValue(lottieDynamicProperties);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getClipToCompositionBounds$lottie_compose_release() {
        return ((Boolean) this.clipToCompositionBounds.getValue()).booleanValue();
    }

    public final void setClipToCompositionBounds$lottie_compose_release(boolean z) {
        this.clipToCompositionBounds.setValue(Boolean.valueOf(z));
    }

    public final Map<String, Typeface> getFontMap$lottie_compose_release() {
        return (Map) this.fontMap.getValue();
    }

    public final void setFontMap$lottie_compose_release(Map<String, ? extends Typeface> map) {
        this.fontMap.setValue(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AsyncUpdates getAsyncUpdates$lottie_compose_release() {
        return (AsyncUpdates) this.asyncUpdates.getValue();
    }

    public final void setAsyncUpdates$lottie_compose_release(AsyncUpdates asyncUpdates) {
        Intrinsics.checkNotNullParameter(asyncUpdates, "<set-?>");
        this.asyncUpdates.setValue(asyncUpdates);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getClipTextToBoundingBox$lottie_compose_release() {
        return ((Boolean) this.clipTextToBoundingBox.getValue()).booleanValue();
    }

    public final void setClipTextToBoundingBox$lottie_compose_release(boolean z) {
        this.clipTextToBoundingBox.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        return getComposition$lottie_compose_release() == null ? Size.INSTANCE.m7980getUnspecifiedNHjbRc() : SizeKt.Size(r0.getBounds().width(), r0.getBounds().height());
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    protected void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        LottieComposition composition$lottie_compose_release = getComposition$lottie_compose_release();
        if (composition$lottie_compose_release == null) {
            return;
        }
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        long jSize = SizeKt.Size(composition$lottie_compose_release.getBounds().width(), composition$lottie_compose_release.getBounds().height());
        long jIntSize = IntSizeKt.IntSize(MathKt.roundToInt(Size.m7972getWidthimpl(drawScope.mo8729getSizeNHjbRc())), MathKt.roundToInt(Size.m7969getHeightimpl(drawScope.mo8729getSizeNHjbRc())));
        this.matrix.reset();
        this.matrix.preScale(IntSize.m11188getWidthimpl(jIntSize) / Size.m7972getWidthimpl(jSize), IntSize.m11187getHeightimpl(jIntSize) / Size.m7969getHeightimpl(jSize));
        this.drawable.enableFeatureFlag(LottieFeatureFlag.MergePathsApi19, getEnableMergePaths$lottie_compose_release());
        this.drawable.setRenderMode(getRenderMode$lottie_compose_release());
        this.drawable.setAsyncUpdates(getAsyncUpdates$lottie_compose_release());
        this.drawable.setComposition(composition$lottie_compose_release);
        this.drawable.setFontMap(getFontMap$lottie_compose_release());
        LottieDynamicProperties dynamicProperties$lottie_compose_release = getDynamicProperties$lottie_compose_release();
        LottieDynamicProperties lottieDynamicProperties = this.setDynamicProperties;
        if (dynamicProperties$lottie_compose_release != lottieDynamicProperties) {
            if (lottieDynamicProperties != null) {
                lottieDynamicProperties.removeFrom$lottie_compose_release(this.drawable);
            }
            LottieDynamicProperties dynamicProperties$lottie_compose_release2 = getDynamicProperties$lottie_compose_release();
            if (dynamicProperties$lottie_compose_release2 != null) {
                dynamicProperties$lottie_compose_release2.addTo$lottie_compose_release(this.drawable);
            }
            this.setDynamicProperties = getDynamicProperties$lottie_compose_release();
        }
        this.drawable.setOutlineMasksAndMattes(getOutlineMasksAndMattes$lottie_compose_release());
        this.drawable.setApplyingOpacityToLayersEnabled(getApplyOpacityToLayers$lottie_compose_release());
        this.drawable.setMaintainOriginalImageBounds(getMaintainOriginalImageBounds$lottie_compose_release());
        this.drawable.setClipToCompositionBounds(getClipToCompositionBounds$lottie_compose_release());
        this.drawable.setClipTextToBoundingBox(getClipTextToBoundingBox$lottie_compose_release());
        this.drawable.setProgress(getProgress$lottie_compose_release());
        this.drawable.setBounds(0, 0, composition$lottie_compose_release.getBounds().width(), composition$lottie_compose_release.getBounds().height());
        this.drawable.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas), this.matrix);
    }
}
