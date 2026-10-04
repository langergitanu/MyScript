package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class RectCollection {

    /* JADX INFO: renamed from: a */
    private ArrayList<Rect> f2038a = new ArrayList<>();

    public void addRect(Rect rect) {
        this.f2038a.add(rect);
    }

    public void addRect(double d, double d2, double d3, double d4) throws PDFNetException {
        this.f2038a.add(new Rect(d, d2, d3, d4));
    }

    public Rect getRectAt(int i) {
        return this.f2038a.get(i);
    }

    public int getNumRects() {
        return this.f2038a.size();
    }

    public void clear() {
        this.f2038a.clear();
    }
}
