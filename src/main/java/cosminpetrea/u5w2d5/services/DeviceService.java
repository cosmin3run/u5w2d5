package cosminpetrea.u5w2d5.services;


import cosminpetrea.u5w2d5.entities.Device;
import cosminpetrea.u5w2d5.entities.Employee;
import cosminpetrea.u5w2d5.enums.DeviceStatus;
import cosminpetrea.u5w2d5.exceptions.NotFoundException;
import cosminpetrea.u5w2d5.payloads.AssignDeviceToEmloyeeDTO;
import cosminpetrea.u5w2d5.payloads.NewDeviceDTO;
import cosminpetrea.u5w2d5.repositories.DeviceDAO;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private EmployeeService employeeService;

    //SAVE DEVICE IN DB
    public Device saveDevice(NewDeviceDTO payload) {
        Device newDevice = new Device();
        newDevice.setType(payload.type());
        newDevice.setDeviceStatus(DeviceStatus.AVAILABLE);
        return deviceDAO.save(newDevice);
    }

    //FIND DEVICE FROM DB BY ID
    public Device findById(UUID id){
        return deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    //SET EMPLOYEE TO DEVICE
    public Device deviceSetEmployee(UUID id, AssignDeviceToEmloyeeDTO employeeId){
        Employee employee = employeeService.findById(employeeId.id());
        Device found = this.findById(id);
        found.setEmployee(employee);
        found.setDeviceStatus(DeviceStatus.ASSIGNED);
        return deviceDAO.save(found);
    }

    //GET ALL DEVICES FROM DB

    public Page<Device> getDevices(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return deviceDAO.findAll(pageable);
    }

    //UPDATE DEVICE IN DB BY ID
    public Device findByIdAndUpdate(UUID id, NewDeviceDTO device) {
        Device found = this.findById(id);
        found.setType(device.type());
        return deviceDAO.save(found);
    }

    //DELETE DEVICE FROM DB
    public void findByIdAndDelete(UUID id) {
        Device found = this.findById(id);
        deviceDAO.delete(found);
    }


}
