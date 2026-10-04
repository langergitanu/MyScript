package com.survicate.surveys.helpers;

import com.survicate.surveys.infrastructure.network.image.SurvicateImageLoader;
import com.survicate.surveys.presentation.theming.FontProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewDependencies.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/helpers/ViewDependencies;", "", "imageLoader", "Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "getImageLoader", "()Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "fontProvider", "Lcom/survicate/surveys/presentation/theming/FontProvider;", "getFontProvider", "()Lcom/survicate/surveys/presentation/theming/FontProvider;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ViewDependencies {
    FontProvider getFontProvider();

    SurvicateImageLoader getImageLoader();
}
