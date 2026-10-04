package com.revenuecat.purchases.common.workflows;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.paywalls.components.common.ExitOffer;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.utils.serializers.JsonObjectToMapSerializer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: WorkflowModels.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@B\u009a\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\u001b\b\u0001\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000e\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bx\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\t\u0012\u0019\b\u0002\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000e0\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\tHÆ\u0003J\u001a\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000e0\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0086\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\t2\u0019\b\u0002\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000e0\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÁ\u0001¢\u0006\u0002\b>R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001dR-\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000e0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001dR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$¨\u0006A"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "", "seen1", "", "id", "", "displayName", "initialStepId", "steps", "", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "screens", "Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", TtmlNode.TAG_METADATA, "Lkotlinx/serialization/Contextual;", "hash", "singleStepFallbackId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "dismissExitOffer", "Lcom/revenuecat/purchases/common/workflows/WorkflowExitOffer;", "getDismissExitOffer$annotations", "()V", "getDismissExitOffer", "()Lcom/revenuecat/purchases/common/workflows/WorkflowExitOffer;", "getDisplayName$annotations", "getDisplayName", "()Ljava/lang/String;", "getHash", "getId", "getInitialStepId$annotations", "getInitialStepId", "getMetadata$annotations", "getMetadata", "()Ljava/util/Map;", "getScreens", "getSingleStepFallbackId$annotations", "getSingleStepFallbackId", "getSteps", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class PublishedWorkflow {
    private final String displayName;
    private final String hash;
    private final String id;
    private final String initialStepId;
    private final Map<String, Object> metadata;
    private final Map<String, WorkflowScreen> screens;
    private final String singleStepFallbackId;
    private final Map<String, WorkflowStep> steps;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, WorkflowStep$$serializer.INSTANCE), new LinkedHashMapSerializer(StringSerializer.INSTANCE, WorkflowScreen$$serializer.INSTANCE), null, null, null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PublishedWorkflow copy$default(PublishedWorkflow publishedWorkflow, String str, String str2, String str3, Map map, Map map2, Map map3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publishedWorkflow.id;
        }
        if ((i & 2) != 0) {
            str2 = publishedWorkflow.displayName;
        }
        if ((i & 4) != 0) {
            str3 = publishedWorkflow.initialStepId;
        }
        if ((i & 8) != 0) {
            map = publishedWorkflow.steps;
        }
        if ((i & 16) != 0) {
            map2 = publishedWorkflow.screens;
        }
        if ((i & 32) != 0) {
            map3 = publishedWorkflow.metadata;
        }
        if ((i & 64) != 0) {
            str4 = publishedWorkflow.hash;
        }
        if ((i & 128) != 0) {
            str5 = publishedWorkflow.singleStepFallbackId;
        }
        String str6 = str4;
        String str7 = str5;
        Map map4 = map2;
        Map map5 = map3;
        return publishedWorkflow.copy(str, str2, str3, map, map4, map5, str6, str7);
    }

    public static /* synthetic */ void getDismissExitOffer$annotations() {
    }

    @SerialName(Keys.DISPLAY_NAME)
    public static /* synthetic */ void getDisplayName$annotations() {
    }

    @SerialName("initial_step_id")
    public static /* synthetic */ void getInitialStepId$annotations() {
    }

    @Serializable(with = JsonObjectToMapSerializer.class)
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @SerialName("single_step_fallback_id")
    public static /* synthetic */ void getSingleStepFallbackId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInitialStepId() {
        return this.initialStepId;
    }

    public final Map<String, WorkflowStep> component4() {
        return this.steps;
    }

    public final Map<String, WorkflowScreen> component5() {
        return this.screens;
    }

    public final Map<String, Object> component6() {
        return this.metadata;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSingleStepFallbackId() {
        return this.singleStepFallbackId;
    }

    public final PublishedWorkflow copy(String id, String displayName, String initialStepId, Map<String, WorkflowStep> steps, Map<String, WorkflowScreen> screens, Map<String, ? extends Object> metadata, String hash, String singleStepFallbackId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(initialStepId, "initialStepId");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new PublishedWorkflow(id, displayName, initialStepId, steps, screens, metadata, hash, singleStepFallbackId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishedWorkflow)) {
            return false;
        }
        PublishedWorkflow publishedWorkflow = (PublishedWorkflow) other;
        return Intrinsics.areEqual(this.id, publishedWorkflow.id) && Intrinsics.areEqual(this.displayName, publishedWorkflow.displayName) && Intrinsics.areEqual(this.initialStepId, publishedWorkflow.initialStepId) && Intrinsics.areEqual(this.steps, publishedWorkflow.steps) && Intrinsics.areEqual(this.screens, publishedWorkflow.screens) && Intrinsics.areEqual(this.metadata, publishedWorkflow.metadata) && Intrinsics.areEqual(this.hash, publishedWorkflow.hash) && Intrinsics.areEqual(this.singleStepFallbackId, publishedWorkflow.singleStepFallbackId);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.initialStepId.hashCode()) * 31) + this.steps.hashCode()) * 31) + this.screens.hashCode()) * 31) + this.metadata.hashCode()) * 31;
        String str = this.hash;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.singleStepFallbackId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PublishedWorkflow(id=" + this.id + ", displayName=" + this.displayName + ", initialStepId=" + this.initialStepId + ", steps=" + this.steps + ", screens=" + this.screens + ", metadata=" + this.metadata + ", hash=" + this.hash + ", singleStepFallbackId=" + this.singleStepFallbackId + ')';
    }

    /* JADX INFO: compiled from: WorkflowModels.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PublishedWorkflow> serializer() {
            return PublishedWorkflow$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PublishedWorkflow(int i, String str, @SerialName(Keys.DISPLAY_NAME) String str2, @SerialName("initial_step_id") String str3, Map map, Map map2, @Serializable(with = JsonObjectToMapSerializer.class) Map map3, String str4, @SerialName("single_step_fallback_id") String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, PublishedWorkflow$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.displayName = str2;
        this.initialStepId = str3;
        this.steps = map;
        this.screens = map2;
        if ((i & 32) == 0) {
            this.metadata = MapsKt.emptyMap();
        } else {
            this.metadata = map3;
        }
        if ((i & 64) == 0) {
            this.hash = null;
        } else {
            this.hash = str4;
        }
        if ((i & 128) == 0) {
            this.singleStepFallbackId = null;
        } else {
            this.singleStepFallbackId = str5;
        }
    }

    public PublishedWorkflow(String id, String displayName, String initialStepId, Map<String, WorkflowStep> steps, Map<String, WorkflowScreen> screens, Map<String, ? extends Object> metadata, String str, String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(initialStepId, "initialStepId");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.id = id;
        this.displayName = displayName;
        this.initialStepId = initialStepId;
        this.steps = steps;
        this.screens = screens;
        this.metadata = metadata;
        this.hash = str;
        this.singleStepFallbackId = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(PublishedWorkflow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.displayName);
        output.encodeStringElement(serialDesc, 2, self.initialStepId);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.steps);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.screens);
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.metadata, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 5, JsonObjectToMapSerializer.INSTANCE, self.metadata);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.hash != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.hash);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.singleStepFallbackId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.singleStepFallbackId);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getInitialStepId() {
        return this.initialStepId;
    }

    public final Map<String, WorkflowStep> getSteps() {
        return this.steps;
    }

    public final Map<String, WorkflowScreen> getScreens() {
        return this.screens;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PublishedWorkflow(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.util.Map r15, java.util.Map r16, java.util.Map r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 32
            if (r1 == 0) goto Lc
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r8 = r1
            goto Le
        Lc:
            r8 = r17
        Le:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L15
            r9 = r2
            goto L17
        L15:
            r9 = r18
        L17:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L24
            r10 = r2
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r2 = r11
            goto L2d
        L24:
            r10 = r19
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
        L2d:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.workflows.PublishedWorkflow.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getSingleStepFallbackId() {
        return this.singleStepFallbackId;
    }

    public final WorkflowExitOffer getDismissExitOffer() {
        WorkflowStep workflowStep;
        String screenId;
        WorkflowScreen workflowScreen;
        ExitOffers exitOffers;
        ExitOffer dismiss;
        String offeringId;
        String str = this.singleStepFallbackId;
        if (str == null || (workflowStep = this.steps.get(str)) == null || (screenId = workflowStep.getScreenId()) == null || (workflowScreen = this.screens.get(screenId)) == null || (exitOffers = workflowScreen.getExitOffers()) == null || (dismiss = exitOffers.getDismiss()) == null || (offeringId = dismiss.getOfferingId()) == null) {
            return null;
        }
        return new WorkflowExitOffer(offeringId, workflowStep.getId());
    }
}
