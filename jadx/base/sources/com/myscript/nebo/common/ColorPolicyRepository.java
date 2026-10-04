package com.myscript.nebo.common;

import androidx.lifecycle.LiveData;
import com.myscript.atk.core.IColorInversionPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: ColorPolicyRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/common/ColorPolicyRepository;", "", "colorPolicy", "Landroidx/lifecycle/LiveData;", "Lcom/myscript/atk/core/IColorInversionPolicy;", "getColorPolicy", "()Landroidx/lifecycle/LiveData;", "invertColor", "", "color", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ColorPolicyRepository {
    LiveData<IColorInversionPolicy> getColorPolicy();

    int invertColor(int color);
}
