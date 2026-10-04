package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.DisplayAdaptiveSyncManagerInterface;
import com.samsung.android.spen.libsdl.SdlDisplayAdaptiveSyncManager;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class DisplayAdaptiveSyncManagerWrapper {
    private DisplayAdaptiveSyncManagerInterface instance;

    private DisplayAdaptiveSyncManagerWrapper(DisplayAdaptiveSyncManagerInterface displayAdaptiveSyncManagerInterface) throws PlatformException {
        try {
            this.instance = displayAdaptiveSyncManagerInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static DisplayAdaptiveSyncManagerWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        try {
            return new DisplayAdaptiveSyncManagerWrapper(new SdlDisplayAdaptiveSyncManager());
        } catch (Error | Exception e) {
            throw new PlatformException(PlatformException.SDL, e);
        }
    }

    public int setAdaptiveSync(boolean z) throws PlatformException {
        try {
            return this.instance.setAdaptiveSync(z);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
