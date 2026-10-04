package aws.smithy.kotlin.runtime.serde.xml;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.content.Document;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: XmlPrimitiveDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ'\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\f0\u000eH\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlPrimitiveDeserializer;", "Laws/smithy/kotlin/runtime/serde/PrimitiveDeserializer;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "fieldDescriptor", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)V", "input", "", "([BLaws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)V", "deserializeValue", ExifInterface.GPS_DIRECTION_TRUE, "transform", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "deserializeByte", "", "deserializeInt", "", "deserializeShort", "", "deserializeLong", "", "deserializeFloat", "", "deserializeDouble", "", "deserializeBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "deserializeBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "deserializeString", "deserializeBoolean", "", "deserializeDocument", "Laws/smithy/kotlin/runtime/content/Document;", "deserializeNull", "", "deserializeByteArray", "deserializeInstant", "Laws/smithy/kotlin/runtime/time/Instant;", "format", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlPrimitiveDeserializer implements PrimitiveDeserializer {
    private final SdkFieldDescriptor fieldDescriptor;
    private final XmlStreamReader reader;

    /* JADX INFO: compiled from: XmlPrimitiveDeserializer.kt */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final String deserializeString$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public XmlPrimitiveDeserializer(XmlStreamReader reader, SdkFieldDescriptor fieldDescriptor) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(fieldDescriptor, "fieldDescriptor");
        this.reader = reader;
        this.fieldDescriptor = fieldDescriptor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XmlPrimitiveDeserializer(byte[] input, SdkFieldDescriptor fieldDescriptor) {
        this(XmlStreamReaderKt.xmlStreamReader(input), fieldDescriptor);
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(fieldDescriptor, "fieldDescriptor");
    }

    private final <T> T deserializeValue(Function1<? super String, ? extends T> transform) {
        T tInvoke;
        if (XmlStreamReader.peek$default(this.reader, 0, 1, null) instanceof XmlToken.BeginElement) {
            XmlToken xmlTokenNextToken = this.reader.nextToken();
            if (xmlTokenNextToken == null) {
                throw new DeserializationException("Expected " + Reflection.getOrCreateKotlinClass(XmlToken.BeginElement.class) + " but instead found null");
            }
            if (xmlTokenNextToken.getClass() != XmlToken.BeginElement.class) {
                throw new DeserializationException("Expected " + Reflection.getOrCreateKotlinClass(XmlToken.BeginElement.class) + "; found " + Reflection.getOrCreateKotlinClass(xmlTokenNextToken.getClass()) + " (" + xmlTokenNextToken + ')');
            }
            if (xmlTokenNextToken != null) {
                if (!Intrinsics.areEqual(((XmlToken.BeginElement) xmlTokenNextToken).getName().getLocal(), XmlFieldTraitsKt.generalName(this.fieldDescriptor))) {
                    return (T) deserializeValue(transform);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.xml.XmlToken.BeginElement");
            }
        }
        XmlToken xmlTokenNextToken2 = this.reader.nextToken();
        if (xmlTokenNextToken2 == null) {
            throw new DeserializationException("Expected " + Reflection.getOrCreateKotlinClass(XmlToken.Text.class) + " but instead found null");
        }
        if (xmlTokenNextToken2.getClass() != XmlToken.Text.class) {
            throw new DeserializationException("Expected " + Reflection.getOrCreateKotlinClass(XmlToken.Text.class) + "; found " + Reflection.getOrCreateKotlinClass(xmlTokenNextToken2.getClass()) + " (" + xmlTokenNextToken2 + ')');
        }
        if (xmlTokenNextToken2 != null) {
            XmlToken.Text text = (XmlToken.Text) xmlTokenNextToken2;
            String value = text.getValue();
            if (value == null || (tInvoke = transform.invoke(value)) == null) {
                throw new DeserializationException(text + " specifies nonexistent or invalid value.");
            }
            XmlToken xmlTokenNextToken3 = this.reader.nextToken();
            if (xmlTokenNextToken3 == null) {
                throw new DeserializationException("Expected " + Reflection.getOrCreateKotlinClass(XmlToken.EndElement.class) + " but instead found null");
            }
            if (xmlTokenNextToken3.getClass() != XmlToken.EndElement.class) {
                throw new DeserializationException("Expected " + Reflection.getOrCreateKotlinClass(XmlToken.EndElement.class) + "; found " + Reflection.getOrCreateKotlinClass(xmlTokenNextToken3.getClass()) + " (" + xmlTokenNextToken3 + ')');
            }
            if (xmlTokenNextToken3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.xml.XmlToken.EndElement");
            }
            return tInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.xml.XmlToken.Text");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte deserializeByte$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Integer intOrNull = StringsKt.toIntOrNull(it);
        if (intOrNull != null) {
            return (byte) intOrNull.intValue();
        }
        throw new DeserializationException("Unable to deserialize " + it + " as Byte");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public byte deserializeByte() {
        return ((Number) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Byte.valueOf(XmlPrimitiveDeserializer.deserializeByte$lambda$0((String) obj));
            }
        })).byteValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int deserializeInt$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Integer intOrNull = StringsKt.toIntOrNull(it);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new DeserializationException("Unable to deserialize " + it + " as Int");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public int deserializeInt() {
        return ((Number) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(XmlPrimitiveDeserializer.deserializeInt$lambda$0((String) obj));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final short deserializeShort$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Integer intOrNull = StringsKt.toIntOrNull(it);
        if (intOrNull != null) {
            return (short) intOrNull.intValue();
        }
        throw new DeserializationException("Unable to deserialize " + it + " as Short");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public short deserializeShort() {
        return ((Number) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Short.valueOf(XmlPrimitiveDeserializer.deserializeShort$lambda$0((String) obj));
            }
        })).shortValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long deserializeLong$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Long longOrNull = StringsKt.toLongOrNull(it);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        throw new DeserializationException("Unable to deserialize " + it + " as Long");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public long deserializeLong() {
        return ((Number) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(XmlPrimitiveDeserializer.deserializeLong$lambda$0((String) obj));
            }
        })).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float deserializeFloat$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Float floatOrNull = StringsKt.toFloatOrNull(it);
        if (floatOrNull != null) {
            return floatOrNull.floatValue();
        }
        throw new DeserializationException("Unable to deserialize " + it + " as Float");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public float deserializeFloat() {
        return ((Number) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(XmlPrimitiveDeserializer.deserializeFloat$lambda$0((String) obj));
            }
        })).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double deserializeDouble$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Double doubleOrNull = StringsKt.toDoubleOrNull(it);
        if (doubleOrNull != null) {
            return doubleOrNull.doubleValue();
        }
        throw new DeserializationException("Unable to deserialize " + it + " as Double");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public double deserializeDouble() {
        return ((Number) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Double.valueOf(XmlPrimitiveDeserializer.deserializeDouble$lambda$0((String) obj));
            }
        })).doubleValue();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public BigInteger deserializeBigInteger() {
        return (BigInteger) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlPrimitiveDeserializer.deserializeBigInteger$lambda$0(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BigInteger deserializeBigInteger$lambda$0(XmlPrimitiveDeserializer xmlPrimitiveDeserializer, String it) {
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(new BigInteger(it));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl == null) {
            return (BigInteger) objM14499constructorimpl;
        }
        throw new DeserializationException("Unable to deserialize " + thM14502exceptionOrNullimpl + " as BigInteger");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public BigDecimal deserializeBigDecimal() {
        return (BigDecimal) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlPrimitiveDeserializer.deserializeBigDecimal$lambda$0(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BigDecimal deserializeBigDecimal$lambda$0(XmlPrimitiveDeserializer xmlPrimitiveDeserializer, String it) {
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(new BigDecimal(it));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl == null) {
            return (BigDecimal) objM14499constructorimpl;
        }
        throw new DeserializationException("Unable to deserialize " + thM14502exceptionOrNullimpl + " as BigDecimal");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public String deserializeString() {
        return (String) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlPrimitiveDeserializer.deserializeString$lambda$0((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deserializeBoolean$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.parseBoolean(it);
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public boolean deserializeBoolean() {
        return ((Boolean) deserializeValue(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlPrimitiveDeserializer$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(XmlPrimitiveDeserializer.deserializeBoolean$lambda$0((String) obj));
            }
        })).booleanValue();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Document deserializeDocument() {
        throw new DeserializationException("cannot deserialize unsupported Document type in xml");
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveDeserializer
    public Void deserializeNull() {
        boolean z;
        if (this.reader.nextToken() == null) {
            throw new DeserializationException("Unexpected end of stream");
        }
        XmlStreamReader xmlStreamReader = this.reader;
        XmlToken lastToken = xmlStreamReader.getLastToken();
        do {
            z = lastToken instanceof XmlToken.EndElement;
            if (!z) {
                lastToken = xmlStreamReader.nextToken();
            }
            if (lastToken == null) {
                break;
            }
        } while (!z);
        if (this.reader.nextToken() != null) {
            return null;
        }
        throw new DeserializationException("Unexpected end of stream");
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
}
