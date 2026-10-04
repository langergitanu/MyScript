package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Sound extends Markup {
    public static final int e_Mic = 1;
    public static final int e_Speaker = 0;
    public static final int e_Unknown = 2;

    static native long Create(long j, long j2);

    static native long CreateWithData(long j, long j2, long j3, int i, int i2, int i3);

    static native int GetIcon(long j);

    static native String GetIconName(long j);

    static native long GetSoundStream(long j);

    static native void SetIcon(long j, int i);

    static native void SetIcon(long j, String str);

    static native void SetSoundStream(long j, long j2);

    public Sound(Obj obj) {
        super(obj);
    }

    public Sound() {
    }

    private Sound(long j, Object obj) {
        super(j, obj);
    }

    public Sound(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Sound create(Doc doc, Rect rect) throws PDFNetException {
        Sound sound = new Sound(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return sound;
    }

    public static Sound createWithData(Doc doc, Rect rect, Filter filter, int i, int i2, int i3) throws PDFNetException {
        Sound sound = new Sound(CreateWithData(doc.__GetHandle(), rect.__GetHandle(), filter.__GetHandle(), i, i2, i3), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(filter);
        return sound;
    }

    public Obj getSoundStream() throws PDFNetException {
        return Obj.__Create(GetSoundStream(__GetHandle()), __GetRefHandle());
    }

    public void setSoundStream(Obj obj) throws PDFNetException {
        SetSoundStream(__GetHandle(), obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
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

    public void setIcon(String str) throws PDFNetException {
        SetIcon(__GetHandle(), str);
    }
}
