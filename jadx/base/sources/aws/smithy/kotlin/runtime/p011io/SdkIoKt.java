package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* JADX INFO: compiled from: SdkIo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkSink;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "buffer", "(Laws/smithy/kotlin/runtime/io/SdkSink;)Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "(Laws/smithy/kotlin/runtime/io/SdkSource;)Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "", FirebaseAnalytics.Param.SOURCE, "([B)Laws/smithy/kotlin/runtime/io/SdkSource;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkIoKt {
    public static final SdkBufferedSink buffer(SdkSink sdkSink) {
        Intrinsics.checkNotNullParameter(sdkSink, "<this>");
        return sdkSink instanceof SdkBufferedSink ? (SdkBufferedSink) sdkSink : new BufferedSinkAdapter(Okio.buffer(ConvertKt.toOkio(sdkSink)));
    }

    public static final SdkBufferedSource buffer(SdkSource sdkSource) {
        Intrinsics.checkNotNullParameter(sdkSource, "<this>");
        return sdkSource instanceof SdkBufferedSource ? (SdkBufferedSource) sdkSource : new BufferedSourceAdapter(Okio.buffer(ConvertKt.toOkio(sdkSource)));
    }

    public static final SdkSource source(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new ByteArraySource(bArr);
    }
}
