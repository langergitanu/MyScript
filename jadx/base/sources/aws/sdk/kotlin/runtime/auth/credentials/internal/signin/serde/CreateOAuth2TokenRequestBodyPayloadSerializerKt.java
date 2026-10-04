package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenRequestBody;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateOAuth2TokenRequestBodyPayloadSerializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeCreateOAuth2TokenRequestBodyPayload", "", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateOAuth2TokenRequestBodyPayloadSerializerKt {
    public static final byte[] serializeCreateOAuth2TokenRequestBodyPayload(CreateOAuth2TokenRequestBody input) {
        Intrinsics.checkNotNullParameter(input, "input");
        JsonSerializer jsonSerializer = new JsonSerializer();
        CreateOAuth2TokenRequestBodyDocumentSerializerKt.serializeCreateOAuth2TokenRequestBodyDocument(jsonSerializer, input);
        return jsonSerializer.toByteArray();
    }
}
