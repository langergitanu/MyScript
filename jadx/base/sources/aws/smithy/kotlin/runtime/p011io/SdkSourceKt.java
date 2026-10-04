package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.internal.JobChannel;
import aws.smithy.kotlin.runtime.p011io.internal.SdkDispatchers;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: SdkSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkSource;", "", "readToByteArray", "(Laws/smithy/kotlin/runtime/io/SdkSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "toSdkByteReadChannel", "(Laws/smithy/kotlin/runtime/io/SdkSource;Lkotlinx/coroutines/CoroutineScope;)Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "byteCount", "", "readFully", "(Laws/smithy/kotlin/runtime/io/SdkSource;Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "readRemaining", "(Laws/smithy/kotlin/runtime/io/SdkSource;Laws/smithy/kotlin/runtime/io/SdkBuffer;)J", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkSourceKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkSourceKt$readToByteArray$2 */
    /* JADX INFO: compiled from: SdkSource.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkSourceKt$readToByteArray$2", m1609f = "SdkSource.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C37602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        final /* synthetic */ SdkSource $this_readToByteArray;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37602(SdkSource sdkSource, Continuation<? super C37602> continuation) {
            super(2, continuation);
            this.$this_readToByteArray = sdkSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37602(this.$this_readToByteArray, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((C37602) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SdkSource sdkSource = this.$this_readToByteArray;
            try {
                byte[] byteArray = SdkIoKt.buffer(sdkSource).readByteArray();
                sdkSource.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    sdkSource.close();
                } catch (Throwable th2) {
                    ExceptionsKt.addSuppressed(th, th2);
                }
                throw th;
            }
        }
    }

    @InternalApi
    public static final Object readToByteArray(SdkSource sdkSource, Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(SdkDispatchers.INSTANCE.getIO(), new C37602(sdkSource, null), continuation);
    }

    public static /* synthetic */ SdkByteReadChannel toSdkByteReadChannel$default(SdkSource sdkSource, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineScope = null;
        }
        return toSdkByteReadChannel(sdkSource, coroutineScope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InternalApi
    public static final SdkByteReadChannel toSdkByteReadChannel(SdkSource sdkSource, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(sdkSource, "<this>");
        JobChannel jobChannel = new JobChannel(null, 1, 0 == true ? 1 : 0);
        if (coroutineScope == null) {
            coroutineScope = GlobalScope.INSTANCE;
        }
        jobChannel.attachJob(BuildersKt__Builders_commonKt.launch$default(coroutineScope, SdkDispatchers.INSTANCE.getIO().plus(new CoroutineName("sdk-source-reader")), null, new SdkSourceKt$toSdkByteReadChannel$job$1(jobChannel, sdkSource, null), 2, null));
        return jobChannel;
    }

    public static final void readFully(SdkSource sdkSource, SdkBuffer sink, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkSource, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException(("Invalid length (" + j + ") must be >= 0L").toString());
        }
        while (j2 != j) {
            long j3 = j - j2;
            long j4 = sdkSource.read(sink, j3);
            if (j4 == -1) {
                throw new EOFException("Unexpected EOF: expected " + j3 + " more bytes; consumed: " + j2);
            }
            j2 += j4;
        }
    }

    @InternalApi
    public static final long readRemaining(SdkSource sdkSource, SdkBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sdkSource, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = sdkSource.read(sink, Long.MAX_VALUE);
        long j2 = 0;
        while (j != -1) {
            j2 += j;
            j = sdkSource.read(sink, Long.MAX_VALUE);
        }
        return j2;
    }
}
