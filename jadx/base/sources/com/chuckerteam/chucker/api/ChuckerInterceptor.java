package com.chuckerteam.chucker.api;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: ChuckerInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\t\u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/ChuckerInterceptor;", "Lokhttp3/Interceptor;", "builder", "Lcom/chuckerteam/chucker/api/ChuckerInterceptor$Builder;", "<init>", "(Lcom/chuckerteam/chucker/api/ChuckerInterceptor$Builder;)V", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "redactHeaders", "names", "", "", "([Ljava/lang/String;)Lcom/chuckerteam/chucker/api/ChuckerInterceptor;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Builder", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChuckerInterceptor implements Interceptor {
    public /* synthetic */ ChuckerInterceptor(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final ChuckerInterceptor redactHeaders(String... names) {
        Intrinsics.checkNotNullParameter(names, "names");
        return this;
    }

    private ChuckerInterceptor(Builder builder) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChuckerInterceptor(Context context) {
        this(new Builder(context));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request());
    }

    /* JADX INFO: compiled from: ChuckerInterceptor.kt */
    @Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001f\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u000f\"\u00020\u000e¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0001J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u001f\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u000f\"\u00020\u000e¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u001f\u0010\u001a\u001a\u00020\u00002\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u000f\"\u00020\u000e¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/ChuckerInterceptor$Builder;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "collector", "Lcom/chuckerteam/chucker/api/ChuckerCollector;", "maxContentLength", "length", "", "redactHeaders", "headerNames", "", "", "", "([Ljava/lang/String;)Lcom/chuckerteam/chucker/api/ChuckerInterceptor$Builder;", "alwaysReadResponseBody", "enable", "", "addBodyDecoder", "decoder", "createShortcut", "skipPaths", "paths", "Lkotlin/text/Regex;", "skipDomains", "domains", "build", "Lcom/chuckerteam/chucker/api/ChuckerInterceptor;", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private final Context context;

        public final Builder addBodyDecoder(Object decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            return this;
        }

        public final Builder alwaysReadResponseBody(boolean enable) {
            return this;
        }

        public final Builder collector(ChuckerCollector collector) {
            Intrinsics.checkNotNullParameter(collector, "collector");
            return this;
        }

        public final Builder createShortcut(boolean enable) {
            return this;
        }

        public final Builder maxContentLength(long length) {
            return this;
        }

        public final Builder redactHeaders(Iterable<String> headerNames) {
            Intrinsics.checkNotNullParameter(headerNames, "headerNames");
            return this;
        }

        public final Builder redactHeaders(String... headerNames) {
            Intrinsics.checkNotNullParameter(headerNames, "headerNames");
            return this;
        }

        public final Builder skipDomains(Regex domains) {
            Intrinsics.checkNotNullParameter(domains, "domains");
            return this;
        }

        public final Builder skipDomains(String... domains) {
            Intrinsics.checkNotNullParameter(domains, "domains");
            return this;
        }

        public final Builder skipPaths(Regex paths) {
            Intrinsics.checkNotNullParameter(paths, "paths");
            return this;
        }

        public final Builder skipPaths(String... paths) {
            Intrinsics.checkNotNullParameter(paths, "paths");
            return this;
        }

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        public final ChuckerInterceptor build() {
            return new ChuckerInterceptor(this, null);
        }
    }
}
