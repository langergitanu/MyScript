package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.GlacierJobParameters;
import aws.sdk.kotlin.services.p010s3.model.OutputLocation;
import aws.sdk.kotlin.services.p010s3.model.RestoreRequest;
import aws.sdk.kotlin.services.p010s3.model.RestoreRequestType;
import aws.sdk.kotlin.services.p010s3.model.SelectParameters;
import aws.sdk.kotlin.services.p010s3.model.Tier;
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

/* JADX INFO: compiled from: RestoreRequestPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeRestoreRequestPayloadWithXmlNameRestoreRequest", "", "input", "Laws/sdk/kotlin/services/s3/model/RestoreRequest;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RestoreRequestPayloadSerializerKt {
    public static final byte[] serializeRestoreRequestPayloadWithXmlNameRestoreRequest(RestoreRequest input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new XmlSerialName("Days"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("Description"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("GlacierJobParameters"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("OutputLocation"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("SelectParameters"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("Tier"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("Type"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("RestoreRequest"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        Integer days = input.getDays();
        if (days != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, days.intValue());
        }
        String description = input.getDescription();
        if (description != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, description);
        }
        GlacierJobParameters glacierJobParameters = input.getGlacierJobParameters();
        if (glacierJobParameters != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, glacierJobParameters, C3592x9246393d.INSTANCE);
        }
        OutputLocation outputLocation = input.getOutputLocation();
        if (outputLocation != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor4, outputLocation, C3593x92463cfe.INSTANCE);
        }
        SelectParameters selectParameters = input.getSelectParameters();
        if (selectParameters != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor5, selectParameters, C3594x924640bf.INSTANCE);
        }
        Tier tier = input.getTier();
        if (tier != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, tier.getValue());
        }
        RestoreRequestType type = input.getType();
        if (type != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, type.getValue());
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}
