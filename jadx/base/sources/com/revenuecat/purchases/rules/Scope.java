package com.revenuecat.purchases.rules;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scope.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/Scope;", "", "root", "Lcom/revenuecat/purchases/rules/Value;", "(Lcom/revenuecat/purchases/rules/Value;)V", "current", "bindings", "", "", "(Lcom/revenuecat/purchases/rules/Value;Lcom/revenuecat/purchases/rules/Value;Ljava/util/Map;)V", "getBindings", "()Ljava/util/Map;", "getCurrent", "()Lcom/revenuecat/purchases/rules/Value;", "getRoot", "binding", "names", "scoped", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class Scope {
    private final Map<String, Value> bindings;
    private final Value current;
    private final Value root;

    /* JADX WARN: Multi-variable type inference failed */
    private Scope(Value value, Value value2, Map<String, ? extends Value> map) {
        this.current = value;
        this.root = value2;
        this.bindings = map;
    }

    public final Value getCurrent() {
        return this.current;
    }

    public final Value getRoot() {
        return this.root;
    }

    public final Map<String, Value> getBindings() {
        return this.bindings;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Scope(Value root) {
        this(root, root, MapsKt.emptyMap());
        Intrinsics.checkNotNullParameter(root, "root");
    }

    public final Scope scoped(Value current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return new Scope(current, this.root, this.bindings);
    }

    public final Scope binding(Map<String, ? extends Value> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        return new Scope(this.current, this.root, MapsKt.plus(this.bindings, names));
    }
}
