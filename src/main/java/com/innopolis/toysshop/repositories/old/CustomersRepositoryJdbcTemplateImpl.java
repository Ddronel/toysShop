//package com.innopolis.toysshop.repositories;
//
//import com.innopolis.toysshop.models.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//@Component
//public class CustomersRepositoryJdbcTemplateImpl implements CustomersRepository {
//
//    //language=SQL
//    private static final String SQL_INSERT = "insert into customer(first_name, last_name, email, address) values (?, ?, ?, ?)";
//
//    //language=SQL
//    private static final String SQL_SELECT_ALL = "select * from customer order by id";
//
//    //language=SQL
//    private static final String SQL_DELETE_BY_ID = "delete from customer where id = ? ";
//
//    //language=SQL
//    private static final String SQL_SELECT_BY_ID = "select * from customer where id = ?";
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public CustomersRepositoryJdbcTemplateImpl(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    private static final RowMapper<Customer> customerRowMapper = (row, rowNumber) -> {
//        int id = row.getInt("id");
//        String first_name = row.getString("first_name");
//        String last_name = row.getString("last_name");
//        String email = row.getString("email");
//        String address = row.getString("address");
//        return new Customer(id, first_name, last_name, email, address);
//    };
//
//    @Override
//    public List<Customer> findAll() {
//        return jdbcTemplate.query(SQL_SELECT_ALL, customerRowMapper);
//    }
//
//    @Override
//    public void save(Customer customer) {
//        jdbcTemplate.update(SQL_INSERT,
//                customer.getFirst_name(),
//                customer.getLast_name(),
//                customer.getEmail(),
//                customer.getAddress());
//    }
//
//    @Override
//    public void delete(Long customerId) {
//        jdbcTemplate.update(SQL_DELETE_BY_ID, customerId);
//
//    }
//
//    @Override
//    public Customer findById(Long customerId) {
//        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, customerRowMapper, customerId);
//    }
//
//
//}
