package io.opencensus.tags;

import io.opencensus.tags.propagation.TagPropagationComponent;

/* JADX INFO: loaded from: classes8.dex */
public abstract class TagsComponent {
    public abstract TaggingState getState();

    public abstract TagPropagationComponent getTagPropagationComponent();

    public abstract Tagger getTagger();

    @Deprecated
    public abstract void setState(TaggingState taggingState);
}
