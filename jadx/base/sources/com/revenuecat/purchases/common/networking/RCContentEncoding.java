package com.revenuecat.purchases.common.networking;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;

/* JADX INFO: compiled from: RCContentEncoding.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RCContentEncoding;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "NONE", "GZIP", "BROTLI", "ZSTD", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum RCContentEncoding {
    NONE(0),
    GZIP(1),
    BROTLI(2),
    ZSTD(3);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int id;

    RCContentEncoding(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }

    /* JADX INFO: compiled from: RCContentEncoding.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\f\u0010\r\u001a\u00020\u0004*\u00020\u0006H\u0002¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RCContentEncoding$Companion;", "", "()V", "decode", "", FirebaseAnalytics.Param.SOURCE, "Ljava/nio/ByteBuffer;", "codecId", "", "fromId", "Lcom/revenuecat/purchases/common/networking/RCContentEncoding;", "id", "gunzip", "toByteArray", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: RCContentEncoding.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RCContentEncoding.values().length];
                try {
                    iArr[RCContentEncoding.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RCContentEncoding.GZIP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RCContentEncoding.BROTLI.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RCContentEncoding.ZSTD.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RCContentEncoding fromId(int id) {
            for (RCContentEncoding rCContentEncoding : RCContentEncoding.values()) {
                if (rCContentEncoding.getId() == id) {
                    return rCContentEncoding;
                }
            }
            return null;
        }

        public final byte[] decode(ByteBuffer source, int codecId) {
            Intrinsics.checkNotNullParameter(source, "source");
            RCContentEncoding rCContentEncodingFromId = fromId(codecId);
            int i = rCContentEncodingFromId == null ? -1 : WhenMappings.$EnumSwitchMapping$0[rCContentEncodingFromId.ordinal()];
            if (i != -1) {
                if (i == 1) {
                    return toByteArray(source);
                }
                if (i == 2) {
                    return gunzip(source);
                }
                if (i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            throw new RCContainerFormatException("Unsupported content encoding id " + codecId + '.', null, 2, null);
        }

        private final byte[] gunzip(ByteBuffer source) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(toByteArray(source)));
                try {
                    byte[] bytes = ByteStreamsKt.readBytes(gZIPInputStream);
                    CloseableKt.closeFinally(gZIPInputStream, null);
                    return bytes;
                } finally {
                }
            } catch (IOException e) {
                throw new RCContainerFormatException("Failed to gzip-decode element.", e);
            }
        }

        private final byte[] toByteArray(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.rewind();
            byte[] bArr = new byte[byteBufferDuplicate.remaining()];
            byteBufferDuplicate.get(bArr);
            return bArr;
        }
    }
}
