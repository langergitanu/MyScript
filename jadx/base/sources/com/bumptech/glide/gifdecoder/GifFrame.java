package com.bumptech.glide.gifdecoder;

/* JADX INFO: loaded from: classes4.dex */
class GifFrame {
    static final int DISPOSAL_BACKGROUND = 2;
    static final int DISPOSAL_NONE = 1;
    static final int DISPOSAL_PREVIOUS = 3;
    static final int DISPOSAL_UNSPECIFIED = 0;
    int bufferFrameStart;
    int delay;
    int dispose;

    /* JADX INFO: renamed from: ih */
    int f554ih;
    boolean interlace;

    /* JADX INFO: renamed from: iw */
    int f555iw;

    /* JADX INFO: renamed from: ix */
    int f556ix;

    /* JADX INFO: renamed from: iy */
    int f557iy;
    int[] lct;
    int transIndex;
    boolean transparency;

    GifFrame() {
    }
}
