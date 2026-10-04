package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.entities.models.ContactAction;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContactActionSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/ContactActionSerializer;", "", "serializeContactActions", "", "actions", "", "Lcom/survicate/surveys/entities/models/ContactAction;", "deserializeContactActions", "serializedActions", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactActionSerializer {
    List<ContactAction> deserializeContactActions(String serializedActions);

    String serializeContactActions(List<? extends ContactAction> actions);
}
