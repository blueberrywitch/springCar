package dika.springcars;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "custom.table.sorting")
public class SortConfig {
    private List<String> disabledFields;

    public List<String> getDisabledFields(){return disabledFields;}

    public void setDisabledFields(List<String> disabledFields) {
        this.disabledFields = disabledFields;
    }
}
