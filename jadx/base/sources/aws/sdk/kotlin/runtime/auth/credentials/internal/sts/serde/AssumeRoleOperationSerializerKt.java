package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClientKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.PolicyDescriptorType;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.ProvidedContext;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.Tag;
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

/* JADX INFO: compiled from: AssumeRoleOperationSerializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, m1599d2 = {"serializeAssumeRoleOperationBody", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleOperationSerializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] serializeAssumeRoleOperationBody(ExecutionContext executionContext, AssumeRoleRequest assumeRoleRequest) {
        final AssumeRoleRequest assumeRoleRequest2;
        Serializer serializerFormUrlSerializer = FormUrlSerializerKt.FormUrlSerializer();
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new FormUrlSerialName("DurationSeconds"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("ExternalId"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("Policy"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new FormUrlSerialName("PolicyArns"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new FormUrlSerialName("ProvidedContexts"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("RoleArn"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("RoleSessionName"));
        SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("SerialNumber"));
        SdkFieldDescriptor sdkFieldDescriptor9 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("SourceIdentity"));
        SdkFieldDescriptor sdkFieldDescriptor10 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new FormUrlSerialName("Tags"));
        SdkFieldDescriptor sdkFieldDescriptor11 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new FormUrlSerialName("TokenCode"));
        SdkFieldDescriptor sdkFieldDescriptor12 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new FormUrlSerialName("TransitiveTagKeys"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new FormUrlSerialName("AssumeRoleRequest"));
        builder.trait(new QueryLiteral("Action", "AssumeRole"));
        builder.trait(new QueryLiteral("Version", StsClientKt.ServiceApiVersion));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        builder.field(sdkFieldDescriptor8);
        builder.field(sdkFieldDescriptor9);
        builder.field(sdkFieldDescriptor10);
        builder.field(sdkFieldDescriptor11);
        builder.field(sdkFieldDescriptor12);
        StructSerializer structSerializerBeginStruct = serializerFormUrlSerializer.beginStruct(builder.build());
        Integer durationSeconds = assumeRoleRequest.getDurationSeconds();
        if (durationSeconds != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, durationSeconds.intValue());
        }
        String externalId = assumeRoleRequest.getExternalId();
        if (externalId != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, externalId);
        }
        String policy = assumeRoleRequest.getPolicy();
        if (policy != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, policy);
        }
        if (assumeRoleRequest.getPolicyArns() != null) {
            assumeRoleRequest2 = assumeRoleRequest;
            structSerializerBeginStruct.listField(sdkFieldDescriptor4, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializerKt$serializeAssumeRoleOperationBody$1$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializerKt$serializeAssumeRoleOperationBody$1$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: AssumeRoleOperationSerializer.kt */
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
                    Iterator<PolicyDescriptorType> it = assumeRoleRequest2.getPolicyArns().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        } else {
            assumeRoleRequest2 = assumeRoleRequest;
        }
        if (assumeRoleRequest2.getProvidedContexts() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor5, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializerKt$serializeAssumeRoleOperationBody$1$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializerKt$serializeAssumeRoleOperationBody$1$5$1, reason: invalid class name */
                /* JADX INFO: compiled from: AssumeRoleOperationSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, ProvidedContext, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, ProvidedContextDocumentSerializerKt.class, "serializeProvidedContextDocument", "serializeProvidedContextDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ProvidedContext providedContext) {
                        invoke2(serializer, providedContext);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, ProvidedContext p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        ProvidedContextDocumentSerializerKt.serializeProvidedContextDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<ProvidedContext> it = assumeRoleRequest2.getProvidedContexts().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        String roleArn = assumeRoleRequest2.getRoleArn();
        if (roleArn != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, roleArn);
        }
        String roleSessionName = assumeRoleRequest2.getRoleSessionName();
        if (roleSessionName != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, roleSessionName);
        }
        String serialNumber = assumeRoleRequest2.getSerialNumber();
        if (serialNumber != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor8, serialNumber);
        }
        String sourceIdentity = assumeRoleRequest2.getSourceIdentity();
        if (sourceIdentity != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor9, sourceIdentity);
        }
        if (assumeRoleRequest2.getTags() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor10, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializerKt$serializeAssumeRoleOperationBody$1$10
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializerKt$serializeAssumeRoleOperationBody$1$10$1, reason: invalid class name */
                /* JADX INFO: compiled from: AssumeRoleOperationSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, Tag, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, TagDocumentSerializerKt.class, "serializeTagDocument", "serializeTagDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Tag;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Tag tag) {
                        invoke2(serializer, tag);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, Tag p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        TagDocumentSerializerKt.serializeTagDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<Tag> it = assumeRoleRequest2.getTags().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        String tokenCode = assumeRoleRequest2.getTokenCode();
        if (tokenCode != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor11, tokenCode);
        }
        if (assumeRoleRequest2.getTransitiveTagKeys() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor12, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializerKt$serializeAssumeRoleOperationBody$1$12
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<String> it = assumeRoleRequest2.getTransitiveTagKeys().iterator();
                    while (it.hasNext()) {
                        listField.serializeString(it.next());
                    }
                }
            });
        }
        structSerializerBeginStruct.endStruct();
        return serializerFormUrlSerializer.toByteArray();
    }
}
