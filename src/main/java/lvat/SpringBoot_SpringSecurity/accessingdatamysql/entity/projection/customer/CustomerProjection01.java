package lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.projection.customer;

public interface CustomerProjection01 extends CustomerProjection {
    String getCustomerName();

    String getContactFirstName();

    String getContactLastName();
}
