package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.common.events.FeatureEvent;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.Date;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomPaywallEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0001\u0007¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent;", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "()V", "isPriorityEvent", "", "()Z", "Impression", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class CustomPaywallEvent implements FeatureEvent {
    public /* synthetic */ CustomPaywallEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.revenuecat.purchases.common.events.FeatureEvent
    public boolean isPriorityEvent() {
        return true;
    }

    private CustomPaywallEvent() {
    }

    /* JADX INFO: compiled from: CustomPaywallEvent.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression;", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent;", "creationData", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$CreationData;", "data", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$Data;", "(Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$CreationData;Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$Data;)V", "getCreationData", "()Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$CreationData;", "getData", "()Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$Data;", "CreationData", "Data", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Impression extends CustomPaywallEvent {
        private final CreationData creationData;
        private final Data data;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impression)) {
                return false;
            }
            Impression impression = (Impression) obj;
            return Intrinsics.areEqual(this.creationData, impression.creationData) && Intrinsics.areEqual(this.data, impression.data);
        }

        public int hashCode() {
            return (this.creationData.hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "Impression(creationData=" + this.creationData + ", data=" + this.data + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Impression(CreationData creationData, Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                creationData = new CreationData(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }
            this(creationData, data);
        }

        public final CreationData getCreationData() {
            return this.creationData;
        }

        public final Data getData() {
            return this.data;
        }

        /* JADX INFO: compiled from: CustomPaywallEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$CreationData;", "", "id", "Ljava/util/UUID;", QuestionSurveyAnswerType.DATE, "Ljava/util/Date;", "(Ljava/util/UUID;Ljava/util/Date;)V", "getDate", "()Ljava/util/Date;", "getId", "()Ljava/util/UUID;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class CreationData {
            private final Date date;
            private final UUID id;

            /* JADX WARN: Multi-variable type inference failed */
            public CreationData() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CreationData)) {
                    return false;
                }
                CreationData creationData = (CreationData) obj;
                return Intrinsics.areEqual(this.id, creationData.id) && Intrinsics.areEqual(this.date, creationData.date);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.date.hashCode();
            }

            public String toString() {
                return "CreationData(id=" + this.id + ", date=" + this.date + ')';
            }

            public CreationData(UUID id, Date date) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(date, "date");
                this.id = id;
                this.date = date;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public /* synthetic */ CreationData(UUID uuid, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
                if ((i & 1) != 0) {
                    uuid = UUID.randomUUID();
                    Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID()");
                }
                this(uuid, (i & 2) != 0 ? new Date() : date);
            }

            public final UUID getId() {
                return this.id;
            }

            public final Date getDate() {
                return this.date;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impression(CreationData creationData, Data data) {
            super(null);
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(data, "data");
            this.creationData = creationData;
            this.data = data;
        }

        /* JADX INFO: compiled from: CustomPaywallEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/events/CustomPaywallEvent$Impression$Data;", "", "paywallId", "", "offeringId", "placementIdentifier", "targetingRevision", "", "targetingRuleId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getOfferingId", "()Ljava/lang/String;", "getPaywallId", "getPlacementIdentifier", "getTargetingRevision", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTargetingRuleId", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Data {
            private final String offeringId;
            private final String paywallId;
            private final String placementIdentifier;
            private final Integer targetingRevision;
            private final String targetingRuleId;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Data)) {
                    return false;
                }
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.paywallId, data.paywallId) && Intrinsics.areEqual(this.offeringId, data.offeringId) && Intrinsics.areEqual(this.placementIdentifier, data.placementIdentifier) && Intrinsics.areEqual(this.targetingRevision, data.targetingRevision) && Intrinsics.areEqual(this.targetingRuleId, data.targetingRuleId);
            }

            public int hashCode() {
                String str = this.paywallId;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.offeringId;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.placementIdentifier;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                Integer num = this.targetingRevision;
                int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
                String str4 = this.targetingRuleId;
                return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
            }

            public String toString() {
                return "Data(paywallId=" + this.paywallId + ", offeringId=" + this.offeringId + ", placementIdentifier=" + this.placementIdentifier + ", targetingRevision=" + this.targetingRevision + ", targetingRuleId=" + this.targetingRuleId + ')';
            }

            public Data(String str, String str2, String str3, Integer num, String str4) {
                this.paywallId = str;
                this.offeringId = str2;
                this.placementIdentifier = str3;
                this.targetingRevision = num;
                this.targetingRuleId = str4;
            }

            public /* synthetic */ Data(String str, String str2, String str3, Integer num, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str4);
            }

            public final String getPaywallId() {
                return this.paywallId;
            }

            public final String getOfferingId() {
                return this.offeringId;
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
        }
    }
}
