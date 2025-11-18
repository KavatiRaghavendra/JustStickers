import java.util.List;

import org.springframework.stereotype.Service;

import com.example.juststickers.dto.ContactDto;
@Service
public interface IContactService {
	
	List<ContactDto> getProducts();

}
