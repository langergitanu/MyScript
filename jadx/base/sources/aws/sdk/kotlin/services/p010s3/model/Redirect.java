package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Redirect.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0014\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001a\u001a\u00020\u00002\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Redirect;", "", "builder", "Laws/sdk/kotlin/services/s3/model/Redirect$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/Redirect$Builder;)V", "hostName", "", "getHostName", "()Ljava/lang/String;", "httpRedirectCode", "getHttpRedirectCode", "protocol", "Laws/sdk/kotlin/services/s3/model/Protocol;", "getProtocol", "()Laws/sdk/kotlin/services/s3/model/Protocol;", "replaceKeyPrefixWith", "getReplaceKeyPrefixWith", "replaceKeyWith", "getReplaceKeyWith", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Redirect {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String hostName;
    private final String httpRedirectCode;
    private final Protocol protocol;
    private final String replaceKeyPrefixWith;
    private final String replaceKeyWith;

    public /* synthetic */ Redirect(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Redirect(Builder builder) {
        this.hostName = builder.getHostName();
        this.httpRedirectCode = builder.getHttpRedirectCode();
        this.protocol = builder.getProtocol();
        this.replaceKeyPrefixWith = builder.getReplaceKeyPrefixWith();
        this.replaceKeyWith = builder.getReplaceKeyWith();
    }

    public final String getHostName() {
        return this.hostName;
    }

    public final String getHttpRedirectCode() {
        return this.httpRedirectCode;
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }

    public final String getReplaceKeyPrefixWith() {
        return this.replaceKeyPrefixWith;
    }

    public final String getReplaceKeyWith() {
        return this.replaceKeyWith;
    }

    /* JADX INFO: compiled from: Redirect.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Redirect$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/Redirect;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Redirect$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Redirect invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Redirect(");
        sb.append("hostName=" + this.hostName + AbstractJsonLexerKt.COMMA);
        sb.append("httpRedirectCode=" + this.httpRedirectCode + AbstractJsonLexerKt.COMMA);
        sb.append("protocol=" + this.protocol + AbstractJsonLexerKt.COMMA);
        sb.append("replaceKeyPrefixWith=" + this.replaceKeyPrefixWith + AbstractJsonLexerKt.COMMA);
        sb.append("replaceKeyWith=" + this.replaceKeyWith);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.hostName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.httpRedirectCode;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Protocol protocol = this.protocol;
        int iHashCode3 = (iHashCode2 + (protocol != null ? protocol.hashCode() : 0)) * 31;
        String str3 = this.replaceKeyPrefixWith;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.replaceKeyWith;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Redirect redirect = (Redirect) other;
        return Intrinsics.areEqual(this.hostName, redirect.hostName) && Intrinsics.areEqual(this.httpRedirectCode, redirect.httpRedirectCode) && Intrinsics.areEqual(this.protocol, redirect.protocol) && Intrinsics.areEqual(this.replaceKeyPrefixWith, redirect.replaceKeyPrefixWith) && Intrinsics.areEqual(this.replaceKeyWith, redirect.replaceKeyWith);
    }

    public static /* synthetic */ Redirect copy$default(Redirect redirect, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.Redirect.copy.1
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
        Builder builder = new Builder(redirect);
        block.invoke(builder);
        return builder.build();
    }

    public final Redirect copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: Redirect.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0005H\u0001J\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Redirect$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/Redirect;", "(Laws/sdk/kotlin/services/s3/model/Redirect;)V", "hostName", "", "getHostName", "()Ljava/lang/String;", "setHostName", "(Ljava/lang/String;)V", "httpRedirectCode", "getHttpRedirectCode", "setHttpRedirectCode", "protocol", "Laws/sdk/kotlin/services/s3/model/Protocol;", "getProtocol", "()Laws/sdk/kotlin/services/s3/model/Protocol;", "setProtocol", "(Laws/sdk/kotlin/services/s3/model/Protocol;)V", "replaceKeyPrefixWith", "getReplaceKeyPrefixWith", "setReplaceKeyPrefixWith", "replaceKeyWith", "getReplaceKeyWith", "setReplaceKeyWith", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String hostName;
        private String httpRedirectCode;
        private Protocol protocol;
        private String replaceKeyPrefixWith;
        private String replaceKeyWith;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getHostName() {
            return this.hostName;
        }

        public final void setHostName(String str) {
            this.hostName = str;
        }

        public final String getHttpRedirectCode() {
            return this.httpRedirectCode;
        }

        public final void setHttpRedirectCode(String str) {
            this.httpRedirectCode = str;
        }

        public final Protocol getProtocol() {
            return this.protocol;
        }

        public final void setProtocol(Protocol protocol) {
            this.protocol = protocol;
        }

        public final String getReplaceKeyPrefixWith() {
            return this.replaceKeyPrefixWith;
        }

        public final void setReplaceKeyPrefixWith(String str) {
            this.replaceKeyPrefixWith = str;
        }

        public final String getReplaceKeyWith() {
            return this.replaceKeyWith;
        }

        public final void setReplaceKeyWith(String str) {
            this.replaceKeyWith = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Redirect x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.hostName = x.getHostName();
            this.httpRedirectCode = x.getHttpRedirectCode();
            this.protocol = x.getProtocol();
            this.replaceKeyPrefixWith = x.getReplaceKeyPrefixWith();
            this.replaceKeyWith = x.getReplaceKeyWith();
        }

        public final Redirect build() {
            return new Redirect(this, null);
        }
    }
}
