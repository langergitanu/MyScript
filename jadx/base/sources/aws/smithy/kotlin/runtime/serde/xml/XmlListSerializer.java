package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.collections.StackKt;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializable;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u000bH\u0016J\u0012\u0010)\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u000202H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u00063"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlListSerializer;", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "xmlWriter", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;", "xmlSerializer", "Laws/smithy/kotlin/runtime/serde/xml/XmlSerializer;", "<init>", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;Laws/smithy/kotlin/runtime/serde/xml/XmlSerializer;)V", "endList", "", "memberTagName", "", "getMemberTagName", "()Ljava/lang/String;", "serializeBoolean", "value", "", "serializeByte", "", "serializeShort", "", "serializeChar", "", "serializeInt", "", "serializeLong", "", "serializeFloat", "", "serializeDouble", "", "serializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "serializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "serializeString", "serializeSdkSerializable", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "serializeNull", "serializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "serializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "serializeByteArray", "", "serializePrimitive", "", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class XmlListSerializer implements ListSerializer {
    private final SdkFieldDescriptor descriptor;
    private final XmlSerializer xmlSerializer;
    private final XmlStreamWriter xmlWriter;

    public XmlListSerializer(SdkFieldDescriptor descriptor, XmlStreamWriter xmlWriter, XmlSerializer xmlSerializer) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(xmlWriter, "xmlWriter");
        Intrinsics.checkNotNullParameter(xmlSerializer, "xmlSerializer");
        this.descriptor = descriptor;
        this.xmlWriter = xmlWriter;
        this.xmlSerializer = xmlSerializer;
    }

    @Override // aws.smithy.kotlin.runtime.serde.ListSerializer
    public void endList() {
        Set<FieldTrait> traits = this.descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it = traits.iterator();
            while (it.hasNext()) {
                if (((FieldTrait) it.next()) instanceof Flattened) {
                    return;
                }
            }
        }
        XmlStreamWriter.endTag$default(this.xmlWriter, XmlFieldTraitsKt.getSerialName(this.descriptor).getName(), null, 2, null);
    }

    private final String getMemberTagName() {
        Object next;
        String element;
        Set<FieldTrait> traits = this.descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it = traits.iterator();
            while (it.hasNext()) {
                if (((FieldTrait) it.next()) instanceof Flattened) {
                    return XmlFieldTraitsKt.getSerialName(this.descriptor).getName();
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
            if (((FieldTrait) next).getClass() == XmlCollectionName.class) {
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        XmlCollectionName xmlCollectionName = (XmlCollectionName) (fieldTrait instanceof XmlCollectionName ? fieldTrait : null);
        return (xmlCollectionName == null || (element = xmlCollectionName.getElement()) == null) ? XmlCollectionName.INSTANCE.getDefault().getElement() : element;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBoolean(boolean value) {
        serializePrimitive(Boolean.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByte(byte value) {
        serializePrimitive(Byte.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeShort(short value) {
        serializePrimitive(Short.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeChar(char value) {
        serializePrimitive(Character.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInt(int value) {
        serializePrimitive(Integer.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeLong(long value) {
        serializePrimitive(Long.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeFloat(float value) {
        serializePrimitive(Float.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDouble(double value) {
        serializePrimitive(Double.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigInteger(BigInteger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        serializePrimitive(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigDecimal(BigDecimal value) {
        Intrinsics.checkNotNullParameter(value, "value");
        serializePrimitive(value.toPlainString());
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        serializePrimitive(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeSdkSerializable(final SdkSerializable value) {
        Object next;
        Intrinsics.checkNotNullParameter(value, "value");
        StackKt.push(this.xmlSerializer.getParentDescriptorStack$serde_xml(), this.descriptor);
        Iterator<T> it = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlCollectionValueNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        XmlSerializerKt.writeTag(this.xmlWriter, getMemberTagName(), (XmlCollectionValueNamespace) (fieldTrait instanceof XmlCollectionValueNamespace ? fieldTrait : null), new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlListSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlListSerializer.serializeSdkSerializable$lambda$0(value, this, (XmlStreamWriter) obj);
            }
        });
        StackKt.pop(this.xmlSerializer.getParentDescriptorStack$serde_xml());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializeSdkSerializable$lambda$0(SdkSerializable sdkSerializable, XmlListSerializer xmlListSerializer, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        sdkSerializable.serialize(xmlListSerializer.xmlSerializer);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeNull() {
        Object next;
        Iterator<T> it = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlCollectionValueNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        XmlSerializerKt.writeTag$default(this.xmlWriter, getMemberTagName(), (XmlCollectionValueNamespace) (fieldTrait instanceof XmlCollectionValueNamespace ? fieldTrait : null), null, 4, null);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDocument(Document value) {
        throw new SerializationException("document values not supported by xml serializer");
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

    private final void serializePrimitive(final Object value) {
        Object next;
        Iterator<T> it = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlCollectionValueNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        XmlSerializerKt.writeTag(this.xmlWriter, getMemberTagName(), (XmlCollectionValueNamespace) (fieldTrait instanceof XmlCollectionValueNamespace ? fieldTrait : null), new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlListSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlListSerializer.serializePrimitive$lambda$0(value, (XmlStreamWriter) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializePrimitive$lambda$0(Object obj, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        writeTag.text(obj.toString());
        return Unit.INSTANCE;
    }
}
