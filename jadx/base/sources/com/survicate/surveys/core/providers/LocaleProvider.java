package com.survicate.surveys.core.providers;

import kotlin.Metadata;

/* JADX INFO: compiled from: LocaleProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/providers/LocaleProvider;", "", "deviceLanguage", "", "getDeviceLanguage", "()Ljava/lang/String;", "appLanguage", "getAppLanguage", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface LocaleProvider {
    String getAppLanguage();

    String getDeviceLanguage();
}
