package com.survicate.surveys.surveys;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes8.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface QuestionSurveyAnswerType {
    public static final String CSAT = "csat";
    public static final String DATE = "date";
    public static final String MATRIX = "matrix";
    public static final String MULTIPLE = "multiple";
    public static final String NUMERICAL = "numerical_scale";
    public static final String SHAPE = "rating";
    public static final String SINGLE = "single";
    public static final String SMILEY_SCALE = "smiley_scale";
    public static final String TEXT = "text";
}
