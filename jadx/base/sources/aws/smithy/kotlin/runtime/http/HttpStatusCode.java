package aws.smithy.kotlin.runtime.http;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: HttpStatusCode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\u0005H\u0096\u0080\u0004J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "", "value", "", "description", "", "<init>", "(ILjava/lang/String;)V", "getValue", "()I", "getDescription", "()Ljava/lang/String;", "toString", "equals", "", "other", "hashCode", "component1", "component2", "copy", "Category", "Companion", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class HttpStatusCode {
    private final String description;
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HttpStatusCode Continue = new HttpStatusCode(100, "Continue");
    private static final HttpStatusCode SwitchingProtocols = new HttpStatusCode(101, "Switching Protocols");
    private static final HttpStatusCode Processing = new HttpStatusCode(102, "Processing");

    /* JADX INFO: renamed from: OK */
    private static final HttpStatusCode f522OK = new HttpStatusCode(200, "OK");
    private static final HttpStatusCode Created = new HttpStatusCode(201, "Created");
    private static final HttpStatusCode Accepted = new HttpStatusCode(202, "Accepted");
    private static final HttpStatusCode NonAuthoritativeInformation = new HttpStatusCode(203, "Non-Authoritative Information");
    private static final HttpStatusCode NoContent = new HttpStatusCode(204, "No Content");
    private static final HttpStatusCode ResetContent = new HttpStatusCode(HttpStatus.SC_RESET_CONTENT, "Reset Content");
    private static final HttpStatusCode PartialContent = new HttpStatusCode(206, "Partial Content");
    private static final HttpStatusCode MultiStatus = new HttpStatusCode(207, "Multi-Status");
    private static final HttpStatusCode MultipleChoices = new HttpStatusCode(300, "Multiple Choices");
    private static final HttpStatusCode MovedPermanently = new HttpStatusCode(301, "Moved Permanently");
    private static final HttpStatusCode Found = new HttpStatusCode(302, "Found");
    private static final HttpStatusCode SeeOther = new HttpStatusCode(303, "See Other");
    private static final HttpStatusCode NotModified = new HttpStatusCode(304, "Not Modified");
    private static final HttpStatusCode UseProxy = new HttpStatusCode(305, "Use Proxy");
    private static final HttpStatusCode TemporaryRedirect = new HttpStatusCode(307, "Temporary Redirect");
    private static final HttpStatusCode PermanentRedirect = new HttpStatusCode(308, "Permanent Redirect");
    private static final HttpStatusCode BadRequest = new HttpStatusCode(400, "Bad Request");
    private static final HttpStatusCode Unauthorized = new HttpStatusCode(401, "Unauthorized");
    private static final HttpStatusCode PaymentRequired = new HttpStatusCode(402, "Payment Required");
    private static final HttpStatusCode Forbidden = new HttpStatusCode(403, "Forbidden");
    private static final HttpStatusCode NotFound = new HttpStatusCode(404, "Not Found");
    private static final HttpStatusCode MethodNotAllowed = new HttpStatusCode(405, "Method Not Allowed");
    private static final HttpStatusCode NotAcceptable = new HttpStatusCode(HttpStatus.SC_NOT_ACCEPTABLE, "Not Acceptable");
    private static final HttpStatusCode ProxyAuthenticationRequired = new HttpStatusCode(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required");
    private static final HttpStatusCode RequestTimeout = new HttpStatusCode(HttpStatus.SC_REQUEST_TIMEOUT, "Request Timeout");
    private static final HttpStatusCode Conflict = new HttpStatusCode(409, "Conflict");
    private static final HttpStatusCode Gone = new HttpStatusCode(HttpStatus.SC_GONE, "Gone");
    private static final HttpStatusCode LengthRequired = new HttpStatusCode(HttpStatus.SC_LENGTH_REQUIRED, "Length Required");
    private static final HttpStatusCode PreconditionFailed = new HttpStatusCode(412, "Precondition Failed");
    private static final HttpStatusCode PayloadTooLarge = new HttpStatusCode(HttpStatus.SC_REQUEST_TOO_LONG, "Payload Too Large");
    private static final HttpStatusCode RequestURITooLong = new HttpStatusCode(HttpStatus.SC_REQUEST_URI_TOO_LONG, "Request-URI Too Long");
    private static final HttpStatusCode UnsupportedMediaType = new HttpStatusCode(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
    private static final HttpStatusCode RequestedRangeNotSatisfiable = new HttpStatusCode(416, "Requested Range Not Satisfiable");
    private static final HttpStatusCode ExpectationFailed = new HttpStatusCode(HttpStatus.SC_EXPECTATION_FAILED, "Expectation Failed");
    private static final HttpStatusCode UnprocessableEntity = new HttpStatusCode(422, "Unprocessable Entity");
    private static final HttpStatusCode Locked = new HttpStatusCode(423, "Locked");
    private static final HttpStatusCode FailedDependency = new HttpStatusCode(424, "Failed Dependency");
    private static final HttpStatusCode TooEarly = new HttpStatusCode(TypedValues.CycleType.TYPE_WAVE_PHASE, "Too Early");
    private static final HttpStatusCode UpgradeRequired = new HttpStatusCode(426, "Upgrade Required");
    private static final HttpStatusCode PreconditionRequired = new HttpStatusCode(428, "Precondition Required");
    private static final HttpStatusCode TooManyRequests = new HttpStatusCode(429, "Too Many Requests");
    private static final HttpStatusCode RequestHeaderFieldTooLarge = new HttpStatusCode(431, "Request Header Fields Too Large");
    private static final HttpStatusCode UnavailableForLegalReason = new HttpStatusCode(451, "Unavailable For Legal Reason");
    private static final HttpStatusCode InternalServerError = new HttpStatusCode(500, "Internal Server Error");
    private static final HttpStatusCode NotImplemented = new HttpStatusCode(501, "Not Implemented");
    private static final HttpStatusCode BadGateway = new HttpStatusCode(502, "Bad Gateway");
    private static final HttpStatusCode ServiceUnavailable = new HttpStatusCode(503, "Service Unavailable");
    private static final HttpStatusCode GatewayTimeout = new HttpStatusCode(504, "Gateway Timeout");
    private static final HttpStatusCode VersionNotSupported = new HttpStatusCode(505, "HTTP Version Not Supported");
    private static final HttpStatusCode VariantAlsoNegotiates = new HttpStatusCode(TypedValues.PositionType.TYPE_PERCENT_X, "Variant Also Negotiates");
    private static final HttpStatusCode InsufficientStorage = new HttpStatusCode(507, "Insufficient Storage");
    private static final HttpStatusCode LoopDetected = new HttpStatusCode(TypedValues.PositionType.TYPE_CURVE_FIT, "Loop Detected");
    private static final HttpStatusCode NotExtended = new HttpStatusCode(TypedValues.PositionType.TYPE_POSITION_TYPE, "Not Extended");
    private static final HttpStatusCode NetworkAuthenticationRequired = new HttpStatusCode(FrameMetricsAggregator.EVERY_DURATION, "Network Authentication Required");
    private static final Map<Integer, HttpStatusCode> byValue = HttpStatusCodeKt.statusCodeMap();

    public static /* synthetic */ HttpStatusCode copy$default(HttpStatusCode httpStatusCode, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = httpStatusCode.value;
        }
        if ((i2 & 2) != 0) {
            str = httpStatusCode.description;
        }
        return httpStatusCode.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final HttpStatusCode copy(int value, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new HttpStatusCode(value, description);
    }

    public HttpStatusCode(int i, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.value = i;
        this.description = description;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getValue() {
        return this.value;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: HttpStatusCode.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00000\u0004:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0096\u0083\u0004J\n\u0010\u0011\u001a\u00020\u000fH\u0096\u0081\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u00020\u0003X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u00020\u0003X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpStatusCode$Category;", "", "Lkotlin/ranges/ClosedRange;", "", "", "range", "Lkotlin/ranges/IntRange;", "<init>", "(Ljava/lang/String;ILkotlin/ranges/IntRange;)V", "INFORMATION", "SUCCESS", "REDIRECT", "CLIENT_ERROR", "SERVER_ERROR", "contains", "", "value", "isEmpty", "endInclusive", "getEndInclusive", "()Ljava/lang/Integer;", TtmlNode.START, "getStart", "Companion", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Category implements Comparable<Category>, ClosedRange<Integer> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Category[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final IntRange range;
        public static final Category INFORMATION = new Category("INFORMATION", 0, new IntRange(100, 199));
        public static final Category SUCCESS = new Category("SUCCESS", 1, new IntRange(200, AIContainerViewModel.SUMMARIZE_MIN_LIMIT));
        public static final Category REDIRECT = new Category("REDIRECT", 2, new IntRange(300, 399));
        public static final Category CLIENT_ERROR = new Category("CLIENT_ERROR", 3, new IntRange(400, 499));
        public static final Category SERVER_ERROR = new Category("SERVER_ERROR", 4, new IntRange(500, 599));

        private static final /* synthetic */ Category[] $values() {
            return new Category[]{INFORMATION, SUCCESS, REDIRECT, CLIENT_ERROR, SERVER_ERROR};
        }

        public static EnumEntries<Category> getEntries() {
            return $ENTRIES;
        }

        public static Category valueOf(String str) {
            return (Category) Enum.valueOf(Category.class, str);
        }

        public static Category[] values() {
            return (Category[]) $VALUES.clone();
        }

        public boolean contains(int value) {
            return this.range.contains(value);
        }

        @Override // kotlin.ranges.ClosedRange
        public Integer getEndInclusive() {
            return this.range.getEndInclusive();
        }

        @Override // kotlin.ranges.ClosedRange
        public Integer getStart() {
            return this.range.getStart();
        }

        @Override // kotlin.ranges.ClosedRange
        public boolean isEmpty() {
            return this.range.isEmpty();
        }

        private Category(String str, int i, IntRange intRange) {
            this.range = intRange;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.ranges.ClosedRange
        public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
            return contains(((Number) comparable).intValue());
        }

        static {
            Category[] categoryArr$values = $values();
            $VALUES = categoryArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(categoryArr$values);
            INSTANCE = new Companion(null);
        }

        /* JADX INFO: compiled from: HttpStatusCode.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpStatusCode$Category$Companion;", "", "<init>", "()V", "fromCode", "Laws/smithy/kotlin/runtime/http/HttpStatusCode$Category;", "value", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Category fromCode(int value) {
                Category category;
                Category[] categoryArrValues = Category.values();
                int length = categoryArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        category = null;
                        break;
                    }
                    category = categoryArrValues[i];
                    IntRange intRange = category.range;
                    int first = intRange.getFirst();
                    if (value <= intRange.getLast() && first <= value) {
                        break;
                    }
                    i++;
                }
                if (category != null) {
                    return category;
                }
                throw new IllegalStateException(("Invalid HTTP code " + value).toString());
            }
        }
    }

    public String toString() {
        return this.value + ": " + this.description;
    }

    public boolean equals(Object other) {
        return (other instanceof HttpStatusCode) && ((HttpStatusCode) other).value == this.value;
    }

    public int hashCode() {
        return Integer.hashCode(this.value);
    }

    /* JADX INFO: compiled from: HttpStatusCode.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bs\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020zR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0011\u0010L\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0011\u0010\\\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0011\u0010^\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0007R\u0011\u0010`\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0007R\u0011\u0010b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0007R\u0011\u0010d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0007R\u0011\u0010f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0007R\u0011\u0010j\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0007R\u0011\u0010l\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0007R\u0011\u0010n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0007R\u0011\u0010p\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0007R\u0011\u0010r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0007R\u0011\u0010t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0007R\u0011\u0010v\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0007R\u001a\u0010x\u001a\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00050yX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpStatusCode$Companion;", "", "<init>", "()V", "Continue", "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "getContinue", "()Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "SwitchingProtocols", "getSwitchingProtocols", "Processing", "getProcessing", "OK", "getOK", "Created", "getCreated", "Accepted", "getAccepted", "NonAuthoritativeInformation", "getNonAuthoritativeInformation", "NoContent", "getNoContent", "ResetContent", "getResetContent", "PartialContent", "getPartialContent", "MultiStatus", "getMultiStatus", "MultipleChoices", "getMultipleChoices", "MovedPermanently", "getMovedPermanently", "Found", "getFound", "SeeOther", "getSeeOther", "NotModified", "getNotModified", "UseProxy", "getUseProxy", "TemporaryRedirect", "getTemporaryRedirect", "PermanentRedirect", "getPermanentRedirect", "BadRequest", "getBadRequest", "Unauthorized", "getUnauthorized", "PaymentRequired", "getPaymentRequired", "Forbidden", "getForbidden", "NotFound", "getNotFound", "MethodNotAllowed", "getMethodNotAllowed", "NotAcceptable", "getNotAcceptable", "ProxyAuthenticationRequired", "getProxyAuthenticationRequired", "RequestTimeout", "getRequestTimeout", "Conflict", "getConflict", "Gone", "getGone", "LengthRequired", "getLengthRequired", "PreconditionFailed", "getPreconditionFailed", "PayloadTooLarge", "getPayloadTooLarge", "RequestURITooLong", "getRequestURITooLong", "UnsupportedMediaType", "getUnsupportedMediaType", "RequestedRangeNotSatisfiable", "getRequestedRangeNotSatisfiable", "ExpectationFailed", "getExpectationFailed", "UnprocessableEntity", "getUnprocessableEntity", "Locked", "getLocked", "FailedDependency", "getFailedDependency", "TooEarly", "getTooEarly", "UpgradeRequired", "getUpgradeRequired", "PreconditionRequired", "getPreconditionRequired", "TooManyRequests", "getTooManyRequests", "RequestHeaderFieldTooLarge", "getRequestHeaderFieldTooLarge", "UnavailableForLegalReason", "getUnavailableForLegalReason", "InternalServerError", "getInternalServerError", "NotImplemented", "getNotImplemented", "BadGateway", "getBadGateway", "ServiceUnavailable", "getServiceUnavailable", "GatewayTimeout", "getGatewayTimeout", "VersionNotSupported", "getVersionNotSupported", "VariantAlsoNegotiates", "getVariantAlsoNegotiates", "InsufficientStorage", "getInsufficientStorage", "LoopDetected", "getLoopDetected", "NotExtended", "getNotExtended", "NetworkAuthenticationRequired", "getNetworkAuthenticationRequired", "byValue", "", "", "fromValue", NotificationCompat.CATEGORY_STATUS, "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpStatusCode getContinue() {
            return HttpStatusCode.Continue;
        }

        public final HttpStatusCode getSwitchingProtocols() {
            return HttpStatusCode.SwitchingProtocols;
        }

        public final HttpStatusCode getProcessing() {
            return HttpStatusCode.Processing;
        }

        public final HttpStatusCode getOK() {
            return HttpStatusCode.f522OK;
        }

        public final HttpStatusCode getCreated() {
            return HttpStatusCode.Created;
        }

        public final HttpStatusCode getAccepted() {
            return HttpStatusCode.Accepted;
        }

        public final HttpStatusCode getNonAuthoritativeInformation() {
            return HttpStatusCode.NonAuthoritativeInformation;
        }

        public final HttpStatusCode getNoContent() {
            return HttpStatusCode.NoContent;
        }

        public final HttpStatusCode getResetContent() {
            return HttpStatusCode.ResetContent;
        }

        public final HttpStatusCode getPartialContent() {
            return HttpStatusCode.PartialContent;
        }

        public final HttpStatusCode getMultiStatus() {
            return HttpStatusCode.MultiStatus;
        }

        public final HttpStatusCode getMultipleChoices() {
            return HttpStatusCode.MultipleChoices;
        }

        public final HttpStatusCode getMovedPermanently() {
            return HttpStatusCode.MovedPermanently;
        }

        public final HttpStatusCode getFound() {
            return HttpStatusCode.Found;
        }

        public final HttpStatusCode getSeeOther() {
            return HttpStatusCode.SeeOther;
        }

        public final HttpStatusCode getNotModified() {
            return HttpStatusCode.NotModified;
        }

        public final HttpStatusCode getUseProxy() {
            return HttpStatusCode.UseProxy;
        }

        public final HttpStatusCode getTemporaryRedirect() {
            return HttpStatusCode.TemporaryRedirect;
        }

        public final HttpStatusCode getPermanentRedirect() {
            return HttpStatusCode.PermanentRedirect;
        }

        public final HttpStatusCode getBadRequest() {
            return HttpStatusCode.BadRequest;
        }

        public final HttpStatusCode getUnauthorized() {
            return HttpStatusCode.Unauthorized;
        }

        public final HttpStatusCode getPaymentRequired() {
            return HttpStatusCode.PaymentRequired;
        }

        public final HttpStatusCode getForbidden() {
            return HttpStatusCode.Forbidden;
        }

        public final HttpStatusCode getNotFound() {
            return HttpStatusCode.NotFound;
        }

        public final HttpStatusCode getMethodNotAllowed() {
            return HttpStatusCode.MethodNotAllowed;
        }

        public final HttpStatusCode getNotAcceptable() {
            return HttpStatusCode.NotAcceptable;
        }

        public final HttpStatusCode getProxyAuthenticationRequired() {
            return HttpStatusCode.ProxyAuthenticationRequired;
        }

        public final HttpStatusCode getRequestTimeout() {
            return HttpStatusCode.RequestTimeout;
        }

        public final HttpStatusCode getConflict() {
            return HttpStatusCode.Conflict;
        }

        public final HttpStatusCode getGone() {
            return HttpStatusCode.Gone;
        }

        public final HttpStatusCode getLengthRequired() {
            return HttpStatusCode.LengthRequired;
        }

        public final HttpStatusCode getPreconditionFailed() {
            return HttpStatusCode.PreconditionFailed;
        }

        public final HttpStatusCode getPayloadTooLarge() {
            return HttpStatusCode.PayloadTooLarge;
        }

        public final HttpStatusCode getRequestURITooLong() {
            return HttpStatusCode.RequestURITooLong;
        }

        public final HttpStatusCode getUnsupportedMediaType() {
            return HttpStatusCode.UnsupportedMediaType;
        }

        public final HttpStatusCode getRequestedRangeNotSatisfiable() {
            return HttpStatusCode.RequestedRangeNotSatisfiable;
        }

        public final HttpStatusCode getExpectationFailed() {
            return HttpStatusCode.ExpectationFailed;
        }

        public final HttpStatusCode getUnprocessableEntity() {
            return HttpStatusCode.UnprocessableEntity;
        }

        public final HttpStatusCode getLocked() {
            return HttpStatusCode.Locked;
        }

        public final HttpStatusCode getFailedDependency() {
            return HttpStatusCode.FailedDependency;
        }

        public final HttpStatusCode getTooEarly() {
            return HttpStatusCode.TooEarly;
        }

        public final HttpStatusCode getUpgradeRequired() {
            return HttpStatusCode.UpgradeRequired;
        }

        public final HttpStatusCode getPreconditionRequired() {
            return HttpStatusCode.PreconditionRequired;
        }

        public final HttpStatusCode getTooManyRequests() {
            return HttpStatusCode.TooManyRequests;
        }

        public final HttpStatusCode getRequestHeaderFieldTooLarge() {
            return HttpStatusCode.RequestHeaderFieldTooLarge;
        }

        public final HttpStatusCode getUnavailableForLegalReason() {
            return HttpStatusCode.UnavailableForLegalReason;
        }

        public final HttpStatusCode getInternalServerError() {
            return HttpStatusCode.InternalServerError;
        }

        public final HttpStatusCode getNotImplemented() {
            return HttpStatusCode.NotImplemented;
        }

        public final HttpStatusCode getBadGateway() {
            return HttpStatusCode.BadGateway;
        }

        public final HttpStatusCode getServiceUnavailable() {
            return HttpStatusCode.ServiceUnavailable;
        }

        public final HttpStatusCode getGatewayTimeout() {
            return HttpStatusCode.GatewayTimeout;
        }

        public final HttpStatusCode getVersionNotSupported() {
            return HttpStatusCode.VersionNotSupported;
        }

        public final HttpStatusCode getVariantAlsoNegotiates() {
            return HttpStatusCode.VariantAlsoNegotiates;
        }

        public final HttpStatusCode getInsufficientStorage() {
            return HttpStatusCode.InsufficientStorage;
        }

        public final HttpStatusCode getLoopDetected() {
            return HttpStatusCode.LoopDetected;
        }

        public final HttpStatusCode getNotExtended() {
            return HttpStatusCode.NotExtended;
        }

        public final HttpStatusCode getNetworkAuthenticationRequired() {
            return HttpStatusCode.NetworkAuthenticationRequired;
        }

        public final HttpStatusCode fromValue(int status) {
            HttpStatusCode httpStatusCode = (HttpStatusCode) HttpStatusCode.byValue.get(Integer.valueOf(status));
            return httpStatusCode == null ? new HttpStatusCode(status, "Unknown HttpStatusCode") : httpStatusCode;
        }
    }
}
