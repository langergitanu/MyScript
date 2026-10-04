package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ObjectLockConfiguration;
import aws.sdk.kotlin.services.p010s3.model.ObjectLockEnabled;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObjectLockConfigurationDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeObjectLockConfigurationDocument", "Laws/sdk/kotlin/services/s3/model/ObjectLockConfiguration;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ObjectLockConfigurationDocumentDeserializerKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ObjectLockConfiguration deserializeObjectLockConfigurationDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        ObjectLockConfiguration.Builder builder = new ObjectLockConfiguration.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                if (!Intrinsics.areEqual(tagName, "ObjectLockEnabled")) {
                    if (Intrinsics.areEqual(tagName, "Rule")) {
                        builder.setRule(ObjectLockRuleDocumentDeserializerKt.deserializeObjectLockRuleDocument(xmlTagReaderNextTag));
                    }
                } else {
                    Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    if (Result.m14506isSuccessimpl(objTryData)) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ObjectLockEnabled.INSTANCE.fromValue((String) objTryData));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData = ResultKt.createFailure(th);
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        }
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ObjectLockEnabled`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setObjectLockEnabled((ObjectLockEnabled) objM14499constructorimpl);
                    } else {
                        objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setObjectLockEnabled((ObjectLockEnabled) objM14499constructorimpl);
                    }
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
