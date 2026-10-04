package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class Device {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Device(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Device device) {
        if (device == null) {
            return 0L;
        }
        return device.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_Device(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setDms(DMS dms) {
        NeboDMSJNI.Device_dms_set(this.swigCPtr, this, DMS.getCPtr(dms), dms);
    }

    public DMS getDms() {
        long jDevice_dms_get = NeboDMSJNI.Device_dms_get(this.swigCPtr, this);
        if (jDevice_dms_get == 0) {
            return null;
        }
        return new DMS(jDevice_dms_get, true);
    }

    public void setViewModel(C6921xdc5161 c6921xdc5161) {
        NeboDMSJNI.Device_viewModel_set(this.swigCPtr, this, C6921xdc5161.getCPtr(c6921xdc5161));
    }

    public C6921xdc5161 getViewModel() {
        long jDevice_viewModel_get = NeboDMSJNI.Device_viewModel_get(this.swigCPtr, this);
        if (jDevice_viewModel_get == 0) {
            return null;
        }
        return new C6921xdc5161(jDevice_viewModel_get, false);
    }

    public void setCloudDrive(C6920xe8fc5931 c6920xe8fc5931) {
        NeboDMSJNI.Device_cloudDrive_set(this.swigCPtr, this, C6920xe8fc5931.getCPtr(c6920xe8fc5931));
    }

    public C6920xe8fc5931 getCloudDrive() {
        long jDevice_cloudDrive_get = NeboDMSJNI.Device_cloudDrive_get(this.swigCPtr, this);
        if (jDevice_cloudDrive_get == 0) {
            return null;
        }
        return new C6920xe8fc5931(jDevice_cloudDrive_get, false);
    }

    public void setUuidGenerator(SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t) {
        NeboDMSJNI.Device_uuidGenerator_set(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t));
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t getUuidGenerator() {
        long jDevice_uuidGenerator_get = NeboDMSJNI.Device_uuidGenerator_get(this.swigCPtr, this);
        if (jDevice_uuidGenerator_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t(jDevice_uuidGenerator_get, false);
    }

    public void setId(int i) {
        NeboDMSJNI.Device_id_set(this.swigCPtr, this, i);
    }

    public int getId() {
        return NeboDMSJNI.Device_id_get(this.swigCPtr, this);
    }

    public void setV1Dir(String str) {
        NeboDMSJNI.Device_v1Dir_set(this.swigCPtr, this, str.getBytes());
    }

    public String getV1Dir() {
        return new String(NeboDMSJNI.Device_v1Dir_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setV2Dir(String str) {
        NeboDMSJNI.Device_v2Dir_set(this.swigCPtr, this, str.getBytes());
    }

    public String getV2Dir() {
        return new String(NeboDMSJNI.Device_v2Dir_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setName(String str) {
        NeboDMSJNI.Device_name_set(this.swigCPtr, this, str.getBytes());
    }

    public String getName() {
        return new String(NeboDMSJNI.Device_name_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public Device() {
        this(NeboDMSJNI.new_Device(), true);
    }
}
