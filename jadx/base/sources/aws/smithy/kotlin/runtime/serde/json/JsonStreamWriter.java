package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import kotlin.Metadata;

/* JADX INFO: compiled from: JsonStreamWriter.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0004\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000fH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0010H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0011H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0012H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0013H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0014H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0015H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0016H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001dÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonStreamWriter;", "", "beginArray", "", "endArray", "writeNull", "beginObject", "endObject", "writeName", "name", "", "writeValue", "value", "bool", "", "", "", "", "", "", "", "", "Laws/smithy/kotlin/runtime/content/BigInteger;", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "writeRawValue", "bytes", "", "getBytes", "()[B", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface JsonStreamWriter {
    void beginArray();

    void beginObject();

    void endArray();

    void endObject();

    byte[] getBytes();

    void writeName(String name);

    void writeNull();

    void writeRawValue(String value);

    void writeValue(byte value);

    void writeValue(double value);

    void writeValue(float value);

    void writeValue(int value);

    void writeValue(long value);

    void writeValue(BigDecimal value);

    void writeValue(BigInteger value);

    void writeValue(Number value);

    void writeValue(String value);

    void writeValue(short value);

    void writeValue(boolean bool);
}
