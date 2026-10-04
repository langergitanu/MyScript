package com.survicate.surveys.entities.survey.questions.question;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: QuestionPointAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002:\u0002=>B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rBK\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u0012\u0010\"\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJH\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u000fJ\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u000fHÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000fJ%\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u001cR \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u001c¨\u0006?"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "Landroid/os/Parcelable;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointEntryTranslation;", "id", "", "possibleAnswer", "", "addingCommentAvailable", "", "randomizable", "singleSelection", "<init>", "(JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getPossibleAnswer$annotations", "getPossibleAnswer", "()Ljava/lang/String;", "getAddingCommentAvailable$annotations", "getAddingCommentAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRandomizable$annotations", "getRandomizable", "getSingleSelection$annotations", "getSingleSelection", "translatedWith", "translation", "component1", "component2", "component3", "component4", "component5", "copy", "(JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class QuestionPointAnswer implements Parcelable, Translatable<SurveyPointEntryTranslation, QuestionPointAnswer> {
    private final Boolean addingCommentAvailable;
    private final long id;
    private final String possibleAnswer;
    private final Boolean randomizable;
    private final Boolean singleSelection;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<QuestionPointAnswer> CREATOR = new Creator();

    /* JADX INFO: compiled from: QuestionPointAnswer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<QuestionPointAnswer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final QuestionPointAnswer createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            Boolean boolValueOf3 = null;
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() != 0) {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new QuestionPointAnswer(j, string, boolValueOf, boolValueOf2, boolValueOf3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final QuestionPointAnswer[] newArray(int i) {
            return new QuestionPointAnswer[i];
        }
    }

    public static /* synthetic */ QuestionPointAnswer copy$default(QuestionPointAnswer questionPointAnswer, long j, String str, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = questionPointAnswer.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = questionPointAnswer.possibleAnswer;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            bool = questionPointAnswer.addingCommentAvailable;
        }
        Boolean bool4 = bool;
        if ((i & 8) != 0) {
            bool2 = questionPointAnswer.randomizable;
        }
        Boolean bool5 = bool2;
        if ((i & 16) != 0) {
            bool3 = questionPointAnswer.singleSelection;
        }
        return questionPointAnswer.copy(j2, str2, bool4, bool5, bool3);
    }

    @SerialName("add_comment")
    public static /* synthetic */ void getAddingCommentAvailable$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("possible_answer")
    public static /* synthetic */ void getPossibleAnswer$annotations() {
    }

    @SerialName("randomizable")
    public static /* synthetic */ void getRandomizable$annotations() {
    }

    @SerialName("single_selection")
    public static /* synthetic */ void getSingleSelection$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPossibleAnswer() {
        return this.possibleAnswer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getAddingCommentAvailable() {
        return this.addingCommentAvailable;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getRandomizable() {
        return this.randomizable;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getSingleSelection() {
        return this.singleSelection;
    }

    public final QuestionPointAnswer copy(long id, String possibleAnswer, Boolean addingCommentAvailable, Boolean randomizable, Boolean singleSelection) {
        return new QuestionPointAnswer(id, possibleAnswer, addingCommentAvailable, randomizable, singleSelection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionPointAnswer)) {
            return false;
        }
        QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) other;
        return this.id == questionPointAnswer.id && Intrinsics.areEqual(this.possibleAnswer, questionPointAnswer.possibleAnswer) && Intrinsics.areEqual(this.addingCommentAvailable, questionPointAnswer.addingCommentAvailable) && Intrinsics.areEqual(this.randomizable, questionPointAnswer.randomizable) && Intrinsics.areEqual(this.singleSelection, questionPointAnswer.singleSelection);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.possibleAnswer;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.addingCommentAvailable;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.randomizable;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.singleSelection;
        return iHashCode4 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "QuestionPointAnswer(id=" + this.id + ", possibleAnswer=" + this.possibleAnswer + ", addingCommentAvailable=" + this.addingCommentAvailable + ", randomizable=" + this.randomizable + ", singleSelection=" + this.singleSelection + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.possibleAnswer);
        Boolean bool = this.addingCommentAvailable;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.randomizable;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.singleSelection;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: QuestionPointAnswer.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<QuestionPointAnswer> serializer() {
            return QuestionPointAnswer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ QuestionPointAnswer(int i, long j, String str, Boolean bool, Boolean bool2, Boolean bool3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, QuestionPointAnswer$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.possibleAnswer = str;
        this.addingCommentAvailable = bool;
        this.randomizable = bool2;
        this.singleSelection = bool3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(QuestionPointAnswer self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.possibleAnswer);
        output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.addingCommentAvailable);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.randomizable);
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.singleSelection);
    }

    public QuestionPointAnswer(long j, String str, Boolean bool, Boolean bool2, Boolean bool3) {
        this.id = j;
        this.possibleAnswer = str;
        this.addingCommentAvailable = bool;
        this.randomizable = bool2;
        this.singleSelection = bool3;
    }

    public final long getId() {
        return this.id;
    }

    public final String getPossibleAnswer() {
        return this.possibleAnswer;
    }

    public final Boolean getAddingCommentAvailable() {
        return this.addingCommentAvailable;
    }

    public final Boolean getRandomizable() {
        return this.randomizable;
    }

    public final Boolean getSingleSelection() {
        return this.singleSelection;
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public QuestionPointAnswer translatedWith(SurveyPointEntryTranslation translation) {
        return copy$default(this, 0L, StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getValue() : null, this.possibleAnswer), null, null, null, 29, null);
    }
}
