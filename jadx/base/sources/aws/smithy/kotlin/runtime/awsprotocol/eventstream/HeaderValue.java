package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSource;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.InstantKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: HeaderValue.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\n\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u0082\u0001\t\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "", "<init>", "()V", "encode", "", "dest", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "Bool", "Byte", "Int16", "Int32", "Int64", "ByteArray", "String", "Timestamp", "Uuid", "Companion", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Bool;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Byte;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$ByteArray;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Int16;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Int32;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Int64;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$String;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Timestamp;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Uuid;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class HeaderValue {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ HeaderValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HeaderValue() {
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Bool;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "", "<init>", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Bool extends HeaderValue {
        private final boolean value;

        public static /* synthetic */ Bool copy$default(Bool bool, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = bool.value;
            }
            return bool.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getValue() {
            return this.value;
        }

        public final Bool copy(boolean value) {
            return new Bool(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Bool) && this.value == ((Bool) other).value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "Bool(value=" + this.value + ')';
        }

        public Bool(boolean z) {
            super(null);
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Byte;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "Lkotlin/UByte;", "<init>", "(BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-w2LRezQ", "()B", "B", "component1", "component1-w2LRezQ", "copy", "copy-7apg3OU", "(B)Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Byte;", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Byte extends HeaderValue {
        private final byte value;

        public /* synthetic */ Byte(byte b, DefaultConstructorMarker defaultConstructorMarker) {
            this(b);
        }

        /* JADX INFO: renamed from: copy-7apg3OU$default, reason: not valid java name */
        public static /* synthetic */ Byte m12143copy7apg3OU$default(Byte r0, byte b, int i, Object obj) {
            if ((i & 1) != 0) {
                b = r0.value;
            }
            return r0.m12145copy7apg3OU(b);
        }

        /* JADX INFO: renamed from: component1-w2LRezQ, reason: not valid java name and from getter */
        public final byte getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: copy-7apg3OU, reason: not valid java name */
        public final Byte m12145copy7apg3OU(byte value) {
            return new Byte(value, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Byte) && this.value == ((Byte) other).value;
        }

        public int hashCode() {
            return UByte.m14529hashCodeimpl(this.value);
        }

        public java.lang.String toString() {
            return "Byte(value=" + ((Object) UByte.m14561toStringimpl(this.value)) + ')';
        }

        private Byte(byte b) {
            super(null);
            this.value = b;
        }

        /* JADX INFO: renamed from: getValue-w2LRezQ, reason: not valid java name */
        public final byte m12146getValuew2LRezQ() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Int16;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "", "<init>", "(S)V", "getValue", "()S", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Int16 extends HeaderValue {
        private final short value;

        public static /* synthetic */ Int16 copy$default(Int16 int16, short s, int i, Object obj) {
            if ((i & 1) != 0) {
                s = int16.value;
            }
            return int16.copy(s);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final short getValue() {
            return this.value;
        }

        public final Int16 copy(short value) {
            return new Int16(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Int16) && this.value == ((Int16) other).value;
        }

        public int hashCode() {
            return Short.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "Int16(value=" + ((int) this.value) + ')';
        }

        public Int16(short s) {
            super(null);
            this.value = s;
        }

        public final short getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Int32;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "", "<init>", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Int32 extends HeaderValue {
        private final int value;

        public static /* synthetic */ Int32 copy$default(Int32 int32, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = int32.value;
            }
            return int32.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getValue() {
            return this.value;
        }

        public final Int32 copy(int value) {
            return new Int32(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Int32) && this.value == ((Int32) other).value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "Int32(value=" + this.value + ')';
        }

        public Int32(int i) {
            super(null);
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Int64;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "", "<init>", "(J)V", "getValue", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Int64 extends HeaderValue {
        private final long value;

        public static /* synthetic */ Int64 copy$default(Int64 int64, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = int64.value;
            }
            return int64.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getValue() {
            return this.value;
        }

        public final Int64 copy(long value) {
            return new Int64(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Int64) && this.value == ((Int64) other).value;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "Int64(value=" + this.value + ')';
        }

        public Int64(long j) {
            super(null);
            this.value = j;
        }

        public final long getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0082\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$ByteArray;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "", "<init>", "([B)V", "getValue", "()[B", "equals", "", "other", "", "hashCode", "", "component1", "copy", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ByteArray extends HeaderValue {
        private final byte[] value;

        public static /* synthetic */ ByteArray copy$default(ByteArray byteArray, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = byteArray.value;
            }
            return byteArray.copy(bArr);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getValue() {
            return this.value;
        }

        public final ByteArray copy(byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new ByteArray(value);
        }

        public java.lang.String toString() {
            return "ByteArray(value=" + Arrays.toString(this.value) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ByteArray(byte[] value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final byte[] getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return other != null && getClass() == other.getClass() && Arrays.equals(this.value, ((ByteArray) other).value);
        }

        public int hashCode() {
            return Arrays.hashCode(this.value);
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$String;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class String extends HeaderValue {
        private final java.lang.String value;

        public static /* synthetic */ String copy$default(String string, java.lang.String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = string.value;
            }
            return string.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String getValue() {
            return this.value;
        }

        public final String copy(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new String(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof String) && Intrinsics.areEqual(this.value, ((String) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public java.lang.String toString() {
            return "String(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public String(java.lang.String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final java.lang.String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Timestamp;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "Laws/smithy/kotlin/runtime/time/Instant;", "<init>", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "getValue", "()Laws/smithy/kotlin/runtime/time/Instant;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Timestamp extends HeaderValue {
        private final Instant value;

        public static /* synthetic */ Timestamp copy$default(Timestamp timestamp, Instant instant, int i, Object obj) {
            if ((i & 1) != 0) {
                instant = timestamp.value;
            }
            return timestamp.copy(instant);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Instant getValue() {
            return this.value;
        }

        public final Timestamp copy(Instant value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Timestamp(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Timestamp) && Intrinsics.areEqual(this.value, ((Timestamp) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public java.lang.String toString() {
            return "Timestamp(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Timestamp(Instant value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final Instant getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Uuid;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "value", "Laws/smithy/kotlin/runtime/util/Uuid;", "<init>", "(Laws/smithy/kotlin/runtime/util/Uuid;)V", "getValue", "()Laws/smithy/kotlin/runtime/util/Uuid;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Uuid extends HeaderValue {
        private final aws.smithy.kotlin.runtime.util.Uuid value;

        public static /* synthetic */ Uuid copy$default(Uuid uuid, aws.smithy.kotlin.runtime.util.Uuid uuid2, int i, Object obj) {
            if ((i & 1) != 0) {
                uuid2 = uuid.value;
            }
            return uuid.copy(uuid2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final aws.smithy.kotlin.runtime.util.Uuid getValue() {
            return this.value;
        }

        public final Uuid copy(aws.smithy.kotlin.runtime.util.Uuid value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Uuid(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Uuid) && Intrinsics.areEqual(this.value, ((Uuid) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public java.lang.String toString() {
            return "Uuid(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Uuid(aws.smithy.kotlin.runtime.util.Uuid value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final aws.smithy.kotlin.runtime.util.Uuid getValue() {
            return this.value;
        }
    }

    public final void encode(SdkBufferedSink dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (this instanceof Bool) {
            HeaderValueKt.writeHeader(dest, ((Bool) this).getValue() ? HeaderType.TRUE : HeaderType.FALSE);
            return;
        }
        if (this instanceof Byte) {
            HeaderValueKt.writeHeader(dest, HeaderType.BYTE);
            dest.writeByte(((Byte) this).m12146getValuew2LRezQ());
            return;
        }
        if (this instanceof Int16) {
            HeaderValueKt.writeHeader(dest, HeaderType.INT16);
            dest.writeShort(((Int16) this).getValue());
            return;
        }
        if (this instanceof Int32) {
            HeaderValueKt.writeHeader(dest, HeaderType.INT32);
            dest.writeInt(((Int32) this).getValue());
            return;
        }
        if (this instanceof Int64) {
            HeaderValueKt.writeHeader(dest, HeaderType.INT64);
            dest.writeLong(((Int64) this).getValue());
            return;
        }
        if (this instanceof ByteArray) {
            HeaderValueKt.writeHeader(dest, HeaderType.BYTE_ARRAY);
            ByteArray byteArray = (ByteArray) this;
            int length = byteArray.getValue().length;
            if (length < 0 || length >= 65536) {
                throw new IllegalStateException("HeaderValue ByteArray too long".toString());
            }
            dest.writeShort((short) byteArray.getValue().length);
            SdkBufferedSink.write$default(dest, byteArray.getValue(), 0, 0, 6, null);
            return;
        }
        if (this instanceof String) {
            byte[] bArrEncodeToByteArray = StringsKt.encodeToByteArray(((String) this).getValue());
            int length2 = bArrEncodeToByteArray.length;
            if (length2 >= 0 && length2 < 65536) {
                HeaderValueKt.writeHeader(dest, HeaderType.STRING);
                dest.writeShort((short) bArrEncodeToByteArray.length);
                SdkBufferedSink.write$default(dest, bArrEncodeToByteArray, 0, 0, 6, null);
                return;
            }
            throw new IllegalStateException("HeaderValue String too long".toString());
        }
        if (this instanceof Timestamp) {
            HeaderValueKt.writeHeader(dest, HeaderType.TIMESTAMP);
            dest.writeLong(InstantKt.getEpochMilliseconds(((Timestamp) this).getValue()));
        } else {
            if (this instanceof Uuid) {
                HeaderValueKt.writeHeader(dest, HeaderType.UUID);
                Uuid uuid = (Uuid) this;
                dest.writeLong(uuid.getValue().getHigh());
                dest.writeLong(uuid.getValue().getLow());
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: HeaderValue.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue$Companion;", "", "<init>", "()V", "decode", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", FirebaseAnalytics.Param.SOURCE, "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: HeaderValue.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HeaderType.values().length];
                try {
                    iArr[HeaderType.STRING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[HeaderType.BYTE_ARRAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[HeaderType.TRUE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[HeaderType.FALSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[HeaderType.BYTE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[HeaderType.INT16.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[HeaderType.INT32.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[HeaderType.INT64.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[HeaderType.TIMESTAMP.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[HeaderType.UUID.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HeaderValue decode(SdkBufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            HeaderType headerTypeFromTypeId = HeaderType.INSTANCE.fromTypeId(source.readByte());
            switch (WhenMappings.$EnumSwitchMapping$0[headerTypeFromTypeId.ordinal()]) {
                case 1:
                case 2:
                    short sM14780constructorimpl = UShort.m14780constructorimpl(source.readShort());
                    long j = ((long) sM14780constructorimpl) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                    if (!source.request(j)) {
                        throw new IllegalStateException(("Invalid HeaderValue; type=" + headerTypeFromTypeId + ", len=" + ((Object) UShort.m14824toStringimpl(sM14780constructorimpl)) + "; readRemaining: " + source.getBuffer().getSize()).toString());
                    }
                    byte[] byteArray = source.readByteArray(j);
                    int i = WhenMappings.$EnumSwitchMapping$0[headerTypeFromTypeId.ordinal()];
                    if (i == 1) {
                        return new String(StringsKt.decodeToString(byteArray));
                    }
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new ByteArray(byteArray);
                case 3:
                    return new Bool(true);
                case 4:
                    return new Bool(false);
                case 5:
                    return new Byte(UByte.m14517constructorimpl(source.readByte()), null);
                case 6:
                    return new Int16(source.readShort());
                case 7:
                    return new Int32(source.readInt());
                case 8:
                    return new Int64(source.readLong());
                case 9:
                    return new Timestamp(InstantKt.fromEpochMilliseconds(Instant.INSTANCE, source.readLong()));
                case 10:
                    return new Uuid(new aws.smithy.kotlin.runtime.util.Uuid(source.readLong(), source.readLong()));
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }
}
