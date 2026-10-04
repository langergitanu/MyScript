package com.samsung.android.spen.libwrapper;

import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class MediaSessionWrapper {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS;

    static {
        if (PlatformUtils.isSemDevice()) {
            FLAG_HANDLES_MEDIA_BUTTONS = 268435456;
        } else {
            FLAG_HANDLES_MEDIA_BUTTONS = 1;
        }
    }
}
