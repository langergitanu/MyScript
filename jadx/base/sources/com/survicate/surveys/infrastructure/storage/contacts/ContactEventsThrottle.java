package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.entities.models.ContactAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactEventsThrottle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b`\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0004H&J\u000e\u0010\f\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\rR$\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/ContactEventsThrottle;", "", "onEventThrottled", "Lkotlin/Function1;", "Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent;", "", "getOnEventThrottled", "()Lkotlin/jvm/functions/Function1;", "setOnEventThrottled", "(Lkotlin/jvm/functions/Function1;)V", "enqueue", "action", "awaitNextFlush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactEventsThrottle {
    Object awaitNextFlush(Continuation<? super Unit> continuation);

    void enqueue(ContactAction.InvokeEvent action);

    Function1<ContactAction.InvokeEvent, Unit> getOnEventThrottled();

    void setOnEventThrottled(Function1<? super ContactAction.InvokeEvent, Unit> function1);
}
