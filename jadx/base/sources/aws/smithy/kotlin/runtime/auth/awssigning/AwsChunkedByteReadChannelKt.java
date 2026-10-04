package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AwsChunkedByteReadChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1599d2 = {"asStream", "Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader$Stream;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "aws-signing-common"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsChunkedByteReadChannelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AwsChunkedReader.Stream asStream(SdkByteReadChannel sdkByteReadChannel) {
        return new AwsChunkedReader.Stream(sdkByteReadChannel) { // from class: aws.smithy.kotlin.runtime.auth.awssigning.AwsChunkedByteReadChannelKt.asStream.1
            private final SdkByteReadChannel delegate;

            {
                this.delegate = sdkByteReadChannel;
            }

            @Override // aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader.Stream
            public boolean isClosedForRead() {
                return this.delegate.isClosedForRead();
            }

            @Override // aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader.Stream
            public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) {
                return this.delegate.read(sdkBuffer, j, continuation);
            }
        };
    }
}
