package Util;

import Repository.CostumerRepositoryImpl;
import Repository.ServiceRepositoryImpl;
import Service.CostumerService;
import Service.Impl.CostumerServiceImpl;
import Service.Impl.ServiceServiceImpl;
import Service.ServiceService;

public class AppContex {

    public static CostumerService costumerService = new CostumerServiceImpl(new CostumerRepositoryImpl());
    public static ServiceService serviceService = new ServiceServiceImpl(new ServiceRepositoryImpl());
}
