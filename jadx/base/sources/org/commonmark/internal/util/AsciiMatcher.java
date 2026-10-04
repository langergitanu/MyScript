package org.commonmark.internal.util;

import java.util.BitSet;

/* JADX INFO: loaded from: classes7.dex */
public class AsciiMatcher implements CharMatcher {
    private final BitSet set;

    private AsciiMatcher(Builder builder) {
        this.set = builder.set;
    }

    @Override // org.commonmark.internal.util.CharMatcher
    public boolean matches(char c) {
        return this.set.get(c);
    }

    public Builder newBuilder() {
        return new Builder((BitSet) this.set.clone());
    }

    public static Builder builder() {
        return new Builder(new BitSet());
    }

    public static class Builder {
        private final BitSet set;

        private Builder(BitSet bitSet) {
            this.set = bitSet;
        }

        /* JADX INFO: renamed from: c */
        public Builder m1659c(char c) {
            if (c > 127) {
                throw new IllegalArgumentException("Can only match ASCII characters");
            }
            this.set.set(c);
            return this;
        }

        public Builder range(char c, char c2) {
            while (c <= c2) {
                m1659c(c);
                c = (char) (c + 1);
            }
            return this;
        }

        public AsciiMatcher build() {
            return new AsciiMatcher(this);
        }
    }
}
