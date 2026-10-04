package org.commonmark.internal.inline;

import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ParsedInline {
    public static ParsedInline none() {
        return null;
    }

    protected ParsedInline() {
    }

    /* JADX INFO: renamed from: of */
    public static ParsedInline m1657of(Node node, Position position) {
        if (node == null) {
            throw new NullPointerException("node must not be null");
        }
        if (position == null) {
            throw new NullPointerException("position must not be null");
        }
        return new ParsedInlineImpl(node, position);
    }
}
