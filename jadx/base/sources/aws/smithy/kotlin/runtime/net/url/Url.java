package aws.smithy.kotlin.runtime.net.url;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.HostKt;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.url.QueryParameters;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.net.url.UrlEncoding;
import aws.smithy.kotlin.runtime.net.url.UrlPath;
import aws.smithy.kotlin.runtime.net.url.UserInfo;
import aws.smithy.kotlin.runtime.text.Scanner;
import aws.smithy.kotlin.runtime.text.TextKt;
import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: Url.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001f\u0018\u0000 >2\u00020\u0001:\u0002>?BC\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0019\u001a\u00020\u00002\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\"\u001a\u00020!H\u0096\u0080\u0004¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0017\u0010:\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b:\u00109\u001a\u0004\b;\u0010#R\u0017\u0010<\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b<\u00109\u001a\u0004\b=\u0010#¨\u0006@"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/Url;", "", "Laws/smithy/kotlin/runtime/net/Scheme;", "scheme", "Laws/smithy/kotlin/runtime/net/Host;", DiagnosticsTracker.HOST_KEY, "", ClientCookie.PORT_ATTR, "Laws/smithy/kotlin/runtime/net/url/UrlPath;", ClientCookie.PATH_ATTR, "Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "parameters", "Laws/smithy/kotlin/runtime/net/url/UserInfo;", "userInfo", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "fragment", "<init>", "(Laws/smithy/kotlin/runtime/net/Scheme;Laws/smithy/kotlin/runtime/net/Host;ILaws/smithy/kotlin/runtime/net/url/UrlPath;Laws/smithy/kotlin/runtime/net/url/QueryParameters;Laws/smithy/kotlin/runtime/net/url/UserInfo;Laws/smithy/kotlin/runtime/text/encoding/Encodable;)V", "Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "toBuilder", "()Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "copy", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/net/url/Url;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/net/Scheme;", "getScheme", "()Laws/smithy/kotlin/runtime/net/Scheme;", "Laws/smithy/kotlin/runtime/net/Host;", "getHost", "()Laws/smithy/kotlin/runtime/net/Host;", "I", "getPort", "Laws/smithy/kotlin/runtime/net/url/UrlPath;", "getPath", "()Laws/smithy/kotlin/runtime/net/url/UrlPath;", "Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "getParameters", "()Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "Laws/smithy/kotlin/runtime/net/url/UserInfo;", "getUserInfo", "()Laws/smithy/kotlin/runtime/net/url/UserInfo;", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "getFragment", "()Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "encoded", "Ljava/lang/String;", "hostAndPort", "getHostAndPort", "requestRelativePath", "getRequestRelativePath", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Url {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String encoded;
    private final Encodable fragment;
    private final Host host;
    private final String hostAndPort;
    private final QueryParameters parameters;
    private final UrlPath path;
    private final int port;
    private final String requestRelativePath;
    private final Scheme scheme;
    private final UserInfo userInfo;

    public /* synthetic */ Url(Scheme scheme, Host host, int i, UrlPath urlPath, QueryParameters queryParameters, UserInfo userInfo, Encodable encodable, DefaultConstructorMarker defaultConstructorMarker) {
        this(scheme, host, i, urlPath, queryParameters, userInfo, encodable);
    }

    private Url(Scheme scheme, Host host, int i, UrlPath urlPath, QueryParameters queryParameters, UserInfo userInfo, Encodable encodable) {
        this.scheme = scheme;
        this.host = host;
        this.port = i;
        this.path = urlPath;
        this.parameters = queryParameters;
        this.userInfo = userInfo;
        this.fragment = encodable;
        StringBuilder sb = new StringBuilder();
        sb.append(host);
        if (i != scheme.getDefaultPort()) {
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append(i);
        }
        this.hostAndPort = sb.toString();
        if (1 <= i && i < 65536) {
            Pair pairStringify = INSTANCE.stringify(scheme, host, i, urlPath, queryParameters, userInfo, encodable);
            this.encoded = (String) pairStringify.getFirst();
            this.requestRelativePath = (String) pairStringify.getSecond();
            return;
        }
        throw new IllegalArgumentException(("Given port " + i + " is not in required range [1, 65535]").toString());
    }

    public final Scheme getScheme() {
        return this.scheme;
    }

    public final Host getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public final UrlPath getPath() {
        return this.path;
    }

    public final QueryParameters getParameters() {
        return this.parameters;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final Encodable getFragment() {
        return this.fragment;
    }

    /* JADX INFO: compiled from: Url.kt */
    @Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\nø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011JU\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0 2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/Url$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/net/url/Url;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/net/url/Url;", "", "value", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "encoding", "parse", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/net/url/UrlEncoding;)Laws/smithy/kotlin/runtime/net/url/Url;", "Laws/smithy/kotlin/runtime/net/Scheme;", "scheme", "Laws/smithy/kotlin/runtime/net/Host;", DiagnosticsTracker.HOST_KEY, "", ClientCookie.PORT_ATTR, "Laws/smithy/kotlin/runtime/net/url/UrlPath;", ClientCookie.PATH_ATTR, "Laws/smithy/kotlin/runtime/net/url/QueryParameters;", "parameters", "Laws/smithy/kotlin/runtime/net/url/UserInfo;", "userInfo", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "fragment", "Lkotlin/Pair;", "stringify", "(Laws/smithy/kotlin/runtime/net/Scheme;Laws/smithy/kotlin/runtime/net/Host;ILaws/smithy/kotlin/runtime/net/url/UrlPath;Laws/smithy/kotlin/runtime/net/url/QueryParameters;Laws/smithy/kotlin/runtime/net/url/UserInfo;Laws/smithy/kotlin/runtime/text/encoding/Encodable;)Lkotlin/Pair;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Url invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }

        public static /* synthetic */ Url parse$default(Companion companion, String str, UrlEncoding urlEncoding, int i, Object obj) {
            if ((i & 2) != 0) {
                urlEncoding = UrlEncoding.INSTANCE.getAll();
            }
            return companion.parse(str, urlEncoding);
        }

        public final Url parse(String value, final UrlEncoding encoding) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            try {
                Companion companion = Url.INSTANCE;
                final Builder builder = new Builder();
                final Scanner scanner = new Scanner(value);
                scanner.requireAndSkip(new String[]{"://"}, new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Url.Companion.parse$lambda$0$0(builder, (String) obj);
                    }
                });
                scanner.upToOrEnd(new String[]{DomExceptionUtils.SEPARATOR, "?", Literals.COMMENT_1}, new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Url.Companion.parse$lambda$0$1(builder, (String) obj);
                    }
                });
                scanner.ifStartsWith(DomExceptionUtils.SEPARATOR, new Function0() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Url.Companion.parse$lambda$0$2(scanner, builder, encoding);
                    }
                });
                scanner.ifStartsWith("?", new Function0() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Url.Companion.parse$lambda$0$3(scanner, builder, encoding);
                    }
                });
                scanner.ifStartsWithSkip(Literals.COMMENT_1, new Function0() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Url.Companion.parse$lambda$0$4(scanner, builder, encoding);
                    }
                });
                return builder.build();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Cannot parse \"" + value + "\" as a URL", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$0(Builder builder, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            builder.setScheme(Scheme.INSTANCE.parse(it));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$1(final Builder builder, String authority) {
            Intrinsics.checkNotNullParameter(authority, "authority");
            Scanner scanner = new Scanner(authority);
            scanner.optionalAndSkip(new String[]{"@"}, new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Url.Companion.parse$lambda$0$1$0(builder, (String) obj);
                }
            });
            scanner.upToOrEnd(new String[0], new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Url.Companion.parse$lambda$0$1$1(builder, (String) obj);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$1$0(Builder builder, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            builder.getUserInfo().parseEncoded$runtime_core(it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$1$1(Builder builder, String hostport) {
            Intrinsics.checkNotNullParameter(hostport, "hostport");
            Pair hostPort = UrlKt.parseHostPort(hostport);
            Host host = (Host) hostPort.component1();
            Integer num = (Integer) hostPort.component2();
            builder.setHost(host);
            if (num != null) {
                builder.setPort(Integer.valueOf(num.intValue()));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$2(Scanner scanner, final Builder builder, final UrlEncoding urlEncoding) {
            scanner.upToOrEnd(new String[]{"?", Literals.COMMENT_1}, new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Url.Companion.parse$lambda$0$2$0(builder, urlEncoding, (String) obj);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$2$0(Builder builder, UrlEncoding urlEncoding, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            builder.getPath().parse$runtime_core(it, urlEncoding);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$3(Scanner scanner, final Builder builder, final UrlEncoding urlEncoding) {
            scanner.upToOrEnd(new String[]{Literals.COMMENT_1}, new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Url.Companion.parse$lambda$0$3$0(builder, urlEncoding, (String) obj);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$3$0(Builder builder, UrlEncoding urlEncoding, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            builder.getParameters().parse$runtime_core(it, urlEncoding);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$4(Scanner scanner, final Builder builder, final UrlEncoding urlEncoding) {
            scanner.upToOrEnd(new String[0], new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$Companion$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Url.Companion.parse$lambda$0$4$0(builder, urlEncoding, (String) obj);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit parse$lambda$0$4$0(Builder builder, UrlEncoding urlEncoding, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            builder.parseFragment$runtime_core(it, urlEncoding);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair<String, String> stringify(Scheme scheme, Host host, int port, UrlPath path, QueryParameters parameters, UserInfo userInfo, Encodable fragment) {
            StringBuilder sb = new StringBuilder();
            sb.append(scheme.getProtocolName());
            sb.append("://");
            sb.append(userInfo);
            sb.append(HostKt.toUrlString(host));
            if (port != scheme.getDefaultPort()) {
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(port);
            }
            int length = sb.length();
            sb.append(path);
            sb.append(parameters);
            if (fragment != null) {
                sb.append('#');
                sb.append(fragment.getEncoded());
            }
            String string = sb.toString();
            String strSubstring = string.substring(length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return TuplesKt.m1606to(string, TextKt.ensurePrefix(strSubstring, DomExceptionUtils.SEPARATOR));
        }
    }

    public final String getHostAndPort() {
        return this.hostAndPort;
    }

    public final String getRequestRelativePath() {
        return this.requestRelativePath;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Url copy$default(Url url, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: aws.smithy.kotlin.runtime.net.url.Url$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Url.copy$lambda$0((Url.Builder) obj2);
                }
            };
        }
        return url.copy(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copy$lambda$0(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return Unit.INSTANCE;
    }

    public final Url copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = toBuilder();
        block.invoke(builder);
        return builder.build();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Url url = (Url) other;
        return Intrinsics.areEqual(this.scheme, url.scheme) && Intrinsics.areEqual(this.host, url.host) && this.port == url.port && Intrinsics.areEqual(this.path, url.path) && Intrinsics.areEqual(this.parameters, url.parameters) && Intrinsics.areEqual(this.userInfo, url.userInfo) && Intrinsics.areEqual(this.fragment, url.fragment);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.scheme.hashCode() * 31) + this.host.hashCode()) * 31) + this.port) * 31) + this.path.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.userInfo.hashCode()) * 31;
        Encodable encodable = this.fragment;
        return iHashCode + (encodable != null ? encodable.hashCode() : 0);
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getEncoded() {
        return this.encoded;
    }

    /* JADX INFO: compiled from: Url.kt */
    @Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J,\u0010\f\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ,\u0010\u000f\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ,\u0010\u0011\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\rJ\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0005R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00105\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b3\u00104R$\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u00106\u001a\u0004\b7\u00108R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010<\u001a\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR(\u0010E\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00104\"\u0004\bC\u0010DR(\u0010H\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u00104\"\u0004\bG\u0010DR\u0011\u0010J\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bI\u00104\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006K"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "Laws/smithy/kotlin/runtime/util/CanDeepCopy;", "Laws/smithy/kotlin/runtime/net/url/Url;", ImagesContract.URL, "<init>", "(Laws/smithy/kotlin/runtime/net/url/Url;)V", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", ClientCookie.PATH_ATTR, "(Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;", "parameters", "Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;", "userInfo", "", "value", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "encoding", "parseFragment$runtime_core", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/net/url/UrlEncoding;)V", "parseFragment", "build", "()Laws/smithy/kotlin/runtime/net/url/Url;", "deepCopy", "()Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "copyFrom", "Laws/smithy/kotlin/runtime/net/Scheme;", "scheme", "Laws/smithy/kotlin/runtime/net/Scheme;", "getScheme", "()Laws/smithy/kotlin/runtime/net/Scheme;", "setScheme", "(Laws/smithy/kotlin/runtime/net/Scheme;)V", "Laws/smithy/kotlin/runtime/net/Host;", DiagnosticsTracker.HOST_KEY, "Laws/smithy/kotlin/runtime/net/Host;", "getHost", "()Laws/smithy/kotlin/runtime/net/Host;", "setHost", "(Laws/smithy/kotlin/runtime/net/Host;)V", "", ClientCookie.PORT_ATTR, "Ljava/lang/Integer;", "getPort", "()Ljava/lang/Integer;", "setPort", "(Ljava/lang/Integer;)V", "getHostAndPort", "()Ljava/lang/String;", "hostAndPort", "Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;", "getPath", "()Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;", "Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;", "getParameters", "()Laws/smithy/kotlin/runtime/net/url/QueryParameters$Builder;", "Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;", "getUserInfo", "()Laws/smithy/kotlin/runtime/net/url/UserInfo$Builder;", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "fragment", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "getDecodedFragment", "setDecodedFragment", "(Ljava/lang/String;)V", "decodedFragment", "getEncodedFragment", "setEncodedFragment", "encodedFragment", "getRequestRelativePath", "requestRelativePath", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder implements CanDeepCopy<Builder> {
        private Encodable fragment;
        private Host host;
        private final QueryParameters.Builder parameters;
        private UrlPath.Builder path;
        private Integer port;
        private Scheme scheme;
        private final UserInfo.Builder userInfo;

        public Builder(Url url) {
            UserInfo userInfo;
            UserInfo.Builder builder;
            QueryParameters parameters;
            QueryParameters.Builder builder2;
            UrlPath path;
            UrlPath.Builder builder3;
            Host.Domain host;
            Scheme scheme;
            this.scheme = (url == null || (scheme = url.getScheme()) == null) ? Scheme.INSTANCE.getHTTPS() : scheme;
            this.host = (url == null || (host = url.getHost()) == null) ? new Host.Domain("") : host;
            this.port = url != null ? Integer.valueOf(url.getPort()) : null;
            this.path = (url == null || (path = url.getPath()) == null || (builder3 = path.toBuilder()) == null) ? new UrlPath.Builder() : builder3;
            this.parameters = (url == null || (parameters = url.getParameters()) == null || (builder2 = parameters.toBuilder()) == null) ? new QueryParameters.Builder() : builder2;
            this.userInfo = (url == null || (userInfo = url.getUserInfo()) == null || (builder = userInfo.toBuilder()) == null) ? new UserInfo.Builder() : builder;
            this.fragment = url != null ? url.getFragment() : null;
        }

        public Builder() {
            this(null);
        }

        public final Scheme getScheme() {
            return this.scheme;
        }

        public final void setScheme(Scheme scheme) {
            Intrinsics.checkNotNullParameter(scheme, "<set-?>");
            this.scheme = scheme;
        }

        public final Host getHost() {
            return this.host;
        }

        public final void setHost(Host host) {
            Intrinsics.checkNotNullParameter(host, "<set-?>");
            this.host = host;
        }

        public final Integer getPort() {
            return this.port;
        }

        public final void setPort(Integer num) {
            this.port = num;
        }

        public final String getHostAndPort() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.host);
            Integer num = this.port;
            if (num != null) {
                int defaultPort = this.scheme.getDefaultPort();
                if (num == null || num.intValue() != defaultPort) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.port);
                }
            }
            return sb.toString();
        }

        public final UrlPath.Builder getPath() {
            return this.path;
        }

        public final void path(Function1<? super UrlPath.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(getPath());
        }

        public final QueryParameters.Builder getParameters() {
            return this.parameters;
        }

        public final void parameters(Function1<? super QueryParameters.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(getParameters());
        }

        public final UserInfo.Builder getUserInfo() {
            return this.userInfo;
        }

        public final void userInfo(Function1<? super UserInfo.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(getUserInfo());
        }

        public final void parseFragment$runtime_core(String value, UrlEncoding encoding) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            if (encoding.contains(UrlEncoding.Fragment.INSTANCE)) {
                setEncodedFragment(value);
            } else {
                setDecodedFragment(value);
            }
        }

        public final String getDecodedFragment() {
            Encodable encodable = this.fragment;
            if (encodable != null) {
                return encodable.getDecoded();
            }
            return null;
        }

        public final void setDecodedFragment(String str) {
            this.fragment = str != null ? PercentEncoding.INSTANCE.getFragment().encodableFromDecoded(str) : null;
        }

        public final String getEncodedFragment() {
            Encodable encodable = this.fragment;
            if (encodable != null) {
                return encodable.getEncoded();
            }
            return null;
        }

        public final void setEncodedFragment(String str) {
            this.fragment = str != null ? PercentEncoding.INSTANCE.getFragment().encodableFromEncoded(str) : null;
        }

        public final Url build() {
            Scheme scheme = this.scheme;
            Host host = this.host;
            Integer num = this.port;
            return new Url(scheme, host, num != null ? num.intValue() : scheme.getDefaultPort(), this.path.build(), this.parameters.build(), this.userInfo.build(), this.fragment, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
        public Builder deepCopy() {
            Builder builder = new Builder();
            builder.scheme = this.scheme;
            builder.host = this.host;
            builder.port = this.port;
            builder.path.copyFrom(this.path);
            builder.parameters.copyFrom(this.parameters);
            builder.userInfo.copyFrom(this.userInfo);
            builder.fragment = this.fragment;
            return builder;
        }

        public final void copyFrom(Url url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.scheme = url.getScheme();
            this.host = url.getHost();
            this.port = Integer.valueOf(url.getPort());
            this.path.copyFrom(url.getPath());
            this.parameters.copyFrom(url.getParameters());
            this.userInfo.copyFrom(url.getUserInfo());
            this.fragment = url.getFragment();
        }

        public final String getRequestRelativePath() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.path.getEncoded());
            sb.append(this.parameters.getEncoded());
            Encodable encodable = this.fragment;
            if (encodable != null) {
                sb.append('#');
                sb.append(encodable.getEncoded());
            }
            return TextKt.ensurePrefix(sb.toString(), DomExceptionUtils.SEPARATOR);
        }
    }
}
