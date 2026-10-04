package aws.smithy.kotlin.runtime.p011io;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: SdkByteReadChannelJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/InputAdapter;", "Ljava/io/InputStream;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "ch", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;)V", "", "read", "()I", "", "b", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "([BII)I", "", "readBlocking", "()J", "available", "", "close", "()V", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "buffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class InputAdapter extends InputStream {
    private final SdkBuffer buffer;
    private final SdkByteReadChannel ch;

    public InputAdapter(SdkByteReadChannel ch2) {
        Intrinsics.checkNotNullParameter(ch2, "ch");
        this.ch = ch2;
        this.buffer = new SdkBuffer();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.ch.isClosedForRead() && this.buffer.getSize() == 0) {
            return -1;
        }
        if (this.buffer.getSize() == 0 && readBlocking() == -1) {
            return -1;
        }
        return this.buffer.readByte() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        if (this.ch.isClosedForRead() && this.buffer.getSize() == 0) {
            return -1;
        }
        if (this.buffer.getSize() == 0 && readBlocking() == -1) {
            return -1;
        }
        return this.buffer.read(b, off, len);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.InputAdapter$readBlocking$1 */
    /* JADX INFO: compiled from: SdkByteReadChannelJVM.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.InputAdapter$readBlocking$1", m1609f = "SdkByteReadChannelJVM.kt", m1610i = {}, m1611l = {48}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C37471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        int label;

        C37471(Continuation<? super C37471> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InputAdapter.this.new C37471(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C37471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object obj2 = InputAdapter.this.ch.read(InputAdapter.this.buffer, 8192L, this);
            return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
        }
    }

    private final long readBlocking() {
        return ((Number) BuildersKt__BuildersKt.runBlocking$default(null, new C37471(null), 1, null)).longValue();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.ch.getAvailableForRead();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.ch.cancel(null);
    }
}
