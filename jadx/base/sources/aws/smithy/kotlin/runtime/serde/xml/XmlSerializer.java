package aws.smithy.kotlin.runtime.serde.xml;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
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
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J;\u0010\u001e\u001a\u00020\u001a\"\b\b\u0000\u0010\u001f*\u00020 2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u0002H\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\u001a0\"H\u0002¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020%H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020&H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020'H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020(H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020)H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020*H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020+H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020,H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020-H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020.H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020/H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\tH\u0016J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\fH\u0016J)\u00105\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\"¢\u0006\u0002\b7H\u0016J)\u00108\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001a0\"¢\u0006\u0002\b7H\u0016J)\u00109\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a0\"¢\u0006\u0002\b7H\u0016J\b\u0010:\u001a\u00020\u001aH\u0016J\u0012\u0010;\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010<\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020&H\u0016J\u0010\u0010=\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020'H\u0016J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020(H\u0016J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020)H\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020*H\u0016J\u0010\u0010A\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020+H\u0016J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020,H\u0016J\u0010\u0010C\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020-H\u0016J\u0010\u0010D\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020.H\u0016J\u0010\u0010E\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020/H\u0016J\u0010\u0010F\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020%H\u0002J\u0010\u0010G\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010H\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010I\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010J\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006K"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlSerializer;", "Laws/smithy/kotlin/runtime/serde/Serializer;", "Laws/smithy/kotlin/runtime/serde/StructSerializer;", "xmlWriter", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;)V", "nodeStack", "", "", "Laws/smithy/kotlin/runtime/collections/ListStack;", "parentDescriptorStack", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "getParentDescriptorStack$serde_xml", "()Ljava/util/List;", "setParentDescriptorStack$serde_xml", "(Ljava/util/List;)V", "toByteArray", "", "beginStruct", "descriptor", "beginList", "Laws/smithy/kotlin/runtime/serde/ListSerializer;", "beginMap", "Laws/smithy/kotlin/runtime/serde/MapSerializer;", "endStruct", "", "field", "value", "Laws/smithy/kotlin/runtime/serde/SdkSerializable;", "tagOrAttribute", ExifInterface.GPS_DIRECTION_TRUE, "", "serdeFn", "Lkotlin/Function1;", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "numberField", "", "", "", "", "", "", "", "", "", "Laws/smithy/kotlin/runtime/content/BigInteger;", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "Laws/smithy/kotlin/runtime/content/Document;", "nullField", "structField", "block", "Lkotlin/ExtensionFunctionType;", "listField", "mapField", "serializeNull", "serializeDocument", "serializeBoolean", "serializeByte", "serializeChar", "serializeShort", "serializeInt", "serializeLong", "serializeFloat", "serializeDouble", "serializeBigInteger", "serializeBigDecimal", "serializeNumber", "serializeString", "serializeInstant", "serializeByteArray", "serializeSdkSerializable", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlSerializer implements Serializer, StructSerializer {
    private List<String> nodeStack;
    private List<SdkFieldDescriptor> parentDescriptorStack;
    private final XmlStreamWriter xmlWriter;

    /* JADX WARN: Multi-variable type inference failed */
    public XmlSerializer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeNull() {
    }

    public XmlSerializer(XmlStreamWriter xmlWriter) {
        Intrinsics.checkNotNullParameter(xmlWriter, "xmlWriter");
        this.xmlWriter = xmlWriter;
        this.nodeStack = new ArrayList();
        this.parentDescriptorStack = new ArrayList();
    }

    public /* synthetic */ XmlSerializer(XmlStreamWriter xmlStreamWriter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? XmlStreamWriterKt.xmlStreamWriter$default(false, 1, null) : xmlStreamWriter);
    }

    public final List<SdkFieldDescriptor> getParentDescriptorStack$serde_xml() {
        return this.parentDescriptorStack;
    }

    public final void setParentDescriptorStack$serde_xml(List<SdkFieldDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.parentDescriptorStack = list;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public byte[] toByteArray() {
        return this.xmlWriter.getBytes();
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public StructSerializer beginStruct(SdkFieldDescriptor descriptor) {
        Object next;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        SdkFieldDescriptor sdkFieldDescriptor = (SdkFieldDescriptor) StackKt.topOrNull(this.parentDescriptorStack);
        if (sdkFieldDescriptor != null) {
            descriptor = sdkFieldDescriptor;
        }
        boolean zIsEmpty = this.nodeStack.isEmpty();
        Iterator<T> it = descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((FieldTrait) next).getClass() == XmlNamespace.class) {
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (!(fieldTrait instanceof XmlNamespace)) {
            fieldTrait = null;
        }
        XmlNamespace xmlNamespace = (XmlNamespace) fieldTrait;
        if (xmlNamespace != null && (zIsEmpty || xmlNamespace.getPrefix() != null)) {
            this.xmlWriter.namespacePrefix(xmlNamespace.getUri(), xmlNamespace.getPrefix());
        }
        String name = XmlFieldTraitsKt.getSerialName(descriptor).getName();
        if (!XmlSerializerKt.isMapOrList(descriptor)) {
            XmlStreamWriter.startTag$default(this.xmlWriter, name, null, 2, null);
        }
        StackKt.push(this.nodeStack, name);
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void endStruct() {
        if (this.nodeStack.isEmpty()) {
            throw new IllegalStateException("Expected nodeStack to have a value, but was empty.".toString());
        }
        String str = (String) StackKt.pop(this.nodeStack);
        if (this.parentDescriptorStack.isEmpty() || XmlSerializerKt.isMapOrList((SdkFieldDescriptor) StackKt.top(this.parentDescriptorStack))) {
            return;
        }
        XmlStreamWriter.endTag$default(this.xmlWriter, str, null, 2, null);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, SdkSerializable value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        StackKt.push(this.parentDescriptorStack, descriptor);
        value.serialize(this);
        StackKt.pop(this.parentDescriptorStack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tagOrAttribute$lambda$0(Function1 function1, Object obj, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        function1.invoke(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.serde.xml.XmlSerializer$numberField$1 */
    /* JADX INFO: compiled from: XmlSerializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37831 extends FunctionReferenceImpl implements Function1<Number, Unit> {
        C37831(Object obj) {
            super(1, obj, XmlSerializer.class, "serializeNumber", "serializeNumber(Ljava/lang/Number;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Number number) {
            invoke2(number);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Number p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((XmlSerializer) this.receiver).serializeNumber(p0);
        }
    }

    private final void numberField(SdkFieldDescriptor descriptor, Number value) {
        tagOrAttribute(descriptor, value, new C37831(this));
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.serde.xml.XmlSerializer$field$1 */
    /* JADX INFO: compiled from: XmlSerializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37801 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        C37801(Object obj) {
            super(1, obj, XmlSerializer.class, "serializeBoolean", "serializeBoolean(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            ((XmlSerializer) this.receiver).serializeBoolean(z);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, boolean value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        tagOrAttribute(descriptor, Boolean.valueOf(value), new C37801(this));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, byte value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        numberField(descriptor, Byte.valueOf(value));
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.serde.xml.XmlSerializer$field$2 */
    /* JADX INFO: compiled from: XmlSerializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37812 extends FunctionReferenceImpl implements Function1<Character, Unit> {
        C37812(Object obj) {
            super(1, obj, XmlSerializer.class, "serializeChar", "serializeChar(C)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Character ch2) {
            invoke(ch2.charValue());
            return Unit.INSTANCE;
        }

        public final void invoke(char c) {
            ((XmlSerializer) this.receiver).serializeChar(c);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, char value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        tagOrAttribute(descriptor, Character.valueOf(value), new C37812(this));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, short value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        numberField(descriptor, Short.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, int value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        numberField(descriptor, Integer.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, long value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        numberField(descriptor, Long.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, float value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        numberField(descriptor, Float.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, double value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        numberField(descriptor, Double.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, BigInteger value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        numberField(descriptor, value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, BigDecimal value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        field(descriptor, value.toPlainString());
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.serde.xml.XmlSerializer$field$3 */
    /* JADX INFO: compiled from: XmlSerializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37823 extends FunctionReferenceImpl implements Function1<String, Unit> {
        C37823(Object obj) {
            super(1, obj, XmlSerializer.class, "serializeString", "serializeString(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((XmlSerializer) this.receiver).serializeString(p0);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        tagOrAttribute(descriptor, value, new C37823(this));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        field(descriptor, value.format(format));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, byte[] value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        field(descriptor, Base64Kt.encodeBase64String(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void field(SdkFieldDescriptor descriptor, Document value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new SerializationException("cannot serialize field " + XmlFieldTraitsKt.getSerialName(descriptor) + "; Document type is not supported by xml encoding");
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void nullField(SdkFieldDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        XmlSerializerKt.writeTag$default(this.xmlWriter, XmlFieldTraitsKt.getSerialName(descriptor).getName(), null, new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlSerializer.nullField$lambda$0(this.f$0, (XmlStreamWriter) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit nullField$lambda$0(XmlSerializer xmlSerializer, XmlStreamWriter writeTag) {
        Intrinsics.checkNotNullParameter(writeTag, "$this$writeTag");
        xmlSerializer.serializeNull();
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void structField(SdkFieldDescriptor descriptor, Function1<? super StructSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        StructSerializer structSerializerBeginStruct = beginStruct(descriptor);
        block.invoke(structSerializerBeginStruct);
        structSerializerBeginStruct.endStruct();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void listField(SdkFieldDescriptor descriptor, Function1<? super ListSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        ListSerializer listSerializerBeginList = beginList(descriptor);
        block.invoke(listSerializerBeginList);
        listSerializerBeginList.endList();
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public void mapField(SdkFieldDescriptor descriptor, Function1<? super MapSerializer, Unit> block) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        MapSerializer mapSerializerBeginMap = beginMap(descriptor);
        block.invoke(mapSerializerBeginMap);
        mapSerializerBeginMap.endMap();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDocument(Document value) {
        throw new SerializationException("document values not supported by xml serializer");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBoolean(boolean value) {
        this.xmlWriter.text(String.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeByte(byte value) {
        serializeNumber(Byte.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeChar(char value) {
        this.xmlWriter.text(String.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeShort(short value) {
        serializeNumber(Short.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInt(int value) {
        serializeNumber(Integer.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeLong(long value) {
        serializeNumber(Long.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeFloat(float value) {
        serializeNumber(Float.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeDouble(double value) {
        serializeNumber(Double.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigInteger(BigInteger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        serializeNumber(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeBigDecimal(BigDecimal value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.xmlWriter.text(value.toPlainString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void serializeNumber(Number value) {
        XmlStreamWriterKt.text(this.xmlWriter, value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.xmlWriter.text(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public void serializeInstant(Instant value, TimestampFormat format) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(format, "format");
        this.xmlWriter.text(value.format(format));
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f A[SYNTHETIC] */
    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ListSerializer beginList(SdkFieldDescriptor descriptor) {
        Iterator<T> it;
        Object next;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Set<FieldTrait> traits = descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it2 = traits.iterator();
            while (it2.hasNext()) {
                if (((FieldTrait) it2.next()) instanceof Flattened) {
                    break;
                }
            }
            it = descriptor.getTraits().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlNamespace.class) {
                    break;
                }
            }
            FieldTrait fieldTrait = (FieldTrait) next;
            XmlSerializerKt.startTag(this.xmlWriter, XmlFieldTraitsKt.getSerialName(descriptor).getName(), (XmlNamespace) (fieldTrait instanceof XmlNamespace ? fieldTrait : null));
        } else {
            it = descriptor.getTraits().iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            FieldTrait fieldTrait2 = (FieldTrait) next;
            XmlSerializerKt.startTag(this.xmlWriter, XmlFieldTraitsKt.getSerialName(descriptor).getName(), (XmlNamespace) (fieldTrait2 instanceof XmlNamespace ? fieldTrait2 : null));
        }
        return new XmlListSerializer(descriptor, this.xmlWriter, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f A[SYNTHETIC] */
    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MapSerializer beginMap(SdkFieldDescriptor descriptor) {
        Iterator<T> it;
        Object next;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Set<FieldTrait> traits = descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it2 = traits.iterator();
            while (it2.hasNext()) {
                if (((FieldTrait) it2.next()) instanceof Flattened) {
                    break;
                }
            }
            it = descriptor.getTraits().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlNamespace.class) {
                    break;
                }
            }
            FieldTrait fieldTrait = (FieldTrait) next;
            XmlSerializerKt.startTag(this.xmlWriter, XmlFieldTraitsKt.getSerialName(descriptor).getName(), (XmlNamespace) (fieldTrait instanceof XmlNamespace ? fieldTrait : null));
        } else {
            it = descriptor.getTraits().iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            FieldTrait fieldTrait2 = (FieldTrait) next;
            XmlSerializerKt.startTag(this.xmlWriter, XmlFieldTraitsKt.getSerialName(descriptor).getName(), (XmlNamespace) (fieldTrait2 instanceof XmlNamespace ? fieldTrait2 : null));
        }
        return new XmlMapSerializer(descriptor, this.xmlWriter, this, false, 8, null);
    }

    private final <T> void tagOrAttribute(SdkFieldDescriptor descriptor, final T value, final Function1<? super T, Unit> serdeFn) {
        T next;
        Iterator<T> it = descriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlNamespace.class) {
                    break;
                }
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (!(fieldTrait instanceof XmlNamespace)) {
            fieldTrait = null;
        }
        XmlNamespace xmlNamespace = (XmlNamespace) fieldTrait;
        Set<FieldTrait> traits = descriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it2 = traits.iterator();
            while (it2.hasNext()) {
                if (((FieldTrait) it2.next()) instanceof XmlAttribute) {
                    this.xmlWriter.attribute(XmlFieldTraitsKt.getSerialName(descriptor).getName(), value.toString(), xmlNamespace != null ? xmlNamespace.getUri() : null);
                    return;
                }
            }
        }
        XmlSerializerKt.writeTag(this.xmlWriter, XmlFieldTraitsKt.getSerialName(descriptor).getName(), xmlNamespace, new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlSerializer.tagOrAttribute$lambda$0(serdeFn, value, (XmlStreamWriter) obj);
            }
        });
    }
}
