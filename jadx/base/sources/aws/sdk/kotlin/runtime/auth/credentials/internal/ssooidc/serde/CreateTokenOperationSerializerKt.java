package aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.CreateTokenRequest;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateTokenOperationSerializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, m1599d2 = {"serializeCreateTokenOperationBody", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateTokenOperationSerializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] serializeCreateTokenOperationBody(ExecutionContext executionContext, final CreateTokenRequest createTokenRequest) {
        JsonSerializer jsonSerializer = new JsonSerializer();
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("clientId"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("clientSecret"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("code"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("codeVerifier"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("deviceCode"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("grantType"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("redirectUri"));
        SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("refreshToken"));
        SdkFieldDescriptor sdkFieldDescriptor9 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new JsonSerialName("scope"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        builder.field(sdkFieldDescriptor8);
        builder.field(sdkFieldDescriptor9);
        StructSerializer structSerializerBeginStruct = jsonSerializer.beginStruct(builder.build());
        String clientId = createTokenRequest.getClientId();
        if (clientId != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, clientId);
        }
        String clientSecret = createTokenRequest.getClientSecret();
        if (clientSecret != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, clientSecret);
        }
        String code = createTokenRequest.getCode();
        if (code != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, code);
        }
        String codeVerifier = createTokenRequest.getCodeVerifier();
        if (codeVerifier != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, codeVerifier);
        }
        String deviceCode = createTokenRequest.getDeviceCode();
        if (deviceCode != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, deviceCode);
        }
        String grantType = createTokenRequest.getGrantType();
        if (grantType != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, grantType);
        }
        String redirectUri = createTokenRequest.getRedirectUri();
        if (redirectUri != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, redirectUri);
        }
        String refreshToken = createTokenRequest.getRefreshToken();
        if (refreshToken != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor8, refreshToken);
        }
        if (createTokenRequest.getScope() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor9, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.serde.CreateTokenOperationSerializerKt$serializeCreateTokenOperationBody$1$9
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<String> it = createTokenRequest.getScope().iterator();
                    while (it.hasNext()) {
                        listField.serializeString(it.next());
                    }
                }
            });
        }
        structSerializerBeginStruct.endStruct();
        return jsonSerializer.toByteArray();
    }
}
