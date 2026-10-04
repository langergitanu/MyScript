package com.myscript.nebo.migration;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IInstallReferralRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/IInstallReferralRepository;", "", "resolveReferral", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLenovoReferral", "", "referralSource", "", "installSource", "Provider", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IInstallReferralRepository {

    /* JADX INFO: compiled from: IInstallReferralRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/IInstallReferralRepository$Provider;", "", "provideInstallReferralRepository", "Lcom/myscript/nebo/migration/IInstallReferralRepository;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        IInstallReferralRepository provideInstallReferralRepository();
    }

    String installSource();

    boolean isLenovoReferral();

    String referralSource();

    Object resolveReferral(Continuation<? super Unit> continuation);
}
