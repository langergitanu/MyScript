package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.MessageType;
import aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializerKt;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ResponseHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, m1599d2 = {"type", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", "aws-event-stream"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResponseHeadersKt {
    @InternalApi
    public static final MessageType type(Message message) {
        HeaderValue value;
        String strExpectString;
        HeaderValue value2;
        HeaderValue value3;
        HeaderValue value4;
        HeaderValue value5;
        Intrinsics.checkNotNullParameter(message, "<this>");
        List<Header> headers = message.getHeaders();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(headers, 10)), 16));
        for (Object obj : headers) {
            linkedHashMap.put(((Header) obj).getName(), obj);
        }
        Object obj2 = linkedHashMap.get(":message-type");
        if (obj2 == null) {
            throw new IllegalStateException("`:message-type` header is required to deserialize an event stream message".toString());
        }
        String strExpectString2 = HeaderValueKt.expectString(((Header) obj2).getValue());
        Header header = (Header) linkedHashMap.get(":event-type");
        String strExpectString3 = null;
        String strExpectString4 = (header == null || (value5 = header.getValue()) == null) ? null : HeaderValueKt.expectString(value5);
        Header header2 = (Header) linkedHashMap.get(":exception-type");
        String strExpectString5 = (header2 == null || (value4 = header2.getValue()) == null) ? null : HeaderValueKt.expectString(value4);
        Header header3 = (Header) linkedHashMap.get(":content-type");
        String strExpectString6 = (header3 == null || (value3 = header3.getValue()) == null) ? null : HeaderValueKt.expectString(value3);
        int iHashCode = strExpectString2.hashCode();
        if (iHashCode != 96784904) {
            if (iHashCode != 96891546) {
                if (iHashCode == 1481625679 && strExpectString2.equals("exception")) {
                    if (strExpectString5 != null) {
                        return new MessageType.Exception(strExpectString5, strExpectString6);
                    }
                    throw new IllegalStateException("Invalid `exception` message: `:exception-type` header is missing".toString());
                }
            } else if (strExpectString2.equals(NotificationCompat.CATEGORY_EVENT)) {
                if (strExpectString4 != null) {
                    return new MessageType.Event(strExpectString4, strExpectString6);
                }
                throw new IllegalStateException("Invalid `event` message: `:event-type` header is missing".toString());
            }
        } else if (strExpectString2.equals("error")) {
            Header header4 = (Header) linkedHashMap.get(":error-code");
            if (header4 == null || (value = header4.getValue()) == null || (strExpectString = HeaderValueKt.expectString(value)) == null) {
                throw new IllegalStateException("Invalid `error` message: `:error-code` header is missing".toString());
            }
            Header header5 = (Header) linkedHashMap.get(RestJsonErrorDeserializerKt.X_AMZN_EVENT_ERROR_MESSAGE_HEADER_NAME);
            if (header5 != null && (value2 = header5.getValue()) != null) {
                strExpectString3 = HeaderValueKt.expectString(value2);
            }
            return new MessageType.Error(strExpectString, strExpectString3);
        }
        return new MessageType.SdkUnknown(strExpectString2);
    }
}
