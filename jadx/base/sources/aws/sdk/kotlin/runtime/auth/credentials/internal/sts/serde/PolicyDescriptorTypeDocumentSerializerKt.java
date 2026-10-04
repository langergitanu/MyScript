package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.PolicyDescriptorType;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PolicyDescriptorTypeDocumentSerializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializePolicyDescriptorTypeDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PolicyDescriptorTypeDocumentSerializerKt {
    public static final void serializePolicyDescriptorTypeDocument(Serializer serializer, PolicyDescriptorType input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("arn"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new FormUrlSerialName("PolicyDescriptorType"));
        builder.field(sdkFieldDescriptor);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        String arn = input.getArn();
        if (arn != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, arn);
        }
        structSerializerBeginStruct.endStruct();
    }
}
