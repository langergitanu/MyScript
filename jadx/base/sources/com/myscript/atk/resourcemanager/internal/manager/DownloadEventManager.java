package com.myscript.atk.resourcemanager.internal.manager;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.internal.DownloadListener;
import com.myscript.nebo.LaunchActivity;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadEventManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u001c\u0010\r\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u001a\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m1599d2 = {"Lcom/myscript/atk/resourcemanager/internal/manager/DownloadEventManager;", "", "<init>", "()V", "downloadListeners", "", "Lcom/myscript/atk/resourcemanager/internal/DownloadListener;", "mainHandler", "Landroid/os/Handler;", "addDownloadListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeDownloadListener", "dispatchNotification", "notification", "Lkotlin/Function1;", "dispatchStart", LaunchActivity.LaunchRoute.Language, "Lcom/myscript/atk/resourcemanager/Language;", "dispatchCanceled", "dispatchEachFileSuccess", "downloadId", "", "dispatchSuccess", "dispatchProgress", "max", "", "progress", "dispatchError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "resourcemanager-lib_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DownloadEventManager {
    private final Set<DownloadListener> downloadListeners = new LinkedHashSet();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public final void addDownloadListener(DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            this.downloadListeners.add(listener);
        }
    }

    public final void removeDownloadListener(DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            this.downloadListeners.remove(listener);
        }
    }

    private final void dispatchNotification(final Function1<? super DownloadListener, Unit> notification) {
        final Set set;
        synchronized (this) {
            set = CollectionsKt.toSet(this.downloadListeners);
        }
        this.mainHandler.post(new Runnable() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadEventManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DownloadEventManager.dispatchNotification$lambda$1(set, notification);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchNotification$lambda$1(Set set, Function1 function1) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
    }

    public final void dispatchStart(final Language language) {
        Intrinsics.checkNotNullParameter(language, "language");
        dispatchNotification(new Function1() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadEventManager$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DownloadEventManager.dispatchStart$lambda$0(language, (DownloadListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchStart$lambda$0(Language language, DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.onDownloadStart(language);
        return Unit.INSTANCE;
    }

    public final void dispatchCanceled(final Language language) {
        Intrinsics.checkNotNullParameter(language, "language");
        dispatchNotification(new Function1() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadEventManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DownloadEventManager.dispatchCanceled$lambda$0(language, (DownloadListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchCanceled$lambda$0(Language language, DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.onDownloadCanceled(language);
        return Unit.INSTANCE;
    }

    public final void dispatchEachFileSuccess(final Language language, final long downloadId) {
        Intrinsics.checkNotNullParameter(language, "language");
        dispatchNotification(new Function1() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadEventManager$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DownloadEventManager.dispatchEachFileSuccess$lambda$0(language, downloadId, (DownloadListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchEachFileSuccess$lambda$0(Language language, long j, DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.onDownloadEachFileSuccess(language, j);
        return Unit.INSTANCE;
    }

    public final void dispatchSuccess(final Language language) {
        Intrinsics.checkNotNullParameter(language, "language");
        dispatchNotification(new Function1() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadEventManager$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DownloadEventManager.dispatchSuccess$lambda$0(language, (DownloadListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchSuccess$lambda$0(Language language, DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.onDownloadSuccess(language);
        return Unit.INSTANCE;
    }

    public final void dispatchProgress(final Language language, final int max, final int progress) {
        Intrinsics.checkNotNullParameter(language, "language");
        dispatchNotification(new Function1() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadEventManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DownloadEventManager.dispatchProgress$lambda$0(language, max, progress, (DownloadListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchProgress$lambda$0(Language language, int i, int i2, DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.onDownloadProgress(language, i, i2);
        return Unit.INSTANCE;
    }

    public final void dispatchError(final Language language, final Exception exception) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(exception, "exception");
        dispatchNotification(new Function1() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadEventManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DownloadEventManager.dispatchError$lambda$0(language, exception, (DownloadListener) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchError$lambda$0(Language language, Exception exc, DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listener.onDownloadError(language, exc);
        return Unit.INSTANCE;
    }
}
