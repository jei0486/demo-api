package com.demo.api.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Table(name="board")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String subject;
    private String content;

    @Builder.Default
    @Column
    private Integer hits = 0;  //default 0

    @Column(name="ins_id")
    private String createdId;

    @Column(name="mod_id")
    private String modifiedId;

}
