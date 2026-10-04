package com.myscript.atk.resourcemanager.internal.bean;

import com.myscript.atk.resourcemanager.utils.Version;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class FilesParserResult {
    private FileInfo mConfInfo;
    private List<FileInfo> mFilesInfo = new ArrayList();
    private Version mVersion;

    public Version getVersion() {
        return this.mVersion;
    }

    public void setVersion(Version version) {
        this.mVersion = version;
    }

    public List<FileInfo> getFilesInfo() {
        return this.mFilesInfo;
    }

    public void setFilesInfo(List<FileInfo> list) {
        this.mFilesInfo = list;
    }

    public FileInfo getFileInfo(String str) {
        for (FileInfo fileInfo : this.mFilesInfo) {
            if (fileInfo.getFilename().endsWith(str)) {
                return fileInfo;
            }
        }
        return null;
    }

    public void setConfInfo(FileInfo fileInfo) {
        this.mConfInfo = fileInfo;
    }

    public FileInfo getConfInfo() {
        return this.mConfInfo;
    }
}
