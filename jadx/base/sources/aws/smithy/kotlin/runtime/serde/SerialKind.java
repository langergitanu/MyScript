package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SdkFieldDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0013\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004\u0082\u0001\u0013\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+¨\u0006,"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind;", "", "<init>", "()V", "toString", "", "Unit", "Integer", "Long", "Double", "String", "Boolean", "Byte", "Char", "Short", "Float", "Enum", "IntEnum", "Map", "List", "Struct", "Timestamp", "Blob", "Document", "BigNumber", "Laws/smithy/kotlin/runtime/serde/SerialKind$BigNumber;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Blob;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Boolean;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Byte;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Char;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Document;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Double;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Enum;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Float;", "Laws/smithy/kotlin/runtime/serde/SerialKind$IntEnum;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Integer;", "Laws/smithy/kotlin/runtime/serde/SerialKind$List;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Long;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Map;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Short;", "Laws/smithy/kotlin/runtime/serde/SerialKind$String;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Struct;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Timestamp;", "Laws/smithy/kotlin/runtime/serde/SerialKind$Unit;", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class SerialKind {
    public /* synthetic */ SerialKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SerialKind() {
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Unit;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Unit extends SerialKind {
        public static final Unit INSTANCE = new Unit();

        private Unit() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Integer;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Integer extends SerialKind {
        public static final Integer INSTANCE = new Integer();

        private Integer() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Long;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Long extends SerialKind {
        public static final Long INSTANCE = new Long();

        private Long() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Double;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Double extends SerialKind {
        public static final Double INSTANCE = new Double();

        private Double() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$String;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class String extends SerialKind {
        public static final String INSTANCE = new String();

        private String() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Boolean;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Boolean extends SerialKind {
        public static final Boolean INSTANCE = new Boolean();

        private Boolean() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Byte;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Byte extends SerialKind {
        public static final Byte INSTANCE = new Byte();

        private Byte() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Char;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Char extends SerialKind {
        public static final Char INSTANCE = new Char();

        private Char() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Short;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Short extends SerialKind {
        public static final Short INSTANCE = new Short();

        private Short() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Float;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Float extends SerialKind {
        public static final Float INSTANCE = new Float();

        private Float() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Enum;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Enum extends SerialKind {
        public static final Enum INSTANCE = new Enum();

        private Enum() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$IntEnum;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class IntEnum extends SerialKind {
        public static final IntEnum INSTANCE = new IntEnum();

        private IntEnum() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Map;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Map extends SerialKind {
        public static final Map INSTANCE = new Map();

        private Map() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$List;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class List extends SerialKind {
        public static final List INSTANCE = new List();

        private List() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Struct;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Struct extends SerialKind {
        public static final Struct INSTANCE = new Struct();

        private Struct() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Timestamp;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Timestamp extends SerialKind {
        public static final Timestamp INSTANCE = new Timestamp();

        private Timestamp() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Blob;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Blob extends SerialKind {
        public static final Blob INSTANCE = new Blob();

        private Blob() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$Document;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Document extends SerialKind {
        public static final Document INSTANCE = new Document();

        private Document() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SdkFieldDescriptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/SerialKind$BigNumber;", "Laws/smithy/kotlin/runtime/serde/SerialKind;", "<init>", "()V", "serde"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BigNumber extends SerialKind {
        public static final BigNumber INSTANCE = new BigNumber();

        private BigNumber() {
            super(null);
        }
    }

    public java.lang.String toString() {
        java.lang.String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        return simpleName == null ? "SerialKind" : simpleName;
    }
}
