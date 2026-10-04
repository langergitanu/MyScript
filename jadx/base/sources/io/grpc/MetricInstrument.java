package io.grpc;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface MetricInstrument {
    String getDescription();

    int getIndex();

    String getName();

    List<String> getOptionalLabelKeys();

    List<String> getRequiredLabelKeys();

    String getUnit();

    boolean isEnableByDefault();
}
