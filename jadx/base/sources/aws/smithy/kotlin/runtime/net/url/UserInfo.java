package aws.smithy.kotlin.runtime.net.url;

import androidx.autofill.HintConstants;
import aws.smithy.kotlin.runtime.net.url.UserInfo;
import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: UserInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UserInfo;", "", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "userName", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(Laws/smithy/kotlin/runtime/text/encoding/Encodable;Laws/smithy/kotlin/runtime/text/encoding/Encodable;)V", "Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;", "toBuilder", "()Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "getUserName", "()Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "getPassword", "isEmpty", "Z", "()Z", "isNotEmpty", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserInfo Empty = new UserInfo(Encodable.INSTANCE.getEmpty(), Encodable.INSTANCE.getEmpty());
    private final boolean isEmpty;
    private final boolean isNotEmpty;
    private final Encodable password;
    private final Encodable userName;

    public /* synthetic */ UserInfo(Encodable encodable, Encodable encodable2, DefaultConstructorMarker defaultConstructorMarker) {
        this(encodable, encodable2);
    }

    /* JADX INFO: compiled from: UserInfo.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UserInfo$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/net/url/UserInfo;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/net/url/UserInfo;", "", "decoded", "parseDecoded", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/url/UserInfo;", "encoded", "parseEncoded", "Empty", "Laws/smithy/kotlin/runtime/net/url/UserInfo;", "getEmpty", "()Laws/smithy/kotlin/runtime/net/url/UserInfo;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserInfo getEmpty() {
            return UserInfo.Empty;
        }

        public final UserInfo invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parseDecoded$lambda$0(String str, Builder UserInfo) {
            Intrinsics.checkNotNullParameter(UserInfo, "$this$UserInfo");
            UserInfo.parseDecoded$runtime_core(str);
            return Unit.INSTANCE;
        }

        public final UserInfo parseDecoded(final String decoded) {
            Intrinsics.checkNotNullParameter(decoded, "decoded");
            return UserInfo.INSTANCE.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.UserInfo$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserInfo.Companion.parseDecoded$lambda$0(decoded, (UserInfo.Builder) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parseEncoded$lambda$0(String str, Builder UserInfo) {
            Intrinsics.checkNotNullParameter(UserInfo, "$this$UserInfo");
            UserInfo.parseEncoded$runtime_core(str);
            return Unit.INSTANCE;
        }

        public final UserInfo parseEncoded(final String encoded) {
            Intrinsics.checkNotNullParameter(encoded, "encoded");
            return UserInfo.INSTANCE.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.UserInfo$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserInfo.Companion.parseEncoded$lambda$0(encoded, (UserInfo.Builder) obj);
                }
            });
        }
    }

    private UserInfo(Encodable encodable, Encodable encodable2) {
        this.userName = encodable;
        this.password = encodable2;
        if (!encodable2.getIsEmpty() && !encodable.getIsNotEmpty()) {
            throw new IllegalArgumentException("Cannot have a password without a user name".toString());
        }
        boolean z = encodable.getIsEmpty() && encodable2.getIsEmpty();
        this.isEmpty = z;
        this.isNotEmpty = !z;
    }

    public final Encodable getPassword() {
        return this.password;
    }

    public final Encodable getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    /* JADX INFO: renamed from: isNotEmpty, reason: from getter */
    public final boolean getIsNotEmpty() {
        return this.isNotEmpty;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.userName, userInfo.userName) && Intrinsics.areEqual(this.password, userInfo.password);
    }

    public int hashCode() {
        return (this.userName.hashCode() * 31) + this.password.hashCode();
    }

    public String toString() {
        return this.userName.getIsEmpty() ? "" : this.password.getIsEmpty() ? this.userName.getEncoded() : this.userName.getEncoded() + AbstractJsonLexerKt.COLON + this.password.getEncoded();
    }

    /* JADX INFO: compiled from: UserInfo.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000bJ+\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u000bR$\u0010$\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010\u000bR\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001cR$\u0010(\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010\u000bR$\u0010+\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010\u000b¨\u0006,"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;", "", "Laws/smithy/kotlin/runtime/net/url/UserInfo;", "userInfo", "<init>", "(Laws/smithy/kotlin/runtime/net/url/UserInfo;)V", "()V", "", "decoded", "", "parseDecoded$runtime_core", "(Ljava/lang/String;)V", "parseDecoded", "encoded", "parseEncoded$runtime_core", "parseEncoded", "text", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "toEncodable", "parse", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "build", "()Laws/smithy/kotlin/runtime/net/url/UserInfo;", "other", "copyFrom", "(Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;)V", "userName", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "value", "getDecodedUserName", "()Ljava/lang/String;", "setDecodedUserName", "decodedUserName", "getEncodedUserName", "setEncodedUserName", "encodedUserName", HintConstants.AUTOFILL_HINT_PASSWORD, "getDecodedPassword", "setDecodedPassword", "decodedPassword", "getEncodedPassword", "setEncodedPassword", "encodedPassword", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Encodable password;
        private Encodable userName;

        public Builder(UserInfo userInfo) {
            Encodable password;
            Encodable userName;
            this.userName = (userInfo == null || (userName = userInfo.getUserName()) == null) ? Encodable.INSTANCE.getEmpty() : userName;
            this.password = (userInfo == null || (password = userInfo.getPassword()) == null) ? Encodable.INSTANCE.getEmpty() : password;
        }

        public Builder() {
            this(null);
        }

        public final String getDecodedUserName() {
            return this.userName.getDecoded();
        }

        public final void setDecodedUserName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.userName = PercentEncoding.INSTANCE.getUserInfo().encodableFromDecoded(value);
        }

        public final String getEncodedUserName() {
            return this.userName.getEncoded();
        }

        public final void setEncodedUserName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.userName = PercentEncoding.INSTANCE.getUserInfo().encodableFromEncoded(value);
        }

        public final String getDecodedPassword() {
            return this.password.getDecoded();
        }

        public final void setDecodedPassword(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.password = PercentEncoding.INSTANCE.getUserInfo().encodableFromDecoded(value);
        }

        public final String getEncodedPassword() {
            return this.password.getEncoded();
        }

        public final void setEncodedPassword(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.password = PercentEncoding.INSTANCE.getUserInfo().encodableFromEncoded(value);
        }

        public final void parseDecoded$runtime_core(String decoded) {
            Intrinsics.checkNotNullParameter(decoded, "decoded");
            parse(decoded, new UserInfo$Builder$parseDecoded$1(PercentEncoding.INSTANCE.getUserInfo()));
        }

        public final void parseEncoded$runtime_core(String encoded) {
            Intrinsics.checkNotNullParameter(encoded, "encoded");
            parse(encoded, new UserInfo$Builder$parseEncoded$1(PercentEncoding.INSTANCE.getUserInfo()));
        }

        private final void parse(String text, Function1<? super String, Encodable> toEncodable) {
            Encodable empty;
            String str = text;
            if (str.length() == 0) {
                this.userName = Encodable.INSTANCE.getEmpty();
                this.password = Encodable.INSTANCE.getEmpty();
                return;
            }
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 2, 2, (Object) null);
            this.userName = toEncodable.invoke(listSplit$default.get(0));
            int size = listSplit$default.size();
            if (size == 1) {
                empty = Encodable.INSTANCE.getEmpty();
            } else if (size == 2) {
                empty = toEncodable.invoke(listSplit$default.get(1));
            } else {
                throw new IllegalArgumentException("invalid user info string " + text);
            }
            this.password = empty;
        }

        public final UserInfo build() {
            return new UserInfo(this.userName, this.password, null);
        }

        public final void copyFrom(UserInfo other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.userName = other.getUserName();
            this.password = other.getPassword();
        }

        public final void copyFrom(Builder other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.userName = other.userName;
            this.password = other.password;
        }
    }
}
