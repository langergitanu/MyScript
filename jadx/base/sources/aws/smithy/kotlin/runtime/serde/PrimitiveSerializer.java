package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020!H&J\b\u0010\"\u001a\u00020\u0003H&J\u0012\u0010#\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010$H&¨\u0006%À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/PrimitiveSerializer;", "", "serializeBoolean", "", "value", "", "serializeByte", "", "serializeShort", "", "serializeChar", "", "serializeInt", "", "serializeLong", "", "serializeFloat", "", "serializeDouble", "", "serializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "serializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "serializeString", "", "serializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "serializeByteArray", "", "serializeSdkSerializable", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "serializeNull", "serializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PrimitiveSerializer {
    void serializeBigDecimal(BigDecimal value);

    void serializeBigInteger(BigInteger value);

    void serializeBoolean(boolean value);

    void serializeByte(byte value);

    void serializeByteArray(byte[] value);

    void serializeChar(char value);

    void serializeDocument(Document value);

    void serializeDouble(double value);

    void serializeFloat(float value);

    void serializeInstant(Instant value, TimestampFormat format);

    void serializeInt(int value);

    void serializeLong(long value);

    void serializeNull();

    void serializeSdkSerializable(SdkSerializable value);

    void serializeShort(short value);

    void serializeString(String value);
}
