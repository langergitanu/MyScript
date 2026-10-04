package com.myscript.nebo;

import com.myscript.nebo.editing.HapticFeedbackManager;
import com.myscript.nebo.editing.HapticFeedbackManagerFactory;
import com.myscript.nebo.editing.HapticFeedbackManagerImpl;
import kotlin.Metadata;

/* JADX INFO: compiled from: HapticFeedbackManagerFactoryImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/HapticFeedbackManagerFactoryImpl;", "Lcom/myscript/nebo/editing/HapticFeedbackManagerFactory;", "<init>", "()V", "createHapticFeedbackManager", "Lcom/myscript/nebo/editing/HapticFeedbackManager;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HapticFeedbackManagerFactoryImpl implements HapticFeedbackManagerFactory {
    public static final int $stable = 0;

    @Override // com.myscript.nebo.editing.HapticFeedbackManagerFactory
    public HapticFeedbackManager createHapticFeedbackManager() {
        return new HapticFeedbackManagerImpl();
    }
}
