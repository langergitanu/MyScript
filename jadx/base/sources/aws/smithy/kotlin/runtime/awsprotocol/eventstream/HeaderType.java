package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HeaderValue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderType;", "", "value", "", "<init>", "(Ljava/lang/String;IB)V", "getValue", "()B", "TRUE", "FALSE", "BYTE", "INT16", "INT32", "INT64", "BYTE_ARRAY", "STRING", "TIMESTAMP", "UUID", "Companion", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HeaderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HeaderType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final byte value;
    public static final HeaderType TRUE = new HeaderType("TRUE", 0, (byte) 0);
    public static final HeaderType FALSE = new HeaderType("FALSE", 1, (byte) 1);
    public static final HeaderType BYTE = new HeaderType("BYTE", 2, (byte) 2);
    public static final HeaderType INT16 = new HeaderType("INT16", 3, (byte) 3);
    public static final HeaderType INT32 = new HeaderType("INT32", 4, (byte) 4);
    public static final HeaderType INT64 = new HeaderType("INT64", 5, (byte) 5);
    public static final HeaderType BYTE_ARRAY = new HeaderType("BYTE_ARRAY", 6, (byte) 6);
    public static final HeaderType STRING = new HeaderType("STRING", 7, (byte) 7);
    public static final HeaderType TIMESTAMP = new HeaderType("TIMESTAMP", 8, (byte) 8);
    public static final HeaderType UUID = new HeaderType("UUID", 9, (byte) 9);

    private static final /* synthetic */ HeaderType[] $values() {
        return new HeaderType[]{TRUE, FALSE, BYTE, INT16, INT32, INT64, BYTE_ARRAY, STRING, TIMESTAMP, UUID};
    }

    public static EnumEntries<HeaderType> getEntries() {
        return $ENTRIES;
    }

    public static HeaderType valueOf(String str) {
        return (HeaderType) Enum.valueOf(HeaderType.class, str);
    }

    public static HeaderType[] values() {
        return (HeaderType[]) $VALUES.clone();
    }

    private HeaderType(String str, int i, byte b) {
        this.value = b;
    }

    public final byte getValue() {
        return this.value;
    }

    static {
        HeaderType[] headerTypeArr$values = $values();
        $VALUES = headerTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(headerTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderType$Companion;", "", "<init>", "()V", "fromTypeId", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderType;", "value", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HeaderType fromTypeId(byte value) {
            HeaderType headerType;
            HeaderType[] headerTypeArrValues = HeaderType.values();
            int length = headerTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    headerType = null;
                    break;
                }
                headerType = headerTypeArrValues[i];
                if (headerType.getValue() == value) {
                    break;
                }
                i++;
            }
            if (headerType != null) {
                return headerType;
            }
            throw new IllegalArgumentException(("Unknown HeaderType: " + ((int) value)).toString());
        }
    }
}
