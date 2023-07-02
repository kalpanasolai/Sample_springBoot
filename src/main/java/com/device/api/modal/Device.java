package com.device.api.modal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Device")
public class Device {
    @Id
    private String deviceId ;
    private String osName ;
    private String osVersion ;
    private String deviceType;
}
