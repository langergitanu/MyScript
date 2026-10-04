package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum MessageIdentifier {
    UNKNOWN_ERROR,
    UNABLE_TO_MIX_LANGUAGE,
    BAD_BLOCK,
    PROCESS_PENDING_OR_REQUIRED,
    SMART_PEN_AUTO_ACTIVATION,
    LIMIT_EXCEEDED,
    ALIGNMENT_GUIDES_DISPLAYED,
    PAGE_ITEM_LIMIT_OK,
    PAGE_ITEM_SOFT_LIMIT_REACHED,
    PAGE_ITEM_HARD_LIMIT_REACHED,
    SNAPPING_ROTATION,
    SNAPPING_ALIGNMENT,
    SNAPPING_RESIZE,
    SNAPPING_CONNECTION,
    SNAPPING_BODY,
    SNAPPING_POINT_OF_INTEREST,
    SNAPPING_LINE_OF_INTEREST,
    SNAPPING_CENTER,
    SNAPPING_CONNECTOR_AXIS,
    SNAPPING_CONNECTOR_ORTHO_AXIS,
    LOCKED_GESTURE_ON_HOLD,
    LOCKED_GESTURE_SCRATCH;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static MessageIdentifier swigToEnum(int i) {
        MessageIdentifier[] messageIdentifierArr = (MessageIdentifier[]) MessageIdentifier.class.getEnumConstants();
        if (i < messageIdentifierArr.length && i >= 0) {
            MessageIdentifier messageIdentifier = messageIdentifierArr[i];
            if (messageIdentifier.swigValue == i) {
                return messageIdentifier;
            }
        }
        for (MessageIdentifier messageIdentifier2 : messageIdentifierArr) {
            if (messageIdentifier2.swigValue == i) {
                return messageIdentifier2;
            }
        }
        throw new IllegalArgumentException("No enum " + MessageIdentifier.class + " with value " + i);
    }

    MessageIdentifier() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    MessageIdentifier(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    MessageIdentifier(MessageIdentifier messageIdentifier) {
        int i = messageIdentifier.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
