package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

/* JADX INFO: loaded from: classes8.dex */
final class AutoValue_Aggregation_Count extends Aggregation.Count {
    public int hashCode() {
        return 1;
    }

    AutoValue_Aggregation_Count() {
    }

    public String toString() {
        return "Count{}";
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Aggregation.Count);
    }
}
