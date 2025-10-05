package exceptions;

public class FrameworkExceptions {

    // 🔹 Base Exception
    public static class FrameworkException extends RuntimeException {
        public FrameworkException(String message) { super(message); }
        public FrameworkException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Element Not Found
    public static class ElementNotFoundException extends FrameworkException {
        public ElementNotFoundException(String message)
        { 
        	super(message); 
        }
        public ElementNotFoundException(String message, Throwable cause) 
        { 
        	super(message, cause); 
        }
    }

    // 🔹 Invalid Test Data
    public static class InvalidTestDataException extends FrameworkException {
        public InvalidTestDataException(String message) { super(message); }
        public InvalidTestDataException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Screenshot Capture Failure
    public static class ScreenshotCaptureException extends FrameworkException {
        public ScreenshotCaptureException(String message) { super(message); }
        public ScreenshotCaptureException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Config Load Failure
    public static class InvalidConfigurationException extends FrameworkException {
        public InvalidConfigurationException(String message) { super(message); }
        public InvalidConfigurationException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Timeout / Wait Failure
    public static class TimeoutException extends FrameworkException {
        public TimeoutException(String message) { super(message); }
        public TimeoutException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Click Failure
    public static class ClickFailureException extends FrameworkException {
        public ClickFailureException(String message) { super(message); }
        public ClickFailureException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Text Retrieval Failure
    public static class TextRetrievalException extends FrameworkException {
        public TextRetrievalException(String message) { super(message); }
        public TextRetrievalException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Input Failure
    public static class InputFailureException extends FrameworkException {
        public InputFailureException(String message) { super(message); }
        public InputFailureException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Dropdown Selection Failure
    public static class DropdownSelectionException extends FrameworkException {
        public DropdownSelectionException(String message) { super(message); }
        public DropdownSelectionException(String message, Throwable cause) { super(message, cause); }
    }

    // 🔹 Page Load Failure
    public static class PageLoadException extends FrameworkException {
	        public PageLoadException(String message) { super(message); }
	        public PageLoadException(String message, Throwable cause) { super(message, cause); }
	    }

    // 🔹 Assertion Failure (Optional)
    public static class AssertionFailureException extends FrameworkException {
        public AssertionFailureException(String message) { super(message); }
        public AssertionFailureException(String message, Throwable cause) { super(message, cause); }
    }
}