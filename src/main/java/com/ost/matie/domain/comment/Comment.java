package com.ost.matie.domain.comment;

import com.ost.matie.config.LongListConverter;
import com.ost.matie.domain.BaseTimeEntity;
import com.ost.matie.domain.community.Community;
import com.ost.matie.domain.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comments")
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "upvotes")
    private Long upvotes;

    @Convert(converter = LongListConverter.class)
    private List<Long> upvoteUserList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @Builder
    public Comment(String description, Long upvotes, List<Long> upvoteUserList, Users user, Community community) {
        this.description = description;
        this.upvotes = upvotes;
        this.upvoteUserList = upvoteUserList;
        this.user = user;
        this.community = community;
    }

    public void update(String description, Long upvotes, List<Long> upvoteUserList) {
        this.description = description;
        this.upvotes = upvotes;
        this.upvoteUserList = upvoteUserList;
    }
}
