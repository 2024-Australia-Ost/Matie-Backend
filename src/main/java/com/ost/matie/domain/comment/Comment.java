package com.ost.matie.domain.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @JsonIgnore
    @OneToMany(mappedBy = "comment", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Upvote> upvoteList;

    @Builder
    public Comment(String description, Users user, Community community) {
        this.description = description;
        this.user = user;
        this.community = community;
    }

    public void update(String description) {
        this.description = description;
    }
}
