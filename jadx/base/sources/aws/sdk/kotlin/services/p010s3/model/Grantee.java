package aws.sdk.kotlin.services.p010s3.model;

import androidx.autofill.HintConstants;
import aws.sdk.kotlin.services.p010s3.model.Type;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Grantee.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0014\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001a\u001a\u00020\u00002\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Grantee;", "", "builder", "Laws/sdk/kotlin/services/s3/model/Grantee$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/Grantee$Builder;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, "getEmailAddress", "id", "getId", "type", "Laws/sdk/kotlin/services/s3/model/Type;", "getType", "()Laws/sdk/kotlin/services/s3/model/Type;", "uri", "getUri", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Grantee {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String displayName;
    private final String emailAddress;
    private final String id;
    private final Type type;
    private final String uri;

    public /* synthetic */ Grantee(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Grantee(Builder builder) {
        this.displayName = builder.getDisplayName();
        this.emailAddress = builder.getEmailAddress();
        this.id = builder.getId();
        Type type = builder.getType();
        if (type == null) {
            throw new IllegalArgumentException("A non-null value must be provided for type".toString());
        }
        this.type = type;
        this.uri = builder.getUri();
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getEmailAddress() {
        return this.emailAddress;
    }

    public final String getId() {
        return this.id;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: compiled from: Grantee.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Grantee$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/Grantee;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Grantee$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Grantee invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Grantee(");
        sb.append("displayName=" + this.displayName + AbstractJsonLexerKt.COMMA);
        sb.append("emailAddress=" + this.emailAddress + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id + AbstractJsonLexerKt.COMMA);
        sb.append("type=" + this.type + AbstractJsonLexerKt.COMMA);
        sb.append("uri=" + this.uri);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.displayName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.emailAddress;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.id;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.type.hashCode()) * 31;
        String str4 = this.uri;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Grantee grantee = (Grantee) other;
        return Intrinsics.areEqual(this.displayName, grantee.displayName) && Intrinsics.areEqual(this.emailAddress, grantee.emailAddress) && Intrinsics.areEqual(this.id, grantee.id) && Intrinsics.areEqual(this.type, grantee.type) && Intrinsics.areEqual(this.uri, grantee.uri);
    }

    public static /* synthetic */ Grantee copy$default(Grantee grantee, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.Grantee.copy.1
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
        Builder builder = new Builder(grantee);
        block.invoke(builder);
        return builder.build();
    }

    public final Grantee copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: Grantee.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0005H\u0001J\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Grantee$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/Grantee;", "(Laws/sdk/kotlin/services/s3/model/Grantee;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, "getEmailAddress", "setEmailAddress", "id", "getId", "setId", "type", "Laws/sdk/kotlin/services/s3/model/Type;", "getType", "()Laws/sdk/kotlin/services/s3/model/Type;", "setType", "(Laws/sdk/kotlin/services/s3/model/Type;)V", "uri", "getUri", "setUri", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String displayName;
        private String emailAddress;
        private String id;
        private Type type;
        private String uri;

        public final String getDisplayName() {
            return this.displayName;
        }

        public final void setDisplayName(String str) {
            this.displayName = str;
        }

        public final String getEmailAddress() {
            return this.emailAddress;
        }

        public final void setEmailAddress(String str) {
            this.emailAddress = str;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final Type getType() {
            return this.type;
        }

        public final void setType(Type type) {
            this.type = type;
        }

        public final String getUri() {
            return this.uri;
        }

        public final void setUri(String str) {
            this.uri = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Grantee x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.displayName = x.getDisplayName();
            this.emailAddress = x.getEmailAddress();
            this.id = x.getId();
            this.type = x.getType();
            this.uri = x.getUri();
        }

        public final Grantee build() {
            return new Grantee(this, null);
        }

        public final Builder correctErrors$s3() {
            if (this.type == null) {
                this.type = new Type.SdkUnknown("no value provided");
            }
            return this;
        }
    }
}
