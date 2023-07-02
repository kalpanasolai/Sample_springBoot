package com.device.api.repository;

import com.device.api.modal.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository <Device,String> {
}
