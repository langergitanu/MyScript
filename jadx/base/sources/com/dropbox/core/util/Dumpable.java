package com.dropbox.core.util;

import com.dropbox.core.util.DumpWriter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Dumpable {
    protected abstract void dumpFields(DumpWriter dumpWriter);

    protected String getTypeName() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public final void toString(StringBuilder sb) {
        new DumpWriter.Plain(sb).m524v(this);
    }

    public final String toStringMultiline() {
        StringBuilder sb = new StringBuilder();
        toStringMultiline(sb, 0, true);
        return sb.toString();
    }

    public final void toStringMultiline(StringBuilder sb, int i, boolean z) {
        new DumpWriter.Multiline(sb, 2, i, z).m524v(this);
    }
}
