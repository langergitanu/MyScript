package com.myscript.nebo.freemium.storage;

import kotlin.Metadata;

/* JADX INFO: compiled from: SecuredLegacyPaidStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0006H'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage;", "", "isPaidLegacyUser", "", "()Z", "storeLegacyState", "", "isLegacy", "clear", "Provider", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface LegacyPaidStorage {

    /* JADX INFO: compiled from: SecuredLegacyPaidStorage.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage$Provider;", "", "provideLegacyPaidStorage", "Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage;", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        LegacyPaidStorage provideLegacyPaidStorage();
    }

    void clear();

    boolean isPaidLegacyUser();

    void storeLegacyState(boolean isLegacy);
}
