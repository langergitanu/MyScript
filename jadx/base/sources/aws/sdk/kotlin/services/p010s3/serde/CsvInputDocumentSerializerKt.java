package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CsvInput;
import aws.sdk.kotlin.services.p010s3.model.FileHeaderInfo;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CsvInputDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeCsvInputDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/CsvInput;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CsvInputDocumentSerializerKt {
    public static final void serializeCsvInputDocument(Serializer serializer, CsvInput input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Boolean.INSTANCE, new XmlSerialName("AllowQuotedRecordDelimiter"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("Comments"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("FieldDelimiter"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("FileHeaderInfo"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("QuoteCharacter"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("QuoteEscapeCharacter"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("RecordDelimiter"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("CsvInput"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        Boolean allowQuotedRecordDelimiter = input.getAllowQuotedRecordDelimiter();
        if (allowQuotedRecordDelimiter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, allowQuotedRecordDelimiter.booleanValue());
        }
        String comments = input.getComments();
        if (comments != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, comments);
        }
        String fieldDelimiter = input.getFieldDelimiter();
        if (fieldDelimiter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, fieldDelimiter);
        }
        FileHeaderInfo fileHeaderInfo = input.getFileHeaderInfo();
        if (fileHeaderInfo != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, fileHeaderInfo.getValue());
        }
        String quoteCharacter = input.getQuoteCharacter();
        if (quoteCharacter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, quoteCharacter);
        }
        String quoteEscapeCharacter = input.getQuoteEscapeCharacter();
        if (quoteEscapeCharacter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, quoteEscapeCharacter);
        }
        String recordDelimiter = input.getRecordDelimiter();
        if (recordDelimiter != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, recordDelimiter);
        }
        structSerializerBeginStruct.endStruct();
    }
}
