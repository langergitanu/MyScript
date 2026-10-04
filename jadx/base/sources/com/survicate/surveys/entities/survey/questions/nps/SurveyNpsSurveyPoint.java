package com.survicate.surveys.entities.survey.questions.nps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.translations.SurveyPointTranslation;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.presentation.base.SurveyPointDisplayer;
import com.survicate.surveys.presentation.base.SurveyViewModel;
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

/* JADX INFO: compiled from: SurveyNpsSurveyPoint.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName("SurveyNps")
@Metadata(m1598d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002KLB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBS\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u001c\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003JI\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u00109\u001a\u00020\bJ\u0013\u0010:\u001a\u00020-2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\bHÖ\u0001J\t\u0010>\u001a\u00020\u0005HÖ\u0001J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\bJ%\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0018R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"¨\u0006M"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "id", "", FirebaseAnalytics.Param.CONTENT, "", "description", "maxPath", "", "answerType", "settings", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getContent$annotations", "getContent", "()Ljava/lang/String;", "getDescription$annotations", "getDescription", "getMaxPath$annotations", "getMaxPath", "()I", "getAnswerType$annotations", "getAnswerType", "getSettings$annotations", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "getDisplayer", "Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "translatedWith", "translation", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointTranslation;", "isMandatory", "", "getSurveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "getDisclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyNpsSurveyPoint implements SurveyPoint {
    private final String answerType;
    private final String content;
    private final String description;
    private final long id;
    private final int maxPath;
    private final SurveyNpsPointSettings settings;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyNpsSurveyPoint> CREATOR = new Creator();

    /* JADX INFO: compiled from: SurveyNpsSurveyPoint.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyNpsSurveyPoint> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyNpsSurveyPoint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurveyNpsSurveyPoint(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), SurveyNpsPointSettings.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyNpsSurveyPoint[] newArray(int i) {
            return new SurveyNpsSurveyPoint[i];
        }
    }

    public static /* synthetic */ SurveyNpsSurveyPoint copy$default(SurveyNpsSurveyPoint surveyNpsSurveyPoint, long j, String str, String str2, int i, String str3, SurveyNpsPointSettings surveyNpsPointSettings, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = surveyNpsSurveyPoint.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = surveyNpsSurveyPoint.content;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = surveyNpsSurveyPoint.description;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            i = surveyNpsSurveyPoint.maxPath;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str3 = surveyNpsSurveyPoint.answerType;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            surveyNpsPointSettings = surveyNpsSurveyPoint.settings;
        }
        return surveyNpsSurveyPoint.copy(j2, str4, str5, i3, str6, surveyNpsPointSettings);
    }

    @SerialName("answer_type")
    public static /* synthetic */ void getAnswerType$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.CONTENT)
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("description")
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("max_path")
    public static /* synthetic */ void getMaxPath$annotations() {
    }

    @SerialName("settings")
    public static /* synthetic */ void getSettings$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMaxPath() {
        return this.maxPath;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnswerType() {
        return this.answerType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SurveyNpsPointSettings getSettings() {
        return this.settings;
    }

    public final SurveyNpsSurveyPoint copy(long id, String content, String description, int maxPath, String answerType, SurveyNpsPointSettings settings) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new SurveyNpsSurveyPoint(id, content, description, maxPath, answerType, settings);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyNpsSurveyPoint)) {
            return false;
        }
        SurveyNpsSurveyPoint surveyNpsSurveyPoint = (SurveyNpsSurveyPoint) other;
        return this.id == surveyNpsSurveyPoint.id && Intrinsics.areEqual(this.content, surveyNpsSurveyPoint.content) && Intrinsics.areEqual(this.description, surveyNpsSurveyPoint.description) && this.maxPath == surveyNpsSurveyPoint.maxPath && Intrinsics.areEqual(this.answerType, surveyNpsSurveyPoint.answerType) && Intrinsics.areEqual(this.settings, surveyNpsSurveyPoint.settings);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.maxPath)) * 31) + this.answerType.hashCode()) * 31) + this.settings.hashCode();
    }

    public String toString() {
        return "SurveyNpsSurveyPoint(id=" + this.id + ", content=" + this.content + ", description=" + this.description + ", maxPath=" + this.maxPath + ", answerType=" + this.answerType + ", settings=" + this.settings + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.content);
        dest.writeString(this.description);
        dest.writeInt(this.maxPath);
        dest.writeString(this.answerType);
        this.settings.writeToParcel(dest, flags);
    }

    /* JADX INFO: compiled from: SurveyNpsSurveyPoint.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyNpsSurveyPoint> serializer() {
            return SurveyNpsSurveyPoint$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyNpsSurveyPoint(int i, long j, String str, String str2, int i2, String str3, SurveyNpsPointSettings surveyNpsPointSettings, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, SurveyNpsSurveyPoint$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.content = str;
        this.description = str2;
        this.maxPath = i2;
        this.answerType = str3;
        this.settings = surveyNpsPointSettings;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyNpsSurveyPoint self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.getId());
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getContent());
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getDescription());
        output.encodeIntElement(serialDesc, 3, self.getMaxPath());
        output.encodeStringElement(serialDesc, 4, self.getAnswerType());
        output.encodeSerializableElement(serialDesc, 5, SurveyNpsPointSettings$$serializer.INSTANCE, self.settings);
    }

    public SurveyNpsSurveyPoint(long j, String str, String str2, int i, String answerType, SurveyNpsPointSettings settings) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.id = j;
        this.content = str;
        this.description = str2;
        this.maxPath = i;
        this.answerType = answerType;
        this.settings = settings;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public long getId() {
        return this.id;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public String getContent() {
        return this.content;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public String getDescription() {
        return this.description;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public int getMaxPath() {
        return this.maxPath;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public String getAnswerType() {
        return this.answerType;
    }

    public final SurveyNpsPointSettings getSettings() {
        return this.settings;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public SurveyPointDisplayer<?> getDisplayer(DisplayEngine displayEngine, SurveyViewModel surveyViewModel) {
        Intrinsics.checkNotNullParameter(displayEngine, "displayEngine");
        Intrinsics.checkNotNullParameter(surveyViewModel, "surveyViewModel");
        throw new IllegalStateException("NPS answer type does not use a SurveyPointDisplayer".toString());
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyPoint translatedWith(SurveyPointTranslation translation) {
        return copy$default(this, 0L, StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getContent() : null, getContent()), StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getDescription() : null, getDescription()), 0, null, this.settings.translatedWith(translation != null ? translation.getSettings() : null), 25, null);
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public boolean isMandatory() {
        return this.settings.getMandatory();
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public SurveyPointImage getSurveyPointImage() {
        return this.settings.getSurveyPointImage();
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public DisclaimerSettings getDisclaimerSettings() {
        return this.settings.getDisclaimerSettings();
    }
}
