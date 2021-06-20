package com.sprayou.spray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    /*
     * no
     * name
     * det
     * addr
     * tel
     * authorityName
     */
    private String no;
    private String name;
    private String det;
    private String addr;
    private String tel;
    private String authorityName;
}