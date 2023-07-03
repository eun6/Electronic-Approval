package com.springboot.electronic_approval.data.dto;

import lombok.*;

public class UserDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
   public static class UserRequest {
        private String name;
        private String email;
        private String pw;
        private int teamId;
        private int positionId;

        public String toString() {
            return "name : " + name + ", email : " + email + ", pw : " + pw + ", teamId : " + teamId + ", positionId : " + positionId;
        }
   }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
   public static class UserResponse {
       private int id;
       private String name;
       private String email;
       private String pw;
       private int teamId;
       private int positionId;
   }
}
