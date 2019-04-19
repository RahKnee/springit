package com.vega.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
//@Data
//@NoArgsConstructor
@Entity
@RequiredArgsConstructor
@Getter @Setter
@ToString
@NoArgsConstructor
public class Comment extends Auditable{
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String body;

    //link
    @NonNull
    @ManyToOne
    private Link link;

   /* public Comment(@NonNull String body, @NonNull Link link) {
        this.body = body;
        this.link = link;
    }*/
}
