package com.myapi.testWatcher;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestListener {


    //in order to achieve test listener in rest assured, we use JUnit @rule annotation and use TestRule, TestWatcher interface.
    // the below test lister code should be inside the test base class in our project.

    @Rule
    public TestRule listener= new TestWatcher() {
        @Override
        protected void succeeded(Description description) {

            //super.succeeded(description);
            // we can change code above and just get succesed method name
            System.out.println("*******************************");
            System.out.println(description.getMethodName());
            System.out.println("--------------------------------");

        }

        @Override
        protected void failed(Throwable e, Description description) {
           // super.failed(e, description);
            System.out.println("*******************************");
            System.out.println(description.getMethodName());
            System.out.println("--------------------------------");
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            //super.skipped(e, description);
            System.out.println("*******************************");
            System.out.println(description.getMethodName());
            System.out.println("--------------------------------");
        }

        @Override
        protected void starting(Description description) {
            //super.starting(description);
            System.out.println("*******************************");
            System.out.println(description.getMethodName());
            System.out.println("--------------------------------");
        }

        @Override
        protected void finished(Description description) {
            //super.finished(description);
            System.out.println("*******************************");
            System.out.println(description.getMethodName());
            System.out.println("--------------------------------");
        }
    };
}
