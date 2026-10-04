package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public interface IZipArchiver {
    boolean addFile(String str, String str2, String str3);

    boolean closeArchive(String str);

    boolean extractEntry(String str, String str2, String str3);

    String[] listEntries(String str);
}
