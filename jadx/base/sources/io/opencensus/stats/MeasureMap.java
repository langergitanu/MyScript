package io.opencensus.stats;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import io.opencensus.internal.Utils;
import io.opencensus.metrics.data.AttachmentValue;
import io.opencensus.stats.Measure;
import io.opencensus.tags.TagContext;

/* JADX INFO: loaded from: classes8.dex */
public abstract class MeasureMap {
    public abstract MeasureMap put(Measure.MeasureDouble measureDouble, double d);

    public abstract MeasureMap put(Measure.MeasureLong measureLong, long j);

    public abstract void record();

    public abstract void record(TagContext tagContext);

    @Deprecated
    public MeasureMap putAttachment(String str, String str2) {
        return putAttachment(str, AttachmentValue.AttachmentValueString.create(str2));
    }

    public MeasureMap putAttachment(String str, AttachmentValue attachmentValue) {
        Utils.checkNotNull(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Utils.checkNotNull(attachmentValue, "value");
        return this;
    }
}
