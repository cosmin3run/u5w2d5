package cosminpetrea.u5w2d5.services;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import cosminpetrea.u5w2d5.entities.Employee;
import cosminpetrea.u5w2d5.exceptions.BadRequestException;
import cosminpetrea.u5w2d5.exceptions.NotFoundException;
import cosminpetrea.u5w2d5.payloads.NewEmployeeDTO;
import cosminpetrea.u5w2d5.repositories.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {



}
