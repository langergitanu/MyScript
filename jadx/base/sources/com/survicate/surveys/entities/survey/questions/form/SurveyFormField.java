package com.survicate.surveys.entities.survey.questions.form;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.translations.SurveyPointEntryTranslation;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SurveyFormField.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002:\u000278B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB?\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u0012\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J3\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010%\u001a\u00020\u000eJ\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000eJ%\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001d¨\u00069"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormField;", "Landroid/os/Parcelable;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointEntryTranslation;", "id", "", "label", "", "fieldType", "required", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getLabel$annotations", "getLabel", "()Ljava/lang/String;", "getFieldType$annotations", "getFieldType", "getRequired$annotations", "getRequired", "()Z", "translatedWith", "translation", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyFormField implements Parcelable, Translatable<SurveyPointEntryTranslation, SurveyFormField> {
    private final String fieldType;
    private final long id;
    private final String label;
    private final boolean required;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyFormField> CREATOR = new Creator();

    /* JADX INFO: compiled from: SurveyFormField.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyFormField> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyFormField createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurveyFormField(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyFormField[] newArray(int i) {
            return new SurveyFormField[i];
        }
    }

    public static /* synthetic */ SurveyFormField copy$default(SurveyFormField surveyFormField, long j, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = surveyFormField.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = surveyFormField.label;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = surveyFormField.fieldType;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            z = surveyFormField.required;
        }
        return surveyFormField.copy(j2, str3, str4, z);
    }

    @SerialName("field_type")
    public static /* synthetic */ void getFieldType$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("label")
    public static /* synthetic */ void getLabel$annotations() {
    }

    @SerialName("required")
    public static /* synthetic */ void getRequired$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFieldType() {
        return this.fieldType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    public final SurveyFormField copy(long id, String label, String fieldType, boolean required) {
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        return new SurveyFormField(id, label, fieldType, required);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyFormField)) {
            return false;
        }
        SurveyFormField surveyFormField = (SurveyFormField) other;
        return this.id == surveyFormField.id && Intrinsics.areEqual(this.label, surveyFormField.label) && Intrinsics.areEqual(this.fieldType, surveyFormField.fieldType) && this.required == surveyFormField.required;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.label;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fieldType.hashCode()) * 31) + Boolean.hashCode(this.required);
    }

    public String toString() {
        return "SurveyFormField(id=" + this.id + ", label=" + this.label + ", fieldType=" + this.fieldType + ", required=" + this.required + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.label);
        dest.writeString(this.fieldType);
        dest.writeInt(this.required ? 1 : 0);
    }

    /* JADX INFO: compiled from: SurveyFormField.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormField$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormField;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyFormField> serializer() {
            return SurveyFormField$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyFormField(int i, long j, String str, String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, SurveyFormField$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.label = str;
        this.fieldType = str2;
        this.required = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyFormField self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.label);
        output.encodeStringElement(serialDesc, 2, self.fieldType);
        output.encodeBooleanElement(serialDesc, 3, self.required);
    }

    public SurveyFormField(long j, String str, String fieldType, boolean z) {
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        this.id = j;
        this.label = str;
        this.fieldType = fieldType;
        this.required = z;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getFieldType() {
        return this.fieldType;
    }

    public final boolean getRequired() {
        return this.required;
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyFormField translatedWith(SurveyPointEntryTranslation translation) {
        return copy$default(this, 0L, StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getValue() : null, this.label), null, false, 13, null);
    }
}
