package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.content.Context;
import androidx.webkit.Profile;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.WebViewOutcomeReceiver;
import androidx.webkit.WebViewStartUpConfig;
import androidx.webkit.WebViewStartUpResult;
import androidx.webkit.WebViewStartupException;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: PaywallWebViewStartUp.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\r\u0010\u000f\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewStartUp;", "", "()V", "startUpExecutor", "Ljava/util/concurrent/Executor;", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "guarded", "delegate", "guarded$revenuecatui_defaultsRelease", "requestStartUp", "", "applicationContext", "Landroid/content/Context;", "executor", "resetForTesting", "resetForTesting$revenuecatui_defaultsRelease", "startUp", WebViewMessageType.CONTEXT, "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallWebViewStartUp {
    public static final int $stable;
    public static final PaywallWebViewStartUp INSTANCE;
    private static final Executor startUpExecutor;
    private static final AtomicBoolean started;

    private PaywallWebViewStartUp() {
    }

    static {
        PaywallWebViewStartUp paywallWebViewStartUp = new PaywallWebViewStartUp();
        INSTANCE = paywallWebViewStartUp;
        started = new AtomicBoolean(false);
        startUpExecutor = paywallWebViewStartUp.guarded$revenuecatui_defaultsRelease(ExecutorsKt.asExecutor(Dispatchers.getIO()));
        $stable = 8;
    }

    public final Executor guarded$revenuecatui_defaultsRelease(final Executor delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new Executor() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewStartUp$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                PaywallWebViewStartUp.guarded$lambda$1(delegate, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guarded$lambda$1(Executor executor, final Runnable runnable) {
        executor.execute(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewStartUp$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PaywallWebViewStartUp.guarded$lambda$1$lambda$0(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guarded$lambda$1$lambda$0(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            Logger.INSTANCE.m1587w("Paywalls V2 WebView startup failed: " + th);
        }
    }

    public static /* synthetic */ void startUp$default(PaywallWebViewStartUp paywallWebViewStartUp, Context context, Executor executor, int i, Object obj) {
        if ((i & 2) != 0) {
            executor = startUpExecutor;
        }
        paywallWebViewStartUp.startUp(context, executor);
    }

    public final void startUp(Context context, final Executor executor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "executor");
        if (started.compareAndSet(false, true)) {
            final Context applicationContext = context.getApplicationContext();
            try {
                executor.execute(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewStartUp$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        PaywallWebViewStartUp.startUp$lambda$2(applicationContext, executor);
                    }
                });
            } catch (RejectedExecutionException e) {
                started.set(false);
                Logger.INSTANCE.m1587w("Paywalls V2 WebView startup could not be triggered: " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startUp$lambda$2(Context applicationContext, Executor executor) {
        PaywallWebViewStartUp paywallWebViewStartUp = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        paywallWebViewStartUp.requestStartUp(applicationContext, executor);
    }

    private final void requestStartUp(Context applicationContext, Executor executor) {
        String str;
        if (WebViewFeature.isFeatureSupported("MULTI_PROFILE")) {
            str = WebViewComponentViewKt.PAYWALL_PROFILE_NAME;
        } else {
            str = Profile.DEFAULT_PROFILE_NAME;
        }
        try {
            WebViewCompat.startUpWebView(applicationContext, new WebViewStartUpConfig.Builder(executor).setProfilesToLoadDuringStartup(SetsKt.setOf(str)).build(), new WebViewOutcomeReceiver<WebViewStartUpResult, WebViewStartupException>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewStartUp.requestStartUp.1
                /* JADX WARN: Removed duplicated region for block: B:6:0x0026  */
                @Override // androidx.webkit.WebViewOutcomeReceiver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResult(WebViewStartUpResult result) {
                    String str2;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Long totalTimeInUiThreadMillis = result.getTotalTimeInUiThreadMillis();
                    if (totalTimeInUiThreadMillis != null) {
                        str2 = totalTimeInUiThreadMillis.longValue() + " ms";
                        if (str2 == null) {
                            str2 = "not reported";
                        }
                    }
                    Logger.INSTANCE.m1583d("Paywalls V2 WebView startup complete (UI thread time: " + str2 + ").");
                }

                @Override // androidx.webkit.WebViewOutcomeReceiver
                public void onError(WebViewStartupException error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    Logger.INSTANCE.m1587w("Paywalls V2 WebView startup failed: " + error);
                }
            });
        } catch (RejectedExecutionException e) {
            started.set(false);
            Logger.INSTANCE.m1587w("Paywalls V2 WebView startup could not be triggered: " + e);
        }
    }

    public final void resetForTesting$revenuecatui_defaultsRelease() {
        started.set(false);
    }
}
