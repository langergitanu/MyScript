package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

/* JADX INFO: loaded from: classes8.dex */
final class AutoValue_Value_ValueSummary extends Value.ValueSummary {
    private final Summary value;

    AutoValue_Value_ValueSummary(Summary summary) {
        if (summary == null) {
            throw new NullPointerException("Null value");
        }
        this.value = summary;
    }

    @Override // io.opencensus.metrics.export.Value.ValueSummary
    Summary getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueSummary{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Value.ValueSummary) {
            return this.value.equals(((Value.ValueSummary) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }
}
