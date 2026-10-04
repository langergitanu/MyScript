package com.myscript.atk.resourcemanager.internal;

import com.myscript.atk.resourcemanager.Language;
import com.myscript.nebo.LaunchActivity;
import kotlin.Metadata;

/* JADX INFO: compiled from: DownloadListener.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\b\u001a\u00060\tj\u0002`\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/atk/resourcemanager/internal/DownloadListener;", "", "onDownloadStart", "", LaunchActivity.LaunchRoute.Language, "Lcom/myscript/atk/resourcemanager/Language;", "onDownloadCanceled", "onDownloadError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onDownloadProgress", "max", "", "progress", "onDownloadEachFileSuccess", "downloadId", "", "onDownloadSuccess", "resourcemanager-lib_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface DownloadListener {
    void onDownloadCanceled(Language language);

    void onDownloadEachFileSuccess(Language language, long downloadId);

    void onDownloadError(Language language, Exception exception);

    void onDownloadProgress(Language language, int max, int progress);

    void onDownloadStart(Language language);

    void onDownloadSuccess(Language language);
}
