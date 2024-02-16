package cosminpetrea.u5w2d5.controllers;


import cosminpetrea.u5w2d5.entities.Device;
import cosminpetrea.u5w2d5.exceptions.BadRequestException;
import cosminpetrea.u5w2d5.payloads.AssignDeviceToEmloyeeDTO;
import cosminpetrea.u5w2d5.payloads.NewDeviceDTO;
import cosminpetrea.u5w2d5.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping
    public Page<Device> getAllDevices(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String orderBy){
        return this.deviceService.getDevices(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public Device findById(@PathVariable UUID id){return this.deviceService.findById(id);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device saveDevice(@RequestBody @Validated NewDeviceDTO payload, BindingResult validation){
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());

        }
        return deviceService.saveDevice(payload);
    }

    @PutMapping("/{id}")
    public Device findByIdAndUpdate(@PathVariable UUID id, @RequestBody NewDeviceDTO updatedDevice){
        return this.deviceService.findByIdAndUpdate(id, updatedDevice );
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        deviceService.findByIdAndDelete(id);
    }

    @PatchMapping("/{deviceId}/assignDevice")
    @ResponseStatus(HttpStatus.OK)
    public Device assignDevice(@PathVariable UUID deviceId, @RequestBody AssignDeviceToEmloyeeDTO employeeId,  BindingResult validation) {
       if (validation.hasErrors()){
           throw new BadRequestException(validation.getAllErrors());
       }

        return deviceService.deviceSetEmployee(deviceId,employeeId);

    }

}
