package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.DesktopModeStateInterface;
import com.samsung.android.spen.libse.SeDesktopModeState;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class DesktopModeStateWrapper {
    private DesktopModeStateInterface instance;

    DesktopModeStateWrapper(DesktopModeStateInterface desktopModeStateInterface) throws PlatformException {
        try {
            this.instance = desktopModeStateInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static DesktopModeStateWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new DesktopModeStateWrapper(new SeDesktopModeState(context));
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f2253SE, e);
            }
        }
        throw new PlatformException(PlatformException.SDL);
    }

    public int getEnabled() throws PlatformException {
        try {
            return this.instance.getEnabled();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getDisplayType() throws PlatformException {
        try {
            return this.instance.getDisplayType();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getEnabledConstant() throws PlatformException {
        try {
            return this.instance.getEnabledConstant();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getDisplayTypeStandaloneConstant() throws PlatformException {
        try {
            return this.instance.getDisplayTypeStandaloneConstant();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getDisplayTypeDualConstant() throws PlatformException {
        try {
            return this.instance.getDisplayTypeDualConstant();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
