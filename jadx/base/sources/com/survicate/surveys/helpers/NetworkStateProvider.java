package com.survicate.surveys.helpers;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkStateProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/helpers/NetworkStateProvider;", "", "isNetworkAvailable", "", "observeNetworkChanges", "Lcom/survicate/surveys/helpers/Observable;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface NetworkStateProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static NetworkStateProvider create(Context context) {
        return INSTANCE.create(context);
    }

    /* JADX INFO: renamed from: isNetworkAvailable */
    boolean getIsNetworkAvailable();

    Observable<Boolean> observeNetworkChanges();

    /* JADX INFO: compiled from: NetworkStateProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/helpers/NetworkStateProvider$Companion;", "", "<init>", "()V", "create", "Lcom/survicate/surveys/helpers/NetworkStateProvider;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final NetworkStateProvider create(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                return new NetworkStateProviderFromApi24(context);
            } catch (Exception unused) {
                return new NetworkStateProviderBelowApi24(context);
            }
        }
    }
}
