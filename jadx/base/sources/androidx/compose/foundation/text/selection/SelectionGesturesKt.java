package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.platform.ViewConfiguration;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SelectionGestures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080@¢\u0006\u0002\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001a*\u0010\u0015\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0017\u001a*\u0010\u0018\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u0013*\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001e\u001a \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"STATIC_KEY", "", "updateSelectionTouchMode", "Landroidx/compose/ui/Modifier;", "updateTouchMode", "Lkotlin/Function1;", "", "", "awaitSelectionGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "observer", "downEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionSubsequentPress", "clicks", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m1609f = "SelectionGestures.kt", m1610i = {0}, m1611l = {340}, m1612m = "awaitDown", m1613n = {"$this$awaitDown"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C07951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07951(Continuation<? super C07951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.awaitDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m1609f = "SelectionGestures.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {267, 294}, m1612m = "mouseSelection", m1613n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer", "dragConsumed"}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C07971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C07971(Continuation<? super C07971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.mouseSelection(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m1609f = "SelectionGestures.kt", m1610i = {0, 0, 0, 1, 1}, m1611l = {PDFACompliance.e_PDFA1_4_1, 145}, m1612m = "touchSelectionFirstPress", m1613n = {"$this$touchSelectionFirstPress", "observer", "firstDown", "$this$touchSelectionFirstPress", "observer"}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1"}, m1616v = 1)
    static final class C07981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C07981(Continuation<? super C07981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionFirstPress(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m1609f = "SelectionGestures.kt", m1610i = {0, 0, 0, 0, 1, 1}, m1611l = {193, PDFACompliance.e_PDFA2_3_2}, m1612m = "touchSelectionSubsequentPress", m1613n = {"$this$touchSelectionSubsequentPress", "observer", "overSlop", "pointerId", "$this$touchSelectionSubsequentPress", "observer"}, m1615s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1"}, m1616v = 1)
    static final class C07991 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C07991(Continuation<? super C07991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionSubsequentPress(null, null, null, 0, this);
        }
    }

    public static final Modifier updateSelectionTouchMode(Modifier modifier, final Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf(STATIC_KEY), new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt.updateSelectionTouchMode.1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: SelectionGestures.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", m1609f = "SelectionGestures.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA9_4}, m1612m = "invokeSuspend", m1613n = {"$this$awaitPointerEventScope"}, m1615s = {"L$0"}, m1616v = 1)
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$updateTouchMode = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updateTouchMode, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:12:0x0033). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r4.label
                        r2 = 1
                        if (r1 == 0) goto L1b
                        if (r1 != r2) goto L13
                        java.lang.Object r1 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r5)
                        goto L33
                    L13:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r0)
                        throw r5
                    L1b:
                        kotlin.ResultKt.throwOnFailure(r5)
                        java.lang.Object r5 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r5
                        r1 = r5
                    L23:
                        androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.p004ui.input.pointer.PointerEventPass.Initial
                        r3 = r4
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4.L$0 = r1
                        r4.label = r2
                        java.lang.Object r5 = r1.awaitPointerEvent(r5, r3)
                        if (r5 != r0) goto L33
                        return r0
                    L33:
                        androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.p004ui.input.pointer.PointerEvent) r5
                        kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r4.$updateTouchMode
                        boolean r5 = androidx.compose.foundation.text.selection.SelectionGestures_androidKt.isMouseOrTouchPad(r5)
                        r5 = r5 ^ r2
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r3.invoke(r5)
                        goto L23
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.C08021.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.p004ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass1(function1, null), continuation);
                return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitSelectionGestures$2 */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitSelectionGestures$2", m1609f = "SelectionGestures.kt", m1610i = {0}, m1611l = {111, 119, PDFACompliance.e_PDFA1_2_2, 124}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C07962 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ClicksCounter $clicksCounter;
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07962(ClicksCounter clicksCounter, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super C07962> continuation) {
            super(2, continuation);
            this.$clicksCounter = clicksCounter;
            this.$mouseSelectionObserver = mouseSelectionObserver;
            this.$textDragObserver = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07962 c07962 = new C07962(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, continuation);
            c07962.L$0 = obj;
            return c07962;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C07962) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(r1, r12.$mouseSelectionObserver, r12.$clicksCounter, r13, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(r1, r12.$textDragObserver, r13, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(r1, r12.$textDragObserver, r13, r12.$clicksCounter.getClicks(), r12) == r0) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj = SelectionGesturesKt.awaitDown(awaitPointerEventScope, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2 && i != 3 && i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            PointerEvent pointerEvent = (PointerEvent) obj;
            this.$clicksCounter.update(pointerEvent);
            boolean zIsMouseOrTouchPad = SelectionGestures_androidKt.isMouseOrTouchPad(pointerEvent);
            if (zIsMouseOrTouchPad && PointerEvent_androidKt.m9462isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!changes.get(i2).isConsumed()) {
                    }
                }
                this.L$0 = null;
                this.label = 2;
            }
            if (!zIsMouseOrTouchPad) {
                if (this.$clicksCounter.getClicks() == 1) {
                    this.L$0 = null;
                    this.label = 3;
                } else {
                    this.L$0 = null;
                    this.label = 4;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final Object awaitSelectionGestures(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C07962(new ClicksCounter(pointerInputScope.getViewConfiguration()), mouseSelectionObserver, textDragObserver, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        if (r11 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionFirstPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C07981 c07981;
        PointerInputChange pointerInputChange;
        if (continuation instanceof C07981) {
            c07981 = (C07981) continuation;
            if ((c07981.label & Integer.MIN_VALUE) != 0) {
                c07981.label -= Integer.MIN_VALUE;
            } else {
                c07981 = new C07981(continuation);
            }
        }
        Object objM2268awaitLongPressOrCancellationrnUCldI = c07981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07981.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objM2268awaitLongPressOrCancellationrnUCldI);
                pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                long id = pointerInputChange.getId();
                c07981.L$0 = awaitPointerEventScope;
                c07981.L$1 = textDragObserver;
                c07981.L$2 = pointerInputChange;
                c07981.label = 1;
                objM2268awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m2268awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, c07981);
                if (objM2268awaitLongPressOrCancellationrnUCldI == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                textDragObserver = (TextDragObserver) c07981.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) c07981.L$0;
                ResultKt.throwOnFailure(objM2268awaitLongPressOrCancellationrnUCldI);
                if (((Boolean) objM2268awaitLongPressOrCancellationrnUCldI).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        PointerInputChange pointerInputChange2 = changes.get(i2);
                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                            pointerInputChange2.consume();
                        }
                    }
                    textDragObserver.onStop();
                } else {
                    textDragObserver.onCancel();
                }
                return Unit.INSTANCE;
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) c07981.L$2;
            textDragObserver = (TextDragObserver) c07981.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c07981.L$0;
            ResultKt.throwOnFailure(objM2268awaitLongPressOrCancellationrnUCldI);
            pointerInputChange = pointerInputChange3;
            awaitPointerEventScope = awaitPointerEventScope2;
            PointerInputChange pointerInputChange4 = (PointerInputChange) objM2268awaitLongPressOrCancellationrnUCldI;
            if (pointerInputChange4 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange4)) {
                textDragObserver.mo3523onStart3MmeM6k(pointerInputChange4.getPosition(), SelectionGestures_androidKt.getFirstLongPressSelectionAdjustment());
                long id2 = pointerInputChange4.getId();
                Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SelectionGesturesKt.touchSelectionFirstPress$lambda$0(textDragObserver, (PointerInputChange) obj);
                    }
                };
                c07981.L$0 = awaitPointerEventScope;
                c07981.L$1 = textDragObserver;
                c07981.L$2 = null;
                c07981.label = 2;
                objM2268awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m2278dragjO51t88(awaitPointerEventScope, id2, function1, c07981);
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit touchSelectionFirstPress$lambda$0(TextDragObserver textDragObserver, PointerInputChange pointerInputChange) {
        textDragObserver.mo3522onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
    
        if (r14 == r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionSubsequentPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, int i, Continuation<? super Unit> continuation) {
        C07991 c07991;
        long id;
        Ref.LongRef longRef;
        if (continuation instanceof C07991) {
            c07991 = (C07991) continuation;
            if ((c07991.label & Integer.MIN_VALUE) != 0) {
                c07991.label -= Integer.MIN_VALUE;
            } else {
                c07991 = new C07991(continuation);
            }
        }
        Object objWithTimeoutOrNull = c07991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07991.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
                PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                id = pointerInputChange.getId();
                textDragObserver.mo3523onStart3MmeM6k(pointerInputChange.getPosition(), i > 2 ? SelectionAdjustment.INSTANCE.getParagraph() : SelectionAdjustment.INSTANCE.getWord());
                longRef = new Ref.LongRef();
                longRef.element = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                C0800xcb1d223 c0800xcb1d223 = new C0800xcb1d223(id, longRef, null);
                c07991.L$0 = awaitPointerEventScope;
                c07991.L$1 = textDragObserver;
                c07991.L$2 = longRef;
                c07991.J$0 = id;
                c07991.label = 1;
                objWithTimeoutOrNull = awaitPointerEventScope.withTimeoutOrNull(longPressTimeoutMillis, c0800xcb1d223, c07991);
                if (objWithTimeoutOrNull == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                textDragObserver = (TextDragObserver) c07991.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) c07991.L$0;
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
                if (((Boolean) objWithTimeoutOrNull).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        PointerInputChange pointerInputChange2 = changes.get(i3);
                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                            pointerInputChange2.consume();
                        }
                    }
                    textDragObserver.onStop();
                } else {
                    textDragObserver.onCancel();
                }
                return Unit.INSTANCE;
            }
            long j = c07991.J$0;
            longRef = (Ref.LongRef) c07991.L$2;
            TextDragObserver textDragObserver2 = (TextDragObserver) c07991.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c07991.L$0;
            try {
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
                id = j;
                textDragObserver = textDragObserver2;
                awaitPointerEventScope = awaitPointerEventScope2;
            } catch (CancellationException e) {
                e = e;
                textDragObserver = textDragObserver2;
                textDragObserver.onCancel();
                throw e;
            }
            DownResolution downResolution = (DownResolution) objWithTimeoutOrNull;
            if (downResolution == null) {
                downResolution = DownResolution.Timeout;
            }
            if (downResolution == DownResolution.Cancel) {
                textDragObserver.onCancel();
                return Unit.INSTANCE;
            }
            if (downResolution == DownResolution.f65Up) {
                textDragObserver.onStop();
                return Unit.INSTANCE;
            }
            if (downResolution == DownResolution.Drag) {
                textDragObserver.mo3522onDragk4lQ0M(longRef.element);
            }
            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SelectionGesturesKt.touchSelectionSubsequentPress$lambda$0(textDragObserver, (PointerInputChange) obj);
                }
            };
            c07991.L$0 = awaitPointerEventScope;
            c07991.L$1 = textDragObserver;
            c07991.L$2 = null;
            c07991.label = 2;
            objWithTimeoutOrNull = DragGestureDetectorKt.m2278dragjO51t88(awaitPointerEventScope, id, function1, c07991);
        } catch (CancellationException e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit touchSelectionSubsequentPress$lambda$0(TextDragObserver textDragObserver, PointerInputChange pointerInputChange) {
        textDragObserver.mo3522onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0098 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:20:0x004f, B:31:0x0090, B:33:0x0098, B:35:0x00a9, B:37:0x00b5, B:28:0x0076), top: B:69:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0138 A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:13:0x0036, B:54:0x011b, B:56:0x0123, B:58:0x0127, B:60:0x0138, B:62:0x0144, B:50:0x00ee), top: B:69:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C07971 c07971;
        final SelectionAdjustment none;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.BooleanRef booleanRef;
        int size;
        if (continuation instanceof C07971) {
            c07971 = (C07971) continuation;
            if ((c07971.label & Integer.MIN_VALUE) != 0) {
                c07971.label -= Integer.MIN_VALUE;
            } else {
                c07971 = new C07971(continuation);
            }
        }
        Object objM2278dragjO51t88 = c07971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07971.label;
        int i2 = 0;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(objM2278dragjO51t88);
                    PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                    if (PointerEvent_androidKt.m9465isShiftPressed5xRPYO0(pointerEvent.getKeyboardModifiers())) {
                        if (mouseSelectionObserver.mo3888onExtendk4lQ0M(pointerInputChange.getPosition())) {
                            pointerInputChange.consume();
                            long id = pointerInputChange.getId();
                            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SelectionGesturesKt.mouseSelection$lambda$0(mouseSelectionObserver, (PointerInputChange) obj);
                                }
                            };
                            c07971.L$0 = awaitPointerEventScope;
                            c07971.L$1 = mouseSelectionObserver;
                            c07971.label = 1;
                            objM2278dragjO51t88 = DragGestureDetectorKt.m2278dragjO51t88(awaitPointerEventScope, id, function1, c07971);
                            if (objM2278dragjO51t88 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) objM2278dragjO51t88).booleanValue()) {
                            }
                        }
                    } else {
                        int clicks = clicksCounter.getClicks();
                        if (clicks == 1) {
                            none = SelectionAdjustment.INSTANCE.getNone();
                        } else if (clicks == 2) {
                            none = SelectionAdjustment.INSTANCE.getWord();
                        } else {
                            none = SelectionAdjustment.INSTANCE.getParagraph();
                        }
                        if (mouseSelectionObserver.mo3890onStart9KIMszo(pointerInputChange.getPosition(), none, clicksCounter.getClicks())) {
                            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                            booleanRef2.element = !Intrinsics.areEqual(none, SelectionAdjustment.INSTANCE.getNone());
                            long id2 = pointerInputChange.getId();
                            Function1 function12 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SelectionGesturesKt.mouseSelection$lambda$2(mouseSelectionObserver, none, booleanRef2, (PointerInputChange) obj);
                                }
                            };
                            c07971.L$0 = awaitPointerEventScope;
                            c07971.L$1 = mouseSelectionObserver;
                            c07971.L$2 = booleanRef2;
                            c07971.label = 2;
                            objM2278dragjO51t88 = DragGestureDetectorKt.m2278dragjO51t88(awaitPointerEventScope, id2, function12, c07971);
                            if (objM2278dragjO51t88 != coroutine_suspended) {
                                awaitPointerEventScope2 = awaitPointerEventScope;
                                booleanRef = booleanRef2;
                                if (((Boolean) objM2278dragjO51t88).booleanValue()) {
                                    List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    size = changes.size();
                                    while (i2 < size) {
                                    }
                                }
                                mouseSelectionObserver.onDragDone();
                            }
                            return coroutine_suspended;
                        }
                    }
                } else if (i == 1) {
                    mouseSelectionObserver = (MouseSelectionObserver) c07971.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) c07971.L$0;
                    ResultKt.throwOnFailure(objM2278dragjO51t88);
                    if (((Boolean) objM2278dragjO51t88).booleanValue()) {
                        List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size2 = changes2.size();
                        while (i2 < size2) {
                            PointerInputChange pointerInputChange2 = changes2.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i2++;
                        }
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef = (Ref.BooleanRef) c07971.L$2;
                    mouseSelectionObserver = (MouseSelectionObserver) c07971.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) c07971.L$0;
                    ResultKt.throwOnFailure(objM2278dragjO51t88);
                    if (((Boolean) objM2278dragjO51t88).booleanValue() && booleanRef.element) {
                        List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size = changes3.size();
                        while (i2 < size) {
                            PointerInputChange pointerInputChange3 = changes3.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mouseSelection$lambda$0(MouseSelectionObserver mouseSelectionObserver, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo3889onExtendDragk4lQ0M(pointerInputChange.getPosition())) {
            pointerInputChange.consume();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mouseSelection$lambda$2(MouseSelectionObserver mouseSelectionObserver, SelectionAdjustment selectionAdjustment, Ref.BooleanRef booleanRef, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo3887onDrag3MmeM6k(pointerInputChange.getPosition(), selectionAdjustment)) {
            pointerInputChange.consume();
            booleanRef.element = true;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0043 -> B:18:0x0046). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        C07951 c07951;
        int size;
        int i;
        if (continuation instanceof C07951) {
            c07951 = (C07951) continuation;
            if ((c07951.label & Integer.MIN_VALUE) != 0) {
                c07951.label -= Integer.MIN_VALUE;
            } else {
                c07951 = new C07951(continuation);
            }
        }
        Object objAwaitPointerEvent = c07951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07951.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent);
            PointerEventPass pointerEventPass = PointerEventPass.Main;
            c07951.L$0 = awaitPointerEventScope;
            c07951.label = 1;
            objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, c07951);
            if (objAwaitPointerEvent == coroutine_suspended) {
            }
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (i < size) {
            }
            return pointerEvent;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        awaitPointerEventScope = (AwaitPointerEventScope) c07951.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent);
        PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent;
        List<PointerInputChange> changes2 = pointerEvent2.getChanges();
        size = changes2.size();
        i = 0;
        while (i < size) {
            if (PointerEventKt.changedToDown(changes2.get(i))) {
                i++;
            } else {
                PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                c07951.L$0 = awaitPointerEventScope;
                c07951.label = 1;
                objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, c07951);
                if (objAwaitPointerEvent == coroutine_suspended) {
                    return coroutine_suspended;
                }
                PointerEvent pointerEvent22 = (PointerEvent) objAwaitPointerEvent;
                List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                size = changes22.size();
                i = 0;
                while (i < size) {
                }
            }
        }
        return pointerEvent22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m7901getDistanceimpl(Offset.m7907minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition())) < DragGestureDetectorKt.m2281pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.getType());
    }
}
