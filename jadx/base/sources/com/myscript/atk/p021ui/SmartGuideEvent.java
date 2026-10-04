package com.myscript.atk.p021ui;

/* JADX INFO: compiled from: SmartGuideUtils.java */
/* JADX INFO: loaded from: classes4.dex */
class SmartGuideEvent {
    public int index;
    public SmartGuideButtons type;

    /* JADX INFO: compiled from: SmartGuideUtils.java */
    enum SmartGuideButtons {
        SELECT_NONE,
        SELECT_SHAPE,
        SELECT_TEXT,
        SELECT_DOODLE,
        SELECT_MORE,
        SELECT_TAG
    }

    SmartGuideEvent(SmartGuideButtons smartGuideButtons, int i) {
        this.type = smartGuideButtons;
        this.index = i;
    }

    SmartGuideEvent(SmartGuideButtons smartGuideButtons) {
        this.type = smartGuideButtons;
        this.index = -1;
    }
}
