package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.FileSpec;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class FileAttachment extends Markup {
    public static final int e_Graph = 0;
    public static final int e_Paperclip = 2;
    public static final int e_PushPin = 1;
    public static final int e_Tag = 3;
    public static final int e_Unknown = 4;

    static native long Create(long j, long j2, String str);

    static native long Create(long j, long j2, String str, String str2);

    static native void Export(long j);

    static native void Export(long j, String str);

    static native long GetFileSpec(long j);

    static native int GetIcon(long j);

    static native String GetIconName(long j);

    static native void SetFileSpec(long j, long j2);

    static native void SetIcon(long j, int i);

    static native void SetIconName(long j, String str);

    public FileAttachment(Obj obj) {
        super(obj);
    }

    public FileAttachment() {
    }

    private FileAttachment(long j, Object obj) {
        super(j, obj);
    }

    public FileAttachment(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static FileAttachment create(Doc doc, Rect rect, String str, String str2) throws PDFNetException {
        FileAttachment fileAttachment = new FileAttachment(Create(doc.__GetHandle(), rect.__GetHandle(), str, str2), doc);
        ReachabilityHelper.ensureReachable(rect);
        return fileAttachment;
    }

    public static FileAttachment create(Doc doc, Rect rect, String str) throws PDFNetException {
        FileAttachment fileAttachment = new FileAttachment(Create(doc.__GetHandle(), rect.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(rect);
        return fileAttachment;
    }

    public void export(String str) throws PDFNetException {
        Export(__GetHandle(), str);
    }

    public void export() throws PDFNetException {
        Export(__GetHandle());
    }

    public FileSpec getFileSpec() throws PDFNetException {
        return FileSpec.__Create(GetFileSpec(__GetHandle()), __GetRefHandle());
    }

    public void SetFileSpec(FileSpec fileSpec) throws PDFNetException {
        SetFileSpec(__GetHandle(), fileSpec.__GetHandle());
    }

    public int getIcon() throws PDFNetException {
        return GetIcon(__GetHandle());
    }

    public void setIcon(int i) throws PDFNetException {
        SetIcon(__GetHandle(), i);
    }

    public String getIconName() throws PDFNetException {
        return GetIconName(__GetHandle());
    }

    public void SetIconName(String str) throws PDFNetException {
        SetIconName(__GetHandle(), str);
    }
}
