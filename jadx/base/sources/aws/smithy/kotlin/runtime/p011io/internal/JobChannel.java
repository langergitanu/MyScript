package aws.smithy.kotlin.runtime.p011io.internal;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannelKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0010J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0096A¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0014H\u0096A¢\u0006\u0004\b\u001a\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001bR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\tR\u0014\u0010\"\u001a\u00020\f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010%R\r\u0010)\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0005R\u0014\u0010*\u001a\u00020\f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010!R\u000b\u0010+\u001a\u00020\f8\u0016X\u0096\u0005R\u0014\u0010.\u001a\u00020\u00148\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/JobChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteChannel;", "delegate", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkByteChannel;)V", "Lkotlinx/coroutines/Job;", "job", "", "attachJob", "(Lkotlinx/coroutines/Job;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "close", "()V", "flush", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", FirebaseAnalytics.Param.SOURCE, "byteCount", "write", "Laws/smithy/kotlin/runtime/io/SdkByteChannel;", "Lkotlinx/coroutines/Job;", "getJob$runtime_core", "()Lkotlinx/coroutines/Job;", "setJob$runtime_core", "getAutoFlush", "()Z", "autoFlush", "", "getAvailableForRead", "()I", "availableForRead", "getAvailableForWrite", "availableForWrite", "closedCause", "isClosedForRead", "isClosedForWrite", "getTotalBytesWritten", "()J", "totalBytesWritten", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JobChannel implements SdkByteChannel {
    private final SdkByteChannel delegate;
    private Job job;

    /* JADX WARN: Multi-variable type inference failed */
    public JobChannel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteChannel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public void flush() {
        this.delegate.flush();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public boolean getAutoFlush() {
        return this.delegate.getAutoFlush();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public int getAvailableForRead() {
        return this.delegate.getAvailableForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public int getAvailableForWrite() {
        return this.delegate.getAvailableForWrite();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Throwable getClosedCause() {
        return this.delegate.getClosedCause();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    /* JADX INFO: renamed from: getTotalBytesWritten */
    public long get_totalBytesWritten() {
        return this.delegate.get_totalBytesWritten();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForRead() {
        return this.delegate.isClosedForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForWrite() {
        return this.delegate.isClosedForWrite();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) {
        return this.delegate.read(sdkBuffer, j, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public Object write(SdkBuffer sdkBuffer, long j, Continuation<? super Unit> continuation) {
        return this.delegate.write(sdkBuffer, j, continuation);
    }

    public JobChannel(SdkByteChannel delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public /* synthetic */ JobChannel(SdkByteChannel sdkByteChannel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SdkByteChannelKt.SdkByteChannel$default(true, 0, 2, null) : sdkByteChannel);
    }

    /* JADX INFO: renamed from: getJob$runtime_core, reason: from getter */
    public final Job getJob() {
        return this.job;
    }

    public final void setJob$runtime_core(Job job) {
        this.job = job;
    }

    public final void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (isClosedForRead()) {
            job.cancel(ExceptionsKt.CancellationException("channel was already closed", this.delegate.getClosedCause()));
        } else {
            this.job = job;
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean cancel(Throwable cause) {
        Job job = this.job;
        if (job != null) {
            job.cancel(ExceptionsKt.CancellationException("channel was cancelled", cause));
        }
        return this.delegate.cancel(cause);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel
    public boolean close(Throwable cause) {
        Job job;
        if (cause != null && (job = this.job) != null) {
            job.cancel(ExceptionsKt.CancellationException("channel was closed with cause", cause));
        }
        return this.delegate.close(cause);
    }
}
