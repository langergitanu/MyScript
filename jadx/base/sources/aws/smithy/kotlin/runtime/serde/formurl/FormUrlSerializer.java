package aws.smithy.kotlin.runtime.serde.formurl;

import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
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
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormUrlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001aH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u00101\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\u0012\u00109\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010:H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006;"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/formurl/FormUrlSerializer;", "Laws/smithy/kotlin/runtime/serde/Serializer;", "buffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "prefix", "", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Ljava/lang/String;)V", "getBuffer", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "getPrefix", "()Ljava/lang/String;", "beginStruct", "Laws/smithy/kotlin/runtime/serde/StructSerializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "beginList", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "beginMap", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "toByteArray", "", "write", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "value", "serializeBoolean", "", "serializeByte", "", "serializeChar", "", "serializeShort", "", "serializeInt", "", "serializeLong", "", "serializeFloat", "", "serializeDouble", "", "serializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "serializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "serializeString", "serializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "serializeByteArray", "serializeSdkSerializable", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "serializeNull", "serializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "serde-form-url"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class FormUrlSerializer implements Serializer {
    private final SdkBuffer buffer;
    private final String prefix;

    public FormUrlSerializer(SdkBuffer buffer, String prefix) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.buffer = buffer;
        this.prefix = prefix;
    }

    public final SdkBuffer getBuffer() {
        return this.buffer;
    }

    public /* synthetic */ FormUrlSerializer(SdkBuffer sdkBuffer, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkBuffer, (i & 2) != 0 ? "" : str);
    }

    public final String getPrefix() {
        return this.prefix;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public StructSerializer beginStruct(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return new FormUrlStructSerializer(this, descriptor, this.prefix);
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public ListSerializer beginList(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return new FormUrlListSerializer(this, descriptor);
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public MapSerializer beginMap(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return new FormUrlMapSerializer(this, descriptor);
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public byte[] toByteArray() {
        return this.buffer.readByteArray();
    }

    private final void write(Function1<? super SdkBuffer, Unit> block) {
        block.invoke(this.buffer);
    }

    private final void write(final String value) {
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.write$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit write$lambda$0(String str, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        SdkBufferedSink.writeUtf8$default(write, FormUrlSerializerKt.encode(str), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBoolean(boolean value) {
        write(String.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeByte$lambda$0(byte b, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        FormUrlSerializerKt.commonWriteNumber(write, Byte.valueOf(b));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByte(final byte value) {
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.serializeByte$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeChar(char value) {
        write(String.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeShort$lambda$0(short s, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        FormUrlSerializerKt.commonWriteNumber(write, Short.valueOf(s));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeShort(final short value) {
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.serializeShort$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeInt$lambda$0(int i, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        FormUrlSerializerKt.commonWriteNumber(write, Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInt(final int value) {
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.serializeInt$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeLong$lambda$0(long j, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        FormUrlSerializerKt.commonWriteNumber(write, Long.valueOf(j));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeLong(final long value) {
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.serializeLong$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeFloat$lambda$0(float f, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        FormUrlSerializerKt.commonWriteNumber(write, Float.valueOf(f));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeFloat(final float value) {
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.serializeFloat$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeDouble$lambda$0(double d, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        FormUrlSerializerKt.commonWriteNumber(write, Double.valueOf(d));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDouble(final double value) {
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.serializeDouble$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeBigInteger$lambda$0(BigInteger bigInteger, SdkBuffer write) throws IOException {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        FormUrlSerializerKt.commonWriteNumber(write, bigInteger);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigInteger(final BigInteger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        write(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlSerializer.serializeBigInteger$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigDecimal(BigDecimal value) {
        Intrinsics.checkNotNullParameter(value, "value");
        write(value.toPlainString());
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        write(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInstant(Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        serializeString(value.format(format));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByteArray(byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        serializeString(Base64Kt.encodeBase64String(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeSdkSerializable(SdkSerializable value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.serialize(this);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeNull() {
        throw new SerializationException("null values not supported by form-url serializer");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDocument(Document value) {
        throw new SerializationException("document values not supported by form-url serializer");
    }
}
