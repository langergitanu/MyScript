package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.airbnb.lottie.C3843L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
class KeyframeParser {
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static JsonReader.Options NAMES = JsonReader.Options.m512of("t", CmcdData.STREAMING_FORMAT_SS, "e", "o", CmcdData.OBJECT_TYPE_INIT_SEGMENT, CmcdData.STREAMING_FORMAT_HLS, TypedValues.TransitionType.S_TO, "ti");
    static JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.m512of("x", "y");

    KeyframeParser() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = pathInterpolatorCache().get(i);
        }
        return weakReference;
    }

    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i, weakReference);
        }
    }

    static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return parseMultiDimensionalKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolatorInterpolatorFor;
        Interpolator interpolator;
        T t;
        jsonReader.beginObject();
        PointF pointFJsonToPoint = null;
        T t2 = null;
        T t3 = null;
        PointF pointFJsonToPoint2 = null;
        PointF pointFJsonToPoint3 = null;
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFJsonToPoint4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t3 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    t2 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointFJsonToPoint = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 4:
                    pointFJsonToPoint4 = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 5:
                    z = jsonReader.nextInt() == 1;
                    break;
                case 6:
                    pointFJsonToPoint2 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 7:
                    pointFJsonToPoint3 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = LINEAR_INTERPOLATOR;
            t = t3;
        } else {
            if (pointFJsonToPoint != null && pointFJsonToPoint4 != null) {
                interpolatorInterpolatorFor = interpolatorFor(pointFJsonToPoint, pointFJsonToPoint4);
            } else {
                interpolatorInterpolatorFor = LINEAR_INTERPOLATOR;
            }
            interpolator = interpolatorInterpolatorFor;
            t = t2;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t3, t, interpolator, fNextDouble, null);
        keyframe.pathCp1 = pointFJsonToPoint2;
        keyframe.pathCp2 = pointFJsonToPoint3;
        return keyframe;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static <T> Keyframe<T> parseMultiDimensionalKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolatorInterpolatorFor;
        Interpolator interpolatorInterpolatorFor2;
        Interpolator interpolatorInterpolatorFor3;
        T t;
        Interpolator interpolator;
        PointF pointF;
        PointF pointF2;
        Keyframe<T> keyframe;
        PointF pointF3;
        boolean z;
        float f2;
        float f3;
        jsonReader.beginObject();
        boolean z2 = false;
        PointF pointFJsonToPoint = null;
        PointF pointFJsonToPoint2 = null;
        PointF pointF4 = null;
        T t2 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        PointF pointFJsonToPoint3 = null;
        PointF pointFJsonToPoint4 = null;
        float fNextDouble = 0.0f;
        T t3 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t2 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    t3 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    boolean z3 = z2;
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble2 = 0.0f;
                        float fNextDouble3 = 0.0f;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.hasNext()) {
                            int iSelectName = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (iSelectName == 0) {
                                pointF3 = pointF6;
                                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                    fNextDouble2 = fNextDouble4;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble2 = (float) jsonReader.nextDouble();
                                    fNextDouble4 = jsonReader.peek() == JsonReader.Token.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble2;
                                    jsonReader.endArray();
                                }
                            } else if (iSelectName == 1) {
                                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                                    pointF3 = pointF6;
                                    fNextDouble5 = (float) jsonReader.nextDouble();
                                    fNextDouble3 = fNextDouble5;
                                } else {
                                    pointF3 = pointF6;
                                    jsonReader.beginArray();
                                    fNextDouble3 = (float) jsonReader.nextDouble();
                                    fNextDouble5 = jsonReader.peek() == JsonReader.Token.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble3;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                            pointF6 = pointF3;
                        }
                        pointF4 = new PointF(fNextDouble2, fNextDouble3);
                        pointF5 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                    } else {
                        pointFJsonToPoint = JsonUtils.jsonToPoint(jsonReader, f);
                    }
                    z2 = z3;
                    break;
                case 4:
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f4 = 0.0f;
                        float f5 = 0.0f;
                        float fNextDouble6 = 0.0f;
                        float fNextDouble7 = 0.0f;
                        while (jsonReader.hasNext()) {
                            int iSelectName2 = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (iSelectName2 != 0) {
                                z = z2;
                                if (iSelectName2 == 1) {
                                    if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                                        fNextDouble7 = (float) jsonReader.nextDouble();
                                        f5 = fNextDouble7;
                                    } else {
                                        jsonReader.beginArray();
                                        float fNextDouble8 = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                                            f3 = fNextDouble8;
                                            fNextDouble7 = (float) jsonReader.nextDouble();
                                        } else {
                                            f3 = fNextDouble8;
                                            fNextDouble7 = f3;
                                        }
                                        jsonReader.endArray();
                                        f5 = f3;
                                    }
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else {
                                z = z2;
                                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    f4 = fNextDouble6;
                                } else {
                                    jsonReader.beginArray();
                                    float fNextDouble9 = (float) jsonReader.nextDouble();
                                    if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                                        f2 = fNextDouble9;
                                        fNextDouble6 = (float) jsonReader.nextDouble();
                                    } else {
                                        f2 = fNextDouble9;
                                        fNextDouble6 = f2;
                                    }
                                    jsonReader.endArray();
                                    f4 = f2;
                                }
                            }
                            z2 = z;
                        }
                        PointF pointF8 = new PointF(f4, f5);
                        PointF pointF9 = new PointF(fNextDouble6, fNextDouble7);
                        jsonReader.endObject();
                        pointF7 = pointF9;
                        pointF6 = pointF8;
                    } else {
                        pointFJsonToPoint2 = JsonUtils.jsonToPoint(jsonReader, f);
                    }
                    break;
                case 5:
                    z2 = jsonReader.nextInt() == 1;
                    break;
                case 6:
                    pointFJsonToPoint3 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 7:
                    pointFJsonToPoint4 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        boolean z4 = z2;
        PointF pointF10 = pointF6;
        jsonReader.endObject();
        if (z4) {
            interpolator = LINEAR_INTERPOLATOR;
            t = t2;
        } else {
            if (pointFJsonToPoint != null && pointFJsonToPoint2 != null) {
                interpolatorInterpolatorFor = interpolatorFor(pointFJsonToPoint, pointFJsonToPoint2);
            } else {
                if (pointF4 != null && pointF5 != null && pointF10 != null && pointF7 != null) {
                    interpolatorInterpolatorFor2 = interpolatorFor(pointF4, pointF10);
                    interpolatorInterpolatorFor3 = interpolatorFor(pointF5, pointF7);
                    t = t3;
                    interpolator = null;
                    if (interpolatorInterpolatorFor2 == null && interpolatorInterpolatorFor3 != null) {
                        pointF2 = pointFJsonToPoint4;
                        pointF = pointFJsonToPoint3;
                        keyframe = new Keyframe<>(lottieComposition, t2, t, interpolatorInterpolatorFor2, interpolatorInterpolatorFor3, fNextDouble, null);
                    } else {
                        pointF = pointFJsonToPoint3;
                        pointF2 = pointFJsonToPoint4;
                        keyframe = new Keyframe<>(lottieComposition, t2, t, interpolator, fNextDouble, null);
                    }
                    keyframe.pathCp1 = pointF;
                    keyframe.pathCp2 = pointF2;
                    return keyframe;
                }
                interpolatorInterpolatorFor = LINEAR_INTERPOLATOR;
            }
            interpolator = interpolatorInterpolatorFor;
            t = t3;
        }
        interpolatorInterpolatorFor2 = null;
        interpolatorInterpolatorFor3 = null;
        if (interpolatorInterpolatorFor2 == null) {
            pointF = pointFJsonToPoint3;
            pointF2 = pointFJsonToPoint4;
            keyframe = new Keyframe<>(lottieComposition, t2, t, interpolator, fNextDouble, null);
        }
        keyframe.pathCp1 = pointF;
        keyframe.pathCp2 = pointF2;
        return keyframe;
    }

    private static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, MAX_CP_VALUE);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        pointF2.y = MiscUtils.clamp(pointF2.y, -100.0f, MAX_CP_VALUE);
        int iHashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> interpolator = C3843L.getDisablePathInterpolatorCache() ? null : getInterpolator(iHashFor);
        Interpolator interpolator2 = interpolator != null ? interpolator.get() : null;
        if (interpolator != null && interpolator2 != null) {
            return interpolator2;
        }
        try {
            linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e) {
            if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
            } else {
                linearInterpolator = new LinearInterpolator();
            }
        }
        if (!C3843L.getDisablePathInterpolatorCache()) {
            try {
                putInterpolator(iHashFor, new WeakReference(linearInterpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return linearInterpolator;
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f));
    }
}
