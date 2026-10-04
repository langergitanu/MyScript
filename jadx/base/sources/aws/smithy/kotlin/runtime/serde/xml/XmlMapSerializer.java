package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.collections.StackKt;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.MapSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializable;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0002J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001bH\u0016J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010 J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010\"J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0002\u0010$J\"\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010\u0013\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010*H\u0016J1\u0010+\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00032\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\r0.¢\u0006\u0002\b0H\u0016J1\u00101\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00032\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0.¢\u0006\u0002\b0H\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u00104\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u001fH\u0016J\u0010\u00105\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020!H\u0016J\u0010\u00106\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020#H\u0016J\u0010\u00107\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u00108\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0010\u00109\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0019H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u001cH\u0016J\u0010\u0010;\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u001bH\u0016J\u0018\u0010A\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010B\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020*H\u0016J\b\u0010C\u001a\u00020\rH\u0016J\u0012\u0010D\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010E\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020FH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlMapSerializer;", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "descriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "xmlWriter", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;", "xmlSerializer", "Laws/smithy/kotlin/runtime/serde/xml/XmlSerializer;", "nestedMap", "", "<init>", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;Laws/smithy/kotlin/runtime/serde/xml/XmlSerializer;Z)V", "endMap", "", "writeEntry", SubscriberAttributeKt.JSON_NAME_KEY, "", "valueFn", "Lkotlin/Function0;", "entry", "value", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "", "(Ljava/lang/String;Ljava/lang/Byte;)V", "", "(Ljava/lang/String;Ljava/lang/Short;)V", "", "(Ljava/lang/String;Ljava/lang/Character;)V", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "", "Laws/smithy/kotlin/runtime/content/Document;", "", "listEntry", "listDescriptor", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "Lkotlin/ExtensionFunctionType;", "mapEntry", "mapDescriptor", "serializeBoolean", "serializeByte", "serializeShort", "serializeChar", "serializeInt", "serializeLong", "serializeFloat", "serializeDouble", "serializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "serializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "serializeString", "serializeSdkSerializable", "serializeInstant", "serializeByteArray", "serializeNull", "serializeDocument", "serializePrimitive", "", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class XmlMapSerializer implements MapSerializer {
    private final SdkFieldDescriptor descriptor;
    private final boolean nestedMap;
    private final XmlSerializer xmlSerializer;
    private final XmlStreamWriter xmlWriter;

    public XmlMapSerializer(SdkFieldDescriptor descriptor, XmlStreamWriter xmlWriter, XmlSerializer xmlSerializer, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(xmlWriter, "xmlWriter");
        Intrinsics.checkNotNullParameter(xmlSerializer, "xmlSerializer");
        this.descriptor = descriptor;
        this.xmlWriter = xmlWriter;
        this.xmlSerializer = xmlSerializer;
        this.nestedMap = z;
    }

    public /* synthetic */ XmlMapSerializer(SdkFieldDescriptor sdkFieldDescriptor, XmlStreamWriter xmlStreamWriter, XmlSerializer xmlSerializer, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkFieldDescriptor, xmlStreamWriter, xmlSerializer, (i & 8) != 0 ? false : z);
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void endMap() {
        Set<FieldTrait> traits = this.descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it = traits.iterator();
            while (it.hasNext()) {
                if (((FieldTrait) it.next()) instanceof Flattened) {
                    return;
                }
            }
        }
        if (this.nestedMap) {
            return;
        }
        XmlStreamWriter.endTag$default(this.xmlWriter, XmlFieldTraitsKt.getSerialName(this.descriptor).getName(), null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void writeEntry(final String key, final Function0<Unit> valueFn) {
        Object next;
        String name;
        Object next2;
        Object next3;
        Iterator<T> it = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlMapName.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (!(fieldTrait instanceof XmlMapName)) {
            fieldTrait = null;
        }
        XmlMapName xmlMapName = (XmlMapName) fieldTrait;
        if (xmlMapName == null) {
            xmlMapName = XmlMapName.INSTANCE.getDefault();
        }
        final XmlMapName xmlMapName2 = xmlMapName;
        Set<FieldTrait> traits = this.descriptor.getTraits();
        if ((traits instanceof Collection) && traits.isEmpty()) {
            name = xmlMapName2.getEntry();
            if (name == null) {
            }
        } else {
            Iterator<T> it2 = traits.iterator();
            while (it2.hasNext()) {
                if (((FieldTrait) it2.next()) instanceof Flattened) {
                    name = XmlFieldTraitsKt.getSerialName(this.descriptor).getName();
                    break;
                }
            }
            name = xmlMapName2.getEntry();
            if (name == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        Iterator<T> it3 = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it3.hasNext()) {
                next2 = null;
                break;
            } else {
                next2 = it3.next();
                if (((FieldTrait) next2).getClass() == XmlMapKeyNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait2 = (FieldTrait) next2;
        if (!(fieldTrait2 instanceof XmlMapKeyNamespace)) {
            fieldTrait2 = null;
        }
        final XmlMapKeyNamespace xmlMapKeyNamespace = (XmlMapKeyNamespace) fieldTrait2;
        Iterator<T> it4 = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it4.hasNext()) {
                next3 = null;
                break;
            } else {
                next3 = it4.next();
                if (((FieldTrait) next3).getClass() == XmlCollectionValueNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait3 = (FieldTrait) next3;
        final XmlCollectionValueNamespace xmlCollectionValueNamespace = (XmlCollectionValueNamespace) (fieldTrait3 instanceof XmlCollectionValueNamespace ? fieldTrait3 : null);
        XmlSerializerKt.writeTag$default(this.xmlWriter, name, null, new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlMapSerializer.writeEntry$lambda$0(xmlMapName2, xmlMapKeyNamespace, xmlCollectionValueNamespace, key, valueFn, (XmlStreamWriter) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeEntry$lambda$0(XmlMapName xmlMapName, XmlMapKeyNamespace xmlMapKeyNamespace, XmlCollectionValueNamespace xmlCollectionValueNamespace, final String str, final Function0 function0, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        XmlSerializerKt.writeTag(writeTag, xmlMapName.getKey(), xmlMapKeyNamespace, new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlMapSerializer.writeEntry$lambda$0$0(str, (XmlStreamWriter) obj);
            }
        });
        XmlSerializerKt.writeTag(writeTag, xmlMapName.getValue(), xmlCollectionValueNamespace, new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlMapSerializer.writeEntry$lambda$0$1(function0, (XmlStreamWriter) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeEntry$lambda$0$0(String str, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        writeTag.text(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeEntry$lambda$0$1(Function0 function0, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$0(XmlMapSerializer xmlMapSerializer, Integer num) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(num));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Integer value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$0(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$1(XmlMapSerializer xmlMapSerializer, Long l) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(l));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$1(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$2(XmlMapSerializer xmlMapSerializer, Float f) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(f));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$2(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$3(XmlMapSerializer xmlMapSerializer, String str) {
        XmlStreamWriter xmlStreamWriter = xmlMapSerializer.xmlWriter;
        if (str == null) {
            str = "";
        }
        xmlStreamWriter.text(str);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$3(this.f$0, value);
            }
        });
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final SdkSerializable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$4(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$4(SdkSerializable sdkSerializable, XmlMapSerializer xmlMapSerializer) {
        if (sdkSerializable == null) {
            xmlMapSerializer.xmlWriter.text("");
            return Unit.INSTANCE;
        }
        StackKt.push(xmlMapSerializer.xmlSerializer.getParentDescriptorStack$serde_xml(), xmlMapSerializer.descriptor);
        sdkSerializable.serialize(xmlMapSerializer.xmlSerializer);
        StackKt.pop(xmlMapSerializer.xmlSerializer.getParentDescriptorStack$serde_xml());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$5(XmlMapSerializer xmlMapSerializer, Double d) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(d));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$5(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$6(XmlMapSerializer xmlMapSerializer, Boolean bool) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(bool));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$6(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$7(XmlMapSerializer xmlMapSerializer, Byte b) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(b));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Byte value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$7(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$8(XmlMapSerializer xmlMapSerializer, Short sh) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(sh));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Short value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$8(this.f$0, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit entry$lambda$9(XmlMapSerializer xmlMapSerializer, Character ch2) {
        xmlMapSerializer.xmlWriter.text(String.valueOf(ch2));
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, final Character value) {
        Intrinsics.checkNotNullParameter(key, "key");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.entry$lambda$9(this.f$0, value);
            }
        });
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(format, "format");
        entry(key, value != null ? value.format(format) : null);
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    /* JADX INFO: renamed from: entry, reason: merged with bridge method [inline-methods] */
    public Void mo12256entry(String key, Document value) {
        Intrinsics.checkNotNullParameter(key, "key");
        throw new SerializationException("document values not supported by xml serializer");
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void entry(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        entry(key, value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void listEntry(String key, final SdkFieldDescriptor listDescriptor, final Function1<? super ListSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listDescriptor, "listDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.listEntry$lambda$0(this.f$0, listDescriptor, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit listEntry$lambda$0(XmlMapSerializer xmlMapSerializer, SdkFieldDescriptor sdkFieldDescriptor, Function1 function1) {
        ListSerializer listSerializerBeginList = xmlMapSerializer.xmlSerializer.beginList(sdkFieldDescriptor);
        function1.invoke(listSerializerBeginList);
        listSerializerBeginList.endList();
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public void mapEntry(String key, final SdkFieldDescriptor mapDescriptor, final Function1<? super MapSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mapDescriptor, "mapDescriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        writeEntry(key, new Function0() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return XmlMapSerializer.mapEntry$lambda$0(mapDescriptor, this, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapEntry$lambda$0(SdkFieldDescriptor sdkFieldDescriptor, XmlMapSerializer xmlMapSerializer, Function1 function1) {
        function1.invoke(new XmlMapSerializer(sdkFieldDescriptor, xmlMapSerializer.xmlWriter, xmlMapSerializer.xmlSerializer, true));
        return Unit.INSTANCE;
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
    public void serializeSdkSerializable(SdkSerializable value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.serialize(this.xmlSerializer);
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
    public void serializeNull() {
        Object next;
        String value;
        Object next2;
        Iterator<T> it = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlMapName.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (!(fieldTrait instanceof XmlMapName)) {
            fieldTrait = null;
        }
        XmlMapName xmlMapName = (XmlMapName) fieldTrait;
        if (xmlMapName == null || (value = xmlMapName.getValue()) == null) {
            value = XmlMapName.INSTANCE.getDefault().getValue();
        }
        String str = value;
        Iterator<T> it2 = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            } else {
                next2 = it2.next();
                if (((FieldTrait) next2).getClass() == XmlCollectionValueNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait2 = (FieldTrait) next2;
        XmlSerializerKt.writeTag$default(this.xmlWriter, str, (XmlCollectionValueNamespace) (fieldTrait2 instanceof XmlCollectionValueNamespace ? fieldTrait2 : null), null, 4, null);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDocument(Document value) {
        throw new SerializationException("document values not supported by xml serializer");
    }

    private final void serializePrimitive(final Object value) {
        Object next;
        String value2;
        Object next2;
        Iterator<T> it = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlMapName.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (!(fieldTrait instanceof XmlMapName)) {
            fieldTrait = null;
        }
        XmlMapName xmlMapName = (XmlMapName) fieldTrait;
        if (xmlMapName == null || (value2 = xmlMapName.getValue()) == null) {
            value2 = XmlMapName.INSTANCE.getDefault().getValue();
        }
        Iterator<T> it2 = this.descriptor.getTraits().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            } else {
                next2 = it2.next();
                if (((FieldTrait) next2).getClass() == XmlCollectionValueNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait2 = (FieldTrait) next2;
        XmlSerializerKt.writeTag(this.xmlWriter, value2, (XmlCollectionValueNamespace) (fieldTrait2 instanceof XmlCollectionValueNamespace ? fieldTrait2 : null), new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlMapSerializer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlMapSerializer.serializePrimitive$lambda$0(value, (XmlStreamWriter) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serializePrimitive$lambda$0(Object obj, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        obj.toString();
        return Unit.INSTANCE;
    }
}
