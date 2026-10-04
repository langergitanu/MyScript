package com.myscript.nebo.p034ui.compose;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.myscript.nebo.migration.ILenovoMigrationController;
import com.myscript.nebo.migration.MigrationProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: LenovoMigrationOnboarding.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/ui/compose/LenovoMigrationOnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "controller", "Lcom/myscript/nebo/migration/ILenovoMigrationController;", "<init>", "(Lcom/myscript/nebo/migration/ILenovoMigrationController;)V", "progress", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/myscript/nebo/migration/MigrationProgress;", "getProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "startMigration", "", "retry", "Factory", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LenovoMigrationOnboardingViewModel extends ViewModel {
    public static final int $stable = 8;
    private final ILenovoMigrationController controller;
    private final StateFlow<MigrationProgress> progress;

    public LenovoMigrationOnboardingViewModel(ILenovoMigrationController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.controller = controller;
        this.progress = controller.getProgress();
    }

    public final StateFlow<MigrationProgress> getProgress() {
        return this.progress;
    }

    public final void startMigration() {
        this.controller.start();
    }

    public final void retry() {
        this.controller.start();
    }

    /* JADX INFO: compiled from: LenovoMigrationOnboarding.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ui/compose/LenovoMigrationOnboardingViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "controller", "Lcom/myscript/nebo/migration/ILenovoMigrationController;", "<init>", "(Lcom/myscript/nebo/migration/ILenovoMigrationController;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Factory implements ViewModelProvider.Factory {
        public static final int $stable = 8;
        private final ILenovoMigrationController controller;

        public Factory(ILenovoMigrationController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.controller = controller;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            return (T) super.create(cls, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
            return (T) super.create(kClass, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new LenovoMigrationOnboardingViewModel(this.controller);
        }
    }
}
