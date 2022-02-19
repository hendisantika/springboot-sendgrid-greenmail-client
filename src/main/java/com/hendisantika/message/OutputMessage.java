package com.hendisantika.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.24
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer statusCode;
    private String message;

    private List<MessageInfo> errorList;

    private Object object;

}
