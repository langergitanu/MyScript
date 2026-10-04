package com.bignerdranch.expandablerecyclerview.model;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ExpandableWrapper<P extends Parent<C>, C> {
    private C mChild;
    private P mParent;
    private List<ExpandableWrapper<P, C>> mWrappedChildList;
    private boolean mWrappedParent = true;
    private boolean mExpanded = false;

    public ExpandableWrapper(P p) {
        this.mParent = p;
        this.mWrappedChildList = generateChildItemList(p);
    }

    public ExpandableWrapper(C c) {
        this.mChild = c;
    }

    public P getParent() {
        return this.mParent;
    }

    public void setParent(P p) {
        this.mParent = p;
        this.mWrappedChildList = generateChildItemList(p);
    }

    public C getChild() {
        return this.mChild;
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public void setExpanded(boolean z) {
        this.mExpanded = z;
    }

    public boolean isParent() {
        return this.mWrappedParent;
    }

    public boolean isParentInitiallyExpanded() {
        if (!this.mWrappedParent) {
            throw new IllegalStateException("Parent not wrapped");
        }
        return this.mParent.isInitiallyExpanded();
    }

    public List<ExpandableWrapper<P, C>> getWrappedChildList() {
        if (!this.mWrappedParent) {
            throw new IllegalStateException("Parent not wrapped");
        }
        return this.mWrappedChildList;
    }

    private List<ExpandableWrapper<P, C>> generateChildItemList(P p) {
        ArrayList arrayList = new ArrayList();
        Iterator<C> it = p.getChildList().iterator();
        while (it.hasNext()) {
            arrayList.add(new ExpandableWrapper(it.next()));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExpandableWrapper expandableWrapper = (ExpandableWrapper) obj;
            P p = this.mParent;
            if (p == null ? expandableWrapper.mParent != null : !p.equals(expandableWrapper.mParent)) {
                return false;
            }
            C c = this.mChild;
            C c2 = expandableWrapper.mChild;
            if (c != null) {
                return c.equals(c2);
            }
            if (c2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        P p = this.mParent;
        int iHashCode = (p != null ? p.hashCode() : 0) * 31;
        C c = this.mChild;
        return iHashCode + (c != null ? c.hashCode() : 0);
    }
}
