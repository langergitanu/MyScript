package aws.smithy.kotlin.runtime.p011io;

import androidx.media3.container.MdtaMetadataEntry;
import aws.smithy.kotlin.runtime.p011io.internal.JobChannel;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.internal.http2.Http2Stream;

/* JADX INFO: compiled from: SdkSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkSourceKt$toSdkByteReadChannel$job$1", m1609f = "SdkSource.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "buffer", "$this$invokeSuspend_u24lambda_u240", "$this$use$iv", "it", "$i$a$-runCatching-SdkSourceKt$toSdkByteReadChannel$job$1$result$1", "$i$f$use", "closed$iv", "$i$a$-use-SdkSourceKt$toSdkByteReadChannel$job$1$result$1$1", "rc"}, m1614nl = {80}, m1615s = {"L$0", "L$1", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "J$0"}, m1616v = 2)
final class SdkSourceKt$toSdkByteReadChannel$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JobChannel $ch;
    final /* synthetic */ SdkSource $source;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SdkSourceKt$toSdkByteReadChannel$job$1(JobChannel jobChannel, SdkSource sdkSource, Continuation<? super SdkSourceKt$toSdkByteReadChannel$job$1> continuation) {
        super(2, continuation);
        this.$ch = jobChannel;
        this.$source = sdkSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SdkSourceKt$toSdkByteReadChannel$job$1 sdkSourceKt$toSdkByteReadChannel$job$1 = new SdkSourceKt$toSdkByteReadChannel$job$1(this.$ch, this.$source, continuation);
        sdkSourceKt$toSdkByteReadChannel$job$1.L$0 = obj;
        return sdkSourceKt$toSdkByteReadChannel$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SdkSourceKt$toSdkByteReadChannel$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c0, code lost:
    
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c2, code lost:
    
        if (r11 != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c4, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c7, code lost:
    
        r0 = kotlin.Result.m14499constructorimpl(kotlin.Unit.INSTANCE);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        SdkSource sdkSource;
        JobChannel jobChannel;
        SdkSource sdkSource2;
        int i;
        int i2;
        int i3;
        int i4;
        Closeable closeable;
        SdkSource sdkSource3;
        SdkBuffer sdkBuffer;
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                SdkBuffer sdkBuffer2 = new SdkBuffer();
                SdkSource sdkSource4 = this.$source;
                jobChannel = this.$ch;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    sdkSource = sdkSource4;
                    sdkSource2 = sdkSource;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    closeable = sdkSource;
                    sdkSource3 = sdkSource4;
                    sdkBuffer = sdkBuffer2;
                    coroutineScope = coroutineScope2;
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Object objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th2));
                    this.$ch.close(Result.m14502exceptionOrNullimpl(objM14499constructorimpl));
                    return Unit.INSTANCE;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i6 = this.I$3;
                int i7 = this.I$2;
                int i8 = this.I$1;
                int i9 = this.I$0;
                SdkSource sdkSource5 = (SdkSource) this.L$6;
                sdkSource = (Closeable) this.L$5;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$4;
                JobChannel jobChannel2 = (JobChannel) this.L$3;
                SdkSource sdkSource6 = (SdkSource) this.L$2;
                SdkBuffer sdkBuffer3 = (SdkBuffer) this.L$1;
                ResultKt.throwOnFailure(obj);
                i = i6;
                coroutineScope = coroutineScope3;
                i2 = i7;
                sdkBuffer = sdkBuffer3;
                i4 = i9;
                sdkSource3 = sdkSource6;
                i3 = i8;
                jobChannel = jobChannel2;
                sdkSource2 = sdkSource5;
                closeable = sdkSource;
            }
            while (true) {
                try {
                    CoroutineScopeKt.ensureActive(coroutineScope);
                    long j = sdkSource3.read(sdkBuffer, Http2Stream.EMIT_BUFFER_SIZE);
                    if (j == -1) {
                        break;
                    }
                    JobChannel jobChannel3 = jobChannel;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                    this.L$1 = sdkBuffer;
                    this.L$2 = sdkSource3;
                    this.L$3 = jobChannel;
                    this.L$4 = coroutineScope;
                    this.L$5 = closeable;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(sdkSource2);
                    this.I$0 = i4;
                    this.I$1 = i3;
                    this.I$2 = i2;
                    this.I$3 = i;
                    this.J$0 = j;
                    this.label = 1;
                    JobChannel jobChannel4 = jobChannel;
                    SdkSource sdkSource7 = sdkSource3;
                    sdkSource = null;
                    CoroutineScope coroutineScope4 = coroutineScope;
                    if (SdkByteWriteChannel.write$default(jobChannel3, sdkBuffer, 0L, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope4;
                    sdkSource3 = sdkSource7;
                    jobChannel = jobChannel4;
                } catch (Throwable th3) {
                    th = th3;
                    sdkSource = closeable;
                    try {
                        sdkSource.close();
                        throw th;
                    } finally {
                        throw th;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
