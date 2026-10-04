package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CsvOutput;
import aws.sdk.kotlin.services.p010s3.model.QuoteFields;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CsvOutputDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeCsvOutputDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/CsvOutput;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CsvOutputDocumentSerializerKt {
    public static final void serializeCsvOutputDocument(Serializer serializer, CsvOutput input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("FieldDelimiter"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("QuoteCharacter"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("QuoteEscapeCharacter"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("QuoteFields"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("RecordDelimiter"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("CsvOutput"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        String fieldDelimiter = input.getFieldDelimiter();
        if (fieldDelimiter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, fieldDelimiter);
        }
        String quoteCharacter = input.getQuoteCharacter();
        if (quoteCharacter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, quoteCharacter);
        }
        String quoteEscapeCharacter = input.getQuoteEscapeCharacter();
        if (quoteEscapeCharacter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, quoteEscapeCharacter);
        }
        QuoteFields quoteFields = input.getQuoteFields();
        if (quoteFields != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, quoteFields.getValue());
        }
        String recordDelimiter = input.getRecordDelimiter();
        if (recordDelimiter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, recordDelimiter);
        }
        structSerializerBeginStruct.endStruct();
    }
}
