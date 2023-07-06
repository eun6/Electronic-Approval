package com.springboot.electronic_approval.controller;

import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentRequest;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentResponse;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentResponseList;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentUpdate;
import com.springboot.electronic_approval.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("document")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DocumentResponseList>> getAllDocument() {
        List<DocumentResponseList> documentResponseDto = documentService.getAllDocument();
        return ResponseEntity.status(HttpStatus.OK).body(documentResponseDto);
    }
    @GetMapping("/get")
    public ResponseEntity<DocumentResponse> getDocument(int id) {
        DocumentResponse documentResponseDto = documentService.getDocument(id);
        return ResponseEntity.status(HttpStatus.OK).body(documentResponseDto);
    }
    @PostMapping("/post")
    public ResponseEntity<DocumentResponse> saveDocument( DocumentRequest documentRequest) {
        DocumentResponse documentResponseDto = documentService.saveDocument(documentRequest);
        return ResponseEntity.status(HttpStatus.OK).body(documentResponseDto);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<DocumentResponse> changeDocument(@PathVariable int id, @RequestBody DocumentUpdate documentUpdate) throws Exception {
        DocumentResponse documentResponseDto = documentService.changeDocument(id, documentUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(documentResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDocument(int id) throws Exception {
        documentService.deleteDocument(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상 삭제");
    }
}
