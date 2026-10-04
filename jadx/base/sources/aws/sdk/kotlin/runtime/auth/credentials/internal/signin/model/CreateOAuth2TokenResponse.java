package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponseBody;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateOAuth2TokenResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0011\u001a\u00020\u00002\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse$Builder;)V", "tokenOutput", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "getTokenOutput", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateOAuth2TokenResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CreateOAuth2TokenResponseBody tokenOutput;

    public /* synthetic */ CreateOAuth2TokenResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateOAuth2TokenResponse(Builder builder) {
        this.tokenOutput = builder.getTokenOutput();
    }

    public final CreateOAuth2TokenResponseBody getTokenOutput() {
        return this.tokenOutput;
    }

    /* JADX INFO: compiled from: CreateOAuth2TokenResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOAuth2TokenResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateOAuth2TokenResponse(");
        sb.append("tokenOutput=" + this.tokenOutput);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        CreateOAuth2TokenResponseBody createOAuth2TokenResponseBody = this.tokenOutput;
        if (createOAuth2TokenResponseBody != null) {
            return createOAuth2TokenResponseBody.hashCode();
        }
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && getClass() == other.getClass() && Intrinsics.areEqual(this.tokenOutput, ((CreateOAuth2TokenResponse) other).tokenOutput);
    }

    public static /* synthetic */ CreateOAuth2TokenResponse copy$default(CreateOAuth2TokenResponse createOAuth2TokenResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponse.copy.1
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
        Builder builder = new Builder(createOAuth2TokenResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateOAuth2TokenResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateOAuth2TokenResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse;)V", "tokenOutput", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "getTokenOutput", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "setTokenOutput", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private CreateOAuth2TokenResponseBody tokenOutput;

        public final Builder correctErrors$aws_config() {
            return this;
        }

        public final CreateOAuth2TokenResponseBody getTokenOutput() {
            return this.tokenOutput;
        }

        public final void setTokenOutput(CreateOAuth2TokenResponseBody createOAuth2TokenResponseBody) {
            this.tokenOutput = createOAuth2TokenResponseBody;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateOAuth2TokenResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.tokenOutput = x.getTokenOutput();
        }

        public final CreateOAuth2TokenResponse build() {
            return new CreateOAuth2TokenResponse(this, null);
        }

        public final void tokenOutput(Function1<? super CreateOAuth2TokenResponseBody.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.tokenOutput = CreateOAuth2TokenResponseKt.f416x77d50360.invoke(block);
        }
    }
}
