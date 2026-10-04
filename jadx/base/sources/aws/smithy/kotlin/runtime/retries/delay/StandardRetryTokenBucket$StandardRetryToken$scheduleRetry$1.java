package aws.smithy.kotlin.runtime.retries.delay;

import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: StandardRetryTokenBucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken", m1609f = "StandardRetryTokenBucket.kt", m1610i = {0, 0}, m1611l = {115}, m1612m = "scheduleRetry", m1613n = {"reason", "size"}, m1614nl = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m1615s = {"L$0", "I$0"}, m1616v = 2)
final class StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StandardRetryTokenBucket.StandardRetryToken this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1(StandardRetryTokenBucket.StandardRetryToken standardRetryToken, Continuation<? super StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1> continuation) {
        super(continuation);
        this.this$0 = standardRetryToken;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scheduleRetry(null, this);
    }
}
