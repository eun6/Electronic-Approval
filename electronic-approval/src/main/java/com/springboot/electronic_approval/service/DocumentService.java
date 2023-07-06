package com.springboot.electronic_approval.service;

import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentResponse;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentRequest;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentUpdate;

public interface DocumentService {
    DocumentResponse getDocument(int id);
    DocumentResponse saveDocument(DocumentRequest documentRequest);
    DocumentResponse changeDocument(int id, DocumentUpdate documentUpdate) throws Exception;

    void deleteDocument(int id) throws Exception;
}
