package com.revenuecat.purchases.common.networking;

import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RCElement.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RCElement;", "", "checksum", "", "data", "Ljava/nio/ByteBuffer;", "codec", "", "([BLjava/nio/ByteBuffer;I)V", "getChecksum", "()[B", "getCodec", "()I", "getData", "()Ljava/nio/ByteBuffer;", "checksumBase64", "", "decode", "matchesChecksum", "", FirebaseAnalytics.Param.CONTENT, "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RCElement {
    private static final Companion Companion = new Companion(null);
    private static final String SHA_256_ALGORITHM = "SHA-256";
    private final byte[] checksum;
    private final int codec;
    private final ByteBuffer data;

    public RCElement(byte[] checksum, ByteBuffer data, int i) {
        Intrinsics.checkNotNullParameter(checksum, "checksum");
        Intrinsics.checkNotNullParameter(data, "data");
        this.checksum = checksum;
        this.data = data;
        this.codec = i;
    }

    public final byte[] getChecksum() {
        return this.checksum;
    }

    public final ByteBuffer getData() {
        return this.data;
    }

    public /* synthetic */ RCElement(byte[] bArr, ByteBuffer byteBuffer, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, byteBuffer, (i2 & 4) != 0 ? RCContentEncoding.NONE.getId() : i);
    }

    public final int getCodec() {
        return this.codec;
    }

    public final byte[] decode() {
        byte[] bArrDecode = RCContentEncoding.INSTANCE.decode(this.data, this.codec);
        if (matchesChecksum(bArrDecode)) {
            return bArrDecode;
        }
        throw new RCContainerFormatException("RC element checksum verification failed.", null, 2, null);
    }

    private final boolean matchesChecksum(byte[] content) {
        byte[] computed = MessageDigest.getInstance("SHA-256").digest(content);
        Intrinsics.checkNotNullExpressionValue(computed, "computed");
        byte[] bArrCopyOf = Arrays.copyOf(computed, this.checksum.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return Arrays.equals(bArrCopyOf, this.checksum);
    }

    public final String checksumBase64() {
        String strEncodeToString = Base64.encodeToString(this.checksum, 11);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(checksum,…ADDING or Base64.NO_WRAP)");
        return strEncodeToString;
    }

    /* JADX INFO: compiled from: RCElement.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RCElement$Companion;", "", "()V", "SHA_256_ALGORITHM", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
