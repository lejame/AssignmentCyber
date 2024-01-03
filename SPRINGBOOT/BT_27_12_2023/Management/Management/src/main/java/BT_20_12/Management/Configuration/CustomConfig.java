package BT_20_12.Management.Configuration;

import BT_20_12.Management.Filter.CustomerFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// cấu trình filter, dùng để chặn nhunxwg file khongo muốn người dùng truy chập
@Configuration
public class CustomConfig {
    @Bean
    public FilterRegistrationBean<CustomerFilter> filterconfig() {

        FilterRegistrationBean<CustomerFilter> customerFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        customerFilterFilterRegistrationBean.setFilter(new CustomerFilter());
        customerFilterFilterRegistrationBean.addUrlPatterns("/role","/login");
        return customerFilterFilterRegistrationBean;
    }
}
