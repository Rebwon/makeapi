package com.rest.api.entity.board;

import com.rest.api.entity.common.CommonDateEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends CommonDateEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false, length = 100)
    private String name;
}
