package com.myscript.nebo.account;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: UserProfileManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/account/FeatureAccessListener;", "", "featuresAccessChanged", "", "access", "", "Lcom/myscript/nebo/account/Feature;", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface FeatureAccessListener {
    void featuresAccessChanged(Map<Feature, Boolean> access);
}
