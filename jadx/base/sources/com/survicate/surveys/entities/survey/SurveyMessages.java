package com.survicate.surveys.entities.survey;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.translations.SurveyMessagesTranslation;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SurveyMessages.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0003:\u000245B7\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0012\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010!\u001a\u00020\fJ\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\fJ%\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013¨\u00066"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/SurveyMessages;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveyMessagesTranslation;", "Landroid/os/Parcelable;", "submitText", "", "navigationBackText", "answerRequiredText", "inputTextPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSubmitText$annotations", "()V", "getSubmitText", "()Ljava/lang/String;", "getNavigationBackText$annotations", "getNavigationBackText", "getAnswerRequiredText$annotations", "getAnswerRequiredText", "getInputTextPlaceholder$annotations", "getInputTextPlaceholder", "translatedWith", "translation", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyMessages implements Translatable<SurveyMessagesTranslation, SurveyMessages>, Parcelable {
    private final String answerRequiredText;
    private final String inputTextPlaceholder;
    private final String navigationBackText;
    private final String submitText;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyMessages> CREATOR = new Creator();

    /* JADX INFO: compiled from: SurveyMessages.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyMessages> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyMessages createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurveyMessages(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyMessages[] newArray(int i) {
            return new SurveyMessages[i];
        }
    }

    public SurveyMessages() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SurveyMessages copy$default(SurveyMessages surveyMessages, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyMessages.submitText;
        }
        if ((i & 2) != 0) {
            str2 = surveyMessages.navigationBackText;
        }
        if ((i & 4) != 0) {
            str3 = surveyMessages.answerRequiredText;
        }
        if ((i & 8) != 0) {
            str4 = surveyMessages.inputTextPlaceholder;
        }
        return surveyMessages.copy(str, str2, str3, str4);
    }

    @SerialName("answer_required_text")
    public static /* synthetic */ void getAnswerRequiredText$annotations() {
    }

    @SerialName("text_placeholder")
    public static /* synthetic */ void getInputTextPlaceholder$annotations() {
    }

    @SerialName("navigation_back_text")
    public static /* synthetic */ void getNavigationBackText$annotations() {
    }

    @SerialName("submit_text")
    public static /* synthetic */ void getSubmitText$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubmitText() {
        return this.submitText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNavigationBackText() {
        return this.navigationBackText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAnswerRequiredText() {
        return this.answerRequiredText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInputTextPlaceholder() {
        return this.inputTextPlaceholder;
    }

    public final SurveyMessages copy(String submitText, String navigationBackText, String answerRequiredText, String inputTextPlaceholder) {
        return new SurveyMessages(submitText, navigationBackText, answerRequiredText, inputTextPlaceholder);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyMessages)) {
            return false;
        }
        SurveyMessages surveyMessages = (SurveyMessages) other;
        return Intrinsics.areEqual(this.submitText, surveyMessages.submitText) && Intrinsics.areEqual(this.navigationBackText, surveyMessages.navigationBackText) && Intrinsics.areEqual(this.answerRequiredText, surveyMessages.answerRequiredText) && Intrinsics.areEqual(this.inputTextPlaceholder, surveyMessages.inputTextPlaceholder);
    }

    public int hashCode() {
        String str = this.submitText;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.navigationBackText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.answerRequiredText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.inputTextPlaceholder;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "SurveyMessages(submitText=" + this.submitText + ", navigationBackText=" + this.navigationBackText + ", answerRequiredText=" + this.answerRequiredText + ", inputTextPlaceholder=" + this.inputTextPlaceholder + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.submitText);
        dest.writeString(this.navigationBackText);
        dest.writeString(this.answerRequiredText);
        dest.writeString(this.inputTextPlaceholder);
    }

    /* JADX INFO: compiled from: SurveyMessages.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/SurveyMessages$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/SurveyMessages;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyMessages> serializer() {
            return SurveyMessages$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyMessages(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.submitText = null;
        } else {
            this.submitText = str;
        }
        if ((i & 2) == 0) {
            this.navigationBackText = null;
        } else {
            this.navigationBackText = str2;
        }
        if ((i & 4) == 0) {
            this.answerRequiredText = null;
        } else {
            this.answerRequiredText = str3;
        }
        if ((i & 8) == 0) {
            this.inputTextPlaceholder = null;
        } else {
            this.inputTextPlaceholder = str4;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyMessages self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.submitText != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.submitText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.navigationBackText != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.navigationBackText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.answerRequiredText != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.answerRequiredText);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.inputTextPlaceholder == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.inputTextPlaceholder);
    }

    public SurveyMessages(String str, String str2, String str3, String str4) {
        this.submitText = str;
        this.navigationBackText = str2;
        this.answerRequiredText = str3;
        this.inputTextPlaceholder = str4;
    }

    public /* synthetic */ SurveyMessages(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getSubmitText() {
        return this.submitText;
    }

    public final String getNavigationBackText() {
        return this.navigationBackText;
    }

    public final String getAnswerRequiredText() {
        return this.answerRequiredText;
    }

    public final String getInputTextPlaceholder() {
        return this.inputTextPlaceholder;
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyMessages translatedWith(SurveyMessagesTranslation translation) {
        return copy(StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getSubmitText() : null, this.submitText), StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getNavigationBackText() : null, this.navigationBackText), StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getAnswerRequiredText() : null, this.answerRequiredText), StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getInputTextPlaceholder() : null, this.inputTextPlaceholder));
    }
}
