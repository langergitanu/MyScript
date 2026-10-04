package aws.smithy.kotlin.runtime.p011io;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkByteReadChannelJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "Ljava/io/InputStream;", "toInputStream", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;)Ljava/io/InputStream;", "", "DEFAULT_READ_BYTES", "J", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkByteReadChannelJVMKt {
    private static final long DEFAULT_READ_BYTES = 8192;

    public static final InputStream toInputStream(SdkByteReadChannel sdkByteReadChannel) {
        Intrinsics.checkNotNullParameter(sdkByteReadChannel, "<this>");
        return new InputAdapter(sdkByteReadChannel);
    }
}
