package com.tuandai.baseproject.dto.qnj;

/**
 * Email 联系方式
 *
 * @author hujunfei
 * @date 2018-12-01 15:22
 */
public class Email {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                '}';
    }
}
