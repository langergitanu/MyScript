package com.myscript.atk.resourcemanager.internal.manager;

import android.app.Application;
import android.app.DownloadManager;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.internal.bean.DownloadInfo;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadProgressManager {
    private static final long DOWNLOAD_REFRESH_INTERVAL = 800;
    private final DownloadEventManager mDownloadEventManager;
    private final DownloadManager mDownloadManager;
    private boolean mIsListenerStarted;
    private final Map<Language, DownloadInfo> mLanguageDownloadInfos;
    private final Runnable mDownloadListener = new Runnable() { // from class: com.myscript.atk.resourcemanager.internal.manager.DownloadProgressManager.1
        @Override // java.lang.Runnable
        public void run() {
            DownloadProgressManager.this.mHandler.postDelayed(this, DownloadProgressManager.DOWNLOAD_REFRESH_INTERVAL);
            DownloadProgressManager.this.updateDownloadStatus();
        }
    };
    private final Map<Language, DownloadInfo> mLanguageDownloadCompleteInfos = new ConcurrentHashMap(0, 0.9f, 1);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public DownloadProgressManager(Application application, Map<Language, DownloadInfo> map, DownloadEventManager downloadEventManager) {
        this.mDownloadEventManager = downloadEventManager;
        this.mDownloadManager = (DownloadManager) application.getSystemService("download");
        this.mLanguageDownloadInfos = map;
    }

    public void register(Language language) {
        this.mDownloadEventManager.dispatchStart(language);
        if (this.mIsListenerStarted) {
            return;
        }
        startDownloadListener();
    }

    public void cancelDownload(Language language) {
        this.mDownloadEventManager.dispatchCanceled(language);
        clearLanguage(language);
        if (this.mLanguageDownloadInfos.isEmpty()) {
            stopDownloadListener();
        }
    }

    public DownloadInfo getDownloadInfo(Language language) {
        if (this.mLanguageDownloadCompleteInfos.containsKey(language)) {
            return this.mLanguageDownloadCompleteInfos.get(language);
        }
        if (this.mLanguageDownloadInfos.containsKey(language)) {
            return this.mLanguageDownloadInfos.get(language);
        }
        return null;
    }

    private void clearLanguage(Language language) {
        this.mLanguageDownloadInfos.remove(language);
    }

    private void startDownloadListener() {
        this.mHandler.postDelayed(this.mDownloadListener, DOWNLOAD_REFRESH_INTERVAL);
        this.mIsListenerStarted = true;
    }

    private void stopDownloadListener() {
        this.mHandler.removeCallbacks(this.mDownloadListener);
        this.mIsListenerStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadStatus() {
        DownloadManager.Query query;
        DownloadManager.Query query2;
        DownloadManager.Query query3 = new DownloadManager.Query();
        for (Map.Entry<Language, DownloadInfo> entry : this.mLanguageDownloadInfos.entrySet()) {
            Language key = entry.getKey();
            DownloadInfo value = entry.getValue();
            query3.setFilterById(value.getDownloadPendingIds());
            Cursor cursorQuery = this.mDownloadManager.query(query3);
            if (cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("_id");
                int columnIndex2 = cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_STATUS);
                int columnIndex3 = cursorQuery.getColumnIndex("reason");
                int columnIndex4 = cursorQuery.getColumnIndex("bytes_so_far");
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndex);
                    int i = cursorQuery.getInt(columnIndex2);
                    int i2 = cursorQuery.getInt(columnIndex4);
                    if (i == 8) {
                        query2 = query3;
                        try {
                            onDownloadSuccess(key, j);
                        } catch (IOException e) {
                            onDownloadFail(key, e);
                        }
                    } else if (i != 16) {
                        query2 = query3;
                    } else {
                        query2 = query3;
                        onDownloadFail(key, new IllegalStateException("Download error #" + cursorQuery.getInt(columnIndex3)));
                    }
                    value.setDownloadedSoFar(j, i2);
                    query3 = query2;
                }
                query = query3;
                onDownloadProgress(key, value.getSize() + value.getAlreadyExistSize(), value.getDownloadedSoFar() + value.getAlreadyExistSize());
                if (value.isDownloadComplete()) {
                    onLanguageDownloadComplete(key);
                }
            } else {
                query = query3;
                onDownloadFail(key, new IllegalStateException("No download information."));
            }
            cursorQuery.close();
            query3 = query;
        }
        if (this.mLanguageDownloadInfos.isEmpty()) {
            stopDownloadListener();
        }
    }

    private boolean canDispatchEvents(Language language) {
        return this.mLanguageDownloadInfos.containsKey(language);
    }

    private void onDownloadSuccess(Language language, long j) throws IOException {
        if (canDispatchEvents(language)) {
            DownloadInfo downloadInfo = this.mLanguageDownloadInfos.get(language);
            downloadInfo.setDownloadComplete(j);
            this.mLanguageDownloadCompleteInfos.put(language, downloadInfo);
            this.mDownloadEventManager.dispatchEachFileSuccess(language, j);
        }
    }

    private void onDownloadProgress(Language language, int i, int i2) {
        if (!canDispatchEvents(language) || i2 == 0) {
            return;
        }
        this.mDownloadEventManager.dispatchProgress(language, i, i2);
    }

    private void onLanguageDownloadComplete(Language language) {
        if (canDispatchEvents(language)) {
            this.mDownloadEventManager.dispatchSuccess(language);
            clearLanguage(language);
        }
    }

    private void onDownloadFail(Language language, Exception exc) {
        if (this.mLanguageDownloadInfos.containsKey(language)) {
            this.mDownloadManager.remove(this.mLanguageDownloadInfos.get(language).getDownloadPendingIds());
            this.mDownloadEventManager.dispatchError(language, exc);
            clearLanguage(language);
        }
    }
}
