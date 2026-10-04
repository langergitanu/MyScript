package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: RCContainer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RCContainer;", "", "version", "", "flags", "config", "", "contentElements", "", "Lcom/revenuecat/purchases/common/networking/RCElement;", "(II[BLjava/util/List;)V", "getConfig", "()[B", "getContentElements", "()Ljava/util/List;", "getFlags", "()I", "getVersion", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RCContainer {
    private static final int ALIGNMENT = 8;
    private static final int BYTE_MASK = 255;
    private static final int CHECKSUM_SIZE = 24;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ELEMENT_HEADER_SIZE = 32;
    private static final int ELEM_RESERVED_SIZE = 4;
    private static final int HEADER_FIXED_SIZE = 8;
    private static final int HEADER_RESERVED_SIZE = 4;
    private static final int HEX_RADIX = 16;
    private static final byte MAGIC_C = 67;
    private static final byte MAGIC_R = 82;
    private static final long RESERVED_UPPER_BITS_MASK = 4294967040L;
    private static final int SUPPORTED_VERSION = 1;
    private static final long UINT32_MASK = 4294967295L;
    private static final int UINT32_SIZE = 4;
    private final byte[] config;
    private final List<RCElement> contentElements;
    private final int flags;
    private final int version;

    public /* synthetic */ RCContainer(int i, int i2, byte[] bArr, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, bArr, list);
    }

    private RCContainer(int i, int i2, byte[] bArr, List<RCElement> list) {
        this.version = i;
        this.flags = i2;
        this.config = bArr;
        this.contentElements = list;
    }

    public final int getVersion() {
        return this.version;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final byte[] getConfig() {
        return this.config;
    }

    public final List<RCElement> getContentElements() {
        return this.contentElements;
    }

    /* JADX INFO: compiled from: RCContainer.kt */
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u0017H\u0002J\f\u0010\u001f\u001a\u00020\u0010*\u00020\u0017H\u0002J\"\u0010 \u001a\u00020\u001b*\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\u001c\u0010%\u001a\u00020\u0017*\u00020\u00172\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RCContainer$Companion;", "", "()V", "ALIGNMENT", "", "BYTE_MASK", "CHECKSUM_SIZE", "ELEMENT_HEADER_SIZE", "ELEM_RESERVED_SIZE", "HEADER_FIXED_SIZE", "HEADER_RESERVED_SIZE", "HEX_RADIX", "MAGIC_C", "", "MAGIC_R", "RESERVED_UPPER_BITS_MASK", "", "SUPPORTED_VERSION", "UINT32_MASK", "UINT32_SIZE", "parse", "Lcom/revenuecat/purchases/common/networking/RCContainer;", "buffer", "Ljava/nio/ByteBuffer;", "bytes", "", "alignTo", "", "alignment", "readAndValidateHeaderMeta", "Lkotlin/Pair;", "readUnsignedInt", "require", "needed", "message", "Lkotlin/Function0;", "", "sliceBytes", "size", "fieldName", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RCContainer parse(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(bytes).asReadOnlyBuffer();
            Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "wrap(bytes).asReadOnlyBuffer()");
            return parse(byteBufferAsReadOnlyBuffer);
        }

        public final RCContainer parse(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            final ByteBuffer source = buffer.slice().asReadOnlyBuffer().order(ByteOrder.LITTLE_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(source, "source");
            require(source, 8, new Function0<String>() { // from class: com.revenuecat.purchases.common.networking.RCContainer$Companion$parse$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Buffer too small for header: need at least 8 bytes, got " + source.remaining() + '.';
                }
            });
            Pair<Integer, Integer> andValidateHeaderMeta = readAndValidateHeaderMeta(source);
            int iIntValue = andValidateHeaderMeta.component1().intValue();
            int iIntValue2 = andValidateHeaderMeta.component2().intValue();
            ArrayList arrayList = new ArrayList();
            while (source.hasRemaining()) {
                require(source, 32, new Function0<String>() { // from class: com.revenuecat.purchases.common.networking.RCContainer$Companion$parse$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Truncated element header: need 32 bytes, got " + source.remaining() + '.';
                    }
                });
                byte[] bArr = new byte[24];
                source.get(bArr);
                long unsignedInt = readUnsignedInt(source);
                long unsignedInt2 = readUnsignedInt(source);
                int i = (int) (255 & unsignedInt2);
                long j = unsignedInt2 & RCContainer.RESERVED_UPPER_BITS_MASK;
                if (j != 0) {
                    LogLevel logLevel = LogLevel.WARN;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        String str = "[Purchases] - " + logLevel.name();
                        StringBuilder sb = new StringBuilder("RC element reserved bits non-zero (0x");
                        String string = Long.toString(j, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        currentLogHandler.mo1545w(str, sb.append(string).append("); ignoring unknown reserved bits.").toString());
                    }
                }
                ByteBuffer byteBufferSliceBytes = sliceBytes(source, unsignedInt, "element");
                alignTo(source, 8);
                arrayList.add(new RCElement(bArr, byteBufferSliceBytes, i));
            }
            if (arrayList.isEmpty()) {
                throw new RCContainerFormatException("Missing config element (element 0).", null, 2, null);
            }
            return new RCContainer(iIntValue, iIntValue2, ((RCElement) CollectionsKt.first((List) arrayList)).decode(), CollectionsKt.drop(arrayList, 1), null);
        }

        private final Pair<Integer, Integer> readAndValidateHeaderMeta(ByteBuffer byteBuffer) {
            if (byteBuffer.get() != 82 || byteBuffer.get() != 67) {
                throw new RCContainerFormatException("Invalid magic bytes. Expected ASCII \"RC\".", null, 2, null);
            }
            int i = byteBuffer.get() & 255;
            if (i != 1) {
                throw new RCContainerFormatException("Unsupported version " + i + ". Expected 1.", null, 2, null);
            }
            int i2 = byteBuffer.get() & 255;
            if (i2 != 0) {
                String string = Integer.toString(i2, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                LogLevel logLevel = LogLevel.WARN;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "RC Container header flags non-zero (0x" + string + "); ignoring unknown flags.");
                }
            }
            byteBuffer.position(byteBuffer.position() + 4);
            return TuplesKt.m1606to(Integer.valueOf(i), Integer.valueOf(i2));
        }

        private final void require(ByteBuffer byteBuffer, int i, Function0<String> function0) {
            if (byteBuffer.remaining() < i) {
                throw new RCContainerFormatException(function0.invoke(), null, 2, null);
            }
        }

        private final long readUnsignedInt(ByteBuffer byteBuffer) {
            return ((long) byteBuffer.getInt()) & RCContainer.UINT32_MASK;
        }

        private final ByteBuffer sliceBytes(ByteBuffer byteBuffer, long j, String str) {
            if (j < 0 || j > byteBuffer.remaining()) {
                throw new RCContainerFormatException("Declared " + str + " size " + j + " exceeds remaining " + byteBuffer.remaining() + " bytes.", null, 2, null);
            }
            int iPosition = byteBuffer.position() + ((int) j);
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.limit(iPosition);
            ByteBuffer view = byteBufferDuplicate.slice().asReadOnlyBuffer();
            byteBuffer.position(iPosition);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return view;
        }

        private final void alignTo(ByteBuffer byteBuffer, int i) {
            int iPosition = byteBuffer.position() % i;
            if (iPosition == 0) {
                return;
            }
            int i2 = i - iPosition;
            if (i2 > byteBuffer.remaining()) {
                byteBuffer.position(byteBuffer.limit());
            } else {
                byteBuffer.position(byteBuffer.position() + i2);
            }
        }
    }
}
