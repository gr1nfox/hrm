package hu.dev.hrm.model;

import hu.dev.hrm.converter.ChildrenConverter;
import hu.dev.hrm.type.Children;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
public class User {
    private final String username;
    private final String email;
    private final String password;
    @Column(columnDefinition = "json")
    @Convert(converter = ChildrenConverter.class)
    private final Children children;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_time", columnDefinition = "TIMESTAMP")
    @CreationTimestamp(source = SourceType.DB)
    private LocalDateTime createdTime;

    @Column(name = "updated_time", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp(source = SourceType.DB)
    private LocalDateTime updatedTime;
}
