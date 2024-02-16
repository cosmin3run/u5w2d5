package cosminpetrea.u5w2d5.entities;

import cosminpetrea.u5w2d5.enums.DeviceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String type;

    @Column(name = "device_status")
    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Device(String type, DeviceStatus deviceStatus) {
        this.type = type;
        this.deviceStatus = deviceStatus;
    }
}
