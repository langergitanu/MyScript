package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryConfiguration;
import aws.sdk.kotlin.services.p010s3.model.InventoryDestination;
import aws.sdk.kotlin.services.p010s3.model.InventoryFilter;
import aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField;
import aws.sdk.kotlin.services.p010s3.model.InventorySchedule;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlCollectionName;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: InventoryConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeInventoryConfigurationPayloadWithXmlNameInventoryConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/InventoryConfiguration;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InventoryConfigurationPayloadSerializerKt {
    /* JADX INFO: renamed from: serializeInventoryConfigurationPayloadWithXmlNameInventoryConfiguration */
    public static final byte[] m481x6a149de2(final InventoryConfiguration input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName(HttpHeaders.DESTINATION));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Filter"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("Id"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("IncludedObjectVersions"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.Boolean.INSTANCE, new XmlSerialName("IsEnabled"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("OptionalFields"), new XmlCollectionName("Field"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Schedule"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("InventoryConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        InventoryDestination destination = input.getDestination();
        if (destination != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, destination, C3524xa1a43c34.INSTANCE);
        }
        InventoryFilter filter = input.getFilter();
        if (filter != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, filter, C3525xa1a43ff5.INSTANCE);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor3, input.getId());
        structSerializerBeginStruct.field(sdkFieldDescriptor4, input.getIncludedObjectVersions().getValue());
        structSerializerBeginStruct.field(sdkFieldDescriptor5, input.getIsEnabled());
        if (input.getOptionalFields() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor6, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.InventoryConfigurationPayloadSerializerKt$serializeInventoryConfigurationPayloadWithXmlNameInventoryConfiguration$1$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<InventoryOptionalField> it = input.getOptionalFields().iterator();
                    while (it.hasNext()) {
                        listField.serializeString(it.next().getValue());
                    }
                }
            });
        }
        InventorySchedule schedule = input.getSchedule();
        if (schedule != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor7, schedule, C3527xa1a44777.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}
