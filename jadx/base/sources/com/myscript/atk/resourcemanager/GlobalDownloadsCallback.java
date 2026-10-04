package com.myscript.atk.resourcemanager;

/* JADX INFO: loaded from: classes4.dex */
public interface GlobalDownloadsCallback {
    void onLanguageDownloadCanceled(Language language);

    void onLanguageDownloadError(Language language, Exception exc);

    void onLanguageDownloadProgress(Language language, int i, int i2);

    void onLanguageDownloadStart(Language language);

    void onLanguageDownloadSuccess(Language language);
}
