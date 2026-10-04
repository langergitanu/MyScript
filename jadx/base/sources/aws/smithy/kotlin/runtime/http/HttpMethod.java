package aws.smithy.kotlin.runtime.http;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "PATCH", "DELETE", "HEAD", "OPTIONS", "Companion", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HttpMethod[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final HttpMethod GET = new HttpMethod("GET", 0);
    public static final HttpMethod POST = new HttpMethod("POST", 1);
    public static final HttpMethod PUT = new HttpMethod("PUT", 2);
    public static final HttpMethod PATCH = new HttpMethod("PATCH", 3);
    public static final HttpMethod DELETE = new HttpMethod("DELETE", 4);
    public static final HttpMethod HEAD = new HttpMethod("HEAD", 5);
    public static final HttpMethod OPTIONS = new HttpMethod("OPTIONS", 6);

    private static final /* synthetic */ HttpMethod[] $values() {
        return new HttpMethod[]{GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS};
    }

    public static EnumEntries<HttpMethod> getEntries() {
        return $ENTRIES;
    }

    public static HttpMethod valueOf(String str) {
        return (HttpMethod) Enum.valueOf(HttpMethod.class, str);
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) $VALUES.clone();
    }

    private HttpMethod(String str, int i) {
    }

    static {
        HttpMethod[] httpMethodArr$values = $values();
        $VALUES = httpMethodArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(httpMethodArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: HttpMethod.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpMethod$Companion;", "", "<init>", "()V", "parse", "Laws/smithy/kotlin/runtime/http/HttpMethod;", FirebaseAnalytics.Param.METHOD, "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final HttpMethod parse(String method) {
            Intrinsics.checkNotNullParameter(method, "method");
            String upperCase = method.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        return HttpMethod.OPTIONS;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        return HttpMethod.GET;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        return HttpMethod.PUT;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        return HttpMethod.HEAD;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        return HttpMethod.POST;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        return HttpMethod.PATCH;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        return HttpMethod.DELETE;
                    }
                    break;
            }
            throw new IllegalArgumentException("unknown HTTP method: " + method);
        }
    }
}
