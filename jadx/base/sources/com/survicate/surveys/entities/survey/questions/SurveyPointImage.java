package com.survicate.surveys.entities.survey.questions;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.translations.SurveyPointImageTranslation;
import com.survicate.surveys.entities.survey.translations.Translatable;
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

/* JADX INFO: compiled from: SurveyPointImage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB/\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u000bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bJ%\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015¨\u00061"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "Landroid/os/Parcelable;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointImageTranslation;", "image", "Lcom/survicate/surveys/entities/survey/questions/Image;", "position", "Lcom/survicate/surveys/entities/survey/questions/ImagePosition;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/Image;Lcom/survicate/surveys/entities/survey/questions/ImagePosition;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/survicate/surveys/entities/survey/questions/Image;Lcom/survicate/surveys/entities/survey/questions/ImagePosition;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImage$annotations", "()V", "getImage", "()Lcom/survicate/surveys/entities/survey/questions/Image;", "getPosition$annotations", "getPosition", "()Lcom/survicate/surveys/entities/survey/questions/ImagePosition;", "translatedWith", "translation", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyPointImage implements Parcelable, Translatable<SurveyPointImageTranslation, SurveyPointImage> {
    private final Image image;
    private final ImagePosition position;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyPointImage> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.SurveyPointImage$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointImage._childSerializers$_anonymous_();
        }
    })};

    /* JADX INFO: compiled from: SurveyPointImage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointImage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointImage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurveyPointImage(Image.CREATOR.createFromParcel(parcel), ImagePosition.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointImage[] newArray(int i) {
            return new SurveyPointImage[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.questions.ImagePosition", ImagePosition.values(), new String[]{"top", "bottom"}, new Annotation[][]{null, null}, null);
    }

    public static /* synthetic */ SurveyPointImage copy$default(SurveyPointImage surveyPointImage, Image image, ImagePosition imagePosition, int i, Object obj) {
        if ((i & 1) != 0) {
            image = surveyPointImage.image;
        }
        if ((i & 2) != 0) {
            imagePosition = surveyPointImage.position;
        }
        return surveyPointImage.copy(image, imagePosition);
    }

    @SerialName("image")
    public static /* synthetic */ void getImage$annotations() {
    }

    @SerialName("mobile_position")
    public static /* synthetic */ void getPosition$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Image getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImagePosition getPosition() {
        return this.position;
    }

    public final SurveyPointImage copy(Image image, ImagePosition position) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(position, "position");
        return new SurveyPointImage(image, position);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointImage)) {
            return false;
        }
        SurveyPointImage surveyPointImage = (SurveyPointImage) other;
        return Intrinsics.areEqual(this.image, surveyPointImage.image) && this.position == surveyPointImage.position;
    }

    public int hashCode() {
        return (this.image.hashCode() * 31) + this.position.hashCode();
    }

    public String toString() {
        return "SurveyPointImage(image=" + this.image + ", position=" + this.position + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.image.writeToParcel(dest, flags);
        dest.writeString(this.position.name());
    }

    /* JADX INFO: compiled from: SurveyPointImage.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyPointImage> serializer() {
            return SurveyPointImage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyPointImage(int i, Image image, ImagePosition imagePosition, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, SurveyPointImage$$serializer.INSTANCE.getDescriptor());
        }
        this.image = image;
        this.position = imagePosition;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyPointImage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, Image$$serializer.INSTANCE, self.image);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.position);
    }

    public SurveyPointImage(Image image, ImagePosition position) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(position, "position");
        this.image = image;
        this.position = position;
    }

    public final Image getImage() {
        return this.image;
    }

    public final ImagePosition getPosition() {
        return this.position;
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyPointImage translatedWith(SurveyPointImageTranslation translation) {
        return copy$default(this, this.image.translatedWith(translation != null ? translation.getImage() : null), null, 2, null);
    }
}
