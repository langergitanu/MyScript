package com.pdftron.pdf;

/* JADX INFO: loaded from: classes7.dex */
public interface ProgressMonitor {
    int getPos();

    int getRangeFinish();

    int getRangeStart();

    int offsetPos(int i);

    int setPos(int i);

    void setRange(int i, int i2);

    int setStep(int i);

    int stepIt();
}
