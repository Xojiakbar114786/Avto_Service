package brr.uz.avto_service.entity.template;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Data
@MappedSuperclass
//@EntityListeners({AuditingEntityListener.class})
public abstract class AbsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @DiffIgnore
    @CreationTimestamp
//    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    //    @DiffIgnore
    @UpdateTimestamp
//    @Column(nullable = false)
    private Timestamp updatedAt;

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;
}
