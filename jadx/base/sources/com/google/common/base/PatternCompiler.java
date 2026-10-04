package com.google.common.base;

/* JADX INFO: loaded from: classes6.dex */
interface PatternCompiler {
    CommonPattern compile(String pattern);

    boolean isPcreLike();
}
