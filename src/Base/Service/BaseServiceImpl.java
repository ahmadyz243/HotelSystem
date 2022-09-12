package Base.Service;

import Base.Entity.BaseEntity;
import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;

import java.io.IOException;

public abstract class BaseServiceImpl<T extends BaseEntity, R extends BaseRepository<T>> implements BaseService<T>{
    protected R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }



    public BaseServiceImpl() {
    }


}
