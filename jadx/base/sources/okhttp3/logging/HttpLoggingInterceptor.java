package okhttp3.logging;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.HTTPClient;
import com.survicate.surveys.TextRecallingManager;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p039io.CloseableKt;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.IsProbablyUtf8Kt;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.apache.http.message.TokenParser;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0003()*B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u001f\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0013\"\u00020\b¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\r\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\n\u0010\u000e¨\u0006+"}, m1599d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "queryParamsNameToRedact", FirebaseAnalytics.Param.LEVEL, "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "redactHeader", "", "name", "redactQueryParams", "", "([Ljava/lang/String;)V", "setLevel", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "redactUrl", ImagesContract.URL, "Lokhttp3/HttpUrl;", "redactUrl$logging_interceptor", "logHeader", "headers", "Lokhttp3/Headers;", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "", "bodyHasUnknownEncoding", "", "bodyIsStreaming", "response", "Level", "Logger", "Companion", "logging-interceptor"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;
    private volatile Set<String> queryParamsNameToRedact;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HttpLoggingInterceptor(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.headersToRedact = SetsKt.emptySet();
        this.queryParamsNameToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void level(Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "logging-interceptor"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
    public static final class Level {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level("NONE", 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }

        private Level(String str, int i) {
        }

        static {
            Level[] levelArr$values = $values();
            $VALUES = levelArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(levelArr$values);
        }
    }

    /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m1599d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "logging-interceptor"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
    public interface Logger {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        void log(String message);

        /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
        @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0007"}, m1599d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "<init>", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "logging-interceptor"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
            @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m1599d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "()V", "log", "", "message", "", "logging-interceptor"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
                }
            }
        }
    }

    public final void redactHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        TreeSet treeSet2 = treeSet;
        CollectionsKt.addAll(treeSet2, this.headersToRedact);
        treeSet2.add(name);
        this.headersToRedact = treeSet;
    }

    public final void redactQueryParams(String... name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        TreeSet treeSet2 = treeSet;
        CollectionsKt.addAll(treeSet2, this.queryParamsNameToRedact);
        CollectionsKt.addAll(treeSet2, name);
        this.queryParamsNameToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.level = level;
        return this;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.LEVEL, imports = {}))
    /* JADX INFO: renamed from: -deprecated_level, reason: not valid java name and from getter */
    public final Level getLevel() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0110 A[LOOP:0: B:42:0x010e->B:43:0x0110, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0280  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws Exception {
        boolean z;
        boolean z2;
        String str;
        String str2;
        Long l;
        GzipSource gzipSource;
        String str3;
        String str4;
        int size;
        int i;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z3 = level == Level.BODY;
        boolean z4 = z3 || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        String str5 = "--> " + request.method() + TokenParser.f2383SP + redactUrl$logging_interceptor(request.url()) + (connection != null ? " " + connection.getProtocol() : "");
        if (!z4 && requestBodyBody != null) {
            str5 = str5 + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.logger.log(str5);
        if (z4) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType contentType = requestBodyBody.getContentType();
                if (contentType == null || headers.get("Content-Type") != null) {
                    z = z4;
                    z2 = z3;
                } else {
                    z = z4;
                    z2 = z3;
                    this.logger.log("Content-Type: " + contentType);
                }
                if (requestBodyBody.contentLength() != -1 && headers.get("Content-Length") == null) {
                    str3 = "-byte body)";
                    str4 = " ";
                    this.logger.log("Content-Length: " + requestBodyBody.contentLength());
                }
                size = headers.size();
                for (i = 0; i < size; i++) {
                    logHeader(headers, i);
                }
                if (z2 || requestBodyBody == null) {
                    str = str4;
                    this.logger.log("--> END " + request.method());
                } else {
                    if (bodyHasUnknownEncoding(request.headers())) {
                        this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                    } else if (requestBodyBody.isDuplex()) {
                        this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                    } else if (requestBodyBody.isOneShot()) {
                        this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
                    } else {
                        Buffer buffer = new Buffer();
                        requestBodyBody.writeTo(buffer);
                        if (StringsKt.equals(HTTPClient.RC_FORMAT_ACCEPT_ENCODING, headers.get("Content-Encoding"), true)) {
                            lValueOf = Long.valueOf(buffer.size());
                            gzipSource = new GzipSource(buffer);
                            try {
                                Buffer buffer2 = new Buffer();
                                buffer2.writeAll(gzipSource);
                                CloseableKt.closeFinally(gzipSource, null);
                                buffer = buffer2;
                            } finally {
                            }
                        } else {
                            lValueOf = null;
                        }
                        Charset charsetCharsetOrUtf8 = Internal.charsetOrUtf8(requestBodyBody.getContentType());
                        this.logger.log("");
                        str = str4;
                        if (!IsProbablyUtf8Kt.isProbablyUtf8(buffer, 16L)) {
                            this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                        } else if (lValueOf != null) {
                            this.logger.log("--> END " + request.method() + " (" + buffer.size() + "-byte, " + lValueOf.longValue() + "-gzipped-byte body)");
                        } else {
                            this.logger.log(buffer.readString(charsetCharsetOrUtf8));
                            this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + str3);
                        }
                    }
                    str = str4;
                }
            } else {
                z = z4;
                z2 = z3;
            }
            str3 = "-byte body)";
            str4 = " ";
            size = headers.size();
            while (i < size) {
            }
            if (z2) {
                str = str4;
                this.logger.log("--> END " + request.method());
            }
        } else {
            z = z4;
            z2 = z3;
            str = " ";
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            Intrinsics.checkNotNull(responseBodyBody);
            long contentLength = responseBodyBody.getContentLength();
            String str6 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- " + responseProceed.code());
            if (responseProceed.message().length() > 0) {
                str2 = str;
                sb.append(str2 + responseProceed.message());
            } else {
                str2 = str;
            }
            sb.append(str2 + redactUrl$logging_interceptor(responseProceed.request().url()) + " (" + millis + "ms");
            if (!z) {
                sb.append(TextRecallingManager.ANSWER_SEPARATOR + str6 + " body");
            }
            sb.append(")");
            logger.log(sb.toString());
            if (z) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (!z2 || !HttpHeaders.promisesBody(responseProceed)) {
                    this.logger.log("<-- END HTTP");
                } else {
                    if (bodyHasUnknownEncoding(responseProceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                        return responseProceed;
                    }
                    if (bodyIsStreaming(responseProceed)) {
                        this.logger.log("<-- END HTTP (streaming)");
                        return responseProceed;
                    }
                    BufferedSource source = responseBodyBody.getSource();
                    source.request(Long.MAX_VALUE);
                    long millis2 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
                    Buffer buffer3 = source.getBuffer();
                    if (StringsKt.equals(HTTPClient.RC_FORMAT_ACCEPT_ENCODING, headers2.get("Content-Encoding"), true)) {
                        Long lValueOf2 = Long.valueOf(buffer3.size());
                        gzipSource = new GzipSource(buffer3.clone());
                        try {
                            Buffer buffer4 = new Buffer();
                            buffer4.writeAll(gzipSource);
                            CloseableKt.closeFinally(gzipSource, null);
                            l = lValueOf2;
                            buffer3 = buffer4;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } else {
                        l = null;
                    }
                    Charset charsetCharsetOrUtf82 = Internal.charsetOrUtf8(responseBodyBody.getMediaType());
                    if (!IsProbablyUtf8Kt.isProbablyUtf8(buffer3, 16L)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (" + millis2 + "ms, binary " + buffer3.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (contentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer3.clone().readString(charsetCharsetOrUtf82));
                    }
                    Logger logger2 = this.logger;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("<-- END HTTP (" + millis2 + "ms, " + buffer3.size() + "-byte");
                    if (l != null) {
                        sb2.append(TextRecallingManager.ANSWER_SEPARATOR + l.longValue() + "-gzipped-byte");
                    }
                    sb2.append(" body)");
                    logger2.log(sb2.toString());
                    return responseProceed;
                }
            }
            return responseProceed;
        } catch (Exception e) {
            long millis3 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            Logger logger3 = this.logger;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- HTTP FAILED: " + e + '.');
            sb3.append(str + redactUrl$logging_interceptor(request.url()) + " (" + millis3 + "ms)");
            logger3.log(sb3.toString());
            throw e;
        }
    }

    public final String redactUrl$logging_interceptor(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.queryParamsNameToRedact.isEmpty() || url.querySize() == 0) {
            return url.getUrl();
        }
        HttpUrl.Builder builderQuery = url.newBuilder().query(null);
        int iQuerySize = url.querySize();
        for (int i = 0; i < iQuerySize; i++) {
            String strQueryParameterName = url.queryParameterName(i);
            builderQuery.addEncodedQueryParameter(strQueryParameterName, this.queryParamsNameToRedact.contains(strQueryParameterName) ? "██" : url.queryParameterValue(i));
        }
        return builderQuery.toString();
    }

    private final void logHeader(Headers headers, int i) {
        this.logger.log(headers.name(i) + ": " + (this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i)));
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || StringsKt.equals(str, HTTP.IDENTITY_CODING, true) || StringsKt.equals(str, HTTPClient.RC_FORMAT_ACCEPT_ENCODING, true)) ? false : true;
    }

    private final boolean bodyIsStreaming(Response response) {
        MediaType mediaType = response.body().getMediaType();
        return mediaType != null && Intrinsics.areEqual(mediaType.type(), "text") && Intrinsics.areEqual(mediaType.subtype(), "event-stream");
    }
}
