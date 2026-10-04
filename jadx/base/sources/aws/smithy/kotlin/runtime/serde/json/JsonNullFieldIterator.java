package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\t\u0010!\u001a\u00020\tH\u0096\u0001J\u0011\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0096\u0001J\t\u0010&\u001a\u00020'H\u0096\u0001J\u0011\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020%H\u0096\u0001J\u000b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0001J\t\u0010,\u001a\u00020-H\u0096\u0001J\t\u0010.\u001a\u00020/H\u0096\u0001J\u0011\u00100\u001a\u00020\u00012\u0006\u0010$\u001a\u000201H\u0096\u0001¨\u00062"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonNullFieldIterator;", "Laws/smithy/kotlin/runtime/serde/Deserializer$FieldIterator;", "Laws/smithy/kotlin/runtime/serde/Deserializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "deserializer", "Laws/smithy/kotlin/runtime/serde/json/JsonDeserializer;", "<init>", "(Laws/smithy/kotlin/runtime/serde/json/JsonDeserializer;)V", "findNextFieldIndex", "", "()Ljava/lang/Integer;", "skipValue", "", "deserializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "deserializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "deserializeBoolean", "", "deserializeByte", "", "deserializeByteArray", "", "deserializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "deserializeDouble", "", "deserializeFloat", "", "deserializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "deserializeInt", "deserializeList", "Laws/smithy/kotlin/runtime/serde/Deserializer$ElementIterator;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "deserializeLong", "", "deserializeMap", "Laws/smithy/kotlin/runtime/serde/Deserializer$EntryIterator;", "deserializeNull", "", "deserializeShort", "", "deserializeString", "", "deserializeStruct", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class JsonNullFieldIterator implements Deserializer.FieldIterator, Deserializer, PrimitiveDeserializer {
    private final /* synthetic */ JsonDeserializer $$delegate_0;
    private final /* synthetic */ JsonDeserializer $$delegate_1;

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public BigDecimal deserializeBigDecimal() {
        return this.$$delegate_1.deserializeBigDecimal();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public BigInteger deserializeBigInteger() {
        return this.$$delegate_1.deserializeBigInteger();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public boolean deserializeBoolean() {
        return this.$$delegate_1.deserializeBoolean();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public byte deserializeByte() {
        return this.$$delegate_1.deserializeByte();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public byte[] deserializeByteArray() {
        return this.$$delegate_1.deserializeByteArray();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Document deserializeDocument() {
        return this.$$delegate_1.deserializeDocument();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public double deserializeDouble() {
        return this.$$delegate_1.deserializeDouble();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public float deserializeFloat() {
        return this.$$delegate_1.deserializeFloat();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Instant deserializeInstant(TimestampFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return this.$$delegate_1.deserializeInstant(format);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public int deserializeInt() {
        return this.$$delegate_1.deserializeInt();
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer
    public Deserializer.ElementIterator deserializeList(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.$$delegate_0.deserializeList(descriptor);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public long deserializeLong() {
        return this.$$delegate_1.deserializeLong();
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer
    public Deserializer.EntryIterator deserializeMap(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.$$delegate_0.deserializeMap(descriptor);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Void deserializeNull() {
        return this.$$delegate_1.deserializeNull();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public short deserializeShort() {
        return this.$$delegate_1.deserializeShort();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public String deserializeString() {
        return this.$$delegate_1.deserializeString();
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer
    public Deserializer.FieldIterator deserializeStruct(SdkObjectDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.$$delegate_0.deserializeStruct(descriptor);
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.FieldIterator
    public Integer findNextFieldIndex() {
        return null;
    }

    public JsonNullFieldIterator(JsonDeserializer deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        this.$$delegate_0 = deserializer;
        this.$$delegate_1 = deserializer;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.FieldIterator
    public void skipValue() {
        throw new DeserializationException("This should not be called during deserialization.");
    }
}
