package com.myscript.nebo;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.myscript.atk.core.MotionPredictionParams;
import com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactory;

/* JADX INFO: loaded from: classes5.dex */
public class MotionPredictionParamsFactoryImpl implements MotionPredictionParamsFactory {
    private static final String TCL_9425X_MODEL = "9425X";
    private static final String TCL_9445X_MODEL = "9445X";
    private static final String TCL_MANUFACTURER = "TCL";

    @Override // com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactory
    public boolean provideCustomMotionPredictionParams() {
        if (TCL_MANUFACTURER.equalsIgnoreCase(Build.MANUFACTURER)) {
            return TCL_9425X_MODEL.equalsIgnoreCase(Build.MODEL) || TCL_9445X_MODEL.equalsIgnoreCase(Build.MODEL);
        }
        return false;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactory
    public MotionPredictionParams provideMotionPredictionParams(Context context, View view) {
        MotionPredictionParams motionPredictionParams = new MotionPredictionParams();
        motionPredictionParams.setEnabled(true);
        motionPredictionParams.setDurationMs(32L);
        return motionPredictionParams;
    }
}
