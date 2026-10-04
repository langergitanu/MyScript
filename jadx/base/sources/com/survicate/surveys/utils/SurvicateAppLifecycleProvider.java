package com.survicate.surveys.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.survicate.surveys.helpers.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppLifecycleProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/utils/SurvicateAppLifecycleProvider;", "Lcom/survicate/surveys/utils/AppLifecycleProvider;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "currentState", "Lcom/survicate/surveys/utils/AppLifecycleState;", "getCurrentState", "()Lcom/survicate/surveys/utils/AppLifecycleState;", "lifecycleObservable", "Lcom/survicate/surveys/helpers/Observable;", "registerObserver", "", "observeLifecycleChanges", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateAppLifecycleProvider implements AppLifecycleProvider, DefaultLifecycleObserver {
    private final Observable<AppLifecycleState> lifecycleObservable = new Observable<>();

    public SurvicateAppLifecycleProvider() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            registerObserver();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.survicate.surveys.utils.SurvicateAppLifecycleProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.registerObserver();
                }
            });
        }
    }

    @Override // com.survicate.surveys.utils.AppLifecycleProvider
    public AppLifecycleState getCurrentState() {
        if (ProcessLifecycleOwner.INSTANCE.get().getLifecycleRegistry().getState().isAtLeast(Lifecycle.State.STARTED)) {
            return AppLifecycleState.FOREGROUND;
        }
        return AppLifecycleState.BACKGROUND;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerObserver() {
        ProcessLifecycleOwner.INSTANCE.get().getLifecycleRegistry().addObserver(this);
    }

    @Override // com.survicate.surveys.utils.AppLifecycleProvider
    public Observable<AppLifecycleState> observeLifecycleChanges() {
        return this.lifecycleObservable;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStart(owner);
        this.lifecycleObservable.notifyObservers(AppLifecycleState.FOREGROUND);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        this.lifecycleObservable.notifyObservers(AppLifecycleState.BACKGROUND);
    }
}
