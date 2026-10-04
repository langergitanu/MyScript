package androidx.compose.foundation.gestures;

import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.location.LocationRequest;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: ForEachGesture.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u0007H\u0087@¢\u0006\u0002\u0010\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\r\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010\u001a;\u0010\u0011\u001a\u00020\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u0012"}, m1599d2 = {"forEachGesture", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ForEachGestureKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 */
    /* JADX INFO: compiled from: ForEachGesture.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ForEachGestureKt", m1609f = "ForEachGesture.kt", m1610i = {0, 0}, m1611l = {84}, m1612m = "awaitAllPointersUp", m1613n = {"$this$awaitAllPointersUp", "pass"}, m1615s = {"L$0", "L$1"}, m1616v = 1)
    static final class C03993 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03993(Continuation<? super C03993> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ForEachGestureKt.awaitAllPointersUp(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 */
    /* JADX INFO: compiled from: ForEachGesture.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ForEachGestureKt", m1609f = "ForEachGesture.kt", m1610i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, m1611l = {48, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, 56}, m1612m = "forEachGesture", m1613n = {"$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext"}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C04011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04011(Continuation<? super C04011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ForEachGestureKt.forEachGesture(null, null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
    
        if (r10 != r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ac, code lost:
    
        if (r10 == r1) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.compose.ui.input.pointer.PointerInputScope] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0092 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ac -> B:18:0x0053). Please report as a decompilation issue!!! */
    @Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @ReplaceWith(expression = "awaitEachGesture(block)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forEachGesture(PointerInputScope pointerInputScope, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        C04011 c04011;
        ?? r10;
        ?? r8;
        ?? r82;
        ?? r2;
        if (continuation instanceof C04011) {
            c04011 = (C04011) continuation;
            if ((c04011.label & Integer.MIN_VALUE) != 0) {
                c04011.label -= Integer.MIN_VALUE;
            } else {
                c04011 = new C04011(continuation);
            }
        }
        Object obj = c04011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r22 = c04011.label;
        try {
        } catch (CancellationException e) {
            e = e;
            if (!JobKt.isActive(pointerInputScope)) {
            }
        }
        if (r22 == 0) {
            ResultKt.throwOnFailure(obj);
            r8 = pointerInputScope;
            r10 = c04011.getContext();
            if (!JobKt.isActive(r10)) {
            }
        } else {
            if (r22 != 1) {
                if (r22 == 2) {
                    CoroutineContext coroutineContext = (CoroutineContext) c04011.L$2;
                    function2 = (Function2) c04011.L$1;
                    PointerInputScope pointerInputScope2 = (PointerInputScope) c04011.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = pointerInputScope2;
                    r82 = coroutineContext;
                } else {
                    if (r22 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CoroutineContext coroutineContext2 = (CoroutineContext) c04011.L$2;
                    function2 = (Function2) c04011.L$1;
                    PointerInputScope pointerInputScope3 = (PointerInputScope) c04011.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = pointerInputScope3;
                    r82 = coroutineContext2;
                }
                r10 = r82;
                r8 = r2;
                if (!JobKt.isActive(r10)) {
                    try {
                    } catch (CancellationException e2) {
                        r22 = r8;
                        pointerInputScope = r10;
                        e = e2;
                        if (!JobKt.isActive(pointerInputScope)) {
                            c04011.L$0 = r22;
                            c04011.L$1 = function2;
                            c04011.L$2 = pointerInputScope;
                            c04011.label = 3;
                            Object objAwaitAllPointersUp = awaitAllPointersUp(r22, c04011);
                            r2 = r22;
                            r82 = pointerInputScope;
                        } else {
                            throw e;
                        }
                    }
                    c04011.L$0 = r8;
                    c04011.L$1 = function2;
                    c04011.L$2 = r10;
                    c04011.label = 1;
                    if (function2.invoke(r8, c04011) != coroutine_suspended) {
                        r22 = r8;
                        pointerInputScope = r10;
                        c04011.L$0 = r22;
                        c04011.L$1 = function2;
                        c04011.L$2 = pointerInputScope;
                        c04011.label = 2;
                        Object objAwaitAllPointersUp2 = awaitAllPointersUp(r22, c04011);
                        r2 = r22;
                        r82 = pointerInputScope;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            CoroutineContext coroutineContext3 = (CoroutineContext) c04011.L$2;
            function2 = (Function2) c04011.L$1;
            PointerInputScope pointerInputScope4 = (PointerInputScope) c04011.L$0;
            ResultKt.throwOnFailure(obj);
            r22 = pointerInputScope4;
            pointerInputScope = coroutineContext3;
            c04011.L$0 = r22;
            c04011.L$1 = function2;
            c04011.L$2 = pointerInputScope;
            c04011.label = 2;
            Object objAwaitAllPointersUp22 = awaitAllPointersUp(r22, c04011);
            r2 = r22;
            r82 = pointerInputScope;
        }
    }

    public static final boolean allPointersUp(AwaitPointerEventScope awaitPointerEventScope) {
        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (changes.get(i).getPressed()) {
                z = true;
                break;
            }
            i++;
        }
        return !z;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2 */
    /* JADX INFO: compiled from: ForEachGesture.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2", m1609f = "ForEachGesture.kt", m1610i = {}, m1611l = {75}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03982 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03982(Continuation<? super C03982> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03982 c03982 = new C03982(continuation);
            c03982.L$0 = obj;
            return c03982;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03982) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ForEachGestureKt.awaitAllPointersUp$default((AwaitPointerEventScope) this.L$0, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final Object awaitAllPointersUp(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C03982(null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        if (allPointersUp(r7) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0050 -> B:19:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUp(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super Unit> continuation) {
        C03993 c03993;
        if (continuation instanceof C03993) {
            c03993 = (C03993) continuation;
            if ((c03993.label & Integer.MIN_VALUE) != 0) {
                c03993.label -= Integer.MIN_VALUE;
            } else {
                c03993 = new C03993(continuation);
            }
        }
        Object objAwaitPointerEvent = c03993.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03993.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PointerEventPass pointerEventPass2 = (PointerEventPass) c03993.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c03993.L$0;
            ResultKt.throwOnFailure(objAwaitPointerEvent);
            pointerEventPass = pointerEventPass2;
            awaitPointerEventScope = awaitPointerEventScope2;
            List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
            int size = changes.size();
            int i2 = 0;
            while (i2 < size) {
                if (changes.get(i2).getPressed()) {
                    c03993.L$0 = awaitPointerEventScope;
                    c03993.L$1 = pointerEventPass;
                    c03993.label = 1;
                    objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, c03993);
                    if (objAwaitPointerEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    List<PointerInputChange> changes2 = ((PointerEvent) objAwaitPointerEvent).getChanges();
                    int size2 = changes2.size();
                    int i22 = 0;
                    while (i22 < size2) {
                    }
                } else {
                    i22++;
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(objAwaitPointerEvent);
    }

    public static /* synthetic */ Object awaitAllPointersUp$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Final;
        }
        return awaitAllPointersUp(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2 */
    /* JADX INFO: compiled from: ForEachGesture.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", m1609f = "ForEachGesture.kt", m1610i = {0, 1, 2}, m1611l = {102, LocationRequest.PRIORITY_NO_POWER, 110}, m1612m = "invokeSuspend", m1613n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, m1615s = {"L$0", "L$0", "L$0"}, m1616v = 1)
    static final class C04002 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ CoroutineContext $currentContext;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04002(CoroutineContext coroutineContext, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C04002> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04002 c04002 = new C04002(this.$currentContext, this.$block, continuation);
            c04002.L$0 = obj;
            return c04002;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C04002) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
        
            if (r9 != r0) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        
            if (r9 == r0) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005d -> B:12:0x0029). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0077 -> B:12:0x0029). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ?? r9;
            ?? r1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r12 = this.label;
            try {
            } catch (CancellationException e) {
                e = e;
                if (!JobKt.isActive(this.$currentContext)) {
                }
            }
            if (r12 == 0) {
                ResultKt.throwOnFailure(obj);
                r9 = (AwaitPointerEventScope) this.L$0;
                if (!JobKt.isActive(this.$currentContext)) {
                }
            } else {
                if (r12 != 1) {
                    if (r12 == 2) {
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r1 = awaitPointerEventScope;
                    } else {
                        if (r12 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r1 = awaitPointerEventScope2;
                    }
                    r9 = r1;
                    if (!JobKt.isActive(this.$currentContext)) {
                        try {
                        } catch (CancellationException e2) {
                            r12 = r9;
                            e = e2;
                            if (!JobKt.isActive(this.$currentContext)) {
                                this.L$0 = r12;
                                this.label = 3;
                                Object objAwaitAllPointersUp$default = ForEachGestureKt.awaitAllPointersUp$default(r12, null, this, 1, null);
                                r1 = r12;
                            } else {
                                throw e;
                            }
                        }
                        Function2 function2 = this.$block;
                        this.L$0 = r9;
                        this.label = 1;
                        if (function2.invoke(r9, this) != coroutine_suspended) {
                            r12 = r9;
                            this.L$0 = r12;
                            this.label = 2;
                            Object objAwaitAllPointersUp$default2 = ForEachGestureKt.awaitAllPointersUp$default(r12, null, this, 1, null);
                            r1 = r12;
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r12 = awaitPointerEventScope3;
                this.L$0 = r12;
                this.label = 2;
                Object objAwaitAllPointersUp$default22 = ForEachGestureKt.awaitAllPointersUp$default(r12, null, this, 1, null);
                r1 = r12;
            }
        }
    }

    public static final Object awaitEachGesture(PointerInputScope pointerInputScope, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C04002(continuation.getContext(), function2, null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }
}
