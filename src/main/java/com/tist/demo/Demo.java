package com.tist.demo;

import com.tist.annotation.FunctionAnnotation;
import com.tist.annotation.SetValue;
import com.tist.utils.Utils;

/**
 * @author Jack Lin
 */
public class Demo {
    @SetValue
    private String annotatedWithoutValue;
    @SetValue("abc")
    private String annotatedWithValue;

    @FunctionAnnotation
    public void printValue() {
        Utils.inject(this);
        System.out.println("default value = " + annotatedWithoutValue);
        System.out.println("input value = " + annotatedWithValue);
    }

    public String getAnnotatedWithoutValue() {
        return annotatedWithoutValue;
    }

    @FunctionAnnotation
    public String getAnnotatedWithValue() {
        return annotatedWithValue;
    }

    @FunctionAnnotation
    public void countAnnotatedFunctions() {
        System.out.println("annotated function count = " + Utils.countAnnotatedFunctions(getClass()));
    }
}
