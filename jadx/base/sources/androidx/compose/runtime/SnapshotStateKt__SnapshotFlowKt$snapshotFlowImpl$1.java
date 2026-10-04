package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1", m1609f = "SnapshotFlow.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, m1611l = {467, 470, 475}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "manager", "needToRerunBlock", "lastValue", "$this$flow", "manager", "needToRerunBlock", "lastValue", "$this$flow", "manager", "needToRerunBlock", "lastValue"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, m1616v = 1)
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    final /* synthetic */ SnapshotFlowManager $externalManager;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1(SnapshotFlowManager snapshotFlowManager, Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1> continuation) {
        super(2, continuation);
        this.$externalManager = snapshotFlowManager;
        this.$block = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1 snapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1(this.$externalManager, this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:26:0x0085, B:31:0x00a8], limit reached: 41 */
    /* JADX WARN: Path cross not found for [B:31:0x00a8, B:26:0x0085], limit reached: 41 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099 A[Catch: all -> 0x004c, PHI: r1 r4 r5 r6
      0x0099: PHI (r1v5 java.lang.Object) = (r1v10 java.lang.Object), (r1v13 java.lang.Object) binds: [B:27:0x0096, B:11:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r4v7 ??) = (r4v21 ??), (r4v22 ??) binds: [B:27:0x0096, B:11:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r5v3 androidx.compose.runtime.SnapshotFlowManager) = (r5v4 androidx.compose.runtime.SnapshotFlowManager), (r5v9 androidx.compose.runtime.SnapshotFlowManager) binds: [B:27:0x0096, B:11:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r6v2 ??) = (r6v17 ??), (r6v18 ??) binds: [B:27:0x0096, B:11:0x0036] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x004c, blocks: (B:14:0x0048, B:26:0x0085, B:29:0x0099, B:31:0x00a8, B:11:0x0036), top: B:41:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #0 {all -> 0x004c, blocks: (B:14:0x0048, B:26:0x0085, B:29:0x0099, B:31:0x00a8, B:11:0x0036), top: B:41:0x0009 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, kotlinx.coroutines.channels.Channel] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a6 -> B:26:0x0085). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00bc -> B:26:0x0085). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        SnapshotFlowManager snapshotFlowManager;
        Object objRunAndWatch$runtime;
        ?? r6;
        ?? r4;
        Object objRunAndWatch$runtime2;
        ?? r62;
        FlowCollector flowCollector;
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r42 = 1;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ?? r63 = (FlowCollector) this.L$0;
                SnapshotFlowManager snapshotFlowManager2 = this.$externalManager;
                if (snapshotFlowManager2 == null) {
                    snapshotFlowManager2 = new SnapshotFlowManager();
                }
                snapshotFlowManager = snapshotFlowManager2;
                Channel channelChannel$default = ChannelKt.Channel$default(1, null, null, 6, null);
                try {
                    objRunAndWatch$runtime = snapshotFlowManager.runAndWatch$runtime(channelChannel$default, this.$block);
                    this.L$0 = r63;
                    this.L$1 = snapshotFlowManager;
                    this.L$2 = channelChannel$default;
                    this.L$3 = objRunAndWatch$runtime;
                    this.label = 1;
                    if (r63.emit(objRunAndWatch$runtime, this) != coroutine_suspended) {
                        r42 = channelChannel$default;
                        r62 = r63;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    r42 = channelChannel$default;
                    th = th;
                    snapshotFlowManager.reportSnapshotFlowCancellation$runtime((SendChannel) r42);
                    if (this.$externalManager == null) {
                        snapshotFlowManager.dispose();
                    }
                    throw th;
                }
            }
            if (i == 1) {
                objRunAndWatch$runtime = this.L$3;
                Channel channel2 = (Channel) this.L$2;
                snapshotFlowManager = (SnapshotFlowManager) this.L$1;
                channel = channel2;
                flowCollector = (FlowCollector) this.L$0;
            } else if (i == 2) {
                objRunAndWatch$runtime = this.L$3;
                Channel channel3 = (Channel) this.L$2;
                snapshotFlowManager = (SnapshotFlowManager) this.L$1;
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                r4 = channel3;
                r6 = flowCollector2;
                objRunAndWatch$runtime2 = snapshotFlowManager.runAndWatch$runtime((SendChannel) r4, this.$block);
                r42 = r4;
                r62 = r6;
                if (!Intrinsics.areEqual(objRunAndWatch$runtime2, objRunAndWatch$runtime)) {
                    this.L$0 = r6;
                    this.L$1 = snapshotFlowManager;
                    this.L$2 = r4;
                    this.L$3 = objRunAndWatch$runtime2;
                    this.label = 3;
                    if (r6.emit(objRunAndWatch$runtime2, this) != coroutine_suspended) {
                        objRunAndWatch$runtime = objRunAndWatch$runtime2;
                        r42 = r4;
                        r62 = r6;
                    }
                    return coroutine_suspended;
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objRunAndWatch$runtime = this.L$3;
                Channel channel4 = (Channel) this.L$2;
                snapshotFlowManager = (SnapshotFlowManager) this.L$1;
                channel = channel4;
                flowCollector = (FlowCollector) this.L$0;
            }
            ResultKt.throwOnFailure(obj);
            r42 = channel;
            r62 = flowCollector;
            this.L$0 = r62;
            this.L$1 = snapshotFlowManager;
            this.L$2 = r42;
            this.L$3 = objRunAndWatch$runtime;
            this.label = 2;
            Object objReceive = r42.receive(this);
            r4 = r42;
            r6 = r62;
            if (objReceive == coroutine_suspended) {
                objRunAndWatch$runtime2 = snapshotFlowManager.runAndWatch$runtime((SendChannel) r4, this.$block);
                r42 = r4;
                r62 = r6;
                if (!Intrinsics.areEqual(objRunAndWatch$runtime2, objRunAndWatch$runtime)) {
                }
                this.L$0 = r62;
                this.L$1 = snapshotFlowManager;
                this.L$2 = r42;
                this.L$3 = objRunAndWatch$runtime;
                this.label = 2;
                Object objReceive2 = r42.receive(this);
                r4 = r42;
                r6 = r62;
                if (objReceive2 == coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
