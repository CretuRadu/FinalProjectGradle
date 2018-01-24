package com.example.xayru.finalprojectgradle;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.CountDownLatch;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by xayru on 1/17/2018.
 */
@RunWith(AndroidJUnit4.class)

// Idea on using Latch I found on stack.overflow by user Keerthana S
public class AsyncTest {
    Context context;
    @Test
    public void testVerifyJoke() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    assertTrue(result.length() > 0);
                    latch.countDown();
                }
            }
        };
        testTask.execute(context);
        latch.await();
    }
}