package aws.smithy.kotlin.runtime.p011io;

import androidx.concurrent.futures.C1519xc40028dd;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.container.MdtaMetadataEntry;
import aws.smithy.kotlin.runtime.p011io.internal.AwaitingSlot;
import aws.smithy.kotlin.runtime.p011io.internal.ChannelCapacity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: RealSdkByteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001c\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aH\u0082\b¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b \u0010\u0019J\u001e\u0010!\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aH\u0082\b¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010$J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010(J\u0019\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010$J\u000f\u0010/\u001a\u00020\u0002H\u0002¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b1\u0010-R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00100R\u0018\u00106\u001a\u000604j\u0002`58\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010AR\u0014\u0010E\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u00100R\u0014\u0010F\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u00100R\u0014\u0010I\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006M"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/RealSdkByteChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteChannel;", "", "autoFlush", "", "maxBufferSize", "<init>", "(ZI)V", "", FirebaseAnalytics.Param.CONTENT, TypedValues.CycleType.S_WAVE_OFFSET, "length", "([BII)V", "requested", "", "awaitBytesToRead", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitBytesToWrite", "awaitFreeSpace", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function0;", "block", "reading", "(Lkotlin/jvm/functions/Function0;)J", FirebaseAnalytics.Param.SOURCE, "byteCount", "write", "writing", "(Lkotlin/jvm/functions/Function0;)V", "ensureNotFailed", "()V", "ensureNotClosed", "size", "afterWrite", "(I)V", "afterRead", "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "flush", "tryFlush", "()Z", "close", "Z", "getAutoFlush", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "lock", "Ljava/lang/Object;", "buffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Laws/smithy/kotlin/runtime/io/internal/ChannelCapacity;", "capacity", "Laws/smithy/kotlin/runtime/io/internal/ChannelCapacity;", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "getAvailableForWrite", "()I", "availableForWrite", "getAvailableForRead", "availableForRead", "isClosedForRead", "isClosedForWrite", "getTotalBytesWritten", "()J", "totalBytesWritten", "Laws/smithy/kotlin/runtime/io/internal/AwaitingSlot;", "slot", "Laws/smithy/kotlin/runtime/io/internal/AwaitingSlot;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RealSdkByteChannel implements SdkByteChannel {
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ int _readInProgress;
    private volatile /* synthetic */ long _totalBytesWritten;
    private volatile /* synthetic */ int _writeInProgress;
    private final boolean autoFlush;
    private final SdkBuffer buffer;
    private final ChannelCapacity capacity;
    private final Object lock;
    private final AwaitingSlot slot;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _readInProgress$FU = AtomicIntegerFieldUpdater.newUpdater(RealSdkByteChannel.class, "_readInProgress");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _writeInProgress$FU = AtomicIntegerFieldUpdater.newUpdater(RealSdkByteChannel.class, "_writeInProgress");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU = AtomicReferenceFieldUpdater.newUpdater(RealSdkByteChannel.class, Object.class, "_closed");
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesWritten$FU = AtomicLongFieldUpdater.newUpdater(RealSdkByteChannel.class, "_totalBytesWritten");

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.RealSdkByteChannel$awaitBytesToRead$1 */
    /* JADX INFO: compiled from: RealSdkByteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.RealSdkByteChannel", m1609f = "RealSdkByteChannel.kt", m1610i = {0}, m1611l = {68}, m1612m = "awaitBytesToRead", m1613n = {"requested"}, m1614nl = {70}, m1615s = {"I$0"}, m1616v = 2)
    static final class C37481 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C37481(Continuation<? super C37481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealSdkByteChannel.this.awaitBytesToRead(0, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.RealSdkByteChannel$awaitBytesToWrite$1 */
    /* JADX INFO: compiled from: RealSdkByteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.RealSdkByteChannel", m1609f = "RealSdkByteChannel.kt", m1610i = {0}, m1611l = {75}, m1612m = "awaitBytesToWrite", m1613n = {"requested"}, m1614nl = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m1615s = {"I$0"}, m1616v = 2)
    static final class C37491 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C37491(Continuation<? super C37491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealSdkByteChannel.this.awaitBytesToWrite(0, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.RealSdkByteChannel$awaitFreeSpace$1 */
    /* JADX INFO: compiled from: RealSdkByteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.RealSdkByteChannel", m1609f = "RealSdkByteChannel.kt", m1610i = {}, m1611l = {82}, m1612m = "awaitFreeSpace", m1613n = {}, m1614nl = {83}, m1615s = {}, m1616v = 2)
    static final class C37501 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C37501(Continuation<? super C37501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealSdkByteChannel.this.awaitFreeSpace(this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.RealSdkByteChannel$read$1 */
    /* JADX INFO: compiled from: RealSdkByteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.RealSdkByteChannel", m1609f = "RealSdkByteChannel.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA9_4}, m1612m = "read", m1613n = {"sink", "this_$iv", "limit", "$i$f$reading", "$i$a$-reading-RealSdkByteChannel$read$3"}, m1614nl = {PDFACompliance.e_PDFA9_5}, m1615s = {"L$0", "L$1", "J$0", "I$0", "I$1"}, m1616v = 2)
    static final class C37511 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37511(Continuation<? super C37511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealSdkByteChannel.this.read(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.RealSdkByteChannel$write$1 */
    /* JADX INFO: compiled from: RealSdkByteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.RealSdkByteChannel", m1609f = "RealSdkByteChannel.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {128}, m1612m = "write", m1613n = {FirebaseAnalytics.Param.SOURCE, "remaining", "this_$iv", "byteCount", "$i$f$writing", "$i$a$-writing-RealSdkByteChannel$write$2"}, m1614nl = {PDFACompliance.e_PDFA1_3_1}, m1615s = {"L$0", "L$1", "L$2", "J$0", "I$0", "I$1"}, m1616v = 2)
    static final class C37521 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C37521(Continuation<? super C37521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealSdkByteChannel.this.write(null, 0L, this);
        }
    }

    public RealSdkByteChannel(boolean z, int i) {
        this.autoFlush = z;
        this.lock = new Object();
        this.buffer = new SdkBuffer();
        this.capacity = new ChannelCapacity(i);
        this._readInProgress = 0;
        this._writeInProgress = 0;
        this._closed = null;
        this._totalBytesWritten = 0L;
        this.slot = new AwaitingSlot();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteChannel, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ void close() {
        super.close();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RealSdkByteChannel(byte[] bArr, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        i = (i3 & 2) != 0 ? 0 : i;
        this(bArr, i, (i3 & 4) != 0 ? bArr.length - i : i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RealSdkByteChannel(byte[] content, int i, int i2) throws IOException {
        this(true, i2);
        Intrinsics.checkNotNullParameter(content, "content");
        if (i2 > getAvailableForWrite()) {
            throw new IllegalArgumentException("Initial contents overflow maximum channel capacity".toString());
        }
        this.buffer.write(content, i, i2);
        afterWrite(i2);
        close();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Throwable getClosedCause() {
        ClosedSentinel closedSentinel = (ClosedSentinel) this._closed;
        if (closedSentinel != null) {
            return closedSentinel.getCause();
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public int getAvailableForWrite() {
        return this.capacity._availableForWrite$internal;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public int getAvailableForRead() {
        return this.capacity._availableForRead$internal;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForRead() {
        if (getClosedCause() == null) {
            return isClosedForWrite() && getAvailableForRead() == 0;
        }
        return true;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForWrite() {
        return this._closed != null;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    /* JADX INFO: renamed from: getTotalBytesWritten, reason: from getter */
    public long get_totalBytesWritten() {
        return this._totalBytesWritten;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitBytesToRead(final int i, Continuation<? super Unit> continuation) {
        C37481 c37481;
        if (continuation instanceof C37481) {
            c37481 = (C37481) continuation;
            if ((c37481.label & Integer.MIN_VALUE) != 0) {
                c37481.label -= Integer.MIN_VALUE;
            } else {
                c37481 = new C37481(continuation);
            }
        }
        Object obj = c37481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37481.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c37481.I$0;
        }
        ResultKt.throwOnFailure(obj);
        while (getAvailableForRead() < i && !isClosedForRead()) {
            AwaitingSlot awaitingSlot = this.slot;
            Function0<Boolean> function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.io.RealSdkByteChannel$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(RealSdkByteChannel.awaitBytesToRead$lambda$0(this.f$0, i));
                }
            };
            c37481.I$0 = i;
            c37481.label = 1;
            if (awaitingSlot.sleep(function0, c37481) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean awaitBytesToRead$lambda$0(RealSdkByteChannel realSdkByteChannel, int i) {
        return realSdkByteChannel.getAvailableForRead() < i && !realSdkByteChannel.isClosedForRead();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitBytesToWrite(final int i, Continuation<? super Unit> continuation) {
        C37491 c37491;
        if (continuation instanceof C37491) {
            c37491 = (C37491) continuation;
            if ((c37491.label & Integer.MIN_VALUE) != 0) {
                c37491.label -= Integer.MIN_VALUE;
            } else {
                c37491 = new C37491(continuation);
            }
        }
        Object obj = c37491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37491.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c37491.I$0;
        }
        ResultKt.throwOnFailure(obj);
        while (getAvailableForWrite() < i && !isClosedForWrite()) {
            if (!tryFlush()) {
                AwaitingSlot awaitingSlot = this.slot;
                Function0<Boolean> function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.io.RealSdkByteChannel$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(RealSdkByteChannel.awaitBytesToWrite$lambda$0(this.f$0, i));
                    }
                };
                c37491.I$0 = i;
                c37491.label = 1;
                if (awaitingSlot.sleep(function0, c37491) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean awaitBytesToWrite$lambda$0(RealSdkByteChannel realSdkByteChannel, int i) {
        return realSdkByteChannel.getAvailableForWrite() < i && !realSdkByteChannel.isClosedForWrite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitFreeSpace(Continuation<? super Unit> continuation) throws Throwable {
        C37501 c37501;
        if (continuation instanceof C37501) {
            c37501 = (C37501) continuation;
            if ((c37501.label & Integer.MIN_VALUE) != 0) {
                c37501.label -= Integer.MIN_VALUE;
            } else {
                c37501 = new C37501(continuation);
            }
        }
        Object obj = c37501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37501.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flush();
            c37501.label = 1;
            if (awaitBytesToWrite(1, c37501) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ensureNotClosed();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0092 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #3 {all -> 0x009c, blocks: (B:35:0x0089, B:37:0x0092, B:43:0x00a0, B:44:0x00ab, B:46:0x00b3, B:49:0x00b8, B:53:0x00c7, B:54:0x00c8, B:45:0x00ac), top: B:68:0x0089, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) throws Throwable {
        C37511 c37511;
        RealSdkByteChannel realSdkByteChannel;
        RealSdkByteChannel realSdkByteChannel2;
        if (continuation instanceof C37511) {
            c37511 = (C37511) continuation;
            if ((c37511.label & Integer.MIN_VALUE) != 0) {
                c37511.label -= Integer.MIN_VALUE;
            } else {
                c37511 = new C37511(continuation);
            }
        }
        Object obj = c37511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (j < 0) {
                throw new IllegalArgumentException(("Read limit must be >= 0, was " + j).toString());
            }
            ensureNotFailed();
            if (isClosedForRead()) {
                return Boxing.boxLong(-1L);
            }
            if (j == 0) {
                return Boxing.boxLong(0L);
            }
            try {
                if (_readInProgress$FU.compareAndSet(this, 0, 1)) {
                    if (getAvailableForRead() == 0) {
                        c37511.L$0 = sdkBuffer;
                        c37511.L$1 = this;
                        c37511.J$0 = j;
                        c37511.I$0 = 0;
                        c37511.I$1 = 0;
                        c37511.label = 1;
                        if (awaitBytesToRead(1, c37511) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        realSdkByteChannel2 = this;
                        ensureNotFailed();
                        if (isClosedForRead()) {
                        }
                    } else {
                        realSdkByteChannel2 = this;
                    }
                } else {
                    throw new IllegalStateException("Read operation already in progress".toString());
                }
            } catch (Throwable th) {
                th = th;
                realSdkByteChannel = this;
                _readInProgress$FU.compareAndSet(realSdkByteChannel, 1, 0);
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c37511.I$1;
            int i3 = c37511.I$0;
            long j2 = c37511.J$0;
            realSdkByteChannel = (RealSdkByteChannel) c37511.L$1;
            SdkBuffer sdkBuffer2 = (SdkBuffer) c37511.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                realSdkByteChannel2 = realSdkByteChannel;
                j = j2;
                sdkBuffer = sdkBuffer2;
            } catch (Throwable th2) {
                th = th2;
                _readInProgress$FU.compareAndSet(realSdkByteChannel, 1, 0);
                throw th;
            }
            try {
                ensureNotFailed();
                if (isClosedForRead()) {
                    Long lBoxLong = Boxing.boxLong(-1L);
                    _readInProgress$FU.compareAndSet(realSdkByteChannel2, 1, 0);
                    return lBoxLong;
                }
            } catch (Throwable th3) {
                th = th3;
                realSdkByteChannel = realSdkByteChannel2;
                _readInProgress$FU.compareAndSet(realSdkByteChannel, 1, 0);
                throw th;
            }
        }
        long jMin = Math.min(getAvailableForRead(), j);
        synchronized (this.lock) {
            sdkBuffer.write(this.buffer, jMin);
            Unit unit = Unit.INSTANCE;
        }
        if (jMin >= 0) {
            realSdkByteChannel2.afterRead((int) jMin);
        }
        _readInProgress$FU.compareAndSet(realSdkByteChannel2, 1, 0);
        return Boxing.boxLong(jMin);
    }

    private final long reading(Function0<Long> block) {
        try {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _readInProgress$FU;
            if (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                throw new IllegalStateException("Read operation already in progress".toString());
            }
            long jLongValue = block.invoke().longValue();
            if (jLongValue >= 0) {
                afterRead((int) jLongValue);
            }
            atomicIntegerFieldUpdater.compareAndSet(this, 1, 0);
            return jLongValue;
        } catch (Throwable th) {
            _readInProgress$FU.compareAndSet(this, 1, 0);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0088 -> B:33:0x008b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008f -> B:58:0x0090). Please report as a decompilation issue!!! */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object write(SdkBuffer sdkBuffer, long j, Continuation<? super Unit> continuation) throws Throwable {
        C37521 c37521;
        Ref.LongRef longRef;
        Throwable th;
        RealSdkByteChannel realSdkByteChannel;
        if (continuation instanceof C37521) {
            c37521 = (C37521) continuation;
            if ((c37521.label & Integer.MIN_VALUE) != 0) {
                c37521.label -= Integer.MIN_VALUE;
            } else {
                c37521 = new C37521(continuation);
            }
        }
        Object obj = c37521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37521.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c37521.I$1;
            int i3 = c37521.I$0;
            long j2 = c37521.J$0;
            RealSdkByteChannel realSdkByteChannel2 = (RealSdkByteChannel) c37521.L$2;
            longRef = (Ref.LongRef) c37521.L$1;
            SdkBuffer sdkBuffer2 = (SdkBuffer) c37521.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                realSdkByteChannel = realSdkByteChannel2;
                j = j2;
                sdkBuffer = sdkBuffer2;
                try {
                    long jMin = Math.min(getAvailableForWrite(), longRef.element);
                    synchronized (this.lock) {
                        this.buffer.write(sdkBuffer, jMin);
                        Unit unit = Unit.INSTANCE;
                    }
                    longRef.element -= jMin;
                    realSdkByteChannel.afterWrite((int) jMin);
                    _writeInProgress$FU.compareAndSet(realSdkByteChannel, 1, 0);
                } catch (Throwable th2) {
                    th = th2;
                    realSdkByteChannel2 = realSdkByteChannel;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            if (longRef.element > 0) {
                return Unit.INSTANCE;
            }
            try {
                if (_writeInProgress$FU.compareAndSet(this, 0, 1)) {
                    if (getAvailableForWrite() == 0) {
                        c37521.L$0 = sdkBuffer;
                        c37521.L$1 = longRef;
                        c37521.L$2 = this;
                        c37521.J$0 = j;
                        c37521.I$0 = 0;
                        c37521.I$1 = 0;
                        c37521.label = 1;
                        if (awaitFreeSpace(c37521) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sdkBuffer2 = sdkBuffer;
                        j2 = j;
                        realSdkByteChannel2 = this;
                        realSdkByteChannel = realSdkByteChannel2;
                        j = j2;
                        sdkBuffer = sdkBuffer2;
                        long jMin2 = Math.min(getAvailableForWrite(), longRef.element);
                        synchronized (this.lock) {
                        }
                    } else {
                        realSdkByteChannel = this;
                        long jMin22 = Math.min(getAvailableForWrite(), longRef.element);
                        synchronized (this.lock) {
                        }
                    }
                } else {
                    throw new IllegalStateException("Write operation already in progress".toString());
                }
            } catch (Throwable th4) {
                th = th4;
                realSdkByteChannel2 = this;
            }
            _writeInProgress$FU.compareAndSet(realSdkByteChannel2, 1, 0);
            throw th;
        }
        ResultKt.throwOnFailure(obj);
        ensureNotClosed();
        if (j == 0) {
            return Unit.INSTANCE;
        }
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = j;
        longRef = longRef2;
        if (longRef.element > 0) {
        }
    }

    private final void writing(Function0<Long> block) {
        try {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _writeInProgress$FU;
            if (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                throw new IllegalStateException("Write operation already in progress".toString());
            }
            afterWrite((int) block.invoke().longValue());
            atomicIntegerFieldUpdater.compareAndSet(this, 1, 0);
        } catch (Throwable th) {
            _writeInProgress$FU.compareAndSet(this, 1, 0);
            throw th;
        }
    }

    private final void ensureNotFailed() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    private final void ensureNotClosed() throws Throwable {
        if (isClosedForWrite()) {
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            throw new ClosedWriteChannelException("Channel " + this + " is already closed");
        }
    }

    private final void afterWrite(int size) {
        this.capacity.completeWrite(size);
        _totalBytesWritten$FU.getAndAdd(this, size);
        if (getAutoFlush() || getAvailableForWrite() == 0) {
            flush();
        }
    }

    private final void afterRead(int size) {
        this.capacity.completeRead(size);
        this.slot.resume();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean cancel(Throwable cause) {
        if (isClosedForWrite()) {
            return false;
        }
        if (cause == null) {
            cause = new CancellationException("Channel cancelled");
        }
        return close(cause);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public void flush() {
        tryFlush();
    }

    private final boolean tryFlush() {
        if (this.capacity._pendingToFlush$internal == 0) {
            this.slot.resume();
            return false;
        }
        this.capacity.flush();
        this.slot.resume();
        return true;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public boolean close(Throwable cause) {
        if (isClosedForWrite()) {
            return false;
        }
        if (!C1519xc40028dd.m48m(_closed$FU, this, null, cause == null ? RealSdkByteChannelKt.CLOSED_SUCCESS : new ClosedSentinel(cause))) {
            return false;
        }
        if (cause == null) {
            flush();
            return true;
        }
        this.slot.cancel(cause);
        return true;
    }
}
