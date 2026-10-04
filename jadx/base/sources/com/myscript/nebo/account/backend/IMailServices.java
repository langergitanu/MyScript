package com.myscript.nebo.account.backend;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MailServices.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/IMailServices;", "", "linkToRevenueCat", "", "appUserId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "optInTrialStarted", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IMailServices {
    Object linkToRevenueCat(String str, Continuation<? super Boolean> continuation);

    Object optInTrialStarted(String str, Continuation<? super Boolean> continuation);
}
