package com.myscript.nebo.account;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: UserProfileManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u000fH&J\u000e\u0010\u0014\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0018À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/UserProfileManager;", "", "isPaidSubscriber", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "hasAccessToAllFeatures", "hasPaidEntitlement", "isFreePeriod", "hasFeatureAccess", "feature", "Lcom/myscript/nebo/account/Feature;", "hasLifetimeInAppPurchase", "hasRecurringPurchase", "addFeatureAccessListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/account/FeatureAccessListener;", "removeFeatureAccessListener", "release", "fetchNeboAccount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWhitelistedVersion", "Provider", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface UserProfileManager {

    /* JADX INFO: compiled from: UserProfileManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/UserProfileManager$Provider;", "", "provideUserProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        UserProfileManager provideUserProfileManager();
    }

    void addFeatureAccessListener(FeatureAccessListener listener);

    Object fetchNeboAccount(Continuation<? super Unit> continuation);

    boolean hasAccessToAllFeatures();

    boolean hasFeatureAccess(Feature feature);

    boolean hasLifetimeInAppPurchase();

    boolean hasPaidEntitlement();

    boolean hasRecurringPurchase();

    boolean isFreePeriod();

    Flow<Boolean> isPaidSubscriber();

    boolean isWhitelistedVersion();

    void release();

    void removeFeatureAccessListener(FeatureAccessListener listener);
}
