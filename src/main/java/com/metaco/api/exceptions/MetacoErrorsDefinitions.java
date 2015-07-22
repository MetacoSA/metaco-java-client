package com.metaco.api.exceptions;

public class MetacoErrorsDefinitions {

    public enum ErrorType {
        InvalidInput("invalid_input"),
        APICallsQuotaExceeded("api_calls_quota_exceeded"),
        SmsSendingFailed("sms_sending_failed"),
        PhoneConfirmationNotFound("phone_confirmation_not_found"),
        InvalidConfirmationCode("invalid_confirmation_code"),
        OrderNotFound("order_not_found"),
        NotEnoughFunds("not_enough_funds"),
        OrderTooSmall("order_too_small"),
        OrderCountLimitExceeded("order_count_limit_exceeded"),
        YearlyTransactionQuotaExceeded("yearly_transaction_quota_exceeded"),
        MaximumTransactionAmountExceeded("maximum_transaction_amount_exceeded"),
        Unauthorized(""),
        NotFound(""),
        ServerError(""),
        UnknownError("");


        public String parameterName;

        ErrorType(String parameterName) {
            this.parameterName = parameterName;
        }

        public String getParameterName() {
            return this.parameterName;
        }

        public static ErrorType fromString(String parameterName) {
            if (parameterName != null) {
                for (ErrorType objType : ErrorType.values()) {
                    if (parameterName.equalsIgnoreCase(objType.parameterName)) {
                        return objType;
                    }
                }
            }
            return null;
        }
    }

    public static ErrorType GetErrorType(MetacoErrorResult result) {
        if (result == null) {
            return ErrorType.UnknownError;
        } else {
            ErrorType type = ErrorType.fromString(result.getMetaco_error());
            if (type == null) {

                String codeStr = String.valueOf(result.getStatus());

                if (result.getStatus() == 404) {
                    type = MetacoErrorsDefinitions.ErrorType.NotFound;
                } else if (result.getStatus() == 401) {
                    type = MetacoErrorsDefinitions.ErrorType.Unauthorized;
                } else if (codeStr.matches("^5[0-9]{2}")) {
                    type = MetacoErrorsDefinitions.ErrorType.ServerError;
                } else {
                    return ErrorType.UnknownError;
                }
            }
            return type;
        }
    }
}
