package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;

/* JADX INFO: compiled from: Deserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&¨\u0006 À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "", "deserializeByte", "", "deserializeInt", "", "deserializeShort", "", "deserializeLong", "", "deserializeFloat", "", "deserializeDouble", "", "deserializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "deserializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "deserializeString", "", "deserializeBoolean", "", "deserializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "deserializeNull", "", "deserializeByteArray", "", "deserializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PrimitiveDeserializer {
    BigDecimal deserializeBigDecimal();

    BigInteger deserializeBigInteger();

    boolean deserializeBoolean();

    byte deserializeByte();

    byte[] deserializeByteArray();

    Document deserializeDocument();

    double deserializeDouble();

    float deserializeFloat();

    Instant deserializeInstant(TimestampFormat format);

    int deserializeInt();

    long deserializeLong();

    Void deserializeNull();

    short deserializeShort();

    String deserializeString();
}
