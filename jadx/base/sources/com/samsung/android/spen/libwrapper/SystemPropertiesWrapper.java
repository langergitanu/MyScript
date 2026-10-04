package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.SystemPropertiesInterface;
import com.samsung.android.spen.libsdl.SdlSystemProperties;
import com.samsung.android.spen.libse.SeSystemProperties;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class SystemPropertiesWrapper {
    private SystemPropertiesInterface instance;

    private SystemPropertiesWrapper(SystemPropertiesInterface systemPropertiesInterface) throws PlatformException {
        try {
            this.instance = systemPropertiesInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static SystemPropertiesWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new SystemPropertiesWrapper(new SeSystemProperties(context));
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f2253SE, e);
            }
        }
        try {
            return new SystemPropertiesWrapper(new SdlSystemProperties(context));
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public String get(String str) throws PlatformException {
        try {
            return this.instance.get(str);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public String getSalesCode() throws PlatformException {
        try {
            return this.instance.getSalesCode();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
