package com.myscript.atk.resourcemanager.internal.manager;

import android.app.Application;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.internal.DownloadListener;
import com.myscript.atk.resourcemanager.internal.bean.DownloadInfo;
import com.myscript.atk.resourcemanager.internal.bean.FileInfo;
import com.myscript.atk.resourcemanager.internal.helper.Md5Helper;
import com.myscript.atk.resourcemanager.internal.utils.FilesUtils;
import com.myscript.atk.resourcemanager.utils.Version;
import com.revenuecat.purchases.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class LanguagesDownloadManager {
    private static final int DEPTH_OF_LANGUAGE_FOLDER = 2;
    private static final int MAX_NUM_OF_FILES_SEPARATOR = 4;
    private static final int MAX_NUM_OF_GOING_PARENT = 3;
    private static final String TAG = "LanguagesDownloadManager";
    private static int cpt;
    private final DownloadEventManager mDownloadEventManager;
    private final DownloadManager mDownloadManager;
    private final DownloadProgressManager mDownloadProgressManager;
    private final Map<Language, DownloadInfo> mLanguageDownloadInfos;
    private final RepositoryManager mRepositoryManager;
    private final File mTemporaryDownloadDir;
    private final String mUserAgent;
    private final List<Language> mWaitingLanguages;
    private final Object mDownloadLock = new Object();
    private int mFileCounter = 0;
    private int mRequestCounter = 0;

    public LanguagesDownloadManager(Application application, RepositoryManager repositoryManager, File file) {
        this.mDownloadManager = (DownloadManager) application.getSystemService("download");
        this.mRepositoryManager = repositoryManager;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mLanguageDownloadInfos = concurrentHashMap;
        this.mWaitingLanguages = new ArrayList();
        DownloadEventManager downloadEventManager = new DownloadEventManager();
        this.mDownloadEventManager = downloadEventManager;
        this.mDownloadProgressManager = new DownloadProgressManager(application, concurrentHashMap, downloadEventManager);
        this.mUserAgent = "UUID:RM2-Version:VERSION_NAME.VERSION_CODE:" + Build.DEVICE + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + Build.ID + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + Build.MANUFACTURER + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + Build.MODEL + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + Build.PRODUCT + ":sdk:" + Build.VERSION.SDK_INT + ":request:";
        this.mTemporaryDownloadDir = file;
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public void release() {
        synchronized (this.mDownloadLock) {
            Iterator<Map.Entry<Language, DownloadInfo>> it = this.mLanguageDownloadInfos.entrySet().iterator();
            while (it.hasNext()) {
                DownloadInfo value = it.next().getValue();
                for (long j : value.getDownloadPendingIds()) {
                    this.mDownloadManager.remove(j);
                }
                cleanupLocalFiles(value);
            }
            this.mLanguageDownloadInfos.clear();
            this.mWaitingLanguages.clear();
        }
    }

    private void cleanupLocalFiles(DownloadInfo downloadInfo) {
        for (long j : downloadInfo.getDownloadPendingIds()) {
            File localFile = downloadInfo.getLocalFile(j);
            if (localFile != null && localFile.exists()) {
                localFile.delete();
            }
        }
    }

    public void addDownloadListener(DownloadListener downloadListener) {
        this.mDownloadEventManager.addDownloadListener(downloadListener);
    }

    public void removeDownloadListener(DownloadListener downloadListener) {
        this.mDownloadEventManager.removeDownloadListener(downloadListener);
    }

    public DownloadInfo getDownloadInfo(Language language) {
        return this.mDownloadProgressManager.getDownloadInfo(language);
    }

    public Set<Language> getCurrentDownloads() {
        HashSet hashSet;
        synchronized (this.mDownloadLock) {
            hashSet = new HashSet();
            hashSet.addAll(this.mLanguageDownloadInfos.keySet());
            hashSet.addAll(this.mWaitingLanguages);
        }
        return hashSet;
    }

    public void processEachFileDownload(Language language, long j) throws NoSuchAlgorithmException, IOException {
        if (this.mRepositoryManager.contains(language)) {
            DownloadInfo downloadInfo = getDownloadInfo(language);
            if (downloadInfo != null) {
                this.mRepositoryManager.processEachFileDownload(downloadInfo, j);
                return;
            } else {
                Log.e(TAG, "\t[Error] processEachFileDownload : Was not able to find download information for " + language);
                throw new IOException(String.format("Was not able to find the language from download information : %s", language.getLanguageKey()));
            }
        }
        Log.e(TAG, "\t[Error] processEachFileDownload : Language list doesn't have " + language);
        throw new IOException(String.format("Was not able to find the language from the language list : %s", language.getLanguageKey()));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050 A[Catch: all -> 0x00d7, DONT_GENERATE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x000b, B:9:0x000f, B:11:0x001c, B:15:0x002f, B:27:0x0050, B:29:0x0053, B:17:0x0036, B:25:0x0048, B:21:0x0040), top: B:73:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053 A[Catch: all -> 0x00d7, DONT_GENERATE, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x000b, B:9:0x000f, B:11:0x001c, B:15:0x002f, B:27:0x0050, B:29:0x0053, B:17:0x0036, B:25:0x0048, B:21:0x0040), top: B:73:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void download(Language language) throws Throwable {
        boolean z;
        boolean z2;
        synchronized (this.mDownloadLock) {
            if (this.mLanguageDownloadInfos.containsKey(language)) {
                return;
            }
            boolean z3 = true;
            boolean z4 = false;
            try {
                this.mRepositoryManager.sync();
            } catch (Exception e) {
                e = e;
                z = false;
            }
            if (this.mRepositoryManager.contains(language)) {
                boolean zIsAvailable = language.isAvailable();
                boolean zEquals = Boolean.TRUE.equals(language.isUpToDate());
                if (zIsAvailable && zEquals) {
                    this.mDownloadEventManager.dispatchCanceled(language);
                }
                try {
                    this.mWaitingLanguages.add(language);
                    z2 = true;
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    this.mDownloadEventManager.dispatchError(language, e);
                    z2 = z;
                }
                if (z2) {
                    return;
                }
                try {
                    List<FileInfo> remoteLanguageFilesInfo = this.mRepositoryManager.getRemoteLanguageFilesInfo(language.getLanguageKey());
                    synchronized (this.mDownloadLock) {
                        try {
                            if (!this.mWaitingLanguages.contains(language)) {
                                return;
                            }
                            DownloadInfo downloadInfo = new DownloadInfo();
                            this.mRepositoryManager.sync();
                            this.mWaitingLanguages.remove(language);
                            if (this.mRepositoryManager.contains(language)) {
                                boolean zIsAvailable2 = language.isAvailable();
                                boolean zEquals2 = Boolean.TRUE.equals(language.isUpToDate());
                                if (!zIsAvailable2 || !zEquals2) {
                                    if (!downloadForRepository(downloadInfo, language, this.mRepositoryManager, remoteLanguageFilesInfo)) {
                                    }
                                    z4 = z3;
                                } else {
                                    this.mDownloadEventManager.dispatchCanceled(language);
                                }
                                z3 = false;
                                z4 = z3;
                            } else {
                                this.mDownloadEventManager.dispatchCanceled(language);
                            }
                            if (!downloadInfo.isEmpty() && !z4) {
                                this.mLanguageDownloadInfos.put(language, downloadInfo);
                                this.mDownloadProgressManager.register(language);
                            }
                        } catch (Exception e3) {
                            this.mDownloadEventManager.dispatchError(language, e3);
                        }
                        return;
                    }
                } catch (Exception e4) {
                    this.mWaitingLanguages.remove(language);
                    this.mDownloadEventManager.dispatchError(language, e4);
                    return;
                }
            }
            this.mDownloadEventManager.dispatchCanceled(language);
            z2 = false;
            if (z2) {
            }
        }
    }

    private boolean downloadForRepository(DownloadInfo downloadInfo, Language language, RepositoryManager repositoryManager, List<FileInfo> list) throws Throwable {
        boolean z;
        boolean z2;
        boolean z3;
        List<Version> list2;
        ArrayList arrayList;
        Iterator<FileInfo> it;
        String languageKey = language.getLanguageKey();
        Version remoteVersion = repositoryManager.getRemoteVersion();
        File fileMakeNewLanguageFolder = repositoryManager.makeNewLanguageFolder(remoteVersion, languageKey);
        List<Version> listFindLanguageVersions = repositoryManager.findLanguageVersions(languageKey);
        ArrayList arrayList2 = new ArrayList();
        if (listFindLanguageVersions.size() > 0) {
            for (Version version : listFindLanguageVersions) {
                if (version.compareTo(remoteVersion) == 0) {
                    z = true;
                    break;
                }
                arrayList2.add(repositoryManager.getLanguageFolder(version, languageKey));
            }
            z = false;
        } else {
            z = false;
        }
        if (!list.isEmpty()) {
            Iterator<FileInfo> it2 = list.iterator();
            int i = 0;
            int size = 0;
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                FileInfo next = it2.next();
                if (isInvalidPath(next.getFilename())) {
                    String str = "\t[Error] Don't need to go up to upper folder such many times.. Hacking try?  : " + next.getFilename();
                    Log.e(TAG, str);
                    this.mDownloadEventManager.dispatchError(language, new RuntimeException(str));
                    z3 = true;
                    break;
                }
                int size2 = next.getSize();
                boolean z4 = z;
                File file = new File(fileMakeNewLanguageFolder, next.getFilename());
                File parentFile = file.getParentFile();
                if (parentFile.isDirectory()) {
                    list2 = listFindLanguageVersions;
                    arrayList = arrayList2;
                } else {
                    parentFile.mkdirs();
                    list2 = listFindLanguageVersions;
                    arrayList = arrayList2;
                    parentFile.setReadable(true, false);
                    parentFile.setWritable(true);
                    parentFile.setExecutable(true, false);
                }
                if (next.getFilename().endsWith(com.myscript.atk.resourcemanager.internal.Constants.CONF_FILENAME_EXT) || list2.size() <= 0 || z4 || file.isFile()) {
                    it = it2;
                } else {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        File file2 = (File) it3.next();
                        Iterator it4 = it3;
                        if (file2 != null) {
                            it = it2;
                            File file3 = new File(file2, next.getFilename());
                            if (((int) file3.length()) == size2) {
                                try {
                                    if (Md5Helper.getMd5(new FileInputStream(file3)).equals(next.getHash())) {
                                        file.createNewFile();
                                        FilesUtils.copy(file3, file);
                                        break;
                                    }
                                } catch (Exception unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            it = it2;
                        }
                        it3 = it4;
                        it2 = it;
                    }
                    it = it2;
                }
                if (!file.isFile()) {
                    i += size2;
                    File file4 = new File(this.mTemporaryDownloadDir, getRandomFileName());
                    long jEnqueue = this.mDownloadManager.enqueue(createDownloadRequest(next.getUri(), Uri.fromFile(file4)));
                    downloadInfo.setDestinationFile(jEnqueue, new File(fileMakeNewLanguageFolder, next.getFilename()));
                    downloadInfo.addDownloadId(jEnqueue, languageKey);
                    downloadInfo.setLocalFile(jEnqueue, file4);
                    downloadInfo.setFileHash(jEnqueue, next.getHash());
                } else if (next.getFilename().endsWith(com.myscript.atk.resourcemanager.internal.Constants.CONF_FILENAME_EXT)) {
                    Log.w(TAG, "\t[WARNING] STRANGE!! conf file should be moved at the very last.. Why already exist? : " + language + " - Deleting .conf file");
                    FilesUtils.delete(file);
                    i += size2;
                    File file5 = new File(this.mTemporaryDownloadDir, getRandomFileName());
                    long jEnqueue2 = this.mDownloadManager.enqueue(createDownloadRequest(next.getUri(), Uri.fromFile(file5)));
                    downloadInfo.setDestinationFile(jEnqueue2, new File(fileMakeNewLanguageFolder, next.getFilename()));
                    downloadInfo.addDownloadId(jEnqueue2, languageKey);
                    downloadInfo.setLocalFile(jEnqueue2, file5);
                    downloadInfo.setFileHash(jEnqueue2, next.getHash());
                } else {
                    size += next.getSize();
                }
                arrayList2 = arrayList;
                z = z4;
                listFindLanguageVersions = list2;
                it2 = it;
            }
            if (i != 0) {
                if (!z3) {
                    downloadInfo.setAlreadyExistSize(size);
                    downloadInfo.setSize(i);
                }
                z2 = z3;
                return !z2;
            }
            String str2 = String.format("No files to download for language '%s' on repository '%s'.", languageKey, repositoryManager);
            Log.w(TAG, str2);
            this.mDownloadEventManager.dispatchError(language, new IllegalArgumentException(str2));
        } else {
            String str3 = String.format("No files to download for language '%s' on repository '%s'.", languageKey, repositoryManager);
            Log.w(TAG, str3);
            this.mDownloadEventManager.dispatchError(language, new IllegalArgumentException(str3));
        }
        z2 = true;
        return !z2;
    }

    private DownloadManager.Request createDownloadRequest(Uri uri, Uri uri2) {
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(2);
        StringBuilder sbAppend = new StringBuilder().append(this.mUserAgent);
        int i = this.mRequestCounter + 1;
        this.mRequestCounter = i;
        request.addRequestHeader("User-Agent", sbAppend.append(i).toString());
        request.setMimeType("application/octet-stream");
        request.setVisibleInDownloadsUi(false);
        request.setDestinationUri(uri2);
        return request;
    }

    public void cancelDownload(Language language) {
        synchronized (this.mDownloadLock) {
            if (this.mWaitingLanguages.contains(language)) {
                this.mWaitingLanguages.remove(language);
                this.mDownloadEventManager.dispatchCanceled(language);
            } else {
                this.mDownloadProgressManager.cancelDownload(language);
                removeDownloadInfos(language);
            }
        }
    }

    private void removeDownloadInfos(Language language) {
        synchronized (this.mDownloadLock) {
            DownloadInfo downloadInfoRemove = this.mLanguageDownloadInfos.remove(language);
            if (downloadInfoRemove != null) {
                for (long j : downloadInfoRemove.getDownloadPendingIds()) {
                    this.mDownloadManager.remove(j);
                }
            }
        }
    }

    private String getRandomFileName() {
        StringBuilder sbAppend = new StringBuilder(com.myscript.atk.resourcemanager.internal.Constants.VO_PREFIX).append(UUID.randomUUID().toString().substring(0, 20)).append(System.currentTimeMillis());
        int i = this.mFileCounter + 1;
        this.mFileCounter = i;
        return sbAppend.append(i).toString();
    }

    private boolean isInvalidPath(String str) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split(File.separator);
        int length = strArrSplit.length;
        if (length > 4) {
            return true;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length - 1; i3++) {
            if (!strArrSplit[i3].equals("") && !strArrSplit[i3].equals(".")) {
                if (strArrSplit[i3].equals("..")) {
                    i++;
                    i2++;
                } else {
                    i--;
                }
            }
        }
        return i > 2 || i2 > 3;
    }
}
