package com.surfingvd.vd.dto;

import java.io.Serializable;
import java.util.List; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter 
public class VdYoutubeDto implements Serializable {

    @ToString
    @Getter
    @Setter
    public static class Req {

        String q;
        String key;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @ToString
    @Getter
    @Setter
    public static class Res {
          
        List<items> items; 
        
        @ToString
        @Getter
        @Setter
        public static class items {
            id id;

            @ToString
            @Getter
            @Setter
            public static class id {
                String videoId;
            }
        } 

    }


    
}
