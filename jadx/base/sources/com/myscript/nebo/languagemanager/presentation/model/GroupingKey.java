package com.myscript.nebo.languagemanager.presentation.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: LanguageManagerItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/model/GroupingKey;", "", "installed", "", "suggested", "available", "<init>", "(ZZZ)V", "getInstalled", "()Z", "getSuggested", "getAvailable", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class GroupingKey {
    private final boolean available;
    private final boolean installed;
    private final boolean suggested;

    public static /* synthetic */ GroupingKey copy$default(GroupingKey groupingKey, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = groupingKey.installed;
        }
        if ((i & 2) != 0) {
            z2 = groupingKey.suggested;
        }
        if ((i & 4) != 0) {
            z3 = groupingKey.available;
        }
        return groupingKey.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getInstalled() {
        return this.installed;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuggested() {
        return this.suggested;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAvailable() {
        return this.available;
    }

    public final GroupingKey copy(boolean installed, boolean suggested, boolean available) {
        return new GroupingKey(installed, suggested, available);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupingKey)) {
            return false;
        }
        GroupingKey groupingKey = (GroupingKey) other;
        return this.installed == groupingKey.installed && this.suggested == groupingKey.suggested && this.available == groupingKey.available;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.installed) * 31) + Boolean.hashCode(this.suggested)) * 31) + Boolean.hashCode(this.available);
    }

    public String toString() {
        return "GroupingKey(installed=" + this.installed + ", suggested=" + this.suggested + ", available=" + this.available + ")";
    }

    public GroupingKey(boolean z, boolean z2, boolean z3) {
        this.installed = z;
        this.suggested = z2;
        this.available = z3;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final boolean getInstalled() {
        return this.installed;
    }

    public final boolean getSuggested() {
        return this.suggested;
    }
}
