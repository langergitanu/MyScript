package aws.smithy.kotlin.runtime.p011io.internal;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSink;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: Convert.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0007*\u00020\u0006H\u0007¢\u0006\u0004\b\u0002\u0010\b\u001a\u0013\u0010\u0002\u001a\u00020\n*\u00020\tH\u0007¢\u0006\u0004\b\u0002\u0010\u000b\u001a\u0013\u0010\u0004\u001a\u00020\t*\u00020\nH\u0007¢\u0006\u0004\b\u0004\u0010\f\u001a\u0013\u0010\u0004\u001a\u00020\u0006*\u00020\u0007H\u0007¢\u0006\u0004\b\u0004\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Lokio/Buffer;", "toOkio", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)Lokio/Buffer;", "toSdk", "(Lokio/Buffer;)Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "Lokio/Source;", "(Laws/smithy/kotlin/runtime/io/SdkSource;)Lokio/Source;", "Laws/smithy/kotlin/runtime/io/SdkSink;", "Lokio/Sink;", "(Laws/smithy/kotlin/runtime/io/SdkSink;)Lokio/Sink;", "(Lokio/Sink;)Laws/smithy/kotlin/runtime/io/SdkSink;", "(Lokio/Source;)Laws/smithy/kotlin/runtime/io/SdkSource;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ConvertKt {
    @InternalApi
    public static final Buffer toOkio(SdkBuffer sdkBuffer) {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        return sdkBuffer.getInner();
    }

    @InternalApi
    public static final SdkBuffer toSdk(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return new SdkBuffer(buffer);
    }

    @InternalApi
    public static final Source toOkio(SdkSource sdkSource) {
        Intrinsics.checkNotNullParameter(sdkSource, "<this>");
        return sdkSource instanceof OkioSdkSource ? ((OkioSdkSource) sdkSource).getDelegate() : new OkioSource(sdkSource);
    }

    @InternalApi
    public static final Sink toOkio(SdkSink sdkSink) {
        Intrinsics.checkNotNullParameter(sdkSink, "<this>");
        return sdkSink instanceof OkioSdkSink ? ((OkioSdkSink) sdkSink).getDelegate() : new OkioSink(sdkSink);
    }

    @InternalApi
    public static final SdkSink toSdk(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return sink instanceof OkioSink ? ((OkioSink) sink).getDelegate() : new OkioSdkSink(sink);
    }

    @InternalApi
    public static final SdkSource toSdk(Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return source instanceof OkioSource ? ((OkioSource) source).getDelegate() : new OkioSdkSource(source);
    }
}
