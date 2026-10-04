package com.survicate.surveys.entities.survey.questions.form;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.translations.SurveyPointEntryTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyPointTranslation;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.presentation.base.SurveyPointDisplayer;
import com.survicate.surveys.presentation.base.SurveyViewModel;
import com.survicate.surveys.utils.extensions.StringExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SurveyFormSurveyPoint.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 V2\u00020\u0001:\u0002UVBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bc\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u001c\u0010)\u001a\u0006\u0012\u0002\b\u00030*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u000101H\u0016J,\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u000bH\u0002J\b\u00105\u001a\u000206H\u0016J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003JY\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0006\u0010C\u001a\u00020\bJ\u0013\u0010D\u001a\u0002062\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\bHÖ\u0001J\t\u0010H\u001a\u00020\u0005HÖ\u0001J\u0016\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\bJ%\u0010N\u001a\u00020J2\u0006\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0001¢\u0006\u0002\bTR\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0007\u001a\u00020\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u001bR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010%R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010(¨\u0006W"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "id", "", FirebaseAnalytics.Param.CONTENT, "", "description", "maxPath", "", "answerType", "fields", "", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormField;", "settings", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormPointSettings;", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormPointSettings;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormPointSettings;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getContent$annotations", "getContent", "()Ljava/lang/String;", "getDescription$annotations", "getDescription", "getMaxPath$annotations", "getMaxPath", "()I", "getAnswerType$annotations", "getAnswerType", "getFields$annotations", "getFields", "()Ljava/util/List;", "getSettings$annotations", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormPointSettings;", "getDisplayer", "Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "translatedWith", "translation", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointTranslation;", "translateFormFields", "translations", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointEntryTranslation;", "isMandatory", "", "getSurveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "getDisclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
@SerialName("SurveyForm")
public final /* data */ class SurveyFormSurveyPoint implements SurveyPoint {
    private final String answerType;
    private final String content;
    private final String description;
    private final List<SurveyFormField> fields;
    private final long id;
    private final int maxPath;
    private final SurveyFormPointSettings settings;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyFormSurveyPoint> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyFormSurveyPoint._childSerializers$_anonymous_();
        }
    }), null};

    /* JADX INFO: compiled from: SurveyFormSurveyPoint.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyFormSurveyPoint> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyFormSurveyPoint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            String string3 = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(SurveyFormField.CREATOR.createFromParcel(parcel));
            }
            return new SurveyFormSurveyPoint(j, string, string2, i, string3, arrayList, SurveyFormPointSettings.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyFormSurveyPoint[] newArray(int i) {
            return new SurveyFormSurveyPoint[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SurveyFormField$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyFormSurveyPoint copy$default(SurveyFormSurveyPoint surveyFormSurveyPoint, long j, String str, String str2, int i, String str3, List list, SurveyFormPointSettings surveyFormPointSettings, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = surveyFormSurveyPoint.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = surveyFormSurveyPoint.content;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = surveyFormSurveyPoint.description;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            i = surveyFormSurveyPoint.maxPath;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str3 = surveyFormSurveyPoint.answerType;
        }
        return surveyFormSurveyPoint.copy(j2, str4, str5, i3, str3, (i2 & 32) != 0 ? surveyFormSurveyPoint.fields : list, (i2 & 64) != 0 ? surveyFormSurveyPoint.settings : surveyFormPointSettings);
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

    @SerialName("fields")
    public static /* synthetic */ void getFields$annotations() {
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

    public final List<SurveyFormField> component6() {
        return this.fields;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SurveyFormPointSettings getSettings() {
        return this.settings;
    }

    public final SurveyFormSurveyPoint copy(long id, String content, String description, int maxPath, String answerType, List<SurveyFormField> fields, SurveyFormPointSettings settings) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new SurveyFormSurveyPoint(id, content, description, maxPath, answerType, fields, settings);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyFormSurveyPoint)) {
            return false;
        }
        SurveyFormSurveyPoint surveyFormSurveyPoint = (SurveyFormSurveyPoint) other;
        return this.id == surveyFormSurveyPoint.id && Intrinsics.areEqual(this.content, surveyFormSurveyPoint.content) && Intrinsics.areEqual(this.description, surveyFormSurveyPoint.description) && this.maxPath == surveyFormSurveyPoint.maxPath && Intrinsics.areEqual(this.answerType, surveyFormSurveyPoint.answerType) && Intrinsics.areEqual(this.fields, surveyFormSurveyPoint.fields) && Intrinsics.areEqual(this.settings, surveyFormSurveyPoint.settings);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        return ((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.maxPath)) * 31) + this.answerType.hashCode()) * 31) + this.fields.hashCode()) * 31) + this.settings.hashCode();
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public boolean isMandatory() {
        return false;
    }

    public String toString() {
        return "SurveyFormSurveyPoint(id=" + this.id + ", content=" + this.content + ", description=" + this.description + ", maxPath=" + this.maxPath + ", answerType=" + this.answerType + ", fields=" + this.fields + ", settings=" + this.settings + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.content);
        dest.writeString(this.description);
        dest.writeInt(this.maxPath);
        dest.writeString(this.answerType);
        List<SurveyFormField> list = this.fields;
        dest.writeInt(list.size());
        Iterator<SurveyFormField> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        this.settings.writeToParcel(dest, flags);
    }

    /* JADX INFO: compiled from: SurveyFormSurveyPoint.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyFormSurveyPoint> serializer() {
            return SurveyFormSurveyPoint$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyFormSurveyPoint(int i, long j, String str, String str2, int i2, String str3, List list, SurveyFormPointSettings surveyFormPointSettings, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, SurveyFormSurveyPoint$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.content = str;
        this.description = str2;
        this.maxPath = i2;
        this.answerType = str3;
        this.fields = list;
        this.settings = surveyFormPointSettings;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyFormSurveyPoint self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.getId());
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getContent());
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getDescription());
        output.encodeIntElement(serialDesc, 3, self.getMaxPath());
        output.encodeStringElement(serialDesc, 4, self.getAnswerType());
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.fields);
        output.encodeSerializableElement(serialDesc, 6, SurveyFormPointSettings$$serializer.INSTANCE, self.settings);
    }

    public SurveyFormSurveyPoint(long j, String str, String str2, int i, String answerType, List<SurveyFormField> fields, SurveyFormPointSettings settings) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.id = j;
        this.content = str;
        this.description = str2;
        this.maxPath = i;
        this.answerType = answerType;
        this.fields = fields;
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

    public final List<SurveyFormField> getFields() {
        return this.fields;
    }

    public final SurveyFormPointSettings getSettings() {
        return this.settings;
    }

    @Override // com.survicate.surveys.entities.survey.questions.SurveyPoint
    public SurveyPointDisplayer<?> getDisplayer(DisplayEngine displayEngine, SurveyViewModel surveyViewModel) {
        Intrinsics.checkNotNullParameter(displayEngine, "displayEngine");
        Intrinsics.checkNotNullParameter(surveyViewModel, "surveyViewModel");
        throw new IllegalStateException("FORM answer type does not use a SurveyPointDisplayer".toString());
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyPoint translatedWith(SurveyPointTranslation translation) {
        return copy$default(this, 0L, StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getContent() : null, getContent()), StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getDescription() : null, getDescription()), 0, null, translateFormFields(this.fields, translation != null ? translation.getFields() : null), this.settings.translatedWith(translation != null ? translation.getSettings() : null), 25, null);
    }

    private final List<SurveyFormField> translateFormFields(List<SurveyFormField> fields, List<SurveyPointEntryTranslation> translations) {
        List<SurveyFormField> list = fields;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SurveyFormField surveyFormField : list) {
            SurveyPointEntryTranslation surveyPointEntryTranslation = null;
            Object obj = null;
            if (translations != null) {
                Iterator<T> it = translations.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((SurveyPointEntryTranslation) next).getId() == surveyFormField.getId()) {
                        obj = next;
                        break;
                    }
                }
                surveyPointEntryTranslation = (SurveyPointEntryTranslation) obj;
            }
            arrayList.add(surveyFormField.translatedWith(surveyPointEntryTranslation));
        }
        return arrayList;
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
