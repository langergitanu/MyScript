package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.traits.UserTrait;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContactAttributesThrottle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/ContactAttributesThrottle;", "", "updateThrottleTimestamps", "", "Lcom/survicate/surveys/traits/UserTrait;", "updatedTraits", "savedTraits", "getTraitsReadyToSend", "traits", "flush", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactAttributesThrottle {
    void flush();

    List<UserTrait> getTraitsReadyToSend(List<? extends UserTrait> traits);

    List<UserTrait> updateThrottleTimestamps(List<? extends UserTrait> updatedTraits, List<? extends UserTrait> savedTraits);
}
