package com.device.api.controller;

import com.device.api.repository.DeviceRepository;
import com.device.api.modal.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class DeviceServices
{

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private DeviceRepository deviceRepo;

    @PostMapping(value = "AddDevice",consumes = APPLICATION_JSON_VALUE )
    public String AddDevice(@RequestBody Device objDevice)
    {
        LOG.info("Adding new Devices......");
        deviceRepo.save(objDevice);
        return  "Added device with id "+ objDevice.getDeviceId();
    }

    @GetMapping("GetAllDevices")
    public List<Device> getDevices(){
        return deviceRepo.findAll();
    }

    @GetMapping("FindDeviceById/{deviceId}")
    public Optional<Device> GetDeviceById(@PathVariable String deviceId)
    {
        LOG.info("Getting device details......"+deviceId);
        return deviceRepo.findById(deviceId);
    }

    @DeleteMapping("delete/{deviceId}")
    public  List<Device> DeleteDeviceById(@PathVariable String deviceId)
    {
        deviceRepo.deleteById(deviceId);
        return deviceRepo.findAll();
    }

    @PutMapping("/Update/{deviceId}")
    public String update(@PathVariable String deviceId,@RequestBody Device objDevice)
    {

        if(deviceRepo.findById(deviceId).isPresent())
        {
            System.out.println("found "+deviceId);
            deviceRepo.save(objDevice);
            return "Udated device by id " + objDevice.getDeviceId();
        }
        else {
            return "Device not found " + deviceId;
        }
    }
}
