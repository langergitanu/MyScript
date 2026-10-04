package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Date {

    /* JADX INFO: renamed from: a */
    long f1515a;

    static native void Attach(long j, long j2);

    static native long DateCreate();

    static native long DateCreate(long j);

    static native long DateCreate(short s, byte b, byte b2, byte b3, byte b4, byte b5);

    static native boolean Equals(long j, long j2);

    static native byte GetDay(long j);

    static native byte GetHour(long j);

    static native byte GetMinute(long j);

    static native byte GetMonth(long j);

    static native byte GetSecond(long j);

    static native byte GetUT(long j);

    static native byte GetUTHour(long j);

    static native byte GetUTMinutes(long j);

    static native short GetYear(long j);

    static native int HashCode(long j);

    static native boolean IsValid(long j);

    static native boolean SetCurrentTime(long j);

    static native void SetDay(long j, byte b);

    static native void SetHour(long j, byte b);

    static native void SetMinute(long j, byte b);

    static native void SetMonth(long j, byte b);

    static native void SetSecond(long j, byte b);

    static native void SetUT(long j, byte b);

    static native void SetUTHour(long j, byte b);

    static native void SetUTMinutes(long j, byte b);

    static native void SetYear(long j, short s);

    static native boolean Update(long j, long j2);

    public Date() throws PDFNetException {
        this.f1515a = DateCreate();
    }

    public Date(Obj obj) throws PDFNetException {
        this.f1515a = DateCreate(obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Date(short s, byte b, byte b2, byte b3, byte b4, byte b5) throws PDFNetException {
        this.f1515a = DateCreate(s, b, b2, b3, b4, b5);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1515a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        boolean zEquals = Equals(this.f1515a, ((Date) obj).f1515a);
        ReachabilityHelper.ensureReachable(obj);
        return zEquals;
    }

    public int hashCode() {
        return HashCode(this.f1515a);
    }

    public void attach(Obj obj) throws PDFNetException {
        Attach(this.f1515a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public boolean update() throws PDFNetException {
        return Update(this.f1515a, 0L);
    }

    public boolean update(Obj obj) throws PDFNetException {
        boolean zUpdate = Update(this.f1515a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
        return zUpdate;
    }

    public void setCurrentTime() {
        SetCurrentTime(this.f1515a);
    }

    public short getYear() throws PDFNetException {
        return GetYear(this.f1515a);
    }

    public byte getMonth() throws PDFNetException {
        return GetMonth(this.f1515a);
    }

    public byte getDay() throws PDFNetException {
        return GetDay(this.f1515a);
    }

    public byte getHour() throws PDFNetException {
        return GetHour(this.f1515a);
    }

    public byte getMinute() throws PDFNetException {
        return GetMinute(this.f1515a);
    }

    public byte getSecond() throws PDFNetException {
        return GetSecond(this.f1515a);
    }

    public byte getUT() throws PDFNetException {
        return GetUT(this.f1515a);
    }

    public byte getUTHour() throws PDFNetException {
        return GetUTHour(this.f1515a);
    }

    public byte getUTMinutes() throws PDFNetException {
        return GetUTMinutes(this.f1515a);
    }

    public void setYear(short s) throws PDFNetException {
        SetYear(this.f1515a, s);
    }

    public void setMonth(byte b) throws PDFNetException {
        SetMonth(this.f1515a, b);
    }

    public void setDay(byte b) throws PDFNetException {
        SetDay(this.f1515a, b);
    }

    public void setHour(byte b) throws PDFNetException {
        SetHour(this.f1515a, b);
    }

    public void setMinute(byte b) throws PDFNetException {
        SetMinute(this.f1515a, b);
    }

    public void setSecond(byte b) throws PDFNetException {
        SetSecond(this.f1515a, b);
    }

    public void setUT(byte b) throws PDFNetException {
        SetUT(this.f1515a, b);
    }

    public void setUTHour(byte b) throws PDFNetException {
        SetUTHour(this.f1515a, b);
    }

    public void seUTMinutes(byte b) throws PDFNetException {
        SetUTMinutes(this.f1515a, b);
    }

    public void setUTMinutes(byte b) throws PDFNetException {
        SetUTMinutes(this.f1515a, b);
    }

    Date(long j) {
        this.f1515a = j;
    }

    public static Date __Create(long j) {
        if (j == 0) {
            return null;
        }
        return new Date(j);
    }

    public long __GetHandle() {
        return this.f1515a;
    }
}
