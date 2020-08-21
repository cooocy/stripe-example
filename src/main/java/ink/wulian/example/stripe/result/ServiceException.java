package ink.wulian.example.stripe.result;

public class ServiceException extends RuntimeException {

    private final ResultEnum resultEnum;

    private String exceptionMessage;

    public ServiceException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public ServiceException(ResultEnum resultEnum, String exceptionMessage) {
        this.resultEnum = resultEnum;
        this.exceptionMessage = exceptionMessage;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

}
