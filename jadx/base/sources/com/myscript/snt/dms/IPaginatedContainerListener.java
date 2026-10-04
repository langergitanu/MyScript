package com.myscript.snt.dms;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IPaginatedContainerListener {
    void pagePropertiesUpdated(String str);

    void pageSelected(String str, long j, long j2, boolean z);

    void pagesContentUpdated(List<String> list);

    void pagesUpdated();
}
