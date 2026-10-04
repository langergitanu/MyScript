package aws.smithy.kotlin.runtime.serde.formurl;

import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializable;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormUrlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J!\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010*\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0011H\u0016J\u0012\u00103\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u000104H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/formurl/FormUrlListSerializer;", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "parent", "Laws/smithy/kotlin/runtime/serde/formurl/FormUrlSerializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "<init>", "(Laws/smithy/kotlin/runtime/serde/formurl/FormUrlSerializer;Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)V", "buffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "initialBufferPos", "", "idx", "", "prefix", "", "writePrefixed", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "endList", "serializeBoolean", "value", "", "serializeChar", "", "serializeByte", "", "serializeShort", "", "serializeInt", "serializeLong", "serializeFloat", "", "serializeDouble", "", "serializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "serializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "serializeString", "serializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "serializeByteArray", "", "serializeSdkSerializable", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "serializeNull", "serializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "serde-form-url"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class FormUrlListSerializer implements ListSerializer {
    private final SdkBuffer buffer;
    private final SdkFieldDescriptor descriptor;
    private int idx;
    private final long initialBufferPos;

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeNull() {
    }

    public FormUrlListSerializer(FormUrlSerializer parent, SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.descriptor = descriptor;
        SdkBuffer buffer = parent.getBuffer();
        this.buffer = buffer;
        this.initialBufferPos = buffer.getSize();
    }

    private final String prefix() {
        Object next;
        Set<FieldTrait> traits = this.descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it = traits.iterator();
            while (it.hasNext()) {
                if (((FieldTrait) it.next()) instanceof FormUrlFlattened) {
                    return FormUrlSerializerKt.getSerialName(this.descriptor) + '.' + this.idx;
                }
            }
        }
        Iterator<T> it2 = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((FieldTrait) next).getClass() == FormUrlCollectionName.class) {
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        FormUrlCollectionName formUrlCollectionName = (FormUrlCollectionName) (fieldTrait instanceof FormUrlCollectionName ? fieldTrait : null);
        if (formUrlCollectionName == null) {
            formUrlCollectionName = FormUrlCollectionName.INSTANCE.getDefault();
        }
        return FormUrlSerializerKt.getSerialName(this.descriptor) + '.' + formUrlCollectionName.getMember() + '.' + this.idx;
    }

    private final void writePrefixed(Function1<? super SdkBuffer, Unit> block) throws IOException {
        this.idx++;
        if (this.buffer.getSize() > 0) {
            SdkBufferedSink.writeUtf8$default(this.buffer, "&", 0, 0, 6, null);
        }
        SdkBufferedSink.writeUtf8$default(this.buffer, prefix(), 0, 0, 6, null);
        SdkBufferedSink.writeUtf8$default(this.buffer, "=", 0, 0, 6, null);
        block.invoke(this.buffer);
    }

    @Override // aws.smithy.kotlin.runtime.serde.ListSerializer
    public void endList() throws IOException {
        if (this.buffer.getSize() == this.initialBufferPos) {
            if (this.buffer.getSize() > 0) {
                SdkBufferedSink.writeUtf8$default(this.buffer, "&", 0, 0, 6, null);
            }
            SdkBufferedSink.writeUtf8$default(this.buffer, FormUrlSerializerKt.getSerialName(this.descriptor), 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(this.buffer, "=", 0, 0, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeBoolean$lambda$0(boolean z, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        SdkBufferedSink.writeUtf8$default(writePrefixed, String.valueOf(z), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBoolean(final boolean value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeBoolean$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeChar$lambda$0(char c, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        SdkBufferedSink.writeUtf8$default(writePrefixed, String.valueOf(c), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeChar(final char value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeChar$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeByte$lambda$0(byte b, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        FormUrlSerializerKt.commonWriteNumber(writePrefixed, Byte.valueOf(b));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByte(final byte value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeByte$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeShort$lambda$0(short s, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        FormUrlSerializerKt.commonWriteNumber(writePrefixed, Short.valueOf(s));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeShort(final short value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeShort$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeInt$lambda$0(int i, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        FormUrlSerializerKt.commonWriteNumber(writePrefixed, Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInt(final int value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeInt$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeLong$lambda$0(long j, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        FormUrlSerializerKt.commonWriteNumber(writePrefixed, Long.valueOf(j));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeLong(final long value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeLong$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeFloat$lambda$0(float f, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        FormUrlSerializerKt.commonWriteNumber(writePrefixed, Float.valueOf(f));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeFloat(final float value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeFloat$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeDouble$lambda$0(double d, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        FormUrlSerializerKt.commonWriteNumber(writePrefixed, Double.valueOf(d));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDouble(final double value) throws IOException {
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeDouble$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeBigInteger$lambda$0(BigInteger bigInteger, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        FormUrlSerializerKt.commonWriteNumber(writePrefixed, bigInteger);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigInteger(final BigInteger value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeBigInteger$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeBigDecimal$lambda$0(BigDecimal bigDecimal, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        SdkBufferedSink.writeUtf8$default(writePrefixed, bigDecimal.toPlainString(), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigDecimal(final BigDecimal value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeBigDecimal$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeString$lambda$0(String str, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        SdkBufferedSink.writeUtf8$default(writePrefixed, FormUrlSerializerKt.encode(str), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeString(final String value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeString$lambda$0(value, (SdkBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeInstant$lambda$0(Instant instant, TimestampFormat timestampFormat, SdkBuffer writePrefixed) throws IOException {
        Intrinsics.checkNotNullParameter(writePrefixed, "$this$writePrefixed");
        SdkBufferedSink.writeUtf8$default(writePrefixed, instant.format(timestampFormat), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInstant(final Instant value, final TimestampFormat format) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        writePrefixed(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlListSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FormUrlListSerializer.serializeInstant$lambda$0(value, format, (SdkBuffer) obj);
            }
        });
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByteArray(byte[] value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        serializeString(Base64Kt.encodeBase64String(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeSdkSerializable(SdkSerializable value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.idx++;
        value.serialize(new FormUrlSerializer(this.buffer, prefix() + '.'));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDocument(Document value) {
        throw new SerializationException("document values not supported by form-url serializer");
    }
}
