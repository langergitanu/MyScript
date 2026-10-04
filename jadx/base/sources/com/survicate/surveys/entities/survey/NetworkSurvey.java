package com.survicate.surveys.entities.survey;

import androidx.core.app.FrameMetricsAggregator;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import java.lang.annotation.Annotation;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NetworkSurvey.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002FGBi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013B\u008b\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u0007HÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J}\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0011HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\"R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\"R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\"R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\"R\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010+R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010.¨\u0006H"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/NetworkSurvey;", "", "id", "", "name", "type", "points", "", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "screens", "events", "Lcom/survicate/surveys/entities/survey/EventTrigger;", "audiencesIds", "", "settings", "Lcom/survicate/surveys/entities/survey/SurveySettings;", "themeId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/survicate/surveys/entities/survey/SurveySettings;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/survicate/surveys/entities/survey/SurveySettings;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getName$annotations", "getName", "getType$annotations", "getType", "getPoints$annotations", "getPoints", "()Ljava/util/List;", "getScreens$annotations", "getScreens", "getEvents$annotations", "getEvents", "getAudiencesIds$annotations", "getAudiencesIds", "getSettings$annotations", "getSettings", "()Lcom/survicate/surveys/entities/survey/SurveySettings;", "getThemeId$annotations", "getThemeId", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkSurvey {
    private final List<Long> audiencesIds;
    private final List<EventTrigger> events;
    private final String id;
    private final String name;
    private final List<SurveyPoint> points;
    private final List<String> screens;
    private final SurveySettings settings;
    private final int themeId;
    private final String type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.NetworkSurvey$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkSurvey._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.NetworkSurvey$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkSurvey._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.NetworkSurvey$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkSurvey._childSerializers$_anonymous_$1();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.NetworkSurvey$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkSurvey._childSerializers$_anonymous_$2();
        }
    }), null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(SurveyPoint.class), new Annotation[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(EventTrigger$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkSurvey copy$default(NetworkSurvey networkSurvey, String str, String str2, String str3, List list, List list2, List list3, List list4, SurveySettings surveySettings, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = networkSurvey.id;
        }
        if ((i2 & 2) != 0) {
            str2 = networkSurvey.name;
        }
        if ((i2 & 4) != 0) {
            str3 = networkSurvey.type;
        }
        if ((i2 & 8) != 0) {
            list = networkSurvey.points;
        }
        if ((i2 & 16) != 0) {
            list2 = networkSurvey.screens;
        }
        if ((i2 & 32) != 0) {
            list3 = networkSurvey.events;
        }
        if ((i2 & 64) != 0) {
            list4 = networkSurvey.audiencesIds;
        }
        if ((i2 & 128) != 0) {
            surveySettings = networkSurvey.settings;
        }
        if ((i2 & 256) != 0) {
            i = networkSurvey.themeId;
        }
        SurveySettings surveySettings2 = surveySettings;
        int i3 = i;
        List list5 = list3;
        List list6 = list4;
        List list7 = list2;
        String str4 = str3;
        return networkSurvey.copy(str, str2, str4, list, list7, list5, list6, surveySettings2, i3);
    }

    @SerialName("audiences_ids")
    public static /* synthetic */ void getAudiencesIds$annotations() {
    }

    @SerialName("events")
    public static /* synthetic */ void getEvents$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("points")
    public static /* synthetic */ void getPoints$annotations() {
    }

    @SerialName("screens")
    public static /* synthetic */ void getScreens$annotations() {
    }

    @SerialName("settings")
    public static /* synthetic */ void getSettings$annotations() {
    }

    @SerialName("theme_id")
    public static /* synthetic */ void getThemeId$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<SurveyPoint> component4() {
        return this.points;
    }

    public final List<String> component5() {
        return this.screens;
    }

    public final List<EventTrigger> component6() {
        return this.events;
    }

    public final List<Long> component7() {
        return this.audiencesIds;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SurveySettings getSettings() {
        return this.settings;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getThemeId() {
        return this.themeId;
    }

    public final NetworkSurvey copy(String id, String name, String type, List<? extends SurveyPoint> points, List<String> screens, List<EventTrigger> events, List<Long> audiencesIds, SurveySettings settings, int themeId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(audiencesIds, "audiencesIds");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new NetworkSurvey(id, name, type, points, screens, events, audiencesIds, settings, themeId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkSurvey)) {
            return false;
        }
        NetworkSurvey networkSurvey = (NetworkSurvey) other;
        return Intrinsics.areEqual(this.id, networkSurvey.id) && Intrinsics.areEqual(this.name, networkSurvey.name) && Intrinsics.areEqual(this.type, networkSurvey.type) && Intrinsics.areEqual(this.points, networkSurvey.points) && Intrinsics.areEqual(this.screens, networkSurvey.screens) && Intrinsics.areEqual(this.events, networkSurvey.events) && Intrinsics.areEqual(this.audiencesIds, networkSurvey.audiencesIds) && Intrinsics.areEqual(this.settings, networkSurvey.settings) && this.themeId == networkSurvey.themeId;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.points.hashCode()) * 31) + this.screens.hashCode()) * 31) + this.events.hashCode()) * 31) + this.audiencesIds.hashCode()) * 31) + this.settings.hashCode()) * 31) + Integer.hashCode(this.themeId);
    }

    public String toString() {
        return "NetworkSurvey(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", points=" + this.points + ", screens=" + this.screens + ", events=" + this.events + ", audiencesIds=" + this.audiencesIds + ", settings=" + this.settings + ", themeId=" + this.themeId + ')';
    }

    /* JADX INFO: compiled from: NetworkSurvey.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/NetworkSurvey$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/NetworkSurvey;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkSurvey> serializer() {
            return NetworkSurvey$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NetworkSurvey(int i, String str, String str2, String str3, List list, List list2, List list3, List list4, SurveySettings surveySettings, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i & FrameMetricsAggregator.EVERY_DURATION)) {
            PluginExceptionsKt.throwMissingFieldException(i, FrameMetricsAggregator.EVERY_DURATION, NetworkSurvey$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.type = str3;
        this.points = list;
        this.screens = list2;
        this.events = list3;
        this.audiencesIds = list4;
        this.settings = surveySettings;
        this.themeId = i2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkSurvey self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
        output.encodeStringElement(serialDesc, 2, self.type);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.points);
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.screens);
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.events);
        output.encodeSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.audiencesIds);
        output.encodeSerializableElement(serialDesc, 7, SurveySettings$$serializer.INSTANCE, self.settings);
        output.encodeIntElement(serialDesc, 8, self.themeId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkSurvey(String id, String str, String type, List<? extends SurveyPoint> points, List<String> screens, List<EventTrigger> events, List<Long> audiencesIds, SurveySettings settings, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(audiencesIds, "audiencesIds");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.id = id;
        this.name = str;
        this.type = type;
        this.points = points;
        this.screens = screens;
        this.events = events;
        this.audiencesIds = audiencesIds;
        this.settings = settings;
        this.themeId = i;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final List<SurveyPoint> getPoints() {
        return this.points;
    }

    public final List<String> getScreens() {
        return this.screens;
    }

    public final List<EventTrigger> getEvents() {
        return this.events;
    }

    public final List<Long> getAudiencesIds() {
        return this.audiencesIds;
    }

    public final SurveySettings getSettings() {
        return this.settings;
    }

    public final int getThemeId() {
        return this.themeId;
    }
}
