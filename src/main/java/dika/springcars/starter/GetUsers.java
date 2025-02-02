package dika.springcars.starter;

import dika.springbootstarter.IncomeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetUsers {

    private final IncomeClient incomeClient;
    @Value("${url}")
    private String url;

    @Autowired
    public GetUsers(IncomeClient incomeClient) {
        this.incomeClient = incomeClient;
    }

    public int getUsers(Long userId) {
        return incomeClient.getData(url, userId);
    }
}
