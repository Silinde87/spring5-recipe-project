package springframework.domain;

import lombok.*;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    private Long id;

}
