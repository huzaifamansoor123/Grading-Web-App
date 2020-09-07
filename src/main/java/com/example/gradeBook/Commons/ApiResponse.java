package com.example.gradeBook.Commons;

public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;

    public ApiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static class AuthToken {

        private String token;
        private String username;
        private String userType;
        private  String email;

        public AuthToken(String token, String username, String userType) {
            this.token = token;
            this.username = username;
            this.userType = userType;
        }

        public AuthToken(String token, String username, String userType, String email) {
            this.token = token;
            this.username = username;
            this.userType = userType;
            this.email = email;
        }

        public AuthToken(){

        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public AuthToken(String token){
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
