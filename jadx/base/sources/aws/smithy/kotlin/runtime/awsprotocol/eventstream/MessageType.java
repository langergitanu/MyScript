package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType;", "", "<init>", "()V", "Event", "Exception", "Error", "SdkUnknown", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$Error;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$Event;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$Exception;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$SdkUnknown;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class MessageType {
    public /* synthetic */ MessageType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MessageType() {
    }

    /* JADX INFO: compiled from: ResponseHeaders.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$Event;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType;", "shapeType", "", "contentType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getShapeType", "()Ljava/lang/String;", "getContentType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Event extends MessageType {
        private final String contentType;
        private final String shapeType;

        public static /* synthetic */ Event copy$default(Event event, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = event.shapeType;
            }
            if ((i & 2) != 0) {
                str2 = event.contentType;
            }
            return event.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getShapeType() {
            return this.shapeType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContentType() {
            return this.contentType;
        }

        public final Event copy(String shapeType, String contentType) {
            Intrinsics.checkNotNullParameter(shapeType, "shapeType");
            return new Event(shapeType, contentType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return Intrinsics.areEqual(this.shapeType, event.shapeType) && Intrinsics.areEqual(this.contentType, event.contentType);
        }

        public int hashCode() {
            int iHashCode = this.shapeType.hashCode() * 31;
            String str = this.contentType;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Event(shapeType=" + this.shapeType + ", contentType=" + this.contentType + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(String shapeType, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(shapeType, "shapeType");
            this.shapeType = shapeType;
            this.contentType = str;
        }

        public /* synthetic */ Event(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final String getShapeType() {
            return this.shapeType;
        }
    }

    /* JADX INFO: compiled from: ResponseHeaders.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$Exception;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType;", "shapeType", "", "contentType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getShapeType", "()Ljava/lang/String;", "getContentType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Exception extends MessageType {
        private final String contentType;
        private final String shapeType;

        public static /* synthetic */ Exception copy$default(Exception exception, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = exception.shapeType;
            }
            if ((i & 2) != 0) {
                str2 = exception.contentType;
            }
            return exception.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getShapeType() {
            return this.shapeType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContentType() {
            return this.contentType;
        }

        public final Exception copy(String shapeType, String contentType) {
            Intrinsics.checkNotNullParameter(shapeType, "shapeType");
            return new Exception(shapeType, contentType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Exception)) {
                return false;
            }
            Exception exception = (Exception) other;
            return Intrinsics.areEqual(this.shapeType, exception.shapeType) && Intrinsics.areEqual(this.contentType, exception.contentType);
        }

        public int hashCode() {
            int iHashCode = this.shapeType.hashCode() * 31;
            String str = this.contentType;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Exception(shapeType=" + this.shapeType + ", contentType=" + this.contentType + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Exception(String shapeType, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(shapeType, "shapeType");
            this.shapeType = shapeType;
            this.contentType = str;
        }

        public /* synthetic */ Exception(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getContentType() {
            return this.contentType;
        }

        public final String getShapeType() {
            return this.shapeType;
        }
    }

    /* JADX INFO: compiled from: ResponseHeaders.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$Error;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType;", "errorCode", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Error extends MessageType {
        private final String errorCode;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.errorCode;
            }
            if ((i & 2) != 0) {
                str2 = error.message;
            }
            return error.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String errorCode, String message) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            return new Error(errorCode, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.errorCode, error.errorCode) && Intrinsics.areEqual(this.message, error.message);
        }

        public int hashCode() {
            int iHashCode = this.errorCode.hashCode() * 31;
            String str = this.message;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Error(errorCode=" + this.errorCode + ", message=" + this.message + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String errorCode, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            this.errorCode = errorCode;
            this.message = str;
        }

        public /* synthetic */ Error(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: ResponseHeaders.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType$SdkUnknown;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageType;", "messageType", "", "<init>", "(Ljava/lang/String;)V", "getMessageType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends MessageType {
        private final String messageType;

        public static /* synthetic */ SdkUnknown copy$default(SdkUnknown sdkUnknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sdkUnknown.messageType;
            }
            return sdkUnknown.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessageType() {
            return this.messageType;
        }

        public final SdkUnknown copy(String messageType) {
            Intrinsics.checkNotNullParameter(messageType, "messageType");
            return new SdkUnknown(messageType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SdkUnknown) && Intrinsics.areEqual(this.messageType, ((SdkUnknown) other).messageType);
        }

        public int hashCode() {
            return this.messageType.hashCode();
        }

        public String toString() {
            return "SdkUnknown(messageType=" + this.messageType + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkUnknown(String messageType) {
            super(null);
            Intrinsics.checkNotNullParameter(messageType, "messageType");
            this.messageType = messageType;
        }

        public final String getMessageType() {
            return this.messageType;
        }
    }
}
