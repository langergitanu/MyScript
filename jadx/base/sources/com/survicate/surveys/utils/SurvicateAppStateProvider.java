package com.survicate.surveys.utils;

import com.survicate.surveys.helpers.NetworkStateProvider;
import com.survicate.surveys.helpers.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppStateProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/utils/SurvicateAppStateProvider;", "Lcom/survicate/surveys/utils/AppStateProvider;", "networkStateProvider", "Lcom/survicate/surveys/helpers/NetworkStateProvider;", "appLifecycleProvider", "Lcom/survicate/surveys/utils/AppLifecycleProvider;", "<init>", "(Lcom/survicate/surveys/helpers/NetworkStateProvider;Lcom/survicate/surveys/utils/AppLifecycleProvider;)V", "currentState", "Lcom/survicate/surveys/utils/AppState;", "getCurrentState", "()Lcom/survicate/surveys/utils/AppState;", "appStateObservable", "Lcom/survicate/surveys/helpers/Observable;", "observeAppStateChanges", "emitCurrentState", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateAppStateProvider implements AppStateProvider {
    private final AppLifecycleProvider appLifecycleProvider;
    private final Observable<AppState> appStateObservable;
    private final NetworkStateProvider networkStateProvider;

    public SurvicateAppStateProvider(NetworkStateProvider networkStateProvider, AppLifecycleProvider appLifecycleProvider) {
        Intrinsics.checkNotNullParameter(networkStateProvider, "networkStateProvider");
        Intrinsics.checkNotNullParameter(appLifecycleProvider, "appLifecycleProvider");
        this.networkStateProvider = networkStateProvider;
        this.appLifecycleProvider = appLifecycleProvider;
        this.appStateObservable = new Observable<>();
        Observable<Boolean> observableObserveNetworkChanges = networkStateProvider.observeNetworkChanges();
        final Function1 function1 = new Function1() { // from class: com.survicate.surveys.utils.SurvicateAppStateProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateAppStateProvider._init_$lambda$0(this.f$0, (Boolean) obj);
            }
        };
        observableObserveNetworkChanges.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.utils.SurvicateAppStateProvider$$ExternalSyntheticLambda1
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function1.invoke(obj);
            }
        });
        Observable<AppLifecycleState> observableObserveLifecycleChanges = appLifecycleProvider.observeLifecycleChanges();
        final Function1 function12 = new Function1() { // from class: com.survicate.surveys.utils.SurvicateAppStateProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateAppStateProvider._init_$lambda$2(this.f$0, (AppLifecycleState) obj);
            }
        };
        observableObserveLifecycleChanges.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.utils.SurvicateAppStateProvider$$ExternalSyntheticLambda3
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function12.invoke(obj);
            }
        });
    }

    @Override // com.survicate.surveys.utils.AppStateProvider
    public AppState getCurrentState() {
        return new AppState(this.networkStateProvider.getIsNetworkAvailable(), this.appLifecycleProvider.getCurrentState() == AppLifecycleState.FOREGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(SurvicateAppStateProvider survicateAppStateProvider, Boolean bool) {
        survicateAppStateProvider.emitCurrentState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(SurvicateAppStateProvider survicateAppStateProvider, AppLifecycleState appLifecycleState) {
        survicateAppStateProvider.emitCurrentState();
        return Unit.INSTANCE;
    }

    @Override // com.survicate.surveys.utils.AppStateProvider
    public Observable<AppState> observeAppStateChanges() {
        return this.appStateObservable;
    }

    private final void emitCurrentState() {
        this.appStateObservable.notifyObservers(getCurrentState());
    }
}
