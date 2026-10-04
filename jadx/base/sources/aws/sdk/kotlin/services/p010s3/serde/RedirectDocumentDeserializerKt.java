package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Protocol;
import aws.sdk.kotlin.services.p010s3.model.Redirect;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RedirectDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeRedirectDocument", "Laws/sdk/kotlin/services/s3/model/Redirect;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RedirectDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Redirect deserializeRedirectDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        Redirect.Builder builder = new Redirect.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1246725487:
                    if (tagName.equals("ReplaceKeyWith")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ReplaceKeyWith`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setReplaceKeyWith((String) objTryData);
                    }
                    break;
                case -924519752:
                    if (tagName.equals("Protocol")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData2)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setProtocol((Protocol) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(Protocol.INSTANCE.fromValue((String) objTryData2));
                            } catch (Throwable th) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objTryData2 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion4 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#Protocol`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setProtocol((Protocol) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case -236112781:
                    if (tagName.equals("HostName")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#HostName`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setHostName((String) objTryData3);
                    }
                    break;
                case 481681585:
                    if (tagName.equals("HttpRedirectCode")) {
                        Object objTryData4 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData4);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objTryData4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#HttpRedirectCode`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData4);
                        builder.setHttpRedirectCode((String) objTryData4);
                    }
                    break;
                case 581780483:
                    if (tagName.equals("ReplaceKeyPrefixWith")) {
                        Object objTryData5 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl5 = Result.m14502exceptionOrNullimpl(objTryData5);
                        if (thM14502exceptionOrNullimpl5 != null) {
                            Result.Companion companion7 = Result.INSTANCE;
                            objTryData5 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ReplaceKeyPrefixWith`)", thM14502exceptionOrNullimpl5)));
                        }
                        ResultKt.throwOnFailure(objTryData5);
                        builder.setReplaceKeyPrefixWith((String) objTryData5);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
