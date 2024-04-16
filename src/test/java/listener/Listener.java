package listener;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("----------------------------------------------");
        System.out.println("This test was disabled" + context.getTestMethod()+" with reason" + reason);
//        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("----------------------------------------------");
        System.out.println("This test was succesfull "+context.getTestMethod());
//        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("----------------------------------------------");
        System.out.println("This test was aborted "+cause.getMessage());
//        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("----------------------------------------------");
        System.out.println("This test was failed "+cause.getMessage());
//        TestWatcher.super.testFailed(context, cause);
    }
}
