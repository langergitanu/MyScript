package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Event;
import aws.sdk.kotlin.services.p010s3.model.QueueConfiguration;
import aws.smithy.kotlin.runtime.collections.CollectionExtKt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QueueConfigurationDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeQueueConfigurationDocument", "Laws/sdk/kotlin/services/s3/model/QueueConfiguration;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class QueueConfigurationDocumentDeserializerKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final QueueConfiguration deserializeQueueConfigurationDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        QueueConfiguration.Builder builder = new QueueConfiguration.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            int iHashCode = tagName.hashCode();
            if (iHashCode != 2363) {
                if (iHashCode != 67338874) {
                    if (iHashCode != 78391537) {
                        if (iHashCode == 2104342424 && tagName.equals("Filter")) {
                            builder.setFilter(NotificationConfigurationFilterDocumentDeserializerKt.deserializeNotificationConfigurationFilterDocument(xmlTagReaderNextTag));
                        }
                    } else if (tagName.equals("Queue")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#QueueArn`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setQueueArn((String) objTryData);
                    }
                } else if (tagName.equals("Event")) {
                    Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    if (Result.m14506isSuccessimpl(objTryData2)) {
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(Event.INSTANCE.fromValue((String) objTryData2));
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objTryData2 = ResultKt.createFailure(th);
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                        }
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#Event`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setEvents(CollectionExtKt.createOrAppend(builder.getEvents(), (Event) objM14499constructorimpl));
                    } else {
                        objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setEvents(CollectionExtKt.createOrAppend(builder.getEvents(), (Event) objM14499constructorimpl));
                    }
                }
            } else if (tagName.equals("Id")) {
                Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData3);
                if (thM14502exceptionOrNullimpl3 != null) {
                    Result.Companion companion5 = Result.INSTANCE;
                    objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#NotificationId`)", thM14502exceptionOrNullimpl3)));
                }
                ResultKt.throwOnFailure(objTryData3);
                builder.setId((String) objTryData3);
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
