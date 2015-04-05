package com.os.operando.samplecodeproject;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
public class SampleTest {

    @Test
    public void sample() {
        assertThat(1 + 1, is(2));
    }

    @Test
    public void sample2() {
        TextView textView = new TextView(InstrumentationRegistry.getContext());
        textView.setText("test");
        assertThat(textView.getText().toString(), is("test"));
    }
}