package Services;

import beans.PoorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodOperationService {

    @Autowired
    UserService userService;
    @Autowired
    GoodService goodService;

    public void buy(int userId,int goodId,float price) throws PoorException {

        float money = userService.getMoney(userId);

        if(price > money)
            throw new PoorException("Your too poor to but this good.");

        userService.setMoney(userId,money - price);
        goodService.setNumber(goodId,goodService.getNumber(goodId) - 1);

    }

}
