package com.bignerdranch.expandablerecyclerview.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Parent<C> {
    List<C> getChildList();

    String getKey();

    boolean isInitiallyExpanded();
}
