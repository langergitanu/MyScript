package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p004ui.graphics.GraphicsContext;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, m1599d2 = {"DebugLoggingEnabled", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "position", "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* JADX INFO: renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m3140measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int iM3139maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo != null ? lazyStaggeredGridLayoutInfo.getVisibleItemsInfo() : null, graphicsContext, null);
        int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length || (iM3139maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation[i6]) == -1) {
                    iM3139maxInRangejy6DScQ = i6 == 0 ? 0 : m3139maxInRangejy6DScQ(iArr, SpanRange.m3150constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = iM3139maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                if (i7 < scrollOffsets.length) {
                    i5 = scrollOffsets[i7];
                } else {
                    i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                }
                iArr2[i7] = i5;
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation(z4)), iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation, scrollOffsets, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x02f6, code lost:
    
        r6 = indexOfMinValue$default(r9, 0, 1, null);
        r7 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0301, code lost:
    
        if (r6 == r7) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0307, code lost:
    
        if (r9[r6] != r9[r7]) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0309, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x030b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x030c, code lost:
    
        r7 = r28[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x030f, code lost:
    
        if (r7 != (-1)) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0311, code lost:
    
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0312, code lost:
    
        r7 = findPreviousItemIndex(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0316, code lost:
    
        if (r7 >= 0) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0318, code lost:
    
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x031a, code lost:
    
        if (r1 != false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0320, code lost:
    
        if (measure$lambda$0$misalignedStart(r10, r0, r9, r6) == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0322, code lost:
    
        if (r50 == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0324, code lost:
    
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x032f, code lost:
    
        if (r3 >= r1) goto L563;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0331, code lost:
    
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0338, code lost:
    
        r1 = r9.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x033c, code lost:
    
        if (r4 >= r1) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x033e, code lost:
    
        r3[r4] = r9[r6];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x034c, code lost:
    
        return measure(r0, r27, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x034d, code lost:
    
        r11 = r27;
        r47 = r2;
        r28 = r3;
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0357, code lost:
    
        r11 = r27;
        r10 = r28;
        r26 = r1;
        r47 = r2;
        r1 = r0.m3134getSpanRangelOCCd4c(r0.getItemProvider(), r7, r6);
        r6 = r0.getLaneInfo();
        r30 = r12;
        r27 = r13;
        r12 = (int) (r1 & 4294967295L);
        r28 = r3;
        r13 = r4;
        r3 = (int) (r1 >> r18);
        r4 = r12 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x037b, code lost:
    
        if (r4 == 1) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x037d, code lost:
    
        r29 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0380, code lost:
    
        r29 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0382, code lost:
    
        if (r29 == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0384, code lost:
    
        r15 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0386, code lost:
    
        r15 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0387, code lost:
    
        r6.setLane(r7, r15);
        r6 = r0.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(r7, r1);
        r1 = m3139maxInRangejy6DScQ(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0397, code lost:
    
        if (r4 == 1) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0399, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x039b, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x039c, code lost:
    
        if (r2 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x039e, code lost:
    
        r2 = r0.getLaneInfo().getGaps(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03a7, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03a8, code lost:
    
        if (r3 >= r12) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03ac, code lost:
    
        if (r9[r3] == r1) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03ae, code lost:
    
        r26 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03b0, code lost:
    
        r48[r3].addFirst(r6);
        r10[r3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03b7, code lost:
    
        if (r2 != null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03b9, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03bb, code lost:
    
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03bd, code lost:
    
        r9[r3] = (r1 + r6.getMainAxisSizeWithSpacings()) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:332:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x071f A[LOOP:21: B:315:0x0671->B:356:0x071f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x08d5  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0731 A[EDGE_INSN: B:537:0x0731->B:358:0x0731 BREAK  A[LOOP:21: B:315:0x0671->B:356:0x071f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyStaggeredGridMeasureResult measure(final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        char c;
        int i2;
        int iIndexOf;
        int i3;
        int i4;
        int i5;
        int[] iArr3;
        int i6;
        int[] iArr4;
        int i7;
        int i8;
        int i9;
        int i10;
        String str;
        int i11;
        int i12;
        int[] iArr5;
        boolean z2;
        int i13;
        int i14;
        int i15;
        int i16;
        String str2;
        int[] iArr6;
        float f;
        int iM10987constrainWidthK40F9xA;
        int iM10969getMaxHeightimpl;
        int[] iArr7;
        List listEmptyList;
        int i17;
        List list;
        List<LazyStaggeredGridMeasuredItem> list2;
        int mainAxisSizeWithSpacings;
        ArrayList arrayList;
        float f2;
        int i18;
        int i19;
        boolean z3;
        boolean z4;
        boolean z5;
        ArrayList arrayList2;
        boolean z6;
        boolean z7;
        boolean z8;
        List<Integer> list3;
        int i20;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        ArrayList arrayList3;
        boolean z9;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        boolean z10;
        boolean z11;
        int i21;
        int[] gaps;
        int i22;
        int i23;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        final LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int iM10972getMinWidthimpl = Constraints.m10972getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints());
            int iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().onMeasured(0, iM10972getMinWidthimpl, iM10971getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long jM3073getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().m3073getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m11186equalsimpl0(jM3073getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                    iM10972getMinWidthimpl = ConstraintsKt.m10987constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM3073getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    iM10971getMinHeightimpl = ConstraintsKt.m10986constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM3073getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, iM10972getMinWidthimpl, iM10971getMinHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyStaggeredGridMeasureKt.measure$lambda$0$0((Placeable.PlacementScope) obj);
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.getIsVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.m11183constructorimpl((((long) Constraints.m10971getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints())) & 4294967295L) | (((long) Constraints.m10972getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints())) << 32)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        String str3 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf2, "copyOf(...)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, iArrCopyOf, itemCount);
        offsetBy(iArrCopyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
        for (int i24 = 0; i24 < laneCount; i24++) {
            arrayDequeArr[i24] = new ArrayDeque(16);
        }
        offsetBy(iArrCopyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z12 = false;
        while (true) {
            if (!measure$lambda$0$hasSpaceBeforeFirst(iArrCopyOf, iArrCopyOf2, lazyStaggeredGridMeasureContext2)) {
                c = TokenParser.f2383SP;
                i2 = 0;
                iIndexOf = -1;
                break;
            }
            iIndexOf = indexOfMaxValue(iArrCopyOf);
            c = TokenParser.f2383SP;
            int i25 = iArrCopyOf[iIndexOf];
            int length = iArrCopyOf2.length;
            for (int i26 = 0; i26 < length; i26++) {
                if (iArrCopyOf[i26] != iArrCopyOf[iIndexOf]) {
                    int i27 = iArrCopyOf2[i26];
                    int i28 = iArrCopyOf2[iIndexOf];
                    if (i27 < i28) {
                        iArrCopyOf2[i26] = i28;
                    }
                }
            }
            i2 = 0;
            int iFindPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i25, iIndexOf);
            if (iFindPreviousItemIndex < 0) {
                break;
            }
            long jM3134getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iFindPreviousItemIndex, iIndexOf);
            int i29 = (int) (jM3134getSpanRangelOCCd4c & 4294967295L);
            ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
            boolean z13 = z12;
            int i30 = (int) (jM3134getSpanRangelOCCd4c >> 32);
            int i31 = i29 - i30;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iFindPreviousItemIndex, i31 != 1 ? -2 : i30);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(iFindPreviousItemIndex, jM3134getSpanRangelOCCd4c);
            int iM3139maxInRangejy6DScQ = m3139maxInRangejy6DScQ(iArrCopyOf2, jM3134getSpanRangelOCCd4c);
            int[] gaps2 = i31 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(iFindPreviousItemIndex) : null;
            boolean z14 = z13;
            while (i30 < i29) {
                iArrCopyOf[i30] = iFindPreviousItemIndex;
                int mainAxisSizeWithSpacings2 = iM3139maxInRangejy6DScQ + lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i30]);
                iArrCopyOf2[i30] = mainAxisSizeWithSpacings2;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings2 <= 0) {
                    z14 = true;
                }
                i30++;
            }
            arrayDequeArr = arrayDequeArr2;
            z12 = z14;
        }
        ArrayDeque[] arrayDequeArr3 = arrayDequeArr;
        boolean z15 = z12;
        int i32 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i33 = iArrCopyOf2[i2];
        if (i33 < i32) {
            offsetBy(iArrCopyOf2, i32 - i33);
            i3 = i - (i32 - i33);
        } else {
            i3 = i;
        }
        offsetBy(iArrCopyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i34 = -1;
        if (iIndexOf == -1) {
            iIndexOf = ArraysKt.indexOf(iArrCopyOf, i2);
        }
        if (iIndexOf != -1 && measure$lambda$0$misalignedStart(iArrCopyOf, lazyStaggeredGridMeasureContext2, iArrCopyOf2, iIndexOf) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length2 = iArrCopyOf.length;
            int[] iArr8 = new int[length2];
            int i35 = 0;
            while (i35 < length2) {
                iArr8[i35] = i34;
                i35++;
                i34 = -1;
            }
            int length3 = iArrCopyOf2.length;
            int[] iArr9 = new int[length3];
            for (int i36 = 0; i36 < length3; i36++) {
                iArr9[i36] = iArrCopyOf2[iIndexOf];
            }
            return measure(lazyStaggeredGridMeasureContext2, i3, iArr8, iArr9, false);
        }
        int[] iArrCopyOf3 = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf3, "copyOf(...)");
        int length4 = iArrCopyOf2.length;
        int[] iArr10 = new int[length4];
        for (int i37 = 0; i37 < length4; i37++) {
            iArr10[i37] = -iArrCopyOf2[i37];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i32;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        int iIndexOfMinValue$default = indexOfMinValue$default(iArrCopyOf3, 0, 1, null);
        int laneCount2 = 0;
        boolean z16 = z15;
        for (int i38 = -1; iIndexOfMinValue$default != i38 && laneCount2 < lazyStaggeredGridMeasureContext2.getLaneCount(); i38 = -1) {
            int i39 = iArrCopyOf3[iIndexOfMinValue$default];
            int iIndexOfMinValue = indexOfMinValue(iArrCopyOf3, i39);
            laneCount2++;
            if (i39 >= 0) {
                int i40 = i3;
                long jM3134getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i39, iIndexOfMinValue$default);
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(i39, jM3134getSpanRangelOCCd4c2);
                ArrayDeque[] arrayDequeArr4 = arrayDequeArr3;
                LazyStaggeredGridLaneInfo laneInfo = lazyStaggeredGridMeasureContext2.getLaneInfo();
                int[] iArr11 = iArrCopyOf;
                int[] iArr12 = iArrCopyOf2;
                int i41 = (int) (jM3134getSpanRangelOCCd4c2 & 4294967295L);
                int i42 = itemCount;
                int i43 = (int) (jM3134getSpanRangelOCCd4c2 >> c);
                int i44 = i41 - i43;
                if (i44 != 1) {
                    i22 = i39;
                    i23 = -2;
                } else {
                    i22 = i39;
                    i23 = i43;
                }
                laneInfo.setLane(i22, i23);
                int iM3139maxInRangejy6DScQ2 = m3139maxInRangejy6DScQ(iArr10, jM3134getSpanRangelOCCd4c2);
                for (int i45 = i43; i45 < i41; i45++) {
                    iArr10[i45] = lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + iM3139maxInRangejy6DScQ2;
                    iArrCopyOf3[i45] = i22;
                    arrayDequeArr4[i45].addLast(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2);
                }
                if (iM3139maxInRangejy6DScQ2 < mainAxisSpacing && iArr10[i43] <= mainAxisSpacing) {
                    lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2.setVisible(false);
                    z16 = true;
                }
                laneCount2 = i44 != 1 ? lazyStaggeredGridMeasureContext2.getLaneCount() : laneCount2;
                arrayDequeArr3 = arrayDequeArr4;
                iIndexOfMinValue$default = iIndexOfMinValue;
                i3 = i40;
                iArrCopyOf = iArr11;
                iArrCopyOf2 = iArr12;
                itemCount = i42;
            } else {
                iIndexOfMinValue$default = iIndexOfMinValue;
            }
        }
        int i46 = i3;
        ArrayDeque[] arrayDequeArr5 = arrayDequeArr3;
        int[] iArr13 = iArrCopyOf;
        int[] iArr14 = iArrCopyOf2;
        int i47 = itemCount;
        loop9: while (true) {
            int i48 = 0;
            while (true) {
                if (i48 >= length4) {
                    for (int i49 = 0; i49 < laneCount; i49++) {
                        if (!arrayDequeArr5[i49].isEmpty()) {
                            i4 = i47;
                            i5 = 1;
                            break loop9;
                        }
                    }
                } else {
                    int i50 = iArr10[i48];
                    if (i50 < iCoerceAtLeast || i50 <= 0) {
                        break;
                    }
                    i48++;
                }
            }
            i5 = 1;
            int iIndexOfMinValue$default2 = indexOfMinValue$default(iArr10, 0, 1, null);
            int iMaxOrThrow = ArraysKt.maxOrThrow(iArrCopyOf3) + 1;
            i4 = i47;
            if (iMaxOrThrow >= i4) {
                break;
            }
            int i51 = length4;
            String str4 = str3;
            ArrayDeque[] arrayDequeArr6 = arrayDequeArr5;
            int i52 = iCoerceAtLeast;
            boolean z17 = z16;
            int i53 = i46;
            long jM3134getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iMaxOrThrow, iIndexOfMinValue$default2);
            int[] iArr15 = iArrCopyOf3;
            int i54 = (int) (jM3134getSpanRangelOCCd4c3 & 4294967295L);
            int i55 = (int) (jM3134getSpanRangelOCCd4c3 >> c);
            int i56 = i54 - i55;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(iMaxOrThrow, i56 != 1 ? -2 : i55);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(iMaxOrThrow, jM3134getSpanRangelOCCd4c3);
            int iM3139maxInRangejy6DScQ3 = m3139maxInRangejy6DScQ(iArr10, jM3134getSpanRangelOCCd4c3);
            if (i56 != 1) {
                gaps = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iMaxOrThrow);
                if (gaps == null) {
                    gaps = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                gaps = null;
            }
            for (int i57 = i55; i57 < i54; i57++) {
                if (gaps != null) {
                    gaps[i57] = iM3139maxInRangejy6DScQ3 - iArr10[i57];
                }
                iArr15[i57] = iMaxOrThrow;
                iArr10[i57] = iM3139maxInRangejy6DScQ3 + lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                arrayDequeArr6[i57].addLast(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(iMaxOrThrow, gaps);
            if (iM3139maxInRangejy6DScQ3 < mainAxisSpacing && iArr10[i55] <= mainAxisSpacing) {
                lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ3.setVisible(false);
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            iArrCopyOf3 = iArr15;
            iCoerceAtLeast = i52;
            i47 = i4;
            str3 = str4;
            z16 = z17;
            arrayDequeArr5 = arrayDequeArr6;
            length4 = i51;
            i46 = i53;
        }
        int i58 = 0;
        while (i58 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr5[i58];
            while (arrayDeque.size() > i5 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIsVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps3 = lazyStaggeredGridMeasuredItem.getSpan() != i5 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr14[i58] = iArr14[i58] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i58]));
                i5 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr13[i58] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i58++;
            i5 = 1;
        }
        int length5 = iArrCopyOf3.length;
        int i59 = 0;
        while (true) {
            if (i59 >= length5) {
                break;
            }
            if (iArrCopyOf3[i59] == i4 - 1) {
                offsetBy(iArr10, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            }
            i59++;
        }
        int i60 = 0;
        while (true) {
            if (i60 < length4) {
                if (iArr10[i60] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i8 = i4;
                    i11 = i46;
                    i6 = i11;
                    iArr4 = iArr13;
                    iArr3 = iArr14;
                    i9 = iCoerceAtLeast;
                    i10 = length4;
                    str = str3;
                    break;
                }
                i60++;
            } else {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr10[indexOfMaxValue(iArr10)];
                iArr3 = iArr14;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr10, mainAxisAvailableSize);
                boolean z18 = false;
                loop31: while (true) {
                    int length6 = iArr3.length;
                    int i61 = 0;
                    while (true) {
                        if (i61 >= length6) {
                            i6 = i46;
                            iArr4 = iArr13;
                            i7 = mainAxisAvailableSize;
                            i8 = i4;
                            i9 = iCoerceAtLeast;
                            break loop31;
                        }
                        if (iArr3[i61] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        }
                        i61++;
                        length4 = length4;
                        iArr13 = iArr13;
                        i46 = i46;
                    }
                    mainAxisAvailableSize = i13;
                    str3 = str2;
                    z18 = z2;
                    length4 = i15;
                    iCoerceAtLeast = i16;
                    i4 = i14;
                    iArr13 = iArr5;
                    i46 = i12;
                }
                i10 = length4;
                str = str3;
                if (z18 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i6, iArr4, iArr3, false);
                }
                i11 = i6 + i7;
                int i62 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i62 < 0) {
                    i11 += i62;
                    offsetBy(iArr10, i62);
                    offsetBy(iArr3, -i62);
                }
            }
        }
        float fScrollToBeConsumed$foundation = lazyStaggeredGridMeasureContext2.getState().scrollToBeConsumed$foundation(measureScope.isLookingAhead());
        if (MathKt.getSign(Math.round(fScrollToBeConsumed$foundation)) != MathKt.getSign(i11) || Math.abs(Math.round(fScrollToBeConsumed$foundation)) < Math.abs(i11)) {
            iArr6 = iArr4;
            f = fScrollToBeConsumed$foundation;
        } else {
            iArr6 = iArr4;
            f = i11;
        }
        float f3 = fScrollToBeConsumed$foundation - f;
        float f4 = 0.0f;
        if (measureScope.isLookingAhead() && i11 > i6 && f3 <= 0.0f) {
            f4 = (i11 - i6) + f3;
        }
        float f5 = f4;
        int[] iArrCopyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf4, str);
        int length7 = iArrCopyOf4.length;
        for (int i63 = 0; i63 < length7; i63++) {
            iArrCopyOf4[i63] = -iArrCopyOf4[i63];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i64 = 0; i64 < laneCount; i64++) {
                ArrayDeque arrayDeque2 = arrayDequeArr5[i64];
                int size = arrayDeque2.size();
                int i65 = 0;
                while (i65 < size) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i65);
                    int[] gaps4 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings3 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[i64]);
                    if (i65 == CollectionsKt.getLastIndex(arrayDeque2) || (i21 = iArr3[i64]) == 0 || i21 < mainAxisSizeWithSpacings3) {
                        break;
                    }
                    iArr3[i64] = i21 - mainAxisSizeWithSpacings3;
                    i65++;
                    iArr6[i64] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i65)).getIndex();
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            iM10987constrainWidthK40F9xA = Constraints.m10970getMaxWidthimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        } else {
            iM10987constrainWidthK40F9xA = ConstraintsKt.m10987constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr10) + beforeContentPadding);
        }
        int i66 = iM10987constrainWidthK40F9xA;
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            iM10969getMaxHeightimpl = ConstraintsKt.m10986constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr10) + beforeContentPadding);
        } else {
            iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        }
        int i67 = iM10969getMaxHeightimpl;
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.getIsVertical() ? i67 : i66, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i68 = iArrCopyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int i69 = -1;
        int size2 = pinnedItems.size() - 1;
        if (size2 >= 0) {
            int i70 = size2;
            ArrayList arrayList4 = null;
            while (true) {
                int i71 = i70 - 1;
                int iIntValue = pinnedItems.get(i70).intValue();
                int lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue);
                int i72 = i68;
                if (lane == -2 || lane == i69) {
                    for (int i73 = 0; i73 < laneCount; i73++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[i73].firstOrNull();
                        if (!((lazyStaggeredGridMeasuredItem4 != null ? lazyStaggeredGridMeasuredItem4.getIndex() : -1) > iIntValue)) {
                            z11 = false;
                            break;
                        }
                    }
                    z11 = true;
                } else {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[lane].firstOrNull();
                    if ((lazyStaggeredGridMeasuredItem5 != null ? lazyStaggeredGridMeasuredItem5.getIndex() : -1) <= iIntValue) {
                        z11 = false;
                        break;
                    }
                    z11 = true;
                }
                if (z11) {
                    iArr7 = iArrCopyOf4;
                    long jM3134getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue, 0);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(iIntValue, jM3134getSpanRangelOCCd4c4);
                    int mainAxisSizeWithSpacings4 = i72 - lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings();
                    lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ4.position(mainAxisSizeWithSpacings4, 0, afterContentPadding);
                    arrayList4.add(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ4);
                    i68 = mainAxisSizeWithSpacings4;
                } else {
                    iArr7 = iArrCopyOf4;
                    i68 = i72;
                }
                if (i71 < 0) {
                    break;
                }
                iArrCopyOf4 = iArr7;
                i70 = i71;
                i69 = -1;
            }
            listEmptyList = arrayList4;
        } else {
            iArr7 = iArrCopyOf4;
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        int[] iArr16 = iArr7;
        List list4 = listEmptyList;
        int i74 = i9;
        List<LazyStaggeredGridMeasuredItem> listCalculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr5, iArr16, afterContentPadding, i32, i74);
        int i75 = iArr16[0];
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull((List) listCalculateVisibleItems);
        int index2 = lazyStaggeredGridMeasuredItem6 != null ? lazyStaggeredGridMeasuredItem6.getIndex() : -1;
        if (!measureScope.isLookingAhead() || lazyStaggeredGridMeasureContext2.getApproachVisibleItems() == null || lazyStaggeredGridMeasureContext2.getApproachVisibleItems().isEmpty()) {
            i17 = beforeContentPadding;
            list = list4;
            list2 = listCalculateVisibleItems;
            mainAxisSizeWithSpacings = i75;
            arrayList = null;
        } else {
            List<LazyStaggeredGridItemInfo> approachVisibleItems = lazyStaggeredGridMeasureContext2.getApproachVisibleItems();
            for (int size3 = approachVisibleItems.size() - 1; -1 < size3; size3--) {
                if (approachVisibleItems.get(size3).getIndex() > index2 && (size3 == 0 || approachVisibleItems.get(size3 - 1).getIndex() <= index2)) {
                    lazyStaggeredGridItemInfo = approachVisibleItems.get(size3);
                    break;
                }
            }
            lazyStaggeredGridItemInfo = null;
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext2.getApproachVisibleItems());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (iMin = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i8 - 1))) {
                int i76 = index;
                mainAxisSizeWithSpacings = i75;
                arrayList = null;
                while (true) {
                    if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i77 = 0;
                        while (true) {
                            if (i77 >= size4) {
                                arrayList3 = arrayList;
                                z10 = false;
                                break;
                            }
                            arrayList3 = arrayList;
                            if (((LazyStaggeredGridMeasuredItem) arrayList.get(i77)).getIndex() == i76) {
                                z10 = true;
                                break;
                            }
                            i77++;
                            arrayList = arrayList3;
                        }
                        z9 = z10;
                        if (z9) {
                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                            List<LazyStaggeredGridItemInfo> approachVisibleItems2 = lazyStaggeredGridMeasureContext2.getApproachVisibleItems();
                            int size5 = approachVisibleItems2.size();
                            i17 = beforeContentPadding;
                            int i78 = 0;
                            while (true) {
                                if (i78 >= size5) {
                                    lazyStaggeredGridItemInfo2 = null;
                                    break;
                                }
                                lazyStaggeredGridItemInfo2 = approachVisibleItems2.get(i78);
                                int i79 = i78;
                                if (lazyStaggeredGridItemInfo2.getIndex() == i76) {
                                    break;
                                }
                                i78 = i79 + 1;
                            }
                            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                            int lane2 = lazyStaggeredGridItemInfo4 != null ? lazyStaggeredGridItemInfo4.getLane() : 0;
                            list = list4;
                            list2 = listCalculateVisibleItems;
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(i76, lazyStaggeredGridMeasureContext2.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i76, lane2));
                            arrayList.add(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ5);
                            int[] positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                            lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ5.position(mainAxisSizeWithSpacings, positions.length > lane2 ? positions[lane2] : 0, afterContentPadding);
                            mainAxisSizeWithSpacings += lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                        } else {
                            i17 = beforeContentPadding;
                            list = list4;
                            list2 = listCalculateVisibleItems;
                            arrayList = arrayList3;
                        }
                        if (i76 != iMin) {
                            break;
                        }
                        i76++;
                        beforeContentPadding = i17;
                        list4 = list;
                        listCalculateVisibleItems = list2;
                    } else {
                        arrayList3 = arrayList;
                    }
                    if (z9) {
                    }
                    if (i76 != iMin) {
                    }
                }
            }
        }
        List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size6 = pinnedItems2.size();
        int i80 = 0;
        ArrayList arrayListEmptyList = null;
        while (i80 < size6) {
            int iIntValue2 = pinnedItems2.get(i80).intValue();
            int i81 = i8;
            if (iIntValue2 >= i81) {
                arrayList2 = arrayList;
            } else {
                if (arrayList != null) {
                    int size7 = arrayList.size();
                    int i82 = 0;
                    while (true) {
                        if (i82 >= size7) {
                            arrayList2 = arrayList;
                            z8 = false;
                            break;
                        }
                        arrayList2 = arrayList;
                        if (((LazyStaggeredGridMeasuredItem) arrayList.get(i82)).getIndex() == iIntValue2) {
                            z8 = true;
                            break;
                        }
                        i82++;
                        arrayList = arrayList2;
                    }
                    z6 = z8;
                    if (!z6) {
                        z7 = false;
                        break;
                    }
                    int lane3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue2);
                    if (lane3 == -2 || lane3 == -1) {
                        for (int i83 : iArrCopyOf3) {
                            if (i83 < iIntValue2) {
                            }
                        }
                        z7 = true;
                    } else {
                        if (iArrCopyOf3[lane3] >= iIntValue2) {
                            z7 = false;
                            break;
                        }
                        z7 = true;
                    }
                    if (z7) {
                        list3 = pinnedItems2;
                        i20 = size6;
                        long jM3134getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = new ArrayList();
                        }
                        List list5 = arrayListEmptyList;
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ6 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(iIntValue2, jM3134getSpanRangelOCCd4c5);
                        lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ6.position(mainAxisSizeWithSpacings, 0, afterContentPadding);
                        mainAxisSizeWithSpacings += lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ6.getMainAxisSizeWithSpacings();
                        list5.add(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ6);
                        arrayListEmptyList = list5;
                    } else {
                        list3 = pinnedItems2;
                        i20 = size6;
                    }
                    i80++;
                    lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
                    arrayList = arrayList2;
                    pinnedItems2 = list3;
                    size6 = i20;
                    i8 = i81;
                } else {
                    arrayList2 = arrayList;
                }
                if (!z6) {
                    z7 = false;
                    break;
                }
                if (z7) {
                }
                i80++;
                lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
                arrayList = arrayList2;
                pinnedItems2 = list3;
                size6 = i20;
                i8 = i81;
            }
            z7 = false;
            if (z7) {
            }
            i80++;
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            arrayList = arrayList2;
            pinnedItems2 = list3;
            size6 = i20;
            i8 = i81;
        }
        ArrayList arrayList5 = arrayList;
        int i84 = i8;
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        final ArrayList arrayList6 = new ArrayList();
        arrayList6.addAll(list);
        arrayList6.addAll(list2);
        if (arrayList5 != null) {
            arrayList6.addAll(arrayList5);
        }
        arrayList6.addAll(arrayListEmptyList);
        lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().onMeasured((int) f, i66, i67, arrayList6, lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr10) + i17, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
        if (!measureScope.isLookingAhead()) {
            long jM3073getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().m3073getMinSizeToFitDisappearingItemsYbymL2g();
            if (IntSize.m11186equalsimpl0(jM3073getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                f2 = f5;
                i18 = i67;
                i19 = i66;
            } else {
                int i85 = lazyStaggeredGridMeasureContext.getIsVertical() ? i67 : i66;
                f2 = f5;
                int iM10987constrainWidthK40F9xA2 = ConstraintsKt.m10987constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), Math.max(i66, (int) (jM3073getMinSizeToFitDisappearingItemsYbymL2g2 >> c)));
                int iM10986constrainHeightK40F9xA = ConstraintsKt.m10986constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), Math.max(i67, (int) (jM3073getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i86 = lazyStaggeredGridMeasureContext.getIsVertical() ? iM10986constrainHeightK40F9xA : iM10987constrainWidthK40F9xA2;
                if (i86 != i85) {
                    int size8 = arrayList6.size();
                    for (int i87 = 0; i87 < size8; i87++) {
                        ((LazyStaggeredGridMeasuredItem) arrayList6.get(i87)).updateMainAxisLayoutSize(i86);
                    }
                }
                i19 = iM10987constrainWidthK40F9xA2;
                i18 = iM10986constrainHeightK40F9xA;
            }
        }
        int i88 = i10;
        int i89 = 0;
        while (true) {
            if (i89 >= i88) {
                z3 = false;
                break;
            }
            if (iArr10[i89] > lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                z3 = true;
                break;
            }
            i89++;
        }
        if (!z3) {
            int length8 = iArrCopyOf3.length;
            int i90 = 0;
            while (true) {
                if (i90 >= length8) {
                    z5 = true;
                    break;
                }
                if (!(iArrCopyOf3[i90] < i84 + (-1))) {
                    z5 = false;
                    break;
                }
                i90++;
            }
            z4 = z5;
        }
        final boolean reverseLayout = lazyStaggeredGridMeasureContext.getReverseLayout();
        final long contentOffset = lazyStaggeredGridMeasureContext.getContentOffset();
        return new LazyStaggeredGridMeasureResult(iArr6, iArr3, f, MeasureScope.layout$default(measureScope, i19, i18, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37(lazyStaggeredGridMeasureContext, arrayList6, reverseLayout, contentOffset, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null), f2, z4, lazyStaggeredGridMeasureContext.getIsVertical(), z16, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, i84, list2, IntSize.m11183constructorimpl((((long) i19) << c) | (((long) i18) & 4294967295L)), i32, i74, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$0$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$0$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final boolean z, final long j, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(list, z, j, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m3096attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m3148getPlacementScopeInvalidatorzYiylxw$foundation());
        return Unit.INSTANCE;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        int size = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            size += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i4 = -1;
                    int i5 = Integer.MAX_VALUE;
                    for (int i6 = 0; i6 < length; i6++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemFirstOrNull = arrayDequeArr[i6].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItemFirstOrNull != null ? lazyStaggeredGridMeasuredItemFirstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i5 > index) {
                            i4 = i6;
                            i5 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemRemoveFirst = arrayDequeArr[i4].removeFirst();
                    if (lazyStaggeredGridMeasuredItemRemoveFirst.getLane() == i4) {
                        long jM3150constructorimpl = SpanRange.m3150constructorimpl(lazyStaggeredGridMeasuredItemRemoveFirst.getLane(), lazyStaggeredGridMeasuredItemRemoveFirst.getSpan());
                        int iM3139maxInRangejy6DScQ = m3139maxInRangejy6DScQ(iArr, jM3150constructorimpl);
                        int i7 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i4];
                        if (lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSize() + iM3139maxInRangejy6DScQ >= i2 && iM3139maxInRangejy6DScQ <= i3) {
                            lazyStaggeredGridMeasuredItemRemoveFirst.position(iM3139maxInRangejy6DScQ, i7, i);
                            arrayList.add(lazyStaggeredGridMeasuredItemRemoveFirst);
                        }
                        int i8 = (int) (jM3150constructorimpl & 4294967295L);
                        for (int i9 = (int) (jM3150constructorimpl >> 32); i9 < i8; i9++) {
                            iArr[i9] = lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSizeWithSpacings() + iM3139maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2, boolean z, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> function2) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        int size;
        int i3;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        if (z && lazyStaggeredGridMeasureContext.getApproachVisibleItems() != null && !lazyStaggeredGridMeasureContext.getApproachVisibleItems().isEmpty()) {
            List<LazyStaggeredGridItemInfo> approachVisibleItems = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
            int size2 = approachVisibleItems.size();
            while (true) {
                size2--;
                if (-1 >= size2) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                }
                if (approachVisibleItems.get(size2).getIndex() > i && (size2 == 0 || approachVisibleItems.get(size2 - 1).getIndex() <= i)) {
                    break;
                }
            }
            lazyStaggeredGridItemInfo = approachVisibleItems.get(size2);
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext.getApproachVisibleItems());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (iMin = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i2 - 1))) {
                ArrayList arrayList = null;
                while (true) {
                    if (arrayList == null) {
                        if (arrayList == null) {
                        }
                        List<LazyStaggeredGridItemInfo> approachVisibleItems2 = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
                        size = approachVisibleItems2.size();
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                            }
                            i3++;
                        }
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                        if (lazyStaggeredGridItemInfo4 == null) {
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                        arrayList.add(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ);
                        int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                        function2.invoke(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
                    } else {
                        int size3 = arrayList.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            if (arrayList.get(i4).getIndex() == index) {
                                break;
                            }
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        List<LazyStaggeredGridItemInfo> approachVisibleItems22 = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
                        size = approachVisibleItems22.size();
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                lazyStaggeredGridItemInfo2 = null;
                                break;
                            }
                            lazyStaggeredGridItemInfo2 = approachVisibleItems22.get(i3);
                            if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                break;
                            }
                            i3++;
                        }
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo42 = lazyStaggeredGridItemInfo2;
                        int lane = lazyStaggeredGridItemInfo42 == null ? lazyStaggeredGridItemInfo42.getLane() : 0;
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                        arrayList.add(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2);
                        int[] positions2 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                        function2.invoke(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2, Integer.valueOf(positions2.length > lane ? positions2[lane] : 0));
                    }
                    if (index == iMin) {
                        return arrayList;
                    }
                    index++;
                }
            }
        }
        return null;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int iIntValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                        long jM3134getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(iIntValue, jM3134getSpanRangelOCCd4c);
                        function1.invoke(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ);
                        arrayList.add(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iIntValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(iIntValue2)).booleanValue()) {
                    long jM3134getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m3134getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m3143getAndMeasurejy6DScQ(iIntValue2, jM3134getSpanRangelOCCd4c2);
                    function1.invoke(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2);
                    arrayList.add(lazyStaggeredGridMeasuredItemM3143getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m3138forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m3139maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            iMax = Math.max(iMax, iArr[i2]);
        }
        return iMax;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int iIntValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > iIntValue) {
                i = i3;
                i2 = iIntValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            int i3 = iArr[length];
            if (i3 >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), i3)) {
                if (lazyStaggeredGridMeasureContext.getLaneInfo().getLane(i3) == -2) {
                    int length2 = iArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i4 = -1;
                            break;
                        } else if (iArr[i4] == i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int i5 = i4 + 1;
                    if (i5 <= length) {
                        while (true) {
                            if (iArr[i5] == i3) {
                                iArr[i5] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i3, i5);
                            }
                            if (i5 == length) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                    length = i4;
                }
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i3, length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke(list.get(size));
                if (i < 0) {
                    return;
                } else {
                    size = i;
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                } else {
                    size = i2;
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37$0(List list, boolean z, long j, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).m3146placeGMOY1bU(placementScope, z, j, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }
}
