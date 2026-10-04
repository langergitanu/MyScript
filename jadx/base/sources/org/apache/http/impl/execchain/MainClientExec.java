package org.apache.http.impl.execchain;

import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthState;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: classes7.dex */
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpProcessor httpProcessor, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(httpProcessor, "Proxy HTTP processor");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.proxyHttpProcessor = httpProcessor;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
    }

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this(httpRequestExecutor, httpClientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, new ImmutableHttpProcessor(new RequestTargetHost()), authenticationStrategy, authenticationStrategy2, userTokenHandler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:196:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x037d  */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Object, org.apache.http.HttpRequest, org.apache.http.client.methods.HttpRequestWrapper] */
    /* JADX WARN: Type inference failed for: r1v26, types: [org.apache.http.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.apache.http.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v4, types: [org.apache.http.impl.execchain.MainClientExec] */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.apache.http.client.methods.HttpExecutionAware] */
    /* JADX WARN: Type inference failed for: r4v16, types: [org.apache.http.protocol.HttpRequestExecutor] */
    /* JADX WARN: Type inference failed for: r4v17, types: [org.apache.http.ConnectionReuseStrategy] */
    /* JADX WARN: Type inference failed for: r4v19, types: [org.apache.http.conn.ConnectionKeepAliveStrategy] */
    /* JADX WARN: Type inference failed for: r4v45, types: [org.apache.http.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v49, types: [org.apache.http.impl.auth.HttpAuthenticator] */
    /* JADX WARN: Type inference failed for: r4v8, types: [org.apache.http.client.UserTokenHandler] */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.apache.http.HttpRequest] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r6v1, types: [org.apache.http.client.protocol.HttpClientContext, org.apache.http.protocol.HttpContext] */
    /* JADX WARN: Type inference failed for: r6v2, types: [org.apache.http.client.protocol.HttpClientContext, org.apache.http.protocol.HttpContext] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
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
    @Override // org.apache.http.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        MainClientExec mainClientExec;
        AuthState authState;
        AuthState authState2;
        HttpClientConnection httpClientConnection;
        ?? r14;
        Object obj;
        ?? r6;
        ?? r1;
        HttpResponse response;
        Object userToken;
        ?? r12;
        HttpClientConnection httpClientConnection2;
        AuthState authState3;
        HttpResponse httpResponse;
        String str;
        MainClientExec mainClientExec2 = this;
        HttpRoute httpRoute2 = httpRoute;
        Object obj2 = httpRequestWrapper;
        HttpClientContext httpClientContext2 = httpClientContext;
        Args.notNull(httpRoute2, "HTTP route");
        Args.notNull(obj2, "HTTP request");
        Args.notNull(httpClientContext2, "HTTP context");
        AuthState targetAuthState = httpClientContext2.getTargetAuthState();
        if (targetAuthState == null) {
            targetAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.target-scope", targetAuthState);
        }
        AuthState authState4 = targetAuthState;
        AuthState proxyAuthState = httpClientContext2.getProxyAuthState();
        if (proxyAuthState == null) {
            proxyAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.proxy-scope", proxyAuthState);
        }
        if (obj2 instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest) obj2);
        }
        Object userToken2 = httpClientContext2.getUserToken();
        ConnectionRequest connectionRequestRequestConnection = mainClientExec2.connManager.requestConnection(httpRoute2, userToken2);
        if (httpExecutionAware != 0) {
            if (httpExecutionAware.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext2.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            HttpClientConnection httpClientConnection3 = connectionRequestRequestConnection.get(connectionRequestTimeout > 0 ? connectionRequestTimeout : 0L, TimeUnit.MILLISECONDS);
            httpClientContext2.setAttribute("http.connection", httpClientConnection3);
            if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection3.isOpen()) {
                mainClientExec2.log.debug("Stale connection check");
                if (httpClientConnection3.isStale()) {
                    mainClientExec2.log.debug("Stale connection detected");
                    httpClientConnection3.close();
                }
            }
            ConnectionHolder connectionHolder = new ConnectionHolder(mainClientExec2.log, mainClientExec2.connManager, httpClientConnection3);
            if (httpExecutionAware != 0) {
                try {
                    try {
                        httpExecutionAware.setCancellable(connectionHolder);
                    } catch (IOException e) {
                        e = e;
                        authState = proxyAuthState;
                        authState2 = authState4;
                        connectionHolder.abortConnection();
                        if (authState.isConnectionBased()) {
                        }
                        if (authState2.isConnectionBased()) {
                        }
                        throw e;
                    } catch (RuntimeException e2) {
                        e = e2;
                        authState = proxyAuthState;
                        authState2 = authState4;
                        connectionHolder.abortConnection();
                        if (authState.isConnectionBased()) {
                        }
                        if (authState2.isConnectionBased()) {
                        }
                        throw e;
                    }
                } catch (Error e3) {
                    e = e3;
                    mainClientExec = mainClientExec2;
                    mainClientExec.connManager.shutdown();
                    throw e;
                } catch (HttpException e4) {
                    e = e4;
                    connectionHolder.abortConnection();
                    throw e;
                } catch (ConnectionShutdownException e5) {
                    e = e5;
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e);
                    throw interruptedIOException;
                }
            }
            int i = 1;
            int i2 = 1;
            MainClientExec mainClientExec3 = mainClientExec2;
            ?? r5 = obj2;
            ?? r62 = httpClientContext2;
            while (true) {
                if (i2 > i && !RequestEntityProxy.isRepeatable(r5)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (httpClientConnection3.isOpen()) {
                    HttpClientConnection httpClientConnection4 = httpClientConnection3;
                    authState = proxyAuthState;
                    httpClientConnection = httpClientConnection4;
                    r14 = r5;
                    r12 = mainClientExec3;
                } else {
                    try {
                        try {
                            AuthState authState5 = proxyAuthState;
                            try {
                                mainClientExec3.log.debug("Opening connection " + httpRoute2);
                                ?? r13 = this;
                                try {
                                    r13.establishRoute(authState5, httpClientConnection3, httpRoute2, r5, r62);
                                    HttpClientConnection httpClientConnection5 = httpClientConnection3;
                                    authState = authState5;
                                    httpClientConnection = httpClientConnection5;
                                    r14 = r5;
                                    r12 = r13;
                                } catch (TunnelRefusedException e6) {
                                    if (r13.log.isDebugEnabled()) {
                                        r13.log.debug(e6.getMessage());
                                    }
                                    response = e6.getResponse();
                                    obj = userToken2;
                                    r1 = r13;
                                    r6 = r62;
                                    if (obj == null) {
                                        userToken = r1.userTokenHandler.getUserToken(r6);
                                        r6.setAttribute("http.user-token", userToken);
                                    } else {
                                        userToken = obj;
                                    }
                                    if (userToken != null) {
                                        connectionHolder.setState(userToken);
                                    }
                                    HttpEntity entity = response.getEntity();
                                    if (entity != null && entity.isStreaming()) {
                                        return new HttpResponseProxy(response, connectionHolder);
                                    }
                                    connectionHolder.releaseConnection();
                                    return new HttpResponseProxy(response, null);
                                }
                            } catch (IOException e7) {
                                e = e7;
                                authState = authState5;
                                authState2 = authState4;
                                connectionHolder.abortConnection();
                                if (authState.isConnectionBased()) {
                                    authState.reset();
                                }
                                if (authState2.isConnectionBased()) {
                                    authState2.reset();
                                }
                                throw e;
                            } catch (RuntimeException e8) {
                                e = e8;
                                authState = authState5;
                                authState2 = authState4;
                                connectionHolder.abortConnection();
                                if (authState.isConnectionBased()) {
                                    authState.reset();
                                }
                                if (authState2.isConnectionBased()) {
                                    authState2.reset();
                                }
                                throw e;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            authState = proxyAuthState;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                            }
                            if (authState2.isConnectionBased()) {
                            }
                            throw e;
                        } catch (RuntimeException e10) {
                            e = e10;
                            authState = proxyAuthState;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                            }
                            if (authState2.isConnectionBased()) {
                            }
                            throw e;
                        }
                    } catch (Error e11) {
                        e = e11;
                        mainClientExec = this;
                        mainClientExec.connManager.shutdown();
                        throw e;
                    } catch (HttpException e12) {
                        e = e12;
                        connectionHolder.abortConnection();
                        throw e;
                    } catch (ConnectionShutdownException e13) {
                        e = e13;
                        InterruptedIOException interruptedIOException2 = new InterruptedIOException("Connection has been shut down");
                        interruptedIOException2.initCause(e);
                        throw interruptedIOException2;
                    }
                }
                try {
                    int socketTimeout = requestConfig.getSocketTimeout();
                    if (socketTimeout >= 0) {
                        httpClientConnection.setSocketTimeout(socketTimeout);
                    }
                    if (httpExecutionAware != 0 && httpExecutionAware.isAborted()) {
                        throw new RequestAbortedException("Request aborted");
                    }
                    if (r12.log.isDebugEnabled()) {
                        obj = userToken2;
                        r12.log.debug("Executing request " + r14.getRequestLine());
                    } else {
                        obj = userToken2;
                    }
                    if (!r14.containsHeader("Authorization")) {
                        if (r12.log.isDebugEnabled()) {
                            r12.log.debug("Target auth state: " + authState4.getState());
                        }
                        r12.authenticator.generateAuthResponse(r14, authState4, r62);
                    }
                    if (!r14.containsHeader("Proxy-Authorization") && !httpRoute.isTunnelled()) {
                        if (r12.log.isDebugEnabled()) {
                            r12.log.debug("Proxy auth state: " + authState.getState());
                        }
                        r12.authenticator.generateAuthResponse(r14, authState, r62);
                    }
                    r62.setAttribute("http.request", r14);
                    HttpResponse httpResponseExecute = r12.requestExecutor.execute(r14, httpClientConnection, r62);
                    if (r12.reuseStrategy.keepAlive(httpResponseExecute, r62)) {
                        try {
                            httpClientConnection2 = httpClientConnection;
                            authState3 = authState;
                            try {
                                long keepAliveDuration = r12.keepAliveStrategy.getKeepAliveDuration(httpResponseExecute, r62);
                                if (r12.log.isDebugEnabled()) {
                                    if (keepAliveDuration > 0) {
                                        try {
                                            httpResponse = httpResponseExecute;
                                            str = "for " + keepAliveDuration + " " + TimeUnit.MILLISECONDS;
                                        } catch (IOException e14) {
                                            e = e14;
                                            authState2 = authState4;
                                            authState = authState3;
                                            connectionHolder.abortConnection();
                                            if (authState.isConnectionBased()) {
                                            }
                                            if (authState2.isConnectionBased()) {
                                            }
                                            throw e;
                                        } catch (RuntimeException e15) {
                                            e = e15;
                                            authState2 = authState4;
                                            authState = authState3;
                                            connectionHolder.abortConnection();
                                            if (authState.isConnectionBased()) {
                                            }
                                            if (authState2.isConnectionBased()) {
                                            }
                                            throw e;
                                        }
                                    } else {
                                        httpResponse = httpResponseExecute;
                                        str = "indefinitely";
                                    }
                                    r12.log.debug("Connection can be kept alive " + str);
                                } else {
                                    httpResponse = httpResponseExecute;
                                }
                                connectionHolder.setValidFor(keepAliveDuration, TimeUnit.MILLISECONDS);
                                connectionHolder.markReusable();
                            } catch (IOException e16) {
                                e = e16;
                            } catch (RuntimeException e17) {
                                e = e17;
                            }
                        } catch (IOException e18) {
                            e = e18;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                            }
                            if (authState2.isConnectionBased()) {
                            }
                            throw e;
                        } catch (RuntimeException e19) {
                            e = e19;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                            }
                            if (authState2.isConnectionBased()) {
                            }
                            throw e;
                        }
                    } else {
                        httpClientConnection2 = httpClientConnection;
                        authState3 = authState;
                        httpResponse = httpResponseExecute;
                        connectionHolder.markNonReusable();
                    }
                    MainClientExec mainClientExec4 = this;
                    HttpClientContext httpClientContext3 = httpClientContext;
                    authState2 = authState4;
                    authState = authState3;
                    HttpResponse httpResponse2 = httpResponse;
                    try {
                        if (!mainClientExec4.needAuthentication(authState2, authState, httpRoute, httpResponse2, httpClientContext3)) {
                            response = httpResponse2;
                            r1 = mainClientExec4;
                            r6 = httpClientContext3;
                            break;
                        }
                        HttpEntity entity2 = httpResponse2.getEntity();
                        if (connectionHolder.isReusable()) {
                            EntityUtils.consume(entity2);
                        } else {
                            httpClientConnection2.close();
                            if (authState.getState() == AuthProtocolState.SUCCESS && authState.isConnectionBased()) {
                                mainClientExec4.log.debug("Resetting proxy auth state");
                                authState.reset();
                            }
                            if (authState2.getState() == AuthProtocolState.SUCCESS && authState2.isConnectionBased()) {
                                mainClientExec4.log.debug("Resetting target auth state");
                                authState2.reset();
                            }
                        }
                        HttpRequest original = r14.getOriginal();
                        if (!original.containsHeader("Authorization")) {
                            r14.removeHeaders("Authorization");
                        }
                        if (!original.containsHeader("Proxy-Authorization")) {
                            r14.removeHeaders("Proxy-Authorization");
                        }
                        i2++;
                        httpRoute2 = httpRoute;
                        authState4 = authState2;
                        proxyAuthState = authState;
                        httpClientConnection3 = httpClientConnection2;
                        r5 = r14;
                        userToken2 = obj;
                        i = 1;
                        mainClientExec3 = mainClientExec4;
                        r62 = httpClientContext3;
                    } catch (IOException e20) {
                        e = e20;
                        connectionHolder.abortConnection();
                        if (authState.isConnectionBased()) {
                        }
                        if (authState2.isConnectionBased()) {
                        }
                        throw e;
                    } catch (RuntimeException e21) {
                        e = e21;
                        connectionHolder.abortConnection();
                        if (authState.isConnectionBased()) {
                        }
                        if (authState2.isConnectionBased()) {
                        }
                        throw e;
                    }
                } catch (IOException e22) {
                    e = e22;
                } catch (RuntimeException e23) {
                    e = e23;
                }
            }
        } catch (InterruptedException e24) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e24);
        } catch (ExecutionException e25) {
            e = e25;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4 A[LOOP:0: B:3:0x000d->B:29:0x00c4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void establishRoute(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        HttpClientContext httpClientContext2;
        HttpRequest httpRequest2;
        HttpRoute httpRoute2;
        HttpClientConnection httpClientConnection2;
        AuthState authState2;
        int connectTimeout = httpClientContext.getRequestConfig().getConnectTimeout();
        RouteTracker routeTracker = new RouteTracker(httpRoute);
        while (true) {
            HttpRoute route = routeTracker.toRoute();
            int iNextStep = this.routeDirector.nextStep(httpRoute, route);
            switch (iNextStep) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + route);
                case 0:
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.connManager.routeComplete(httpClientConnection2, httpRoute2, httpClientContext2);
                    if (iNextStep > 0) {
                        return;
                    }
                    authState = authState2;
                    httpClientConnection = httpClientConnection2;
                    httpRoute = httpRoute2;
                    httpRequest = httpRequest2;
                    httpClientContext = httpClientContext2;
                    break;
                case 1:
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.connManager.connect(httpClientConnection2, httpRoute2, connectTimeout > 0 ? connectTimeout : 0, httpClientContext2);
                    routeTracker.connectTarget(httpRoute2.isSecure());
                    if (iNextStep > 0) {
                    }
                    break;
                case 2:
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.connManager.connect(httpClientConnection2, httpRoute2, connectTimeout > 0 ? connectTimeout : 0, httpClientContext2);
                    routeTracker.connectProxy(httpRoute2.getProxyHost(), httpRoute2.isSecure() && !httpRoute2.isTunnelled());
                    if (iNextStep > 0) {
                    }
                    break;
                case 3:
                    boolean zCreateTunnelToTarget = createTunnelToTarget(authState, httpClientConnection, httpRoute, httpRequest, httpClientContext);
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    this.log.debug("Tunnel to target created.");
                    routeTracker.tunnelTarget(zCreateTunnelToTarget);
                    if (iNextStep > 0) {
                    }
                    break;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean zCreateTunnelToProxy = createTunnelToProxy(httpRoute, hopCount, httpClientContext);
                    this.log.debug("Tunnel to proxy created.");
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(hopCount), zCreateTunnelToProxy);
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    if (iNextStep > 0) {
                    }
                    break;
                case 5:
                    this.connManager.upgrade(httpClientConnection, httpRoute, httpClientContext);
                    routeTracker.layerProtocol(httpRoute.isSecure());
                    httpClientContext2 = httpClientContext;
                    httpRequest2 = httpRequest;
                    httpRoute2 = httpRoute;
                    httpClientConnection2 = httpClientConnection;
                    authState2 = authState;
                    if (iNextStep > 0) {
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown step indicator " + iNextStep + " from RouteDirector.");
            }
        }
    }

    private boolean createTunnelToTarget(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        AuthState authState2;
        HttpClientContext httpClientContext2;
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int connectTimeout = requestConfig.getConnectTimeout();
        HttpHost targetHost = httpRoute.getTargetHost();
        HttpHost proxyHost = httpRoute.getProxyHost();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest(HttpMethods.CONNECT, targetHost.toHostString(), httpRequest.getProtocolVersion());
        this.requestExecutor.preProcess(basicHttpRequest, this.proxyHttpProcessor, httpClientContext);
        HttpResponse httpResponse = null;
        while (true) {
            if (httpResponse == null) {
                if (!httpClientConnection.isOpen()) {
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                }
                basicHttpRequest.removeHeaders("Proxy-Authorization");
                this.authenticator.generateAuthResponse(basicHttpRequest, authState, httpClientContext);
                HttpResponse httpResponseExecute = this.requestExecutor.execute(basicHttpRequest, httpClientConnection, httpClientContext);
                this.requestExecutor.postProcess(httpResponseExecute, this.proxyHttpProcessor, httpClientContext);
                if (httpResponseExecute.getStatusLine().getStatusCode() < 200) {
                    throw new HttpException("Unexpected response to CONNECT request: " + httpResponseExecute.getStatusLine());
                }
                if (requestConfig.isAuthenticationEnabled()) {
                    authState2 = authState;
                    httpClientContext2 = httpClientContext;
                    if (this.authenticator.isAuthenticationRequested(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2) && this.authenticator.handleAuthChallenge(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2)) {
                        if (this.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
                            this.log.debug("Connection kept alive");
                            EntityUtils.consume(httpResponseExecute.getEntity());
                        } else {
                            httpClientConnection.close();
                        }
                        httpResponse = null;
                    }
                    authState = authState2;
                    httpClientContext = httpClientContext2;
                } else {
                    authState2 = authState;
                    httpClientContext2 = httpClientContext;
                }
                httpResponse = httpResponseExecute;
                authState = authState2;
                httpClientContext = httpClientContext2;
            } else {
                if (httpResponse.getStatusLine().getStatusCode() <= 299) {
                    return false;
                }
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    httpResponse.setEntity(new BufferedHttpEntity(entity));
                }
                httpClientConnection.close();
                throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
            }
        }
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean needAuthentication(AuthState authState, AuthState authState2, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        if (!httpClientContext.getRequestConfig().isAuthenticationEnabled()) {
            return false;
        }
        HttpHost targetHost = httpClientContext.getTargetHost();
        if (targetHost == null) {
            targetHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost = targetHost.getPort() < 0 ? new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName()) : targetHost;
        boolean zIsAuthenticationRequested = this.authenticator.isAuthenticationRequested(httpHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        HttpHost httpHost2 = httpHost;
        HttpHost proxyHost = httpRoute.getProxyHost();
        if (proxyHost == null) {
            proxyHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost3 = proxyHost;
        boolean zIsAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        if (zIsAuthenticationRequested) {
            return this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        }
        if (zIsAuthenticationRequested2) {
            return this.authenticator.handleAuthChallenge(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        }
        return false;
    }
}
