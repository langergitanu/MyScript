package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.IntelligentTieringAccessTier;
import aws.sdk.kotlin.services.p010s3.model.InvalidObjectState;
import aws.sdk.kotlin.services.p010s3.model.StorageClass;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InvalidObjectStateDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"deserializeInvalidObjectStateError", "", "builder", "Laws/sdk/kotlin/services/s3/model/InvalidObjectState$Builder;", "payload", "", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InvalidObjectStateDeserializerKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void deserializeInvalidObjectStateError(InvalidObjectState.Builder builder, byte[] payload) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Object objM14499constructorimpl2;
        Throwable thM14502exceptionOrNullimpl2;
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(payload, "payload");
        XmlTagReader xmlTagReaderUnwrapXmlErrorResponse = XmlErrorUtilsKt.unwrapXmlErrorResponse(XmlTagReaderKt.xmlTagReader(payload));
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReaderUnwrapXmlErrorResponse.nextTag();
            if (xmlTagReaderNextTag == null) {
                return;
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            if (!Intrinsics.areEqual(tagName, "AccessTier")) {
                if (Intrinsics.areEqual(tagName, "StorageClass")) {
                    Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    if (Result.m14506isSuccessimpl(objTryData)) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(StorageClass.INSTANCE.fromValue((String) objTryData));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData = ResultKt.createFailure(th);
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        }
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#StorageClass`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setStorageClass((StorageClass) objM14499constructorimpl);
                    } else {
                        objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setStorageClass((StorageClass) objM14499constructorimpl);
                    }
                }
            } else {
                Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                if (Result.m14506isSuccessimpl(objTryData2)) {
                    try {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM14499constructorimpl2 = Result.m14499constructorimpl(IntelligentTieringAccessTier.INSTANCE.fromValue((String) objTryData2));
                    } catch (Throwable th2) {
                        Result.Companion companion5 = Result.INSTANCE;
                        objTryData2 = ResultKt.createFailure(th2);
                        objM14499constructorimpl2 = Result.m14499constructorimpl(objTryData2);
                    }
                    thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                    if (thM14502exceptionOrNullimpl2 != null) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#IntelligentTieringAccessTier`)", thM14502exceptionOrNullimpl2)));
                    }
                    ResultKt.throwOnFailure(objM14499constructorimpl2);
                    builder.setAccessTier((IntelligentTieringAccessTier) objM14499constructorimpl2);
                } else {
                    objM14499constructorimpl2 = Result.m14499constructorimpl(objTryData2);
                    thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                    if (thM14502exceptionOrNullimpl2 != null) {
                    }
                    ResultKt.throwOnFailure(objM14499constructorimpl2);
                    builder.setAccessTier((IntelligentTieringAccessTier) objM14499constructorimpl2);
                }
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
