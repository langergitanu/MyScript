package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import com.survicate.surveys.TextRecallingManager;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c */
    private final int f1039c;

    /* JADX INFO: renamed from: d */
    private final int f1040d;

    /* JADX INFO: renamed from: k0 */
    private final long f1041k0;

    /* JADX INFO: renamed from: k1 */
    private final long f1042k1;

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    SipHashFunction(int c, int d, long k0, long k1) {
        Preconditions.checkArgument(c > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", c);
        Preconditions.checkArgument(d > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", d);
        this.f1039c = c;
        this.f1040d = d;
        this.f1041k0 = k0;
        this.f1042k1 = k1;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f1039c, this.f1040d, this.f1041k0, this.f1042k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f1039c + "" + this.f1040d + "(" + this.f1041k0 + TextRecallingManager.ANSWER_SEPARATOR + this.f1042k1 + ")";
    }

    public boolean equals(Object object) {
        if (object instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) object;
            if (this.f1039c == sipHashFunction.f1039c && this.f1040d == sipHashFunction.f1040d && this.f1041k0 == sipHashFunction.f1041k0 && this.f1042k1 == sipHashFunction.f1042k1) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.f1039c) ^ this.f1040d)) ^ this.f1041k0) ^ this.f1042k1);
    }

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* JADX INFO: renamed from: b */
        private long f1043b;

        /* JADX INFO: renamed from: c */
        private final int f1044c;

        /* JADX INFO: renamed from: d */
        private final int f1045d;
        private long finalM;

        /* JADX INFO: renamed from: v0 */
        private long f1046v0;

        /* JADX INFO: renamed from: v1 */
        private long f1047v1;

        /* JADX INFO: renamed from: v2 */
        private long f1048v2;

        /* JADX INFO: renamed from: v3 */
        private long f1049v3;

        SipHasher(int c, int d, long k0, long k1) {
            super(8);
            this.f1043b = 0L;
            this.finalM = 0L;
            this.f1044c = c;
            this.f1045d = d;
            this.f1046v0 = 8317987319222330741L ^ k0;
            this.f1047v1 = 7237128888997146477L ^ k1;
            this.f1048v2 = 7816392313619706465L ^ k0;
            this.f1049v3 = 8387220255154660723L ^ k1;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer buffer) {
            this.f1043b += 8;
            processM(buffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer buffer) {
            this.f1043b += (long) buffer.remaining();
            int i = 0;
            while (buffer.hasRemaining()) {
                this.finalM ^= (((long) buffer.get()) & 255) << i;
                i += 8;
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            long j = this.finalM ^ (this.f1043b << 56);
            this.finalM = j;
            processM(j);
            this.f1048v2 ^= 255;
            sipRound(this.f1045d);
            return HashCode.fromLong(((this.f1046v0 ^ this.f1047v1) ^ this.f1048v2) ^ this.f1049v3);
        }

        private void processM(long m) {
            this.f1049v3 ^= m;
            sipRound(this.f1044c);
            this.f1046v0 = m ^ this.f1046v0;
        }

        private void sipRound(int iterations) {
            for (int i = 0; i < iterations; i++) {
                long j = this.f1046v0;
                long j2 = this.f1047v1;
                this.f1046v0 = j + j2;
                this.f1048v2 += this.f1049v3;
                this.f1047v1 = Long.rotateLeft(j2, 13);
                long jRotateLeft = Long.rotateLeft(this.f1049v3, 16);
                long j3 = this.f1047v1;
                long j4 = this.f1046v0;
                this.f1047v1 = j3 ^ j4;
                this.f1049v3 = jRotateLeft ^ this.f1048v2;
                long jRotateLeft2 = Long.rotateLeft(j4, 32);
                long j5 = this.f1048v2;
                long j6 = this.f1047v1;
                this.f1048v2 = j5 + j6;
                this.f1046v0 = jRotateLeft2 + this.f1049v3;
                this.f1047v1 = Long.rotateLeft(j6, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f1049v3, 21);
                long j7 = this.f1047v1;
                long j8 = this.f1048v2;
                this.f1047v1 = j7 ^ j8;
                this.f1049v3 = jRotateLeft3 ^ this.f1046v0;
                this.f1048v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}
