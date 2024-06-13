package PTR.PTR.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="calendar_diet_plan")
public class CalendarDietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;
    @Column
    private int carbohydrate; //탄
    @Column
    private int protein; //단
    @Column
    private int fat; //지
    @Column
    private String detail; //세부
}
