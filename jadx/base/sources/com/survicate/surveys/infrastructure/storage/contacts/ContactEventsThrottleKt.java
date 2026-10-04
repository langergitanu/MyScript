package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.entities.models.ContactAction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactEventsThrottle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"THROTTLE_DELAY_MS", "", "markEventsAsScheduled", "", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ContactEventsThrottleKt {
    private static final long THROTTLE_DELAY_MS = 3000;

    public static final void markEventsAsScheduled(ContactStore contactStore) {
        Intrinsics.checkNotNullParameter(contactStore, "<this>");
        contactStore.updateContactActions(new Function1() { // from class: com.survicate.surveys.infrastructure.storage.contacts.ContactEventsThrottleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactEventsThrottleKt.markEventsAsScheduled$lambda$1((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List markEventsAsScheduled$lambda$1(List current) {
        Intrinsics.checkNotNullParameter(current, "current");
        List<ContactAction> list = current;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ContactAction.InvokeEvent invokeEventCopy$default : list) {
            if (invokeEventCopy$default instanceof ContactAction.InvokeEvent) {
                invokeEventCopy$default = ContactAction.InvokeEvent.copy$default((ContactAction.InvokeEvent) invokeEventCopy$default, null, null, null, null, true, 15, null);
            }
            arrayList.add(invokeEventCopy$default);
        }
        return arrayList;
    }
}
