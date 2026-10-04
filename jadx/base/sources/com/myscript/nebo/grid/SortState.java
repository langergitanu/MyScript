package com.myscript.nebo.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/grid/SortState;", "", "sorting", "Lcom/myscript/nebo/grid/Sort;", "availableOrderings", "", "Lcom/myscript/nebo/grid/Order;", "order", "isMenuOpen", "", "<init>", "(Lcom/myscript/nebo/grid/Sort;Ljava/util/List;Lcom/myscript/nebo/grid/Order;Z)V", "getSorting", "()Lcom/myscript/nebo/grid/Sort;", "getAvailableOrderings", "()Ljava/util/List;", "getOrder", "()Lcom/myscript/nebo/grid/Order;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SortState {
    public static final int $stable = 8;
    private final List<Order> availableOrderings;
    private final boolean isMenuOpen;
    private final Order order;
    private final Sort sorting;

    public SortState() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SortState copy$default(SortState sortState, Sort sort, List list, Order order, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            sort = sortState.sorting;
        }
        if ((i & 2) != 0) {
            list = sortState.availableOrderings;
        }
        if ((i & 4) != 0) {
            order = sortState.order;
        }
        if ((i & 8) != 0) {
            z = sortState.isMenuOpen;
        }
        return sortState.copy(sort, list, order, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sort getSorting() {
        return this.sorting;
    }

    public final List<Order> component2() {
        return this.availableOrderings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Order getOrder() {
        return this.order;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsMenuOpen() {
        return this.isMenuOpen;
    }

    public final SortState copy(Sort sorting, List<? extends Order> availableOrderings, Order order, boolean isMenuOpen) {
        Intrinsics.checkNotNullParameter(sorting, "sorting");
        Intrinsics.checkNotNullParameter(availableOrderings, "availableOrderings");
        Intrinsics.checkNotNullParameter(order, "order");
        return new SortState(sorting, availableOrderings, order, isMenuOpen);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SortState)) {
            return false;
        }
        SortState sortState = (SortState) other;
        return this.sorting == sortState.sorting && Intrinsics.areEqual(this.availableOrderings, sortState.availableOrderings) && this.order == sortState.order && this.isMenuOpen == sortState.isMenuOpen;
    }

    public int hashCode() {
        return (((((this.sorting.hashCode() * 31) + this.availableOrderings.hashCode()) * 31) + this.order.hashCode()) * 31) + Boolean.hashCode(this.isMenuOpen);
    }

    public String toString() {
        return "SortState(sorting=" + this.sorting + ", availableOrderings=" + this.availableOrderings + ", order=" + this.order + ", isMenuOpen=" + this.isMenuOpen + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SortState(Sort sorting, List<? extends Order> availableOrderings, Order order, boolean z) {
        Intrinsics.checkNotNullParameter(sorting, "sorting");
        Intrinsics.checkNotNullParameter(availableOrderings, "availableOrderings");
        Intrinsics.checkNotNullParameter(order, "order");
        this.sorting = sorting;
        this.availableOrderings = availableOrderings;
        this.order = order;
        this.isMenuOpen = z;
    }

    public /* synthetic */ SortState(Sort sort, EnumEntries<Order> enumEntries, Order order, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Sort.Manual : sort, (i & 2) != 0 ? Order.getEntries() : enumEntries, (i & 4) != 0 ? Order.Ascending : order, (i & 8) != 0 ? false : z);
    }

    public final Sort getSorting() {
        return this.sorting;
    }

    public final List<Order> getAvailableOrderings() {
        return this.availableOrderings;
    }

    public final Order getOrder() {
        return this.order;
    }

    public final boolean isMenuOpen() {
        return this.isMenuOpen;
    }
}
