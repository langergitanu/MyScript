package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.ExpirationStatus;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRule;
import aws.smithy.kotlin.runtime.collections.CollectionExtKt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifecycleRuleDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeLifecycleRuleDocument", "Laws/sdk/kotlin/services/s3/model/LifecycleRule;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleRuleDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LifecycleRule deserializeLifecycleRuleDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        LifecycleRule.Builder builder = new LifecycleRule.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1949075583:
                    if (tagName.equals("NoncurrentVersionTransition")) {
                        builder.setNoncurrentVersionTransitions(CollectionExtKt.createOrAppend(builder.getNoncurrentVersionTransitions(), NoncurrentVersionTransitionDocumentDeserializerKt.deserializeNoncurrentVersionTransitionDocument(xmlTagReaderNextTag)));
                    }
                    break;
                case -1896243534:
                    if (tagName.equals(TextFieldImplKt.PrefixId)) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Prefix`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setPrefix((String) objTryData);
                    }
                    break;
                case -1808614382:
                    if (tagName.equals("Status")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData2)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setStatus((ExpirationStatus) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ExpirationStatus.INSTANCE.fromValue((String) objTryData2));
                            } catch (Throwable th) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objTryData2 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion4 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ExpirationStatus`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setStatus((ExpirationStatus) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case -1558101153:
                    if (tagName.equals("AbortIncompleteMultipartUpload")) {
                        builder.setAbortIncompleteMultipartUpload(AbortIncompleteMultipartUploadDocumentDeserializerKt.deserializeAbortIncompleteMultipartUploadDocument(xmlTagReaderNextTag));
                    }
                    break;
                case -1062382373:
                    if (tagName.equals("NoncurrentVersionExpiration")) {
                        builder.setNoncurrentVersionExpiration(NoncurrentVersionExpirationDocumentDeserializerKt.deserializeNoncurrentVersionExpirationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case PDFACompliance.e_PDFA2_3_3_1 /* 2331 */:
                    if (tagName.equals("ID")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ID`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setId((String) objTryData3);
                    }
                    break;
                case 269306229:
                    if (tagName.equals("Transition")) {
                        builder.setTransitions(CollectionExtKt.createOrAppend(builder.getTransitions(), TransitionDocumentDeserializerKt.deserializeTransitionDocument(xmlTagReaderNextTag)));
                    }
                    break;
                case 1155999439:
                    if (tagName.equals("Expiration")) {
                        builder.setExpiration(LifecycleExpirationDocumentDeserializerKt.deserializeLifecycleExpirationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 2104342424:
                    if (tagName.equals("Filter")) {
                        builder.setFilter(LifecycleRuleFilterDocumentDeserializerKt.deserializeLifecycleRuleFilterDocument(xmlTagReaderNextTag));
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
