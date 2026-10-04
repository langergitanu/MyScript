package com.myscript.nebo.dms.core;

import com.myscript.nebo.common.utils.NameUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionPropertiesValidator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator;", "", "<init>", "()V", "validate", "Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status;", "requestedName", "", "Status", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CollectionPropertiesValidator {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: CollectionPropertiesValidator.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status;", "", "<init>", "()V", "collectionName", "", "getCollectionName", "()Ljava/lang/String;", "Valid", "Blank", "Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status$Blank;", "Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status$Valid;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Status {
        public static final int $stable = 0;
        private final String collectionName;

        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Status() {
            this.collectionName = "";
        }

        public String getCollectionName() {
            return this.collectionName;
        }

        /* JADX INFO: compiled from: CollectionPropertiesValidator.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status$Valid;", "Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status;", "collectionName", "", "<init>", "(Ljava/lang/String;)V", "getCollectionName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Valid extends Status {
            public static final int $stable = 0;
            private final String collectionName;

            public static /* synthetic */ Valid copy$default(Valid valid, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = valid.collectionName;
                }
                return valid.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getCollectionName() {
                return this.collectionName;
            }

            public final Valid copy(String collectionName) {
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                return new Valid(collectionName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Valid) && Intrinsics.areEqual(this.collectionName, ((Valid) other).collectionName);
            }

            public int hashCode() {
                return this.collectionName.hashCode();
            }

            public String toString() {
                return "Valid(collectionName=" + this.collectionName + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(String collectionName) {
                super(null);
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                this.collectionName = collectionName;
            }

            @Override // com.myscript.nebo.dms.core.CollectionPropertiesValidator.Status
            public String getCollectionName() {
                return this.collectionName;
            }
        }

        /* JADX INFO: compiled from: CollectionPropertiesValidator.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status$Blank;", "Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Blank extends Status {
            public static final int $stable = 0;
            public static final Blank INSTANCE = new Blank();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Blank)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 387684592;
            }

            public String toString() {
                return "Blank";
            }

            private Blank() {
                super(null);
            }
        }
    }

    public final Status validate(String requestedName) {
        Intrinsics.checkNotNullParameter(requestedName, "requestedName");
        String strNormalizeSpaces = NameUtils.normalizeSpaces(requestedName);
        return strNormalizeSpaces.length() == 0 ? Status.Blank.INSTANCE : new Status.Valid(strNormalizeSpaces);
    }
}
