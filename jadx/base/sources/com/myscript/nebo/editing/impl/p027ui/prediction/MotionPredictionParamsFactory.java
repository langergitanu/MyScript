package com.myscript.nebo.editing.impl.p027ui.prediction;

import android.content.Context;
import android.view.View;
import com.myscript.atk.core.MotionPredictionParams;

/* JADX INFO: loaded from: classes7.dex */
public interface MotionPredictionParamsFactory {
    boolean provideCustomMotionPredictionParams();

    MotionPredictionParams provideMotionPredictionParams(Context context, View view);

    default MotionPredictionParams defaultMotionPredictionParams() {
        MotionPredictionParams motionPredictionParams = new MotionPredictionParams();
        motionPredictionParams.setEnabled(true);
        motionPredictionParams.setDurationMs(32L);
        return motionPredictionParams;
    }
}
