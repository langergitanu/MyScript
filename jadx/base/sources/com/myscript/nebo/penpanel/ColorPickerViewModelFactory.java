package com.myscript.nebo.penpanel;

import android.content.ComponentCallbacks2;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ColorPickerViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPickerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "color", "", "readOnly", "", "canInvertColor", "<init>", "(IZZ)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorPickerViewModelFactory implements ViewModelProvider.Factory {
    private final boolean canInvertColor;
    private final int color;
    private final boolean readOnly;

    public ColorPickerViewModelFactory(int i, boolean z, boolean z2) {
        this.color = i;
        this.readOnly = z;
        this.canInvertColor = z2;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(Class<T> cls) {
        return (T) super.create(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
        return (T) super.create(kClass, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (modelClass.isAssignableFrom(ColorPickerViewModel.class)) {
            ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(extras);
            Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.common.ColorPolicyRepositoryProvider");
            return new ColorPickerViewModel(this.color, ((ColorPolicyRepositoryProvider) componentCallbacks2RequireApplication).provideColorPolicyRepository(), this.readOnly, this.canInvertColor);
        }
        throw new IllegalArgumentException("Unknown ViewModel " + modelClass);
    }
}
