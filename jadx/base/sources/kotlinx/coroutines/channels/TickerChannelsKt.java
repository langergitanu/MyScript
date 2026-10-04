package kotlinx.coroutines.channels;

import com.google.android.gms.location.LocationRequest;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.yalantis.ucrop.UCrop;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: TickerChannels.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a,\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r\u001a,\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, m1599d2 = {"ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "delayMillis", "", "initialDelayMillis", WebViewMessageType.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "fixedPeriodTicker", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedDelayTicker", "kotlinx-coroutines-core"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TickerChannelsKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "kotlinx.coroutines.channels.TickerChannelsKt", m1609f = "TickerChannels.kt", m1610i = {0, 0, 1, 1, 2, 2}, m1611l = {102, 104, LocationRequest.PRIORITY_NO_POWER}, m1612m = "fixedDelayTicker", m1613n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, m1615s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    static final class C87511 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C87511(Continuation<? super C87511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedDelayTicker(0L, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "kotlinx.coroutines.channels.TickerChannelsKt", m1609f = "TickerChannels.kt", m1610i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, m1611l = {80, 84, 90, PDFACompliance.e_PDFA9_2}, m1612m = "fixedPeriodTicker", m1613n = {"channel", "delayMillis", "deadline", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs"}, m1615s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
    static final class C87521 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C87521(Continuation<? super C87521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedPeriodTicker(0L, 0L, null, this);
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        if (j < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 < 0) {
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new C87533(tickerMode, j, j2, null));
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3 */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", m1609f = "TickerChannels.kt", m1610i = {}, m1611l = {68, UCrop.REQUEST_CROP}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C87533 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        final /* synthetic */ TickerMode $mode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3$WhenMappings */
        /* JADX INFO: compiled from: TickerChannels.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TickerMode.values().length];
                try {
                    iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C87533(TickerMode tickerMode, long j, long j2, Continuation<? super C87533> continuation) {
            super(2, continuation);
            this.$mode = tickerMode;
            this.$delayMillis = j;
            this.$initialDelayMillis = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C87533 c87533 = new C87533(this.$mode, this.$delayMillis, this.$initialDelayMillis, continuation);
            c87533.L$0 = obj;
            return c87533;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
            return ((C87533) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker(r10.$delayMillis, r10.$initialDelayMillis, r11.getChannel(), r10) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        
            if (kotlinx.coroutines.channels.TickerChannelsKt.fixedPeriodTicker(r10.$delayMillis, r10.$initialDelayMillis, r11.getChannel(), r10) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
                if (i2 == 1) {
                    this.label = 1;
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.label = 2;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) == r2) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0114, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) != r2) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00fe -> B:31:0x00ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0114 -> B:15:0x003e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        C87521 c87521;
        SendChannel sendChannel2;
        long j3;
        long j4;
        long jDelayToNanos;
        long j5;
        long j6;
        SendChannel sendChannel3;
        char c;
        long j7;
        long jCoerceAtLeast;
        char c2;
        char c3;
        Unit unit;
        if (continuation instanceof C87521) {
            c87521 = (C87521) continuation;
            if ((c87521.label & Integer.MIN_VALUE) != 0) {
                c87521.label -= Integer.MIN_VALUE;
            } else {
                c87521 = new C87521(continuation);
            }
        }
        Object obj = c87521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c87521.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
            long jNanoTime = (abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime()) + EventLoop_commonKt.delayToNanos(j2);
            sendChannel2 = sendChannel;
            c87521.L$0 = sendChannel2;
            j3 = j;
            c87521.J$0 = j3;
            c87521.J$1 = jNanoTime;
            c87521.label = 1;
            if (DelayKt.delay(j2, c87521) != coroutine_suspended) {
                j4 = jNanoTime;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                j6 = c87521.J$1;
                j7 = c87521.J$0;
                sendChannel3 = (SendChannel) c87521.L$0;
                ResultKt.throwOnFailure(obj);
                AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
                if (abstractTimeSource2 == null) {
                }
                jCoerceAtLeast = RangesKt.coerceAtLeast(j7 - jNanoTime, 0L);
                if (jCoerceAtLeast != 0) {
                    c2 = 3;
                    long jDelayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                    c87521.L$0 = sendChannel3;
                    c87521.J$0 = j7;
                    c87521.J$1 = j6;
                    c3 = 4;
                    c87521.label = 4;
                }
                long j8 = j4 + jDelayToNanos;
                unit = Unit.INSTANCE;
                c87521.L$0 = sendChannel2;
                c87521.J$0 = j8;
                c87521.J$1 = jDelayToNanos;
                c87521.label = 2;
                if (sendChannel2.send(unit, c87521) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 3) {
                j6 = c87521.J$1;
                j5 = c87521.J$0;
                sendChannel3 = (SendChannel) c87521.L$0;
                ResultKt.throwOnFailure(obj);
                c = 3;
                long j9 = j5;
                jDelayToNanos = j6;
                j4 = j9;
                sendChannel2 = sendChannel3;
                long j82 = j4 + jDelayToNanos;
                unit = Unit.INSTANCE;
                c87521.L$0 = sendChannel2;
                c87521.J$0 = j82;
                c87521.J$1 = jDelayToNanos;
                c87521.label = 2;
                if (sendChannel2.send(unit, c87521) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j6 = c87521.J$1;
            j7 = c87521.J$0;
            sendChannel3 = (SendChannel) c87521.L$0;
            ResultKt.throwOnFailure(obj);
            c3 = 4;
            c2 = 3;
            long j10 = j7;
            jDelayToNanos = j6;
            j4 = j10;
            sendChannel2 = sendChannel3;
            long j822 = j4 + jDelayToNanos;
            unit = Unit.INSTANCE;
            c87521.L$0 = sendChannel2;
            c87521.J$0 = j822;
            c87521.J$1 = jDelayToNanos;
            c87521.label = 2;
            if (sendChannel2.send(unit, c87521) != coroutine_suspended) {
                long j11 = jDelayToNanos;
                j7 = j822;
                j6 = j11;
                sendChannel3 = sendChannel2;
                AbstractTimeSource abstractTimeSource22 = AbstractTimeSourceKt.timeSource;
                long jNanoTime2 = abstractTimeSource22 == null ? abstractTimeSource22.nanoTime() : System.nanoTime();
                jCoerceAtLeast = RangesKt.coerceAtLeast(j7 - jNanoTime2, 0L);
                if (jCoerceAtLeast != 0 && j6 != 0) {
                    long j12 = j6 - ((jNanoTime2 - j7) % j6);
                    j5 = jNanoTime2 + j12;
                    long jDelayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j12);
                    c87521.L$0 = sendChannel3;
                    c87521.J$0 = j5;
                    c87521.J$1 = j6;
                    c = 3;
                    c87521.label = 3;
                } else {
                    c2 = 3;
                    long jDelayNanosToMillis3 = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                    c87521.L$0 = sendChannel3;
                    c87521.J$0 = j7;
                    c87521.J$1 = j6;
                    c3 = 4;
                    c87521.label = 4;
                }
            }
            return coroutine_suspended;
        }
        j4 = c87521.J$1;
        long j13 = c87521.J$0;
        SendChannel sendChannel4 = (SendChannel) c87521.L$0;
        ResultKt.throwOnFailure(obj);
        sendChannel2 = sendChannel4;
        j3 = j13;
        jDelayToNanos = EventLoop_commonKt.delayToNanos(j3);
        long j8222 = j4 + jDelayToNanos;
        unit = Unit.INSTANCE;
        c87521.L$0 = sendChannel2;
        c87521.J$0 = j8222;
        c87521.J$1 = jDelayToNanos;
        c87521.label = 2;
        if (sendChannel2.send(unit, c87521) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) != r1) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        C87511 c87511;
        SendChannel<? super Unit> sendChannel2;
        if (continuation instanceof C87511) {
            c87511 = (C87511) continuation;
            if ((c87511.label & Integer.MIN_VALUE) != 0) {
                c87511.label -= Integer.MIN_VALUE;
            } else {
                c87511 = new C87511(continuation);
            }
        }
        Object obj = c87511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c87511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c87511.L$0 = sendChannel;
            c87511.J$0 = j;
            c87511.label = 1;
            if (DelayKt.delay(j2, c87511) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j = c87511.J$0;
            sendChannel = (SendChannel) c87511.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            j = c87511.J$0;
            sendChannel2 = (SendChannel) c87511.L$0;
            ResultKt.throwOnFailure(obj);
            c87511.L$0 = sendChannel2;
            c87511.J$0 = j;
            c87511.label = 3;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c87511.J$0;
            sendChannel2 = (SendChannel) c87511.L$0;
            ResultKt.throwOnFailure(obj);
            sendChannel = sendChannel2;
        }
        Unit unit = Unit.INSTANCE;
        c87511.L$0 = sendChannel;
        c87511.J$0 = j;
        c87511.label = 2;
        if (sendChannel.send(unit, c87511) != coroutine_suspended) {
            sendChannel2 = sendChannel;
            c87511.L$0 = sendChannel2;
            c87511.J$0 = j;
            c87511.label = 3;
        }
        return coroutine_suspended;
    }
}
