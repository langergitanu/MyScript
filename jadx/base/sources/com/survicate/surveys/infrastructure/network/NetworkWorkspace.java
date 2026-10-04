package com.survicate.surveys.infrastructure.network;

import com.survicate.surveys.entities.survey.Integration;
import com.survicate.surveys.entities.survey.Integration$$serializer;
import com.survicate.surveys.entities.survey.NetworkSurvey;
import com.survicate.surveys.entities.survey.NetworkSurvey$$serializer;
import com.survicate.surveys.entities.survey.NetworkTargetingEvent;
import com.survicate.surveys.entities.survey.NetworkTargetingEvent$$serializer;
import com.survicate.surveys.entities.survey.audience.NetworkAudience;
import com.survicate.surveys.entities.survey.audience.NetworkAudience$$serializer;
import com.survicate.surveys.entities.survey.theme.network.NetworkTheme;
import com.survicate.surveys.entities.survey.theme.network.NetworkTheme$$serializer;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import com.survicate.surveys.infrastructure.serialization.TranslationsSerializer;
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

/* JADX INFO: compiled from: NetworkWorkspace.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0002PQB\u0094\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0013\u0010\u0014\u001a\u000f\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u0016\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018B¥\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0017\u0010\u001dJ\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003HÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\t\u0010A\u001a\u00020\nHÆ\u0003J\u0016\u0010B\u001a\u000f\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u0016\u0018\u00010\u0003HÆ\u0003J¢\u0001\u0010C\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u0016\u0018\u00010\u0003HÆ\u0001J\u0013\u0010D\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u001aHÖ\u0001J\t\u0010G\u001a\u00020\u000eHÖ\u0001J%\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010(R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010-R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010!R\u001c\u0010\u0011\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010(R\u001c\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001f\u001a\u0004\b3\u0010(R\u001c\u0010\u0013\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001f\u001a\u0004\b5\u0010(R)\u0010\u0014\u001a\u000f\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u0016\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001f\u001a\u0004\b7\u0010!¨\u0006R"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace;", "", "surveys", "", "Lcom/survicate/surveys/entities/survey/NetworkSurvey;", "themes", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkTheme;", "audiences", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudience;", "installing", "", "integrations", "Lcom/survicate/surveys/entities/survey/Integration;", "panelAnswerUrlTemplate", "", "targetingEvents", "Lcom/survicate/surveys/entities/survey/NetworkTargetingEvent;", "targetingEventsEnabled", "backendTargetingEnabled", "enforceUserAuthentication", "translations", "Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "Lkotlinx/serialization/Contextual;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/lang/String;Ljava/util/List;ZZZLjava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/util/List;Ljava/lang/String;Ljava/util/List;ZZZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSurveys$annotations", "()V", "getSurveys", "()Ljava/util/List;", "getThemes$annotations", "getThemes", "getAudiences$annotations", "getAudiences", "getInstalling$annotations", "getInstalling", "()Z", "getIntegrations$annotations", "getIntegrations", "getPanelAnswerUrlTemplate$annotations", "getPanelAnswerUrlTemplate", "()Ljava/lang/String;", "getTargetingEvents$annotations", "getTargetingEvents", "getTargetingEventsEnabled$annotations", "getTargetingEventsEnabled", "getBackendTargetingEnabled$annotations", "getBackendTargetingEnabled", "getEnforceUserAuthentication$annotations", "getEnforceUserAuthentication", "getTranslations$annotations", "getTranslations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkWorkspace {
    private final List<NetworkAudience> audiences;
    private final boolean backendTargetingEnabled;
    private final boolean enforceUserAuthentication;
    private final boolean installing;
    private final List<Integration> integrations;
    private final String panelAnswerUrlTemplate;
    private final List<NetworkSurvey> surveys;
    private final List<NetworkTargetingEvent> targetingEvents;
    private final boolean targetingEventsEnabled;
    private final List<NetworkTheme> themes;
    private final List<SurveyTranslation> translations;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.NetworkWorkspace$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkWorkspace._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.NetworkWorkspace$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkWorkspace._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.NetworkWorkspace$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkWorkspace._childSerializers$_anonymous_$1();
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.NetworkWorkspace$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkWorkspace._childSerializers$_anonymous_$2();
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.NetworkWorkspace$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkWorkspace._childSerializers$_anonymous_$3();
        }
    }), null, null, null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(NetworkSurvey$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(NetworkTheme$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(NetworkAudience$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(Integration$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(NetworkTargetingEvent$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkWorkspace copy$default(NetworkWorkspace networkWorkspace, List list, List list2, List list3, boolean z, List list4, String str, List list5, boolean z2, boolean z3, boolean z4, List list6, int i, Object obj) {
        if ((i & 1) != 0) {
            list = networkWorkspace.surveys;
        }
        if ((i & 2) != 0) {
            list2 = networkWorkspace.themes;
        }
        if ((i & 4) != 0) {
            list3 = networkWorkspace.audiences;
        }
        if ((i & 8) != 0) {
            z = networkWorkspace.installing;
        }
        if ((i & 16) != 0) {
            list4 = networkWorkspace.integrations;
        }
        if ((i & 32) != 0) {
            str = networkWorkspace.panelAnswerUrlTemplate;
        }
        if ((i & 64) != 0) {
            list5 = networkWorkspace.targetingEvents;
        }
        if ((i & 128) != 0) {
            z2 = networkWorkspace.targetingEventsEnabled;
        }
        if ((i & 256) != 0) {
            z3 = networkWorkspace.backendTargetingEnabled;
        }
        if ((i & 512) != 0) {
            z4 = networkWorkspace.enforceUserAuthentication;
        }
        if ((i & 1024) != 0) {
            list6 = networkWorkspace.translations;
        }
        boolean z5 = z4;
        List list7 = list6;
        boolean z6 = z2;
        boolean z7 = z3;
        String str2 = str;
        List list8 = list5;
        List list9 = list4;
        List list10 = list3;
        return networkWorkspace.copy(list, list2, list10, z, list9, str2, list8, z6, z7, z5, list7);
    }

    @SerialName("audiences")
    public static /* synthetic */ void getAudiences$annotations() {
    }

    @SerialName("backend_targeting_enabled")
    public static /* synthetic */ void getBackendTargetingEnabled$annotations() {
    }

    @SerialName("enforce_user_authentication")
    public static /* synthetic */ void getEnforceUserAuthentication$annotations() {
    }

    @SerialName("installing")
    public static /* synthetic */ void getInstalling$annotations() {
    }

    @SerialName("integrations")
    public static /* synthetic */ void getIntegrations$annotations() {
    }

    @SerialName("panel_answer_url")
    public static /* synthetic */ void getPanelAnswerUrlTemplate$annotations() {
    }

    @SerialName("surveys")
    public static /* synthetic */ void getSurveys$annotations() {
    }

    @SerialName("targeting_events")
    public static /* synthetic */ void getTargetingEvents$annotations() {
    }

    @SerialName("targeting_events_enabled")
    public static /* synthetic */ void getTargetingEventsEnabled$annotations() {
    }

    @SerialName("themes")
    public static /* synthetic */ void getThemes$annotations() {
    }

    @SerialName("translations")
    @Serializable(with = TranslationsSerializer.class)
    public static /* synthetic */ void getTranslations$annotations() {
    }

    public final List<NetworkSurvey> component1() {
        return this.surveys;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getEnforceUserAuthentication() {
        return this.enforceUserAuthentication;
    }

    public final List<SurveyTranslation> component11() {
        return this.translations;
    }

    public final List<NetworkTheme> component2() {
        return this.themes;
    }

    public final List<NetworkAudience> component3() {
        return this.audiences;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getInstalling() {
        return this.installing;
    }

    public final List<Integration> component5() {
        return this.integrations;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPanelAnswerUrlTemplate() {
        return this.panelAnswerUrlTemplate;
    }

    public final List<NetworkTargetingEvent> component7() {
        return this.targetingEvents;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getTargetingEventsEnabled() {
        return this.targetingEventsEnabled;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getBackendTargetingEnabled() {
        return this.backendTargetingEnabled;
    }

    public final NetworkWorkspace copy(List<NetworkSurvey> surveys, List<NetworkTheme> themes, List<NetworkAudience> audiences, boolean installing, List<Integration> integrations, String panelAnswerUrlTemplate, List<NetworkTargetingEvent> targetingEvents, boolean targetingEventsEnabled, boolean backendTargetingEnabled, boolean enforceUserAuthentication, List<SurveyTranslation> translations) {
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(themes, "themes");
        Intrinsics.checkNotNullParameter(audiences, "audiences");
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(panelAnswerUrlTemplate, "panelAnswerUrlTemplate");
        Intrinsics.checkNotNullParameter(targetingEvents, "targetingEvents");
        return new NetworkWorkspace(surveys, themes, audiences, installing, integrations, panelAnswerUrlTemplate, targetingEvents, targetingEventsEnabled, backendTargetingEnabled, enforceUserAuthentication, translations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkWorkspace)) {
            return false;
        }
        NetworkWorkspace networkWorkspace = (NetworkWorkspace) other;
        return Intrinsics.areEqual(this.surveys, networkWorkspace.surveys) && Intrinsics.areEqual(this.themes, networkWorkspace.themes) && Intrinsics.areEqual(this.audiences, networkWorkspace.audiences) && this.installing == networkWorkspace.installing && Intrinsics.areEqual(this.integrations, networkWorkspace.integrations) && Intrinsics.areEqual(this.panelAnswerUrlTemplate, networkWorkspace.panelAnswerUrlTemplate) && Intrinsics.areEqual(this.targetingEvents, networkWorkspace.targetingEvents) && this.targetingEventsEnabled == networkWorkspace.targetingEventsEnabled && this.backendTargetingEnabled == networkWorkspace.backendTargetingEnabled && this.enforceUserAuthentication == networkWorkspace.enforceUserAuthentication && Intrinsics.areEqual(this.translations, networkWorkspace.translations);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.surveys.hashCode() * 31) + this.themes.hashCode()) * 31) + this.audiences.hashCode()) * 31) + Boolean.hashCode(this.installing)) * 31) + this.integrations.hashCode()) * 31) + this.panelAnswerUrlTemplate.hashCode()) * 31) + this.targetingEvents.hashCode()) * 31) + Boolean.hashCode(this.targetingEventsEnabled)) * 31) + Boolean.hashCode(this.backendTargetingEnabled)) * 31) + Boolean.hashCode(this.enforceUserAuthentication)) * 31;
        List<SurveyTranslation> list = this.translations;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkWorkspace(surveys=");
        sb.append(this.surveys).append(", themes=").append(this.themes).append(", audiences=").append(this.audiences).append(", installing=").append(this.installing).append(", integrations=").append(this.integrations).append(", panelAnswerUrlTemplate=").append(this.panelAnswerUrlTemplate).append(", targetingEvents=").append(this.targetingEvents).append(", targetingEventsEnabled=").append(this.targetingEventsEnabled).append(", backendTargetingEnabled=").append(this.backendTargetingEnabled).append(", enforceUserAuthentication=").append(this.enforceUserAuthentication).append(", translations=").append(this.translations).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: NetworkWorkspace.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkWorkspace> serializer() {
            return NetworkWorkspace$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NetworkWorkspace(int i, List list, List list2, List list3, boolean z, List list4, String str, List list5, boolean z2, boolean z3, boolean z4, List list6, SerializationConstructorMarker serializationConstructorMarker) {
        if (1960 != (i & 1960)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1960, NetworkWorkspace$$serializer.INSTANCE.getDescriptor());
        }
        this.surveys = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 2) == 0) {
            this.themes = CollectionsKt.emptyList();
        } else {
            this.themes = list2;
        }
        if ((i & 4) == 0) {
            this.audiences = CollectionsKt.emptyList();
        } else {
            this.audiences = list3;
        }
        this.installing = z;
        if ((i & 16) == 0) {
            this.integrations = CollectionsKt.emptyList();
        } else {
            this.integrations = list4;
        }
        this.panelAnswerUrlTemplate = str;
        if ((i & 64) == 0) {
            this.targetingEvents = CollectionsKt.emptyList();
        } else {
            this.targetingEvents = list5;
        }
        this.targetingEventsEnabled = z2;
        this.backendTargetingEnabled = z3;
        this.enforceUserAuthentication = z4;
        this.translations = list6;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkWorkspace self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.surveys, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.surveys);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.themes, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.themes);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.audiences, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.audiences);
        }
        output.encodeBooleanElement(serialDesc, 3, self.installing);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.integrations, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.integrations);
        }
        output.encodeStringElement(serialDesc, 5, self.panelAnswerUrlTemplate);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.targetingEvents, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.targetingEvents);
        }
        output.encodeBooleanElement(serialDesc, 7, self.targetingEventsEnabled);
        output.encodeBooleanElement(serialDesc, 8, self.backendTargetingEnabled);
        output.encodeBooleanElement(serialDesc, 9, self.enforceUserAuthentication);
        output.encodeNullableSerializableElement(serialDesc, 10, TranslationsSerializer.INSTANCE, self.translations);
    }

    public NetworkWorkspace(List<NetworkSurvey> surveys, List<NetworkTheme> themes, List<NetworkAudience> audiences, boolean z, List<Integration> integrations, String panelAnswerUrlTemplate, List<NetworkTargetingEvent> targetingEvents, boolean z2, boolean z3, boolean z4, List<SurveyTranslation> list) {
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(themes, "themes");
        Intrinsics.checkNotNullParameter(audiences, "audiences");
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(panelAnswerUrlTemplate, "panelAnswerUrlTemplate");
        Intrinsics.checkNotNullParameter(targetingEvents, "targetingEvents");
        this.surveys = surveys;
        this.themes = themes;
        this.audiences = audiences;
        this.installing = z;
        this.integrations = integrations;
        this.panelAnswerUrlTemplate = panelAnswerUrlTemplate;
        this.targetingEvents = targetingEvents;
        this.targetingEventsEnabled = z2;
        this.backendTargetingEnabled = z3;
        this.enforceUserAuthentication = z4;
        this.translations = list;
    }

    public final List<NetworkSurvey> getSurveys() {
        return this.surveys;
    }

    public /* synthetic */ NetworkWorkspace(List list, List list2, List list3, boolean z, List list4, String str, List list5, boolean z2, boolean z3, boolean z4, List list6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, z, (i & 16) != 0 ? CollectionsKt.emptyList() : list4, str, (i & 64) != 0 ? CollectionsKt.emptyList() : list5, z2, z3, z4, list6);
    }

    public final List<NetworkTheme> getThemes() {
        return this.themes;
    }

    public final List<NetworkAudience> getAudiences() {
        return this.audiences;
    }

    public final boolean getInstalling() {
        return this.installing;
    }

    public final List<Integration> getIntegrations() {
        return this.integrations;
    }

    public final String getPanelAnswerUrlTemplate() {
        return this.panelAnswerUrlTemplate;
    }

    public final List<NetworkTargetingEvent> getTargetingEvents() {
        return this.targetingEvents;
    }

    public final boolean getTargetingEventsEnabled() {
        return this.targetingEventsEnabled;
    }

    public final boolean getBackendTargetingEnabled() {
        return this.backendTargetingEnabled;
    }

    public final boolean getEnforceUserAuthentication() {
        return this.enforceUserAuthentication;
    }

    public final List<SurveyTranslation> getTranslations() {
        return this.translations;
    }
}
