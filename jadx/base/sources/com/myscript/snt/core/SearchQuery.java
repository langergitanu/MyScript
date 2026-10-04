package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SearchQuery {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SearchQuery(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SearchQuery searchQuery) {
        if (searchQuery == null) {
            return 0L;
        }
        return searchQuery.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_SearchQuery(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SearchQuery(String str) {
        this(NeboEngineJNI.new_SearchQuery__SWIG_0(str.getBytes()), true);
    }

    public SearchQuery(String str, PageKey pageKey) {
        this(NeboEngineJNI.new_SearchQuery__SWIG_1(str.getBytes(), PageKey.getCPtr(pageKey), pageKey), true);
    }

    public String pattern() {
        return new String(NeboEngineJNI.SearchQuery_pattern(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public PageKey pageKey() {
        return new PageKey(NeboEngineJNI.SearchQuery_pageKey(this.swigCPtr, this), true);
    }

    public QueryType type() {
        return QueryType.swigToEnum(NeboEngineJNI.SearchQuery_type(this.swigCPtr, this));
    }

    public static SearchQuery emptyQuery() {
        return new SearchQuery(NeboEngineJNI.SearchQuery_emptyQuery(), true);
    }

    public enum QueryType {
        DOCUMENT(1),
        COLLECTION(2),
        GLOBAL(4),
        PAGE(8);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static QueryType swigToEnum(int i) {
            QueryType[] queryTypeArr = (QueryType[]) QueryType.class.getEnumConstants();
            if (i < queryTypeArr.length && i >= 0) {
                QueryType queryType = queryTypeArr[i];
                if (queryType.swigValue == i) {
                    return queryType;
                }
            }
            for (QueryType queryType2 : queryTypeArr) {
                if (queryType2.swigValue == i) {
                    return queryType2;
                }
            }
            throw new IllegalArgumentException("No enum " + QueryType.class + " with value " + i);
        }

        QueryType() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        QueryType(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        QueryType(QueryType queryType) {
            int i = queryType.swigValue;
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
