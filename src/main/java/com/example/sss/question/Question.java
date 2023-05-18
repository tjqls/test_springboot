package com.example.sss.question;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.sss.answer.Answer;
import com.example.sss.user.SiteUser;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 엔티티로 만들기 위해 Question 클래스에 @Entity 애너테이션을 적용
public class Question {
    @Id // 고유번호 id속성에 적용한 @Id 애너테이션은 id 속성을 기본 키로 지정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue 애너테이션을 적용하면 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장된다
    //strategy는 고유번호를 생성하는 옵션/ GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용한다.
    private Integer id; //(고유Id)

    @Column(length = 200)
    //@Column 엔티티의 속성은 테이블의 컬럼명과 일치하는데 컬럼의 세부설정을 위해 @Column애너테이션을 사용

    private String subject; // (질문 제목)

    @Column(columnDefinition = "TEXT")
    private String content;//(질문 내용)

    private LocalDateTime createDate; // 아마 작성 일자같음


    @OneToMany(mappedBy="question",cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    // Answer 엔티티 객체로 구성된 answerList를 속성을 추가하고 @OneToMany 애너테이션을 설정했다.
    // 이제 질문 객체에서 답변을 참조하려면 question.getAnswerList()를 호출하면 된다.
    //@OneToMany 애너테이션에 사용된 mappedBy는 참조 엔티티의 속성명을 의미한다.
    // 즉, Answer엔티티에서 Question 엔티티를 참조한 속성명 question을 mappedBy에 전달해야 한다.

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}