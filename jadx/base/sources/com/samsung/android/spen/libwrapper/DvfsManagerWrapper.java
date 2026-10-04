package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.DvfsManagerInterface;
import com.samsung.android.spen.libsdl.SdlDvfsManager;
import com.samsung.android.spen.libse.SeDvfsManager;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class DvfsManagerWrapper {
    public static final int TYPE_BUS_MIN;
    public static final int TYPE_CPU_CORE_NUM_MAX;
    public static final int TYPE_CPU_CORE_NUM_MIN;
    public static final int TYPE_CPU_MAX;
    public static final int TYPE_CPU_MIN;
    public static final int TYPE_EMMC_BURST_MODE;
    public static final int TYPE_GPU_MAX;
    public static final int TYPE_GPU_MIN;
    private DvfsManagerInterface instance;

    static {
        if (PlatformUtils.isSemDevice()) {
            TYPE_BUS_MIN = 805310465;
            TYPE_CPU_CORE_NUM_MAX = 268443652;
            TYPE_CPU_CORE_NUM_MIN = 268443651;
            TYPE_CPU_MAX = 301993986;
            TYPE_CPU_MIN = 301993985;
            TYPE_EMMC_BURST_MODE = 18;
            TYPE_GPU_MAX = 536875010;
            TYPE_GPU_MIN = 536875009;
            return;
        }
        TYPE_BUS_MIN = 19;
        TYPE_CPU_CORE_NUM_MAX = 15;
        TYPE_CPU_CORE_NUM_MIN = 14;
        TYPE_CPU_MAX = 13;
        TYPE_CPU_MIN = 12;
        TYPE_EMMC_BURST_MODE = 18;
        TYPE_GPU_MAX = 17;
        TYPE_GPU_MIN = 16;
    }

    private DvfsManagerWrapper(DvfsManagerInterface dvfsManagerInterface) throws PlatformException {
        try {
            this.instance = dvfsManagerInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static DvfsManagerWrapper create(Context context, int i) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new DvfsManagerWrapper(new SeDvfsManager(context, "", i));
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f2253SE, e);
            }
        }
        try {
            return new DvfsManagerWrapper(new SdlDvfsManager(context, "", i));
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public static DvfsManagerWrapper create(Context context, String str, int i) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new DvfsManagerWrapper(new SeDvfsManager(context, str, i));
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f2253SE, e);
            }
        }
        try {
            return new DvfsManagerWrapper(new SdlDvfsManager(context, str, i));
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public void acquire() throws PlatformException {
        try {
            this.instance.acquire();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void acquire(int i) throws PlatformException {
        try {
            this.instance.acquire(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void release() throws PlatformException {
        try {
            this.instance.release();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public void setDvfsValue(int i) throws PlatformException {
        try {
            this.instance.setDvfsValue(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getApproximateFrequency(int i) throws PlatformException {
        try {
            return this.instance.getApproximateFrequency(i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int[] getSupportedFrequency() throws PlatformException {
        try {
            return this.instance.getSupportedFrequency();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
