package com.springboot.electronic_approval.service;

import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentResponse;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentResponseList;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentRequest;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentUpdate;

import java.util.List;

public interface DocumentService {
    DocumentResponse getDocument(int id);
    List<DocumentResponseList> getAllDocument();

    DocumentResponse saveDocument(DocumentRequest documentRequest);
    DocumentResponse changeDocument(int id, DocumentUpdate documentUpdate) throws Exception;

    void deleteDocument(int id) throws Exception;
}
