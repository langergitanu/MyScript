package com.pdftron.pdf;

/* JADX INFO: loaded from: classes7.dex */
public class TextSearchResult {
    public static final int e_done = 0;
    public static final int e_found = 2;
    public static final int e_page = 1;
    private String ambient_str;
    private int code;
    Highlights highlights;
    private int page_num;
    private String result_str;

    public TextSearchResult(int i, int i2, String str, String str2, long j) {
        this.code = i;
        this.page_num = i2;
        this.result_str = str;
        this.ambient_str = str2;
        this.highlights = new Highlights(j);
    }

    public int getCode() {
        return this.code;
    }

    public int getPageNum() {
        return this.page_num;
    }

    public String getResultStr() {
        return this.result_str;
    }

    public String getAmbientStr() {
        return this.ambient_str;
    }

    public Highlights getHighlights() {
        return this.highlights;
    }
}
