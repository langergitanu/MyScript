package com.myscript.nebo.migration;

import android.content.Context;
import android.util.Log;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.google.android.gms.actions.SearchIntents;
import com.myscript.nebo.migration.ReferrerResult;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: PlayInstallReferrerSource.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/migration/PlayInstallReferrerSource;", "Lcom/myscript/nebo/migration/InstallReferrerSource;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", SearchIntents.EXTRA_QUERY, "Lcom/myscript/nebo/migration/ReferrerResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PlayInstallReferrerSource implements InstallReferrerSource {
    private static final String TAG = "PlayInstallReferrer";
    private final Context context;
    public static final int $stable = 8;

    public PlayInstallReferrerSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.myscript.nebo.migration.InstallReferrerSource
    public Object query(Continuation<? super ReferrerResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.context).build();
        installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: com.myscript.nebo.migration.PlayInstallReferrerSource$query$2$1
            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(int responseCode) {
                Object objM14499constructorimpl;
                ReferrerResult.Resolved resolved;
                if (responseCode == 0) {
                    InstallReferrerClient installReferrerClient = installReferrerClientBuild;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        PlayInstallReferrerSource$query$2$1 playInstallReferrerSource$query$2$1 = this;
                        objM14499constructorimpl = Result.m14499constructorimpl(installReferrerClient.getInstallReferrer().getInstallReferrer());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                    }
                    resolved = new ReferrerResult.Resolved((String) (Result.m14505isFailureimpl(objM14499constructorimpl) ? null : objM14499constructorimpl));
                } else if (responseCode == 2) {
                    resolved = new ReferrerResult.Resolved(null);
                } else {
                    Log.d("PlayInstallReferrer", "Install Referrer response: " + responseCode);
                    resolved = ReferrerResult.Transient.INSTANCE;
                }
                InstallReferrerClient installReferrerClient2 = installReferrerClientBuild;
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    PlayInstallReferrerSource$query$2$1 playInstallReferrerSource$query$2$12 = this;
                    installReferrerClient2.endConnection();
                    Result.m14499constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.m14499constructorimpl(ResultKt.createFailure(th2));
                }
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<ReferrerResult> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion5 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(resolved));
                }
            }

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<ReferrerResult> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m14499constructorimpl(ReferrerResult.Transient.INSTANCE));
                }
            }
        });
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.myscript.nebo.migration.PlayInstallReferrerSource$query$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                InstallReferrerClient installReferrerClient = installReferrerClientBuild;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    installReferrerClient.endConnection();
                    Result.m14499constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m14499constructorimpl(ResultKt.createFailure(th2));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
