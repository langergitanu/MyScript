package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.AnalyticsConfiguration;
import aws.sdk.kotlin.services.p010s3.model.AnalyticsFilter;
import aws.sdk.kotlin.services.p010s3.model.StorageClassAnalysis;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeAnalyticsConfigurationPayloadWithXmlNameAnalyticsConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnalyticsConfigurationPayloadSerializerKt {
    /* JADX INFO: renamed from: serializeAnalyticsConfigurationPayloadWithXmlNameAnalyticsConfiguration */
    public static final byte[] m474xc21df40e(AnalyticsConfiguration input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Filter"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("Id"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("StorageClassAnalysis"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("AnalyticsConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        AnalyticsFilter filter = input.getFilter();
        if (filter != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, filter, C3484xb7ca3a0a.INSTANCE);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor2, input.getId());
        StorageClassAnalysis storageClassAnalysis = input.getStorageClassAnalysis();
        if (storageClassAnalysis != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, storageClassAnalysis, C3485xb7ca3dcb.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}
