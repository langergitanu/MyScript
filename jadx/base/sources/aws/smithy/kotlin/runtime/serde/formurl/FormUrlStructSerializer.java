package aws.smithy.kotlin.runtime.serde.formurl;

import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.MapSerializer;
import aws.smithy.kotlin.runtime.serde.PrimitiveSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializable;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FormUrlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0017H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0019H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001aH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001cH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001dH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0016J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020$H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020%H\u0016J)\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100'¢\u0006\u0002\b(H\u0016J)\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00100'¢\u0006\u0002\b(H\u0016J)\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00100'¢\u0006\u0002\b(H\u0016J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0010H\u0016J\u0011\u0010/\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001fH\u0096\u0001J\u0011\u00100\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001eH\u0096\u0001J\u0011\u00101\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u0011\u00102\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0017H\u0096\u0001J\u0011\u00103\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020%H\u0096\u0001J\u0011\u00104\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0019H\u0096\u0001J\u0013\u00105\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0096\u0001J\u0011\u00106\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001dH\u0096\u0001J\u0011\u00107\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001cH\u0096\u0001J\u0019\u00108\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096\u0001J\u0011\u00109\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010:\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u001bH\u0096\u0001J\t\u0010;\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010<\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020$H\u0096\u0001J\u0011\u0010=\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010>\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\bH\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006?"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/formurl/FormUrlStructSerializer;", "Laws/smithy/kotlin/runtime/serde/StructSerializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveSerializer;", "parent", "Laws/smithy/kotlin/runtime/serde/formurl/FormUrlSerializer;", "structDescriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "prefix", "", "<init>", "(Laws/smithy/kotlin/runtime/serde/formurl/FormUrlSerializer;Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;Ljava/lang/String;)V", "buffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "getBuffer", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "writeField", "", "descriptor", "block", "Lkotlin/Function0;", "field", "value", "", "", "", "", "", "", "", "", "Laws/smithy/kotlin/runtime/content/BigInteger;", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "Laws/smithy/kotlin/runtime/content/Document;", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "", "structField", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "listField", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "mapField", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "nullField", "endStruct", "serializeBigDecimal", "serializeBigInteger", "serializeBoolean", "serializeByte", "serializeByteArray", "serializeChar", "serializeDocument", "serializeDouble", "serializeFloat", "serializeInstant", "serializeInt", "serializeLong", "serializeNull", "serializeSdkSerializable", "serializeShort", "serializeString", "serde-form-url"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class FormUrlStructSerializer implements StructSerializer, PrimitiveSerializer {
    private final FormUrlSerializer parent;
    private final String prefix;
    private final SdkFieldDescriptor structDescriptor;

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void endStruct() {
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void nullField(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigDecimal(BigDecimal value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.parent.serializeBigDecimal(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigInteger(BigInteger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.parent.serializeBigInteger(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBoolean(boolean value) {
        this.parent.serializeBoolean(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByte(byte value) {
        this.parent.serializeByte(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByteArray(byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.parent.serializeByteArray(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeChar(char value) {
        this.parent.serializeChar(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDocument(Document value) {
        this.parent.serializeDocument(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDouble(double value) {
        this.parent.serializeDouble(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeFloat(float value) {
        this.parent.serializeFloat(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInstant(Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        this.parent.serializeInstant(value, format);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInt(int value) {
        this.parent.serializeInt(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeLong(long value) {
        this.parent.serializeLong(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeNull() {
        this.parent.serializeNull();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeSdkSerializable(SdkSerializable value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.parent.serializeSdkSerializable(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeShort(short value) {
        this.parent.serializeShort(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.parent.serializeString(value);
    }

    public FormUrlStructSerializer(FormUrlSerializer parent, SdkFieldDescriptor structDescriptor, String prefix) throws IOException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(structDescriptor, "structDescriptor");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.parent = parent;
        this.structDescriptor = structDescriptor;
        this.prefix = prefix;
        Set<FieldTrait> traits = structDescriptor.getTraits();
        ArrayList<QueryLiteral> arrayList = new ArrayList();
        for (FieldTrait fieldTrait : traits) {
            QueryLiteral queryLiteral = fieldTrait instanceof QueryLiteral ? (QueryLiteral) fieldTrait : null;
            if (queryLiteral != null) {
                arrayList.add(queryLiteral);
            }
        }
        for (final QueryLiteral queryLiteral2 : arrayList) {
            writeField(FormUrlSerializerKt.toDescriptor(queryLiteral2), new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FormUrlStructSerializer.lambda$1$0(this.f$0, queryLiteral2);
                }
            });
        }
    }

    private final SdkBuffer getBuffer() {
        return this.parent.getBuffer();
    }

    static final Unit lambda$1$0(FormUrlStructSerializer formUrlStructSerializer, QueryLiteral queryLiteral) {
        formUrlStructSerializer.serializeString(queryLiteral.getValue());
        return Unit.INSTANCE;
    }

    private final void writeField(SdkFieldDescriptor descriptor, Function0<Unit> block) throws IOException {
        if (getBuffer().getSize() > 0) {
            SdkBufferedSink.writeUtf8$default(getBuffer(), "&", 0, 0, 6, null);
        }
        if (!StringsKt.isBlank(this.prefix)) {
            SdkBufferedSink.writeUtf8$default(getBuffer(), this.prefix, 0, 0, 6, null);
        }
        SdkBufferedSink.writeUtf8$default(getBuffer(), FormUrlSerializerKt.getSerialName(descriptor), 0, 0, 6, null);
        SdkBufferedSink.writeUtf8$default(getBuffer(), "=", 0, 0, 6, null);
        block.invoke();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final boolean value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$0(FormUrlStructSerializer formUrlStructSerializer, boolean z) {
        formUrlStructSerializer.serializeBoolean(z);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final byte value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$1(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$1(FormUrlStructSerializer formUrlStructSerializer, byte b) {
        formUrlStructSerializer.serializeByte(b);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final short value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$2(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$2(FormUrlStructSerializer formUrlStructSerializer, short s) {
        formUrlStructSerializer.serializeShort(s);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final char value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$3(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$3(FormUrlStructSerializer formUrlStructSerializer, char c) {
        formUrlStructSerializer.serializeChar(c);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final int value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$4(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$4(FormUrlStructSerializer formUrlStructSerializer, int i) {
        formUrlStructSerializer.serializeInt(i);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final long value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$5(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$5(FormUrlStructSerializer formUrlStructSerializer, long j) {
        formUrlStructSerializer.serializeLong(j);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final float value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$6(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$6(FormUrlStructSerializer formUrlStructSerializer, float f) {
        formUrlStructSerializer.serializeFloat(f);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final double value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$7(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$7(FormUrlStructSerializer formUrlStructSerializer, double d) {
        formUrlStructSerializer.serializeDouble(d);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final BigInteger value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$8(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$8(FormUrlStructSerializer formUrlStructSerializer, BigInteger bigInteger) {
        formUrlStructSerializer.serializeBigInteger(bigInteger);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final BigDecimal value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$9(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$9(FormUrlStructSerializer formUrlStructSerializer, BigDecimal bigDecimal) {
        formUrlStructSerializer.serializeBigDecimal(bigDecimal);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final String value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$10(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$10(FormUrlStructSerializer formUrlStructSerializer, String str) {
        formUrlStructSerializer.serializeString(str);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final Instant value, final TimestampFormat format) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$11(this.f$0, value, format);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$11(FormUrlStructSerializer formUrlStructSerializer, Instant instant, TimestampFormat timestampFormat) {
        formUrlStructSerializer.serializeInstant(instant, timestampFormat);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, Document value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new SerializationException("cannot serialize field " + FormUrlSerializerKt.getSerialName(descriptor) + "; Document type is not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, SdkSerializable value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        value.serialize(new FormUrlSerializer(getBuffer(), this.prefix + FormUrlSerializerKt.getSerialName(descriptor) + '.'));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, final byte[] value) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        writeField(descriptor, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlStructSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlStructSerializer.field$lambda$12(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit field$lambda$12(FormUrlStructSerializer formUrlStructSerializer, byte[] bArr) {
        formUrlStructSerializer.serializeByteArray(bArr);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void structField(SdkFieldDescriptor descriptor, Function1<? super StructSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void listField(SdkFieldDescriptor descriptor, Function1<? super ListSerializer, Unit> block) throws IOException {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        FormUrlListSerializer formUrlListSerializer = new FormUrlListSerializer(this.parent, FormUrlSerializerKt.copyWithNewSerialName(descriptor, this.prefix + FormUrlSerializerKt.getSerialName(descriptor)));
        block.invoke(formUrlListSerializer);
        formUrlListSerializer.endList();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void mapField(SdkFieldDescriptor descriptor, Function1<? super MapSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new FormUrlMapSerializer(this.parent, FormUrlSerializerKt.copyWithNewSerialName(descriptor, this.prefix + FormUrlSerializerKt.getSerialName(descriptor))));
    }
}
