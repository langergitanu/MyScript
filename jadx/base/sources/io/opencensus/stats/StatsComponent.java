package io.opencensus.stats;

/* JADX INFO: loaded from: classes8.dex */
public abstract class StatsComponent {
    public abstract StatsCollectionState getState();

    public abstract StatsRecorder getStatsRecorder();

    public abstract ViewManager getViewManager();

    @Deprecated
    public abstract void setState(StatsCollectionState statsCollectionState);
}
