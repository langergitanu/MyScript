package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CompressionType;
import aws.sdk.kotlin.services.p010s3.model.CsvInput;
import aws.sdk.kotlin.services.p010s3.model.InputSerialization;
import aws.sdk.kotlin.services.p010s3.model.JsonInput;
import aws.sdk.kotlin.services.p010s3.model.ParquetInput;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import com.fasterxml.jackson.core.JsonFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputSerializationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeInputSerializationDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/InputSerialization;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InputSerializationDocumentSerializerKt {
    public static final void serializeInputSerializationDocument(Serializer serializer, InputSerialization input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("CSV"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("CompressionType"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName(JsonFactory.FORMAT_NAME_JSON));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Parquet"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("InputSerialization"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        CsvInput csv = input.getCsv();
        if (csv != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, csv, C3516xb170bbe0.INSTANCE);
        }
        CompressionType compressionType = input.getCompressionType();
        if (compressionType != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, compressionType.getValue());
        }
        JsonInput json = input.getJson();
        if (json != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, json, C3517xb170c362.INSTANCE);
        }
        ParquetInput parquet = input.getParquet();
        if (parquet != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor4, parquet, C3518xb170c723.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
    }
}
