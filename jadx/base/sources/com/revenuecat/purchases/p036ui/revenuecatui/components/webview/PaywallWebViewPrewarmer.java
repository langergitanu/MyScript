package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallWebViewPrewarmer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0015\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\nH\u0003J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\nH\u0007J\b\u0010$\u001a\u00020\"H\u0007J\b\u0010%\u001a\u00020\"H\u0007J\u0010\u0010&\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\nH\u0007J\u0018\u0010'\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0007J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\nH\u0003J\b\u0010)\u001a\u00020\"H\u0003J\u0010\u0010*\u001a\u00020\"2\u0006\u0010 \u001a\u00020\nH\u0003J\b\u0010+\u001a\u00020\"H\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00038AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00038AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013¨\u0006."}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer;", "", "maxConcurrentWarms", "", "(I)V", "applicationContext", "Landroid/content/Context;", "displayedComponents", "inFlight", "Ljava/util/LinkedHashMap;", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer$InFlightWarm;", "Lkotlin/collections/LinkedHashMap;", "mainHandler", "Landroid/os/Handler;", "queue", "Lkotlin/collections/ArrayDeque;", "queuedCount", "getQueuedCount$revenuecatui_defaultsRelease", "()I", "trimCallbacks", "com/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer$trimCallbacks$1", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer$trimCallbacks$1;", "warmedUrls", "", "warmingCount", "getWarmingCount$revenuecatui_defaultsRelease", "alreadyCovered", "", "resolvedUrl", "begin", WebViewMessageType.CONTEXT, ImagesContract.URL, "finishWarm", "", "markWarmed", "onCacheCleared", "onDisplayEnded", "onDisplayStarted", "prewarm", "release", "releaseInFlight", "settle", "startAvailable", "Companion", "InFlightWarm", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallWebViewPrewarmer {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int MAX_CONCURRENT_WARMS = 2;
    public static final long SETTLE_GRACE_MS = 250;
    public static final long WARM_STALL_TIMEOUT_MS = 3000;
    private static final PaywallWebViewPrewarmer shared;
    private Context applicationContext;
    private int displayedComponents;
    private final LinkedHashMap<String, InFlightWarm> inFlight;
    private final Handler mainHandler;
    private final int maxConcurrentWarms;
    private final ArrayDeque<String> queue;
    private final PaywallWebViewPrewarmer$trimCallbacks$1 trimCallbacks;
    private final Set<String> warmedUrls;

    public PaywallWebViewPrewarmer() {
        this(0, 1, null);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer$trimCallbacks$1] */
    public PaywallWebViewPrewarmer(int i) {
        this.maxConcurrentWarms = i;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.queue = new ArrayDeque<>();
        this.inFlight = new LinkedHashMap<>();
        this.warmedUrls = new LinkedHashSet();
        this.trimCallbacks = new ComponentCallbacks2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer$trimCallbacks$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            }

            @Override // android.content.ComponentCallbacks
            @Deprecated(message = "deprecated on interface but mandatory implementation")
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int level) {
                if (CollectionsKt.listOf((Object[]) new Integer[]{20, 5}).contains(Integer.valueOf(level))) {
                    return;
                }
                if (this.this$0.inFlight.isEmpty() && this.this$0.queue.isEmpty()) {
                    return;
                }
                Logger.INSTANCE.m1583d("Paywalls V2 web_view cache warming released on trim (level " + level + ").");
                ArrayDeque arrayDeque = this.this$0.queue;
                Set setKeySet = this.this$0.inFlight.keySet();
                Intrinsics.checkNotNullExpressionValue(setKeySet, "inFlight.keys");
                PaywallWebViewPrewarmer paywallWebViewPrewarmer = this.this$0;
                ArrayList arrayList = new ArrayList();
                for (Object obj : setKeySet) {
                    if (!paywallWebViewPrewarmer.warmedUrls.contains((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                arrayDeque.addAll(0, arrayList);
                this.this$0.releaseInFlight();
            }
        };
    }

    public static final /* synthetic */ void access$settle(PaywallWebViewPrewarmer paywallWebViewPrewarmer, String str) {
        paywallWebViewPrewarmer.settle(str);
    }

    public /* synthetic */ PaywallWebViewPrewarmer(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PaywallWebViewPrewarmer.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer$InFlightWarm;", "", "view", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;", "scheduledTeardown", "Ljava/lang/Runnable;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;Ljava/lang/Runnable;)V", "getScheduledTeardown", "()Ljava/lang/Runnable;", "setScheduledTeardown", "(Ljava/lang/Runnable;)V", "getView", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final class InFlightWarm {
        private Runnable scheduledTeardown;
        private final PaywallWebView view;

        public InFlightWarm(PaywallWebView view, Runnable scheduledTeardown) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheduledTeardown, "scheduledTeardown");
            this.view = view;
            this.scheduledTeardown = scheduledTeardown;
        }

        public final PaywallWebView getView() {
            return this.view;
        }

        public final Runnable getScheduledTeardown() {
            return this.scheduledTeardown;
        }

        public final void setScheduledTeardown(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "<set-?>");
            this.scheduledTeardown = runnable;
        }
    }

    public final void prewarm(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        String strResolve = WebViewUrlResolver.INSTANCE.resolve(url);
        if (strResolve == null) {
            Logger.INSTANCE.m1583d("Paywalls V2 web_view not prewarmed: URL must be https with no '{{' markers: '" + url + '\'');
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (this.applicationContext == null) {
            applicationContext.registerComponentCallbacks(this.trimCallbacks);
        }
        this.applicationContext = applicationContext;
        if (alreadyCovered(strResolve)) {
            Logger.INSTANCE.m1583d("Paywalls V2 web_view already warmed or warming this URL; skipping.");
        } else {
            this.queue.addLast(strResolve);
        }
        startAvailable();
    }

    public final void onDisplayStarted(String resolvedUrl) {
        Intrinsics.checkNotNullParameter(resolvedUrl, "resolvedUrl");
        this.queue.remove(resolvedUrl);
        int i = this.displayedComponents + 1;
        this.displayedComponents = i;
        if (i > 1) {
            return;
        }
        ArrayDeque<String> arrayDeque = this.queue;
        Set<String> setKeySet = this.inFlight.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "inFlight.keys");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String str = (String) obj;
            if (!this.warmedUrls.contains(str) && !Intrinsics.areEqual(str, resolvedUrl)) {
                arrayList.add(obj);
            }
        }
        arrayDeque.addAll(0, arrayList);
        this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.releaseInFlight();
            }
        });
    }

    public final void markWarmed(String resolvedUrl) {
        Intrinsics.checkNotNullParameter(resolvedUrl, "resolvedUrl");
        this.warmedUrls.add(resolvedUrl);
    }

    public final void onCacheCleared() {
        this.warmedUrls.clear();
        ArrayDeque<String> arrayDeque = this.queue;
        Set<String> setKeySet = this.inFlight.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "inFlight.keys");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!this.queue.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        arrayDeque.addAll(0, arrayList);
        releaseInFlight();
        this.mainHandler.post(new PaywallWebViewPrewarmer$$ExternalSyntheticLambda3(this));
    }

    public final void onDisplayEnded() {
        int i = this.displayedComponents;
        if (i == 0) {
            return;
        }
        int i2 = i - 1;
        this.displayedComponents = i2;
        if (i2 == 0) {
            this.mainHandler.post(new PaywallWebViewPrewarmer$$ExternalSyntheticLambda3(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseInFlight() {
        Set<String> setKeySet = this.inFlight.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "inFlight.keys");
        Iterator it = CollectionsKt.toList(setKeySet).iterator();
        while (it.hasNext()) {
            release((String) it.next());
        }
    }

    private final boolean alreadyCovered(String resolvedUrl) {
        return this.warmedUrls.contains(resolvedUrl) || this.inFlight.containsKey(resolvedUrl) || this.queue.contains(resolvedUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAvailable() {
        Context context;
        String strRemoveFirstOrNull;
        if (this.displayedComponents <= 0 && (context = this.applicationContext) != null) {
            CollectionsKt.removeAll((List) this.queue, (Function1) new Function1<String, Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer.startAvailable.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(PaywallWebViewPrewarmer.this.warmedUrls.contains(it));
                }
            });
            while (this.inFlight.size() < this.maxConcurrentWarms && (strRemoveFirstOrNull = this.queue.removeFirstOrNull()) != null && begin(context, strRemoveFirstOrNull)) {
            }
        }
    }

    private final boolean begin(Context context, final String url) {
        Runnable runnable = new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PaywallWebViewPrewarmer.begin$lambda$2(this.f$0, url);
            }
        };
        try {
            PaywallWebView paywallWebViewCreateWarmingWebView = WebViewComponentViewKt.createWarmingWebView(context, url, new PaywallWebViewPrewarmer$begin$view$1(this, url), new PaywallWebViewPrewarmer$begin$view$2(this, url));
            this.inFlight.put(url, new InFlightWarm(paywallWebViewCreateWarmingWebView, runnable));
            paywallWebViewCreateWarmingWebView.loadUrl(url);
            this.mainHandler.postDelayed(runnable, 3000L);
            Logger.INSTANCE.m1583d("Paywalls V2 web_view warming the http cache for '" + url + "'.");
            return true;
        } catch (Throwable th) {
            Logger.INSTANCE.m1587w("Paywalls V2 web_view could not be prewarmed: " + th);
            release(url);
            this.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.startAvailable();
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void begin$lambda$2(PaywallWebViewPrewarmer paywallWebViewPrewarmer, String str) {
        Logger.INSTANCE.m1583d("Paywalls V2 web_view cache warm stalled; moving on to the next URL.");
        paywallWebViewPrewarmer.finishWarm(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void settle(final String url) {
        InFlightWarm inFlightWarm = this.inFlight.get(url);
        if (inFlightWarm == null) {
            return;
        }
        this.warmedUrls.add(url);
        this.mainHandler.removeCallbacks(inFlightWarm.getScheduledTeardown());
        inFlightWarm.setScheduledTeardown(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finishWarm(url);
            }
        });
        this.mainHandler.postDelayed(inFlightWarm.getScheduledTeardown(), 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWarm(String url) {
        if (release(url)) {
            startAvailable();
        }
    }

    private final boolean release(String url) {
        InFlightWarm inFlightWarmRemove = this.inFlight.remove(url);
        if (inFlightWarmRemove == null) {
            return false;
        }
        this.mainHandler.removeCallbacks(inFlightWarmRemove.getScheduledTeardown());
        WebViewComponentViewKt.destroyPaywallWebView(inFlightWarmRemove.getView());
        return true;
    }

    public final int getQueuedCount$revenuecatui_defaultsRelease() {
        return this.queue.size();
    }

    public final int getWarmingCount$revenuecatui_defaultsRelease() {
        return this.inFlight.size();
    }

    /* JADX INFO: compiled from: PaywallWebViewPrewarmer.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u0016\u0010\t\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer$Companion;", "", "()V", "MAX_CONCURRENT_WARMS", "", "getMAX_CONCURRENT_WARMS$revenuecatui_defaultsRelease$annotations", "SETTLE_GRACE_MS", "", "getSETTLE_GRACE_MS$revenuecatui_defaultsRelease$annotations", "WARM_STALL_TIMEOUT_MS", "getWARM_STALL_TIMEOUT_MS$revenuecatui_defaultsRelease$annotations", "shared", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer;", "getShared", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewPrewarmer;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getMAX_CONCURRENT_WARMS$revenuecatui_defaultsRelease$annotations() {
        }

        public static /* synthetic */ void getSETTLE_GRACE_MS$revenuecatui_defaultsRelease$annotations() {
        }

        /* JADX INFO: renamed from: getWARM_STALL_TIMEOUT_MS$revenuecatui_defaultsRelease$annotations */
        public static /* synthetic */ void m1577x8d6f0781() {
        }

        private Companion() {
        }

        public final PaywallWebViewPrewarmer getShared() {
            return PaywallWebViewPrewarmer.shared;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        shared = new PaywallWebViewPrewarmer(0, 1, defaultConstructorMarker);
    }
}
