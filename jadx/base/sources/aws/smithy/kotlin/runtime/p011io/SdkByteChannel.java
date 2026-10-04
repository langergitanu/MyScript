package aws.smithy.kotlin.runtime.p011io;

import kotlin.Metadata;

/* JADX INFO: compiled from: SdkByteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkByteChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteWriteChannel;", "", "close", "()V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkByteChannel extends SdkByteReadChannel, SdkByteWriteChannel {

    /* JADX INFO: compiled from: SdkByteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void close(SdkByteChannel sdkByteChannel) {
            SdkByteChannel.super.close();
        }
    }

    default void close() {
        close(null);
    }
}
