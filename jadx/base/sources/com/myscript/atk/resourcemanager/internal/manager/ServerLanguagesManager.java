package com.myscript.atk.resourcemanager.internal.manager;

import android.app.Application;
import android.util.Log;
import com.myscript.atk.resourcemanager.GlobalDownloadsCallback;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.internal.DownloadListener;
import com.myscript.atk.resourcemanager.internal.bean.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes4.dex */
public class ServerLanguagesManager {
    private static final String TAG = "ServerLanguagesManager";
    private final DownloadListener mDownloadListener;
    private final Set<GlobalDownloadsCallback> mDownloadsCallbacks = new CopyOnWriteArraySet();
    private final LanguagesDownloadManager mLanguagesDownloadManager;
    private final RepositoryManager mRepositoryManager;

    public ServerLanguagesManager(Application application, RepositoryManager repositoryManager, File file) {
        DownloadListener downloadListener = new DownloadListener() { // from class: com.myscript.atk.resourcemanager.internal.manager.ServerLanguagesManager.1
            @Override // com.myscript.atk.resourcemanager.internal.DownloadListener
            public void onDownloadStart(Language language) {
                for (GlobalDownloadsCallback globalDownloadsCallback : ServerLanguagesManager.this.mDownloadsCallbacks) {
                    try {
                        globalDownloadsCallback.onLanguageDownloadStart(language);
                    } catch (Exception e) {
                        Log.e(ServerLanguagesManager.TAG, "Something went wrong while starting the download of a language " + language, e);
                        dispatchException(globalDownloadsCallback, language, e);
                    }
                }
            }

            @Override // com.myscript.atk.resourcemanager.internal.DownloadListener
            public void onDownloadProgress(Language language, int i, int i2) {
                for (GlobalDownloadsCallback globalDownloadsCallback : ServerLanguagesManager.this.mDownloadsCallbacks) {
                    try {
                        globalDownloadsCallback.onLanguageDownloadProgress(language, i, i2);
                    } catch (Exception e) {
                        Log.e(ServerLanguagesManager.TAG, "Something went wrong during language download " + language, e);
                        dispatchException(globalDownloadsCallback, language, e);
                    }
                }
            }

            @Override // com.myscript.atk.resourcemanager.internal.DownloadListener
            public void onDownloadEachFileSuccess(Language language, long j) {
                try {
                    ServerLanguagesManager.this.mLanguagesDownloadManager.processEachFileDownload(language, j);
                } catch (Exception e) {
                    Log.e(ServerLanguagesManager.TAG, "Something went wrong on onDownloadEachFileSuccess of repositoryManager" + e.getMessage(), e);
                }
            }

            @Override // com.myscript.atk.resourcemanager.internal.DownloadListener
            public void onDownloadSuccess(Language language) {
                Language languageUpdateLanguage;
                DownloadInfo downloadInfo = ServerLanguagesManager.this.mLanguagesDownloadManager.getDownloadInfo(language);
                if (downloadInfo != null) {
                    Iterator<String> it = downloadInfo.getFolders().iterator();
                    while (it.hasNext()) {
                        try {
                            ServerLanguagesManager.this.mRepositoryManager.onDownloadSuccess(new Language(it.next()), downloadInfo);
                        } catch (Exception e) {
                            Log.e(ServerLanguagesManager.TAG, "Something went wrong on onDownloadSuccess of repositoryManager" + e.getMessage(), e);
                            Iterator it2 = ServerLanguagesManager.this.mDownloadsCallbacks.iterator();
                            while (it2.hasNext()) {
                                dispatchException((GlobalDownloadsCallback) it2.next(), language, e);
                            }
                        }
                    }
                }
                if (ServerLanguagesManager.this.mDownloadsCallbacks.isEmpty()) {
                    return;
                }
                try {
                    languageUpdateLanguage = ServerLanguagesManager.this.mRepositoryManager.updateLanguage(language);
                } catch (IOException e2) {
                    Log.e(ServerLanguagesManager.TAG, "Something went wrong on updateLanguage" + e2.getMessage(), e2);
                    Iterator it3 = ServerLanguagesManager.this.mDownloadsCallbacks.iterator();
                    while (it3.hasNext()) {
                        dispatchException((GlobalDownloadsCallback) it3.next(), language, e2);
                    }
                    languageUpdateLanguage = language;
                }
                for (GlobalDownloadsCallback globalDownloadsCallback : ServerLanguagesManager.this.mDownloadsCallbacks) {
                    try {
                        globalDownloadsCallback.onLanguageDownloadSuccess(languageUpdateLanguage);
                    } catch (Exception e3) {
                        Log.e(ServerLanguagesManager.TAG, "Something went wrong during onLanguageDownloadSuccess" + e3.getMessage(), e3);
                        dispatchException(globalDownloadsCallback, language, e3);
                    }
                }
            }

            @Override // com.myscript.atk.resourcemanager.internal.DownloadListener
            public void onDownloadError(Language language, Exception exc) {
                if (ServerLanguagesManager.this.mDownloadsCallbacks.size() > 0) {
                    try {
                        language = ServerLanguagesManager.this.mRepositoryManager.updateLanguage(language);
                    } catch (IOException e) {
                        Log.e(ServerLanguagesManager.TAG, e.getMessage(), e);
                    }
                    Iterator it = ServerLanguagesManager.this.mDownloadsCallbacks.iterator();
                    while (it.hasNext()) {
                        ((GlobalDownloadsCallback) it.next()).onLanguageDownloadError(language, exc);
                    }
                }
            }

            @Override // com.myscript.atk.resourcemanager.internal.DownloadListener
            public void onDownloadCanceled(Language language) {
                if (ServerLanguagesManager.this.mDownloadsCallbacks.size() > 0) {
                    try {
                        language = ServerLanguagesManager.this.mRepositoryManager.updateLanguage(language);
                    } catch (IOException e) {
                        Log.e(ServerLanguagesManager.TAG, e.getMessage(), e);
                    }
                    Iterator it = ServerLanguagesManager.this.mDownloadsCallbacks.iterator();
                    while (it.hasNext()) {
                        ((GlobalDownloadsCallback) it.next()).onLanguageDownloadCanceled(language);
                    }
                }
            }

            private void dispatchException(GlobalDownloadsCallback globalDownloadsCallback, Language language, Exception exc) {
                globalDownloadsCallback.onLanguageDownloadError(language, exc);
            }
        };
        this.mDownloadListener = downloadListener;
        this.mRepositoryManager = repositoryManager;
        LanguagesDownloadManager languagesDownloadManager = new LanguagesDownloadManager(application, repositoryManager, file);
        this.mLanguagesDownloadManager = languagesDownloadManager;
        languagesDownloadManager.addDownloadListener(downloadListener);
    }

    public void addDownloadsCallbacks(GlobalDownloadsCallback globalDownloadsCallback) {
        this.mDownloadsCallbacks.add(globalDownloadsCallback);
    }

    public void removeDownloadsCallbacks(GlobalDownloadsCallback globalDownloadsCallback) {
        this.mDownloadsCallbacks.remove(globalDownloadsCallback);
    }

    public int getNumOfResourceManagerDownloadCallbacks() {
        return this.mDownloadsCallbacks.size();
    }

    public void download(Language language) throws Throwable {
        this.mLanguagesDownloadManager.download(language);
    }

    public void cancelDownload(Language language) {
        this.mLanguagesDownloadManager.cancelDownload(language);
    }

    public Set<Language> getCurrentDownloads() {
        return this.mLanguagesDownloadManager.getCurrentDownloads();
    }

    public void release() {
        this.mLanguagesDownloadManager.release();
    }
}
