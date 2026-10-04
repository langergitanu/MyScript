package com.myscript.snt.core;

import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class FileUtils {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FileUtils(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(FileUtils fileUtils) {
        if (fileUtils == null) {
            return 0L;
        }
        return fileUtils.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_FileUtils(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String separator() {
        return new String(NeboEngineJNI.FileUtils_separator__SWIG_0(), StandardCharsets.UTF_8);
    }

    public static String unix_separator() {
        return new String(NeboEngineJNI.FileUtils_unix_separator(), StandardCharsets.UTF_8);
    }

    public static String win_separator() {
        return new String(NeboEngineJNI.FileUtils_win_separator(), StandardCharsets.UTF_8);
    }

    public static String separator(String str) {
        return new String(NeboEngineJNI.FileUtils_separator__SWIG_1(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String addDotAtFileExtension(String str) {
        return new String(NeboEngineJNI.FileUtils_addDotAtFileExtension(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String addSlashAtEndOfPath(String str, String str2) {
        return new String(NeboEngineJNI.FileUtils_addSlashAtEndOfPath__SWIG_0(str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public static String addSlashAtEndOfPath(String str) {
        return new String(NeboEngineJNI.FileUtils_addSlashAtEndOfPath__SWIG_1(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String removeSlashAtBeginningOfPath(String str) {
        return new String(NeboEngineJNI.FileUtils_removeSlashAtBeginningOfPath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String removeSlashesAtBeginingAndEnd(String str) {
        return new String(NeboEngineJNI.FileUtils_removeSlashesAtBeginingAndEnd(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String addSlashAtBeginningOfPath(String str) {
        return new String(NeboEngineJNI.FileUtils_addSlashAtBeginningOfPath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String removeSlashAtEndOfPath(String str) {
        return new String(NeboEngineJNI.FileUtils_removeSlashAtEndOfPath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String replaceWinSeparatorFromPath(String str) {
        return new String(NeboEngineJNI.FileUtils_replaceWinSeparatorFromPath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static boolean isAbsolutePath(String str) {
        return NeboEngineJNI.FileUtils_isAbsolutePath(str.getBytes());
    }

    public static String relativePathFromAbsolute(String str, String str2) {
        return new String(NeboEngineJNI.FileUtils_relativePathFromAbsolute(str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public static String absolutePath(String str) {
        return new String(NeboEngineJNI.FileUtils_absolutePath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String fileNameFromFullPath(String str) {
        return new String(NeboEngineJNI.FileUtils_fileNameFromFullPath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String parentFolder(String str) {
        return new String(NeboEngineJNI.FileUtils_parentFolder(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String fileDisplayNameFromPath(String str) {
        return new String(NeboEngineJNI.FileUtils_fileDisplayNameFromPath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String relativePath(String str, String str2) {
        return new String(NeboEngineJNI.FileUtils_relativePath(str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public static String appendPaths(String str, String str2) {
        return new String(NeboEngineJNI.FileUtils_appendPaths(str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public static boolean createFolders(String str) {
        return NeboEngineJNI.FileUtils_createFolders(str.getBytes());
    }

    public static String convertPathToUnixPath(String str) {
        return new String(NeboEngineJNI.FileUtils_convertPathToUnixPath(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String temporaryPath(long j) {
        return new String(NeboEngineJNI.FileUtils_temporaryPath__SWIG_0(j), StandardCharsets.UTF_8);
    }

    public static String temporaryPath(String str) {
        return new String(NeboEngineJNI.FileUtils_temporaryPath__SWIG_1(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String temporaryPath() {
        return new String(NeboEngineJNI.FileUtils_temporaryPath__SWIG_2(), StandardCharsets.UTF_8);
    }

    public static String fileNameWithoutExtension(String str) {
        return new String(NeboEngineJNI.FileUtils_fileNameWithoutExtension(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String extensionFromPath(String str, boolean z) {
        return new String(NeboEngineJNI.FileUtils_extensionFromPath__SWIG_0(str.getBytes(), z), StandardCharsets.UTF_8);
    }

    public static String extensionFromPath(String str) {
        return new String(NeboEngineJNI.FileUtils_extensionFromPath__SWIG_1(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static boolean hasExtension(String str) {
        return NeboEngineJNI.FileUtils_hasExtension(str.getBytes());
    }

    public static long fileSize(String str) {
        return NeboEngineJNI.FileUtils_fileSize(str.getBytes());
    }

    public static boolean isFileExists(String str) {
        return NeboEngineJNI.FileUtils_isFileExists(str.getBytes());
    }

    public static List<String> findFiles(String str, String str2) {
        return new SWIGVectorString(NeboEngineJNI.FileUtils_findFiles(str.getBytes(), str2.getBytes()), true);
    }

    public static boolean renameFile(String str, String str2) {
        return NeboEngineJNI.FileUtils_renameFile(str.getBytes(), str2.getBytes());
    }

    public static boolean removeFile(String str) {
        return NeboEngineJNI.FileUtils_removeFile(str.getBytes());
    }

    public static boolean removeFiles(String str, String str2) {
        return NeboEngineJNI.FileUtils_removeFiles(str.getBytes(), str2.getBytes());
    }

    public static boolean removeFolder(String str) {
        return NeboEngineJNI.FileUtils_removeFolder(str.getBytes());
    }

    public static String sha256(String str) {
        return new String(NeboEngineJNI.FileUtils_sha256(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static boolean copyFile(String str, String str2) {
        return NeboEngineJNI.FileUtils_copyFile(str.getBytes(), str2.getBytes());
    }

    public static boolean endsWith(String str, String str2) {
        return NeboEngineJNI.FileUtils_endsWith(str.getBytes(), str2.getBytes());
    }

    public static String readFile(String str) {
        return new String(NeboEngineJNI.FileUtils_readFile(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static boolean writeFile(String str, String str2) {
        return NeboEngineJNI.FileUtils_writeFile(str.getBytes(), str2.getBytes());
    }

    public FileUtils() {
        this(NeboEngineJNI.new_FileUtils(), true);
    }
}
