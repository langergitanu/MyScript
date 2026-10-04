package com.samsung.android.sdk.pen.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.spen.libwrapper.DesktopModeManagerWrapper;
import com.samsung.android.spen.libwrapper.DesktopModeStateWrapper;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.SettingsSystemWrapper;
import com.samsung.android.spen.libwrapper.SystemPropertiesWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SpenConfiguration.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0018R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "", "nativeHandle", "getNativeHandle", "()J", "deviceType", "", "getDeviceType", "()I", "setDeviceType", "(I)V", "deviceUXType", "getDeviceUXType", "setDeviceUXType", "dexMode", "getDexMode", "setDexMode", "close", "", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenConfiguration {
    public static final int AI_CONFIG_VERSION_20251 = 20251;
    public static final int AI_CONFIG_VERSION_20253 = 20253;
    private static final String CONFIG_AI_VERSION = "SEC_FLOATING_FEATURE_COMMON_CONFIG_AI_VERSION";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEVICE_TYPE_FOLD = 2;
    public static final int DEVICE_TYPE_PHONE = 0;
    public static final int DEVICE_TYPE_TABLET = 1;
    public static final int DEVICE_UX_TYPE_PHONE = 0;
    public static final int DEVICE_UX_TYPE_TABLET = 1;
    public static final int DEX_MODE_DUAL = 1;
    public static final int DEX_MODE_NEW_DEX = 3;
    public static final int DEX_MODE_NONE = 0;
    public static final int DEX_MODE_STANDALONE = 2;
    private static final String FOLD_DEVICE_FEATURE_Q = "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_WM_CONTROLS_DISPLAY_SWITCH";
    private static final String FOLD_DEVICE_FEATURE_R_UP = "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD";
    public static final int ONE_UI_8_0 = 80000;
    public static final int ONE_UI_NONE = 0;
    private static final int R_OS_VERSION_CODES = 30;
    private static final String TAG = "SpenConfiguration";
    private int deviceType;
    private int deviceUXType;
    private int dexMode;
    private long nativeHandle;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(int i, int i2, int i3);

    @JvmStatic
    public static final Integer getConfigAiVersion(Context context) {
        return INSTANCE.getConfigAiVersion(context);
    }

    @JvmStatic
    public static final int getOneUiVersion(Context context) {
        return INSTANCE.getOneUiVersion(context);
    }

    @JvmStatic
    public static final boolean isChromeBook(Context context) {
        return INSTANCE.isChromeBook(context);
    }

    @JvmStatic
    public static final boolean isDesktopMode(Context context) {
        return INSTANCE.isDesktopMode(context);
    }

    @JvmStatic
    public static final boolean isDexDualMode(Context context) {
        return INSTANCE.isDexDualMode(context);
    }

    @JvmStatic
    public static final boolean isDexStandAloneMode(Context context) {
        return INSTANCE.isDexStandAloneMode(context);
    }

    @JvmStatic
    public static final boolean isFoldDevice(Context context) {
        return INSTANCE.isFoldDevice(context);
    }

    @JvmStatic
    public static final boolean isLandscapeQuirk() {
        return INSTANCE.isLandscapeQuirk();
    }

    @JvmStatic
    public static final boolean isMainDisplay(Configuration configuration) {
        return INSTANCE.isMainDisplay(configuration);
    }

    @JvmStatic
    public static final boolean isNewDexMode(Context context) {
        return INSTANCE.isNewDexMode(context);
    }

    @JvmStatic
    public static final boolean isSubDisplay(Configuration configuration) {
        return INSTANCE.isSubDisplay(configuration);
    }

    @JvmStatic
    private static final boolean isSystemBuildCharacteristicsContaining(Context context, String str) {
        return INSTANCE.isSystemBuildCharacteristicsContaining(context, str);
    }

    @JvmStatic
    public static final boolean isSystemDarkMode(Context context) {
        return INSTANCE.isSystemDarkMode(context);
    }

    @JvmStatic
    public static final boolean isTabletDevice(Context context) {
        return INSTANCE.isTabletDevice(context);
    }

    @JvmStatic
    public static final boolean isTabletUX(Context context) {
        return INSTANCE.isTabletUX(context);
    }

    @JvmStatic
    public static final boolean isVSTDevice(Context context) {
        return INSTANCE.isVSTDevice(context);
    }

    public SpenConfiguration(Context context) {
        int i;
        if (context == null) {
            throw new IllegalArgumentException("context must be not null".toString());
        }
        Companion companion = INSTANCE;
        int i2 = 2;
        if (companion.isTabletDevice(context)) {
            i = 1;
        } else {
            i = companion.isFoldDevice(context) ? 2 : 0;
        }
        this.deviceType = i;
        this.deviceUXType = (i == 1 || i == 2) ? 1 : 0;
        if (!companion.isDesktopMode(context)) {
            i2 = 0;
        } else if (!companion.isDexStandAloneMode(context)) {
            i2 = companion.isNewDexMode(context) ? 3 : 1;
        }
        this.dexMode = i2;
        Log.i(TAG, "SpenConfiguration deviceType=" + this.deviceType + ", deviceUXType=" + this.deviceUXType + ", dexMode=" + i2);
        this.nativeHandle = companion.Native_init(this.deviceType, this.deviceUXType, this.dexMode);
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(int i) {
        this.deviceType = i;
    }

    public final int getDeviceUXType() {
        return this.deviceUXType;
    }

    public final void setDeviceUXType(int i) {
        this.deviceUXType = i;
    }

    public final int getDexMode() {
        return this.dexMode;
    }

    public final void setDexMode(int i) {
        this.dexMode = i;
    }

    public final void close() {
        long j = this.nativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.nativeHandle = 0L;
        }
    }

    /* JADX INFO: compiled from: SpenConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0005H\u0003J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0012\u0010 \u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010!\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010'\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010(\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010)\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010*\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010+\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0019\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0019H\u0007J!\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0083 J\u0011\u00104\u001a\u0002052\u0006\u00106\u001a\u000200H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u00067"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/view/SpenConfiguration$Companion;", "", "<init>", "()V", "TAG", "", "R_OS_VERSION_CODES", "", "FOLD_DEVICE_FEATURE_Q", "FOLD_DEVICE_FEATURE_R_UP", "CONFIG_AI_VERSION", "DEVICE_TYPE_PHONE", "DEVICE_TYPE_TABLET", "DEVICE_TYPE_FOLD", "DEVICE_UX_TYPE_PHONE", "DEVICE_UX_TYPE_TABLET", "DEX_MODE_NONE", "DEX_MODE_DUAL", "DEX_MODE_STANDALONE", "DEX_MODE_NEW_DEX", "ONE_UI_NONE", "ONE_UI_8_0", "AI_CONFIG_VERSION_20251", "AI_CONFIG_VERSION_20253", "isTabletDevice", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "isVSTDevice", "isSystemBuildCharacteristicsContaining", "value", "isTabletUX", "isFoldDevice", "isChromeBook", "isMainDisplay", "configuration", "Landroid/content/res/Configuration;", "isSubDisplay", "isDesktopMode", "isDexStandAloneMode", "isDexDualMode", "isNewDexMode", "isSystemDarkMode", "getOneUiVersion", "getConfigAiVersion", "(Landroid/content/Context;)Ljava/lang/Integer;", "isLandscapeQuirk", "Native_init", "", "deviceType", "deviceUXType", "dexMode", "Native_finalize", "", "handle", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long handle) {
            SpenConfiguration.Native_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(int deviceType, int deviceUXType, int dexMode) {
            return SpenConfiguration.Native_init(deviceType, deviceUXType, dexMode);
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isTabletDevice(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return isSystemBuildCharacteristicsContaining(context, "tablet");
        }

        @JvmStatic
        public final boolean isVSTDevice(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return isSystemBuildCharacteristicsContaining(context, "HMD");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean isSystemBuildCharacteristicsContaining(Context context, String value) {
            try {
                String str = SystemPropertiesWrapper.create(context).get("ro.build.characteristics");
                if (str != null) {
                    Log.d(SpenConfiguration.TAG, "buildCharacteristics : " + str + " value : " + value);
                    return StringsKt.contains$default((CharSequence) str, (CharSequence) value, false, 2, (Object) null);
                }
            } catch (PlatformException unused) {
            }
            return false;
        }

        @JvmStatic
        public final boolean isTabletUX(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return isTabletDevice(context) || isFoldDevice(context) || isChromeBook(context) || isVSTDevice(context);
        }

        @JvmStatic
        public final boolean isFoldDevice(Context context) {
            String str;
            if (Build.VERSION.SDK_INT < 30) {
                str = SpenConfiguration.FOLD_DEVICE_FEATURE_Q;
            } else {
                str = SpenConfiguration.FOLD_DEVICE_FEATURE_R_UP;
            }
            try {
                return FloatingFeatureWrapper.create(context).getBoolean(str);
            } catch (PlatformException unused) {
                String str2 = Build.MODEL;
                if (TextUtils.isEmpty(str2) || str2.length() < 7) {
                    return false;
                }
                Intrinsics.checkNotNull(str2);
                String strSubstring = str2.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                char cCharAt = strSubstring.charAt(0);
                if (cCharAt == 'F') {
                    if (!StringsKt.startsWith$default(strSubstring, "F90", false, 2, (Object) null) && !StringsKt.startsWith$default(strSubstring, "F91", false, 2, (Object) null) && !StringsKt.startsWith$default(strSubstring, "F92", false, 2, (Object) null) && !StringsKt.startsWith$default(strSubstring, "F93", false, 2, (Object) null)) {
                        return false;
                    }
                } else if (cCharAt != 'W' || !StringsKt.startsWith$default(strSubstring, "W20", false, 2, (Object) null)) {
                    return false;
                }
                return true;
            }
        }

        @JvmStatic
        public final boolean isChromeBook(Context context) {
            PackageManager packageManager;
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return false;
            }
            return packageManager.hasSystemFeature("org.chromium.arc.device_management");
        }

        @JvmStatic
        public final boolean isMainDisplay(Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return configuration.semDisplayDeviceType == 0;
        }

        @JvmStatic
        public final boolean isSubDisplay(Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return configuration.semDisplayDeviceType == 5;
        }

        @JvmStatic
        public final boolean isDesktopMode(Context context) {
            try {
                return DesktopModeManagerWrapper.create(context).isDesktopMode();
            } catch (PlatformException unused) {
                return false;
            }
        }

        @JvmStatic
        public final boolean isDexStandAloneMode(Context context) {
            try {
                DesktopModeStateWrapper desktopModeStateWrapperCreate = DesktopModeStateWrapper.create(context);
                boolean z = true;
                boolean z2 = desktopModeStateWrapperCreate.getEnabled() == desktopModeStateWrapperCreate.getEnabledConstant();
                int displayType = desktopModeStateWrapperCreate.getDisplayType();
                if (!z2 || displayType != desktopModeStateWrapperCreate.getDisplayTypeStandaloneConstant()) {
                    z = false;
                }
                Log.d(SpenConfiguration.TAG, "isDexStandAloneMode: isEnabled=" + z2 + ", isStandaloneMode=" + z);
                return z;
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "isDexStandAloneMode exception: " + e);
                return false;
            }
        }

        @JvmStatic
        public final boolean isDexDualMode(Context context) {
            try {
                DesktopModeStateWrapper desktopModeStateWrapperCreate = DesktopModeStateWrapper.create(context);
                boolean z = true;
                boolean z2 = desktopModeStateWrapperCreate.getEnabled() == desktopModeStateWrapperCreate.getEnabledConstant();
                int displayType = desktopModeStateWrapperCreate.getDisplayType();
                if (!z2 || displayType != desktopModeStateWrapperCreate.getDisplayTypeDualConstant()) {
                    z = false;
                }
                Log.d(SpenConfiguration.TAG, "isDexDualMode: isEnabled=" + z2 + ", isDualMode=" + z);
                return z;
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "isDexDualMode exception: " + e);
                return false;
            }
        }

        @JvmStatic
        public final boolean isNewDexMode(Context context) {
            if (context == null) {
                return false;
            }
            return SettingsSystemWrapper.create(context).getIntForUser(context.getContentResolver(), "new_dex", 0, SettingsSystemWrapper.USER_OWNER) == 1;
        }

        @JvmStatic
        public final boolean isSystemDarkMode(Context context) {
            Resources resources;
            Configuration configuration;
            return (((context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? -1 : configuration.uiMode) & 48) == 32;
        }

        @JvmStatic
        public final int getOneUiVersion(Context context) {
            try {
                String str = SystemPropertiesWrapper.create(context).get("ro.build.version.oneui");
                Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                return Integer.parseInt(str);
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "getOneUiVersion PlatformException: " + e);
                return 0;
            } catch (NumberFormatException e2) {
                Log.e(SpenConfiguration.TAG, "getOneUiVersion NumberFormatException: " + e2);
                return 0;
            }
        }

        @JvmStatic
        public final Integer getConfigAiVersion(Context context) {
            try {
                return Integer.valueOf(FloatingFeatureWrapper.create(context).getInt(SpenConfiguration.CONFIG_AI_VERSION));
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "getConfigAiVersion exception: " + e);
                return null;
            }
        }

        @JvmStatic
        public final boolean isLandscapeQuirk() {
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(str) && str.length() >= 7) {
                Intrinsics.checkNotNull(str);
                String strSubstring = str.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                if (StringsKt.startsWith$default(strSubstring, "F968", false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }
    }
}
