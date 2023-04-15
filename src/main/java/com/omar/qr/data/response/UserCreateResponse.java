package com.omar.qr.data.response;

import com.omar.qr.data.entity.User;
import lombok.Data;

@Data
public class UserCreateResponse {

    String response;
    User user;

}
