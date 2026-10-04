package com.myscript.atk.resourcemanager;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import com.myscript.atk.resourcemanager.internal.manager.RepositoryManager;
import com.myscript.atk.resourcemanager.internal.manager.ServerLanguagesManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ResourceManagerImpl implements ResourceManager {
    private static final String TAG = "ResourceManagerImpl";
    private final ServerLanguagesManager mLanguagesManager;
    private final RepositoryManager mRepositoryManager;
    private final File mRootFolder;
    private final File mTemporaryDownloadDir;

    public ResourceManagerImpl(Application application, ResourceManagerConf resourceManagerConf) {
        String localFolderName = resourceManagerConf.getLocalFolderName();
        File file = (File) Objects.requireNonNull(application.getFilesDir().getParentFile());
        this.mRootFolder = file;
        File file2 = new File(application.getExternalFilesDir(null), "DownloadTemp");
        this.mTemporaryDownloadDir = file2;
        RepositoryManager repositoryManager = new RepositoryManager(application, resourceManagerConf.getRepoName(), Uri.parse(resourceManagerConf.getRemoteUri()), new File(file, localFolderName), resourceManagerConf.getAssetsPath());
        this.mRepositoryManager = repositoryManager;
        this.mLanguagesManager = new ServerLanguagesManager(application, repositoryManager, file2);
    }

    public void onBind() {
        this.mRepositoryManager.checkPackageVersion(this.mRootFolder);
        try {
            this.mRepositoryManager.checkRepositorySanity(this.mTemporaryDownloadDir);
            this.mRepositoryManager.sync();
        } catch (IOException e) {
            Log.e(TAG, "Error while synchronizing repository", e);
        }
    }

    public void onUnbind() {
        try {
            Set<Language> currentDownloads = this.mLanguagesManager.getCurrentDownloads();
            if (currentDownloads != null && !currentDownloads.isEmpty()) {
                Iterator<Language> it = currentDownloads.iterator();
                while (it.hasNext()) {
                    this.mLanguagesManager.cancelDownload(it.next());
                }
            }
            this.mLanguagesManager.release();
        } catch (Exception e) {
            Log.e(TAG, "Error while cancelling downloads during unbinding : ", e);
        }
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public void addDownloadsCallback(GlobalDownloadsCallback globalDownloadsCallback) {
        this.mLanguagesManager.addDownloadsCallbacks(globalDownloadsCallback);
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public void removeDownloadsCallback(GlobalDownloadsCallback globalDownloadsCallback) {
        this.mLanguagesManager.removeDownloadsCallbacks(globalDownloadsCallback);
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public void downloadLanguage(Language language) throws Throwable {
        this.mLanguagesManager.download(language);
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public void cancelDownload(Language language) {
        this.mLanguagesManager.cancelDownload(language);
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public List<Language> getCurrentDownloads() {
        return new ArrayList(this.mLanguagesManager.getCurrentDownloads());
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public void deleteLanguage(Language language) {
        this.mRepositoryManager.remove(language);
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public List<String> getConfPaths() {
        return new ArrayList(this.mRepositoryManager.getConfPaths());
    }

    @Override // com.myscript.atk.resourcemanager.ResourceManager
    public String updateLanguageList() {
        try {
            this.mRepositoryManager.pull();
            this.mRepositoryManager.sync();
        } catch (IOException e) {
            Log.e(TAG, "Error while synchronizing repository", e);
        }
        return this.mRepositoryManager.getLatestPath();
    }
}
