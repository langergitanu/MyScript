package aws.smithy.kotlin.runtime.http.config;

import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.http.config.HttpEngineConfig;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: HttpClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000bR6\u0010\n\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/config/HttpClientConfig;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "getInterceptors", "()Ljava/util/List;", "interceptors", "Builder", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpClientConfig extends HttpEngineConfig {

    /* JADX INFO: compiled from: HttpClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R>\u0010\f\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/config/HttpClientConfig$Builder;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig$Builder;", "", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "getInterceptors", "()Ljava/util/List;", "setInterceptors", "(Ljava/util/List;)V", "interceptors", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder extends HttpEngineConfig.Builder {
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> getInterceptors();

        void setInterceptors(List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list);
    }

    List<Interceptor<Object, Object, HttpRequest, HttpResponse>> getInterceptors();
}
