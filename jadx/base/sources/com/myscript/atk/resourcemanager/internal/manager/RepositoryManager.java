package com.myscript.atk.resourcemanager.internal.manager;

import android.app.Application;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.internal.Constants;
import com.myscript.atk.resourcemanager.internal.bean.DownloadInfo;
import com.myscript.atk.resourcemanager.internal.bean.FileInfo;
import com.myscript.atk.resourcemanager.internal.bean.FilesParserResult;
import com.myscript.atk.resourcemanager.internal.helper.Md5Helper;
import com.myscript.atk.resourcemanager.internal.utils.FilesUtils;
import com.myscript.atk.resourcemanager.internal.utils.IOUtils;
import com.myscript.atk.resourcemanager.utils.FilesParser;
import com.myscript.atk.resourcemanager.utils.Latest;
import com.myscript.atk.resourcemanager.utils.LatestParser;
import com.myscript.atk.resourcemanager.utils.Version;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RepositoryManager {
    private static final String CONF_DIRNAME = "conf";
    public static final String FILES_INFO_FILENAME = "files.json";
    public static final String LATEST_FILENAME = "latest.json";
    public static final String PACKAGE_VER_FILENAME = "package.ver";
    public static final String RESOURCES_FILENAME = "resources.json";
    private static final String RESOURCE_DIRNAME = "resources";
    private static final String TAG = "RepositoryManager";
    public static final String TEMPO_SUFFIX = "rkljEFDS";
    private static final int TIMEOUT = 30000;
    private final Application mApplication;
    private final String mAssetsPath;
    private final File mFolder;
    private final Uri mHost;
    private Latest mLocalLatest;
    private Latest mRemoteLatest;
    private final String mRepoName;
    private List<Version> mVersions;
    private final Object mFolderLock = new Object();
    private boolean mUpdateResource = false;

    public RepositoryManager(Application application, String str, Uri uri, File file, String str2) {
        this.mApplication = application;
        this.mRepoName = str;
        this.mHost = uri;
        this.mFolder = file;
        this.mAssetsPath = str2;
    }

    public void remove(Language language) {
        String languageKey = language.getLanguageKey();
        synchronized (this.mFolderLock) {
            Iterator<Version> it = findLanguageVersions(languageKey).iterator();
            while (it.hasNext()) {
                File file = new File(this.mFolder, it.next().toString());
                File file2 = new File(file, CONF_DIRNAME);
                File file3 = new File(file, RESOURCE_DIRNAME);
                FilesUtils.delete(new File(file2, languageKey + Constants.CONF_FILENAME_EXT));
                FilesUtils.delete(new File(file3, languageKey));
            }
        }
    }

    public void remove(String str, Version version) {
        String string = version.toString();
        synchronized (this.mFolderLock) {
            File file = new File(this.mFolder, string);
            File file2 = new File(file, CONF_DIRNAME);
            File file3 = new File(file, RESOURCE_DIRNAME);
            FilesUtils.delete(new File(file2, str + Constants.CONF_FILENAME_EXT));
            FilesUtils.delete(new File(file3, str));
        }
    }

    public void removeAll() {
        synchronized (this.mFolderLock) {
            FilesUtils.delete(this.mFolder);
            this.mFolder.delete();
        }
    }

    public File getLocalFolder() {
        return this.mFolder;
    }

    public File getLatestFile() throws IOException {
        ensureLocalFolder();
        return new File(this.mFolder, LATEST_FILENAME);
    }

    private Version getLocalVersion() {
        return this.mLocalLatest.getVersion();
    }

    public Version getRemoteVersion() {
        Latest latest = this.mRemoteLatest;
        if (latest == null) {
            throw new IllegalStateException("No version found, try to call pull() before.");
        }
        return latest.getVersion();
    }

    public boolean contains(Language language) {
        if (this.mLocalLatest == null) {
            try {
                sync();
            } catch (IOException e) {
                Log.e(TAG, "Sync error", e);
                return false;
            }
        }
        return this.mLocalLatest.getLanguages().contains(language.getLanguageKey());
    }

    public void pull() throws IOException {
        InputStream inputStream = null;
        try {
            Uri.Builder builderBuildUpon = this.mHost.buildUpon();
            builderBuildUpon.appendPath(LATEST_FILENAME);
            URLConnection uRLConnectionOpenConnection = new URL(builderBuildUpon.build().toString()).openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(TIMEOUT);
            uRLConnectionOpenConnection.setReadTimeout(TIMEOUT);
            inputStream = uRLConnectionOpenConnection.getInputStream();
            String strStreamToString = IOUtils.streamToString(inputStream);
            IOUtils.write(strStreamToString, getLatestFile());
            this.mRemoteLatest = new LatestParser().parse(strStreamToString);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public List<FileInfo> getRemoteLanguageFilesInfo(String str) throws Throwable {
        if (this.mRemoteLatest == null) {
            pull();
        }
        List<FileInfo> arrayList = new ArrayList<>();
        InputStream inputStream = null;
        FileInfo confInfo = null;
        try {
            Uri.Builder builderBuildUpon = this.mHost.buildUpon();
            builderBuildUpon.appendPath(this.mRemoteLatest.getVersion().toString());
            builderBuildUpon.appendPath(RESOURCE_DIRNAME);
            builderBuildUpon.appendPath(str);
            Uri uriBuild = builderBuildUpon.build();
            builderBuildUpon.appendPath(FILES_INFO_FILENAME);
            Uri uriBuild2 = builderBuildUpon.build();
            URLConnection uRLConnectionOpenConnection = new URL(uriBuild2.toString()).openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(TIMEOUT);
            uRLConnectionOpenConnection.setReadTimeout(TIMEOUT);
            InputStream inputStream2 = uRLConnectionOpenConnection.getInputStream();
            try {
                String strStreamToString = IOUtils.streamToString(inputStream2);
                FilesParserResult filesParserResult = new FilesParser(uriBuild).parse(strStreamToString);
                if (filesParserResult != null) {
                    arrayList = filesParserResult.getFilesInfo();
                    confInfo = filesParserResult.getConfInfo();
                }
                IOUtils.closeQuietly(inputStream2);
                try {
                    arrayList.add(new FileInfo(FILES_INFO_FILENAME, Md5Helper.getMd5ForString(strStreamToString), strStreamToString.length(), uriBuild2));
                    if (confInfo != null) {
                        Uri.Builder builderBuildUpon2 = this.mHost.buildUpon();
                        builderBuildUpon2.appendPath(this.mRemoteLatest.getVersion().toString());
                        builderBuildUpon2.appendPath(CONF_DIRNAME);
                        builderBuildUpon2.appendPath(str + Constants.CONF_FILENAME_EXT);
                        arrayList.add(new FileInfo(confInfo.getFilename(), confInfo.getHash(), confInfo.getSize(), builderBuildUpon2.build()));
                    }
                    return arrayList;
                } catch (NoSuchAlgorithmException e) {
                    throw new IOException(e);
                }
            } catch (Throwable th) {
                th = th;
                inputStream = inputStream2;
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void sync() throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (this.mFolderLock) {
            ensureLocalFolder();
            try {
                fileInputStream = new FileInputStream(new File(this.mFolder, LATEST_FILENAME));
                try {
                    this.mLocalLatest = new LatestParser().parse(IOUtils.streamToString(fileInputStream));
                    this.mVersions = buildVersionsInfo(false);
                    IOUtils.closeQuietly(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        }
    }

    public List<String> getConfPaths() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mFolderLock) {
            List<Version> listBuildVersionsInfo = buildVersionsInfo(false);
            this.mVersions = listBuildVersionsInfo;
            for (int size = listBuildVersionsInfo.size(); size > 0; size--) {
                arrayList.add(new File(new File(this.mFolder, this.mVersions.get(size - 1).toString()), CONF_DIRNAME).getAbsolutePath());
            }
        }
        return arrayList;
    }

    public String getLatestPath() {
        synchronized (this.mFolderLock) {
            File file = new File(this.mFolder, LATEST_FILENAME);
            if (!file.isFile()) {
                return null;
            }
            return file.getAbsolutePath();
        }
    }

    public File getLanguageFolder(Version version, String str) {
        synchronized (this.mFolderLock) {
            File file = new File(this.mFolder, version.toString());
            if (!file.isDirectory()) {
                return null;
            }
            File file2 = new File(file, RESOURCE_DIRNAME);
            if (!file2.isDirectory()) {
                return null;
            }
            File file3 = new File(file2, str);
            if (file3.isDirectory()) {
                return file3;
            }
            return null;
        }
    }

    public File makeNewLanguageFolder(Version version, String str) {
        File file;
        synchronized (this.mFolderLock) {
            File file2 = new File(this.mFolder, version.toString());
            if (!file2.isDirectory()) {
                file2.mkdirs();
                file2.setReadable(true, false);
                file2.setWritable(true);
                file2.setExecutable(true, false);
            }
            File file3 = new File(file2, RESOURCE_DIRNAME);
            if (!file3.isDirectory()) {
                file3.mkdirs();
                file3.setReadable(true, false);
                file3.setWritable(true);
                file3.setExecutable(true, false);
            }
            file = new File(file3, str);
            if (!file.isDirectory()) {
                file.mkdirs();
                file.setReadable(true, false);
                file.setWritable(true);
                file.setExecutable(true, false);
            }
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7 A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:13:0x0024, B:14:0x002c, B:16:0x0032, B:18:0x0050, B:20:0x0053, B:22:0x0058, B:24:0x0064, B:26:0x0076, B:28:0x0090, B:30:0x00a7, B:31:0x00ac, B:33:0x00b2, B:38:0x00cc, B:42:0x00d4, B:43:0x00d7, B:44:0x00dc, B:46:0x00e2, B:49:0x00e7, B:51:0x00ed), top: B:56:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkRepositorySanity(File file) throws IOException {
        boolean z;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.getName().startsWith(Constants.VO_PREFIX)) {
                    FilesUtils.delete(file2);
                }
            }
        }
        synchronized (this.mFolderLock) {
            for (Version version : buildVersionsInfo(true)) {
                File file3 = new File(this.mFolder, version.toString());
                File file4 = new File(file3, CONF_DIRNAME);
                File[] fileArrListFiles2 = file4.listFiles();
                if (fileArrListFiles2 != null && fileArrListFiles2.length > 0) {
                    int i = 0;
                    for (File file5 : fileArrListFiles2) {
                        String langKeyFromConfFileName = getLangKeyFromConfFileName(file5.getName());
                        if (langKeyFromConfFileName != null) {
                            File file6 = new File(new File(file3, RESOURCE_DIRNAME), langKeyFromConfFileName);
                            if (file6.isDirectory()) {
                                FilesParser filesParser = new FilesParser(Uri.parse(file6.getAbsolutePath()));
                                File file7 = new File(file6, FILES_INFO_FILENAME);
                                if (file7.isFile()) {
                                    List<FileInfo> filesInfo = filesParser.parse(IOUtils.streamToString(new FileInputStream(file7))).getFilesInfo();
                                    if (filesInfo.isEmpty()) {
                                        z = false;
                                    } else {
                                        Iterator<FileInfo> it = filesInfo.iterator();
                                        z = true;
                                        while (it.hasNext()) {
                                            if (!new File(file6, it.next().getFilename()).isFile()) {
                                                z = false;
                                            }
                                        }
                                    }
                                    if (z) {
                                        i++;
                                    }
                                } else {
                                    z = false;
                                }
                            }
                        } else {
                            z = true;
                        }
                        if (!z) {
                            remove(langKeyFromConfFileName, version);
                        }
                    }
                    String[] list = file4.list();
                    if (list == null || list.length == 0 || i == 0) {
                    }
                } else {
                    FilesUtils.delete(file3);
                }
            }
        }
    }

    public void onDownloadSuccess(Language language, DownloadInfo downloadInfo) throws NoSuchAlgorithmException, IOException {
        String languageKey = language.getLanguageKey();
        synchronized (this.mFolderLock) {
            moveConfFile(downloadInfo, languageKey);
            for (Version version : findLanguageVersions(languageKey)) {
                if (version.compareTo(getLocalVersion()) < 0) {
                    remove(languageKey, version);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:7:0x0017, B:9:0x0038, B:14:0x0048, B:15:0x006a, B:17:0x0070, B:19:0x007c, B:32:0x00f2, B:20:0x007f, B:22:0x008a, B:23:0x0096, B:25:0x009f, B:27:0x00c2, B:29:0x00d7, B:34:0x00f4, B:35:0x010a, B:30:0x00e8, B:26:0x00bf, B:12:0x003e), top: B:39:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:7:0x0017, B:9:0x0038, B:14:0x0048, B:15:0x006a, B:17:0x0070, B:19:0x007c, B:32:0x00f2, B:20:0x007f, B:22:0x008a, B:23:0x0096, B:25:0x009f, B:27:0x00c2, B:29:0x00d7, B:34:0x00f4, B:35:0x010a, B:30:0x00e8, B:26:0x00bf, B:12:0x003e), top: B:39:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:7:0x0017, B:9:0x0038, B:14:0x0048, B:15:0x006a, B:17:0x0070, B:19:0x007c, B:32:0x00f2, B:20:0x007f, B:22:0x008a, B:23:0x0096, B:25:0x009f, B:27:0x00c2, B:29:0x00d7, B:34:0x00f4, B:35:0x010a, B:30:0x00e8, B:26:0x00bf, B:12:0x003e), top: B:39:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d7 A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:7:0x0017, B:9:0x0038, B:14:0x0048, B:15:0x006a, B:17:0x0070, B:19:0x007c, B:32:0x00f2, B:20:0x007f, B:22:0x008a, B:23:0x0096, B:25:0x009f, B:27:0x00c2, B:29:0x00d7, B:34:0x00f4, B:35:0x010a, B:30:0x00e8, B:26:0x00bf, B:12:0x003e), top: B:39:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8 A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:7:0x0017, B:9:0x0038, B:14:0x0048, B:15:0x006a, B:17:0x0070, B:19:0x007c, B:32:0x00f2, B:20:0x007f, B:22:0x008a, B:23:0x0096, B:25:0x009f, B:27:0x00c2, B:29:0x00d7, B:34:0x00f4, B:35:0x010a, B:30:0x00e8, B:26:0x00bf, B:12:0x003e), top: B:39:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4 A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:7:0x0017, B:9:0x0038, B:14:0x0048, B:15:0x006a, B:17:0x0070, B:19:0x007c, B:32:0x00f2, B:20:0x007f, B:22:0x008a, B:23:0x0096, B:25:0x009f, B:27:0x00c2, B:29:0x00d7, B:34:0x00f4, B:35:0x010a, B:30:0x00e8, B:26:0x00bf, B:12:0x003e), top: B:39:0x0017, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processEachFileDownload(DownloadInfo downloadInfo, long j) throws NoSuchAlgorithmException, IOException {
        boolean zRenameTo;
        File parentFile;
        boolean zCheckHash;
        File destinationFile = downloadInfo.getDestinationFile(j);
        if (destinationFile.getName().endsWith(Constants.CONF_FILENAME_EXT)) {
            return;
        }
        synchronized (this.mFolderLock) {
            File localFile = downloadInfo.getLocalFile(j);
            try {
                zRenameTo = localFile.renameTo(new File(localFile.getAbsolutePath() + TEMPO_SUFFIX));
            } catch (SecurityException e) {
                Log.e(TAG, "processEachFileDownload - renameTo failed by SecurityException : ", e);
                zRenameTo = false;
            }
            if (!zRenameTo) {
                Log.d(getTag(), "processEachFileDownload - renameTo failed in id: " + j + " filename: " + localFile.getAbsolutePath());
            }
            if (destinationFile.isFile()) {
                if (!destinationFile.getName().startsWith("../")) {
                    FilesUtils.delete(destinationFile);
                    parentFile = destinationFile.getParentFile();
                    if (!parentFile.isDirectory()) {
                    }
                    destinationFile.createNewFile();
                    File localFile2 = downloadInfo.getLocalFile(j);
                    if (!zRenameTo) {
                    }
                    destinationFile.setReadable(true, false);
                    destinationFile.setWritable(true);
                    destinationFile.setExecutable(true, false);
                    if (!destinationFile.getName().endsWith(FILES_INFO_FILENAME)) {
                    }
                    if (!zCheckHash) {
                    }
                }
            } else {
                parentFile = destinationFile.getParentFile();
                if (!parentFile.isDirectory()) {
                    parentFile.mkdirs();
                    parentFile.setReadable(true, false);
                    parentFile.setWritable(true);
                    parentFile.setExecutable(true, false);
                }
                destinationFile.createNewFile();
                File localFile22 = downloadInfo.getLocalFile(j);
                if (!zRenameTo) {
                    FilesUtils.move(new File(localFile22.getAbsolutePath() + TEMPO_SUFFIX), destinationFile);
                } else {
                    FilesUtils.move(localFile22, destinationFile);
                }
                destinationFile.setReadable(true, false);
                destinationFile.setWritable(true);
                destinationFile.setExecutable(true, false);
                if (!destinationFile.getName().endsWith(FILES_INFO_FILENAME)) {
                    zCheckHash = downloadInfo.getFileHash(j).equals(Md5Helper.getMd5ForString(IOUtils.fileToString(destinationFile)));
                } else {
                    zCheckHash = checkHash(destinationFile, downloadInfo.getFileHash(j));
                }
                if (!zCheckHash) {
                    destinationFile.delete();
                    throw new IllegalStateException(String.format("Checksum check failed, file corrupted: %s", destinationFile.getName()));
                }
            }
        }
    }

    private void moveConfFile(DownloadInfo downloadInfo, String str) throws Throwable {
        Iterator<Long> it = downloadInfo.getDownloadIds(str).iterator();
        long j = 0;
        File file = null;
        boolean zRenameTo = false;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            File destinationFile = downloadInfo.getDestinationFile(jLongValue);
            if (destinationFile.getName().endsWith(Constants.CONF_FILENAME_EXT)) {
                if (destinationFile.isFile()) {
                    Log.d(getTag(), "moveConfFile : STRANGE!! Why conf file is already existing? : " + jLongValue + " filename: " + destinationFile.getAbsolutePath());
                    FilesUtils.delete(destinationFile);
                }
                File localFile = downloadInfo.getLocalFile(jLongValue);
                try {
                    zRenameTo = localFile.renameTo(new File(localFile.getAbsolutePath() + TEMPO_SUFFIX));
                } catch (SecurityException e) {
                    Log.e(TAG, "moveConfFile - renameTo failed by SecurityException : ", e);
                    zRenameTo = false;
                }
                if (!zRenameTo) {
                    Log.d(getTag(), "moveConfFile : Conf file renameTo failed id: " + jLongValue + " filename: " + localFile.getAbsolutePath());
                }
                file = destinationFile;
                j = jLongValue;
            } else if (!destinationFile.isFile()) {
                throw new IllegalStateException(String.format("moveConfFile : Error!! Can not find %s from the repository", destinationFile.getName()));
            }
        }
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.isDirectory()) {
                parentFile.mkdirs();
                parentFile.setReadable(true, false);
                parentFile.setWritable(true);
                parentFile.setExecutable(true, false);
            }
            file.createNewFile();
            File localFile2 = downloadInfo.getLocalFile(j);
            if (zRenameTo) {
                FilesUtils.move(new File(localFile2.getAbsolutePath() + TEMPO_SUFFIX), file);
            } else {
                FilesUtils.move(localFile2, file);
            }
            file.setReadable(true, false);
            file.setWritable(true);
            file.setExecutable(true, false);
            if (checkHash(file, downloadInfo.getFileHash(j))) {
                return;
            }
            file.delete();
            throw new IllegalStateException(String.format("File corrupted : %s", file.getName()));
        }
        throw new IllegalStateException("moveConfFile : Error!! Can not find conf file from the download information");
    }

    public boolean isFirstDownloadOfVersion() throws IOException {
        File[] fileArrListFiles;
        if (this.mRemoteLatest == null) {
            pull();
        }
        File file = new File(this.mFolder, this.mRemoteLatest.getVersion().toString());
        File file2 = new File(file, CONF_DIRNAME);
        synchronized (this.mFolderLock) {
            if (file.isDirectory() && file2.isDirectory()) {
                File[] fileArrListFiles2 = file2.listFiles();
                if (fileArrListFiles2 != null) {
                    for (File file3 : fileArrListFiles2) {
                        if (file3.getName().endsWith(Constants.CONF_FILENAME_EXT)) {
                            return false;
                        }
                    }
                }
                if (fileArrListFiles2 != null) {
                    File file4 = new File(file, Constants.MUL);
                    if (file4.isDirectory() && (fileArrListFiles = file4.listFiles()) != null && fileArrListFiles.length > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private boolean checkHash(File file, String str) throws NoSuchAlgorithmException, IOException {
        return Md5Helper.getMd5(new FileInputStream(file)).equals(str);
    }

    public Language updateLanguage(Language language) throws IOException {
        Boolean boolValueOf;
        Language languageCopy;
        sync();
        synchronized (this.mFolderLock) {
            String languageKey = language.getLanguageKey();
            Version versionFindLatestLanguageVersion = findLatestLanguageVersion(languageKey);
            boolean zIsAvailable = isAvailable(languageKey, versionFindLatestLanguageVersion, getLanguageFilesInfo(languageKey, versionFindLatestLanguageVersion).getFilesInfo());
            if (versionFindLatestLanguageVersion == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(versionFindLatestLanguageVersion.compareTo(getLocalVersion()) >= 0);
            }
            languageCopy = language.copy(languageKey, language.getDisplayName(), zIsAvailable, boolValueOf);
        }
        return languageCopy;
    }

    private Version findLatestLanguageVersion(String str) {
        if (this.mVersions == null) {
            this.mVersions = buildVersionsInfo(false);
        }
        for (int size = this.mVersions.size(); size > 0; size--) {
            Version version = this.mVersions.get(size - 1);
            if (new File(new File(new File(this.mFolder, version.toString()), CONF_DIRNAME), str + Constants.CONF_FILENAME_EXT).isFile()) {
                return version;
            }
        }
        return null;
    }

    private boolean isAvailable(String str, Version version, List<FileInfo> list) {
        if (str == null || version == null || list == null) {
            return false;
        }
        File file = new File(new File(new File(this.mFolder, version.toString()), RESOURCE_DIRNAME), str);
        if (list.isEmpty()) {
            return false;
        }
        Iterator<FileInfo> it = list.iterator();
        boolean zIsFile = true;
        while (it.hasNext()) {
            zIsFile &= new File(file, it.next().getFilename()).isFile();
        }
        return zIsFile;
    }

    private List<Version> buildVersionsInfo(boolean z) {
        ArrayList arrayList = new ArrayList();
        String[] list = this.mFolder.list();
        if (list != null) {
            for (String str : list) {
                File file = new File(this.mFolder, str);
                if (file.isDirectory()) {
                    try {
                        Version version = new Version(str);
                        File file2 = new File(file, CONF_DIRNAME);
                        if (file2.isDirectory()) {
                            File[] fileArrListFiles = file2.listFiles();
                            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                                arrayList.add(version);
                            } else if (z && fileArrListFiles != null) {
                                arrayList.add(version);
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                        Log.w(getTag(), "buildVersionsInfo : failed in adding version : " + str);
                    }
                }
            }
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    private FilesParserResult getLanguageFilesInfo(String str, Version version) throws IOException {
        ensureLocalFolder();
        FilesParserResult filesParserResult = new FilesParserResult();
        if (str != null && version != null) {
            File file = new File(new File(new File(this.mFolder, version.toString()), RESOURCE_DIRNAME), str);
            if (file.isDirectory()) {
                FilesParser filesParser = new FilesParser(Uri.parse(file.getAbsolutePath()));
                File file2 = new File(file, FILES_INFO_FILENAME);
                if (file2.isFile()) {
                    return filesParser.parse(IOUtils.streamToString(new FileInputStream(file2)));
                }
            }
        }
        return filesParserResult;
    }

    private void ensureLocalFolder() throws IOException {
        Map<String, Version> remainedLanguageList;
        synchronized (this.mFolderLock) {
            File file = new File(this.mFolder, LATEST_FILENAME);
            if (!this.mFolder.isDirectory() || !file.isFile() || this.mUpdateResource) {
                if (this.mFolder.isDirectory()) {
                    remainedLanguageList = getRemainedLanguageList();
                } else {
                    if (this.mFolder.isDirectory()) {
                        FilesUtils.delete(this.mFolder);
                    }
                    if (!this.mFolder.isDirectory() && !this.mFolder.mkdirs()) {
                        throw new UnknownError("Can't create folder " + this.mFolder.getAbsolutePath());
                    }
                    remainedLanguageList = null;
                }
                new AssetsLanguagesManager(this.mApplication.getAssets(), this).copyAssets(this.mAssetsPath, this.mFolder, remainedLanguageList);
                if (file.isFile()) {
                    File file2 = new File(file.getAbsolutePath() + Constants.ASSET_LATEST_EXTENSION);
                    FilesUtils.copy(file, file2);
                    file2.setReadable(true, false);
                    file2.setWritable(true);
                    file2.setExecutable(true, false);
                }
                this.mUpdateResource = false;
            }
        }
    }

    private String getTag() {
        return "RepositoryManager:" + this.mRepoName;
    }

    public String toString() {
        return String.format("RepositoryManager{%s, %s, %s}", this.mFolder, this.mRepoName, this.mHost);
    }

    private String getLangKeyFromConfFileName(String str) {
        if (str != null && str.endsWith(Constants.CONF_FILENAME_EXT)) {
            try {
                String[] strArrSplit = str.split("\\.");
                if (strArrSplit.length == 2) {
                    return strArrSplit[0];
                }
                return null;
            } catch (Exception e) {
                Log.e(TAG, "Something went wrong while parsing filename " + str, e);
            }
        }
        return null;
    }

    public List<Version> findLanguageVersions(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.mVersions == null) {
            this.mVersions = buildVersionsInfo(false);
        }
        for (Version version : this.mVersions) {
            if (new File(new File(new File(this.mFolder, version.toString()), CONF_DIRNAME), str + Constants.CONF_FILENAME_EXT).isFile()) {
                arrayList.add(version);
            }
        }
        return arrayList;
    }

    public void checkPackageVersion(File file) {
        Version version;
        synchronized (this.mFolderLock) {
            File file2 = new File(file, PACKAGE_VER_FILENAME);
            Version version2 = null;
            if (!file2.isFile()) {
                try {
                    version2 = new Version(this.mApplication.getPackageManager().getPackageInfo(this.mApplication.getPackageName(), 0).versionName);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(getTag(), "checkPackageVersion : Failed to retrieve package info : " + e);
                } catch (IllegalArgumentException e2) {
                    Log.e(getTag(), "checkPackageVersion : Error on package version : " + e2);
                }
                if (version2 != null) {
                    File file3 = new File(file, PACKAGE_VER_FILENAME);
                    IOUtils.write(version2.toString(), file3);
                    file3.setReadable(true, false);
                }
                this.mUpdateResource = true;
            } else {
                try {
                    version = new Version(this.mApplication.getPackageManager().getPackageInfo(this.mApplication.getPackageName(), 0).versionName);
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    version = null;
                } catch (IllegalArgumentException e4) {
                    e = e4;
                    version = null;
                }
                try {
                    String str = IOUtils.read(file2);
                    if (str != null) {
                        version2 = new Version(str);
                    }
                } catch (PackageManager.NameNotFoundException e5) {
                    e = e5;
                    Log.e(getTag(), "checkPackageVersion : Failed to retrieve package info : " + e);
                } catch (IllegalArgumentException e6) {
                    e = e6;
                    Log.e(getTag(), "checkPackageVersion : Error on package version : " + e);
                }
                if (version2 != null) {
                    this.mUpdateResource = version.compareTo(version2) > 0;
                } else {
                    this.mUpdateResource = true;
                }
                if (version != null) {
                    FilesUtils.delete(file2);
                    File file4 = new File(file, PACKAGE_VER_FILENAME);
                    IOUtils.write(version.toString(), file4);
                    file4.setReadable(true, false);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0073 A[Catch: all -> 0x014f, TryCatch #1 {, blocks: (B:4:0x000f, B:6:0x0017, B:8:0x001b, B:10:0x002a, B:12:0x003c, B:14:0x0042, B:16:0x0045, B:19:0x0063, B:18:0x0049, B:20:0x0066, B:21:0x0069, B:22:0x006d, B:24:0x0073, B:26:0x0091, B:28:0x0094, B:30:0x0099, B:32:0x00a5, B:34:0x00b7, B:36:0x00d1, B:38:0x00e8, B:39:0x00ed, B:41:0x00f3, B:48:0x0113, B:50:0x011d, B:51:0x0120, B:55:0x012d, B:56:0x0130, B:57:0x0136, B:59:0x013e, B:64:0x0146, B:66:0x014d), top: B:73:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<String, Version> getRemainedLanguageList() throws IOException {
        Iterator it;
        Iterator it2;
        Iterator it3;
        boolean z;
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        synchronized (this.mFolderLock) {
            String[] list = this.mFolder.list();
            if (list != null) {
                for (String str : list) {
                    File file = new File(this.mFolder, str);
                    if (file.isDirectory()) {
                        try {
                            Version version = new Version(str);
                            File file2 = new File(file, CONF_DIRNAME);
                            if (file2.isDirectory() && (fileArrListFiles = file2.listFiles()) != null && fileArrListFiles.length > 0) {
                                arrayList.add(version);
                            }
                        } catch (IllegalArgumentException unused) {
                            Log.w(getTag(), "getRemainedLanguageList : failed in adding version : " + str);
                        }
                    }
                }
                Collections.sort(arrayList);
                it = arrayList.iterator();
                while (it.hasNext()) {
                    Version version2 = (Version) it.next();
                    File file3 = new File(this.mFolder, version2.toString());
                    File file4 = new File(file3, CONF_DIRNAME);
                    File[] fileArrListFiles2 = file4.listFiles();
                    if (fileArrListFiles2 == null || fileArrListFiles2.length <= 0) {
                        it2 = it;
                    } else {
                        int length = fileArrListFiles2.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            String langKeyFromConfFileName = getLangKeyFromConfFileName(fileArrListFiles2[i].getName());
                            if (langKeyFromConfFileName != null) {
                                File file5 = new File(new File(file3, RESOURCE_DIRNAME), langKeyFromConfFileName);
                                if (file5.isDirectory()) {
                                    FilesParser filesParser = new FilesParser(Uri.parse(file5.getAbsolutePath()));
                                    File file6 = new File(file5, FILES_INFO_FILENAME);
                                    if (file6.isFile()) {
                                        List<FileInfo> filesInfo = filesParser.parse(IOUtils.streamToString(new FileInputStream(file6))).getFilesInfo();
                                        if (filesInfo.isEmpty()) {
                                            z = false;
                                        } else {
                                            Iterator<FileInfo> it4 = filesInfo.iterator();
                                            z = true;
                                            while (it4.hasNext()) {
                                                Iterator it5 = it;
                                                if (!new File(file5, it4.next().getFilename()).isFile()) {
                                                    z = false;
                                                }
                                                it = it5;
                                            }
                                        }
                                        it3 = it;
                                        if (z) {
                                            i2++;
                                            Version version3 = (Version) map.get(langKeyFromConfFileName);
                                            if (version3 != null) {
                                                remove(langKeyFromConfFileName, version3);
                                            }
                                            map.put(langKeyFromConfFileName, version2);
                                        }
                                    } else {
                                        it3 = it;
                                        z = false;
                                    }
                                }
                            } else {
                                it3 = it;
                                z = true;
                            }
                            if (!z) {
                                remove(langKeyFromConfFileName, version2);
                            }
                            i++;
                            it = it3;
                        }
                        it2 = it;
                        String[] list2 = file4.list();
                        if (list2 == null || list2.length == 0 || i2 == 0) {
                        }
                        it = it2;
                    }
                    FilesUtils.delete(file3);
                    it = it2;
                }
            } else {
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
            }
        }
        return map;
    }
}
