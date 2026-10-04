package com.revenuecat.purchases.common.events;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.utils.Event;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.EncodeDefault;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: BackendEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00112\u00020\u0001:\t\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHÇ\u0001\u0082\u0001\u0006\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent;", "Lcom/revenuecat/purchases/utils/Event;", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Ad", "Checkpoint", "Companion", "CustomPaywall", "CustomPaywallPresentedOfferingContextData", "CustomerCenter", "Paywalls", "PresentedOfferingContextData", "Workflows", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Checkpoint;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public abstract class BackendEvent implements Event {
    public static final int AD_EVENT_SCHEMA_VERSION = 1;
    public static final int CHECKPOINT_EVENT_SCHEMA_VERSION = 1;
    public static final String CHECKPOINT_EVENT_TYPE = "checkpoint_hit";
    public static final int CUSTOMER_CENTER_EVENT_SCHEMA_VERSION = 1;
    public static final int CUSTOM_PAYWALL_EVENT_SCHEMA_VERSION = 1;
    public static final int PAYWALL_EVENT_SCHEMA_VERSION = 1;
    public static final int WORKFLOW_EVENT_SCHEMA_VERSION = 1;
    public static final String WORKFLOW_EVENT_TYPE = "workflows";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.common.events.BackendEvent.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.revenuecat.purchases.common.events.BackendEvent", Reflection.getOrCreateKotlinClass(BackendEvent.class), new KClass[]{Reflection.getOrCreateKotlinClass(C7172Ad.class), Reflection.getOrCreateKotlinClass(Checkpoint.class), Reflection.getOrCreateKotlinClass(CustomPaywall.class), Reflection.getOrCreateKotlinClass(CustomerCenter.class), Reflection.getOrCreateKotlinClass(Paywalls.class), Reflection.getOrCreateKotlinClass(Workflows.class)}, new KSerializer[]{BackendEvent$Ad$$serializer.INSTANCE, BackendEvent$Checkpoint$$serializer.INSTANCE, BackendEvent$CustomPaywall$$serializer.INSTANCE, BackendEvent$CustomerCenter$$serializer.INSTANCE, BackendEvent$Paywalls$$serializer.INSTANCE, BackendEvent$Workflows$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    public /* synthetic */ BackendEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(BackendEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    private BackendEvent() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BackendEvent(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0002NOB\u0097\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018Bk\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0019J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\u0087\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010A\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001J&\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LHÁ\u0001¢\u0006\u0002\bMR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010,R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001d¨\u0006P"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "revisionID", "type", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;", "appUserID", "appSessionID", DiagnosticsEntry.TIMESTAMP_KEY, "", "darkMode", "", "locale", "displayMode", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", ClientCookie.PATH_ATTR, "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", ImagesContract.URL, "surveyOptionID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;)V", "getAppSessionID$annotations", "()V", "getAppSessionID", "()Ljava/lang/String;", "getAppUserID$annotations", "getAppUserID", "getDarkMode$annotations", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", "getId", "getLocale", "getPath", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "getRevisionID$annotations", "getRevisionID", "()I", "getSurveyOptionID$annotations", "getSurveyOptionID", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;", "getUrl", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("customer_center")
    public static final /* data */ class CustomerCenter extends BackendEvent {
        private final String appSessionID;
        private final String appUserID;
        private final boolean darkMode;
        private final CustomerCenterDisplayMode displayMode;
        private final String id;
        private final String locale;
        private final CustomerCenterConfigData.HelpPath.PathType path;
        private final int revisionID;
        private final String surveyOptionID;
        private final long timestamp;
        private final CustomerCenterEventType type;
        private final String url;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, CustomerCenterEventType.INSTANCE.serializer(), null, null, null, null, null, CustomerCenterDisplayMode.INSTANCE.serializer(), CustomerCenterConfigData.HelpPath.PathType.INSTANCE.serializer(), null, null};

        public static /* synthetic */ CustomerCenter copy$default(CustomerCenter customerCenter, String str, int i, CustomerCenterEventType customerCenterEventType, String str2, String str3, long j, boolean z, String str4, CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, String str6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = customerCenter.id;
            }
            return customerCenter.copy(str, (i2 & 2) != 0 ? customerCenter.revisionID : i, (i2 & 4) != 0 ? customerCenter.type : customerCenterEventType, (i2 & 8) != 0 ? customerCenter.appUserID : str2, (i2 & 16) != 0 ? customerCenter.appSessionID : str3, (i2 & 32) != 0 ? customerCenter.timestamp : j, (i2 & 64) != 0 ? customerCenter.darkMode : z, (i2 & 128) != 0 ? customerCenter.locale : str4, (i2 & 256) != 0 ? customerCenter.displayMode : customerCenterDisplayMode, (i2 & 512) != 0 ? customerCenter.path : pathType, (i2 & 1024) != 0 ? customerCenter.url : str5, (i2 & 2048) != 0 ? customerCenter.surveyOptionID : str6);
        }

        @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY)
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName(Keys.DARK_MODE)
        public static /* synthetic */ void getDarkMode$annotations() {
        }

        @SerialName("display_mode")
        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        @SerialName("revision_id")
        public static /* synthetic */ void getRevisionID$annotations() {
        }

        @SerialName("survey_option_id")
        public static /* synthetic */ void getSurveyOptionID$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final CustomerCenterConfigData.HelpPath.PathType getPath() {
            return this.path;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getSurveyOptionID() {
            return this.surveyOptionID;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getRevisionID() {
            return this.revisionID;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CustomerCenterEventType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final CustomerCenter copy(String id, int revisionID, CustomerCenterEventType type, String appUserID, String appSessionID, long timestamp, boolean darkMode, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType path, String url, String surveyOptionID) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            return new CustomerCenter(id, revisionID, type, appUserID, appSessionID, timestamp, darkMode, locale, displayMode, path, url, surveyOptionID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomerCenter)) {
                return false;
            }
            CustomerCenter customerCenter = (CustomerCenter) other;
            return Intrinsics.areEqual(this.id, customerCenter.id) && this.revisionID == customerCenter.revisionID && this.type == customerCenter.type && Intrinsics.areEqual(this.appUserID, customerCenter.appUserID) && Intrinsics.areEqual(this.appSessionID, customerCenter.appSessionID) && this.timestamp == customerCenter.timestamp && this.darkMode == customerCenter.darkMode && Intrinsics.areEqual(this.locale, customerCenter.locale) && this.displayMode == customerCenter.displayMode && this.path == customerCenter.path && Intrinsics.areEqual(this.url, customerCenter.url) && Intrinsics.areEqual(this.surveyOptionID, customerCenter.surveyOptionID);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.revisionID)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.locale.hashCode()) * 31) + this.displayMode.hashCode()) * 31;
            CustomerCenterConfigData.HelpPath.PathType pathType = this.path;
            int iHashCode2 = (iHashCode + (pathType == null ? 0 : pathType.hashCode())) * 31;
            String str = this.url;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.surveyOptionID;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            StringBuilder sb = new StringBuilder("CustomerCenter(id=");
            sb.append(this.id).append(", revisionID=").append(this.revisionID).append(", type=").append(this.type).append(", appUserID=").append(this.appUserID).append(", appSessionID=").append(this.appSessionID).append(", timestamp=").append(this.timestamp).append(", darkMode=").append(this.darkMode).append(", locale=").append(this.locale).append(", displayMode=").append(this.displayMode).append(", path=").append(this.path).append(", url=").append(this.url).append(", surveyOptionID=");
            sb.append(this.surveyOptionID).append(')');
            return sb.toString();
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CustomerCenter> serializer() {
                return BackendEvent$CustomerCenter$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CustomerCenter(int i, String str, @SerialName("revision_id") int i2, CustomerCenterEventType customerCenterEventType, @SerialName("app_user_id") String str2, @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY) String str3, long j, @SerialName(Keys.DARK_MODE) boolean z, String str4, @SerialName("display_mode") CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, @SerialName("survey_option_id") String str6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4095, BackendEvent$CustomerCenter$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.revisionID = i2;
            this.type = customerCenterEventType;
            this.appUserID = str2;
            this.appSessionID = str3;
            this.timestamp = j;
            this.darkMode = z;
            this.locale = str4;
            this.displayMode = customerCenterDisplayMode;
            this.path = pathType;
            this.url = str5;
            this.surveyOptionID = str6;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(CustomerCenter self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.revisionID);
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            output.encodeStringElement(serialDesc, 4, self.appSessionID);
            output.encodeLongElement(serialDesc, 5, self.timestamp);
            output.encodeBooleanElement(serialDesc, 6, self.darkMode);
            output.encodeStringElement(serialDesc, 7, self.locale);
            output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.displayMode);
            output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.path);
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.url);
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.surveyOptionID);
        }

        public final String getId() {
            return this.id;
        }

        public final int getRevisionID() {
            return this.revisionID;
        }

        public final CustomerCenterEventType getType() {
            return this.type;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final CustomerCenterConfigData.HelpPath.PathType getPath() {
            return this.path;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getSurveyOptionID() {
            return this.surveyOptionID;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerCenter(String id, int i, CustomerCenterEventType type, String appUserID, String appSessionID, long j, boolean z, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            this.id = id;
            this.revisionID = i;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.timestamp = j;
            this.darkMode = z;
            this.locale = locale;
            this.displayMode = displayMode;
            this.path = pathType;
            this.url = str;
            this.surveyOptionID = str2;
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u007f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ½\u00012\u00020\u0001:\u0004¼\u0001½\u0001Bå\u0003\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\b\u00100\u001a\u0004\u0018\u000101¢\u0006\u0002\u00102B«\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u00103J\n\u0010\u0086\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010IJ\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010IJ\n\u0010\u009c\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u000fHÆ\u0003JÎ\u0003\u0010\u00ad\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010®\u0001J\u0016\u0010¯\u0001\u001a\u00020\u00122\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001HÖ\u0003J\n\u0010²\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010³\u0001\u001a\u00020\u0006HÖ\u0001J.\u0010´\u0001\u001a\u00030µ\u00012\u0007\u0010¶\u0001\u001a\u00020\u00002\b\u0010·\u0001\u001a\u00030¸\u00012\b\u0010¹\u0001\u001a\u00030º\u0001HÁ\u0001¢\u0006\u0003\b»\u0001R\u001c\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u00105\u001a\u0004\b9\u00107R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u00105\u001a\u0004\b;\u00107R\u001e\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u00105\u001a\u0004\b=\u00107R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u00105\u001a\u0004\b?\u00107R\u001e\u0010,\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u00105\u001a\u0004\bA\u00107R\u001e\u0010.\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u00105\u001a\u0004\bC\u00107R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u00105\u001a\u0004\bE\u0010FR \u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010J\u0012\u0004\bG\u00105\u001a\u0004\bH\u0010IR\u001e\u0010(\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u00105\u001a\u0004\bL\u00107R\u001e\u0010+\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u00105\u001a\u0004\bN\u00107R\u001e\u0010$\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u00105\u001a\u0004\bP\u00107R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010J\u0012\u0004\bQ\u00105\u001a\u0004\bR\u0010IR\u001e\u0010'\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u00105\u001a\u0004\bT\u00107R\u001e\u0010*\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u00105\u001a\u0004\bV\u00107R\u001c\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u00105\u001a\u0004\bX\u00107R \u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010J\u0012\u0004\bY\u00105\u001a\u0004\bZ\u0010IR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u00105\u001a\u0004\b\\\u00107R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b]\u00105\u001a\u0004\b^\u00107R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b_\u00105\u001a\u0004\b`\u00107R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\ba\u00107R\u001c\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bb\u00105\u001a\u0004\bc\u00107R\u001c\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bd\u00105\u001a\u0004\be\u00107R\u001e\u0010#\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bf\u00105\u001a\u0004\bg\u00107R \u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010J\u0012\u0004\bh\u00105\u001a\u0004\bi\u0010IR\u001e\u0010&\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bj\u00105\u001a\u0004\bk\u00107R\u001e\u0010)\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bl\u00105\u001a\u0004\bm\u00107R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bn\u00105\u001a\u0004\bo\u00107R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bp\u00105\u001a\u0004\bq\u00107R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\br\u00105\u001a\u0004\bs\u0010tR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bu\u00105\u001a\u0004\bv\u0010wR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bx\u00105\u001a\u0004\by\u00107R\u001e\u0010-\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bz\u00105\u001a\u0004\b{\u00107R\u001e\u0010/\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u00105\u001a\u0004\b}\u00107R\u001c\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b~\u00105\u001a\u0004\b\u007f\u00107R\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0012\u0010\b\u001a\u00020\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u00107R\u0012\u0010\u0007\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010tR \u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0084\u0001\u00105\u001a\u0005\b\u0085\u0001\u00107¨\u0006¾\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "seen2", "id", "", "version", "type", "appUserID", "sessionID", "offeringID", "paywallID", "paywallRevision", DiagnosticsEntry.TIMESTAMP_KEY, "", "displayMode", "darkMode", "", "localeIdentifier", "workflowID", "presentedOfferingContext", "Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "exitOfferType", "exitOfferingID", "packageID", "productID", "errorCode", "errorMessage", "componentType", "componentName", "componentValue", "componentUrl", "originIndex", "destinationIndex", "originContextName", "destinationContextName", "defaultIndex", "originPackageIdentifier", "destinationPackageIdentifier", "defaultPackageIdentifier", "originProductIdentifier", "destinationProductIdentifier", "defaultProductIdentifier", "currentPackageIdentifier", "resultingPackageIdentifier", "currentProductIdentifier", "resultingProductIdentifier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserID$annotations", "()V", "getAppUserID", "()Ljava/lang/String;", "getComponentName$annotations", "getComponentName", "getComponentType$annotations", "getComponentType", "getComponentUrl$annotations", "getComponentUrl", "getComponentValue$annotations", "getComponentValue", "getCurrentPackageIdentifier$annotations", "getCurrentPackageIdentifier", "getCurrentProductIdentifier$annotations", "getCurrentProductIdentifier", "getDarkMode$annotations", "getDarkMode", "()Z", "getDefaultIndex$annotations", "getDefaultIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultPackageIdentifier$annotations", "getDefaultPackageIdentifier", "getDefaultProductIdentifier$annotations", "getDefaultProductIdentifier", "getDestinationContextName$annotations", "getDestinationContextName", "getDestinationIndex$annotations", "getDestinationIndex", "getDestinationPackageIdentifier$annotations", "getDestinationPackageIdentifier", "getDestinationProductIdentifier$annotations", "getDestinationProductIdentifier", "getDisplayMode$annotations", "getDisplayMode", "getErrorCode$annotations", "getErrorCode", "getErrorMessage$annotations", "getErrorMessage", "getExitOfferType$annotations", "getExitOfferType", "getExitOfferingID$annotations", "getExitOfferingID", "getId", "getLocaleIdentifier$annotations", "getLocaleIdentifier", "getOfferingID$annotations", "getOfferingID", "getOriginContextName$annotations", "getOriginContextName", "getOriginIndex$annotations", "getOriginIndex", "getOriginPackageIdentifier$annotations", "getOriginPackageIdentifier", "getOriginProductIdentifier$annotations", "getOriginProductIdentifier", "getPackageID$annotations", "getPackageID", "getPaywallID$annotations", "getPaywallID", "getPaywallRevision$annotations", "getPaywallRevision", "()I", "getPresentedOfferingContext$annotations", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "getProductID$annotations", "getProductID", "getResultingPackageIdentifier$annotations", "getResultingPackageIdentifier", "getResultingProductIdentifier$annotations", "getResultingProductIdentifier", "getSessionID$annotations", "getSessionID", "getTimestamp", "()J", "getType", "getVersion", "getWorkflowID$annotations", "getWorkflowID", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("paywalls")
    public static final /* data */ class Paywalls extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appUserID;
        private final String componentName;
        private final String componentType;
        private final String componentUrl;
        private final String componentValue;
        private final String currentPackageIdentifier;
        private final String currentProductIdentifier;
        private final boolean darkMode;
        private final Integer defaultIndex;
        private final String defaultPackageIdentifier;
        private final String defaultProductIdentifier;
        private final String destinationContextName;
        private final Integer destinationIndex;
        private final String destinationPackageIdentifier;
        private final String destinationProductIdentifier;
        private final String displayMode;
        private final Integer errorCode;
        private final String errorMessage;
        private final String exitOfferType;
        private final String exitOfferingID;
        private final String id;
        private final String localeIdentifier;
        private final String offeringID;
        private final String originContextName;
        private final Integer originIndex;
        private final String originPackageIdentifier;
        private final String originProductIdentifier;
        private final String packageID;
        private final String paywallID;
        private final int paywallRevision;
        private final PresentedOfferingContextData presentedOfferingContext;
        private final String productID;
        private final String resultingPackageIdentifier;
        private final String resultingProductIdentifier;
        private final String sessionID;
        private final long timestamp;
        private final String type;
        private final int version;
        private final String workflowID;

        public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, long j, String str7, boolean z, String str8, String str9, PresentedOfferingContextData presentedOfferingContextData, String str10, String str11, String str12, String str13, Integer num, String str14, String str15, String str16, String str17, String str18, Integer num2, Integer num3, String str19, String str20, Integer num4, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, int i3, int i4, Object obj) {
            String str31;
            String str32;
            String str33;
            String str34;
            Integer num5;
            Integer num6;
            String str35;
            String str36;
            Integer num7;
            String str37;
            String str38;
            String str39;
            String str40;
            String str41;
            String str42;
            String str43;
            String str44;
            String str45;
            long j2;
            String str46;
            boolean z2;
            String str47;
            String str48;
            PresentedOfferingContextData presentedOfferingContextData2;
            String str49;
            String str50;
            String str51;
            Integer num8;
            String str52;
            String str53;
            String str54;
            int i5;
            String str55;
            String str56;
            String str57;
            String str58;
            String str59;
            int i6;
            String str60 = (i3 & 1) != 0 ? paywalls.id : str;
            int i7 = (i3 & 2) != 0 ? paywalls.version : i;
            String str61 = (i3 & 4) != 0 ? paywalls.type : str2;
            String str62 = (i3 & 8) != 0 ? paywalls.appUserID : str3;
            String str63 = (i3 & 16) != 0 ? paywalls.sessionID : str4;
            String str64 = (i3 & 32) != 0 ? paywalls.offeringID : str5;
            String str65 = (i3 & 64) != 0 ? paywalls.paywallID : str6;
            int i8 = (i3 & 128) != 0 ? paywalls.paywallRevision : i2;
            long j3 = (i3 & 256) != 0 ? paywalls.timestamp : j;
            String str66 = (i3 & 512) != 0 ? paywalls.displayMode : str7;
            boolean z3 = (i3 & 1024) != 0 ? paywalls.darkMode : z;
            String str67 = (i3 & 2048) != 0 ? paywalls.localeIdentifier : str8;
            String str68 = (i3 & 4096) != 0 ? paywalls.workflowID : str9;
            String str69 = str60;
            PresentedOfferingContextData presentedOfferingContextData3 = (i3 & 8192) != 0 ? paywalls.presentedOfferingContext : presentedOfferingContextData;
            String str70 = (i3 & 16384) != 0 ? paywalls.exitOfferType : str10;
            String str71 = (i3 & 32768) != 0 ? paywalls.exitOfferingID : str11;
            String str72 = (i3 & 65536) != 0 ? paywalls.packageID : str12;
            String str73 = (i3 & 131072) != 0 ? paywalls.productID : str13;
            Integer num9 = (i3 & 262144) != 0 ? paywalls.errorCode : num;
            String str74 = (i3 & 524288) != 0 ? paywalls.errorMessage : str14;
            String str75 = (i3 & 1048576) != 0 ? paywalls.componentType : str15;
            String str76 = (i3 & 2097152) != 0 ? paywalls.componentName : str16;
            String str77 = (i3 & 4194304) != 0 ? paywalls.componentValue : str17;
            String str78 = (i3 & 8388608) != 0 ? paywalls.componentUrl : str18;
            Integer num10 = (i3 & 16777216) != 0 ? paywalls.originIndex : num2;
            Integer num11 = (i3 & 33554432) != 0 ? paywalls.destinationIndex : num3;
            String str79 = (i3 & 67108864) != 0 ? paywalls.originContextName : str19;
            String str80 = (i3 & 134217728) != 0 ? paywalls.destinationContextName : str20;
            Integer num12 = (i3 & 268435456) != 0 ? paywalls.defaultIndex : num4;
            String str81 = (i3 & 536870912) != 0 ? paywalls.originPackageIdentifier : str21;
            String str82 = (i3 & 1073741824) != 0 ? paywalls.destinationPackageIdentifier : str22;
            String str83 = (i3 & Integer.MIN_VALUE) != 0 ? paywalls.defaultPackageIdentifier : str23;
            String str84 = (i4 & 1) != 0 ? paywalls.originProductIdentifier : str24;
            String str85 = (i4 & 2) != 0 ? paywalls.destinationProductIdentifier : str25;
            String str86 = (i4 & 4) != 0 ? paywalls.defaultProductIdentifier : str26;
            String str87 = (i4 & 8) != 0 ? paywalls.currentPackageIdentifier : str27;
            String str88 = (i4 & 16) != 0 ? paywalls.resultingPackageIdentifier : str28;
            String str89 = (i4 & 32) != 0 ? paywalls.currentProductIdentifier : str29;
            if ((i4 & 64) != 0) {
                str32 = str89;
                str31 = paywalls.resultingProductIdentifier;
                str34 = str78;
                num5 = num10;
                num6 = num11;
                str35 = str79;
                str36 = str80;
                num7 = num12;
                str37 = str81;
                str38 = str82;
                str39 = str83;
                str40 = str84;
                str41 = str85;
                str42 = str86;
                str43 = str87;
                str44 = str88;
                str45 = str70;
                str46 = str66;
                z2 = z3;
                str47 = str67;
                str48 = str68;
                presentedOfferingContextData2 = presentedOfferingContextData3;
                str49 = str71;
                str50 = str72;
                str51 = str73;
                num8 = num9;
                str52 = str74;
                str53 = str75;
                str54 = str76;
                str33 = str77;
                i5 = i7;
                str55 = str61;
                str56 = str62;
                str57 = str63;
                str58 = str64;
                str59 = str65;
                i6 = i8;
                j2 = j3;
            } else {
                str31 = str30;
                str32 = str89;
                str33 = str77;
                str34 = str78;
                num5 = num10;
                num6 = num11;
                str35 = str79;
                str36 = str80;
                num7 = num12;
                str37 = str81;
                str38 = str82;
                str39 = str83;
                str40 = str84;
                str41 = str85;
                str42 = str86;
                str43 = str87;
                str44 = str88;
                str45 = str70;
                j2 = j3;
                str46 = str66;
                z2 = z3;
                str47 = str67;
                str48 = str68;
                presentedOfferingContextData2 = presentedOfferingContextData3;
                str49 = str71;
                str50 = str72;
                str51 = str73;
                num8 = num9;
                str52 = str74;
                str53 = str75;
                str54 = str76;
                i5 = i7;
                str55 = str61;
                str56 = str62;
                str57 = str63;
                str58 = str64;
                str59 = str65;
                i6 = i8;
            }
            return paywalls.copy(str69, i5, str55, str56, str57, str58, str59, i6, j2, str46, z2, str47, str48, presentedOfferingContextData2, str45, str49, str50, str51, num8, str52, str53, str54, str33, str34, num5, num6, str35, str36, num7, str37, str38, str39, str40, str41, str42, str43, str44, str32, str31);
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName("component_name")
        public static /* synthetic */ void getComponentName$annotations() {
        }

        @SerialName("component_type")
        public static /* synthetic */ void getComponentType$annotations() {
        }

        @SerialName("component_url")
        public static /* synthetic */ void getComponentUrl$annotations() {
        }

        @SerialName("component_value")
        public static /* synthetic */ void getComponentValue$annotations() {
        }

        @SerialName("current_package_id")
        public static /* synthetic */ void getCurrentPackageIdentifier$annotations() {
        }

        @SerialName("current_product_id")
        public static /* synthetic */ void getCurrentProductIdentifier$annotations() {
        }

        @SerialName(Keys.DARK_MODE)
        public static /* synthetic */ void getDarkMode$annotations() {
        }

        @SerialName("default_index")
        public static /* synthetic */ void getDefaultIndex$annotations() {
        }

        @SerialName("default_package_id")
        public static /* synthetic */ void getDefaultPackageIdentifier$annotations() {
        }

        @SerialName("default_product_id")
        public static /* synthetic */ void getDefaultProductIdentifier$annotations() {
        }

        @SerialName("destination_context_name")
        public static /* synthetic */ void getDestinationContextName$annotations() {
        }

        @SerialName("destination_index")
        public static /* synthetic */ void getDestinationIndex$annotations() {
        }

        @SerialName("destination_package_id")
        public static /* synthetic */ void getDestinationPackageIdentifier$annotations() {
        }

        @SerialName("destination_product_id")
        public static /* synthetic */ void getDestinationProductIdentifier$annotations() {
        }

        @SerialName("display_mode")
        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        @SerialName(DiagnosticsTracker.ERROR_CODE_KEY)
        public static /* synthetic */ void getErrorCode$annotations() {
        }

        @SerialName(DiagnosticsTracker.ERROR_MESSAGE_KEY)
        public static /* synthetic */ void getErrorMessage$annotations() {
        }

        @SerialName("exit_offer_type")
        public static /* synthetic */ void getExitOfferType$annotations() {
        }

        @SerialName("exit_offering_id")
        public static /* synthetic */ void getExitOfferingID$annotations() {
        }

        @SerialName("locale")
        public static /* synthetic */ void getLocaleIdentifier$annotations() {
        }

        @SerialName("offering_id")
        public static /* synthetic */ void getOfferingID$annotations() {
        }

        @SerialName("origin_context_name")
        public static /* synthetic */ void getOriginContextName$annotations() {
        }

        @SerialName("origin_index")
        public static /* synthetic */ void getOriginIndex$annotations() {
        }

        @SerialName("origin_package_id")
        public static /* synthetic */ void getOriginPackageIdentifier$annotations() {
        }

        @SerialName("origin_product_id")
        public static /* synthetic */ void getOriginProductIdentifier$annotations() {
        }

        @SerialName("package_id")
        public static /* synthetic */ void getPackageID$annotations() {
        }

        @SerialName("paywall_id")
        public static /* synthetic */ void getPaywallID$annotations() {
        }

        @SerialName("paywall_revision")
        public static /* synthetic */ void getPaywallRevision$annotations() {
        }

        @SerialName("presented_offering_context")
        public static /* synthetic */ void getPresentedOfferingContext$annotations() {
        }

        @SerialName("product_id")
        public static /* synthetic */ void getProductID$annotations() {
        }

        @SerialName("resulting_package_id")
        public static /* synthetic */ void getResultingPackageIdentifier$annotations() {
        }

        @SerialName("resulting_product_id")
        public static /* synthetic */ void getResultingProductIdentifier$annotations() {
        }

        @SerialName("session_id")
        public static /* synthetic */ void getSessionID$annotations() {
        }

        @SerialName(Keys.WORKFLOW_ID)
        public static /* synthetic */ void getWorkflowID$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getDisplayMode() {
            return this.displayMode;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getWorkflowID() {
            return this.workflowID;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final PresentedOfferingContextData getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getExitOfferType() {
            return this.exitOfferType;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getExitOfferingID() {
            return this.exitOfferingID;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getPackageID() {
            return this.packageID;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getProductID() {
            return this.productID;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Integer getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getComponentType() {
            return this.componentType;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getComponentName() {
            return this.componentName;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getComponentValue() {
            return this.componentValue;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final String getComponentUrl() {
            return this.componentUrl;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Integer getOriginIndex() {
            return this.originIndex;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Integer getDestinationIndex() {
            return this.destinationIndex;
        }

        /* JADX INFO: renamed from: component27, reason: from getter */
        public final String getOriginContextName() {
            return this.originContextName;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final String getDestinationContextName() {
            return this.destinationContextName;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final Integer getDefaultIndex() {
            return this.defaultIndex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component30, reason: from getter */
        public final String getOriginPackageIdentifier() {
            return this.originPackageIdentifier;
        }

        /* JADX INFO: renamed from: component31, reason: from getter */
        public final String getDestinationPackageIdentifier() {
            return this.destinationPackageIdentifier;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final String getDefaultPackageIdentifier() {
            return this.defaultPackageIdentifier;
        }

        /* JADX INFO: renamed from: component33, reason: from getter */
        public final String getOriginProductIdentifier() {
            return this.originProductIdentifier;
        }

        /* JADX INFO: renamed from: component34, reason: from getter */
        public final String getDestinationProductIdentifier() {
            return this.destinationProductIdentifier;
        }

        /* JADX INFO: renamed from: component35, reason: from getter */
        public final String getDefaultProductIdentifier() {
            return this.defaultProductIdentifier;
        }

        /* JADX INFO: renamed from: component36, reason: from getter */
        public final String getCurrentPackageIdentifier() {
            return this.currentPackageIdentifier;
        }

        /* JADX INFO: renamed from: component37, reason: from getter */
        public final String getResultingPackageIdentifier() {
            return this.resultingPackageIdentifier;
        }

        /* JADX INFO: renamed from: component38, reason: from getter */
        public final String getCurrentProductIdentifier() {
            return this.currentProductIdentifier;
        }

        /* JADX INFO: renamed from: component39, reason: from getter */
        public final String getResultingProductIdentifier() {
            return this.resultingProductIdentifier;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSessionID() {
            return this.sessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getOfferingID() {
            return this.offeringID;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPaywallID() {
            return this.paywallID;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Paywalls copy(String id, int version, String type, String appUserID, String sessionID, String offeringID, String paywallID, int paywallRevision, long timestamp, String displayMode, boolean darkMode, String localeIdentifier, String workflowID, PresentedOfferingContextData presentedOfferingContext, String exitOfferType, String exitOfferingID, String packageID, String productID, Integer errorCode, String errorMessage, String componentType, String componentName, String componentValue, String componentUrl, Integer originIndex, Integer destinationIndex, String originContextName, String destinationContextName, Integer defaultIndex, String originPackageIdentifier, String destinationPackageIdentifier, String defaultPackageIdentifier, String originProductIdentifier, String destinationProductIdentifier, String defaultProductIdentifier, String currentPackageIdentifier, String resultingPackageIdentifier, String currentProductIdentifier, String resultingProductIdentifier) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new Paywalls(id, version, type, appUserID, sessionID, offeringID, paywallID, paywallRevision, timestamp, displayMode, darkMode, localeIdentifier, workflowID, presentedOfferingContext, exitOfferType, exitOfferingID, packageID, productID, errorCode, errorMessage, componentType, componentName, componentValue, componentUrl, originIndex, destinationIndex, originContextName, destinationContextName, defaultIndex, originPackageIdentifier, destinationPackageIdentifier, defaultPackageIdentifier, originProductIdentifier, destinationProductIdentifier, defaultProductIdentifier, currentPackageIdentifier, resultingPackageIdentifier, currentProductIdentifier, resultingProductIdentifier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Paywalls)) {
                return false;
            }
            Paywalls paywalls = (Paywalls) other;
            return Intrinsics.areEqual(this.id, paywalls.id) && this.version == paywalls.version && Intrinsics.areEqual(this.type, paywalls.type) && Intrinsics.areEqual(this.appUserID, paywalls.appUserID) && Intrinsics.areEqual(this.sessionID, paywalls.sessionID) && Intrinsics.areEqual(this.offeringID, paywalls.offeringID) && Intrinsics.areEqual(this.paywallID, paywalls.paywallID) && this.paywallRevision == paywalls.paywallRevision && this.timestamp == paywalls.timestamp && Intrinsics.areEqual(this.displayMode, paywalls.displayMode) && this.darkMode == paywalls.darkMode && Intrinsics.areEqual(this.localeIdentifier, paywalls.localeIdentifier) && Intrinsics.areEqual(this.workflowID, paywalls.workflowID) && Intrinsics.areEqual(this.presentedOfferingContext, paywalls.presentedOfferingContext) && Intrinsics.areEqual(this.exitOfferType, paywalls.exitOfferType) && Intrinsics.areEqual(this.exitOfferingID, paywalls.exitOfferingID) && Intrinsics.areEqual(this.packageID, paywalls.packageID) && Intrinsics.areEqual(this.productID, paywalls.productID) && Intrinsics.areEqual(this.errorCode, paywalls.errorCode) && Intrinsics.areEqual(this.errorMessage, paywalls.errorMessage) && Intrinsics.areEqual(this.componentType, paywalls.componentType) && Intrinsics.areEqual(this.componentName, paywalls.componentName) && Intrinsics.areEqual(this.componentValue, paywalls.componentValue) && Intrinsics.areEqual(this.componentUrl, paywalls.componentUrl) && Intrinsics.areEqual(this.originIndex, paywalls.originIndex) && Intrinsics.areEqual(this.destinationIndex, paywalls.destinationIndex) && Intrinsics.areEqual(this.originContextName, paywalls.originContextName) && Intrinsics.areEqual(this.destinationContextName, paywalls.destinationContextName) && Intrinsics.areEqual(this.defaultIndex, paywalls.defaultIndex) && Intrinsics.areEqual(this.originPackageIdentifier, paywalls.originPackageIdentifier) && Intrinsics.areEqual(this.destinationPackageIdentifier, paywalls.destinationPackageIdentifier) && Intrinsics.areEqual(this.defaultPackageIdentifier, paywalls.defaultPackageIdentifier) && Intrinsics.areEqual(this.originProductIdentifier, paywalls.originProductIdentifier) && Intrinsics.areEqual(this.destinationProductIdentifier, paywalls.destinationProductIdentifier) && Intrinsics.areEqual(this.defaultProductIdentifier, paywalls.defaultProductIdentifier) && Intrinsics.areEqual(this.currentPackageIdentifier, paywalls.currentPackageIdentifier) && Intrinsics.areEqual(this.resultingPackageIdentifier, paywalls.resultingPackageIdentifier) && Intrinsics.areEqual(this.currentProductIdentifier, paywalls.currentProductIdentifier) && Intrinsics.areEqual(this.resultingProductIdentifier, paywalls.resultingProductIdentifier);
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + this.offeringID.hashCode()) * 31;
            String str = this.paywallID;
            int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.displayMode.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.localeIdentifier.hashCode()) * 31;
            String str2 = this.workflowID;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            PresentedOfferingContextData presentedOfferingContextData = this.presentedOfferingContext;
            int iHashCode4 = (iHashCode3 + (presentedOfferingContextData == null ? 0 : presentedOfferingContextData.hashCode())) * 31;
            String str3 = this.exitOfferType;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.exitOfferingID;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.packageID;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.productID;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num = this.errorCode;
            int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
            String str7 = this.errorMessage;
            int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.componentType;
            int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.componentName;
            int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.componentValue;
            int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.componentUrl;
            int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Integer num2 = this.originIndex;
            int iHashCode15 = (iHashCode14 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.destinationIndex;
            int iHashCode16 = (iHashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str12 = this.originContextName;
            int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
            String str13 = this.destinationContextName;
            int iHashCode18 = (iHashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
            Integer num4 = this.defaultIndex;
            int iHashCode19 = (iHashCode18 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str14 = this.originPackageIdentifier;
            int iHashCode20 = (iHashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.destinationPackageIdentifier;
            int iHashCode21 = (iHashCode20 + (str15 == null ? 0 : str15.hashCode())) * 31;
            String str16 = this.defaultPackageIdentifier;
            int iHashCode22 = (iHashCode21 + (str16 == null ? 0 : str16.hashCode())) * 31;
            String str17 = this.originProductIdentifier;
            int iHashCode23 = (iHashCode22 + (str17 == null ? 0 : str17.hashCode())) * 31;
            String str18 = this.destinationProductIdentifier;
            int iHashCode24 = (iHashCode23 + (str18 == null ? 0 : str18.hashCode())) * 31;
            String str19 = this.defaultProductIdentifier;
            int iHashCode25 = (iHashCode24 + (str19 == null ? 0 : str19.hashCode())) * 31;
            String str20 = this.currentPackageIdentifier;
            int iHashCode26 = (iHashCode25 + (str20 == null ? 0 : str20.hashCode())) * 31;
            String str21 = this.resultingPackageIdentifier;
            int iHashCode27 = (iHashCode26 + (str21 == null ? 0 : str21.hashCode())) * 31;
            String str22 = this.currentProductIdentifier;
            int iHashCode28 = (iHashCode27 + (str22 == null ? 0 : str22.hashCode())) * 31;
            String str23 = this.resultingProductIdentifier;
            return iHashCode28 + (str23 != null ? str23.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            StringBuilder sb = new StringBuilder("Paywalls(id=");
            sb.append(this.id).append(", version=").append(this.version).append(", type=").append(this.type).append(", appUserID=").append(this.appUserID).append(", sessionID=").append(this.sessionID).append(", offeringID=").append(this.offeringID).append(", paywallID=").append(this.paywallID).append(", paywallRevision=").append(this.paywallRevision).append(", timestamp=").append(this.timestamp).append(", displayMode=").append(this.displayMode).append(", darkMode=").append(this.darkMode).append(", localeIdentifier=");
            sb.append(this.localeIdentifier).append(", workflowID=").append(this.workflowID).append(", presentedOfferingContext=").append(this.presentedOfferingContext).append(", exitOfferType=").append(this.exitOfferType).append(", exitOfferingID=").append(this.exitOfferingID).append(", packageID=").append(this.packageID).append(", productID=").append(this.productID).append(", errorCode=").append(this.errorCode).append(", errorMessage=").append(this.errorMessage).append(", componentType=").append(this.componentType).append(", componentName=").append(this.componentName).append(", componentValue=").append(this.componentValue);
            sb.append(", componentUrl=").append(this.componentUrl).append(", originIndex=").append(this.originIndex).append(", destinationIndex=").append(this.destinationIndex).append(", originContextName=").append(this.originContextName).append(", destinationContextName=").append(this.destinationContextName).append(", defaultIndex=").append(this.defaultIndex).append(", originPackageIdentifier=").append(this.originPackageIdentifier).append(", destinationPackageIdentifier=").append(this.destinationPackageIdentifier).append(", defaultPackageIdentifier=").append(this.defaultPackageIdentifier).append(", originProductIdentifier=").append(this.originProductIdentifier).append(", destinationProductIdentifier=").append(this.destinationProductIdentifier).append(", defaultProductIdentifier=");
            sb.append(this.defaultProductIdentifier).append(", currentPackageIdentifier=").append(this.currentPackageIdentifier).append(", resultingPackageIdentifier=").append(this.resultingPackageIdentifier).append(", currentProductIdentifier=").append(this.currentProductIdentifier).append(", resultingProductIdentifier=").append(this.resultingProductIdentifier).append(')');
            return sb.toString();
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Paywalls> serializer() {
                return BackendEvent$Paywalls$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Paywalls(int i, int i2, String str, int i3, String str2, @SerialName("app_user_id") String str3, @SerialName("session_id") String str4, @SerialName("offering_id") String str5, @SerialName("paywall_id") String str6, @SerialName("paywall_revision") int i4, long j, @SerialName("display_mode") String str7, @SerialName(Keys.DARK_MODE) boolean z, @SerialName("locale") String str8, @SerialName(Keys.WORKFLOW_ID) String str9, @SerialName("presented_offering_context") PresentedOfferingContextData presentedOfferingContextData, @SerialName("exit_offer_type") String str10, @SerialName("exit_offering_id") String str11, @SerialName("package_id") String str12, @SerialName("product_id") String str13, @SerialName(DiagnosticsTracker.ERROR_CODE_KEY) Integer num, @SerialName(DiagnosticsTracker.ERROR_MESSAGE_KEY) String str14, @SerialName("component_type") String str15, @SerialName("component_name") String str16, @SerialName("component_value") String str17, @SerialName("component_url") String str18, @SerialName("origin_index") Integer num2, @SerialName("destination_index") Integer num3, @SerialName("origin_context_name") String str19, @SerialName("destination_context_name") String str20, @SerialName("default_index") Integer num4, @SerialName("origin_package_id") String str21, @SerialName("destination_package_id") String str22, @SerialName("default_package_id") String str23, @SerialName("origin_product_id") String str24, @SerialName("destination_product_id") String str25, @SerialName("default_product_id") String str26, @SerialName("current_package_id") String str27, @SerialName("resulting_package_id") String str28, @SerialName("current_product_id") String str29, @SerialName("resulting_product_id") String str30, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwArrayMissingFieldException(new int[]{i, i2}, new int[]{4095, 0}, BackendEvent$Paywalls$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i3;
            this.type = str2;
            this.appUserID = str3;
            this.sessionID = str4;
            this.offeringID = str5;
            this.paywallID = str6;
            this.paywallRevision = i4;
            this.timestamp = j;
            this.displayMode = str7;
            this.darkMode = z;
            this.localeIdentifier = str8;
            if ((i & 4096) == 0) {
                this.workflowID = null;
            } else {
                this.workflowID = str9;
            }
            if ((i & 8192) == 0) {
                this.presentedOfferingContext = null;
            } else {
                this.presentedOfferingContext = presentedOfferingContextData;
            }
            if ((i & 16384) == 0) {
                this.exitOfferType = null;
            } else {
                this.exitOfferType = str10;
            }
            if ((32768 & i) == 0) {
                this.exitOfferingID = null;
            } else {
                this.exitOfferingID = str11;
            }
            if ((65536 & i) == 0) {
                this.packageID = null;
            } else {
                this.packageID = str12;
            }
            if ((131072 & i) == 0) {
                this.productID = null;
            } else {
                this.productID = str13;
            }
            if ((262144 & i) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num;
            }
            if ((524288 & i) == 0) {
                this.errorMessage = null;
            } else {
                this.errorMessage = str14;
            }
            if ((1048576 & i) == 0) {
                this.componentType = null;
            } else {
                this.componentType = str15;
            }
            if ((2097152 & i) == 0) {
                this.componentName = null;
            } else {
                this.componentName = str16;
            }
            if ((4194304 & i) == 0) {
                this.componentValue = null;
            } else {
                this.componentValue = str17;
            }
            if ((8388608 & i) == 0) {
                this.componentUrl = null;
            } else {
                this.componentUrl = str18;
            }
            if ((16777216 & i) == 0) {
                this.originIndex = null;
            } else {
                this.originIndex = num2;
            }
            if ((33554432 & i) == 0) {
                this.destinationIndex = null;
            } else {
                this.destinationIndex = num3;
            }
            if ((67108864 & i) == 0) {
                this.originContextName = null;
            } else {
                this.originContextName = str19;
            }
            if ((134217728 & i) == 0) {
                this.destinationContextName = null;
            } else {
                this.destinationContextName = str20;
            }
            if ((268435456 & i) == 0) {
                this.defaultIndex = null;
            } else {
                this.defaultIndex = num4;
            }
            if ((536870912 & i) == 0) {
                this.originPackageIdentifier = null;
            } else {
                this.originPackageIdentifier = str21;
            }
            if ((1073741824 & i) == 0) {
                this.destinationPackageIdentifier = null;
            } else {
                this.destinationPackageIdentifier = str22;
            }
            if ((i & Integer.MIN_VALUE) == 0) {
                this.defaultPackageIdentifier = null;
            } else {
                this.defaultPackageIdentifier = str23;
            }
            if ((i2 & 1) == 0) {
                this.originProductIdentifier = null;
            } else {
                this.originProductIdentifier = str24;
            }
            if ((i2 & 2) == 0) {
                this.destinationProductIdentifier = null;
            } else {
                this.destinationProductIdentifier = str25;
            }
            if ((i2 & 4) == 0) {
                this.defaultProductIdentifier = null;
            } else {
                this.defaultProductIdentifier = str26;
            }
            if ((i2 & 8) == 0) {
                this.currentPackageIdentifier = null;
            } else {
                this.currentPackageIdentifier = str27;
            }
            if ((i2 & 16) == 0) {
                this.resultingPackageIdentifier = null;
            } else {
                this.resultingPackageIdentifier = str28;
            }
            if ((i2 & 32) == 0) {
                this.currentProductIdentifier = null;
            } else {
                this.currentProductIdentifier = str29;
            }
            if ((i2 & 64) == 0) {
                this.resultingProductIdentifier = null;
            } else {
                this.resultingProductIdentifier = str30;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Paywalls self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            output.encodeStringElement(serialDesc, 4, self.sessionID);
            output.encodeStringElement(serialDesc, 5, self.offeringID);
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.paywallID);
            output.encodeIntElement(serialDesc, 7, self.paywallRevision);
            output.encodeLongElement(serialDesc, 8, self.timestamp);
            output.encodeStringElement(serialDesc, 9, self.displayMode);
            output.encodeBooleanElement(serialDesc, 10, self.darkMode);
            output.encodeStringElement(serialDesc, 11, self.localeIdentifier);
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.workflowID != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.workflowID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.presentedOfferingContext != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, BackendEvent$PresentedOfferingContextData$$serializer.INSTANCE, self.presentedOfferingContext);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.exitOfferType != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.exitOfferType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.exitOfferingID != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.exitOfferingID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.packageID != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.packageID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.productID != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.productID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.errorCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.errorCode);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.errorMessage != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.errorMessage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.componentType != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.componentType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.componentName != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.componentName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.componentValue != null) {
                output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.componentValue);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.componentUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.componentUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 24) || self.originIndex != null) {
                output.encodeNullableSerializableElement(serialDesc, 24, IntSerializer.INSTANCE, self.originIndex);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 25) || self.destinationIndex != null) {
                output.encodeNullableSerializableElement(serialDesc, 25, IntSerializer.INSTANCE, self.destinationIndex);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.originContextName != null) {
                output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.originContextName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 27) || self.destinationContextName != null) {
                output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.destinationContextName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 28) || self.defaultIndex != null) {
                output.encodeNullableSerializableElement(serialDesc, 28, IntSerializer.INSTANCE, self.defaultIndex);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.originPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 29, StringSerializer.INSTANCE, self.originPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.destinationPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 30, StringSerializer.INSTANCE, self.destinationPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.defaultPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 31, StringSerializer.INSTANCE, self.defaultPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.originProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 32, StringSerializer.INSTANCE, self.originProductIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 33) || self.destinationProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 33, StringSerializer.INSTANCE, self.destinationProductIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.defaultProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 34, StringSerializer.INSTANCE, self.defaultProductIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.currentPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 35, StringSerializer.INSTANCE, self.currentPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.resultingPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 36, StringSerializer.INSTANCE, self.resultingPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 37) || self.currentProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 37, StringSerializer.INSTANCE, self.currentProductIdentifier);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 38) && self.resultingProductIdentifier == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 38, StringSerializer.INSTANCE, self.resultingProductIdentifier);
        }

        public /* synthetic */ Paywalls(String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, long j, String str7, boolean z, String str8, String str9, PresentedOfferingContextData presentedOfferingContextData, String str10, String str11, String str12, String str13, Integer num, String str14, String str15, String str16, String str17, String str18, Integer num2, Integer num3, String str19, String str20, Integer num4, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, str3, str4, str5, str6, i2, j, str7, z, str8, (i3 & 4096) != 0 ? null : str9, (i3 & 8192) != 0 ? null : presentedOfferingContextData, (i3 & 16384) != 0 ? null : str10, (32768 & i3) != 0 ? null : str11, (65536 & i3) != 0 ? null : str12, (131072 & i3) != 0 ? null : str13, (262144 & i3) != 0 ? null : num, (524288 & i3) != 0 ? null : str14, (1048576 & i3) != 0 ? null : str15, (2097152 & i3) != 0 ? null : str16, (4194304 & i3) != 0 ? null : str17, (8388608 & i3) != 0 ? null : str18, (16777216 & i3) != 0 ? null : num2, (33554432 & i3) != 0 ? null : num3, (67108864 & i3) != 0 ? null : str19, (134217728 & i3) != 0 ? null : str20, (268435456 & i3) != 0 ? null : num4, (536870912 & i3) != 0 ? null : str21, (1073741824 & i3) != 0 ? null : str22, (i3 & Integer.MIN_VALUE) != 0 ? null : str23, (i4 & 1) != 0 ? null : str24, (i4 & 2) != 0 ? null : str25, (i4 & 4) != 0 ? null : str26, (i4 & 8) != 0 ? null : str27, (i4 & 16) != 0 ? null : str28, (i4 & 32) != 0 ? null : str29, (i4 & 64) != 0 ? null : str30);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getSessionID() {
            return this.sessionID;
        }

        public final String getOfferingID() {
            return this.offeringID;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final String getWorkflowID() {
            return this.workflowID;
        }

        public final PresentedOfferingContextData getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final String getExitOfferType() {
            return this.exitOfferType;
        }

        public final String getExitOfferingID() {
            return this.exitOfferingID;
        }

        public final String getPackageID() {
            return this.packageID;
        }

        public final String getProductID() {
            return this.productID;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final String getComponentType() {
            return this.componentType;
        }

        public final String getComponentName() {
            return this.componentName;
        }

        public final String getComponentValue() {
            return this.componentValue;
        }

        public final String getComponentUrl() {
            return this.componentUrl;
        }

        public final Integer getOriginIndex() {
            return this.originIndex;
        }

        public final Integer getDestinationIndex() {
            return this.destinationIndex;
        }

        public final String getOriginContextName() {
            return this.originContextName;
        }

        public final String getDestinationContextName() {
            return this.destinationContextName;
        }

        public final Integer getDefaultIndex() {
            return this.defaultIndex;
        }

        public final String getOriginPackageIdentifier() {
            return this.originPackageIdentifier;
        }

        public final String getDestinationPackageIdentifier() {
            return this.destinationPackageIdentifier;
        }

        public final String getDefaultPackageIdentifier() {
            return this.defaultPackageIdentifier;
        }

        public final String getOriginProductIdentifier() {
            return this.originProductIdentifier;
        }

        public final String getDestinationProductIdentifier() {
            return this.destinationProductIdentifier;
        }

        public final String getDefaultProductIdentifier() {
            return this.defaultProductIdentifier;
        }

        public final String getCurrentPackageIdentifier() {
            return this.currentPackageIdentifier;
        }

        public final String getResultingPackageIdentifier() {
            return this.resultingPackageIdentifier;
        }

        public final String getCurrentProductIdentifier() {
            return this.currentProductIdentifier;
        }

        public final String getResultingProductIdentifier() {
            return this.resultingProductIdentifier;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywalls(String id, int i, String type, String appUserID, String sessionID, String offeringID, String str, int i2, long j, String displayMode, boolean z, String localeIdentifier, String str2, PresentedOfferingContextData presentedOfferingContextData, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, String str11, Integer num2, Integer num3, String str12, String str13, Integer num4, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.id = id;
            this.version = i;
            this.type = type;
            this.appUserID = appUserID;
            this.sessionID = sessionID;
            this.offeringID = offeringID;
            this.paywallID = str;
            this.paywallRevision = i2;
            this.timestamp = j;
            this.displayMode = displayMode;
            this.darkMode = z;
            this.localeIdentifier = localeIdentifier;
            this.workflowID = str2;
            this.presentedOfferingContext = presentedOfferingContextData;
            this.exitOfferType = str3;
            this.exitOfferingID = str4;
            this.packageID = str5;
            this.productID = str6;
            this.errorCode = num;
            this.errorMessage = str7;
            this.componentType = str8;
            this.componentName = str9;
            this.componentValue = str10;
            this.componentUrl = str11;
            this.originIndex = num2;
            this.destinationIndex = num3;
            this.originContextName = str12;
            this.destinationContextName = str13;
            this.defaultIndex = num4;
            this.originPackageIdentifier = str14;
            this.destinationPackageIdentifier = str15;
            this.defaultPackageIdentifier = str16;
            this.originProductIdentifier = str17;
            this.destinationProductIdentifier = str18;
            this.defaultProductIdentifier = str19;
            this.currentPackageIdentifier = str20;
            this.resultingPackageIdentifier = str21;
            this.currentProductIdentifier = str22;
            this.resultingProductIdentifier = str23;
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245Ba\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rBM\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÁ\u0001¢\u0006\u0002\b3R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012¨\u00066"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "", "seen1", "", "placementIdentifier", "", "targetingRevision", "targetingRuleId", "paywallID", "workflowID", "traceId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPaywallID$annotations", "()V", "getPaywallID", "()Ljava/lang/String;", "getPlacementIdentifier$annotations", "getPlacementIdentifier", "getTargetingRevision$annotations", "getTargetingRevision", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTargetingRuleId$annotations", "getTargetingRuleId", "getTraceId$annotations", "getTraceId", "getWorkflowID$annotations", "getWorkflowID", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    public static final /* data */ class PresentedOfferingContextData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String paywallID;
        private final String placementIdentifier;
        private final Integer targetingRevision;
        private final String targetingRuleId;
        private final String traceId;
        private final String workflowID;

        public PresentedOfferingContextData() {
            this((String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PresentedOfferingContextData copy$default(PresentedOfferingContextData presentedOfferingContextData, String str, Integer num, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = presentedOfferingContextData.placementIdentifier;
            }
            if ((i & 2) != 0) {
                num = presentedOfferingContextData.targetingRevision;
            }
            if ((i & 4) != 0) {
                str2 = presentedOfferingContextData.targetingRuleId;
            }
            if ((i & 8) != 0) {
                str3 = presentedOfferingContextData.paywallID;
            }
            if ((i & 16) != 0) {
                str4 = presentedOfferingContextData.workflowID;
            }
            if ((i & 32) != 0) {
                str5 = presentedOfferingContextData.traceId;
            }
            String str6 = str4;
            String str7 = str5;
            return presentedOfferingContextData.copy(str, num, str2, str3, str6, str7);
        }

        @SerialName("paywall_id")
        public static /* synthetic */ void getPaywallID$annotations() {
        }

        @SerialName("placement_identifier")
        public static /* synthetic */ void getPlacementIdentifier$annotations() {
        }

        @SerialName("targeting_revision")
        public static /* synthetic */ void getTargetingRevision$annotations() {
        }

        @SerialName("targeting_rule_id")
        public static /* synthetic */ void getTargetingRuleId$annotations() {
        }

        @SerialName("trace_id")
        public static /* synthetic */ void getTraceId$annotations() {
        }

        @SerialName(Keys.WORKFLOW_ID)
        public static /* synthetic */ void getWorkflowID$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPlacementIdentifier() {
            return this.placementIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTargetingRevision() {
            return this.targetingRevision;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTargetingRuleId() {
            return this.targetingRuleId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPaywallID() {
            return this.paywallID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getWorkflowID() {
            return this.workflowID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        public final PresentedOfferingContextData copy(String placementIdentifier, Integer targetingRevision, String targetingRuleId, String paywallID, String workflowID, String traceId) {
            return new PresentedOfferingContextData(placementIdentifier, targetingRevision, targetingRuleId, paywallID, workflowID, traceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PresentedOfferingContextData)) {
                return false;
            }
            PresentedOfferingContextData presentedOfferingContextData = (PresentedOfferingContextData) other;
            return Intrinsics.areEqual(this.placementIdentifier, presentedOfferingContextData.placementIdentifier) && Intrinsics.areEqual(this.targetingRevision, presentedOfferingContextData.targetingRevision) && Intrinsics.areEqual(this.targetingRuleId, presentedOfferingContextData.targetingRuleId) && Intrinsics.areEqual(this.paywallID, presentedOfferingContextData.paywallID) && Intrinsics.areEqual(this.workflowID, presentedOfferingContextData.workflowID) && Intrinsics.areEqual(this.traceId, presentedOfferingContextData.traceId);
        }

        public int hashCode() {
            String str = this.placementIdentifier;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.targetingRevision;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.targetingRuleId;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.paywallID;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.workflowID;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.traceId;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "PresentedOfferingContextData(placementIdentifier=" + this.placementIdentifier + ", targetingRevision=" + this.targetingRevision + ", targetingRuleId=" + this.targetingRuleId + ", paywallID=" + this.paywallID + ", workflowID=" + this.workflowID + ", traceId=" + this.traceId + ')';
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ PresentedOfferingContextData(int i, @SerialName("placement_identifier") String str, @SerialName("targeting_revision") Integer num, @SerialName("targeting_rule_id") String str2, @SerialName("paywall_id") String str3, @SerialName(Keys.WORKFLOW_ID) String str4, @SerialName("trace_id") String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.placementIdentifier = null;
            } else {
                this.placementIdentifier = str;
            }
            if ((i & 2) == 0) {
                this.targetingRevision = null;
            } else {
                this.targetingRevision = num;
            }
            if ((i & 4) == 0) {
                this.targetingRuleId = null;
            } else {
                this.targetingRuleId = str2;
            }
            if ((i & 8) == 0) {
                this.paywallID = null;
            } else {
                this.paywallID = str3;
            }
            if ((i & 16) == 0) {
                this.workflowID = null;
            } else {
                this.workflowID = str4;
            }
            if ((i & 32) == 0) {
                this.traceId = null;
            } else {
                this.traceId = str5;
            }
        }

        public PresentedOfferingContextData(String str, Integer num, String str2, String str3, String str4, String str5) {
            this.placementIdentifier = str;
            this.targetingRevision = num;
            this.targetingRuleId = str2;
            this.paywallID = str3;
            this.workflowID = str4;
            this.traceId = str5;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(PresentedOfferingContextData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.placementIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.placementIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.targetingRevision != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.targetingRevision);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.targetingRuleId != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.targetingRuleId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.paywallID != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.paywallID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.workflowID != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.workflowID);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.traceId == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.traceId);
        }

        public /* synthetic */ PresentedOfferingContextData(String str, Integer num, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
        }

        public final String getPlacementIdentifier() {
            return this.placementIdentifier;
        }

        public final Integer getTargetingRevision() {
            return this.targetingRevision;
        }

        public final String getTargetingRuleId() {
            return this.targetingRuleId;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final String getWorkflowID() {
            return this.workflowID;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fHÆ\u0001¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData$Companion;", "", "()V", "fromContext", "Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", WebViewMessageType.CONTEXT, "Lcom/revenuecat/purchases/PresentedOfferingContext;", "paywallId", "", "workflowId", "traceId", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PresentedOfferingContextData> serializer() {
                return BackendEvent$PresentedOfferingContextData$$serializer.INSTANCE;
            }

            public static /* synthetic */ PresentedOfferingContextData fromContext$default(Companion companion, PresentedOfferingContext presentedOfferingContext, String str, String str2, String str3, int i, Object obj) {
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                if ((i & 8) != 0) {
                    str3 = null;
                }
                return companion.fromContext(presentedOfferingContext, str, str2, str3);
            }

            public final PresentedOfferingContextData fromContext(PresentedOfferingContext context, String paywallId, String workflowId, String traceId) {
                Intrinsics.checkNotNullParameter(context, "context");
                boolean z = (context.getPlacementIdentifier() == null && context.getTargetingContext() == null) ? false : true;
                boolean z2 = (paywallId == null && workflowId == null && traceId == null) ? false : true;
                if (!z && !z2) {
                    return null;
                }
                String placementIdentifier = context.getPlacementIdentifier();
                PresentedOfferingContext.TargetingContext targetingContext = context.getTargetingContext();
                Integer numValueOf = targetingContext != null ? Integer.valueOf(targetingContext.getRevision()) : null;
                PresentedOfferingContext.TargetingContext targetingContext2 = context.getTargetingContext();
                return new PresentedOfferingContextData(placementIdentifier, numValueOf, targetingContext2 != null ? targetingContext2.getRuleId() : null, paywallId, workflowId, traceId);
            }
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@By\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012B]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jk\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÁ\u0001¢\u0006\u0002\b>R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006A"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "version", "type", "appUserID", "appSessionID", DiagnosticsEntry.TIMESTAMP_KEY, "", "paywallID", "offeringID", "presentedOfferingContext", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;)V", "getAppSessionID$annotations", "()V", "getAppSessionID", "()Ljava/lang/String;", "getAppUserID$annotations", "getAppUserID", "getId", "getOfferingID$annotations", "getOfferingID", "getPaywallID$annotations", "getPaywallID", "getPresentedOfferingContext$annotations", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;", "getTimestamp", "()J", "getType", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("custom_paywall_event")
    public static final /* data */ class CustomPaywall extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appSessionID;
        private final String appUserID;
        private final String id;
        private final String offeringID;
        private final String paywallID;
        private final CustomPaywallPresentedOfferingContextData presentedOfferingContext;
        private final long timestamp;
        private final String type;
        private final int version;

        public static /* synthetic */ CustomPaywall copy$default(CustomPaywall customPaywall, String str, int i, String str2, String str3, String str4, long j, String str5, String str6, CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = customPaywall.id;
            }
            if ((i2 & 2) != 0) {
                i = customPaywall.version;
            }
            if ((i2 & 4) != 0) {
                str2 = customPaywall.type;
            }
            if ((i2 & 8) != 0) {
                str3 = customPaywall.appUserID;
            }
            if ((i2 & 16) != 0) {
                str4 = customPaywall.appSessionID;
            }
            if ((i2 & 32) != 0) {
                j = customPaywall.timestamp;
            }
            if ((i2 & 64) != 0) {
                str5 = customPaywall.paywallID;
            }
            if ((i2 & 128) != 0) {
                str6 = customPaywall.offeringID;
            }
            if ((i2 & 256) != 0) {
                customPaywallPresentedOfferingContextData = customPaywall.presentedOfferingContext;
            }
            CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData2 = customPaywallPresentedOfferingContextData;
            String str7 = str5;
            long j2 = j;
            String str8 = str3;
            String str9 = str4;
            String str10 = str2;
            return customPaywall.copy(str, i, str10, str8, str9, j2, str7, str6, customPaywallPresentedOfferingContextData2);
        }

        @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY)
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName("offering_id")
        public static /* synthetic */ void getOfferingID$annotations() {
        }

        @SerialName("paywall_id")
        public static /* synthetic */ void getPaywallID$annotations() {
        }

        @SerialName("presented_offering_context")
        public static /* synthetic */ void getPresentedOfferingContext$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPaywallID() {
            return this.paywallID;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getOfferingID() {
            return this.offeringID;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final CustomPaywallPresentedOfferingContextData getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final CustomPaywall copy(String id, int version, String type, String appUserID, String appSessionID, long timestamp, String paywallID, String offeringID, CustomPaywallPresentedOfferingContextData presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            return new CustomPaywall(id, version, type, appUserID, appSessionID, timestamp, paywallID, offeringID, presentedOfferingContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomPaywall)) {
                return false;
            }
            CustomPaywall customPaywall = (CustomPaywall) other;
            return Intrinsics.areEqual(this.id, customPaywall.id) && this.version == customPaywall.version && Intrinsics.areEqual(this.type, customPaywall.type) && Intrinsics.areEqual(this.appUserID, customPaywall.appUserID) && Intrinsics.areEqual(this.appSessionID, customPaywall.appSessionID) && this.timestamp == customPaywall.timestamp && Intrinsics.areEqual(this.paywallID, customPaywall.paywallID) && Intrinsics.areEqual(this.offeringID, customPaywall.offeringID) && Intrinsics.areEqual(this.presentedOfferingContext, customPaywall.presentedOfferingContext);
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31;
            String str = this.appSessionID;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str2 = this.paywallID;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.offeringID;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData = this.presentedOfferingContext;
            return iHashCode4 + (customPaywallPresentedOfferingContextData != null ? customPaywallPresentedOfferingContextData.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomPaywall(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", timestamp=" + this.timestamp + ", paywallID=" + this.paywallID + ", offeringID=" + this.offeringID + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CustomPaywall> serializer() {
                return BackendEvent$CustomPaywall$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CustomPaywall(int i, String str, int i2, String str2, @SerialName("app_user_id") String str3, @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY) String str4, long j, @SerialName("paywall_id") String str5, @SerialName("offering_id") String str6, @SerialName("presented_offering_context") CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (47 != (i & 47)) {
                PluginExceptionsKt.throwMissingFieldException(i, 47, BackendEvent$CustomPaywall$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.appUserID = str3;
            if ((i & 16) == 0) {
                this.appSessionID = null;
            } else {
                this.appSessionID = str4;
            }
            this.timestamp = j;
            if ((i & 64) == 0) {
                this.paywallID = null;
            } else {
                this.paywallID = str5;
            }
            if ((i & 128) == 0) {
                this.offeringID = null;
            } else {
                this.offeringID = str6;
            }
            if ((i & 256) == 0) {
                this.presentedOfferingContext = null;
            } else {
                this.presentedOfferingContext = customPaywallPresentedOfferingContextData;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(CustomPaywall self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.appSessionID != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.appSessionID);
            }
            output.encodeLongElement(serialDesc, 5, self.timestamp);
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.paywallID != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.paywallID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.offeringID != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.offeringID);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.presentedOfferingContext == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 8, C7174x93065cce.INSTANCE, self.presentedOfferingContext);
        }

        public /* synthetic */ CustomPaywall(String str, int i, String str2, String str3, String str4, long j, String str5, String str6, CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, str3, (i2 & 16) != 0 ? null : str4, j, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? null : customPaywallPresentedOfferingContextData);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final String getOfferingID() {
            return this.offeringID;
        }

        public final CustomPaywallPresentedOfferingContextData getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPaywall(String id, int i, String type, String appUserID, String str, long j, String str2, String str3, CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            this.id = id;
            this.version = i;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = str;
            this.timestamp = j;
            this.paywallID = str2;
            this.offeringID = str3;
            this.presentedOfferingContext = customPaywallPresentedOfferingContextData;
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245B_\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÁ\u0001¢\u0006\u0002\b3R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00066"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Checkpoint;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "version", "type", Keys.IDENTIFIER, "appUserID", "appSessionID", DiagnosticsEntry.TIMESTAMP_KEY, "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAppSessionID$annotations", "()V", "getAppSessionID", "()Ljava/lang/String;", "getAppUserID$annotations", "getAppUserID", "getId", "getIdentifier", "getTimestamp", "()J", "getType", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("checkpoint")
    public static final /* data */ class Checkpoint extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appSessionID;
        private final String appUserID;
        private final String id;
        private final String identifier;
        private final long timestamp;
        private final String type;
        private final int version;

        public static /* synthetic */ Checkpoint copy$default(Checkpoint checkpoint, String str, int i, String str2, String str3, String str4, String str5, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = checkpoint.id;
            }
            if ((i2 & 2) != 0) {
                i = checkpoint.version;
            }
            if ((i2 & 4) != 0) {
                str2 = checkpoint.type;
            }
            if ((i2 & 8) != 0) {
                str3 = checkpoint.identifier;
            }
            if ((i2 & 16) != 0) {
                str4 = checkpoint.appUserID;
            }
            if ((i2 & 32) != 0) {
                str5 = checkpoint.appSessionID;
            }
            if ((i2 & 64) != 0) {
                j = checkpoint.timestamp;
            }
            long j2 = j;
            String str6 = str4;
            String str7 = str5;
            return checkpoint.copy(str, i, str2, str3, str6, str7, j2);
        }

        @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY)
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Checkpoint copy(String id, int version, String type, String identifier, String appUserID, String appSessionID, long timestamp) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            return new Checkpoint(id, version, type, identifier, appUserID, appSessionID, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Checkpoint)) {
                return false;
            }
            Checkpoint checkpoint = (Checkpoint) other;
            return Intrinsics.areEqual(this.id, checkpoint.id) && this.version == checkpoint.version && Intrinsics.areEqual(this.type, checkpoint.type) && Intrinsics.areEqual(this.identifier, checkpoint.identifier) && Intrinsics.areEqual(this.appUserID, checkpoint.appUserID) && Intrinsics.areEqual(this.appSessionID, checkpoint.appSessionID) && this.timestamp == checkpoint.timestamp;
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.identifier.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31) + Long.hashCode(this.timestamp);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Checkpoint(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", identifier=" + this.identifier + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", timestamp=" + this.timestamp + ')';
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Checkpoint$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Checkpoint;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Checkpoint> serializer() {
                return BackendEvent$Checkpoint$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Checkpoint(int i, String str, int i2, String str2, String str3, @SerialName("app_user_id") String str4, @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY) String str5, long j, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (127 != (i & 127)) {
                PluginExceptionsKt.throwMissingFieldException(i, 127, BackendEvent$Checkpoint$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.identifier = str3;
            this.appUserID = str4;
            this.appSessionID = str5;
            this.timestamp = j;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Checkpoint self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.identifier);
            output.encodeStringElement(serialDesc, 4, self.appUserID);
            output.encodeStringElement(serialDesc, 5, self.appSessionID);
            output.encodeLongElement(serialDesc, 6, self.timestamp);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Checkpoint(String id, int i, String type, String identifier, String appUserID, String appSessionID, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            this.id = id;
            this.version = i;
            this.type = type;
            this.identifier = identifier;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.timestamp = j;
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0004=>?@Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003JY\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001J&\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;HÁ\u0001¢\u0006\u0002\b<R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006A"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "version", "type", "eventName", "timestampMs", "", "appUserID", WebViewMessageType.CONTEXT, "Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Context;", DiagnosticsEntry.PROPERTIES_KEY, "Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Context;Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Context;Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties;)V", "getAppUserID$annotations", "()V", "getAppUserID", "()Ljava/lang/String;", "getContext$annotations", "getContext", "()Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Context;", "getEventName$annotations", "getEventName", "getId", "getProperties", "()Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties;", "getTimestampMs$annotations", "getTimestampMs", "()J", "getType", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "Context", "Properties", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName(BackendEvent.WORKFLOW_EVENT_TYPE)
    public static final /* data */ class Workflows extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appUserID;
        private final Context context;
        private final String eventName;
        private final String id;
        private final Properties properties;
        private final long timestampMs;
        private final String type;
        private final int version;

        public static /* synthetic */ Workflows copy$default(Workflows workflows, String str, int i, String str2, String str3, long j, String str4, Context context, Properties properties, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = workflows.id;
            }
            if ((i2 & 2) != 0) {
                i = workflows.version;
            }
            if ((i2 & 4) != 0) {
                str2 = workflows.type;
            }
            if ((i2 & 8) != 0) {
                str3 = workflows.eventName;
            }
            if ((i2 & 16) != 0) {
                j = workflows.timestampMs;
            }
            if ((i2 & 32) != 0) {
                str4 = workflows.appUserID;
            }
            if ((i2 & 64) != 0) {
                context = workflows.context;
            }
            if ((i2 & 128) != 0) {
                properties = workflows.properties;
            }
            Properties properties2 = properties;
            String str5 = str4;
            long j2 = j;
            String str6 = str2;
            String str7 = str3;
            return workflows.copy(str, i, str6, str7, j2, str5, context, properties2);
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
        public static /* synthetic */ void getContext$annotations() {
        }

        @SerialName("event_name")
        public static /* synthetic */ void getEventName$annotations() {
        }

        @SerialName("timestamp_ms")
        public static /* synthetic */ void getTimestampMs$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getEventName() {
            return this.eventName;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getTimestampMs() {
            return this.timestampMs;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Properties getProperties() {
            return this.properties;
        }

        public final Workflows copy(String id, int version, String type, String eventName, long timestampMs, String appUserID, Context context, Properties properties) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(properties, "properties");
            return new Workflows(id, version, type, eventName, timestampMs, appUserID, context, properties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Workflows)) {
                return false;
            }
            Workflows workflows = (Workflows) other;
            return Intrinsics.areEqual(this.id, workflows.id) && this.version == workflows.version && Intrinsics.areEqual(this.type, workflows.type) && Intrinsics.areEqual(this.eventName, workflows.eventName) && this.timestampMs == workflows.timestampMs && Intrinsics.areEqual(this.appUserID, workflows.appUserID) && Intrinsics.areEqual(this.context, workflows.context) && Intrinsics.areEqual(this.properties, workflows.properties);
        }

        public int hashCode() {
            return (((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.eventName.hashCode()) * 31) + Long.hashCode(this.timestampMs)) * 31) + this.appUserID.hashCode()) * 31) + this.context.hashCode()) * 31) + this.properties.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Workflows(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", eventName=" + this.eventName + ", timestampMs=" + this.timestampMs + ", appUserID=" + this.appUserID + ", context=" + this.context + ", properties=" + this.properties + ')';
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Workflows> serializer() {
                return BackendEvent$Workflows$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Workflows(int i, String str, int i2, String str2, @SerialName("event_name") String str3, @SerialName("timestamp_ms") long j, @SerialName("app_user_id") String str4, @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS) Context context, Properties properties, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (191 != (i & 191)) {
                PluginExceptionsKt.throwMissingFieldException(i, 191, BackendEvent$Workflows$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.eventName = str3;
            this.timestampMs = j;
            this.appUserID = str4;
            if ((i & 64) == 0) {
                this.context = new Context((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            } else {
                this.context = context;
            }
            this.properties = properties;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Workflows self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.eventName);
            output.encodeLongElement(serialDesc, 4, self.timestampMs);
            output.encodeStringElement(serialDesc, 5, self.appUserID);
            output.encodeSerializableElement(serialDesc, 6, BackendEvent$Workflows$Context$$serializer.INSTANCE, self.context);
            output.encodeSerializableElement(serialDesc, 7, BackendEvent$Workflows$Properties$$serializer.INSTANCE, self.properties);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final long getTimestampMs() {
            return this.timestampMs;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public /* synthetic */ Workflows(String str, int i, String str2, String str3, long j, String str4, Context context, Properties properties, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            Context context2;
            if ((i2 & 64) != 0) {
                context2 = new Context((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            } else {
                context2 = context;
            }
            this(str, i, str2, str3, j, str4, context2, properties);
        }

        public final Context getContext() {
            return this.context;
        }

        public final Properties getProperties() {
            return this.properties;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Workflows(String id, int i, String type, String eventName, long j, String appUserID, Context context, Properties properties) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(properties, "properties");
            this.id = id;
            this.version = i;
            this.type = type;
            this.eventName = eventName;
            this.timestampMs = j;
            this.appUserID = appUserID;
            this.context = context;
            this.properties = properties;
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0012\u0010\r¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Context;", "", "seen1", "", DeviceDimensionProvider.KEY_PLATFORM, "", "sdkVersion", "locale", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getPlatform$annotations", "()V", "getPlatform", "getSdkVersion$annotations", "getSdkVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        @Serializable
        public static final /* data */ class Context {
            private static final Companion Companion = new Companion(null);

            @Deprecated
            public static final String WORKFLOW_CONTEXT_PLATFORM = "android";
            private final String locale;
            private final String platform;
            private final String sdkVersion;

            public Context() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Context copy$default(Context context, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = context.platform;
                }
                if ((i & 2) != 0) {
                    str2 = context.sdkVersion;
                }
                if ((i & 4) != 0) {
                    str3 = context.locale;
                }
                return context.copy(str, str2, str3);
            }

            @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
            public static /* synthetic */ void getPlatform$annotations() {
            }

            @SerialName("sdk_version")
            @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS)
            public static /* synthetic */ void getSdkVersion$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPlatform() {
                return this.platform;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getSdkVersion() {
                return this.sdkVersion;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getLocale() {
                return this.locale;
            }

            public final Context copy(String platform, String sdkVersion, String locale) {
                Intrinsics.checkNotNullParameter(platform, "platform");
                Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
                return new Context(platform, sdkVersion, locale);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Context)) {
                    return false;
                }
                Context context = (Context) other;
                return Intrinsics.areEqual(this.platform, context.platform) && Intrinsics.areEqual(this.sdkVersion, context.sdkVersion) && Intrinsics.areEqual(this.locale, context.locale);
            }

            public int hashCode() {
                int iHashCode = ((this.platform.hashCode() * 31) + this.sdkVersion.hashCode()) * 31;
                String str = this.locale;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "Context(platform=" + this.platform + ", sdkVersion=" + this.sdkVersion + ", locale=" + this.locale + ')';
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Context(int i, @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS) String str, @SerialName("sdk_version") @EncodeDefault(mode = EncodeDefault.Mode.ALWAYS) String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
                this.platform = (i & 1) == 0 ? WORKFLOW_CONTEXT_PLATFORM : str;
                if ((i & 2) == 0) {
                    this.sdkVersion = "10.20.0";
                } else {
                    this.sdkVersion = str2;
                }
                if ((i & 4) == 0) {
                    this.locale = null;
                } else {
                    this.locale = str3;
                }
            }

            public Context(String platform, String sdkVersion, String str) {
                Intrinsics.checkNotNullParameter(platform, "platform");
                Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
                this.platform = platform;
                this.sdkVersion = sdkVersion;
                this.locale = str;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Context self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.platform);
                output.encodeStringElement(serialDesc, 1, self.sdkVersion);
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.locale == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.locale);
            }

            public /* synthetic */ Context(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? WORKFLOW_CONTEXT_PLATFORM : str, (i & 2) != 0 ? "10.20.0" : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getPlatform() {
                return this.platform;
            }

            public final String getSdkVersion() {
                return this.sdkVersion;
            }

            public final String getLocale() {
                return this.locale;
            }

            /* JADX INFO: compiled from: BackendEvent.kt */
            @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Context$Companion;", "", "()V", "WORKFLOW_CONTEXT_PLATFORM", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Context;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Context> serializer() {
                    return BackendEvent$Workflows$Context$$serializer.INSTANCE;
                }
            }
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB\u009d\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013B\u0081\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008e\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J&\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CHÁ\u0001¢\u0006\u0002\bDR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u000b\u0010 R \u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b\r\u0010 R \u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b#\u0010\u0016\u001a\u0004\b\u0010\u0010 R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018¨\u0006G"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties;", "", "seen1", "", "workflowId", "", "stepId", "traceId", "fromStepId", "toStepId", "entryReason", "isFirstStep", "", "isLastStep", RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, "experimentVariant", "isLastVariantStep", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEntryReason$annotations", "()V", "getEntryReason", "()Ljava/lang/String;", "getExperimentId$annotations", "getExperimentId", "getExperimentVariant$annotations", "getExperimentVariant", "getFromStepId$annotations", "getFromStepId", "isFirstStep$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isLastStep$annotations", "isLastVariantStep$annotations", "getStepId$annotations", "getStepId", "getToStepId$annotations", "getToStepId", "getTraceId$annotations", "getTraceId", "getWorkflowId$annotations", "getWorkflowId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        @Serializable
        public static final /* data */ class Properties {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String entryReason;
            private final String experimentId;
            private final String experimentVariant;
            private final String fromStepId;
            private final Boolean isFirstStep;
            private final Boolean isLastStep;
            private final Boolean isLastVariantStep;
            private final String stepId;
            private final String toStepId;
            private final String traceId;
            private final String workflowId;

            public static /* synthetic */ Properties copy$default(Properties properties, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, String str8, Boolean bool3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = properties.workflowId;
                }
                if ((i & 2) != 0) {
                    str2 = properties.stepId;
                }
                if ((i & 4) != 0) {
                    str3 = properties.traceId;
                }
                if ((i & 8) != 0) {
                    str4 = properties.fromStepId;
                }
                if ((i & 16) != 0) {
                    str5 = properties.toStepId;
                }
                if ((i & 32) != 0) {
                    str6 = properties.entryReason;
                }
                if ((i & 64) != 0) {
                    bool = properties.isFirstStep;
                }
                if ((i & 128) != 0) {
                    bool2 = properties.isLastStep;
                }
                if ((i & 256) != 0) {
                    str7 = properties.experimentId;
                }
                if ((i & 512) != 0) {
                    str8 = properties.experimentVariant;
                }
                if ((i & 1024) != 0) {
                    bool3 = properties.isLastVariantStep;
                }
                String str9 = str8;
                Boolean bool4 = bool3;
                Boolean bool5 = bool2;
                String str10 = str7;
                String str11 = str6;
                Boolean bool6 = bool;
                String str12 = str5;
                String str13 = str3;
                return properties.copy(str, str2, str13, str4, str12, str11, bool6, bool5, str10, str9, bool4);
            }

            @SerialName("entry_reason")
            public static /* synthetic */ void getEntryReason$annotations() {
            }

            @SerialName("experiment_id")
            public static /* synthetic */ void getExperimentId$annotations() {
            }

            @SerialName("experiment_variant")
            public static /* synthetic */ void getExperimentVariant$annotations() {
            }

            @SerialName("from_step_id")
            public static /* synthetic */ void getFromStepId$annotations() {
            }

            @SerialName(Keys.STEP_ID)
            public static /* synthetic */ void getStepId$annotations() {
            }

            @SerialName("to_step_id")
            public static /* synthetic */ void getToStepId$annotations() {
            }

            @SerialName("trace_id")
            public static /* synthetic */ void getTraceId$annotations() {
            }

            @SerialName(Keys.WORKFLOW_ID)
            public static /* synthetic */ void getWorkflowId$annotations() {
            }

            @SerialName("is_first_step")
            public static /* synthetic */ void isFirstStep$annotations() {
            }

            @SerialName("is_last_step")
            public static /* synthetic */ void isLastStep$annotations() {
            }

            @SerialName("is_last_variant_step")
            public static /* synthetic */ void isLastVariantStep$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getWorkflowId() {
                return this.workflowId;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final String getExperimentVariant() {
                return this.experimentVariant;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final Boolean getIsLastVariantStep() {
                return this.isLastVariantStep;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getStepId() {
                return this.stepId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getTraceId() {
                return this.traceId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getFromStepId() {
                return this.fromStepId;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getToStepId() {
                return this.toStepId;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getEntryReason() {
                return this.entryReason;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Boolean getIsFirstStep() {
                return this.isFirstStep;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final Boolean getIsLastStep() {
                return this.isLastStep;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getExperimentId() {
                return this.experimentId;
            }

            public final Properties copy(String workflowId, String stepId, String traceId, String fromStepId, String toStepId, String entryReason, Boolean isFirstStep, Boolean isLastStep, String experimentId, String experimentVariant, Boolean isLastVariantStep) {
                Intrinsics.checkNotNullParameter(workflowId, "workflowId");
                Intrinsics.checkNotNullParameter(stepId, "stepId");
                return new Properties(workflowId, stepId, traceId, fromStepId, toStepId, entryReason, isFirstStep, isLastStep, experimentId, experimentVariant, isLastVariantStep);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Properties)) {
                    return false;
                }
                Properties properties = (Properties) other;
                return Intrinsics.areEqual(this.workflowId, properties.workflowId) && Intrinsics.areEqual(this.stepId, properties.stepId) && Intrinsics.areEqual(this.traceId, properties.traceId) && Intrinsics.areEqual(this.fromStepId, properties.fromStepId) && Intrinsics.areEqual(this.toStepId, properties.toStepId) && Intrinsics.areEqual(this.entryReason, properties.entryReason) && Intrinsics.areEqual(this.isFirstStep, properties.isFirstStep) && Intrinsics.areEqual(this.isLastStep, properties.isLastStep) && Intrinsics.areEqual(this.experimentId, properties.experimentId) && Intrinsics.areEqual(this.experimentVariant, properties.experimentVariant) && Intrinsics.areEqual(this.isLastVariantStep, properties.isLastVariantStep);
            }

            public int hashCode() {
                int iHashCode = ((this.workflowId.hashCode() * 31) + this.stepId.hashCode()) * 31;
                String str = this.traceId;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.fromStepId;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.toStepId;
                int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.entryReason;
                int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Boolean bool = this.isFirstStep;
                int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
                Boolean bool2 = this.isLastStep;
                int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                String str5 = this.experimentId;
                int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.experimentVariant;
                int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
                Boolean bool3 = this.isLastVariantStep;
                return iHashCode9 + (bool3 != null ? bool3.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Properties(workflowId=");
                sb.append(this.workflowId).append(", stepId=").append(this.stepId).append(", traceId=").append(this.traceId).append(", fromStepId=").append(this.fromStepId).append(", toStepId=").append(this.toStepId).append(", entryReason=").append(this.entryReason).append(", isFirstStep=").append(this.isFirstStep).append(", isLastStep=").append(this.isLastStep).append(", experimentId=").append(this.experimentId).append(", experimentVariant=").append(this.experimentVariant).append(", isLastVariantStep=").append(this.isLastVariantStep).append(')');
                return sb.toString();
            }

            /* JADX INFO: compiled from: BackendEvent.kt */
            @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Workflows$Properties;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Properties> serializer() {
                    return BackendEvent$Workflows$Properties$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Properties(int i, @SerialName(Keys.WORKFLOW_ID) String str, @SerialName(Keys.STEP_ID) String str2, @SerialName("trace_id") String str3, @SerialName("from_step_id") String str4, @SerialName("to_step_id") String str5, @SerialName("entry_reason") String str6, @SerialName("is_first_step") Boolean bool, @SerialName("is_last_step") Boolean bool2, @SerialName("experiment_id") String str7, @SerialName("experiment_variant") String str8, @SerialName("is_last_variant_step") Boolean bool3, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, BackendEvent$Workflows$Properties$$serializer.INSTANCE.getDescriptor());
                }
                this.workflowId = str;
                this.stepId = str2;
                if ((i & 4) == 0) {
                    this.traceId = null;
                } else {
                    this.traceId = str3;
                }
                if ((i & 8) == 0) {
                    this.fromStepId = null;
                } else {
                    this.fromStepId = str4;
                }
                if ((i & 16) == 0) {
                    this.toStepId = null;
                } else {
                    this.toStepId = str5;
                }
                if ((i & 32) == 0) {
                    this.entryReason = null;
                } else {
                    this.entryReason = str6;
                }
                if ((i & 64) == 0) {
                    this.isFirstStep = null;
                } else {
                    this.isFirstStep = bool;
                }
                if ((i & 128) == 0) {
                    this.isLastStep = null;
                } else {
                    this.isLastStep = bool2;
                }
                if ((i & 256) == 0) {
                    this.experimentId = null;
                } else {
                    this.experimentId = str7;
                }
                if ((i & 512) == 0) {
                    this.experimentVariant = null;
                } else {
                    this.experimentVariant = str8;
                }
                if ((i & 1024) == 0) {
                    this.isLastVariantStep = null;
                } else {
                    this.isLastVariantStep = bool3;
                }
            }

            public Properties(String workflowId, String stepId, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, String str5, String str6, Boolean bool3) {
                Intrinsics.checkNotNullParameter(workflowId, "workflowId");
                Intrinsics.checkNotNullParameter(stepId, "stepId");
                this.workflowId = workflowId;
                this.stepId = stepId;
                this.traceId = str;
                this.fromStepId = str2;
                this.toStepId = str3;
                this.entryReason = str4;
                this.isFirstStep = bool;
                this.isLastStep = bool2;
                this.experimentId = str5;
                this.experimentVariant = str6;
                this.isLastVariantStep = bool3;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Properties self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.workflowId);
                output.encodeStringElement(serialDesc, 1, self.stepId);
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.traceId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.traceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fromStepId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.fromStepId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.toStepId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.toStepId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.entryReason != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.entryReason);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.isFirstStep != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.isFirstStep);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.isLastStep != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.isLastStep);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.experimentId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.experimentId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.experimentVariant != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.experimentVariant);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 10) && self.isLastVariantStep == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 10, BooleanSerializer.INSTANCE, self.isLastVariantStep);
            }

            public /* synthetic */ Properties(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, String str8, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : bool2, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : bool3);
            }

            public final String getWorkflowId() {
                return this.workflowId;
            }

            public final String getStepId() {
                return this.stepId;
            }

            public final String getTraceId() {
                return this.traceId;
            }

            public final String getFromStepId() {
                return this.fromStepId;
            }

            public final String getToStepId() {
                return this.toStepId;
            }

            public final String getEntryReason() {
                return this.entryReason;
            }

            public final Boolean isFirstStep() {
                return this.isFirstStep;
            }

            public final Boolean isLastStep() {
                return this.isLastStep;
            }

            public final String getExperimentId() {
                return this.experimentId;
            }

            public final String getExperimentVariant() {
                return this.experimentVariant;
            }

            public final Boolean isLastVariantStep() {
                return this.isLastVariantStep;
            }
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006*"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;", "", "seen1", "", "placementIdentifier", "", "targetingRevision", "targetingRuleId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getPlacementIdentifier$annotations", "()V", "getPlacementIdentifier", "()Ljava/lang/String;", "getTargetingRevision$annotations", "getTargetingRevision", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTargetingRuleId$annotations", "getTargetingRuleId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    public static final /* data */ class CustomPaywallPresentedOfferingContextData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String placementIdentifier;
        private final Integer targetingRevision;
        private final String targetingRuleId;

        public CustomPaywallPresentedOfferingContextData() {
            this((String) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CustomPaywallPresentedOfferingContextData copy$default(CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData, String str, Integer num, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customPaywallPresentedOfferingContextData.placementIdentifier;
            }
            if ((i & 2) != 0) {
                num = customPaywallPresentedOfferingContextData.targetingRevision;
            }
            if ((i & 4) != 0) {
                str2 = customPaywallPresentedOfferingContextData.targetingRuleId;
            }
            return customPaywallPresentedOfferingContextData.copy(str, num, str2);
        }

        @SerialName("placement_identifier")
        public static /* synthetic */ void getPlacementIdentifier$annotations() {
        }

        @SerialName("targeting_revision")
        public static /* synthetic */ void getTargetingRevision$annotations() {
        }

        @SerialName("targeting_rule_id")
        public static /* synthetic */ void getTargetingRuleId$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPlacementIdentifier() {
            return this.placementIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTargetingRevision() {
            return this.targetingRevision;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTargetingRuleId() {
            return this.targetingRuleId;
        }

        public final CustomPaywallPresentedOfferingContextData copy(String placementIdentifier, Integer targetingRevision, String targetingRuleId) {
            return new CustomPaywallPresentedOfferingContextData(placementIdentifier, targetingRevision, targetingRuleId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomPaywallPresentedOfferingContextData)) {
                return false;
            }
            CustomPaywallPresentedOfferingContextData customPaywallPresentedOfferingContextData = (CustomPaywallPresentedOfferingContextData) other;
            return Intrinsics.areEqual(this.placementIdentifier, customPaywallPresentedOfferingContextData.placementIdentifier) && Intrinsics.areEqual(this.targetingRevision, customPaywallPresentedOfferingContextData.targetingRevision) && Intrinsics.areEqual(this.targetingRuleId, customPaywallPresentedOfferingContextData.targetingRuleId);
        }

        public int hashCode() {
            String str = this.placementIdentifier;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.targetingRevision;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.targetingRuleId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CustomPaywallPresentedOfferingContextData(placementIdentifier=" + this.placementIdentifier + ", targetingRevision=" + this.targetingRevision + ", targetingRuleId=" + this.targetingRuleId + ')';
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CustomPaywallPresentedOfferingContextData(int i, @SerialName("placement_identifier") String str, @SerialName("targeting_revision") Integer num, @SerialName("targeting_rule_id") String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.placementIdentifier = null;
            } else {
                this.placementIdentifier = str;
            }
            if ((i & 2) == 0) {
                this.targetingRevision = null;
            } else {
                this.targetingRevision = num;
            }
            if ((i & 4) == 0) {
                this.targetingRuleId = null;
            } else {
                this.targetingRuleId = str2;
            }
        }

        public CustomPaywallPresentedOfferingContextData(String str, Integer num, String str2) {
            this.placementIdentifier = str;
            this.targetingRevision = num;
            this.targetingRuleId = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(CustomPaywallPresentedOfferingContextData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.placementIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.placementIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.targetingRevision != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.targetingRevision);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.targetingRuleId == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.targetingRuleId);
        }

        public /* synthetic */ CustomPaywallPresentedOfferingContextData(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
        }

        public final String getPlacementIdentifier() {
            return this.placementIdentifier;
        }

        public final Integer getTargetingRevision() {
            return this.targetingRevision;
        }

        public final String getTargetingRuleId() {
            return this.targetingRuleId;
        }

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fHÆ\u0001¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData$Companion;", "", "()V", TypedValues.TransitionType.S_FROM, "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;", "placementIdentifier", "", "targetingRevision", "", "targetingRuleId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywallPresentedOfferingContextData;", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CustomPaywallPresentedOfferingContextData> serializer() {
                return C7174x93065cce.INSTANCE;
            }

            public final CustomPaywallPresentedOfferingContextData from(String placementIdentifier, Integer targetingRevision, String targetingRuleId) {
                if (placementIdentifier == null && targetingRevision == null && targetingRuleId == null) {
                    return null;
                }
                return new CustomPaywallPresentedOfferingContextData(placementIdentifier, targetingRevision, targetingRuleId);
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.BackendEvent$Ad */
    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 {2\u00020\u0001:\u0002z{B\u009d\u0002\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 Bõ\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010!J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010]\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010HJ\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\tHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\u0092\u0002\u0010k\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010lJ\u0013\u0010m\u001a\u00020\u00182\b\u0010n\u001a\u0004\u0018\u00010oHÖ\u0003J\t\u0010p\u001a\u00020\u0003HÖ\u0001J\t\u0010q\u001a\u00020\u0005HÖ\u0001J&\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u00002\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xHÁ\u0001¢\u0006\u0002\byR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u001c\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010#\u001a\u0004\b+\u0010%R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010#\u001a\u0004\b-\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010#\u001a\u0004\b1\u0010%R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00105\u0012\u0004\b2\u0010#\u001a\u0004\b3\u00104R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010#\u001a\u0004\b7\u0010%R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010#\u001a\u0004\b9\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R \u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010?\u0012\u0004\b<\u0010#\u001a\u0004\b=\u0010>R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010#\u001a\u0004\bA\u0010%R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010#\u001a\u0004\bC\u0010%R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010#\u001a\u0004\bE\u0010%R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010I\u0012\u0004\bF\u0010#\u001a\u0004\bG\u0010HR \u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00105\u0012\u0004\bJ\u0010#\u001a\u0004\bK\u00104R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010#\u001a\u0004\bM\u0010%R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010#\u001a\u0004\bO\u0010PR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010%R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006|"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "version", "type", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "adFormat", "placement", "adUnitId", "impressionId", "appUserID", "appSessionID", "captureMethod", "revenueMicros", "currency", "precision", "mediatorErrorCode", "rewardVerificationEnabled", "", "rewardType", "rewardVirtualCurrencyCode", "rewardVirtualCurrencyAmount", "rewardEntitlementId", "rewardFailureReason", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAdFormat$annotations", "()V", "getAdFormat", "()Ljava/lang/String;", "getAdUnitId$annotations", "getAdUnitId", "getAppSessionID$annotations", "getAppSessionID", "getAppUserID$annotations", "getAppUserID", "getCaptureMethod$annotations", "getCaptureMethod", "getCurrency", "getId", "getImpressionId$annotations", "getImpressionId", "getMediatorErrorCode$annotations", "getMediatorErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMediatorName$annotations", "getMediatorName", "getNetworkName$annotations", "getNetworkName", "getPlacement", "getPrecision", "getRevenueMicros$annotations", "getRevenueMicros", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRewardEntitlementId$annotations", "getRewardEntitlementId", "getRewardFailureReason$annotations", "getRewardFailureReason", "getRewardType$annotations", "getRewardType", "getRewardVerificationEnabled$annotations", "getRewardVerificationEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRewardVirtualCurrencyAmount$annotations", "getRewardVirtualCurrencyAmount", "getRewardVirtualCurrencyCode$annotations", "getRewardVirtualCurrencyCode", "getTimestamp$annotations", "getTimestamp", "()J", "getType", "getVersion", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("ad")
    public static final /* data */ class C7172Ad extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String adFormat;
        private final String adUnitId;
        private final String appSessionID;
        private final String appUserID;
        private final String captureMethod;
        private final String currency;
        private final String id;
        private final String impressionId;
        private final Integer mediatorErrorCode;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final String precision;
        private final Long revenueMicros;
        private final String rewardEntitlementId;
        private final String rewardFailureReason;
        private final String rewardType;
        private final Boolean rewardVerificationEnabled;
        private final Integer rewardVirtualCurrencyAmount;
        private final String rewardVirtualCurrencyCode;
        private final long timestamp;
        private final String type;
        private final int version;

        public static /* synthetic */ C7172Ad copy$default(C7172Ad c7172Ad, String str, int i, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, String str12, String str13, Integer num, Boolean bool, String str14, String str15, Integer num2, String str16, String str17, int i2, Object obj) {
            String str18;
            String str19;
            String str20 = (i2 & 1) != 0 ? c7172Ad.id : str;
            int i3 = (i2 & 2) != 0 ? c7172Ad.version : i;
            String str21 = (i2 & 4) != 0 ? c7172Ad.type : str2;
            long j2 = (i2 & 8) != 0 ? c7172Ad.timestamp : j;
            String str22 = (i2 & 16) != 0 ? c7172Ad.networkName : str3;
            String str23 = (i2 & 32) != 0 ? c7172Ad.mediatorName : str4;
            String str24 = (i2 & 64) != 0 ? c7172Ad.adFormat : str5;
            String str25 = (i2 & 128) != 0 ? c7172Ad.placement : str6;
            String str26 = (i2 & 256) != 0 ? c7172Ad.adUnitId : str7;
            String str27 = (i2 & 512) != 0 ? c7172Ad.impressionId : str8;
            String str28 = (i2 & 1024) != 0 ? c7172Ad.appUserID : str9;
            String str29 = (i2 & 2048) != 0 ? c7172Ad.appSessionID : str10;
            String str30 = (i2 & 4096) != 0 ? c7172Ad.captureMethod : str11;
            String str31 = str20;
            Long l2 = (i2 & 8192) != 0 ? c7172Ad.revenueMicros : l;
            String str32 = (i2 & 16384) != 0 ? c7172Ad.currency : str12;
            String str33 = (i2 & 32768) != 0 ? c7172Ad.precision : str13;
            Integer num3 = (i2 & 65536) != 0 ? c7172Ad.mediatorErrorCode : num;
            Boolean bool2 = (i2 & 131072) != 0 ? c7172Ad.rewardVerificationEnabled : bool;
            String str34 = (i2 & 262144) != 0 ? c7172Ad.rewardType : str14;
            String str35 = (i2 & 524288) != 0 ? c7172Ad.rewardVirtualCurrencyCode : str15;
            Integer num4 = (i2 & 1048576) != 0 ? c7172Ad.rewardVirtualCurrencyAmount : num2;
            String str36 = (i2 & 2097152) != 0 ? c7172Ad.rewardEntitlementId : str16;
            if ((i2 & 4194304) != 0) {
                str19 = str36;
                str18 = c7172Ad.rewardFailureReason;
            } else {
                str18 = str17;
                str19 = str36;
            }
            return c7172Ad.copy(str31, i3, str21, j2, str22, str23, str24, str25, str26, str27, str28, str29, str30, l2, str32, str33, num3, bool2, str34, str35, num4, str19, str18);
        }

        @SerialName(FirebaseAnalytics.Param.AD_FORMAT)
        public static /* synthetic */ void getAdFormat$annotations() {
        }

        @SerialName("ad_unit_id")
        public static /* synthetic */ void getAdUnitId$annotations() {
        }

        @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY)
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName("capture_method")
        public static /* synthetic */ void getCaptureMethod$annotations() {
        }

        @SerialName("impression_id")
        public static /* synthetic */ void getImpressionId$annotations() {
        }

        @SerialName("mediator_error_code")
        public static /* synthetic */ void getMediatorErrorCode$annotations() {
        }

        @SerialName("mediator_name")
        public static /* synthetic */ void getMediatorName$annotations() {
        }

        @SerialName("network_name")
        public static /* synthetic */ void getNetworkName$annotations() {
        }

        @SerialName("revenue_micros")
        public static /* synthetic */ void getRevenueMicros$annotations() {
        }

        @SerialName("reward_entitlement_id")
        public static /* synthetic */ void getRewardEntitlementId$annotations() {
        }

        @SerialName("reward_failure_reason")
        public static /* synthetic */ void getRewardFailureReason$annotations() {
        }

        @SerialName("reward_type")
        public static /* synthetic */ void getRewardType$annotations() {
        }

        @SerialName("reward_verification_enabled")
        public static /* synthetic */ void getRewardVerificationEnabled$annotations() {
        }

        @SerialName("reward_virtual_currency_amount")
        public static /* synthetic */ void getRewardVirtualCurrencyAmount$annotations() {
        }

        @SerialName("reward_virtual_currency_code")
        public static /* synthetic */ void getRewardVirtualCurrencyCode$annotations() {
        }

        @SerialName("timestamp_ms")
        public static /* synthetic */ void getTimestamp$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getImpressionId() {
            return this.impressionId;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getCaptureMethod() {
            return this.captureMethod;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Long getRevenueMicros() {
            return this.revenueMicros;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getPrecision() {
            return this.precision;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Boolean getRewardVerificationEnabled() {
            return this.rewardVerificationEnabled;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getRewardType() {
            return this.rewardType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getRewardVirtualCurrencyCode() {
            return this.rewardVirtualCurrencyCode;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Integer getRewardVirtualCurrencyAmount() {
            return this.rewardVirtualCurrencyAmount;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getRewardEntitlementId() {
            return this.rewardEntitlementId;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getRewardFailureReason() {
            return this.rewardFailureReason;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNetworkName() {
            return this.networkName;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getMediatorName() {
            return this.mediatorName;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getAdFormat() {
            return this.adFormat;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getPlacement() {
            return this.placement;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final C7172Ad copy(String id, int version, String type, long timestamp, String networkName, String mediatorName, String adFormat, String placement, String adUnitId, String impressionId, String appUserID, String appSessionID, String captureMethod, Long revenueMicros, String currency, String precision, Integer mediatorErrorCode, Boolean rewardVerificationEnabled, String rewardType, String rewardVirtualCurrencyCode, Integer rewardVirtualCurrencyAmount, String rewardEntitlementId, String rewardFailureReason) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            return new C7172Ad(id, version, type, timestamp, networkName, mediatorName, adFormat, placement, adUnitId, impressionId, appUserID, appSessionID, captureMethod, revenueMicros, currency, precision, mediatorErrorCode, rewardVerificationEnabled, rewardType, rewardVirtualCurrencyCode, rewardVirtualCurrencyAmount, rewardEntitlementId, rewardFailureReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof C7172Ad)) {
                return false;
            }
            C7172Ad c7172Ad = (C7172Ad) other;
            return Intrinsics.areEqual(this.id, c7172Ad.id) && this.version == c7172Ad.version && Intrinsics.areEqual(this.type, c7172Ad.type) && this.timestamp == c7172Ad.timestamp && Intrinsics.areEqual(this.networkName, c7172Ad.networkName) && Intrinsics.areEqual(this.mediatorName, c7172Ad.mediatorName) && Intrinsics.areEqual(this.adFormat, c7172Ad.adFormat) && Intrinsics.areEqual(this.placement, c7172Ad.placement) && Intrinsics.areEqual(this.adUnitId, c7172Ad.adUnitId) && Intrinsics.areEqual(this.impressionId, c7172Ad.impressionId) && Intrinsics.areEqual(this.appUserID, c7172Ad.appUserID) && Intrinsics.areEqual(this.appSessionID, c7172Ad.appSessionID) && Intrinsics.areEqual(this.captureMethod, c7172Ad.captureMethod) && Intrinsics.areEqual(this.revenueMicros, c7172Ad.revenueMicros) && Intrinsics.areEqual(this.currency, c7172Ad.currency) && Intrinsics.areEqual(this.precision, c7172Ad.precision) && Intrinsics.areEqual(this.mediatorErrorCode, c7172Ad.mediatorErrorCode) && Intrinsics.areEqual(this.rewardVerificationEnabled, c7172Ad.rewardVerificationEnabled) && Intrinsics.areEqual(this.rewardType, c7172Ad.rewardType) && Intrinsics.areEqual(this.rewardVirtualCurrencyCode, c7172Ad.rewardVirtualCurrencyCode) && Intrinsics.areEqual(this.rewardVirtualCurrencyAmount, c7172Ad.rewardVirtualCurrencyAmount) && Intrinsics.areEqual(this.rewardEntitlementId, c7172Ad.rewardEntitlementId) && Intrinsics.areEqual(this.rewardFailureReason, c7172Ad.rewardFailureReason);
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str = this.networkName;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.mediatorName.hashCode()) * 31;
            String str2 = this.adFormat;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.placement;
            int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.adUnitId.hashCode()) * 31;
            String str4 = this.impressionId;
            int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31;
            String str5 = this.captureMethod;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Long l = this.revenueMicros;
            int iHashCode7 = (iHashCode6 + (l == null ? 0 : l.hashCode())) * 31;
            String str6 = this.currency;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.precision;
            int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Integer num = this.mediatorErrorCode;
            int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
            Boolean bool = this.rewardVerificationEnabled;
            int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str8 = this.rewardType;
            int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.rewardVirtualCurrencyCode;
            int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Integer num2 = this.rewardVirtualCurrencyAmount;
            int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str10 = this.rewardEntitlementId;
            int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.rewardFailureReason;
            return iHashCode15 + (str11 != null ? str11.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            StringBuilder sb = new StringBuilder("Ad(id=");
            sb.append(this.id).append(", version=").append(this.version).append(", type=").append(this.type).append(", timestamp=").append(this.timestamp).append(", networkName=").append(this.networkName).append(", mediatorName=").append(this.mediatorName).append(", adFormat=").append(this.adFormat).append(", placement=").append(this.placement).append(", adUnitId=").append(this.adUnitId).append(", impressionId=").append(this.impressionId).append(", appUserID=").append(this.appUserID).append(", appSessionID=");
            sb.append(this.appSessionID).append(", captureMethod=").append(this.captureMethod).append(", revenueMicros=").append(this.revenueMicros).append(", currency=").append(this.currency).append(", precision=").append(this.precision).append(", mediatorErrorCode=").append(this.mediatorErrorCode).append(", rewardVerificationEnabled=").append(this.rewardVerificationEnabled).append(", rewardType=").append(this.rewardType).append(", rewardVirtualCurrencyCode=").append(this.rewardVirtualCurrencyCode).append(", rewardVirtualCurrencyAmount=").append(this.rewardVirtualCurrencyAmount).append(", rewardEntitlementId=").append(this.rewardEntitlementId).append(", rewardFailureReason=").append(this.rewardFailureReason);
            sb.append(')');
            return sb.toString();
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.BackendEvent$Ad$Companion, reason: from kotlin metadata */
        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Ad$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<C7172Ad> serializer() {
                return BackendEvent$Ad$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ C7172Ad(int i, String str, int i2, String str2, @SerialName("timestamp_ms") long j, @SerialName("network_name") String str3, @SerialName("mediator_name") String str4, @SerialName(FirebaseAnalytics.Param.AD_FORMAT) String str5, String str6, @SerialName("ad_unit_id") String str7, @SerialName("impression_id") String str8, @SerialName("app_user_id") String str9, @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY) String str10, @SerialName("capture_method") String str11, @SerialName("revenue_micros") Long l, String str12, String str13, @SerialName("mediator_error_code") Integer num, @SerialName("reward_verification_enabled") Boolean bool, @SerialName("reward_type") String str14, @SerialName("reward_virtual_currency_code") String str15, @SerialName("reward_virtual_currency_amount") Integer num2, @SerialName("reward_entitlement_id") String str16, @SerialName("reward_failure_reason") String str17, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4015 != (i & 4015)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4015, BackendEvent$Ad$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.timestamp = j;
            if ((i & 16) == 0) {
                this.networkName = null;
            } else {
                this.networkName = str3;
            }
            this.mediatorName = str4;
            if ((i & 64) == 0) {
                this.adFormat = null;
            } else {
                this.adFormat = str5;
            }
            this.placement = str6;
            this.adUnitId = str7;
            this.impressionId = str8;
            this.appUserID = str9;
            this.appSessionID = str10;
            if ((i & 4096) == 0) {
                this.captureMethod = null;
            } else {
                this.captureMethod = str11;
            }
            if ((i & 8192) == 0) {
                this.revenueMicros = null;
            } else {
                this.revenueMicros = l;
            }
            if ((i & 16384) == 0) {
                this.currency = null;
            } else {
                this.currency = str12;
            }
            if ((32768 & i) == 0) {
                this.precision = null;
            } else {
                this.precision = str13;
            }
            if ((65536 & i) == 0) {
                this.mediatorErrorCode = null;
            } else {
                this.mediatorErrorCode = num;
            }
            if ((131072 & i) == 0) {
                this.rewardVerificationEnabled = null;
            } else {
                this.rewardVerificationEnabled = bool;
            }
            if ((262144 & i) == 0) {
                this.rewardType = null;
            } else {
                this.rewardType = str14;
            }
            if ((524288 & i) == 0) {
                this.rewardVirtualCurrencyCode = null;
            } else {
                this.rewardVirtualCurrencyCode = str15;
            }
            if ((1048576 & i) == 0) {
                this.rewardVirtualCurrencyAmount = null;
            } else {
                this.rewardVirtualCurrencyAmount = num2;
            }
            if ((2097152 & i) == 0) {
                this.rewardEntitlementId = null;
            } else {
                this.rewardEntitlementId = str16;
            }
            if ((i & 4194304) == 0) {
                this.rewardFailureReason = null;
            } else {
                this.rewardFailureReason = str17;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(C7172Ad self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeLongElement(serialDesc, 3, self.timestamp);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.networkName != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.networkName);
            }
            output.encodeStringElement(serialDesc, 5, self.mediatorName);
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.adFormat != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.adFormat);
            }
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.placement);
            output.encodeStringElement(serialDesc, 8, self.adUnitId);
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.impressionId);
            output.encodeStringElement(serialDesc, 10, self.appUserID);
            output.encodeStringElement(serialDesc, 11, self.appSessionID);
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.captureMethod != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.captureMethod);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.revenueMicros != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, LongSerializer.INSTANCE, self.revenueMicros);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.currency != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.currency);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.precision != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.precision);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.mediatorErrorCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.mediatorErrorCode);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.rewardVerificationEnabled != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, BooleanSerializer.INSTANCE, self.rewardVerificationEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.rewardType != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.rewardType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.rewardVirtualCurrencyCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.rewardVirtualCurrencyCode);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.rewardVirtualCurrencyAmount != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, IntSerializer.INSTANCE, self.rewardVirtualCurrencyAmount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.rewardEntitlementId != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.rewardEntitlementId);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 22) && self.rewardFailureReason == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.rewardFailureReason);
        }

        public /* synthetic */ C7172Ad(String str, int i, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, String str12, String str13, Integer num, Boolean bool, String str14, String str15, Integer num2, String str16, String str17, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, j, (i2 & 16) != 0 ? null : str3, str4, (i2 & 64) != 0 ? null : str5, str6, str7, str8, str9, str10, (i2 & 4096) != 0 ? null : str11, (i2 & 8192) != 0 ? null : l, (i2 & 16384) != 0 ? null : str12, (32768 & i2) != 0 ? null : str13, (65536 & i2) != 0 ? null : num, (131072 & i2) != 0 ? null : bool, (262144 & i2) != 0 ? null : str14, (524288 & i2) != 0 ? null : str15, (1048576 & i2) != 0 ? null : num2, (2097152 & i2) != 0 ? null : str16, (i2 & 4194304) != 0 ? null : str17);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getNetworkName() {
            return this.networkName;
        }

        public final String getMediatorName() {
            return this.mediatorName;
        }

        public final String getAdFormat() {
            return this.adFormat;
        }

        public final String getPlacement() {
            return this.placement;
        }

        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final String getImpressionId() {
            return this.impressionId;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final String getCaptureMethod() {
            return this.captureMethod;
        }

        public final Long getRevenueMicros() {
            return this.revenueMicros;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getPrecision() {
            return this.precision;
        }

        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        public final Boolean getRewardVerificationEnabled() {
            return this.rewardVerificationEnabled;
        }

        public final String getRewardType() {
            return this.rewardType;
        }

        public final String getRewardVirtualCurrencyCode() {
            return this.rewardVirtualCurrencyCode;
        }

        public final Integer getRewardVirtualCurrencyAmount() {
            return this.rewardVirtualCurrencyAmount;
        }

        public final String getRewardEntitlementId() {
            return this.rewardEntitlementId;
        }

        public final String getRewardFailureReason() {
            return this.rewardFailureReason;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7172Ad(String id, int i, String type, long j, String str, String mediatorName, String str2, String str3, String adUnitId, String str4, String appUserID, String appSessionID, String str5, Long l, String str6, String str7, Integer num, Boolean bool, String str8, String str9, Integer num2, String str10, String str11) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            this.id = id;
            this.version = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = str2;
            this.placement = str3;
            this.adUnitId = adUnitId;
            this.impressionId = str4;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.captureMethod = str5;
            this.revenueMicros = l;
            this.currency = str6;
            this.precision = str7;
            this.mediatorErrorCode = num;
            this.rewardVerificationEnabled = bool;
            this.rewardType = str8;
            this.rewardVirtualCurrencyCode = str9;
            this.rewardVirtualCurrencyAmount = num2;
            this.rewardEntitlementId = str10;
            this.rewardFailureReason = str11;
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Companion;", "", "()V", "AD_EVENT_SCHEMA_VERSION", "", "CHECKPOINT_EVENT_SCHEMA_VERSION", "CHECKPOINT_EVENT_TYPE", "", "CUSTOMER_CENTER_EVENT_SCHEMA_VERSION", "CUSTOM_PAYWALL_EVENT_SCHEMA_VERSION", "PAYWALL_EVENT_SCHEMA_VERSION", "WORKFLOW_EVENT_SCHEMA_VERSION", "WORKFLOW_EVENT_TYPE", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) BackendEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<BackendEvent> serializer() {
            return get$cachedSerializer();
        }
    }
}
