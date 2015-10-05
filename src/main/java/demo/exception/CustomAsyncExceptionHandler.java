package demo.exception;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements
		AsyncUncaughtExceptionHandler {
	// handleUncaughtException() invoked when there are any uncaught
	// asynchronous exceptions. (ie. @Async with void return)
	@Override
	public void handleUncaughtException(Throwable throwable, Method method,
			Object... params) {
		System.out.println("Exception message - " + throwable.getMessage());
		System.out.println("Method name - " + method.getName());
		for (Object param : params) {
			System.out.println("Parameter value - " + param);
		}

	}

}