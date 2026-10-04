package com.survicate.surveys.entities.survey.surveyLogic.matrix;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SurveyPointMatrixLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rBM\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JC\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0006\u0010'\u001a\u00020\u0003J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0003J%\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 ¨\u0006="}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyPointMatrixLogic;", "Landroid/os/Parcelable;", "orderNumber", "", "uid", "", "goTo", "groupOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "groups", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixGroup;", "<init>", "(IJJLcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJJLcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderNumber$annotations", "()V", "getOrderNumber", "()I", "getUid$annotations", "getUid", "()J", "getGoTo$annotations", "getGoTo", "getGroupOperator$annotations", "getGroupOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getGroups$annotations", "getGroups", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyPointMatrixLogic implements Parcelable {
    private final long goTo;
    private final SurveyLogicOperator groupOperator;
    private final List<SurveyLogicMatrixGroup> groups;
    private final int orderNumber;
    private final long uid;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyPointMatrixLogic> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyPointMatrixLogic$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMatrixLogic._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyPointMatrixLogic$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMatrixLogic._childSerializers$_anonymous_$0();
        }
    })};

    /* JADX INFO: compiled from: SurveyPointMatrixLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointMatrixLogic> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMatrixLogic createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(SurveyLogicMatrixGroup.CREATOR.createFromParcel(parcel));
            }
            return new SurveyPointMatrixLogic(i, j, j2, surveyLogicOperatorValueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMatrixLogic[] newArray(int i) {
            return new SurveyPointMatrixLogic[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(SurveyLogicMatrixGroup$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyPointMatrixLogic copy$default(SurveyPointMatrixLogic surveyPointMatrixLogic, int i, long j, long j2, SurveyLogicOperator surveyLogicOperator, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = surveyPointMatrixLogic.orderNumber;
        }
        if ((i2 & 2) != 0) {
            j = surveyPointMatrixLogic.uid;
        }
        if ((i2 & 4) != 0) {
            j2 = surveyPointMatrixLogic.goTo;
        }
        if ((i2 & 8) != 0) {
            surveyLogicOperator = surveyPointMatrixLogic.groupOperator;
        }
        if ((i2 & 16) != 0) {
            list = surveyPointMatrixLogic.groups;
        }
        long j3 = j2;
        return surveyPointMatrixLogic.copy(i, j, j3, surveyLogicOperator, list);
    }

    @SerialName("go_to")
    public static /* synthetic */ void getGoTo$annotations() {
    }

    @SerialName("group_operator")
    public static /* synthetic */ void getGroupOperator$annotations() {
    }

    @SerialName("group")
    public static /* synthetic */ void getGroups$annotations() {
    }

    @SerialName("order_number")
    public static /* synthetic */ void getOrderNumber$annotations() {
    }

    @SerialName("uid")
    public static /* synthetic */ void getUid$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOrderNumber() {
        return this.orderNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGoTo() {
        return this.goTo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SurveyLogicOperator getGroupOperator() {
        return this.groupOperator;
    }

    public final List<SurveyLogicMatrixGroup> component5() {
        return this.groups;
    }

    public final SurveyPointMatrixLogic copy(int orderNumber, long uid, long goTo, SurveyLogicOperator groupOperator, List<SurveyLogicMatrixGroup> groups) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        return new SurveyPointMatrixLogic(orderNumber, uid, goTo, groupOperator, groups);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointMatrixLogic)) {
            return false;
        }
        SurveyPointMatrixLogic surveyPointMatrixLogic = (SurveyPointMatrixLogic) other;
        return this.orderNumber == surveyPointMatrixLogic.orderNumber && this.uid == surveyPointMatrixLogic.uid && this.goTo == surveyPointMatrixLogic.goTo && this.groupOperator == surveyPointMatrixLogic.groupOperator && Intrinsics.areEqual(this.groups, surveyPointMatrixLogic.groups);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.orderNumber) * 31) + Long.hashCode(this.uid)) * 31) + Long.hashCode(this.goTo)) * 31;
        SurveyLogicOperator surveyLogicOperator = this.groupOperator;
        return ((iHashCode + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.groups.hashCode();
    }

    public String toString() {
        return "SurveyPointMatrixLogic(orderNumber=" + this.orderNumber + ", uid=" + this.uid + ", goTo=" + this.goTo + ", groupOperator=" + this.groupOperator + ", groups=" + this.groups + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.orderNumber);
        dest.writeLong(this.uid);
        dest.writeLong(this.goTo);
        SurveyLogicOperator surveyLogicOperator = this.groupOperator;
        if (surveyLogicOperator == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(surveyLogicOperator.name());
        }
        List<SurveyLogicMatrixGroup> list = this.groups;
        dest.writeInt(list.size());
        Iterator<SurveyLogicMatrixGroup> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    /* JADX INFO: compiled from: SurveyPointMatrixLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyPointMatrixLogic$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyPointMatrixLogic;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyPointMatrixLogic> serializer() {
            return SurveyPointMatrixLogic$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyPointMatrixLogic(int i, int i2, long j, long j2, SurveyLogicOperator surveyLogicOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, SurveyPointMatrixLogic$$serializer.INSTANCE.getDescriptor());
        }
        this.orderNumber = i2;
        this.uid = j;
        this.goTo = j2;
        this.groupOperator = surveyLogicOperator;
        this.groups = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyPointMatrixLogic self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.orderNumber);
        output.encodeLongElement(serialDesc, 1, self.uid);
        output.encodeLongElement(serialDesc, 2, self.goTo);
        output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.groupOperator);
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.groups);
    }

    public SurveyPointMatrixLogic(int i, long j, long j2, SurveyLogicOperator surveyLogicOperator, List<SurveyLogicMatrixGroup> groups) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.orderNumber = i;
        this.uid = j;
        this.goTo = j2;
        this.groupOperator = surveyLogicOperator;
        this.groups = groups;
    }

    public final int getOrderNumber() {
        return this.orderNumber;
    }

    public final long getUid() {
        return this.uid;
    }

    public final long getGoTo() {
        return this.goTo;
    }

    public final SurveyLogicOperator getGroupOperator() {
        return this.groupOperator;
    }

    public final List<SurveyLogicMatrixGroup> getGroups() {
        return this.groups;
    }
}
