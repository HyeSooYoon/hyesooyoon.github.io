package com.surfingvd.vd.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class VdTwitchDto implements Serializable {

    @ToString
    @Getter
    @Setter
    public static class Req {

        String query;
        String user_id;        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @ToString
    @Getter
    @Setter
    public static class Res {
         
        List<data> data;  
        
        @ToString
        @Getter
        @Setter
        public static class data {

            String broadcaster_login;
            String display_name;
            String game_id;
            String id;
            boolean is_live;
            
            String url;            
        } 

    }


    
}
