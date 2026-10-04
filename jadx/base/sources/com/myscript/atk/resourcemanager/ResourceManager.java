package com.myscript.atk.resourcemanager;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ResourceManager {

    @FunctionalInterface
    public interface Provider {
        ResourceManager provideResourceManager();
    }

    void addDownloadsCallback(GlobalDownloadsCallback globalDownloadsCallback);

    void cancelDownload(Language language);

    void deleteLanguage(Language language);

    void downloadLanguage(Language language);

    List<String> getConfPaths();

    List<Language> getCurrentDownloads();

    void removeDownloadsCallback(GlobalDownloadsCallback globalDownloadsCallback);

    String updateLanguageList();
}
