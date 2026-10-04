package com.survicate.surveys.entities.survey.questions;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.translations.DisclaimerSettingsTranslation;
import com.survicate.surveys.entities.survey.translations.Translatable;
import com.survicate.surveys.utils.extensions.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: DisclaimerSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002:\u00029:B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fBI\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u0012\u0010\u001f\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J;\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0006\u0010'\u001a\u00020\u000eJ\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u000eHÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000eJ%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015¨\u0006;"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "Landroid/os/Parcelable;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/DisclaimerSettingsTranslation;", "title", "", "description", "checkboxVisible", "", "checkboxRequired", "checkboxLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getDescription$annotations", "getDescription", "getCheckboxVisible$annotations", "getCheckboxVisible", "()Z", "getCheckboxRequired$annotations", "getCheckboxRequired", "getCheckboxLabel$annotations", "getCheckboxLabel", "translatedWith", "translation", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class DisclaimerSettings implements Parcelable, Translatable<DisclaimerSettingsTranslation, DisclaimerSettings> {
    private final String checkboxLabel;
    private final boolean checkboxRequired;
    private final boolean checkboxVisible;
    private final String description;
    private final String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<DisclaimerSettings> CREATOR = new Creator();

    /* JADX INFO: compiled from: DisclaimerSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<DisclaimerSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DisclaimerSettings createFromParcel(Parcel parcel) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            boolean z2 = true;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z2 = false;
            }
            return new DisclaimerSettings(string, string2, z2, parcel.readInt() != 0 ? z : false, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DisclaimerSettings[] newArray(int i) {
            return new DisclaimerSettings[i];
        }
    }

    public static /* synthetic */ DisclaimerSettings copy$default(DisclaimerSettings disclaimerSettings, String str, String str2, boolean z, boolean z2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = disclaimerSettings.title;
        }
        if ((i & 2) != 0) {
            str2 = disclaimerSettings.description;
        }
        if ((i & 4) != 0) {
            z = disclaimerSettings.checkboxVisible;
        }
        if ((i & 8) != 0) {
            z2 = disclaimerSettings.checkboxRequired;
        }
        if ((i & 16) != 0) {
            str3 = disclaimerSettings.checkboxLabel;
        }
        String str4 = str3;
        boolean z3 = z;
        return disclaimerSettings.copy(str, str2, z3, z2, str4);
    }

    @SerialName("checkbox_label")
    public static /* synthetic */ void getCheckboxLabel$annotations() {
    }

    @SerialName("checkbox_required")
    public static /* synthetic */ void getCheckboxRequired$annotations() {
    }

    @SerialName("checkbox_visible")
    public static /* synthetic */ void getCheckboxVisible$annotations() {
    }

    @SerialName("description")
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCheckboxVisible() {
        return this.checkboxVisible;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCheckboxRequired() {
        return this.checkboxRequired;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCheckboxLabel() {
        return this.checkboxLabel;
    }

    public final DisclaimerSettings copy(String title, String description, boolean checkboxVisible, boolean checkboxRequired, String checkboxLabel) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(checkboxLabel, "checkboxLabel");
        return new DisclaimerSettings(title, description, checkboxVisible, checkboxRequired, checkboxLabel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisclaimerSettings)) {
            return false;
        }
        DisclaimerSettings disclaimerSettings = (DisclaimerSettings) other;
        return Intrinsics.areEqual(this.title, disclaimerSettings.title) && Intrinsics.areEqual(this.description, disclaimerSettings.description) && this.checkboxVisible == disclaimerSettings.checkboxVisible && this.checkboxRequired == disclaimerSettings.checkboxRequired && Intrinsics.areEqual(this.checkboxLabel, disclaimerSettings.checkboxLabel);
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.checkboxVisible)) * 31) + Boolean.hashCode(this.checkboxRequired)) * 31) + this.checkboxLabel.hashCode();
    }

    public String toString() {
        return "DisclaimerSettings(title=" + this.title + ", description=" + this.description + ", checkboxVisible=" + this.checkboxVisible + ", checkboxRequired=" + this.checkboxRequired + ", checkboxLabel=" + this.checkboxLabel + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeInt(this.checkboxVisible ? 1 : 0);
        dest.writeInt(this.checkboxRequired ? 1 : 0);
        dest.writeString(this.checkboxLabel);
    }

    /* JADX INFO: compiled from: DisclaimerSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DisclaimerSettings> serializer() {
            return DisclaimerSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DisclaimerSettings(int i, String str, String str2, boolean z, boolean z2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, DisclaimerSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.title = str;
        this.description = str2;
        this.checkboxVisible = z;
        this.checkboxRequired = z2;
        this.checkboxLabel = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(DisclaimerSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.title);
        output.encodeStringElement(serialDesc, 1, self.description);
        output.encodeBooleanElement(serialDesc, 2, self.checkboxVisible);
        output.encodeBooleanElement(serialDesc, 3, self.checkboxRequired);
        output.encodeStringElement(serialDesc, 4, self.checkboxLabel);
    }

    public DisclaimerSettings(String title, String description, boolean z, boolean z2, String checkboxLabel) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(checkboxLabel, "checkboxLabel");
        this.title = title;
        this.description = description;
        this.checkboxVisible = z;
        this.checkboxRequired = z2;
        this.checkboxLabel = checkboxLabel;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getCheckboxVisible() {
        return this.checkboxVisible;
    }

    public final boolean getCheckboxRequired() {
        return this.checkboxRequired;
    }

    public final String getCheckboxLabel() {
        return this.checkboxLabel;
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public DisclaimerSettings translatedWith(DisclaimerSettingsTranslation translation) {
        return copy$default(this, StringExtensionsKt.ifNullOrBlank(translation != null ? translation.getTitle() : null, this.title), StringExtensionsKt.ifNullOrBlank(translation != null ? translation.getDescription() : null, this.description), false, false, StringExtensionsKt.ifNullOrBlank(translation != null ? translation.getCheckboxLabel() : null, this.checkboxLabel), 12, null);
    }
}
