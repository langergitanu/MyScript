package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.HorizontalAlignmentLine;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, m1599d2 = {"paddingFrom", "Landroidx/compose/ui/Modifier;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", TtmlNode.ANNOTATION_POSITION_BEFORE, "Landroidx/compose/ui/unit/Dp;", TtmlNode.ANNOTATION_POSITION_AFTER, "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "horizontal", "", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "foundation-layout"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AlignmentLineKt {
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2498paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM();
        }
        return m2497paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m2497paddingFrom4j6BHR0(Modifier modifier, final AlignmentLine alignmentLine, final float f, final float f2) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, C1486Dp.m11015boximpl(f));
                inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, C1486Dp.m11015boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2500paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
        }
        return m2499paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m2499paddingFromY_r0B1c(Modifier modifier, final AlignmentLine alignmentLine, final long j, final long j2) {
        AlignmentLine alignmentLine2;
        long j3;
        long j4;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            alignmentLine2 = alignmentLine;
            j3 = j;
            j4 = j2;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("paddingFrom");
                    inspectorInfo.getProperties().set("alignmentLine", alignmentLine);
                    inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, TextUnit.m11201boximpl(j));
                    inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, TextUnit.m11201boximpl(j2));
                }
            };
        } else {
            alignmentLine2 = alignmentLine;
            j3 = j;
            j4 = j2;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AlignmentLineOffsetTextUnitElement(alignmentLine2, j3, j4, noInspectorInfo, null));
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2502paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM();
        }
        return m2501paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2504paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
        }
        return m2503paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m2496alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        int iMax;
        int height;
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = placeableMo9625measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height2 = getHorizontal(alignmentLine) ? placeableMo9625measureBRTryo0.getHeight() : placeableMo9625measureBRTryo0.getWidth();
        int iM10969getMaxHeightimpl = (getHorizontal(alignmentLine) ? Constraints.m10969getMaxHeightimpl(j) : Constraints.m10970getMaxWidthimpl(j)) - height2;
        final int iCoerceIn = RangesKt.coerceIn((!Float.isNaN(f) ? measureScope.mo2185roundToPx0680j_4(f) : 0) - i, 0, iM10969getMaxHeightimpl);
        final int iCoerceIn2 = RangesKt.coerceIn(((!Float.isNaN(f2) ? measureScope.mo2185roundToPx0680j_4(f2) : 0) - height2) + i, 0, iM10969getMaxHeightimpl - iCoerceIn);
        if (getHorizontal(alignmentLine)) {
            iMax = placeableMo9625measureBRTryo0.getWidth();
        } else {
            iMax = Math.max(placeableMo9625measureBRTryo0.getWidth() + iCoerceIn + iCoerceIn2, Constraints.m10972getMinWidthimpl(j));
        }
        final int i2 = iMax;
        if (getHorizontal(alignmentLine)) {
            height = Math.max(placeableMo9625measureBRTryo0.getHeight() + iCoerceIn + iCoerceIn2, Constraints.m10971getMinHeightimpl(j));
        } else {
            height = placeableMo9625measureBRTryo0.getHeight();
        }
        final int i3 = height;
        return MeasureScope.layout$default(measureScope, i2, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AlignmentLineKt.alignmentLineOffsetMeasure_tjqqzMA$lambda$1(alignmentLine, f, iCoerceIn, i2, iCoerceIn2, placeableMo9625measureBRTryo0, i3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit alignmentLineOffsetMeasure_tjqqzMA$lambda$1(AlignmentLine alignmentLine, float f, int i, int i2, int i3, Placeable placeable, int i4, Placeable.PlacementScope placementScope) {
        int width;
        int i5;
        if (getHorizontal(alignmentLine)) {
            width = 0;
        } else {
            width = !C1486Dp.m11022equalsimpl0(f, C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM()) ? i : (i2 - i3) - placeable.getWidth();
        }
        if (getHorizontal(alignmentLine)) {
            if (C1486Dp.m11022equalsimpl0(f, C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM())) {
                i = (i4 - i3) - placeable.getHeight();
            }
            i5 = i;
        } else {
            i5 = 0;
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, i5, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m2501paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f2) {
        Modifier.Companion companionM2498paddingFrom4j6BHR0$default;
        Modifier.Companion companionM2498paddingFrom4j6BHR0$default2;
        if (!Float.isNaN(f)) {
            companionM2498paddingFrom4j6BHR0$default = m2498paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.p004ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null);
        } else {
            companionM2498paddingFrom4j6BHR0$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = modifier.then(companionM2498paddingFrom4j6BHR0$default);
        if (!Float.isNaN(f2)) {
            companionM2498paddingFrom4j6BHR0$default2 = m2498paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.p004ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null);
        } else {
            companionM2498paddingFrom4j6BHR0$default2 = Modifier.INSTANCE;
        }
        return modifierThen.then(companionM2498paddingFrom4j6BHR0$default2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m2503paddingFromBaselinewCyjxdI(Modifier modifier, long j, long j2) {
        Modifier.Companion companionM2500paddingFromY_r0B1c$default;
        Modifier modifierThen = modifier.then(TextUnit.m11209getRawTypeimpl(j) == 0 ? Modifier.INSTANCE : m2500paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.p004ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null));
        if (TextUnit.m11209getRawTypeimpl(j2) != 0) {
            companionM2500paddingFromY_r0B1c$default = m2500paddingFromY_r0B1c$default(Modifier.INSTANCE, androidx.compose.p004ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null);
        } else {
            companionM2500paddingFromY_r0B1c$default = Modifier.INSTANCE;
        }
        return modifierThen.then(companionM2500paddingFromY_r0B1c$default);
    }
}
