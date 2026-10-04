package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Field extends AbstractC6968g implements AutoCloseable {
    public static final int e_action_trigger_calculate = 16;
    public static final int e_action_trigger_format = 14;
    public static final int e_action_trigger_keystroke = 13;
    public static final int e_action_trigger_validate = 15;
    public static final int e_button = 0;
    public static final int e_centered = 1;
    public static final int e_check = 1;
    public static final int e_choice = 4;
    public static final int e_comb = 12;
    public static final int e_combo = 14;
    public static final int e_commit_on_sel_change = 18;
    public static final int e_edit = 15;
    public static final int e_file_select = 9;
    public static final int e_left_justified = 0;
    public static final int e_multiline = 7;
    public static final int e_multiselect = 17;
    public static final int e_no_export = 2;
    public static final int e_no_scroll = 11;
    public static final int e_no_spellcheck = 10;
    public static final int e_null = 6;
    public static final int e_password = 8;
    public static final int e_pushbutton_flag = 3;
    public static final int e_radio = 2;
    public static final int e_radio_flag = 4;
    public static final int e_radios_in_unison = 6;
    public static final int e_read_only = 0;
    public static final int e_required = 1;
    public static final int e_rich_text = 13;
    public static final int e_right_justified = 2;
    public static final int e_signature = 5;
    public static final int e_sort = 16;
    public static final int e_text = 3;
    public static final int e_toggle_to_off = 5;

    /* JADX INFO: renamed from: a */
    long f1541a;

    /* JADX INFO: renamed from: d */
    private Object f1542d;

    static native void Destroy(long j);

    static native void EraseAppearance(long j);

    static native long FieldCreate(long j);

    static native long FindInheritedAttribute(long j, String str);

    static native void Flatten(long j, long j2);

    static native long GetDefaultAppearance(long j);

    static native long GetDefaultValue(long j);

    static native String GetDefaultValueAsString(long j);

    static native boolean GetFlag(long j, int i);

    static native int GetJustification(long j);

    static native int GetMaxLen(long j);

    static native String GetName(long j);

    static native String GetOpt(long j, int i);

    static native int GetOptCount(long j);

    static native String GetPartialName(long j);

    static native long GetSDFObj(long j);

    static native long GetTriggerAction(long j, int i);

    static native int GetType(long j);

    static native long GetUpdateRect(long j);

    static native long GetValue(long j);

    static native boolean GetValueAsBool(long j);

    static native String GetValueAsString(long j);

    static native boolean IsAnnot(long j);

    static native boolean IsLockedByDigitalSignature(long j);

    static native boolean IsValid(long j);

    static native void RefreshAppearance(long j);

    static native void Rename(long j, String str);

    static native void SetFlag(long j, int i, boolean z);

    static native void SetJustification(long j, int i);

    static native void SetMaxLen(long j, int i);

    static native long SetValue(long j, long j2);

    static native long SetValue(long j, String str);

    static native long SetValue(long j, boolean z);

    static native long UseSignatureHandler(long j, long j2);

    public Field(Obj obj) throws PDFNetException {
        this.f1541a = FieldCreate(obj.__GetHandle());
        this.f1542d = obj.__GetRefHandle();
        clearList();
    }

    @Override // com.pdftron.pdf.AbstractC6968g, com.pdftron.pdf.__Delete
    public void destroy() throws PDFNetException {
        long j = this.f1541a;
        if (j == 0 || (this.f1542d instanceof FieldIterator)) {
            return;
        }
        Destroy(j);
        this.f1541a = 0L;
    }

    @Override // com.pdftron.pdf.AbstractC6968g
    protected void finalize() throws Throwable {
        destroy();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1541a);
    }

    public Obj getTriggerAction(int i) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.f1541a, i), this.f1542d);
    }

    public int getType() throws PDFNetException {
        return GetType(this.f1541a);
    }

    public Obj getValue() throws PDFNetException {
        return Obj.__Create(GetValue(this.f1541a), this.f1542d);
    }

    public String getValueAsString() throws PDFNetException {
        return GetValueAsString(this.f1541a);
    }

    public boolean getValueAsBool() throws PDFNetException {
        return GetValueAsBool(this.f1541a);
    }

    public ViewChangeCollection setValue(Obj obj) throws PDFNetException {
        ViewChangeCollection viewChangeCollection = new ViewChangeCollection(SetValue(this.f1541a, obj.__GetHandle()));
        ReachabilityHelper.ensureReachable(obj);
        return viewChangeCollection;
    }

    public ViewChangeCollection setValue(String str) throws PDFNetException {
        return new ViewChangeCollection(SetValue(this.f1541a, str));
    }

    public ViewChangeCollection setValue(boolean z) throws PDFNetException {
        return new ViewChangeCollection(SetValue(this.f1541a, z));
    }

    public void refreshAppearance() throws PDFNetException {
        RefreshAppearance(this.f1541a);
    }

    public void eraseAppearance() throws PDFNetException {
        EraseAppearance(this.f1541a);
    }

    public Obj getDefaultValue() throws PDFNetException {
        return Obj.__Create(GetDefaultValue(this.f1541a), this.f1542d);
    }

    public GState getDefaultAppearance() throws PDFNetException {
        return new GState(GetDefaultAppearance(this.f1541a), this.f1542d, null);
    }

    public String getDefaultValueAsString() throws PDFNetException {
        return GetDefaultValueAsString(this.f1541a);
    }

    public String getName() throws PDFNetException {
        return GetName(this.f1541a);
    }

    public String getPartialName() throws PDFNetException {
        return GetPartialName(this.f1541a);
    }

    public void rename(String str) throws PDFNetException {
        Rename(this.f1541a, str);
    }

    public boolean isAnnot() throws PDFNetException {
        return IsAnnot(this.f1541a);
    }

    public boolean getFlag(int i) throws PDFNetException {
        return GetFlag(this.f1541a, i);
    }

    public void setFlag(int i, boolean z) throws PDFNetException {
        SetFlag(this.f1541a, i, z);
    }

    public int getJustification() throws PDFNetException {
        return GetJustification(this.f1541a);
    }

    public void setJustification(int i) throws PDFNetException {
        SetJustification(this.f1541a, i);
    }

    public void setMaxLen(int i) throws PDFNetException {
        SetMaxLen(this.f1541a, i);
    }

    public int getMaxLen() throws PDFNetException {
        return GetMaxLen(this.f1541a);
    }

    public void flatten(Page page) throws PDFNetException {
        Flatten(this.f1541a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
    }

    public Obj findInheritedAttribute(String str) throws PDFNetException {
        return Obj.__Create(FindInheritedAttribute(this.f1541a, str), this.f1542d);
    }

    public Rect getUpdateRect() {
        return new Rect(GetUpdateRect(this.f1541a));
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.f1541a), this.f1542d);
    }

    public Obj useSignatureHandler(long j) throws PDFNetException {
        return Obj.__Create(UseSignatureHandler(this.f1541a, j), this.f1542d);
    }

    public int getOptCount() throws PDFNetException {
        return GetOptCount(this.f1541a);
    }

    public String getOpt(int i) throws PDFNetException {
        return GetOpt(this.f1541a, i);
    }

    public boolean isLockedByDigitalSignature() throws PDFNetException {
        return IsLockedByDigitalSignature(this.f1541a);
    }

    Field(long j, Object obj) throws PDFNetException {
        this.f1541a = j;
        this.f1542d = obj;
        clearList();
    }

    public static Field __Create(long j, Object obj) throws PDFNetException {
        if (j == 0) {
            return null;
        }
        return new Field(j, obj);
    }

    public long __GetHandle() {
        return this.f1541a;
    }

    public Object __GetRefHandle() {
        return this.f1542d;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
