package com.myscript.nebo.screennavigation;

import com.myscript.nebo.whatsnew.ApplicationState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ILaunchStateProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\fH&J\u000e\u0010\u000f\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0012\u0010\r\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/screennavigation/ILaunchStateProvider;", "", "versionName", "", "getVersionName", "()Ljava/lang/String;", "requiresPLSMigration", "", "getRequiresPLSMigration", "()Z", "isOnBoardingNeeded", "setOnBoardingNotNeeded", "", "isEnterpriseMandatoryLoginNeeded", "isLoggedIn", "hasSubscribed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applicationState", "Lcom/myscript/nebo/whatsnew/ApplicationState;", "getApplicationState", "()Lcom/myscript/nebo/whatsnew/ApplicationState;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ILaunchStateProvider {
    ApplicationState getApplicationState();

    boolean getRequiresPLSMigration();

    String getVersionName();

    Object hasSubscribed(Continuation<? super Boolean> continuation);

    boolean isEnterpriseMandatoryLoginNeeded();

    boolean isLoggedIn();

    boolean isOnBoardingNeeded();

    void setOnBoardingNotNeeded();
}
