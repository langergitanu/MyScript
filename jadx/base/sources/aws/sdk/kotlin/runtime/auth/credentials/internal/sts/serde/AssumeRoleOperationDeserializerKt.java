package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.PackedPolicyTooLargeException;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.StsException;
import aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails;
import aws.smithy.kotlin.runtime.awsprotocol.ProtocolErrorsKt;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.awsprotocol.xml.RestXmlErrorDeserializerKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: compiled from: AssumeRoleOperationDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m1599d2 = {"throwAssumeRoleError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeAssumeRoleOperationBody", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse$Builder;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleOperationDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Void throwAssumeRoleError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
        PackedPolicyTooLargeException stsException;
        HttpResponse httpResponseWithPayload = ResponseUtilsKt.withPayload(httpCall.getResponse(), bArr);
        HttpCall httpCallCopy$default = HttpCall.copy$default(httpCall, null, httpResponseWithPayload, 1, null);
        try {
            if (bArr == null) {
                throw new IllegalStateException("unable to parse error from empty response".toString());
            }
            ErrorDetails restXmlErrorResponse = RestXmlErrorDeserializerKt.parseRestXmlErrorResponse(bArr);
            String code = restXmlErrorResponse.getCode();
            if (code != null) {
                switch (code.hashCode()) {
                    case -924282799:
                        stsException = !code.equals("PackedPolicyTooLarge") ? new StsException(restXmlErrorResponse.getMessage()) : new PackedPolicyTooLargeExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                        break;
                    case -608224069:
                        if (code.equals("ExpiredTokenException")) {
                            stsException = new ExpiredTokenExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case -109774721:
                        if (code.equals("RegionDisabledException")) {
                            stsException = new RegionDisabledExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 534430952:
                        if (code.equals("MalformedPolicyDocument")) {
                            stsException = new MalformedPolicyDocumentExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                }
            }
            ProtocolErrorsKt.setAseErrorMetadata(stsException, httpResponseWithPayload, restXmlErrorResponse);
            throw stsException;
        } catch (Exception e) {
            StsException stsException2 = new StsException("Failed to parse response as 'awsQuery' error", e);
            ProtocolErrorsKt.setAseErrorMetadata(stsException2, httpCallCopy$default.getResponse(), null);
            throw stsException2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void deserializeAssumeRoleOperationBody(AssumeRoleResponse.Builder builder, byte[] bArr) {
        XmlTagReader xmlTagReaderUnwrapAwsQueryResponse = AwsQueryUtilKt.unwrapAwsQueryResponse(XmlTagReaderKt.xmlTagReader(bArr), "AssumeRole");
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReaderUnwrapAwsQueryResponse.nextTag();
            if (xmlTagReaderNextTag == null) {
                return;
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1787805543:
                    if (tagName.equals("AssumedRoleUser")) {
                        builder.setAssumedRoleUser(AssumedRoleUserDocumentDeserializerKt.deserializeAssumedRoleUserDocument(xmlTagReaderNextTag));
                    }
                    break;
                case -1686485237:
                    if (tagName.equals("PackedPolicySize")) {
                        Object objM14499constructorimpl = ParsersKt.parseInt(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (integer: `com.amazonaws.sts#nonNegativeIntegerType`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setPackedPolicySize((Integer) objM14499constructorimpl);
                    }
                    break;
                case 1793703449:
                    if (tagName.equals("SourceIdentity")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.sts#sourceIdentityType`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setSourceIdentity((String) objTryData);
                    }
                    break;
                case 1956825820:
                    if (tagName.equals("Credentials")) {
                        builder.setCredentials(CredentialsDocumentDeserializerKt.deserializeCredentialsDocument(xmlTagReaderNextTag));
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
