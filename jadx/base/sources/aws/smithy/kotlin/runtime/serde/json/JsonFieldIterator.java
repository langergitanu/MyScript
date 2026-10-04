package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: JsonDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\t\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096\u0001J\t\u0010%\u001a\u00020\rH\u0096\u0001J\u0011\u0010&\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020(H\u0096\u0001J\t\u0010)\u001a\u00020*H\u0096\u0001J\u0011\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020(H\u0096\u0001J\u000b\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0001J\t\u0010/\u001a\u000200H\u0096\u0001J\t\u00101\u001a\u000202H\u0096\u0001J\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonFieldIterator;", "Laws/smithy/kotlin/runtime/serde/Deserializer$FieldIterator;", "Laws/smithy/kotlin/runtime/serde/Deserializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "reader", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamReader;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "deserializer", "Laws/smithy/kotlin/runtime/serde/json/JsonDeserializer;", "<init>", "(Laws/smithy/kotlin/runtime/serde/json/JsonStreamReader;Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;Laws/smithy/kotlin/runtime/serde/json/JsonDeserializer;)V", "findNextFieldIndex", "", "()Ljava/lang/Integer;", "skipValue", "", "deserializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "deserializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "deserializeBoolean", "", "deserializeByte", "", "deserializeByteArray", "", "deserializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "deserializeDouble", "", "deserializeFloat", "", "deserializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "deserializeInt", "deserializeList", "Laws/smithy/kotlin/runtime/serde/Deserializer$ElementIterator;", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "deserializeLong", "", "deserializeMap", "Laws/smithy/kotlin/runtime/serde/Deserializer$EntryIterator;", "deserializeNull", "", "deserializeShort", "", "deserializeString", "", "deserializeStruct", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class JsonFieldIterator implements Deserializer.FieldIterator, Deserializer, PrimitiveDeserializer {
    private final /* synthetic */ JsonDeserializer $$delegate_0;
    private final /* synthetic */ JsonDeserializer $$delegate_1;
    private final SdkObjectDescriptor descriptor;
    private final JsonStreamReader reader;

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

    public JsonFieldIterator(JsonStreamReader reader, SdkObjectDescriptor descriptor, JsonDeserializer deserializer) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        this.$$delegate_0 = deserializer;
        this.$$delegate_1 = deserializer;
        this.reader = reader;
        this.descriptor = descriptor;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.FieldIterator
    public Integer findNextFieldIndex() {
        JsonToken jsonTokenPeek = this.reader.peek();
        Integer numValueOf = null;
        numValueOf = null;
        numValueOf = null;
        Object obj = null;
        if (!Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndObject.INSTANCE)) {
            if (!Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndDocument.INSTANCE)) {
                if (Intrinsics.areEqual(jsonTokenPeek, JsonToken.Null.INSTANCE)) {
                    JsonToken jsonTokenNextToken = this.reader.nextToken();
                    if (jsonTokenNextToken.getClass() != JsonToken.Null.class) {
                        throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Null.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
                    }
                    if (jsonTokenNextToken == null) {
                        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.Null");
                    }
                } else {
                    JsonToken jsonTokenNextToken2 = this.reader.nextToken();
                    if (jsonTokenNextToken2.getClass() != JsonToken.Name.class) {
                        throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Name.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken2.getClass()));
                    }
                    if (jsonTokenNextToken2 != null) {
                        String value = ((JsonToken.Name) jsonTokenNextToken2).getValue();
                        Iterator<T> it = this.descriptor.getFields().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            if (Intrinsics.areEqual(JsonFieldTraitsKt.getSerialName((SdkFieldDescriptor) next), value)) {
                                obj = next;
                                break;
                            }
                        }
                        SdkFieldDescriptor sdkFieldDescriptor = (SdkFieldDescriptor) obj;
                        if (this.descriptor.getTraits().contains(new IgnoreKey(value))) {
                            this.reader.skipNext();
                            return findNextFieldIndex();
                        }
                        numValueOf = Integer.valueOf(sdkFieldDescriptor != null ? sdkFieldDescriptor.getIndex() : -1);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.Name");
                    }
                }
            }
        } else {
            JsonToken jsonTokenNextToken3 = this.reader.nextToken();
            if (jsonTokenNextToken3.getClass() != JsonToken.EndObject.class) {
                throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.EndObject.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken3.getClass()));
            }
            if (jsonTokenNextToken3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.EndObject");
            }
        }
        if (numValueOf == null || !Intrinsics.areEqual(this.reader.peek(), JsonToken.Null.INSTANCE)) {
            return numValueOf;
        }
        JsonToken jsonTokenNextToken4 = this.reader.nextToken();
        if (jsonTokenNextToken4.getClass() != JsonToken.Null.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Null.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken4.getClass()));
        }
        if (jsonTokenNextToken4 != null) {
            return findNextFieldIndex();
        }
        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.Null");
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.FieldIterator
    public void skipValue() {
        this.reader.skipNext();
    }
}
