package com.springboot.electronic_approval.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class DocumentDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DocumentRequest {
        private String title;
        private String content;
        private String attachment;
        private String deadline;
        private int drafterId;
        private int executorId;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DocumentResponse {
        private int id;
        private String title;
        private String content;
        private String attachment;
        private Timestamp date;
        private String deadline;
        private int drafterId;
        private int executorId;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DocumentUpdate {
        private String title;
        private String content;
        private String attachment;
        private String deadline;
        private int drafterId;
        private int executorId;
    }
}
