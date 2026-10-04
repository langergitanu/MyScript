package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.MalformedPolicyDocumentException;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MalformedPolicyDocumentExceptionDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"deserializeMalformedPolicyDocumentExceptionError", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/MalformedPolicyDocumentException$Builder;", "payload", "", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MalformedPolicyDocumentExceptionDeserializerKt {
    public static final void deserializeMalformedPolicyDocumentExceptionError(MalformedPolicyDocumentException.Builder builder, byte[] payload) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(payload, "payload");
        XmlTagReader xmlTagReaderUnwrapWrappedXmlErrorResponse = XmlErrorUtilsKt.unwrapWrappedXmlErrorResponse(XmlTagReaderKt.xmlTagReader(payload));
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReaderUnwrapWrappedXmlErrorResponse.nextTag();
            if (xmlTagReaderNextTag == null) {
                return;
            }
            if (Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "message")) {
                Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                if (thM14502exceptionOrNullimpl != null) {
                    Result.Companion companion = Result.INSTANCE;
                    objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.sts#malformedPolicyDocumentMessage`)", thM14502exceptionOrNullimpl)));
                }
                ResultKt.throwOnFailure(objTryData);
                builder.setMessage((String) objTryData);
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
