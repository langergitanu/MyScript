package com.survicate.surveys.core.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Executor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH&R(\u0010\u0002\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/core/utils/Executor;", "", "onException", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "getOnException", "()Lkotlin/jvm/functions/Function1;", "setOnException", "(Lkotlin/jvm/functions/Function1;)V", "post", "action", "Lkotlin/Function0;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface Executor {
    Function1<Exception, Unit> getOnException();

    void post(Function0<Unit> action);

    void setOnException(Function1<? super Exception, Unit> function1);
}
