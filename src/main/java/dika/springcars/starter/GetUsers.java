package dika.springcars.starter;

import dika.springbootstarter.IncomeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsers {

    private final IncomeClient incomeClient;
    @Value("${url}")
    private String url;

    @Autowired
    public GetUsers(IncomeClient incomeClient) {
        this.incomeClient = incomeClient;
    }

    public int[] getUsers() {
        int[] salaryies = new int[6];
        List<Object> list = incomeClient.getData(new ParameterizedTypeReference<List<Object>>() {
        }, url);
        for (int i = 0; i < 6; i++) {
            String IdSalary = ((list.get(i).toString()).replaceAll("[a-zA-Zа-яА-Я={}]", ""));
            String[] arr = IdSalary.split(",");
            salaryies[i] = (Integer.parseInt(arr[1].trim()));
        }
        return salaryies;
    }

}
