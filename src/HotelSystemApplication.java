


import Util.AppContex;
import Util.Menu;

import java.io.IOException;

public class HotelSystemApplication {
    public static void main(String[] args) throws IOException{
        runApp();
    }
    //--------------------------------------------------------------------











    private static void runApp() {
        Menu.printMainMenu();
        int selection = Menu.selectMainMenu();
        if (selection == 1){                        //add costumer
            AppContex.costumerService.save(AppContex.costumerService.createNewCostumer());
            System.out.println("costumer saved...");
            runApp();
        }else if(selection == 2) {                  // give service to costumer
            AppContex.serviceService.save(AppContex.serviceService.createNewServiceForCostumer());
            System.out.println("service saved...");
            runApp();
        }else {                                     // view costumer's bill
            AppContex.serviceService.viewCostumerBill();
            runApp();
        }
    }
}
