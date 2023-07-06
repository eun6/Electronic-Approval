package com.springboot.electronic_approval.service.impl;

import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentRequest;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentResponse;
import com.springboot.electronic_approval.data.dto.DocumentDto.DocumentUpdate;
import com.springboot.electronic_approval.data.entity.Document;
import com.springboot.electronic_approval.data.entity.User;
import com.springboot.electronic_approval.data.repository.DocumentRepository;
import com.springboot.electronic_approval.data.repository.UserRepository;
import com.springboot.electronic_approval.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DocumentResponse getDocument(int id) {
        LOGGER.info("[get Document] input id : {}", id);
        Document document = documentRepository.findById(id).get();
        LOGGER.info("[get Document] documnet drafter : {}, executor : {}", document.getDrafter(), document.getExecutor());

        DocumentResponse documentResponseDto = DocumentResponse.builder()
                .id(document.getId())
                .title(document.getTitle())
                .content(document.getContent())
                .attachment(document.getAttachment())
                .date(document.getDate())
                .deadline(document.getDeadline())
                .drafterId(document.getDrafter().getId())
                .executorId(document.getExecutor().getId())
                .build();
        return documentResponseDto;
    }

    @Override
    public DocumentResponse saveDocument(DocumentRequest documentRequest) {
        //노예인 drafter, executor 정보 가져오기
        LOGGER.info("[drafter] drafterID : {}", documentRequest.getDrafterId());
        User drafter = userRepository.getById(documentRequest.getDrafterId());
        LOGGER.info("[executor] executorID : {}", documentRequest.getExecutorId());
        User executor = userRepository.getById(documentRequest.getExecutorId());

        //document 객체 생성
        LOGGER.info("[save Document] Document : {}", documentRequest.toString());
        Document document = new Document();
        document.setTitle(documentRequest.getTitle());
        document.setContent(documentRequest.getContent());
        document.setAttachment(documentRequest.getAttachment());
        document.setDeadline(documentRequest.getDeadline());
        document.setDrafter(drafter);
        document.setExecutor(executor);

        //생성한 document 객체 레포지토리에 저장
        Document savedDocument = documentRepository.save(document);
        DocumentResponse documentResponseDto = DocumentResponse.builder()
                .id(savedDocument.getId())
                .title(savedDocument.getTitle())
                .content(savedDocument.getContent())
                .attachment(savedDocument.getAttachment())
                .drafterId(savedDocument.getDrafter().getId())
                .executorId(savedDocument.getExecutor().getId())
                .date(savedDocument.getDate())
                .deadline(savedDocument.getDeadline())
                .build();

        return documentResponseDto;
    }

    //어떤 항목을 수정 가능하게 할지 미정 -> 추후 코드 작성
    @Override
    public DocumentResponse changeDocument(int id, DocumentUpdate documentUpdate) throws Exception {
        //노예 drafter, executor 불러오기
        User drafter = userRepository.getById(documentUpdate.getDrafterId());
        User executor = userRepository.getById(documentUpdate.getExecutorId());
        
        //클라이언트에서 보낸 id와 일치하는 문서 찾기
        Document document = documentRepository.findById(id).get();
        document.setId(id);
        document.setTitle(documentUpdate.getTitle());
        document.setContent(documentUpdate.getContent());
        document.setAttachment(documentUpdate.getAttachment());
        document.setDeadline(documentUpdate.getDeadline());
        document.setDrafter(drafter);
        document.setExecutor(executor);

        Document changedDocument = documentRepository.save(document);
        DocumentResponse documentResponseDto = DocumentResponse.builder()
                .id(changedDocument.getId())
                .title(changedDocument.getTitle())
                .content(changedDocument.getContent())
                .attachment(changedDocument.getAttachment())
                .date(changedDocument.getDate())
                .deadline(changedDocument.getDeadline())
                .drafterId(changedDocument.getDrafter().getId())
                .executorId(changedDocument.getExecutor().getId())
                .build();

        return documentResponseDto;
    }

    @Override
    public void deleteDocument(int id) throws Exception {
        documentRepository.deleteById(id);
    }
}
