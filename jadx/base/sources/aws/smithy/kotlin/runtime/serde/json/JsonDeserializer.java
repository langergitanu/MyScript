package aws.smithy.kotlin.runtime.serde.json;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.content.DocumentKt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JsonDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001>B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J6\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u001e0 H\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010*H\u0002J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00022\u0006\u00100\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00032\u0006\u00100\u001a\u000203H\u0016J\b\u00105\u001a\u00020!H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020(H\u0016J\b\u0010<\u001a\u00020(H\u0016J\b\u0010=\u001a\u00020(H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonDeserializer;", "Laws/smithy/kotlin/runtime/serde/Deserializer;", "Laws/smithy/kotlin/runtime/serde/Deserializer$ElementIterator;", "Laws/smithy/kotlin/runtime/serde/Deserializer$EntryIterator;", "Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "payload", "", "<init>", "([B)V", "reader", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamReader;", "deserializeByte", "", "deserializeInt", "", "deserializeShort", "", "deserializeLong", "", "deserializeFloat", "", "deserializeDouble", "", "deserializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "deserializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "deserializeNumber", "", "nextNumberValue", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "value", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "deserializeString", "deserializeBoolean", "", "deserializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "deserializeDocumentImpl", "deserializeNull", "", "deserializeStruct", "Laws/smithy/kotlin/runtime/serde/Deserializer$FieldIterator;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "deserializeList", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "deserializeMap", SubscriberAttributeKt.JSON_NAME_KEY, "deserializeByteArray", "deserializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "nextHasValue", "hasNextEntry", "hasNextElement", "Companion", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonDeserializer implements Deserializer, Deserializer.ElementIterator, Deserializer.EntryIterator, PrimitiveDeserializer {
    private static final Set<String> validNumberStrings = SetsKt.setOf((Object[]) new String[]{"Infinity", "-Infinity", "NaN"});
    private final JsonStreamReader reader;

    /* JADX INFO: compiled from: JsonDeserializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimestampFormat.values().length];
            try {
                iArr[TimestampFormat.EPOCH_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimestampFormat.ISO_8601.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimestampFormat.RFC_5322.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JsonDeserializer(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.reader = JsonStreamReaderKt.jsonStreamReader(payload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte deserializeByte$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Byte byteOrNull = StringsKt.toByteOrNull(it);
        return byteOrNull != null ? byteOrNull.byteValue() : (byte) Double.parseDouble(it);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public byte deserializeByte() {
        return ((Number) nextNumberValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Byte.valueOf(JsonDeserializer.deserializeByte$lambda$0((String) obj));
            }
        })).byteValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int deserializeInt$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Integer intOrNull = StringsKt.toIntOrNull(it);
        return intOrNull != null ? intOrNull.intValue() : (int) Double.parseDouble(it);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public int deserializeInt() {
        return ((Number) nextNumberValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(JsonDeserializer.deserializeInt$lambda$0((String) obj));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final short deserializeShort$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Short shortOrNull = StringsKt.toShortOrNull(it);
        return shortOrNull != null ? shortOrNull.shortValue() : (short) Double.parseDouble(it);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public short deserializeShort() {
        return ((Number) nextNumberValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Short.valueOf(JsonDeserializer.deserializeShort$lambda$0((String) obj));
            }
        })).shortValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long deserializeLong$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Long longOrNull = StringsKt.toLongOrNull(it);
        return longOrNull != null ? longOrNull.longValue() : (long) Double.parseDouble(it);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public long deserializeLong() {
        return ((Number) nextNumberValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(JsonDeserializer.deserializeLong$lambda$0((String) obj));
            }
        })).longValue();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public float deserializeFloat() {
        return (float) deserializeDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double deserializeDouble$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Double.parseDouble(it);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public double deserializeDouble() {
        return ((Number) nextNumberValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Double.valueOf(JsonDeserializer.deserializeDouble$lambda$0((String) obj));
            }
        })).doubleValue();
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$deserializeBigInteger$1 */
    /* JADX INFO: compiled from: JsonDeserializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37791 extends FunctionReferenceImpl implements Function1<String, BigInteger> {
        public static final C37791 INSTANCE = new C37791();

        C37791() {
            super(1, BigInteger.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final BigInteger invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new BigInteger(p0);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public BigInteger deserializeBigInteger() {
        return (BigInteger) nextNumberValue(C37791.INSTANCE);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$deserializeBigDecimal$1 */
    /* JADX INFO: compiled from: JsonDeserializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37781 extends FunctionReferenceImpl implements Function1<String, BigDecimal> {
        public static final C37781 INSTANCE = new C37781();

        C37781() {
            super(1, BigDecimal.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final BigDecimal invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new BigDecimal(p0);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public BigDecimal deserializeBigDecimal() {
        return (BigDecimal) nextNumberValue(C37781.INSTANCE);
    }

    private final Number deserializeNumber() {
        return (Number) nextNumberValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonDeserializer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonDeserializer.deserializeNumber$lambda$0((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Number deserializeNumber$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.contains$default((CharSequence) it, '.', false, 2, (Object) null) ? Double.valueOf(Double.parseDouble(it)) : Long.valueOf(Long.parseLong(it));
    }

    private final <T> T nextNumberValue(Function1<? super String, ? extends T> block) {
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken instanceof JsonToken.Number) {
            return block.invoke(((JsonToken.Number) jsonTokenNextToken).getValue());
        }
        if (jsonTokenNextToken instanceof JsonToken.String) {
            JsonToken.String string = (JsonToken.String) jsonTokenNextToken;
            if (validNumberStrings.contains(string.getValue())) {
                return block.invoke(string.getValue());
            }
        }
        throw new DeserializationException(jsonTokenNextToken + " cannot be deserialized as type Number");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public String deserializeString() {
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken instanceof JsonToken.String) {
            return ((JsonToken.String) jsonTokenNextToken).getValue();
        }
        if (jsonTokenNextToken instanceof JsonToken.Number) {
            return ((JsonToken.Number) jsonTokenNextToken).getValue();
        }
        if (jsonTokenNextToken instanceof JsonToken.Bool) {
            return String.valueOf(((JsonToken.Bool) jsonTokenNextToken).getValue());
        }
        throw new DeserializationException(jsonTokenNextToken + " cannot be deserialized as type String");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public boolean deserializeBoolean() {
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.Bool.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Bool.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken != null) {
            return ((JsonToken.Bool) jsonTokenNextToken).getValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.Bool");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Document deserializeDocument() {
        Document documentDeserializeDocumentImpl = deserializeDocumentImpl();
        if (documentDeserializeDocumentImpl != null) {
            return documentDeserializeDocumentImpl;
        }
        throw new IllegalStateException("expected non-null document field".toString());
    }

    private final Document deserializeDocumentImpl() {
        JsonToken jsonTokenPeek = this.reader.peek();
        if (jsonTokenPeek instanceof JsonToken.Number) {
            return DocumentKt.Document(deserializeNumber());
        }
        if (jsonTokenPeek instanceof JsonToken.String) {
            return DocumentKt.Document(deserializeString());
        }
        if (jsonTokenPeek instanceof JsonToken.Bool) {
            return DocumentKt.Document(deserializeBoolean());
        }
        if (Intrinsics.areEqual(jsonTokenPeek, JsonToken.Null.INSTANCE)) {
            this.reader.nextToken();
            return null;
        }
        if (!Intrinsics.areEqual(jsonTokenPeek, JsonToken.BeginArray.INSTANCE)) {
            if (!Intrinsics.areEqual(jsonTokenPeek, JsonToken.BeginObject.INSTANCE)) {
                if (Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndArray.INSTANCE) || Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndObject.INSTANCE) || Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndDocument.INSTANCE)) {
                    throw new DeserializationException("encountered unexpected json token \"" + jsonTokenPeek + "\" while deserializing document");
                }
                if (!(jsonTokenPeek instanceof JsonToken.Name)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new DeserializationException("encountered unexpected json field declaration \"" + ((JsonToken.Name) jsonTokenPeek).getValue() + "\" while deserializing document");
            }
            Deserializer.EntryIterator entryIteratorDeserializeMap = deserializeMap(new SdkFieldDescriptor(SerialKind.Document.INSTANCE, 0, null, 6, null));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (entryIteratorDeserializeMap.hasNextEntry()) {
                linkedHashMap.put(entryIteratorDeserializeMap.key(), deserializeDocumentImpl());
            }
            return new Document.Map(linkedHashMap);
        }
        Deserializer.ElementIterator elementIteratorDeserializeList = deserializeList(new SdkFieldDescriptor(SerialKind.Document.INSTANCE, 0, null, 6, null));
        ArrayList arrayList = new ArrayList();
        while (elementIteratorDeserializeList.hasNextElement()) {
            arrayList.add(deserializeDocumentImpl());
        }
        return new Document.List(arrayList);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Void deserializeNull() {
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.Null.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Null.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken == null) {
            throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.Null");
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer
    public Deserializer.FieldIterator deserializeStruct(SdkObjectDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonToken jsonTokenPeek = this.reader.peek();
        if (!Intrinsics.areEqual(jsonTokenPeek, JsonToken.BeginObject.INSTANCE)) {
            if (Intrinsics.areEqual(jsonTokenPeek, JsonToken.Null.INSTANCE)) {
                return new JsonNullFieldIterator(this);
            }
            throw new DeserializationException("Unexpected token type " + this.reader.peek());
        }
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.BeginObject.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginObject.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken != null) {
            return new JsonFieldIterator(this.reader, descriptor, this);
        }
        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.BeginObject");
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer
    public Deserializer.ElementIterator deserializeList(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.BeginArray.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginArray.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken != null) {
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.BeginArray");
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer
    public Deserializer.EntryIterator deserializeMap(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.BeginObject.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.BeginObject.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken != null) {
            return this;
        }
        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.BeginObject");
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.EntryIterator
    public String key() {
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.Name.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.Name.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken != null) {
            return ((JsonToken.Name) jsonTokenNextToken).getValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.Name");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public byte[] deserializeByteArray() {
        return Base64Kt.decodeBase64Bytes(deserializeString());
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Instant deserializeInstant(TimestampFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        int i = WhenMappings.$EnumSwitchMapping$0[format.ordinal()];
        if (i == 1) {
            return Instant.INSTANCE.fromEpochSeconds(deserializeString());
        }
        if (i == 2) {
            return Instant.INSTANCE.fromIso8601(deserializeString());
        }
        if (i == 3) {
            return Instant.INSTANCE.fromRfc5322(deserializeString());
        }
        throw new DeserializationException("unknown timestamp format: " + format);
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.ElementIterator, aws.smithy.kotlin.runtime.serde.Deserializer.EntryIterator
    public boolean nextHasValue() {
        return !Intrinsics.areEqual(this.reader.peek(), JsonToken.Null.INSTANCE);
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.EntryIterator
    public boolean hasNextEntry() {
        JsonToken jsonTokenPeek = this.reader.peek();
        if (!Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndObject.INSTANCE)) {
            return (Intrinsics.areEqual(jsonTokenPeek, JsonToken.Null.INSTANCE) || Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndDocument.INSTANCE)) ? false : true;
        }
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.EndObject.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.EndObject.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken == null) {
            throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.EndObject");
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Deserializer.ElementIterator
    public boolean hasNextElement() {
        JsonToken jsonTokenPeek = this.reader.peek();
        if (!Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndArray.INSTANCE)) {
            return !Intrinsics.areEqual(jsonTokenPeek, JsonToken.EndDocument.INSTANCE);
        }
        JsonToken jsonTokenNextToken = this.reader.nextToken();
        if (jsonTokenNextToken.getClass() != JsonToken.EndArray.class) {
            throw new DeserializationException("expected " + Reflection.getOrCreateKotlinClass(JsonToken.EndArray.class) + "; found " + Reflection.getOrCreateKotlinClass(jsonTokenNextToken.getClass()));
        }
        if (jsonTokenNextToken == null) {
            throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.json.JsonToken.EndArray");
        }
        return false;
    }
}
