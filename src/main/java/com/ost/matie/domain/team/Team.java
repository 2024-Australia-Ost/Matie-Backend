package com.ost.matie.domain.team;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ost.matie.config.LongListConverter;
import com.ost.matie.domain.clear.Clear;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    private LocalDateTime finishDate;

    @Column(name = "point")
    private Long point;

    @Convert(converter = LongListConverter.class)
    private List<Long> userList;

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Clear> clearList;

    public void update(List<Long> userList) {
        this.userList = userList;
    }
}
