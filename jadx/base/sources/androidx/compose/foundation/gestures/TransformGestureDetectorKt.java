package androidx.compose.foundation.gestures;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.spatial.RectListKt;
import androidx.constraintlayout.motion.widget.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: TransformGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u000f\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\u0011\u001a\u0013\u0010\u0012\u001a\u00020\f*\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\f*\u00020\u0011\u001a\u000f\u0010\u0016\u001a\u00020\u0007*\u00020\u0011¢\u0006\u0002\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\f*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b\u001a/\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u001dH\u0000¢\u0006\u0002\u0010\u001f¨\u0006 "}, m1599d2 = {"detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "", "onGesture", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "", "zoom", Key.ROTATION, "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRotation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "angle", "angle-k-4lQ0M", "(J)F", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateCentroidSize", "useCurrent", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "pointerInputChangeMatcher", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Landroidx/compose/ui/input/pointer/PointerEvent;ZLkotlin/jvm/functions/Function1;)J", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2 */
    /* JADX INFO: compiled from: TransformGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", m1609f = "TransformGestureDetector.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m1611l = {60, RectListKt.BitOffsetForGesturable}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, m1615s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"}, m1616v = 1)
    static final class C04552 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04552(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super C04552> continuation) {
            super(2, continuation);
            this.$panZoomLock = z;
            this.$onGesture = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04552 c04552 = new C04552(this.$panZoomLock, this.$onGesture, continuation);
            c04552.L$0 = obj;
            return c04552;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C04552) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x009e, code lost:
        
            if (r3 == r1) goto L16;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0163  */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [int] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x009e -> B:17:0x00a1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            float f;
            float f2;
            int i;
            long jM7908plusMKHz9U;
            AwaitPointerEventScope awaitPointerEventScope;
            float f3;
            int i2;
            float f4;
            Object objAwaitPointerEvent$default;
            ?? r4;
            Object obj2;
            int i3;
            float f5;
            int i4;
            int size;
            int i5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = this.label;
            float f6 = 1.0f;
            int i7 = 2;
            float f7 = 0.0f;
            boolean z = false;
            int i8 = 1;
            if (i6 == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
                float touchSlop = awaitPointerEventScope2.getViewConfiguration().getTouchSlop();
                this.L$0 = awaitPointerEventScope2;
                this.F$0 = 0.0f;
                this.F$1 = 1.0f;
                this.J$0 = jM7919getZeroF1C5BW0;
                this.I$0 = 0;
                this.F$2 = touchSlop;
                this.I$1 = 0;
                this.label = 1;
                if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null) != coroutine_suspended) {
                    f = 1.0f;
                    f2 = 0.0f;
                    i = 0;
                    jM7908plusMKHz9U = jM7919getZeroF1C5BW0;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    f3 = touchSlop;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                f3 = this.F$2;
                i = this.I$0;
                jM7908plusMKHz9U = this.J$0;
                f = this.F$1;
                f2 = this.F$0;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                f4 = 1.0f;
                objAwaitPointerEvent$default = obj;
                PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size2 = changes.size();
                float f8 = f7;
                ?? r5 = z;
                while (true) {
                    if (r5 >= size2) {
                        r4 = z;
                        break;
                    }
                    if (changes.get(r5).isConsumed()) {
                        r4 = i8;
                        break;
                    }
                    r5++;
                }
                if (r4 == 0) {
                    float fCalculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent);
                    float fCalculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent);
                    f5 = f3;
                    long jCalculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent);
                    if (i == 0) {
                        f *= fCalculateZoom;
                        f2 += fCalculateRotation;
                        jM7908plusMKHz9U = Offset.m7908plusMKHz9U(jM7908plusMKHz9U, jCalculatePan);
                        float fCalculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent, z);
                        obj2 = coroutine_suspended;
                        i3 = 1;
                        float fAbs = Math.abs(1 - f) * fCalculateCentroidSize;
                        float fAbs2 = Math.abs(((3.1415927f * f2) * fCalculateCentroidSize) / 180.0f);
                        float fM7901getDistanceimpl = Offset.m7901getDistanceimpl(jM7908plusMKHz9U);
                        if (fAbs > f5 || fAbs2 > f5 || fM7901getDistanceimpl > f5) {
                            i2 = (!this.$panZoomLock || fAbs2 >= f5) ? 0 : 1;
                            i = 1;
                        }
                    } else {
                        obj2 = coroutine_suspended;
                        i3 = 1;
                    }
                    if (i != 0) {
                        long jCalculateCentroid = TransformGestureDetectorKt.calculateCentroid(pointerEvent, false);
                        if (i2 != 0) {
                            fCalculateRotation = f8;
                        }
                        if (fCalculateRotation == f8 && fCalculateZoom == f4) {
                            i4 = i2;
                            if (!Offset.m7900equalsimpl0(jCalculatePan, Offset.INSTANCE.m7919getZeroF1C5BW0())) {
                            }
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            size = changes2.size();
                            for (i5 = 0; i5 < size; i5++) {
                                PointerInputChange pointerInputChange = changes2.get(i5);
                                if (PointerEventKt.positionChanged(pointerInputChange)) {
                                    pointerInputChange.consume();
                                }
                            }
                        } else {
                            i4 = i2;
                        }
                        this.$onGesture.invoke(Offset.m7892boximpl(jCalculateCentroid), Offset.m7892boximpl(jCalculatePan), Boxing.boxFloat(fCalculateZoom), Boxing.boxFloat(fCalculateRotation));
                        List<PointerInputChange> changes22 = pointerEvent.getChanges();
                        size = changes22.size();
                        while (i5 < size) {
                        }
                    } else {
                        i4 = i2;
                    }
                    i2 = i4;
                } else {
                    obj2 = coroutine_suspended;
                    i3 = i8;
                    f5 = f3;
                }
                if (r4 == 0) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    for (int i9 = 0; i9 < size3; i9++) {
                        if (changes3.get(i9).getPressed()) {
                            f3 = f5;
                            i8 = i3;
                            f6 = f4;
                            f7 = f8;
                            coroutine_suspended = obj2;
                            i7 = 2;
                            z = false;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            i2 = this.I$1;
            f3 = this.F$2;
            i = this.I$0;
            jM7908plusMKHz9U = this.J$0;
            f = this.F$1;
            f2 = this.F$0;
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = awaitPointerEventScope;
            this.F$0 = f2;
            this.F$1 = f;
            this.J$0 = jM7908plusMKHz9U;
            this.I$0 = i;
            this.F$2 = f3;
            this.I$1 = i2;
            this.label = i7;
            f4 = f6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, i8, null);
        }
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C04552(z, function4, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        long jCalculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < size2; i4++) {
            PointerInputChange pointerInputChange2 = changes2.get(i4);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long position = pointerInputChange2.getPosition();
                long jM7907minusMKHz9U = Offset.m7907minusMKHz9U(pointerInputChange2.getPreviousPosition(), jCalculateCentroid2);
                long jM7907minusMKHz9U2 = Offset.m7907minusMKHz9U(position, jCalculateCentroid);
                float fM2425anglek4lQ0M = m2425anglek4lQ0M(jM7907minusMKHz9U2) - m2425anglek4lQ0M(jM7907minusMKHz9U);
                float fM7901getDistanceimpl = Offset.m7901getDistanceimpl(Offset.m7908plusMKHz9U(jM7907minusMKHz9U2, jM7907minusMKHz9U)) / 2.0f;
                if (fM2425anglek4lQ0M > 180.0f) {
                    fM2425anglek4lQ0M -= 360.0f;
                } else if (fM2425anglek4lQ0M < -180.0f) {
                    fM2425anglek4lQ0M += 360.0f;
                }
                f2 += fM2425anglek4lQ0M * fM7901getDistanceimpl;
                f += fM7901getDistanceimpl;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        float fCalculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float fCalculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (fCalculateCentroidSize == 0.0f || fCalculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return fCalculateCentroidSize / fCalculateCentroidSize2;
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        if (Offset.m7900equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m7918getUnspecifiedF1C5BW0())) {
            return Offset.INSTANCE.m7919getZeroF1C5BW0();
        }
        return Offset.m7907minusMKHz9U(jCalculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, z);
        float fM7901getDistanceimpl = 0.0f;
        if (Offset.m7900equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m7918getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                fM7901getDistanceimpl += Offset.m7901getDistanceimpl(Offset.m7907minusMKHz9U(z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition(), jCalculateCentroid));
                i++;
            }
        }
        return fM7901getDistanceimpl / i;
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z) {
        return calculateCentroid(pointerEvent, z, new Function1() { // from class: androidx.compose.foundation.gestures.TransformGestureDetectorKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformGestureDetectorKt.calculateCentroid$lambda$0((PointerInputChange) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean calculateCentroid$lambda$0(PointerInputChange pointerInputChange) {
        return pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed();
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z, function1);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z, Function1<? super PointerInputChange, Boolean> function1) {
        long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (function1.invoke(pointerInputChange).booleanValue()) {
                jM7919getZeroF1C5BW0 = Offset.m7908plusMKHz9U(jM7919getZeroF1C5BW0, z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition());
                i++;
            }
        }
        if (i == 0) {
            return Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        }
        return Offset.m7898divtuRUvjQ(jM7919getZeroF1C5BW0, i);
    }

    /* JADX INFO: renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m2425anglek4lQ0M(long j) {
        if (Float.intBitsToFloat((int) (j >> 32)) == 0.0f && Float.intBitsToFloat((int) (j & 4294967295L)) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Float.intBitsToFloat(r0), Float.intBitsToFloat((int) (j & 4294967295L))))) * 180.0f) / 3.1415927f;
    }
}
