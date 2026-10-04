package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.entities.models.ContactAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH&J(\u0010\f\u001a\u00020\u00032\u001e\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;", "", "saveRespondentVerificationTime", "", "timeMs", "", "saveContactAction", "action", "Lcom/survicate/surveys/entities/models/ContactAction;", "removeContactAction", "loadContactActions", "", "updateContactActions", "transform", "Lkotlin/Function1;", "clearUserData", "clearRespondentVerificationTime", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactStore {
    void clearRespondentVerificationTime();

    void clearUserData();

    List<ContactAction> loadContactActions();

    void removeContactAction(ContactAction action);

    void saveContactAction(ContactAction action);

    void saveRespondentVerificationTime(long timeMs);

    void updateContactActions(Function1<? super List<? extends ContactAction>, ? extends List<? extends ContactAction>> transform);
}
