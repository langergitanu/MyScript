package com.revenuecat.purchases.paywalls;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallAssetWarming.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0014\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "warmerProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/paywalls/PaywallAssetWarmer;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "isAvailable", "", "()Z", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "warmer", "getWarmer", "()Lcom/revenuecat/purchases/paywalls/PaywallAssetWarmer;", "warmer$delegate", "clearWebViewStorage", "", "prebootWebView", "warmImages", "imageUris", "", "Landroid/net/Uri;", "warmWebViewUrls", "urls", "", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallAssetWarming {
    private static final Companion Companion = new Companion(null);
    private final Context context;

    /* JADX INFO: renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final Lazy mainHandler;

    /* JADX INFO: renamed from: warmer$delegate, reason: from kotlin metadata */
    private final Lazy warmer;

    public PaywallAssetWarming(Context context, final Function0<? extends PaywallAssetWarmer> warmerProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(warmerProvider, "warmerProvider");
        this.context = context;
        this.warmer = LazyKt.lazy(new Function0<PaywallAssetWarmer>() { // from class: com.revenuecat.purchases.paywalls.PaywallAssetWarming$warmer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaywallAssetWarmer invoke() {
                return warmerProvider.invoke();
            }
        });
        this.mainHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.revenuecat.purchases.paywalls.PaywallAssetWarming$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.PaywallAssetWarming$1 */
    /* JADX INFO: compiled from: PaywallAssetWarming.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class C73571 extends FunctionReferenceImpl implements Function0<PaywallAssetWarmer> {
        C73571(Object obj) {
            super(0, obj, Companion.class, "loadWarmer", "loadWarmer()Lcom/revenuecat/purchases/paywalls/PaywallAssetWarmer;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PaywallAssetWarmer invoke() {
            return ((Companion) this.receiver).loadWarmer();
        }
    }

    public /* synthetic */ PaywallAssetWarming(Context context, C73571 c73571, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new C73571(Companion) : c73571);
    }

    private final PaywallAssetWarmer getWarmer() {
        return (PaywallAssetWarmer) this.warmer.getValue();
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    public final boolean isAvailable() {
        return getWarmer() != null;
    }

    public final void warmImages(Collection<? extends Uri> imageUris) {
        PaywallAssetWarmer warmer;
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(imageUris, "imageUris");
        if (imageUris.isEmpty() || (warmer = getWarmer()) == null) {
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Pre-downloading " + imageUris.size() + " paywall image(s): " + imageUris);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            PaywallAssetWarming paywallAssetWarming = this;
            warmer.warmImages(this.context, CollectionsKt.toList(imageUris));
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Paywall image warming failed.", thM14502exceptionOrNullimpl);
        }
    }

    public final void prebootWebView() {
        Object objM14499constructorimpl;
        PaywallAssetWarmer warmer = getWarmer();
        if (warmer == null) {
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Prebooting the WebView engine for a paywall web_view component.");
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            PaywallAssetWarming paywallAssetWarming = this;
            warmer.prebootWebView(this.context);
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Paywalls V2 WebView preboot failed.", thM14502exceptionOrNullimpl);
        }
    }

    public final void warmWebViewUrls(final Collection<String> urls) {
        final PaywallAssetWarmer warmer;
        Intrinsics.checkNotNullParameter(urls, "urls");
        if (urls.isEmpty() || (warmer = getWarmer()) == null) {
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Warming " + urls.size() + " Paywalls V2 web_view bundle(s): " + urls);
        }
        prebootWebView();
        getMainHandler().post(new Runnable() { // from class: com.revenuecat.purchases.paywalls.PaywallAssetWarming$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PaywallAssetWarming.warmWebViewUrls$lambda$12(this.f$0, warmer, urls);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmWebViewUrls$lambda$12(PaywallAssetWarming paywallAssetWarming, PaywallAssetWarmer paywallAssetWarmer, Collection collection) {
        Object objM14499constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            paywallAssetWarmer.warmWebViewUrls(paywallAssetWarming.context, CollectionsKt.toList(collection));
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Paywalls V2 web_view warming failed.", thM14502exceptionOrNullimpl);
        }
    }

    public final void clearWebViewStorage() {
        getMainHandler().post(new Runnable() { // from class: com.revenuecat.purchases.paywalls.PaywallAssetWarming$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PaywallAssetWarming.clearWebViewStorage$lambda$17(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearWebViewStorage$lambda$17(PaywallAssetWarming paywallAssetWarming) {
        Object objM14499constructorimpl;
        PaywallAssetWarmer warmer = paywallAssetWarming.getWarmer();
        if (warmer == null) {
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Clearing Paywalls V2 web_view storage for the outgoing user.");
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            warmer.clearWebViewStorage(paywallAssetWarming.context);
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Paywalls V2 web_view storage could not be cleared.", thM14502exceptionOrNullimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PaywallAssetWarming.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming$Companion;", "", "()V", "loadWarmer", "Lcom/revenuecat/purchases/paywalls/PaywallAssetWarmer;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaywallAssetWarmer loadWarmer() {
            Object objM14499constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                ServiceLoader serviceLoaderLoad = ServiceLoader.load(PaywallAssetWarmer.class, PaywallAssetWarmer.class.getClassLoader());
                Intrinsics.checkNotNullExpressionValue(serviceLoaderLoad, "load(\n                  …Loader,\n                )");
                objM14499constructorimpl = Result.m14499constructorimpl((PaywallAssetWarmer) CollectionsKt.firstOrNull(serviceLoaderLoad));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl != null) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to load a PaywallAssetWarmer implementation.", thM14502exceptionOrNullimpl);
                objM14499constructorimpl = null;
            }
            PaywallAssetWarmer paywallAssetWarmer = (PaywallAssetWarmer) objM14499constructorimpl;
            if (paywallAssetWarmer == null) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "No PaywallAssetWarmer found, so paywall asset warming is off (no RevenueCatUI dependency, or META-INF/services stripped by packaging).");
                }
            }
            return paywallAssetWarmer;
        }
    }
}
