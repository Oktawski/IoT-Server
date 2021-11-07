package com.oktawski.iotserver.light;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oktawski.iotserver.superclasses.WifiDevice;
import com.oktawski.iotserver.user.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "lights")
public class Light extends WifiDevice {

    private int red, green, blue, intensity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user = null;

    public Light(String name, String address){
        super(name, address);
    }

    public Light(String name, String address, int red, int green, int blue, int intensity, Boolean on) {
        super(name, address, on);

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.intensity = intensity;
    }
}
