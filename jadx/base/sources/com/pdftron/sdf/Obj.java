package com.pdftron.sdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.filters.FilterWriter;
import com.pdftron.helpers.DoubleRectangle2D;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class Obj {
    public static final int e_array = 6;
    public static final int e_bool = 1;
    public static final int e_dict = 5;
    public static final int e_name = 3;
    public static final int e_null = 0;
    public static final int e_number = 2;
    public static final int e_stream = 7;
    public static final int e_string = 4;

    /* JADX INFO: renamed from: a */
    long f2180a;

    /* JADX INFO: renamed from: b */
    Object f2181b;

    static native void Erase(long j, long j2);

    static native void Erase(long j, String str);

    static native void EraseAt(long j, int i);

    static native long Find(long j, String str);

    static native long FindObj(long j, String str);

    static native long Get(long j, String str);

    static native String GetAsPDFText(long j);

    static native long GetAt(long j, int i);

    static native boolean GetBool(long j);

    static native byte[] GetBuffer(long j);

    static native long GetDecodedStream(long j);

    static native long GetDictIterator(long j);

    static native long GetDoc(long j);

    static native short GetGenNum(long j);

    static native String GetName(long j);

    static native double GetNumber(long j);

    static native long GetObjNum(long j);

    static native long GetOffset(long j);

    static native byte[] GetRawBuffer(long j);

    static native long GetRawStream(long j, boolean z);

    static native long GetRawStreamLength(long j);

    static native int GetType(long j);

    static native long Insert(long j, int i, long j2);

    static native long InsertArray(long j, int i);

    static native long InsertBool(long j, int i, boolean z);

    static native long InsertDict(long j, int i);

    static native long InsertMatrix(long j, int i, long j2);

    static native long InsertName(long j, int i, String str);

    static native long InsertNull(long j, int i);

    static native long InsertNumber(long j, int i, double d);

    static native long InsertRect(long j, int i, double d, double d2, double d3, double d4);

    static native long InsertString(long j, int i, String str);

    static native long InsertString(long j, int i, byte[] bArr);

    static native long InsertText(long j, int i, String str);

    static native boolean IsArray(long j);

    static native boolean IsBool(long j);

    static native boolean IsContainer(long j);

    static native boolean IsDict(long j);

    static native boolean IsEqual(long j, long j2);

    static native boolean IsFree(long j);

    static native boolean IsIndirect(long j);

    static native boolean IsLoaded(long j);

    static native boolean IsMarked(long j);

    static native boolean IsName(long j);

    static native boolean IsNull(long j);

    static native boolean IsNumber(long j);

    static native boolean IsStream(long j);

    static native boolean IsString(long j);

    static native long PushBack(long j, long j2);

    static native long PushBackArray(long j);

    static native long PushBackBool(long j, boolean z);

    static native long PushBackDict(long j);

    static native long PushBackMatrix(long j, long j2);

    static native long PushBackName(long j, String str);

    static native long PushBackNull(long j);

    static native long PushBackNumber(long j, double d);

    static native long PushBackRect(long j, double d, double d2, double d3, double d4);

    static native long PushBackString(long j, String str);

    static native long PushBackString(long j, byte[] bArr);

    static native long PushBackText(long j, String str);

    static native long Put(long j, String str, long j2);

    static native long PutArray(long j, String str);

    static native long PutBool(long j, String str, boolean z);

    static native long PutDict(long j, String str);

    static native long PutMatrix(long j, String str, long j2);

    static native long PutName(long j, String str, String str2);

    static native void PutNull(long j, String str);

    static native long PutNumber(long j, String str, double d);

    static native long PutRect(long j, String str, double d, double d2, double d3, double d4);

    static native long PutString(long j, String str, String str2);

    static native long PutString(long j, String str, byte[] bArr);

    static native long PutText(long j, String str, String str2);

    static native boolean Rename(long j, String str, String str2);

    static native void SetBool(long j, boolean z);

    static native void SetMark(long j, boolean z);

    static native void SetName(long j, String str);

    static native void SetNumber(long j, double d);

    static native void SetStreamData(long j, byte[] bArr, long j2);

    static native void SetString(long j, String str);

    static native void SetString(long j, byte[] bArr);

    static native long Size(long j);

    static native void Write(long j, long j2);

    public int getType() throws PDFNetException {
        return GetType(this.f2180a);
    }

    public boolean isBool() throws PDFNetException {
        return IsBool(this.f2180a);
    }

    public boolean isNumber() throws PDFNetException {
        return IsNumber(this.f2180a);
    }

    public boolean isNull() throws PDFNetException {
        return IsNull(this.f2180a);
    }

    public boolean isString() throws PDFNetException {
        return IsString(this.f2180a);
    }

    public boolean isName() throws PDFNetException {
        return IsName(this.f2180a);
    }

    public boolean isIndirect() throws PDFNetException {
        return IsIndirect(this.f2180a);
    }

    public boolean isContainer() throws PDFNetException {
        return IsContainer(this.f2180a);
    }

    public boolean isDict() throws PDFNetException {
        return IsDict(this.f2180a);
    }

    public boolean isArray() throws PDFNetException {
        return IsArray(this.f2180a);
    }

    public boolean isStream() throws PDFNetException {
        return IsStream(this.f2180a);
    }

    public SDFDoc getDoc() throws PDFNetException {
        return new SDFDoc(GetDoc(this.f2180a), this.f2181b);
    }

    public void write(FilterWriter filterWriter) throws PDFNetException {
        Write(this.f2180a, filterWriter.__GetHandle());
        ReachabilityHelper.ensureReachable(filterWriter);
    }

    public long size() throws PDFNetException {
        return Size(this.f2180a);
    }

    public long getObjNum() throws PDFNetException {
        return GetObjNum(this.f2180a);
    }

    public short getGenNum() throws PDFNetException {
        return GetGenNum(this.f2180a);
    }

    public long getOffset() throws PDFNetException {
        return GetOffset(this.f2180a);
    }

    public boolean isFree() throws PDFNetException {
        return IsFree(this.f2180a);
    }

    public void setMark(boolean z) throws PDFNetException {
        SetMark(this.f2180a, z);
    }

    public boolean isMarked() throws PDFNetException {
        return IsMarked(this.f2180a);
    }

    public boolean isLoaded() throws PDFNetException {
        return IsLoaded(this.f2180a);
    }

    public boolean isEqual(Obj obj) throws PDFNetException {
        boolean zIsEqual = IsEqual(this.f2180a, obj.f2180a);
        ReachabilityHelper.ensureReachable(obj);
        return zIsEqual;
    }

    public boolean getBool() throws PDFNetException {
        return GetBool(this.f2180a);
    }

    public void setBool(boolean z) throws PDFNetException {
        SetBool(this.f2180a, z);
    }

    public double getNumber() throws PDFNetException {
        return GetNumber(this.f2180a);
    }

    public void setNumber(double d) throws PDFNetException {
        SetNumber(this.f2180a, d);
    }

    public byte[] getBuffer() throws PDFNetException {
        return GetBuffer(this.f2180a);
    }

    public byte[] getRawBuffer() throws PDFNetException {
        return GetRawBuffer(this.f2180a);
    }

    public String getAsPDFText() throws PDFNetException {
        return GetAsPDFText(this.f2180a);
    }

    public void setString(byte[] bArr) throws PDFNetException {
        SetString(this.f2180a, bArr);
    }

    public void setString(String str) throws PDFNetException {
        SetString(this.f2180a, str);
    }

    public String getName() throws PDFNetException {
        return GetName(this.f2180a);
    }

    public void setName(String str) throws PDFNetException {
        SetName(this.f2180a, str);
    }

    public DictIterator getDictIterator() throws PDFNetException {
        return new DictIterator(GetDictIterator(this.f2180a), this.f2181b);
    }

    public DictIterator find(String str) throws PDFNetException {
        return new DictIterator(Find(this.f2180a, str), this.f2181b);
    }

    public Obj findObj(String str) throws PDFNetException {
        return __Create(FindObj(this.f2180a, str), this.f2181b);
    }

    public DictIterator get(String str) throws PDFNetException {
        return new DictIterator(Get(this.f2180a, str), this.f2181b);
    }

    public Obj putName(String str, String str2) throws PDFNetException {
        return __Create(PutName(this.f2180a, str, str2), this.f2181b);
    }

    public Obj putArray(String str) throws PDFNetException {
        return __Create(PutArray(this.f2180a, str), this.f2181b);
    }

    public Obj putBool(String str, boolean z) throws PDFNetException {
        return __Create(PutBool(this.f2180a, str, z), this.f2181b);
    }

    public Obj putDict(String str) throws PDFNetException {
        return __Create(PutDict(this.f2180a, str), this.f2181b);
    }

    public Obj putNumber(String str, double d) throws PDFNetException {
        return __Create(PutNumber(this.f2180a, str, d), this.f2181b);
    }

    public Obj putString(String str, String str2) throws PDFNetException {
        return __Create(PutString(this.f2180a, str, str2), this.f2181b);
    }

    public Obj putString(String str, byte[] bArr) throws PDFNetException {
        return __Create(PutString(this.f2180a, str, bArr), this.f2181b);
    }

    public Obj putText(String str, String str2) throws PDFNetException {
        return __Create(PutText(this.f2180a, str, str2), this.f2181b);
    }

    public void putNull(String str) throws PDFNetException {
        PutNull(this.f2180a, str);
    }

    public Obj put(String str, Obj obj) throws PDFNetException {
        return __Create(Put(this.f2180a, str, obj.f2180a), this.f2181b);
    }

    public Obj putRect(String str, double d, double d2, double d3, double d4) throws PDFNetException {
        return __Create(PutRect(this.f2180a, str, d, d2, d3, d4), this.f2181b);
    }

    public Obj putRect(String str, DoubleRectangle2D doubleRectangle2D) throws PDFNetException {
        return __Create(PutRect(this.f2180a, str, doubleRectangle2D.f1418x, doubleRectangle2D.f1419y, doubleRectangle2D.f1418x + doubleRectangle2D.width, doubleRectangle2D.f1419y + doubleRectangle2D.height), this.f2181b);
    }

    public Obj putMatrix(String str, Matrix2D matrix2D) throws PDFNetException {
        return __Create(PutMatrix(this.f2180a, str, matrix2D.__GetHandle()), this.f2181b);
    }

    public void erase(String str) throws PDFNetException {
        Erase(this.f2180a, str);
    }

    public void erase(DictIterator dictIterator) throws PDFNetException {
        Erase(this.f2180a, dictIterator.__GetHandle());
        ReachabilityHelper.ensureReachable(dictIterator);
    }

    public boolean rename(String str, String str2) throws PDFNetException {
        return Rename(this.f2180a, str, str2);
    }

    public Obj getAt(int i) throws PDFNetException {
        return __Create(GetAt(this.f2180a, i), this.f2181b);
    }

    public Obj insertName(int i, String str) throws PDFNetException {
        return __Create(InsertName(this.f2180a, i, str), this.f2181b);
    }

    public Obj insertArray(int i) throws PDFNetException {
        return __Create(InsertArray(this.f2180a, i), this.f2181b);
    }

    public Obj insertBool(int i, boolean z) throws PDFNetException {
        return __Create(InsertBool(this.f2180a, i, z), this.f2181b);
    }

    public Obj insertDict(int i) throws PDFNetException {
        return __Create(InsertDict(this.f2180a, i), this.f2181b);
    }

    public Obj insertNumber(int i, double d) throws PDFNetException {
        return __Create(InsertNumber(this.f2180a, i, d), this.f2181b);
    }

    public Obj insertString(int i, String str) throws PDFNetException {
        return __Create(InsertString(this.f2180a, i, str), this.f2181b);
    }

    public Obj insertString(int i, byte[] bArr) throws PDFNetException {
        return __Create(InsertString(this.f2180a, i, bArr), this.f2181b);
    }

    public Obj insertText(int i, String str) throws PDFNetException {
        return __Create(InsertText(this.f2180a, i, str), this.f2181b);
    }

    public Obj insertNull(int i) throws PDFNetException {
        return __Create(InsertNull(this.f2180a, i), this.f2181b);
    }

    public Obj insert(int i, Obj obj) throws PDFNetException {
        return __Create(Insert(this.f2180a, i, obj.f2180a), this.f2181b);
    }

    public Obj insertRect(int i, double d, double d2, double d3, double d4) throws PDFNetException {
        return __Create(InsertRect(this.f2180a, i, d, d2, d3, d4), this.f2181b);
    }

    public Obj insertRect(int i, DoubleRectangle2D doubleRectangle2D) throws PDFNetException {
        return __Create(InsertRect(this.f2180a, i, doubleRectangle2D.f1418x, doubleRectangle2D.f1419y, doubleRectangle2D.f1418x + doubleRectangle2D.width, doubleRectangle2D.f1419y + doubleRectangle2D.height), this.f2181b);
    }

    public Obj insertMatrix(int i, Matrix2D matrix2D) throws PDFNetException {
        return __Create(InsertMatrix(this.f2180a, i, matrix2D.__GetHandle()), this.f2181b);
    }

    public Obj pushBackName(String str) throws PDFNetException {
        return __Create(PushBackName(this.f2180a, str), this.f2181b);
    }

    public Obj pushBackArray() throws PDFNetException {
        return __Create(PushBackArray(this.f2180a), this.f2181b);
    }

    public Obj pushBackBool(boolean z) throws PDFNetException {
        return __Create(PushBackBool(this.f2180a, z), this.f2181b);
    }

    public Obj pushBackDict() throws PDFNetException {
        return __Create(PushBackDict(this.f2180a), this.f2181b);
    }

    public Obj pushBackNumber(double d) throws PDFNetException {
        return __Create(PushBackNumber(this.f2180a, d), this.f2181b);
    }

    public Obj pushBackString(String str) throws PDFNetException {
        return __Create(PushBackString(this.f2180a, str), this.f2181b);
    }

    public Obj pushBackString(byte[] bArr) throws PDFNetException {
        return __Create(PushBackString(this.f2180a, bArr), this.f2181b);
    }

    public Obj pushBackText(String str) throws PDFNetException {
        return __Create(PushBackText(this.f2180a, str), this.f2181b);
    }

    public Obj pushBackNull() throws PDFNetException {
        return __Create(PushBackNull(this.f2180a), this.f2181b);
    }

    public Obj pushBack(Obj obj) throws PDFNetException {
        return __Create(PushBack(this.f2180a, obj.f2180a), this.f2181b);
    }

    public Obj pushBackRect(double d, double d2, double d3, double d4) throws PDFNetException {
        return __Create(PushBackRect(this.f2180a, d, d2, d3, d4), this.f2181b);
    }

    public Obj pushBackRect(DoubleRectangle2D doubleRectangle2D) throws PDFNetException {
        return __Create(PushBackRect(this.f2180a, doubleRectangle2D.f1418x, doubleRectangle2D.f1419y, doubleRectangle2D.f1418x + doubleRectangle2D.width, doubleRectangle2D.f1419y + doubleRectangle2D.height), this.f2181b);
    }

    public Obj pushBackMatrix(Matrix2D matrix2D) throws PDFNetException {
        return __Create(PushBackMatrix(this.f2180a, matrix2D.__GetHandle()), this.f2181b);
    }

    public void eraseAt(int i) throws PDFNetException {
        EraseAt(this.f2180a, i);
    }

    public long getRawStreamLength() throws PDFNetException {
        return GetRawStreamLength(this.f2180a);
    }

    public Filter getRawStream(boolean z) throws PDFNetException {
        return Filter.__Create(GetRawStream(this.f2180a, z), null);
    }

    public Filter getDecodedStream() throws PDFNetException {
        return Filter.__Create(GetDecodedStream(this.f2180a), null);
    }

    public void setStreamData(byte[] bArr, Filter filter) throws PDFNetException {
        if (filter != null) {
            filter.__SetRefHandle(this);
        }
        SetStreamData(this.f2180a, bArr, filter.__GetHandle());
        ReachabilityHelper.ensureReachable(filter);
    }

    private Obj(long j, Object obj) {
        this.f2180a = j;
        this.f2181b = obj;
    }

    public static Obj __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Obj(j, obj);
    }

    public long __GetHandle() {
        return this.f2180a;
    }

    public Object __GetRefHandle() {
        return this.f2181b;
    }
}
