package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"user_id", "event_date"}), @UniqueConstraint(columnNames = {"name", "event_date"})
})

public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Users user;

    @Column(nullable = false)
    private int placesAvailable;

    @Column(name = "name",nullable = false)
    private String eventName;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "stadium",nullable = false)
    private String stadiumName;

    @Column(nullable = false)
    private int maxCapacity;

}
