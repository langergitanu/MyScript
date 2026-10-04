package com.bignerdranch.expandablerecyclerview.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleParent<C> implements Parent<C> {
    private List<C> mChildList;

    @Override // com.bignerdranch.expandablerecyclerview.model.Parent
    public String getKey() {
        return null;
    }

    @Override // com.bignerdranch.expandablerecyclerview.model.Parent
    public boolean isInitiallyExpanded() {
        return false;
    }

    protected SimpleParent(List<C> list) {
        this.mChildList = list;
    }

    @Override // com.bignerdranch.expandablerecyclerview.model.Parent
    public List<C> getChildList() {
        return this.mChildList;
    }

    public void setChildList(List<C> list) {
        this.mChildList = list;
    }
}
