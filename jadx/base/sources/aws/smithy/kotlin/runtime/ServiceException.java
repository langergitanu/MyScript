package aws.smithy.kotlin.runtime;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0002\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\tB\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u00020\u00048VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/ServiceException;", "Laws/smithy/kotlin/runtime/SdkBaseException;", "<init>", "()V", "", "message", "(Ljava/lang/String;)V", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "", "getDisplayMetadata", "()Ljava/util/List;", "displayMetadata", "getMessage", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/ServiceErrorMetadata;", "sdkErrorMetadata", "Laws/smithy/kotlin/runtime/ServiceErrorMetadata;", "getSdkErrorMetadata", "()Laws/smithy/kotlin/runtime/ServiceErrorMetadata;", "ErrorType", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ServiceException extends SdkBaseException {
    private final ServiceErrorMetadata sdkErrorMetadata;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Exceptions.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/ServiceException$ErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "Client", "Server", "Unknown", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ErrorType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ErrorType[] $VALUES;
        public static final ErrorType Client = new ErrorType("Client", 0);
        public static final ErrorType Server = new ErrorType("Server", 1);
        public static final ErrorType Unknown = new ErrorType("Unknown", 2);

        private static final /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{Client, Server, Unknown};
        }

        public static EnumEntries<ErrorType> getEntries() {
            return $ENTRIES;
        }

        public static ErrorType valueOf(String str) {
            return (ErrorType) Enum.valueOf(ErrorType.class, str);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        private ErrorType(String str, int i) {
        }

        static {
            ErrorType[] errorTypeArr$values = $values();
            $VALUES = errorTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(errorTypeArr$values);
        }
    }

    public ServiceException() {
        this.sdkErrorMetadata = new ServiceErrorMetadata();
    }

    public ServiceException(String str) {
        super(str);
        this.sdkErrorMetadata = new ServiceErrorMetadata();
    }

    public ServiceException(String str, Throwable th) {
        super(str, th);
        this.sdkErrorMetadata = new ServiceErrorMetadata();
    }

    public ServiceException(Throwable th) {
        super(th);
        this.sdkErrorMetadata = new ServiceErrorMetadata();
    }

    private final List<String> getDisplayMetadata() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        String message = super.getMessage();
        if (message == null) {
            message = getSdkErrorMetadata().getErrorMessage();
        }
        if (message == null) {
            String errorCode = getSdkErrorMetadata().getErrorCode();
            if (errorCode != null) {
                listCreateListBuilder.add("Service returned error code " + errorCode);
            }
            listCreateListBuilder.add("Error type: " + getSdkErrorMetadata().getErrorType());
            listCreateListBuilder.add("Protocol response: " + getSdkErrorMetadata().getProtocolResponse().getSummary());
        } else {
            listCreateListBuilder.add(message);
        }
        String requestId = getSdkErrorMetadata().getRequestId();
        if (requestId != null) {
            listCreateListBuilder.add("Request ID: " + requestId);
        }
        List list = listCreateListBuilder;
        Iterator<T> it = getSdkErrorMetadata().getClientContext().iterator();
        while (it.hasNext()) {
            list.add(((ClientErrorContext) it.next()).getFormatted());
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return CollectionsKt.joinToString$default(getDisplayMetadata(), null, null, null, 0, null, null, 63, null);
    }

    @Override // aws.smithy.kotlin.runtime.SdkBaseException
    public ServiceErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }
}
