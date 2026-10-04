package com.myscript.nebo.languagemanager.presentation;

import kotlin.Metadata;

/* JADX INFO: compiled from: LanguageAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/Callback;", "", "onLanguageDownloadRequested", "", "languageKey", "", "onRemoveLanguageRequest", "onCancelLanguageDownloadRequest", "onLanguageClicked", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Callback {
    void onCancelLanguageDownloadRequest(String languageKey);

    void onLanguageClicked(String languageKey);

    void onLanguageDownloadRequested(String languageKey);

    void onRemoveLanguageRequest(String languageKey);
}
