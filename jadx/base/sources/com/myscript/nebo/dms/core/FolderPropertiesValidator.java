package com.myscript.nebo.dms.core;

import com.myscript.nebo.common.utils.NameUtils;
import com.myscript.snt.core.CollectionKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FolderPropertiesValidator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B!\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0005J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0007R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/FolderPropertiesValidator;", "", "hasFolder", "Lkotlin/Function2;", "Lcom/myscript/snt/core/CollectionKey;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "validate", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "collectionKey", "requestedName", "getUniqueName", "requestedFolderName", "cleanName", "Status", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderPropertiesValidator {
    public static final int $stable = 0;
    private final Function2<CollectionKey, String, Boolean> hasFolder;

    public final String getUniqueName(CollectionKey collectionKey, String requestedFolderName) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(requestedFolderName, "requestedFolderName");
        return getUniqueName$default(this, collectionKey, requestedFolderName, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FolderPropertiesValidator(Function2<? super CollectionKey, ? super String, Boolean> hasFolder) {
        Intrinsics.checkNotNullParameter(hasFolder, "hasFolder");
        this.hasFolder = hasFolder;
    }

    /* JADX INFO: compiled from: FolderPropertiesValidator.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "", "<init>", "()V", "folderName", "", "getFolderName", "()Ljava/lang/String;", "NoCollection", "Valid", "Blank", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status$Blank;", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status$NoCollection;", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status$Valid;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Status {
        public static final int $stable = 0;
        private final String folderName;

        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Status() {
            this.folderName = "";
        }

        public String getFolderName() {
            return this.folderName;
        }

        /* JADX INFO: compiled from: FolderPropertiesValidator.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status$NoCollection;", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class NoCollection extends Status {
            public static final int $stable = 0;
            public static final NoCollection INSTANCE = new NoCollection();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoCollection)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -693995821;
            }

            public String toString() {
                return "NoCollection";
            }

            private NoCollection() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FolderPropertiesValidator.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status$Valid;", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "folderName", "", "<init>", "(Ljava/lang/String;)V", "getFolderName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Valid extends Status {
            public static final int $stable = 0;
            private final String folderName;

            public static /* synthetic */ Valid copy$default(Valid valid, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = valid.folderName;
                }
                return valid.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getFolderName() {
                return this.folderName;
            }

            public final Valid copy(String folderName) {
                Intrinsics.checkNotNullParameter(folderName, "folderName");
                return new Valid(folderName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Valid) && Intrinsics.areEqual(this.folderName, ((Valid) other).folderName);
            }

            public int hashCode() {
                return this.folderName.hashCode();
            }

            public String toString() {
                return "Valid(folderName=" + this.folderName + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(String folderName) {
                super(null);
                Intrinsics.checkNotNullParameter(folderName, "folderName");
                this.folderName = folderName;
            }

            @Override // com.myscript.nebo.dms.core.FolderPropertiesValidator.Status
            public String getFolderName() {
                return this.folderName;
            }
        }

        /* JADX INFO: compiled from: FolderPropertiesValidator.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status$Blank;", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
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
                return -1378724800;
            }

            public String toString() {
                return "Blank";
            }

            private Blank() {
                super(null);
            }
        }
    }

    public final Status validate(CollectionKey collectionKey, String requestedName) {
        Intrinsics.checkNotNullParameter(requestedName, "requestedName");
        String strNormalizeSpaces = NameUtils.normalizeSpaces(requestedName);
        if (collectionKey == null) {
            return Status.NoCollection.INSTANCE;
        }
        return StringsKt.isBlank(strNormalizeSpaces) ? Status.Blank.INSTANCE : new Status.Valid(strNormalizeSpaces);
    }

    public static /* synthetic */ String getUniqueName$default(FolderPropertiesValidator folderPropertiesValidator, CollectionKey collectionKey, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return folderPropertiesValidator.getUniqueName(collectionKey, str, z);
    }

    public final String getUniqueName(CollectionKey collectionKey, String requestedFolderName, boolean cleanName) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(requestedFolderName, "requestedFolderName");
        int i = 0;
        String strCleanName$default = cleanName ? NameUtils.cleanName$default(requestedFolderName, 0, null, 6, null) : requestedFolderName;
        while (this.hasFolder.invoke(collectionKey, strCleanName$default).booleanValue()) {
            i++;
            strCleanName$default = requestedFolderName + " (" + i + ")";
        }
        return strCleanName$default;
    }
}
