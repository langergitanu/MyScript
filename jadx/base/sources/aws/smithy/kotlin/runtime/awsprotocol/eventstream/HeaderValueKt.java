package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.HeaderValue;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.Uuid;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeaderValue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0007H\u0007\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0007H\u0007\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0007H\u0007\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0007H\u0007\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0007H\u0007\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0007H\u0007\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0007H\u0007\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0007H\u0007\u001a+\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0019*\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u00190\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a+\u0010\u001d\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0019*\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00190\u001bH\u0007¢\u0006\u0002\u0010\u001c¨\u0006\u001e"}, m1599d2 = {"writeHeader", "", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "headerType", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderType;", "expectBool", "", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "expectByte", "", "expectInt16", "", "expectInt32", "", "expectInt64", "", "expectString", "", "expectByteArray", "", "expectTimestamp", "Laws/smithy/kotlin/runtime/time/Instant;", "expectUuid", "Laws/smithy/kotlin/runtime/util/Uuid;", "expectEnumValue", ExifInterface.GPS_DIRECTION_TRUE, "fromValue", "Lkotlin/Function1;", "(Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "expectIntEnumValue", "aws-event-stream"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HeaderValueKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeHeader(SdkBufferedSink sdkBufferedSink, HeaderType headerType) throws IOException {
        sdkBufferedSink.writeByte(headerType.getValue());
    }

    @InternalApi
    public static final boolean expectBool(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.Bool bool = headerValue instanceof HeaderValue.Bool ? (HeaderValue.Bool) headerValue : null;
        Boolean boolValueOf = bool != null ? Boolean.valueOf(bool.getValue()) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        throw new IllegalStateException(("expected HeaderValue.Bool, found: " + headerValue).toString());
    }

    @InternalApi
    public static final byte expectByte(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.Byte r0 = headerValue instanceof HeaderValue.Byte ? (HeaderValue.Byte) headerValue : null;
        Byte bValueOf = r0 != null ? Byte.valueOf(r0.m12146getValuew2LRezQ()) : null;
        if (bValueOf != null) {
            return bValueOf.byteValue();
        }
        throw new IllegalStateException(("expected HeaderValue.Byte, found: " + headerValue).toString());
    }

    @InternalApi
    public static final short expectInt16(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.Int16 int16 = headerValue instanceof HeaderValue.Int16 ? (HeaderValue.Int16) headerValue : null;
        Short shValueOf = int16 != null ? Short.valueOf(int16.getValue()) : null;
        if (shValueOf != null) {
            return shValueOf.shortValue();
        }
        throw new IllegalStateException(("expected HeaderValue.Int16, found: " + headerValue).toString());
    }

    @InternalApi
    public static final int expectInt32(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.Int32 int32 = headerValue instanceof HeaderValue.Int32 ? (HeaderValue.Int32) headerValue : null;
        Integer numValueOf = int32 != null ? Integer.valueOf(int32.getValue()) : null;
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        throw new IllegalStateException(("expected HeaderValue.Int32, found: " + headerValue).toString());
    }

    @InternalApi
    public static final long expectInt64(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.Int64 int64 = headerValue instanceof HeaderValue.Int64 ? (HeaderValue.Int64) headerValue : null;
        Long lValueOf = int64 != null ? Long.valueOf(int64.getValue()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        throw new IllegalStateException(("expected HeaderValue.Int64, found: " + headerValue).toString());
    }

    @InternalApi
    public static final String expectString(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.String string = headerValue instanceof HeaderValue.String ? (HeaderValue.String) headerValue : null;
        String value = string != null ? string.getValue() : null;
        if (value != null) {
            return value;
        }
        throw new IllegalStateException(("expected HeaderValue.String, found: " + headerValue).toString());
    }

    @InternalApi
    public static final byte[] expectByteArray(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.ByteArray byteArray = headerValue instanceof HeaderValue.ByteArray ? (HeaderValue.ByteArray) headerValue : null;
        byte[] value = byteArray != null ? byteArray.getValue() : null;
        if (value != null) {
            return value;
        }
        throw new IllegalStateException(("expected HeaderValue.ByteArray, found: " + headerValue).toString());
    }

    @InternalApi
    public static final Instant expectTimestamp(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.Timestamp timestamp = headerValue instanceof HeaderValue.Timestamp ? (HeaderValue.Timestamp) headerValue : null;
        Instant value = timestamp != null ? timestamp.getValue() : null;
        if (value != null) {
            return value;
        }
        throw new IllegalStateException(("expected HeaderValue.Bool, found: " + headerValue).toString());
    }

    @InternalApi
    public static final Uuid expectUuid(HeaderValue headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        HeaderValue.Uuid uuid = headerValue instanceof HeaderValue.Uuid ? (HeaderValue.Uuid) headerValue : null;
        Uuid value = uuid != null ? uuid.getValue() : null;
        if (value != null) {
            return value;
        }
        throw new IllegalStateException(("expected HeaderValue.Bool, found: " + headerValue).toString());
    }

    @InternalApi
    public static final <T> T expectEnumValue(HeaderValue headerValue, Function1<? super String, ? extends T> fromValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        Intrinsics.checkNotNullParameter(fromValue, "fromValue");
        return fromValue.invoke(expectString(headerValue));
    }

    @InternalApi
    public static final <T> T expectIntEnumValue(HeaderValue headerValue, Function1<? super Integer, ? extends T> fromValue) {
        Intrinsics.checkNotNullParameter(headerValue, "<this>");
        Intrinsics.checkNotNullParameter(fromValue, "fromValue");
        return fromValue.invoke(Integer.valueOf(expectInt32(headerValue)));
    }
}
