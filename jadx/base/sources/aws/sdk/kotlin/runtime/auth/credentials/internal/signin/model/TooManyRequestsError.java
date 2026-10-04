package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: TooManyRequestsError.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0082\u0004J'\u0010\u0012\u001a\u00020\u00002\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/SigninException;", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError$Builder;)V", "error", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "getError", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "toString", "", "hashCode", "", "equals", "", "other", "", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooManyRequestsError extends SigninException {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final OAuth2ErrorCode error;

    public /* synthetic */ TooManyRequestsError(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private TooManyRequestsError(Builder builder) {
        super(builder.getMessage());
        OAuth2ErrorCode error = builder.getError();
        if (error == null) {
            throw new IllegalArgumentException("A non-null value must be provided for error".toString());
        }
        this.error = error;
        getSdkErrorMetadata().getAttributes().set(ServiceErrorMetadata.INSTANCE.getErrorType(), ServiceException.ErrorType.Client);
    }

    public final OAuth2ErrorCode getError() {
        return this.error;
    }

    /* JADX INFO: compiled from: TooManyRequestsError.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TooManyRequestsError invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder("TooManyRequestsError(");
        sb.append("error=" + this.error + AbstractJsonLexerKt.COMMA);
        sb.append("message=" + getMessage());
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        return (this.error.hashCode() * 31) + getMessage().hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        TooManyRequestsError tooManyRequestsError = (TooManyRequestsError) other;
        return Intrinsics.areEqual(this.error, tooManyRequestsError.error) && Intrinsics.areEqual(getMessage(), tooManyRequestsError.getMessage());
    }

    public static /* synthetic */ TooManyRequestsError copy$default(TooManyRequestsError tooManyRequestsError, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.TooManyRequestsError.copy.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(tooManyRequestsError);
        block.invoke(builder);
        return builder.build();
    }

    public final TooManyRequestsError copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: TooManyRequestsError.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\r\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError;)V", "error", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "getError", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "setError", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private OAuth2ErrorCode error;
        private String message;

        public final OAuth2ErrorCode getError() {
            return this.error;
        }

        public final void setError(OAuth2ErrorCode oAuth2ErrorCode) {
            this.error = oAuth2ErrorCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(TooManyRequestsError x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.error = x.getError();
            this.message = x.getMessage();
        }

        public final TooManyRequestsError build() {
            return new TooManyRequestsError(this, null);
        }

        public final Builder correctErrors$aws_config() {
            if (this.error == null) {
                this.error = new OAuth2ErrorCode.SdkUnknown("no value provided");
            }
            if (this.message == null) {
                this.message = "";
            }
            return this;
        }
    }
}
