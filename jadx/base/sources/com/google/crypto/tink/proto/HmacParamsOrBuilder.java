package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes6.dex */
public interface HmacParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHash();

    int getHashValue();

    int getTagSize();
}
