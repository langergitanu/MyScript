package com.google.android.material.color.utilities;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes6.dex */
public class SchemeMonochrome extends DynamicScheme {
    public SchemeMonochrome(Hct hct, boolean z, double d) {
        super(hct, Variant.MONOCHROME, z, d, TonalPalette.fromHueAndChroma(hct.getHue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), TonalPalette.fromHueAndChroma(hct.getHue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), TonalPalette.fromHueAndChroma(hct.getHue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), TonalPalette.fromHueAndChroma(hct.getHue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), TonalPalette.fromHueAndChroma(hct.getHue(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }
}
