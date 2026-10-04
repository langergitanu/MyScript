package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.MapSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializable;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001KB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0017H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0019H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u001aH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u001bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u001cH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u001dH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u001eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u001fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020 H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020!H\u0016J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J)\u0010'\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110)¢\u0006\u0002\b*H\u0016J)\u0010+\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110)¢\u0006\u0002\b*H\u0016J)\u0010,\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110)¢\u0006\u0002\b*H\u0016J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010/J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u00100J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u00101J\u001a\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u00102J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u00103J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0002\u00104J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u00105J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u00106J\"\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016J1\u00107\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\r2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110)¢\u0006\u0002\b*H\u0016J1\u00109\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\r2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110)¢\u0006\u0002\b*H\u0016J\b\u0010;\u001a\u00020\u0011H\u0016J\u0010\u0010<\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u001eH\u0016J\u0010\u0010=\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u001fH\u0016J\u0010\u0010>\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020 H\u0016J\u0010\u0010?\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020!H\u0016J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0017H\u0016J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0010\u0010B\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0019H\u0016J\u0010\u0010C\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u001bH\u0016J\u0010\u0010D\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u001cH\u0016J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u001dH\u0016J\u0010\u0010F\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u001aH\u0016J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010H\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010I\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0012\u0010J\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonSerializer;", "Laws/smithy/kotlin/runtime/serde/Serializer;", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "Laws/smithy/kotlin/runtime/serde/StructSerializer;", "<init>", "()V", "jsonWriter", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamWriter;", "toByteArray", "", "beginStruct", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "beginList", "beginMap", "endStruct", "", "endList", "endMap", "field", "value", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "", "", "", "", "", "Laws/smithy/kotlin/runtime/content/BigInteger;", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "", "", "", "", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "Laws/smithy/kotlin/runtime/content/Document;", "nullField", "structField", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "listField", "mapField", "entry", SubscriberAttributeKt.JSON_NAME_KEY, "(Ljava/lang/String;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/lang/Long;)V", "(Ljava/lang/String;Ljava/lang/Float;)V", "(Ljava/lang/String;Ljava/lang/Double;)V", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "(Ljava/lang/String;Ljava/lang/Byte;)V", "(Ljava/lang/String;Ljava/lang/Short;)V", "(Ljava/lang/String;Ljava/lang/Character;)V", "listEntry", "listDescriptor", "mapEntry", "mapDescriptor", "serializeNull", "serializeBoolean", "serializeByte", "serializeShort", "serializeChar", "serializeInt", "serializeLong", "serializeFloat", "serializeDouble", "serializeBigInteger", "serializeBigDecimal", "serializeString", "serializeSdkSerializable", "serializeInstant", "serializeByteArray", "serializeDocument", "Companion", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonSerializer implements Serializer, ListSerializer, MapSerializer, StructSerializer {
    private static final Set<Double> doublesToStringify = SetsKt.setOf((Object[]) new Double[]{Double.valueOf(Double.NEGATIVE_INFINITY), Double.valueOf(Double.POSITIVE_INFINITY), Double.valueOf(Double.NaN)});
    private static final Set<Float> floatsToStringify = SetsKt.setOf((Object[]) new Float[]{Float.valueOf(Float.NEGATIVE_INFINITY), Float.valueOf(Float.POSITIVE_INFINITY), Float.valueOf(Float.NaN)});
    private final JsonStreamWriter jsonWriter = JsonStreamWriterKt.jsonStreamWriter$default(false, 1, null);

    /* JADX INFO: compiled from: JsonSerializer.kt */
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
                iArr[TimestampFormat.ISO_8601_CONDENSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimestampFormat.ISO_8601_CONDENSED_DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimestampFormat.ISO_8601_FULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimestampFormat.RFC_5322.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public byte[] toByteArray() {
        byte[] bytes = this.jsonWriter.getBytes();
        if (bytes != null) {
            return bytes;
        }
        throw new SerializationException("Serializer payload is empty");
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public StructSerializer beginStruct(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.beginObject();
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public ListSerializer beginList(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.beginArray();
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public MapSerializer beginMap(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.beginObject();
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void endStruct() {
        this.jsonWriter.endObject();
    }

    @Override // aws.smithy.kotlin.runtime.serde.ListSerializer
    public void endList() {
        this.jsonWriter.endArray();
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void endMap() {
        this.jsonWriter.endObject();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, SdkSerializable value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        value.serialize(this);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, byte[] value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeByteArray(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, int value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeInt(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, long value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeLong(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, float value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeFloat(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeString(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, double value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeDouble(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, BigInteger value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeBigInteger(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, BigDecimal value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeBigDecimal(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, boolean value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeBoolean(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, byte value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeByte(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, short value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeShort(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, char value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeChar(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeInstant(value, format);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, Document value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeDocument(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void nullField(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        serializeNull();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void structField(SdkFieldDescriptor descriptor, Function1<? super StructSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        StructSerializer structSerializerBeginStruct = beginStruct(descriptor);
        block.invoke(structSerializerBeginStruct);
        structSerializerBeginStruct.endStruct();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void listField(SdkFieldDescriptor descriptor, Function1<? super ListSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        ListSerializer listSerializerBeginList = beginList(descriptor);
        block.invoke(listSerializerBeginList);
        listSerializerBeginList.endList();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void mapField(SdkFieldDescriptor descriptor, Function1<? super MapSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(descriptor));
        MapSerializer mapSerializerBeginMap = beginMap(descriptor);
        block.invoke(mapSerializerBeginMap);
        mapSerializerBeginMap.endMap();
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Integer value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeInt(value.intValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeLong(value.longValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeFloat(value.floatValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeString(value);
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, SdkSerializable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            value.serialize(this);
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeDouble(value.doubleValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeBoolean(value.booleanValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Byte value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeByte(value.byteValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Short value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeShort(value.shortValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Character value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeChar(value.charValue());
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(format, "format");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeInstant(value, format);
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    /* JADX INFO: renamed from: entry */
    public void mo12256entry(String key, Document value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        serializeDocument(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonWriter.writeName(key);
        if (value != null) {
            serializeByteArray(value);
        } else {
            this.jsonWriter.writeNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void listEntry(String key, SdkFieldDescriptor listDescriptor, Function1<? super ListSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listDescriptor, "listDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        this.jsonWriter.writeName(key);
        beginList(listDescriptor);
        block.invoke(this);
        endList();
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void mapEntry(String key, SdkFieldDescriptor mapDescriptor, Function1<? super MapSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mapDescriptor, "mapDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        this.jsonWriter.writeName(key);
        beginMap(mapDescriptor);
        block.invoke(this);
        endMap();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeNull() {
        this.jsonWriter.writeNull();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBoolean(boolean value) {
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByte(byte value) {
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeShort(short value) {
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeChar(char value) {
        this.jsonWriter.writeValue(String.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInt(int value) {
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeLong(long value) {
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeFloat(float value) {
        if (floatsToStringify.contains(Float.valueOf(value))) {
            this.jsonWriter.writeValue(String.valueOf(value));
        } else {
            this.jsonWriter.writeValue(value);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDouble(double value) {
        if (doublesToStringify.contains(Double.valueOf(value))) {
            this.jsonWriter.writeValue(String.valueOf(value));
        } else {
            this.jsonWriter.writeValue(value);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigInteger(BigInteger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigDecimal(BigDecimal value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeValue(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeSdkSerializable(SdkSerializable value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.serialize(this);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInstant(Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        switch (WhenMappings.$EnumSwitchMapping$0[format.ordinal()]) {
            case 1:
                this.jsonWriter.writeRawValue(value.format(format));
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.jsonWriter.writeValue(value.format(format));
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByteArray(byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        serializeString(Base64Kt.encodeBase64String(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDocument(Document value) {
        if (value instanceof Document.Number) {
            this.jsonWriter.writeValue(((Document.Number) value).getValue());
            return;
        }
        if (value instanceof Document.String) {
            this.jsonWriter.writeValue(((Document.String) value).getValue());
            return;
        }
        if (value instanceof Document.Boolean) {
            this.jsonWriter.writeValue(((Document.Boolean) value).getValue());
            return;
        }
        if (value == null) {
            this.jsonWriter.writeNull();
            return;
        }
        if (value instanceof Document.List) {
            this.jsonWriter.beginArray();
            Iterator<T> it = ((Document.List) value).getValue().iterator();
            while (it.hasNext()) {
                serializeDocument((Document) it.next());
            }
            this.jsonWriter.endArray();
            return;
        }
        if (!(value instanceof Document.Map)) {
            throw new NoWhenBranchMatchedException();
        }
        this.jsonWriter.beginObject();
        Iterator<T> it2 = ((Document.Map) value).getValue().entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            this.jsonWriter.writeName((String) entry.getKey());
            serializeDocument((Document) entry.getValue());
        }
        this.jsonWriter.endObject();
    }
}
