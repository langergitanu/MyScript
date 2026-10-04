package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.SdkBaseException;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpException.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB1\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\fB'\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\n\u0010\u0012\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpException;", "Laws/smithy/kotlin/runtime/SdkBaseException;", "message", "", "errorCode", "Laws/smithy/kotlin/runtime/http/HttpErrorCode;", "retryable", "", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/http/HttpErrorCode;Z)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;Laws/smithy/kotlin/runtime/http/HttpErrorCode;Z)V", "(Ljava/lang/Throwable;Laws/smithy/kotlin/runtime/http/HttpErrorCode;Z)V", "getErrorCode", "()Laws/smithy/kotlin/runtime/http/HttpErrorCode;", "setRetryable", "", "toString", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpException extends SdkBaseException {
    private final HttpErrorCode errorCode;

    /* JADX INFO: compiled from: HttpException.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpErrorCode.values().length];
            try {
                iArr[HttpErrorCode.CONNECT_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HttpErrorCode.TLS_NEGOTIATION_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HttpErrorCode.SDK_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final HttpErrorCode getErrorCode() {
        return this.errorCode;
    }

    public /* synthetic */ HttpException(String str, HttpErrorCode httpErrorCode, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? HttpErrorCode.SDK_UNKNOWN : httpErrorCode, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(String str, HttpErrorCode errorCode, boolean z) {
        super(str);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
        setRetryable(z);
    }

    public /* synthetic */ HttpException(String str, Throwable th, HttpErrorCode httpErrorCode, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th, (i & 4) != 0 ? HttpErrorCode.SDK_UNKNOWN : httpErrorCode, (i & 8) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(String str, Throwable th, HttpErrorCode errorCode, boolean z) {
        super(str, th);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
        setRetryable(z);
    }

    public /* synthetic */ HttpException(Throwable th, HttpErrorCode httpErrorCode, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? HttpErrorCode.SDK_UNKNOWN : httpErrorCode, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(Throwable th, HttpErrorCode errorCode, boolean z) {
        super(th);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
        setRetryable(z);
    }

    private final void setRetryable(boolean retryable) {
        MutableAttributes attributes = getSdkErrorMetadata().getAttributes();
        AttributeKey<Boolean> retryable2 = ErrorMetadata.INSTANCE.getRetryable();
        boolean z = true;
        if (!retryable) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.errorCode.ordinal()];
            if (i != 1 && i != 2) {
                z = false;
            }
        }
        attributes.set(retryable2, Boolean.valueOf(z));
    }

    @Override // java.lang.Throwable
    public String toString() {
        String string = super.toString();
        return WhenMappings.$EnumSwitchMapping$0[this.errorCode.ordinal()] == 3 ? string : string + "; HttpErrorCode(" + this.errorCode + ')';
    }
}
