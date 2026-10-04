package com.myscript.nebo.videotutorial;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TutorialPagerAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/videotutorial/TutorialPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "mediaPlayerConfigurer", "Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer;", "data", "", "Lcom/myscript/nebo/videotutorial/TutorialData;", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/myscript/nebo/videotutorial/IMediaPlayerConfigurer;[Lcom/myscript/nebo/videotutorial/TutorialData;)V", "[Lcom/myscript/nebo/videotutorial/TutorialData;", "fragments", "Landroid/util/SparseArray;", "Lcom/myscript/nebo/videotutorial/TutorialSlideFragment;", "resetMediaPlayerConfigurer", "", "resetMediaPlayerConfigurer$video_tutorial_release", "getItem", "position", "", "instantiateItem", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "destroyItem", "obj", "", "getCount", "video-tutorial_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TutorialPagerAdapter extends FragmentPagerAdapter {
    private final TutorialData[] data;
    private final SparseArray<TutorialSlideFragment> fragments;
    private IMediaPlayerConfigurer mediaPlayerConfigurer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialPagerAdapter(FragmentManager fragmentManager, IMediaPlayerConfigurer iMediaPlayerConfigurer, TutorialData[] data) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(data, "data");
        this.mediaPlayerConfigurer = iMediaPlayerConfigurer;
        this.data = data;
        this.fragments = new SparseArray<>();
    }

    public final void resetMediaPlayerConfigurer$video_tutorial_release() {
        this.mediaPlayerConfigurer = null;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public TutorialSlideFragment getItem(int position) {
        TutorialData tutorialData = this.data[position];
        TutorialSlideFragment tutorialSlideFragment = this.fragments.get(position);
        return tutorialSlideFragment == null ? TutorialSlideFragment.INSTANCE.newInstance(tutorialData.getVideo(), tutorialData.getTitleStringRes(), tutorialData.getBodyStringRes(), tutorialData.getVideoAspectRatioStringRes()) : tutorialSlideFragment;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public TutorialSlideFragment instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        Object objInstantiateItem = super.instantiateItem(container, position);
        Intrinsics.checkNotNull(objInstantiateItem, "null cannot be cast to non-null type com.myscript.nebo.videotutorial.TutorialSlideFragment");
        TutorialSlideFragment tutorialSlideFragment = (TutorialSlideFragment) objInstantiateItem;
        tutorialSlideFragment.setMediaPlayerConfigurer(this.mediaPlayerConfigurer);
        this.fragments.put(position, tutorialSlideFragment);
        return tutorialSlideFragment;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object obj) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        super.destroyItem(container, position, obj);
        this.fragments.get(position).setMediaPlayerConfigurer(null);
        this.fragments.remove(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.data.length;
    }
}
