package com.springboot.electronic_approval.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "document_title")
    private String name;

    @Column(nullable = false, name = "document_content")
    private String content;

    @Column
    private String attachment;

    //자동 추가
    @CreationTimestamp
    @Column(nullable = false, name = "draft_date")
    private Timestamp date;

    @Column(nullable = false)
    private String deadline;

    //FK 가지고 있는 쪽이 부모가 되는 듯.
    @ManyToOne
    @JoinColumn(name = "Drafter_id")
    private User Drafter;

    @ManyToOne
    @JoinColumn(name = "Executor_id")
    private User Executor;
}
