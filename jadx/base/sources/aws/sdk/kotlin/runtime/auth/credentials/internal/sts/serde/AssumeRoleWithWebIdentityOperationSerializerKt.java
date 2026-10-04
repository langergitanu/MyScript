package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClientKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.PolicyDescriptorType;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerialName;
import aws.smithy.kotlin.runtime.serde.formurl.FormUrlSerializerKt;
import aws.smithy.kotlin.runtime.serde.formurl.QueryLiteral;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssumeRoleWithWebIdentityOperationSerializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, m1599d2 = {"serializeAssumeRoleWithWebIdentityOperationBody", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleWithWebIdentityOperationSerializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] serializeAssumeRoleWithWebIdentityOperationBody(ExecutionContext executionContext, final AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest) {
        Serializer serializerFormUrlSerializer = FormUrlSerializerKt.FormUrlSerializer();
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new FormUrlSerialName("DurationSeconds"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("Policy"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new FormUrlSerialName("PolicyArns"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("ProviderId"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("RoleArn"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("RoleSessionName"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("WebIdentityToken"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new FormUrlSerialName("AssumeRoleWithWebIdentityRequest"));
        builder.trait(new QueryLiteral("Action", "AssumeRoleWithWebIdentity"));
        builder.trait(new QueryLiteral("Version", StsClientKt.ServiceApiVersion));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        StructSerializer structSerializerBeginStruct = serializerFormUrlSerializer.beginStruct(builder.build());
        Integer durationSeconds = assumeRoleWithWebIdentityRequest.getDurationSeconds();
        if (durationSeconds != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, durationSeconds.intValue());
        }
        String policy = assumeRoleWithWebIdentityRequest.getPolicy();
        if (policy != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, policy);
        }
        if (assumeRoleWithWebIdentityRequest.getPolicyArns() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor3, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleWithWebIdentityOperationSerializerKt$serializeAssumeRoleWithWebIdentityOperationBody$1$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleWithWebIdentityOperationSerializerKt$serializeAssumeRoleWithWebIdentityOperationBody$1$3$1, reason: invalid class name */
                /* JADX INFO: compiled from: AssumeRoleWithWebIdentityOperationSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, PolicyDescriptorType, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, PolicyDescriptorTypeDocumentSerializerKt.class, "serializePolicyDescriptorTypeDocument", "serializePolicyDescriptorTypeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, PolicyDescriptorType policyDescriptorType) {
                        invoke2(serializer, policyDescriptorType);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, PolicyDescriptorType p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        PolicyDescriptorTypeDocumentSerializerKt.serializePolicyDescriptorTypeDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<PolicyDescriptorType> it = assumeRoleWithWebIdentityRequest.getPolicyArns().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        String providerId = assumeRoleWithWebIdentityRequest.getProviderId();
        if (providerId != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, providerId);
        }
        String roleArn = assumeRoleWithWebIdentityRequest.getRoleArn();
        if (roleArn != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, roleArn);
        }
        String roleSessionName = assumeRoleWithWebIdentityRequest.getRoleSessionName();
        if (roleSessionName != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, roleSessionName);
        }
        String webIdentityToken = assumeRoleWithWebIdentityRequest.getWebIdentityToken();
        if (webIdentityToken != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, webIdentityToken);
        }
        structSerializerBeginStruct.endStruct();
        return serializerFormUrlSerializer.toByteArray();
    }
}
