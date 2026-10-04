package com.myscript.nebo.p022ai.presentation.compose;

import kotlin.Metadata;

/* JADX INFO: compiled from: AIContainerViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/UserDataProvider;", "", "hasUser", "", "requiresSignIn", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface UserDataProvider {
    boolean hasUser();

    default boolean requiresSignIn() {
        return true;
    }

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean requiresSignIn(UserDataProvider userDataProvider) {
            return UserDataProvider.super.requiresSignIn();
        }
    }
}
