package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumedRoleUser;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssumedRoleUserDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeAssumedRoleUserDocument", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumedRoleUser;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumedRoleUserDocumentDeserializerKt {
    public static final AssumedRoleUser deserializeAssumedRoleUserDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        AssumedRoleUser.Builder builder = new AssumedRoleUser.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                if (!Intrinsics.areEqual(tagName, "AssumedRoleId")) {
                    if (Intrinsics.areEqual(tagName, "Arn")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.sts#arnType`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setArn((String) objTryData);
                    }
                } else {
                    Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData2);
                    if (thM14502exceptionOrNullimpl2 != null) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.sts#assumedRoleIdType`)", thM14502exceptionOrNullimpl2)));
                    }
                    ResultKt.throwOnFailure(objTryData2);
                    builder.setAssumedRoleId((String) objTryData2);
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$aws_config();
                return builder.build();
            }
        }
    }
}
