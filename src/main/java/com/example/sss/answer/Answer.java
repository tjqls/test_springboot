package com.example.sss.answer;

import com.example.sss.question.Question;
import com.example.sss.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    // 답변은 하나의 질문에 여러개가 달릴 수 있는 구조
    //따라서 답변은 Many(많은 것)가 되고 질문은 One(하나)이 된다.
    //@ManyToOne 애너테이션을 설정하면 Answer 엔티티의 question 속성과 Question 엔티티가 서로 연결된다.
    // 실제 데이터베이스에서는 ForeignKey 관계가 생성된다.


    private Question question;
    // question 속성은 답변 엔티티에서 질문 엔티티를 참조하기 위해 추가
    // EX) 답변 객체(예:answer)를 통해 질문 객체의 제목을 알고 싶다면
    // → answer.getQuestion().getSubject()처럼 접근할 수 있다.
    // 하지만 이렇게 속성만 추가하면 안되고 질문 엔티티와 연결된 속성이라는 것을 명시적으로 표시해야 한다.

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}