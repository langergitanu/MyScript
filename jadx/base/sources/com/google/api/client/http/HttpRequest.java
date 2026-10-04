package com.google.api.client.http;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StreamingContent;
import com.google.api.client.util.StringUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.opencensus.common.Scope;
import io.opencensus.contrib.http.util.HttpTraceAttributeConstants;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes6.dex */
public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX;
    public static final String VERSION;

    @Deprecated
    private BackOffPolicy backOffPolicy;
    private HttpContent content;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;
    private HttpIOExceptionHandler ioExceptionHandler;
    private ObjectParser objectParser;
    private String requestMethod;
    private HttpResponseInterceptor responseInterceptor;
    private boolean suppressUserAgentSuffix;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;
    private HttpHeaders headers = new HttpHeaders();
    private HttpHeaders responseHeaders = new HttpHeaders();
    private int numRetries = 10;
    private int contentLoggingLimit = 16384;
    private boolean loggingEnabled = true;
    private boolean curlLoggingEnabled = true;
    private int connectTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private int readTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private int writeTimeout = 0;
    private boolean followRedirects = true;
    private boolean useRawRedirectUrls = false;
    private boolean throwExceptionOnExecuteError = true;

    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;
    private final Tracer tracer = OpenCensusUtils.getTracer();
    private boolean responseReturnRawInputStream = false;

    static {
        String version = getVersion();
        VERSION = version;
        USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/" + version + " (gzip)";
    }

    HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    public HttpContent getContent() {
        return this.content;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpEncoding getEncoding() {
        return this.encoding;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.backOffPolicy;
    }

    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.backOffPolicy = backOffPolicy;
        return this;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public boolean isCurlLoggingEnabled() {
        return this.curlLoggingEnabled;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.curlLoggingEnabled = z;
        return this;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.connectTimeout = i;
        return this;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.readTimeout = i;
        return this;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public HttpRequest setWriteTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.writeTimeout = i;
        return this;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.executeInterceptor;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.unsuccessfulResponseHandler;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.ioExceptionHandler;
    }

    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.ioExceptionHandler = httpIOExceptionHandler;
        return this;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    public int getNumberOfRetries() {
        return this.numRetries;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.numRetries = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
        return this;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public boolean getUseRawRedirectUrls() {
        return this.useRawRedirectUrls;
    }

    public HttpRequest setUseRawRedirectUrls(boolean z) {
        this.useRawRedirectUrls = z;
        return this;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.throwExceptionOnExecuteError = z;
        return this;
    }

    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.retryOnExecuteIOException;
    }

    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.retryOnExecuteIOException = z;
        return this;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.suppressUserAgentSuffix;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.suppressUserAgentSuffix = z;
        return this;
    }

    public boolean getResponseReturnRawInputStream() {
        return this.responseReturnRawInputStream;
    }

    public HttpRequest setResponseReturnRawInputStream(boolean z) {
        this.responseReturnRawInputStream = z;
        return this;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:10|(1:12)|13|(1:15)|16|(1:21)(1:20)|(22:23|(2:25|(1:27))|30|(2:32|(1:34)(1:35))|36|(1:38)|39|(1:45)(1:44)|46|(7:48|(1:50)(1:51)|52|(1:54)(1:55)|(5:57|(2:59|(1:61))(1:62)|(2:64|(1:66))|67|(1:69))(1:70)|(1:72)|73)(1:74)|(2:76|(3:78|(1:80)|81))|(1:85)(1:84)|86|171|87|(1:89)|174|90|91|(3:172|113|(5:115|(1:117)(1:118)|(2:120|(1:(3:128|129|(3:177|131|122)))(1:122))|133|(1:135))(2:(1:142)(1:143)|144))(0)|145|(4:184|(1:148)(1:149)|150|(4:152|(1:154)|155|(1:165)(3:179|160|161))(1:166))(1:167))(1:28)|29|30|(0)|36|(0)|39|(2:41|45)(0)|46|(0)(0)|(0)|(1:85)(0)|86|171|87|(0)|174|90|91|(0)(0)|145|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02b7, code lost:
    
        if (r25.retryOnExecuteIOException == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02c4, code lost:
    
        r3.end(com.google.api.client.http.OpenCensusUtils.getEndSpanOptions(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02cb, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02cc, code lost:
    
        if (r20 != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02ce, code lost:
    
        r8.log(java.util.logging.Level.WARNING, "exception thrown while executing request", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02d5, code lost:
    
        r4.close();
        r4 = r16;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02b4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0376 A[LOOP:0: B:10:0x0035->B:167:0x0376, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0336 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0285 A[Catch: all -> 0x02b1, IOException -> 0x02b4, TRY_LEAVE, TryCatch #3 {IOException -> 0x02b4, blocks: (B:87:0x027f, B:89:0x0285, B:93:0x02a7, B:95:0x02ad, B:96:0x02b0), top: B:171:0x027f, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.google.api.client.http.HttpResponseInterceptor] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.api.client.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.google.api.client.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.api.client.http.HttpUnsuccessfulResponseHandler] */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.google.api.client.http.LowLevelHttpRequest] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponse execute() throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        HttpContent httpContent;
        Span span;
        int i;
        boolean z;
        boolean z2;
        Integer num;
        long j;
        StreamingContent streamingContent;
        Scope scopeWithSpan;
        ?? r4;
        boolean z3;
        BackOffPolicy backOffPolicy;
        LowLevelHttpResponse lowLevelHttpResponseExecute;
        StreamingContent loggingStreamingContent;
        StreamingContent httpEncodingStreamingContent;
        long length;
        ?? r5;
        Preconditions.checkArgument(this.numRetries >= 0);
        int i2 = this.numRetries;
        BackOffPolicy backOffPolicy2 = this.backOffPolicy;
        if (backOffPolicy2 != null) {
            backOffPolicy2.reset();
        }
        Preconditions.checkNotNull(this.requestMethod);
        Preconditions.checkNotNull(this.url);
        Span spanStartSpan = this.tracer.spanBuilder(OpenCensusUtils.SPAN_NAME_HTTP_REQUEST_EXECUTE).setRecordEvents(OpenCensusUtils.isRecordEvent()).startSpan();
        int i3 = i2;
        ?? r0 = 0;
        while (true) {
            spanStartSpan.addAnnotation("retry #" + (this.numRetries - i3));
            if (r0 != 0) {
                r0.ignore();
            }
            HttpExecuteInterceptor httpExecuteInterceptor = this.executeInterceptor;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(this);
            }
            String strBuild = this.url.build();
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_METHOD, this.requestMethod);
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_HOST, this.url.getHost());
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_PATH, this.url.getRawPath());
            addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_URL, strBuild);
            ?? BuildRequest = this.transport.buildRequest(this.requestMethod, strBuild);
            Logger logger = HttpTransport.LOGGER;
            boolean z4 = this.loggingEnabled && logger.isLoggable(Level.CONFIG);
            try {
                try {
                    if (z4) {
                        sb = new StringBuilder();
                        sb.append("-------------- REQUEST  --------------").append(StringUtils.LINE_SEPARATOR);
                        sb.append(this.requestMethod).append(TokenParser.f2383SP).append(strBuild).append(StringUtils.LINE_SEPARATOR);
                        if (this.curlLoggingEnabled) {
                            sb2 = new StringBuilder("curl -v --compressed");
                            if (!this.requestMethod.equals("GET")) {
                                sb2.append(" -X ").append(this.requestMethod);
                            }
                        }
                        String userAgent = this.headers.getUserAgent();
                        if (!this.suppressUserAgentSuffix) {
                            if (userAgent == null) {
                                HttpHeaders httpHeaders = this.headers;
                                String str = USER_AGENT_SUFFIX;
                                httpHeaders.setUserAgent(str);
                                addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str);
                            } else {
                                String str2 = userAgent + " " + USER_AGENT_SUFFIX;
                                this.headers.setUserAgent(str2);
                                addSpanAttribute(spanStartSpan, HttpTraceAttributeConstants.HTTP_USER_AGENT, str2);
                            }
                        }
                        OpenCensusUtils.propagateTracingContext(spanStartSpan, this.headers);
                        HttpHeaders.serializeHeaders(this.headers, sb, sb2, logger, BuildRequest);
                        if (!this.suppressUserAgentSuffix) {
                            this.headers.setUserAgent(userAgent);
                        }
                        httpContent = this.content;
                        boolean z5 = httpContent != null || httpContent.retrySupported();
                        if (httpContent == null) {
                            String type = this.content.getType();
                            if (z4) {
                                num = null;
                                j = -1;
                                i = i3;
                                loggingStreamingContent = new LoggingStreamingContent(httpContent, HttpTransport.LOGGER, Level.CONFIG, this.contentLoggingLimit);
                            } else {
                                i = i3;
                                num = null;
                                j = -1;
                                loggingStreamingContent = httpContent;
                            }
                            HttpEncoding httpEncoding = this.encoding;
                            if (httpEncoding == null) {
                                length = this.content.getLength();
                                r5 = num;
                                httpEncodingStreamingContent = loggingStreamingContent;
                            } else {
                                String name = httpEncoding.getName();
                                httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, this.encoding);
                                length = j;
                                r5 = name;
                            }
                            if (z4) {
                                if (type != null) {
                                    z = z4;
                                    z2 = z5;
                                    String str3 = "Content-Type: " + type;
                                    span = spanStartSpan;
                                    sb.append(str3).append(StringUtils.LINE_SEPARATOR);
                                    if (sb2 != null) {
                                        sb2.append(" -H '" + str3 + "'");
                                    }
                                } else {
                                    span = spanStartSpan;
                                    z = z4;
                                    z2 = z5;
                                }
                                if (r5 != 0) {
                                    String str4 = "Content-Encoding: " + r5;
                                    sb.append(str4).append(StringUtils.LINE_SEPARATOR);
                                    if (sb2 != null) {
                                        sb2.append(" -H '" + str4 + "'");
                                    }
                                }
                                if (length >= 0) {
                                    sb.append("Content-Length: " + length).append(StringUtils.LINE_SEPARATOR);
                                }
                            } else {
                                span = spanStartSpan;
                                z = z4;
                                z2 = z5;
                            }
                            if (sb2 != null) {
                                sb2.append(" -d '@-'");
                            }
                            BuildRequest.setContentType(type);
                            BuildRequest.setContentEncoding(r5);
                            BuildRequest.setContentLength(length);
                            BuildRequest.setStreamingContent(httpEncodingStreamingContent);
                            streamingContent = httpEncodingStreamingContent;
                        } else {
                            span = spanStartSpan;
                            i = i3;
                            z = z4;
                            z2 = z5;
                            num = null;
                            j = -1;
                            streamingContent = httpContent;
                        }
                        if (z) {
                            logger.config(sb.toString());
                            if (sb2 != null) {
                                sb2.append(" -- '");
                                sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                                sb2.append("'");
                                if (streamingContent != null) {
                                    sb2.append(" << $$$");
                                }
                                logger.config(sb2.toString());
                            }
                        }
                        boolean z6 = !z2 && i > 0;
                        BuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
                        BuildRequest.setWriteTimeout(this.writeTimeout);
                        Span span2 = span;
                        scopeWithSpan = this.tracer.withSpan(span2);
                        OpenCensusUtils.recordSentMessageEvent(span2, BuildRequest.getContentLength());
                        lowLevelHttpResponseExecute = BuildRequest.execute();
                        if (lowLevelHttpResponseExecute != null) {
                            OpenCensusUtils.recordReceivedMessageEvent(span2, lowLevelHttpResponseExecute.getContentLength());
                            span2.putAttribute(HttpTraceAttributeConstants.HTTP_STATUS_CODE, AttributeValue.longAttributeValue(lowLevelHttpResponseExecute.getStatusCode()));
                        }
                        HttpResponse httpResponse = new HttpResponse(this, lowLevelHttpResponseExecute);
                        scopeWithSpan.close();
                        r4 = httpResponse;
                        ?? r02 = num;
                        if (r4 == 0) {
                            try {
                                if (r4.isSuccessStatusCode()) {
                                    z3 = z6 & (r4 == 0);
                                } else {
                                    ?? r52 = this.unsuccessfulResponseHandler;
                                    boolean zHandleResponse = r52 != 0 ? r52.handleResponse(this, r4, z6) : false;
                                    if (!zHandleResponse) {
                                        if (handleRedirect(r4.getStatusCode(), r4.getHeaders())) {
                                            zHandleResponse = true;
                                        } else if (z6 && (backOffPolicy = this.backOffPolicy) != null && backOffPolicy.isBackOffRequired(r4.getStatusCode())) {
                                            long nextBackOffMillis = this.backOffPolicy.getNextBackOffMillis();
                                            if (nextBackOffMillis != j) {
                                                try {
                                                    this.sleeper.sleep(nextBackOffMillis);
                                                } catch (InterruptedException unused) {
                                                }
                                                zHandleResponse = true;
                                            }
                                        }
                                    }
                                    z3 = z6 & zHandleResponse;
                                    if (z3) {
                                        r4.ignore();
                                    }
                                }
                            } catch (Throwable th) {
                                if (r4 != 0) {
                                }
                                throw th;
                            }
                        }
                        i3 = i - 1;
                        if (z3) {
                            span2.end(OpenCensusUtils.getEndSpanOptions(r4 == 0 ? num : Integer.valueOf(r4.getStatusCode())));
                            if (r4 == 0) {
                                throw r02;
                            }
                            ?? r03 = this.responseInterceptor;
                            if (r03 != 0) {
                                r03.interceptResponse(r4);
                            }
                            if (!this.throwExceptionOnExecuteError || r4.isSuccessStatusCode()) {
                                return r4;
                            }
                            try {
                                throw new HttpResponseException.Builder(r4).setAttemptCount(this.numRetries - i3).build();
                            } finally {
                                r4.disconnect();
                            }
                        }
                        r0 = r4;
                        spanStartSpan = span2;
                    } else {
                        sb = null;
                    }
                    HttpResponse httpResponse2 = new HttpResponse(this, lowLevelHttpResponseExecute);
                    scopeWithSpan.close();
                    r4 = httpResponse2;
                    ?? r022 = num;
                    if (r4 == 0) {
                    }
                    i3 = i - 1;
                    if (z3) {
                    }
                } catch (Throwable th2) {
                    InputStream content = lowLevelHttpResponseExecute.getContent();
                    if (content != null) {
                        content.close();
                    }
                    throw th2;
                }
                lowLevelHttpResponseExecute = BuildRequest.execute();
                if (lowLevelHttpResponseExecute != null) {
                }
            } catch (Throwable th3) {
                scopeWithSpan.close();
                throw th3;
            }
            sb2 = null;
            String userAgent2 = this.headers.getUserAgent();
            if (!this.suppressUserAgentSuffix) {
            }
            OpenCensusUtils.propagateTracingContext(spanStartSpan, this.headers);
            HttpHeaders.serializeHeaders(this.headers, sb, sb2, logger, BuildRequest);
            if (!this.suppressUserAgentSuffix) {
            }
            httpContent = this.content;
            if (httpContent != null) {
            }
            if (httpContent == null) {
            }
            if (z) {
            }
            if (z2) {
            }
            BuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
            BuildRequest.setWriteTimeout(this.writeTimeout);
            Span span22 = span;
            scopeWithSpan = this.tracer.withSpan(span22);
            OpenCensusUtils.recordSentMessageEvent(span22, BuildRequest.getContentLength());
        }
    }

    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new Callable<HttpResponse>() { // from class: com.google.api.client.http.HttpRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public HttpResponse call() throws Exception {
                return HttpRequest.this.execute();
            }
        });
        executor.execute(futureTask);
        return futureTask;
    }

    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newFixedThreadPool(1, new ThreadFactoryBuilder().setDaemon(true).build()));
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location), this.useRawRedirectUrls));
        if (i == 303) {
            setRequestMethod("GET");
            setContent(null);
        }
        this.headers.setAuthorization((String) null);
        this.headers.setIfMatch(null);
        this.headers.setIfNoneMatch(null);
        this.headers.setIfModifiedSince(null);
        this.headers.setIfUnmodifiedSince(null);
        this.headers.setIfRange(null);
        return true;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public HttpRequest setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    private static void addSpanAttribute(Span span, String str, String str2) {
        if (str2 != null) {
            span.putAttribute(str, AttributeValue.stringAttributeValue(str2));
        }
    }

    private static String getVersion() {
        String property = "unknown-version";
        try {
            InputStream resourceAsStream = HttpRequest.class.getResourceAsStream("/com/google/api/client/http/google-http-client.properties");
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    property = properties.getProperty("google-http-client.version");
                } finally {
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        return property;
    }
}
