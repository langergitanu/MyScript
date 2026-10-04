package aws.smithy.kotlin.runtime.serde.formurl;

import aws.sdk.kotlin.runtime.config.profile.Literals;
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
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormUrlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u001e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018H\u0002J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010 J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010\"J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010#J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,H\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010\u0019\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010/H\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u000100H\u0016J1\u00101\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00062\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001403¢\u0006\u0002\b5H\u0016J1\u00106\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00062\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001403¢\u0006\u0002\b5H\u0016J\b\u00108\u001a\u00020\u0014H\u0016J\u0011\u00109\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020:H\u0096\u0001J\u0011\u0010;\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020<H\u0096\u0001J\u0011\u0010=\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010>\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001dH\u0096\u0001J\u0011\u0010?\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u000200H\u0096\u0001J\u0011\u0010@\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020!H\u0096\u0001J\u0013\u0010A\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010/H\u0096\u0001J\u0011\u0010B\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020(H\u0096\u0001J\u0011\u0010C\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020&H\u0096\u0001J\u0019\u0010D\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096\u0001J\u0011\u0010E\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\fH\u0096\u0001J\u0011\u0010F\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020$H\u0096\u0001J\t\u0010G\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010H\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020-H\u0096\u0001J\u0011\u0010I\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010J\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0010H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006K"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/formurl/FormUrlMapSerializer;", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveSerializer;", "parent", "Laws/smithy/kotlin/runtime/serde/formurl/FormUrlSerializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "<init>", "(Laws/smithy/kotlin/runtime/serde/formurl/FormUrlSerializer;Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)V", "buffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "idx", "", "mapName", "Laws/smithy/kotlin/runtime/serde/formurl/FormUrlMapName;", "commonPrefix", "", "getCommonPrefix", "()Ljava/lang/String;", "writeKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "writeEntry", "block", "Lkotlin/Function0;", "entry", "value", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "", "(Ljava/lang/String;Ljava/lang/Byte;)V", "", "(Ljava/lang/String;Ljava/lang/Short;)V", "", "(Ljava/lang/String;Ljava/lang/Character;)V", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "", "Laws/smithy/kotlin/runtime/content/Document;", "", "listEntry", "listDescriptor", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "Lkotlin/ExtensionFunctionType;", "mapEntry", "mapDescriptor", "endMap", "serializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "serializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "serializeBoolean", "serializeByte", "serializeByteArray", "serializeChar", "serializeDocument", "serializeDouble", "serializeFloat", "serializeInstant", "serializeInt", "serializeLong", "serializeNull", "serializeSdkSerializable", "serializeShort", "serializeString", "serde-form-url"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class FormUrlMapSerializer implements MapSerializer, PrimitiveSerializer {
    private final SdkBuffer buffer;
    private final SdkFieldDescriptor descriptor;
    private int idx;
    private final FormUrlMapName mapName;
    private final FormUrlSerializer parent;

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void endMap() {
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

    public FormUrlMapSerializer(FormUrlSerializer parent, SdkFieldDescriptor descriptor) {
        Object next;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.parent = parent;
        this.descriptor = descriptor;
        this.buffer = parent.getBuffer();
        Iterator<T> it = descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == FormUrlMapName.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        FormUrlMapName formUrlMapName = (FormUrlMapName) (fieldTrait instanceof FormUrlMapName ? fieldTrait : null);
        this.mapName = formUrlMapName == null ? FormUrlMapName.INSTANCE.getDefault() : formUrlMapName;
    }

    private final String getCommonPrefix() {
        Set<FieldTrait> traits = this.descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it = traits.iterator();
            while (it.hasNext()) {
                if (((FieldTrait) it.next()) instanceof FormUrlFlattened) {
                    return FormUrlSerializerKt.getSerialName(this.descriptor) + '.' + this.idx;
                }
            }
        }
        return FormUrlSerializerKt.getSerialName(this.descriptor) + ".entry." + this.idx;
    }

    private final void writeKey(String key) throws IOException {
        this.idx++;
        if (this.buffer.getSize() > 0) {
            SdkBufferedSink.writeUtf8$default(this.buffer, "&", 0, 0, 6, null);
        }
        SdkBufferedSink.writeUtf8$default(this.buffer, getCommonPrefix() + '.' + this.mapName.getKey() + Literals.PROPERTY_SPLITTER + FormUrlSerializerKt.encode(key), 0, 0, 6, null);
    }

    private final void writeEntry(String key, Function0<Unit> block) throws IOException {
        writeKey(key);
        SdkBufferedSink.writeUtf8$default(this.buffer, "&", 0, 0, 6, null);
        SdkBufferedSink.writeUtf8$default(this.buffer, getCommonPrefix() + '.' + this.mapName.getValue() + Literals.PROPERTY_SPLITTER, 0, 0, 6, null);
        block.invoke();
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Boolean value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$0(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$0(Boolean bool, FormUrlMapSerializer formUrlMapSerializer) {
        if (bool != null) {
            formUrlMapSerializer.serializeBoolean(bool.booleanValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Byte value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$1(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$1(Byte b, FormUrlMapSerializer formUrlMapSerializer) {
        if (b != null) {
            formUrlMapSerializer.serializeByte(b.byteValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Short value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$2(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$2(Short sh, FormUrlMapSerializer formUrlMapSerializer) {
        if (sh != null) {
            formUrlMapSerializer.serializeShort(sh.shortValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Character value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$3(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$3(Character ch2, FormUrlMapSerializer formUrlMapSerializer) {
        if (ch2 != null) {
            formUrlMapSerializer.serializeChar(ch2.charValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Integer value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$4(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$4(Integer num, FormUrlMapSerializer formUrlMapSerializer) {
        if (num != null) {
            formUrlMapSerializer.serializeInt(num.intValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Long value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$5(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$5(Long l, FormUrlMapSerializer formUrlMapSerializer) {
        if (l != null) {
            formUrlMapSerializer.serializeLong(l.longValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Float value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$6(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$6(Float f, FormUrlMapSerializer formUrlMapSerializer) {
        if (f != null) {
            formUrlMapSerializer.serializeFloat(f.floatValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Double value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$7(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$7(Double d, FormUrlMapSerializer formUrlMapSerializer) {
        if (d != null) {
            formUrlMapSerializer.serializeDouble(d.doubleValue());
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final String value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$8(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$8(String str, FormUrlMapSerializer formUrlMapSerializer) {
        if (str != null) {
            formUrlMapSerializer.serializeString(str);
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Instant value, final TimestampFormat format) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(format, "format");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.formurl.FormUrlMapSerializer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FormUrlMapSerializer.entry$lambda$9(value, this, format);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$9(Instant instant, FormUrlMapSerializer formUrlMapSerializer, TimestampFormat timestampFormat) {
        if (instant != null) {
            formUrlMapSerializer.serializeInstant(instant, timestampFormat);
            return Unit.INSTANCE;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, SdkSerializable value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            writeKey(key);
            value.serialize(new FormUrlSerializer(this.buffer, getCommonPrefix() + '.' + this.mapName.getValue() + '.'));
            return;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    /* JADX INFO: renamed from: entry, reason: merged with bridge method [inline-methods] */
    public Void mo12256entry(String key, Document value) {
        Intrinsics.checkNotNullParameter(key, "key");
        throw new SerializationException("document values not supported by form-url serializer");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            serializeByteArray(value);
            return;
        }
        throw new SerializationException("sparse collections are not supported by form-url encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void listEntry(String key, SdkFieldDescriptor listDescriptor, Function1<? super ListSerializer, Unit> block) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listDescriptor, "listDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        writeKey(key);
        FormUrlListSerializer formUrlListSerializer = new FormUrlListSerializer(this.parent, new SdkFieldDescriptor(SerialKind.List.INSTANCE, new FormUrlSerialName(getCommonPrefix() + '.' + this.mapName.getValue())));
        block.invoke(formUrlListSerializer);
        formUrlListSerializer.endList();
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void mapEntry(String key, SdkFieldDescriptor mapDescriptor, Function1<? super MapSerializer, Unit> block) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mapDescriptor, "mapDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        writeKey(key);
        block.invoke(new FormUrlMapSerializer(this.parent, new SdkFieldDescriptor(SerialKind.Map.INSTANCE, new FormUrlSerialName(getCommonPrefix() + '.' + this.mapName.getValue()))));
    }
}
