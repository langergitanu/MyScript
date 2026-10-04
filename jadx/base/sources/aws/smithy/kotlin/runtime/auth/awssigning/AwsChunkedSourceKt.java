package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSource;
import aws.smithy.kotlin.runtime.p011io.SdkIoKt;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: compiled from: AwsChunkedSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1599d2 = {"asStream", "Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader$Stream;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "aws-signing-common"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsChunkedSourceKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AwsChunkedReader.Stream asStream(SdkSource sdkSource) {
        return new AwsChunkedReader.Stream(sdkSource) { // from class: aws.smithy.kotlin.runtime.auth.awssigning.AwsChunkedSourceKt.asStream.1
            private final SdkBufferedSource delegate;

            {
                this.delegate = SdkIoKt.buffer(sdkSource);
            }

            @Override // aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader.Stream
            public boolean isClosedForRead() {
                return this.delegate.exhausted();
            }

            @Override // aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader.Stream
            public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) {
                return Boxing.boxLong(this.delegate.read(sdkBuffer, j));
            }
        };
    }
}
