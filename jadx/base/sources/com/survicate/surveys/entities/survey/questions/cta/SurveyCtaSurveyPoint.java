package com.survicate.surveys.entities.survey.questions.cta;

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
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: compiled from: SurveyCtaSurveyPoint.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName("SurveyCta")
@Metadata(m1598d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBS\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u001c\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\r\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003JI\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u0010;\u001a\u00020\bJ\u0013\u0010<\u001a\u00020/2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\bHÖ\u0001J\t\u0010@\u001a\u00020\u0005HÖ\u0001J\u0016\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\bJ%\u0010F\u001a\u00020B2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0018R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"¨\u0006O"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "id", "", FirebaseAnalytics.Param.CONTENT, "", "description", "maxPath", "", "answerType", "ctaSettings", "Lcom/survicate/surveys/entities/survey/questions/cta/CtaSettings;", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/survicate/surveys/entities/survey/questions/cta/CtaSettings;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/survicate/surveys/entities/survey/questions/cta/CtaSettings;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getContent$annotations", "getContent", "()Ljava/lang/String;", "getDescription$annotations", "getDescription", "getMaxPath$annotations", "getMaxPath", "()I", "getAnswerType$annotations", "getAnswerType", "getCtaSettings$annotations", "getCtaSettings", "()Lcom/survicate/surveys/entities/survey/questions/cta/CtaSettings;", "getDisplayer", "Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "translatedWith", "translation", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointTranslation;", "getNextSurveyPointId", "()Ljava/lang/Long;", "isMandatory", "", "getSurveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "getDisclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyCtaSurveyPoint implements SurveyPoint {
    private final String answerType;
    private final String content;
    private final CtaSettings ctaSettings;
    private final String description;
    private final long id;
    private final int maxPath;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyCtaSurveyPoint> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyCtaSurveyPoint._childSerializers$_anonymous_();
        }
    })};

    /* JADX INFO: compiled from: SurveyCtaSurveyPoint.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyCtaSurveyPoint> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyCtaSurveyPoint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurveyCtaSurveyPoint(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), (CtaSettings) parcel.readParcelable(SurveyCtaSurveyPoint.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyCtaSurveyPoint[] newArray(int i) {
            return new SurveyCtaSurveyPoint[i];
        }
    }

    public static /* synthetic */ SurveyCtaSurveyPoint copy$default(SurveyCtaSurveyPoint surveyCtaSurveyPoint, long j, String str, String str2, int i, String str3, CtaSettings ctaSettings, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = surveyCtaSurveyPoint.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = surveyCtaSurveyPoint.content;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = surveyCtaSurveyPoint.description;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            i = surveyCtaSurveyPoint.maxPath;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str3 = surveyCtaSurveyPoint.answerType;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            ctaSettings = surveyCtaSurveyPoint.ctaSettings;
        }
        return surveyCtaSurveyPoint.copy(j2, str4, str5, i3, str6, ctaSettings);
    }

    @SerialName("answer_type")
    public static /* synthetic */ void getAnswerType$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.CONTENT)
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("settings")
    public static /* synthetic */ void getCtaSettings$annotations() {
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
    public final CtaSettings getCtaSettings() {
        return this.ctaSettings;
    }

    public final SurveyCtaSurveyPoint copy(long id, String content, String description, int maxPath, String answerType, CtaSettings ctaSettings) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(ctaSettings, "ctaSettings");
        return new SurveyCtaSurveyPoint(id, content, description, maxPath, answerType, ctaSettings);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyCtaSurveyPoint)) {
            return false;
        }
        SurveyCtaSurveyPoint surveyCtaSurveyPoint = (SurveyCtaSurveyPoint) other;
        return this.id == surveyCtaSurveyPoint.id && Intrinsics.areEqual(this.content, surveyCtaSurveyPoint.content) && Intrinsics.areEqual(this.description, surveyCtaSurveyPoint.description) && this.maxPath == surveyCtaSurveyPoint.maxPath && Intrinsics.areEqual(this.answerType, surveyCtaSurveyPoint.answerType) && Intrinsics.areEqual(this.ctaSettings, surveyCtaSurveyPoint.ctaSettings);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.maxPath)) * 31) + this.answerType.hashCode()) * 31) + this.ctaSettings.hashCode();
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public boolean isMandatory() {
        return true;
    }

    public String toString() {
        return "SurveyCtaSurveyPoint(id=" + this.id + ", content=" + this.content + ", description=" + this.description + ", maxPath=" + this.maxPath + ", answerType=" + this.answerType + ", ctaSettings=" + this.ctaSettings + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.content);
        dest.writeString(this.description);
        dest.writeInt(this.maxPath);
        dest.writeString(this.answerType);
        dest.writeParcelable(this.ctaSettings, flags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        final String str = "answer_type";
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(CtaSettings.class), new Annotation[]{new JsonClassDiscriminator(str) { // from class: com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0
            private final /* synthetic */ String discriminator;

            {
                Intrinsics.checkNotNullParameter(str, "discriminator");
                this.discriminator = str;
            }

            @Override // java.lang.annotation.Annotation
            public final /* synthetic */ Class annotationType() {
                return JsonClassDiscriminator.class;
            }

            @Override // kotlinx.serialization.json.JsonClassDiscriminator
            public final /* synthetic */ String discriminator() {
                return this.discriminator;
            }

            @Override // java.lang.annotation.Annotation
            public final boolean equals(Object obj) {
                return (obj instanceof JsonClassDiscriminator) && Intrinsics.areEqual(discriminator(), ((JsonClassDiscriminator) obj).discriminator());
            }

            @Override // java.lang.annotation.Annotation
            public final int hashCode() {
                return ("discriminator".hashCode() * 127) ^ this.discriminator.hashCode();
            }

            @Override // java.lang.annotation.Annotation
            public final String toString() {
                return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.discriminator + ')';
            }
        }});
    }

    /* JADX INFO: compiled from: SurveyCtaSurveyPoint.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyCtaSurveyPoint> serializer() {
            return SurveyCtaSurveyPoint$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyCtaSurveyPoint(int i, long j, String str, String str2, int i2, String str3, CtaSettings ctaSettings, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, SurveyCtaSurveyPoint$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.content = str;
        this.description = str2;
        this.maxPath = i2;
        this.answerType = str3;
        this.ctaSettings = ctaSettings;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyCtaSurveyPoint self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.getId());
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getContent());
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getDescription());
        output.encodeIntElement(serialDesc, 3, self.getMaxPath());
        output.encodeStringElement(serialDesc, 4, self.getAnswerType());
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.ctaSettings);
    }

    public SurveyCtaSurveyPoint(long j, String str, String str2, int i, String answerType, CtaSettings ctaSettings) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(ctaSettings, "ctaSettings");
        this.id = j;
        this.content = str;
        this.description = str2;
        this.maxPath = i;
        this.answerType = answerType;
        this.ctaSettings = ctaSettings;
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

    public final CtaSettings getCtaSettings() {
        return this.ctaSettings;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public SurveyPointDisplayer<?> getDisplayer(DisplayEngine displayEngine, SurveyViewModel surveyViewModel) {
        Intrinsics.checkNotNullParameter(displayEngine, "displayEngine");
        Intrinsics.checkNotNullParameter(surveyViewModel, "surveyViewModel");
        throw new IllegalStateException("CTA answer type does not use a SurveyPointDisplayer".toString());
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyPoint translatedWith(SurveyPointTranslation translation) {
        return copy$default(this, 0L, StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getContent() : null, getContent()), StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getDescription() : null, getDescription()), 0, null, this.ctaSettings.translatedWith(translation != null ? translation.getSettings() : null), 25, null);
    }

    public final Long getNextSurveyPointId() {
        return this.ctaSettings.getNextSurveyPointId();
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public SurveyPointImage getSurveyPointImage() {
        return this.ctaSettings.getSurveyPointImage();
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public DisclaimerSettings getDisclaimerSettings() {
        return this.ctaSettings.getDisclaimerSettings();
    }
}
