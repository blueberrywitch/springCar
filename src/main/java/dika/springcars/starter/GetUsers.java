package dika.springcars.starter;

import dika.springbootstarter.IncomeClient;
import dika.springcars.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetUsers {

    @Value("${url}")
    private String url;

    private IncomeClient incomeClient;

    @Autowired
    public GetUsers(IncomeClient incomeClient) {
        this.incomeClient = incomeClient;
    }

    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        for (Object object :incomeClient.getData(new ParameterizedTypeReference<List<Object>>() {}, url)){
            String IdSalary = ((object.toString()).replaceAll("[a-zA-Zа-яА-Я={}]", ""));
            String[] arr = IdSalary.split(",");
            list.add(new User(Long.parseLong(arr[0]), Integer.parseInt(arr[1].trim()), null));
        }
        return list;
    }

}
