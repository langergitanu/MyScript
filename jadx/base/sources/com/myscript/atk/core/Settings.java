package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class Settings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Settings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Settings settings) {
        if (settings == null) {
            return 0L;
        }
        return settings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Settings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static Settings getInstance() {
        return new Settings(ATKCoreJNI.Settings_getInstance(), false);
    }

    public void enableGestureNN(boolean z) {
        ATKCoreJNI.Settings_enableGestureNN(this.swigCPtr, this, z);
    }

    public boolean isGestureNNEnabled() {
        return ATKCoreJNI.Settings_isGestureNNEnabled(this.swigCPtr, this);
    }

    public void enableEventLogger(boolean z) {
        ATKCoreJNI.Settings_enableEventLogger(this.swigCPtr, this, z);
    }

    public boolean isEventLoggerEnabled() {
        return ATKCoreJNI.Settings_isEventLoggerEnabled(this.swigCPtr, this);
    }

    public void enableFontCaching(boolean z) {
        ATKCoreJNI.Settings_enableFontCaching(this.swigCPtr, this, z);
    }

    public boolean isFontCachingEnabled() {
        return ATKCoreJNI.Settings_isFontCachingEnabled(this.swigCPtr, this);
    }

    public float indentFactor() {
        return ATKCoreJNI.Settings_indentFactor(this.swigCPtr, this);
    }

    public void setAssertOnError(boolean z) {
        ATKCoreJNI.Settings_setAssertOnError(this.swigCPtr, this, z);
    }

    public boolean assertOnError() {
        return ATKCoreJNI.Settings_assertOnError(this.swigCPtr, this);
    }

    public void enableMigrationAtSync(boolean z) {
        ATKCoreJNI.Settings_enableMigrationAtSync(this.swigCPtr, this, z);
    }

    public boolean isMigrationAtSyncEnabled() {
        return ATKCoreJNI.Settings_isMigrationAtSyncEnabled(this.swigCPtr, this);
    }
}
