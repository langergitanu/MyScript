package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.foundation.gestures.TransformableKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.HistoricalChange;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerEventType;
import androidx.compose.p004ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001b\u001a<\u0010\u001c\u001a\u00020\r*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001e\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", "enabled", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectNonTouchGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePointerEventAsCtrlScrollOrNull", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointer", "Landroidx/compose/ui/input/pointer/PointerEvent;", "consumePointerEventAsPanOrNull", "consumePointerEventAsScaleOrNull", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEvent;)Ljava/lang/Float;", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TransformableKt", m1609f = "Transformable.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {461, 463, PDFACompliance.e_PDFA5_2_1}, m1612m = "detectZoom", m1613n = {"$this$detectZoom", "channel", "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", NotificationCompat.CATEGORY_EVENT, "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, m1615s = {"L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"}, m1616v = 1)
    static final class C04601 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C04601(Continuation<? super C04601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, false, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean transformable$lambda$0(Offset offset) {
        return true;
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformableKt.transformable$lambda$0((Offset) obj));
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2 */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2", m1609f = "Transformable.kt", m1610i = {0, 1, 2, 3}, m1611l = {288, 315, PDFACompliance.e_PDFA3_3_1, 349}, m1612m = "invokeSuspend", m1613n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, m1615s = {"L$0", "L$0", "L$0", "L$0"}, m1616v = 1)
    static final class C04562 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<TransformEvent> $channel;
        final /* synthetic */ CoroutineContext $currentContext;
        final /* synthetic */ ScrollConfig $scrollConfig;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04562(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super C04562> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$scrollConfig = scrollConfig;
            this.$channel = channel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(PointerInputChange pointerInputChange) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$1(PointerInputChange pointerInputChange) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$3(PointerInputChange pointerInputChange) {
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04562 c04562 = new C04562(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
            c04562.L$0 = obj;
            return c04562;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C04562) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0164, code lost:
        
            if (r9 != r0) goto L55;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0084 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0167, B:57:0x016f, B:52:0x0137, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d3, B:41:0x00dd, B:43:0x00e4, B:44:0x00f0, B:47:0x011a, B:49:0x0122, B:51:0x0129, B:60:0x017d, B:61:0x0188, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0167, B:57:0x016f, B:52:0x0137, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d3, B:41:0x00dd, B:43:0x00e4, B:44:0x00f0, B:47:0x011a, B:49:0x0122, B:51:0x0129, B:60:0x017d, B:61:0x0188, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0122 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0167, B:57:0x016f, B:52:0x0137, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d3, B:41:0x00dd, B:43:0x00e4, B:44:0x00f0, B:47:0x011a, B:49:0x0122, B:51:0x0129, B:60:0x017d, B:61:0x0188, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0080 -> B:27:0x005d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00db -> B:59:0x0174). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00dd -> B:36:0x008f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0120 -> B:59:0x0174). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0122 -> B:44:0x00f0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0164 -> B:55:0x0167). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object objAwaitPointerEvent$default;
            PointerEvent pointerEvent;
            Offset offsetConsumePointerEventAsPanOrNull;
            Object objAwaitPointerEvent$default2;
            Offset offsetConsumePointerEventAsCtrlScrollOrNull;
            Object objAwaitPointerEvent$default3;
            Offset offsetConsumePointerEventAsCtrlScrollOrNull2;
            float fFloatValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    if (!JobKt.isActive(this.$currentContext)) {
                    }
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    objAwaitPointerEvent$default3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    if (objAwaitPointerEvent$default3 == coroutine_suspended) {
                    }
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default3;
                    offsetConsumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                    Offset offsetConsumePointerEventAsPanOrNull2 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                    Float fConsumePointerEventAsScaleOrNull = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 == null) {
                    }
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 != null) {
                    }
                } else if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitPointerEvent$default3 = obj;
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default3;
                    offsetConsumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                    Offset offsetConsumePointerEventAsPanOrNull22 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                    Float fConsumePointerEventAsScaleOrNull2 = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 == null) {
                    }
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 != null) {
                    }
                } else if (i == 2) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitPointerEvent$default2 = obj;
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default2;
                    offsetConsumePointerEventAsCtrlScrollOrNull = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                    if (offsetConsumePointerEventAsCtrlScrollOrNull != null) {
                    }
                    if (!JobKt.isActive(this.$currentContext)) {
                    }
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    objAwaitPointerEvent$default3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    if (objAwaitPointerEvent$default3 == coroutine_suspended) {
                    }
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default3;
                    offsetConsumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                    Offset offsetConsumePointerEventAsPanOrNull222 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                    Float fConsumePointerEventAsScaleOrNull22 = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 == null) {
                    }
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 != null) {
                    }
                } else if (i == 3) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitPointerEvent$default = obj;
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                    offsetConsumePointerEventAsPanOrNull = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                    if (offsetConsumePointerEventAsPanOrNull != null) {
                    }
                    if (!JobKt.isActive(this.$currentContext)) {
                    }
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    objAwaitPointerEvent$default3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    if (objAwaitPointerEvent$default3 == coroutine_suspended) {
                    }
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default3;
                    offsetConsumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                    Offset offsetConsumePointerEventAsPanOrNull2222 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                    Float fConsumePointerEventAsScaleOrNull222 = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 == null) {
                    }
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 != null) {
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Object objAwaitPointerEvent$default4 = obj;
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default4;
                    Float fConsumePointerEventAsScaleOrNull3 = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                    if (fConsumePointerEventAsScaleOrNull3 != null) {
                        fFloatValue = fConsumePointerEventAsScaleOrNull3.floatValue();
                        this.$channel.mo16021trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Boolean.valueOf(TransformableKt.C04562.invokeSuspend$lambda$3((PointerInputChange) obj2));
                            }
                        }, 1, null), fFloatValue, Offset.INSTANCE.m7919getZeroF1C5BW0(), 0.0f, null));
                        this.L$0 = awaitPointerEventScope;
                        this.label = 4;
                        objAwaitPointerEvent$default4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    }
                    if (!JobKt.isActive(this.$currentContext)) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    objAwaitPointerEvent$default3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    if (objAwaitPointerEvent$default3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default3;
                    offsetConsumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                    Offset offsetConsumePointerEventAsPanOrNull22222 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                    Float fConsumePointerEventAsScaleOrNull2222 = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 == null || offsetConsumePointerEventAsPanOrNull22222 != null || fConsumePointerEventAsScaleOrNull2222 != null) {
                        if (offsetConsumePointerEventAsCtrlScrollOrNull2 != null) {
                            long jM7913unboximpl = offsetConsumePointerEventAsCtrlScrollOrNull2.m7913unboximpl();
                            this.$channel.mo16021trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                            this.$channel.mo16021trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Boolean.valueOf(TransformableKt.C04562.invokeSuspend$lambda$0((PointerInputChange) obj2));
                                }
                            }, 1, null), (float) Math.pow(2.0f, Float.intBitsToFloat((int) (jM7913unboximpl & 4294967295L)) / 545.0f), Offset.INSTANCE.m7919getZeroF1C5BW0(), 0.0f, null));
                            this.L$0 = awaitPointerEventScope;
                            this.label = 2;
                            objAwaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                            if (objAwaitPointerEvent$default2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pointerEvent = (PointerEvent) objAwaitPointerEvent$default2;
                            offsetConsumePointerEventAsCtrlScrollOrNull = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                            if (offsetConsumePointerEventAsCtrlScrollOrNull != null) {
                                jM7913unboximpl = offsetConsumePointerEventAsCtrlScrollOrNull.m7913unboximpl();
                                this.$channel.mo16021trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return Boolean.valueOf(TransformableKt.C04562.invokeSuspend$lambda$0((PointerInputChange) obj2));
                                    }
                                }, 1, null), (float) Math.pow(2.0f, Float.intBitsToFloat((int) (jM7913unboximpl & 4294967295L)) / 545.0f), Offset.INSTANCE.m7919getZeroF1C5BW0(), 0.0f, null));
                                this.L$0 = awaitPointerEventScope;
                                this.label = 2;
                                objAwaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                                if (objAwaitPointerEvent$default2 == coroutine_suspended) {
                                }
                                pointerEvent = (PointerEvent) objAwaitPointerEvent$default2;
                                offsetConsumePointerEventAsCtrlScrollOrNull = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                                if (offsetConsumePointerEventAsCtrlScrollOrNull != null) {
                                }
                            }
                            if (!JobKt.isActive(this.$currentContext)) {
                            }
                        } else if (offsetConsumePointerEventAsPanOrNull22222 != null) {
                            long jM7913unboximpl2 = offsetConsumePointerEventAsPanOrNull22222.m7913unboximpl();
                            this.$channel.mo16021trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                            long jM7913unboximpl3 = jM7913unboximpl2;
                            this.$channel.mo16021trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Boolean.valueOf(TransformableKt.C04562.invokeSuspend$lambda$1((PointerInputChange) obj2));
                                }
                            }, 1, null), 1.0f, jM7913unboximpl3, 0.0f, null));
                            this.L$0 = awaitPointerEventScope;
                            this.label = 3;
                            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                            if (objAwaitPointerEvent$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                            offsetConsumePointerEventAsPanOrNull = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                            if (offsetConsumePointerEventAsPanOrNull != null) {
                                jM7913unboximpl3 = offsetConsumePointerEventAsPanOrNull.m7913unboximpl();
                                this.$channel.mo16021trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return Boolean.valueOf(TransformableKt.C04562.invokeSuspend$lambda$1((PointerInputChange) obj2));
                                    }
                                }, 1, null), 1.0f, jM7913unboximpl3, 0.0f, null));
                                this.L$0 = awaitPointerEventScope;
                                this.label = 3;
                                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                                if (objAwaitPointerEvent$default == coroutine_suspended) {
                                }
                                pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                                offsetConsumePointerEventAsPanOrNull = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                                if (offsetConsumePointerEventAsPanOrNull != null) {
                                }
                            }
                            if (!JobKt.isActive(this.$currentContext)) {
                            }
                        } else {
                            if (fConsumePointerEventAsScaleOrNull2222 == null) {
                                throw new IllegalStateException("One of zoomOffset, panOffset and scaleDelta must be non-null".toString());
                            }
                            float fFloatValue2 = fConsumePointerEventAsScaleOrNull2222.floatValue();
                            this.$channel.mo16021trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                            fFloatValue = fFloatValue2;
                            this.$channel.mo16021trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Boolean.valueOf(TransformableKt.C04562.invokeSuspend$lambda$3((PointerInputChange) obj2));
                                }
                            }, 1, null), fFloatValue, Offset.INSTANCE.m7919getZeroF1C5BW0(), 0.0f, null));
                            this.L$0 = awaitPointerEventScope;
                            this.label = 4;
                            objAwaitPointerEvent$default4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                        }
                    }
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    objAwaitPointerEvent$default3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    if (objAwaitPointerEvent$default3 == coroutine_suspended) {
                    }
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default3;
                    offsetConsumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                    Offset offsetConsumePointerEventAsPanOrNull222222 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                    Float fConsumePointerEventAsScaleOrNull22222 = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 == null) {
                    }
                    if (offsetConsumePointerEventAsCtrlScrollOrNull2 != null) {
                    }
                }
            } finally {
                this.$channel.mo16021trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsCtrlScrollOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent, ScrollConfig scrollConfig) {
        long jM7919getZeroF1C5BW0;
        PointerInputChange pointerInputChange;
        if (!PointerEvent_androidKt.m9456isCtrlPressed5xRPYO0(pointerEvent.getKeyboardModifiers()) || (!PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9447getScroll7fucELk()) && !PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9441getPanStart7fucELk()) && !PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9440getPanMove7fucELk()) && !PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9439getPanEnd7fucELk()))) {
            return null;
        }
        long jMo2220calculateMouseWheelScroll8xgXZGE = scrollConfig.mo2220calculateMouseWheelScroll8xgXZGE(awaitPointerEventScope, pointerEvent, awaitPointerEventScope.mo9377getSizeYbymL2g());
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges())) == null) {
            jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
        } else {
            long jM7895constructorimpl = Offset.m7895constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            Offset offsetM7892boximpl = Offset.m7892boximpl(Offset.INSTANCE.m7919getZeroF1C5BW0());
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                offsetM7892boximpl = Offset.m7892boximpl(Offset.m7907minusMKHz9U(offsetM7892boximpl.m7913unboximpl(), historical.get(i).getPanOffset()));
            }
            jM7919getZeroF1C5BW0 = Offset.m7908plusMKHz9U(jM7895constructorimpl, offsetM7892boximpl.m7913unboximpl());
        }
        long jM7908plusMKHz9U = Offset.m7908plusMKHz9U(jMo2220calculateMouseWheelScroll8xgXZGE, jM7919getZeroF1C5BW0);
        if (Offset.m7900equalsimpl0(jM7908plusMKHz9U, Offset.INSTANCE.m7919getZeroF1C5BW0())) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size2 = changes.size();
        for (int i2 = 0; i2 < size2; i2++) {
            changes.get(i2).consume();
        }
        return Offset.m7892boximpl(jM7908plusMKHz9U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsPanOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        long jM7919getZeroF1C5BW0;
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (!PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9441getPanStart7fucELk()) && !PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9440getPanMove7fucELk()) && !PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9439getPanEnd7fucELk()))) {
            return null;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges());
        if (pointerInputChange == null) {
            jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
        } else {
            long jM7895constructorimpl = Offset.m7895constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            Offset offsetM7892boximpl = Offset.m7892boximpl(Offset.INSTANCE.m7919getZeroF1C5BW0());
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                offsetM7892boximpl = Offset.m7892boximpl(Offset.m7907minusMKHz9U(offsetM7892boximpl.m7913unboximpl(), historical.get(i).getPanOffset()));
            }
            jM7919getZeroF1C5BW0 = Offset.m7908plusMKHz9U(jM7895constructorimpl, offsetM7892boximpl.m7913unboximpl());
        }
        if (Offset.m7900equalsimpl0(jM7919getZeroF1C5BW0, Offset.INSTANCE.m7919getZeroF1C5BW0())) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size2 = changes.size();
        for (int i2 = 0; i2 < size2; i2++) {
            changes.get(i2).consume();
        }
        return Offset.m7892boximpl(jM7919getZeroF1C5BW0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float consumePointerEventAsScaleOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (!PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9446getScaleStart7fucELk()) && !PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9444getScaleChange7fucELk()) && !PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9445getScaleEnd7fucELk()))) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        float scaleFactor = 1.0f;
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            scaleFactor *= pointerInputChange.getScaleFactor();
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size2 = historical.size();
            for (int i2 = 0; i2 < size2; i2++) {
                scaleFactor *= historical.get(i2).getScaleFactor();
            }
        }
        if (scaleFactor == 1.0f) {
            return null;
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size3 = changes2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            changes2.get(i3).consume();
        }
        return Float.valueOf(scaleFactor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x032d, code lost:
    
        if (r6 != 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x032f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0153, code lost:
    
        if (androidx.compose.foundation.ComposeFoundationFlags.isTrackpadGestureHandlingEnabled == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0163, code lost:
    
        if (androidx.compose.p004ui.input.pointer.PointerEventType.m9432equalsimpl0(r0.getType(), androidx.compose.p004ui.input.pointer.PointerEventType.INSTANCE.m9441getPanStart7fucELk()) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0173, code lost:
    
        if (androidx.compose.p004ui.input.pointer.PointerEventType.m9432equalsimpl0(r0.getType(), androidx.compose.p004ui.input.pointer.PointerEventType.INSTANCE.m9440getPanMove7fucELk()) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0183, code lost:
    
        if (androidx.compose.p004ui.input.pointer.PointerEventType.m9432equalsimpl0(r0.getType(), androidx.compose.p004ui.input.pointer.PointerEventType.INSTANCE.m9439getPanEnd7fucELk()) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0193, code lost:
    
        if (androidx.compose.p004ui.input.pointer.PointerEventType.m9432equalsimpl0(r0.getType(), androidx.compose.p004ui.input.pointer.PointerEventType.INSTANCE.m9446getScaleStart7fucELk()) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a3, code lost:
    
        if (androidx.compose.p004ui.input.pointer.PointerEventType.m9432equalsimpl0(r0.getType(), androidx.compose.p004ui.input.pointer.PointerEventType.INSTANCE.m9444getScaleChange7fucELk()) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b3, code lost:
    
        if (androidx.compose.p004ui.input.pointer.PointerEventType.m9432equalsimpl0(r0.getType(), androidx.compose.p004ui.input.pointer.PointerEventType.INSTANCE.m9445getScaleEnd7fucELk()) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b7, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0334 A[EDGE_INSN: B:117:0x0334->B:106:0x0334 BREAK  A[LOOP:0: B:100:0x031f->B:105:0x0331], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0151 A[EDGE_INSN: B:121:0x0151->B:32:0x0151 BREAK  A[LOOP:2: B:27:0x013f->B:31:0x014e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0301  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0301 -> B:99:0x030e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z, Channel<TransformEvent> channel, Function1<? super Offset, Boolean> function1, Continuation<? super Unit> continuation) {
        C04601 c04601;
        Channel<TransformEvent> channel2;
        Function1<? super Offset, Boolean> function12;
        boolean z2;
        float f;
        long j;
        int i;
        int i2;
        float f2;
        float f3;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super Offset, Boolean> function13;
        AwaitPointerEventScope awaitPointerEventScope3;
        float f4;
        float f5;
        Channel<TransformEvent> channel3;
        int size;
        int i3;
        int i4;
        C04601 c046012;
        float f6;
        long j2;
        int i5;
        int i6;
        C04601 c046013;
        Object objAwaitPointerEvent;
        float f7;
        int i7;
        int i8;
        Channel<TransformEvent> channel4;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerEvent pointerEvent;
        float f8;
        float f9;
        long j3;
        int size2;
        int i9;
        int size3;
        int i10;
        int size4;
        int i11;
        if (continuation instanceof C04601) {
            c04601 = (C04601) continuation;
            if ((c04601.label & Integer.MIN_VALUE) != 0) {
                c04601.label -= Integer.MIN_VALUE;
            } else {
                c04601 = new C04601(continuation);
            }
        }
        C04601 c046014 = c04601;
        Object objAwaitPointerEvent$default = c046014.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i12 = c046014.label;
        if (i12 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
            float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
            c046014.L$0 = awaitPointerEventScope;
            channel2 = channel;
            c046014.L$1 = channel2;
            function12 = function1;
            c046014.L$2 = function12;
            z2 = z;
            c046014.Z$0 = z2;
            c046014.F$0 = 0.0f;
            c046014.F$1 = 1.0f;
            c046014.J$0 = jM7919getZeroF1C5BW0;
            c046014.I$0 = 0;
            c046014.F$2 = touchSlop;
            c046014.I$1 = 0;
            c046014.label = 1;
            if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, c046014, 2, null) != coroutine_suspended) {
                f = touchSlop;
                j = jM7919getZeroF1C5BW0;
                i = 0;
                i2 = 0;
                f2 = 1.0f;
                f3 = 0.0f;
                awaitPointerEventScope2 = awaitPointerEventScope;
            }
            return coroutine_suspended;
        }
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i4 = c046014.I$2;
                i7 = c046014.I$1;
                f7 = c046014.F$2;
                i8 = c046014.I$0;
                j2 = c046014.J$0;
                float f10 = c046014.F$1;
                f3 = c046014.F$0;
                boolean z3 = c046014.Z$0;
                pointerEvent = (PointerEvent) c046014.L$3;
                Function1<? super Offset, Boolean> function14 = (Function1) c046014.L$2;
                Channel<TransformEvent> channel5 = (Channel) c046014.L$1;
                AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) c046014.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                f2 = f10;
                channel4 = channel5;
                awaitPointerEventScope4 = awaitPointerEventScope5;
                function12 = function14;
                z2 = z3;
                c046013 = c046014;
                objAwaitPointerEvent = objAwaitPointerEvent$default;
                List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
                size3 = changes.size();
                Object obj = coroutine_suspended;
                i10 = 0;
                while (true) {
                    if (i10 >= size3) {
                        break;
                    }
                    if (changes.get(i10).isConsumed()) {
                        break;
                    }
                    i10++;
                }
                boolean z4 = false;
                if (i4 == 0 && !z4) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    size4 = changes2.size();
                    for (i11 = 0; i11 < size4; i11++) {
                        if (changes2.get(i11).getPressed()) {
                            i = i7;
                            f = f7;
                            i2 = i8;
                            c046014 = c046013;
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            coroutine_suspended = obj;
                            channel2 = channel4;
                            j = j2;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            i = c046014.I$1;
            f = c046014.F$2;
            i2 = c046014.I$0;
            j = c046014.J$0;
            float f11 = c046014.F$1;
            float f12 = c046014.F$0;
            boolean z5 = c046014.Z$0;
            Function1<? super Offset, Boolean> function15 = (Function1) c046014.L$2;
            Channel<TransformEvent> channel6 = (Channel) c046014.L$1;
            AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) c046014.L$0;
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            f5 = f11;
            channel3 = channel6;
            z2 = z5;
            f4 = f12;
            function13 = function15;
            awaitPointerEventScope3 = awaitPointerEventScope6;
            PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes3 = pointerEvent2.getChanges();
            size = changes3.size();
            int i13 = i;
            i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (changes3.get(i3).isConsumed()) {
                    break;
                }
                i3++;
            }
            i4 = 1;
            if (i4 != 0) {
                float fCalculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent2);
                float fCalculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent2);
                float f13 = f5;
                float f14 = f4;
                long jCalculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent2);
                if (i2 == 0) {
                    float f15 = f13 * fCalculateZoom;
                    float f16 = f14 + fCalculateRotation;
                    long jM7908plusMKHz9U = Offset.m7908plusMKHz9U(j, jCalculatePan);
                    int i14 = i2;
                    float fCalculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent2, false);
                    float fAbs = Math.abs(1 - f15) * fCalculateCentroidSize;
                    float fAbs2 = Math.abs(((3.1415927f * f16) * fCalculateCentroidSize) / 180.0f);
                    float fM7901getDistanceimpl = Offset.m7901getDistanceimpl(jM7908plusMKHz9U);
                    if (fAbs > f || fAbs2 > f || (fM7901getDistanceimpl > f && function13.invoke(Offset.m7892boximpl(jCalculatePan)).booleanValue())) {
                        i6 = (!z2 || fAbs2 >= f) ? 0 : 1;
                        channel3.mo16021trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        i5 = 1;
                        f8 = f15;
                        f9 = f16;
                    } else {
                        i6 = i13;
                        f8 = f15;
                        f9 = f16;
                        i5 = i14;
                    }
                    j3 = jM7908plusMKHz9U;
                } else {
                    f8 = f13;
                    f9 = f14;
                    j3 = j;
                    i5 = i2;
                    i6 = i13;
                }
                if (i5 != 0) {
                    long jCalculateCentroid = TransformGestureDetectorKt.calculateCentroid(pointerEvent2, false);
                    float f17 = i6 != 0 ? 0.0f : fCalculateRotation;
                    if (f17 == 0.0f && fCalculateZoom == 1.0f) {
                        c046012 = c046014;
                        if (!Offset.m7900equalsimpl0(jCalculatePan, Offset.INSTANCE.m7919getZeroF1C5BW0()) && function13.invoke(Offset.m7892boximpl(jCalculatePan)).booleanValue()) {
                        }
                        List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                        size2 = changes4.size();
                        for (i9 = 0; i9 < size2; i9++) {
                            PointerInputChange pointerInputChange = changes4.get(i9);
                            if (PointerEventKt.positionChanged(pointerInputChange)) {
                                pointerInputChange.consume();
                            }
                        }
                    } else {
                        c046012 = c046014;
                    }
                    channel3.mo16021trySendJP2dKIU(new TransformEvent.TransformDelta(jCalculateCentroid, fCalculateZoom, jCalculatePan, f17, null));
                    List<PointerInputChange> changes42 = pointerEvent2.getChanges();
                    size2 = changes42.size();
                    while (i9 < size2) {
                    }
                } else {
                    c046012 = c046014;
                }
                j2 = j3;
                f6 = f8;
                f3 = f9;
            } else {
                int i15 = i2;
                c046012 = c046014;
                ChannelResult.m16036boximpl(channel3.mo16021trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE));
                f6 = f5;
                f3 = f4;
                j2 = j;
                i5 = i15;
                i6 = i13;
            }
            PointerEventPass pointerEventPass = PointerEventPass.Final;
            c046013 = c046012;
            c046013.L$0 = awaitPointerEventScope3;
            c046013.L$1 = channel3;
            c046013.L$2 = function13;
            c046013.L$3 = pointerEvent2;
            c046013.Z$0 = z2;
            c046013.F$0 = f3;
            c046013.F$1 = f6;
            c046013.J$0 = j2;
            c046013.I$0 = i5;
            c046013.F$2 = f;
            c046013.I$1 = i6;
            c046013.I$2 = i4;
            c046013.label = 3;
            objAwaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, c046013);
            if (objAwaitPointerEvent != coroutine_suspended) {
                float f18 = f6;
                f7 = f;
                i7 = i6;
                i8 = i5;
                channel4 = channel3;
                f2 = f18;
                awaitPointerEventScope4 = awaitPointerEventScope3;
                function12 = function13;
                pointerEvent = pointerEvent2;
                List<PointerInputChange> changes5 = ((PointerEvent) objAwaitPointerEvent).getChanges();
                size3 = changes5.size();
                Object obj2 = coroutine_suspended;
                i10 = 0;
                while (true) {
                    if (i10 >= size3) {
                    }
                    i10++;
                }
                boolean z42 = false;
                if (i4 == 0) {
                    List<PointerInputChange> changes22 = pointerEvent.getChanges();
                    size4 = changes22.size();
                    while (i11 < size4) {
                    }
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        i = c046014.I$1;
        f = c046014.F$2;
        i2 = c046014.I$0;
        j = c046014.J$0;
        f2 = c046014.F$1;
        f3 = c046014.F$0;
        boolean z6 = c046014.Z$0;
        function12 = (Function1) c046014.L$2;
        Channel<TransformEvent> channel7 = (Channel) c046014.L$1;
        awaitPointerEventScope2 = (AwaitPointerEventScope) c046014.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent$default);
        z2 = z6;
        channel2 = channel7;
        c046014.L$0 = awaitPointerEventScope2;
        c046014.L$1 = channel2;
        c046014.L$2 = function12;
        c046014.L$3 = null;
        c046014.Z$0 = z2;
        c046014.F$0 = f3;
        c046014.F$1 = f2;
        c046014.J$0 = j;
        c046014.I$0 = i2;
        c046014.F$2 = f;
        c046014.I$1 = i;
        c046014.label = 2;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, c046014, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            float f19 = f3;
            f5 = f2;
            channel3 = channel2;
            f4 = f19;
            AwaitPointerEventScope awaitPointerEventScope7 = awaitPointerEventScope2;
            function13 = function12;
            awaitPointerEventScope3 = awaitPointerEventScope7;
            PointerEvent pointerEvent22 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes32 = pointerEvent22.getChanges();
            size = changes32.size();
            int i132 = i;
            i3 = 0;
            while (true) {
                if (i3 >= size) {
                }
                i3++;
            }
            i4 = 1;
            if (i4 != 0) {
            }
            PointerEventPass pointerEventPass2 = PointerEventPass.Final;
            c046013 = c046012;
            c046013.L$0 = awaitPointerEventScope3;
            c046013.L$1 = channel3;
            c046013.L$2 = function13;
            c046013.L$3 = pointerEvent22;
            c046013.Z$0 = z2;
            c046013.F$0 = f3;
            c046013.F$1 = f6;
            c046013.J$0 = j2;
            c046013.I$0 = i5;
            c046013.F$2 = f;
            c046013.I$1 = i6;
            c046013.I$2 = i4;
            c046013.label = 3;
            objAwaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass2, c046013);
            if (objAwaitPointerEvent != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectNonTouchGestures(PointerInputScope pointerInputScope, Channel<TransformEvent> channel, ScrollConfig scrollConfig, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C04562(continuation.get$context(), scrollConfig, channel, null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }
}
