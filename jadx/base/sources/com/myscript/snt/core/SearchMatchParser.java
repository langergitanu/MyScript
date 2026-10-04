package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.IntInterval;
import com.myscript.atk.core.Page;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SearchMatchParser {
    public static final char DELIMETER = ';';
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SearchMatchParser(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SearchMatchParser searchMatchParser) {
        if (searchMatchParser == null) {
            return 0L;
        }
        return searchMatchParser.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_SearchMatchParser(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public int getTEXT_SEARCH_HIT_TOKENS_SIZE() {
        return NeboEngineJNI.SearchMatchParser_TEXT_SEARCH_HIT_TOKENS_SIZE_get(this.swigCPtr, this);
    }

    public int getPDF_SEARCH_HIT_TOKENS_SIZE() {
        return NeboEngineJNI.SearchMatchParser_PDF_SEARCH_HIT_TOKENS_SIZE_get(this.swigCPtr, this);
    }

    public SearchMatchParser(String str) {
        this(NeboEngineJNI.new_SearchMatchParser(str.getBytes()), true);
    }

    public String identification() {
        return new String(NeboEngineJNI.SearchMatchParser_identification(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public IntInterval interval() {
        return new IntInterval(NeboEngineJNI.SearchMatchParser_interval(this.swigCPtr, this), true);
    }

    public Extent extent(Page page) {
        return new Extent(NeboEngineJNI.SearchMatchParser_extent(this.swigCPtr, this, Page.getCPtr(page), page), true);
    }

    public boolean hasExtent() {
        return NeboEngineJNI.SearchMatchParser_hasExtent(this.swigCPtr, this);
    }

    public enum SEARCH_HIT_TOKENS {
        IDENTIFICATION(0),
        INTERVAL_INDEX_BEGIN(1),
        INTERVAL_INDEX_END(2),
        EXTENT_RATIO_XMIN(1),
        EXTENT_RATIO_YMIN(2),
        EXTENT_RATIO_XMAX(3),
        EXTENT_RATIO_YMAX(4);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static SEARCH_HIT_TOKENS swigToEnum(int i) {
            SEARCH_HIT_TOKENS[] search_hit_tokensArr = (SEARCH_HIT_TOKENS[]) SEARCH_HIT_TOKENS.class.getEnumConstants();
            if (i < search_hit_tokensArr.length && i >= 0) {
                SEARCH_HIT_TOKENS search_hit_tokens = search_hit_tokensArr[i];
                if (search_hit_tokens.swigValue == i) {
                    return search_hit_tokens;
                }
            }
            for (SEARCH_HIT_TOKENS search_hit_tokens2 : search_hit_tokensArr) {
                if (search_hit_tokens2.swigValue == i) {
                    return search_hit_tokens2;
                }
            }
            throw new IllegalArgumentException("No enum " + SEARCH_HIT_TOKENS.class + " with value " + i);
        }

        SEARCH_HIT_TOKENS() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        SEARCH_HIT_TOKENS(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        SEARCH_HIT_TOKENS(SEARCH_HIT_TOKENS search_hit_tokens) {
            int i = search_hit_tokens.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
