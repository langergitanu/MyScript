package com.survicate.surveys.entities.survey.theme.network;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: NetworkTheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB]\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003JS\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010 R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010%R\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010%¨\u0006?"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/network/NetworkTheme;", "", "id", "", "type", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeType;", "hasDarkMode", "", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;", "colorSchemeDark", "settings", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;", "settingsDark", "<init>", "(ILcom/survicate/surveys/entities/survey/theme/network/NetworkThemeType;ZLcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/survicate/surveys/entities/survey/theme/network/NetworkThemeType;ZLcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()I", "getType$annotations", "getType", "()Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeType;", "getHasDarkMode$annotations", "getHasDarkMode", "()Z", "getColorScheme$annotations", "getColorScheme", "()Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;", "getColorSchemeDark$annotations", "getColorSchemeDark", "getSettings$annotations", "getSettings", "()Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;", "getSettingsDark$annotations", "getSettingsDark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkTheme {
    private final NetworkColorScheme colorScheme;
    private final NetworkColorScheme colorSchemeDark;
    private final boolean hasDarkMode;
    private final int id;
    private final NetworkThemeSettings settings;
    private final NetworkThemeSettings settingsDark;
    private final NetworkThemeType type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.theme.network.NetworkTheme$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkTheme._childSerializers$_anonymous_();
        }
    }), null, null, null, null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.theme.network.NetworkThemeType", NetworkThemeType.values(), new String[]{"MicroTheme"}, new Annotation[][]{null}, null);
    }

    public static /* synthetic */ NetworkTheme copy$default(NetworkTheme networkTheme, int i, NetworkThemeType networkThemeType, boolean z, NetworkColorScheme networkColorScheme, NetworkColorScheme networkColorScheme2, NetworkThemeSettings networkThemeSettings, NetworkThemeSettings networkThemeSettings2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = networkTheme.id;
        }
        if ((i2 & 2) != 0) {
            networkThemeType = networkTheme.type;
        }
        if ((i2 & 4) != 0) {
            z = networkTheme.hasDarkMode;
        }
        if ((i2 & 8) != 0) {
            networkColorScheme = networkTheme.colorScheme;
        }
        if ((i2 & 16) != 0) {
            networkColorScheme2 = networkTheme.colorSchemeDark;
        }
        if ((i2 & 32) != 0) {
            networkThemeSettings = networkTheme.settings;
        }
        if ((i2 & 64) != 0) {
            networkThemeSettings2 = networkTheme.settingsDark;
        }
        NetworkThemeSettings networkThemeSettings3 = networkThemeSettings;
        NetworkThemeSettings networkThemeSettings4 = networkThemeSettings2;
        NetworkColorScheme networkColorScheme3 = networkColorScheme2;
        boolean z2 = z;
        return networkTheme.copy(i, networkThemeType, z2, networkColorScheme, networkColorScheme3, networkThemeSettings3, networkThemeSettings4);
    }

    @SerialName("color_scheme")
    public static /* synthetic */ void getColorScheme$annotations() {
    }

    @SerialName("color_scheme_dark")
    public static /* synthetic */ void getColorSchemeDark$annotations() {
    }

    @SerialName("has_dark_mode")
    public static /* synthetic */ void getHasDarkMode$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("settings")
    public static /* synthetic */ void getSettings$annotations() {
    }

    @SerialName("settings_dark")
    public static /* synthetic */ void getSettingsDark$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NetworkThemeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasDarkMode() {
        return this.hasDarkMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final NetworkColorScheme getColorScheme() {
        return this.colorScheme;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final NetworkColorScheme getColorSchemeDark() {
        return this.colorSchemeDark;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final NetworkThemeSettings getSettings() {
        return this.settings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final NetworkThemeSettings getSettingsDark() {
        return this.settingsDark;
    }

    public final NetworkTheme copy(int id, NetworkThemeType type, boolean hasDarkMode, NetworkColorScheme colorScheme, NetworkColorScheme colorSchemeDark, NetworkThemeSettings settings, NetworkThemeSettings settingsDark) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new NetworkTheme(id, type, hasDarkMode, colorScheme, colorSchemeDark, settings, settingsDark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkTheme)) {
            return false;
        }
        NetworkTheme networkTheme = (NetworkTheme) other;
        return this.id == networkTheme.id && this.type == networkTheme.type && this.hasDarkMode == networkTheme.hasDarkMode && Intrinsics.areEqual(this.colorScheme, networkTheme.colorScheme) && Intrinsics.areEqual(this.colorSchemeDark, networkTheme.colorSchemeDark) && Intrinsics.areEqual(this.settings, networkTheme.settings) && Intrinsics.areEqual(this.settingsDark, networkTheme.settingsDark);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.hasDarkMode)) * 31) + this.colorScheme.hashCode()) * 31;
        NetworkColorScheme networkColorScheme = this.colorSchemeDark;
        int iHashCode2 = (((iHashCode + (networkColorScheme == null ? 0 : networkColorScheme.hashCode())) * 31) + this.settings.hashCode()) * 31;
        NetworkThemeSettings networkThemeSettings = this.settingsDark;
        return iHashCode2 + (networkThemeSettings != null ? networkThemeSettings.hashCode() : 0);
    }

    public String toString() {
        return "NetworkTheme(id=" + this.id + ", type=" + this.type + ", hasDarkMode=" + this.hasDarkMode + ", colorScheme=" + this.colorScheme + ", colorSchemeDark=" + this.colorSchemeDark + ", settings=" + this.settings + ", settingsDark=" + this.settingsDark + ')';
    }

    /* JADX INFO: compiled from: NetworkTheme.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/network/NetworkTheme$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkTheme;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkTheme> serializer() {
            return NetworkTheme$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NetworkTheme(int i, int i2, NetworkThemeType networkThemeType, boolean z, NetworkColorScheme networkColorScheme, NetworkColorScheme networkColorScheme2, NetworkThemeSettings networkThemeSettings, NetworkThemeSettings networkThemeSettings2, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, NetworkTheme$$serializer.INSTANCE.getDescriptor());
        }
        this.id = i2;
        this.type = networkThemeType;
        this.hasDarkMode = z;
        this.colorScheme = networkColorScheme;
        this.colorSchemeDark = networkColorScheme2;
        this.settings = networkThemeSettings;
        this.settingsDark = networkThemeSettings2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkTheme self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.type);
        output.encodeBooleanElement(serialDesc, 2, self.hasDarkMode);
        output.encodeSerializableElement(serialDesc, 3, NetworkColorScheme$$serializer.INSTANCE, self.colorScheme);
        output.encodeNullableSerializableElement(serialDesc, 4, NetworkColorScheme$$serializer.INSTANCE, self.colorSchemeDark);
        output.encodeSerializableElement(serialDesc, 5, NetworkThemeSettings$$serializer.INSTANCE, self.settings);
        output.encodeNullableSerializableElement(serialDesc, 6, NetworkThemeSettings$$serializer.INSTANCE, self.settingsDark);
    }

    public NetworkTheme(int i, NetworkThemeType type, boolean z, NetworkColorScheme colorScheme, NetworkColorScheme networkColorScheme, NetworkThemeSettings settings, NetworkThemeSettings networkThemeSettings) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.id = i;
        this.type = type;
        this.hasDarkMode = z;
        this.colorScheme = colorScheme;
        this.colorSchemeDark = networkColorScheme;
        this.settings = settings;
        this.settingsDark = networkThemeSettings;
    }

    public final int getId() {
        return this.id;
    }

    public final NetworkThemeType getType() {
        return this.type;
    }

    public final boolean getHasDarkMode() {
        return this.hasDarkMode;
    }

    public final NetworkColorScheme getColorScheme() {
        return this.colorScheme;
    }

    public final NetworkColorScheme getColorSchemeDark() {
        return this.colorSchemeDark;
    }

    public final NetworkThemeSettings getSettings() {
        return this.settings;
    }

    public final NetworkThemeSettings getSettingsDark() {
        return this.settingsDark;
    }
}
