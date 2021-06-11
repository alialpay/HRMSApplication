package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService<T extends User> {
    DataResult<List<T>>getAll();
    Result add(T t);
    DataResult<User> getByEmail(String email);

}
