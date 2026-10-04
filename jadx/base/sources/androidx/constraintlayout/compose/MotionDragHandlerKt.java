package androidx.constraintlayout.compose;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.C1326xe3d9cdbd;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.constraintlayout.motion.widget.Key;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: MotionDragHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\fH\u0082@¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¨\u0006\u001b"}, m1599d2 = {"detectDragGesturesWhenNeeded", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onAcceptFirstDown", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Lkotlin/ParameterName;", "name", "change", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "motionPointerInput", "Landroidx/compose/ui/Modifier;", SubscriberAttributeKt.JSON_NAME_KEY, "", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "constraintlayout-compose_release"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class MotionDragHandlerKt {

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2 */
    /* JADX INFO: compiled from: MotionDragHandler.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2", m1609f = "MotionDragHandler.kt", m1610i = {0, 1, 1, 1}, m1611l = {166, PDFACompliance.e_PDFA1_7_4, PDFACompliance.e_PDFA1_8_3}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop"}, m1615s = {"L$0", "L$0", "L$1", "L$2"})
    static final class C15432 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Boolean> $onAcceptFirstDown;
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C15432(Function1<? super Offset, Boolean> function1, Function1<? super Offset, Unit> function12, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C15432> continuation) {
            super(2, continuation);
            this.$onAcceptFirstDown = function1;
            this.$onDragStart = function12;
            this.$onDrag = function2;
            this.$onDragCancel = function0;
            this.$onDragEnd = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15432 c15432 = new C15432(this.$onAcceptFirstDown, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            c15432.L$0 = obj;
            return c15432;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C15432) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00db, code lost:
        
            if (r12 == r0) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009a A[PHI: r1 r4 r5 r12
          0x009a: PHI (r1v5 kotlin.jvm.internal.Ref$LongRef) = (r1v4 kotlin.jvm.internal.Ref$LongRef), (r1v13 kotlin.jvm.internal.Ref$LongRef) binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
          0x009a: PHI (r4v8 androidx.compose.ui.input.pointer.PointerInputChange) = 
          (r4v7 androidx.compose.ui.input.pointer.PointerInputChange)
          (r4v11 androidx.compose.ui.input.pointer.PointerInputChange)
         binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
          0x009a: PHI (r5v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r5v7 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r5v10 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]
          0x009a: PHI (r12v9 java.lang.Object) = (r12v8 java.lang.Object), (r12v0 java.lang.Object) binds: [B:22:0x0097, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0097 -> B:24:0x009a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            AwaitPointerEventScope awaitPointerEventScope2;
            final Ref.LongRef longRef;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, true, null, this, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        this.$onDragCancel.invoke();
                    } else {
                        this.$onDragEnd.invoke();
                    }
                    return Unit.INSTANCE;
                }
                longRef = (Ref.LongRef) this.L$2;
                pointerInputChange = (PointerInputChange) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
                if (pointerInputChange2 == null && !pointerInputChange2.isConsumed()) {
                    this.L$0 = awaitPointerEventScope2;
                    this.L$1 = pointerInputChange;
                    this.L$2 = longRef;
                    this.label = 2;
                    obj = DragGestureDetectorKt.m2272awaitTouchSlopOrCancellationjO51t88(awaitPointerEventScope2, pointerInputChange.getId(), new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt.detectDragGesturesWhenNeeded.2.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3, Offset offset) {
                            m11419invokeUv8p0NA(pointerInputChange3, offset.m7913unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m11419invokeUv8p0NA(PointerInputChange pointerInputChange3, long j) {
                            pointerInputChange3.consume();
                            longRef.element = j;
                        }
                    }, this);
                    if (obj != coroutine_suspended) {
                        PointerInputChange pointerInputChange22 = (PointerInputChange) obj;
                        if (pointerInputChange22 == null) {
                        }
                        if (pointerInputChange22 != null) {
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    if (pointerInputChange22 != null) {
                        this.$onDragStart.invoke(Offset.m7892boximpl(pointerInputChange22.getPosition()));
                        this.$onDrag.invoke(pointerInputChange22, Offset.m7892boximpl(longRef.element));
                        long id = pointerInputChange22.getId();
                        final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 3;
                        obj = DragGestureDetectorKt.m2278dragjO51t88(awaitPointerEventScope2, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt.detectDragGesturesWhenNeeded.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                                invoke2(pointerInputChange3);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange pointerInputChange3) {
                                function2.invoke(pointerInputChange3, Offset.m7892boximpl(PointerEventKt.positionChange(pointerInputChange3)));
                                pointerInputChange3.consume();
                            }
                        }, this);
                    }
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
            if (!this.$onAcceptFirstDown.invoke(Offset.m7892boximpl(pointerInputChange3.getPosition())).booleanValue()) {
                return Unit.INSTANCE;
            }
            Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.element = Offset.INSTANCE.m7919getZeroF1C5BW0();
            awaitPointerEventScope2 = awaitPointerEventScope;
            longRef = longRef2;
            pointerInputChange = pointerInputChange3;
            this.L$0 = awaitPointerEventScope2;
            this.L$1 = pointerInputChange;
            this.L$2 = longRef;
            this.label = 2;
            obj = DragGestureDetectorKt.m2272awaitTouchSlopOrCancellationjO51t88(awaitPointerEventScope2, pointerInputChange.getId(), new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt.detectDragGesturesWhenNeeded.2.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange32, Offset offset) {
                    m11419invokeUv8p0NA(pointerInputChange32, offset.m7913unboximpl());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m11419invokeUv8p0NA(PointerInputChange pointerInputChange32, long j) {
                    pointerInputChange32.consume();
                    longRef.element = j;
                }
            }, this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectDragGesturesWhenNeeded(PointerInputScope pointerInputScope, Function1<? super Offset, Boolean> function1, Function1<? super Offset, Unit> function12, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C15432(function1, function12, function2, function02, function0, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final Modifier motionPointerInput(Modifier modifier, final Object obj, final MutableFloatState mutableFloatState, final MotionMeasurer motionMeasurer) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("motionPointerInput");
                inspectorInfo.getProperties().set(SubscriberAttributeKt.JSON_NAME_KEY, obj);
                inspectorInfo.getProperties().set(Key.MOTIONPROGRESS, mutableFloatState);
                inspectorInfo.getProperties().set("measurer", motionMeasurer);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt.motionPointerInput.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(146198586);
                ComposerKt.sourceInformation(composer, "C65@2451L123,68@2601L61,70@2711L1716,70@2672L1755,107@4475L1202:MotionDragHandler.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(146198586, i, -1, "androidx.constraintlayout.compose.motionPointerInput.<anonymous> (MotionDragHandler.kt:61)");
                }
                if (!motionMeasurer.getTransition().hasOnSwipe()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifier2;
                }
                ComposerKt.sourceInformationMarkerStart(composer, -1723183141, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChanged = composer.changed(obj);
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                MutableFloatState mutableFloatState2 = mutableFloatState;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new TransitionHandler(motionMeasurer2, mutableFloatState2);
                    composer.updateRememberedValue(objRememberedValue);
                }
                TransitionHandler transitionHandler = (TransitionHandler) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1723178403, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChanged2 = composer.changed(obj);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ChannelKt.Channel$default(-1, null, null, 6, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Channel channel = (Channel) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                Object obj2 = obj;
                ComposerKt.sourceInformationMarkerStart(composer, -1723173228, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(transitionHandler) | composer.changedInstance(channel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function2) new MotionDragHandlerKt$motionPointerInput$2$1$1(transitionHandler, channel, null);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(obj2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, 0);
                Object obj3 = obj;
                ComposerKt.sourceInformationMarkerStart(composer, -1723117294, "CC(remember):MotionDragHandler.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(transitionHandler) | composer.changedInstance(channel);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function2) new MotionDragHandlerKt$motionPointerInput$2$2$1(transitionHandler, channel, null);
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierThen = modifier2.then(new SuspendPointerInputElement(obj3, null, null, new C1326xe3d9cdbd((Function2) objRememberedValue4), 6, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen;
            }
        });
    }
}
