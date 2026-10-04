package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class Struct {

    /* JADX INFO: renamed from: bb */
    protected ByteBuffer f320bb;
    protected int bb_pos;

    protected void __reset(int i, ByteBuffer byteBuffer) {
        this.f320bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, null);
    }
}
