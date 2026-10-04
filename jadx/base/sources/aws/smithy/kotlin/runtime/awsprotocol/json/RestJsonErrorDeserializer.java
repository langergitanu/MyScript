package aws.smithy.kotlin.runtime.awsprotocol.json;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RestJsonErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/json/RestJsonErrorDeserializer;", "", "<init>", "()V", "ERR_CODE_ALT1_DESCRIPTOR", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "ERR_CODE_ALT2_DESCRIPTOR", "MESSAGE_ALT1_DESCRIPTOR", "MESSAGE_ALT2_DESCRIPTOR", "MESSAGE_ALT3_DESCRIPTOR", "OBJ_DESCRIPTOR", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "deserialize", "Laws/smithy/kotlin/runtime/awsprotocol/ErrorDetails;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", "payload", "", "aws-json-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RestJsonErrorDeserializer {
    private static final SdkFieldDescriptor ERR_CODE_ALT1_DESCRIPTOR;
    private static final SdkFieldDescriptor ERR_CODE_ALT2_DESCRIPTOR;
    public static final RestJsonErrorDeserializer INSTANCE = new RestJsonErrorDeserializer();
    private static final SdkFieldDescriptor MESSAGE_ALT1_DESCRIPTOR;
    private static final SdkFieldDescriptor MESSAGE_ALT2_DESCRIPTOR;
    private static final SdkFieldDescriptor MESSAGE_ALT3_DESCRIPTOR;
    private static final SdkObjectDescriptor OBJ_DESCRIPTOR;

    private RestJsonErrorDeserializer() {
    }

    static {
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new JsonSerialName("code"));
        ERR_CODE_ALT1_DESCRIPTOR = sdkFieldDescriptor;
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new JsonSerialName("__type"));
        ERR_CODE_ALT2_DESCRIPTOR = sdkFieldDescriptor2;
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("message"));
        MESSAGE_ALT1_DESCRIPTOR = sdkFieldDescriptor3;
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("Message"));
        MESSAGE_ALT2_DESCRIPTOR = sdkFieldDescriptor4;
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("errorMessage"));
        MESSAGE_ALT3_DESCRIPTOR = sdkFieldDescriptor5;
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        OBJ_DESCRIPTOR = builder.build();
    }

    public final ErrorDetails deserialize(Headers headers, byte[] payload) {
        String strDeserializeString;
        String strDeserializeString2;
        Intrinsics.checkNotNullParameter(headers, "headers");
        String strDeserializeString3 = headers.get(RestJsonErrorDeserializerKt.X_AMZN_ERROR_MESSAGE_HEADER_NAME);
        if (strDeserializeString3 == null) {
            strDeserializeString3 = headers.get(RestJsonErrorDeserializerKt.X_AMZN_EVENT_ERROR_MESSAGE_HEADER_NAME);
        }
        String str = headers.get(RestJsonErrorDeserializerKt.X_AMZN_ERROR_TYPE_HEADER_NAME);
        if (payload != null) {
            Deserializer.FieldIterator fieldIteratorDeserializeStruct = new JsonDeserializer(payload).deserializeStruct(OBJ_DESCRIPTOR);
            strDeserializeString = null;
            strDeserializeString2 = null;
            while (true) {
                Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
                int index = ERR_CODE_ALT1_DESCRIPTOR.getIndex();
                if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index) {
                    strDeserializeString = fieldIteratorDeserializeStruct.deserializeString();
                } else {
                    int index2 = ERR_CODE_ALT2_DESCRIPTOR.getIndex();
                    if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index2) {
                        strDeserializeString2 = fieldIteratorDeserializeStruct.deserializeString();
                    } else {
                        int index3 = MESSAGE_ALT1_DESCRIPTOR.getIndex();
                        if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index3) {
                            int index4 = MESSAGE_ALT2_DESCRIPTOR.getIndex();
                            if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index4) {
                                int index5 = MESSAGE_ALT3_DESCRIPTOR.getIndex();
                                if (numFindNextFieldIndex == null || numFindNextFieldIndex.intValue() != index5) {
                                    if (numFindNextFieldIndex == null) {
                                        break;
                                    }
                                    fieldIteratorDeserializeStruct.skipValue();
                                }
                            }
                        }
                        strDeserializeString3 = fieldIteratorDeserializeStruct.deserializeString();
                    }
                }
            }
        } else {
            strDeserializeString = null;
            strDeserializeString2 = null;
        }
        if (str == null) {
            str = strDeserializeString == null ? strDeserializeString2 : strDeserializeString;
        }
        return new ErrorDetails(ResponseUtilsKt.sanitizeErrorType(str), strDeserializeString3, null);
    }
}
